package indi.orange1438.managementsystem.util;

import java.text.SimpleDateFormat;

/**
 * 全局ID生成器(身份证生成器)
 * Twitter的snowflake算法
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/15 15:57
 */
public class IdGeneratorUtils {
    // 时间和时间格式要一致
    private String dateStr = "2017-2-1 20:16:40";
    private String dateFormatStr = "yyyy-MM-dd HH:mm:ss";

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long twepoch = 0L;
    private long workerIdBits = 5L; //节点ID长度
    private long datacenterIdBits = 5L; //数据中心ID长度
    private long maxWorkerId = -1L ^ (-1L << workerIdBits); //最大支持机器节点数0~31，一共32个
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits); //最大支持数据中心节点数0~31，一共32个
    private long sequenceBits = 12L; //序列号12位
    private long workerIdShift = sequenceBits; //机器节点左移12位
    private long datacenterIdShift = sequenceBits + workerIdBits; //数据中心节点左移17位
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits; //时间毫秒数左移22位
    private long sequenceMask = -1L ^ (-1L << sequenceBits); //4095
    private long lastTimestamp = -1L;

    private static class IdGenHolder {
        private static final IdGeneratorUtils instance = new IdGeneratorUtils();
    }

    public static IdGeneratorUtils getInstance() {
        return IdGenHolder.instance;
    }

    private IdGeneratorUtils() {
        this(0L, 0L);
    }

    private IdGeneratorUtils(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("workerId不能大于%d或小于0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenterId不能大于%d或小于0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;

        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
        try {
            twepoch = dateFormat.parse(dateStr).getTime();
        } catch (Exception e) {
            twepoch = 0L;
        }

    }

    public synchronized long nextId() {
        long timestamp = timeGen(); //获取当前毫秒数
        //如果服务器时间有问题(时钟后退) 报错。
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("时钟后退,拒绝为%d毫秒生成ID", lastTimestamp - timestamp));
        }

        //如果上次生成时间和当前时间相同,在同一毫秒内
        if (lastTimestamp == timestamp) {
            //sequence自增，因为sequence只有12bit，所以和sequenceMask相与一下，去掉高位
            sequence = (sequence + 1) & sequenceMask;
            //判断是否溢出,也就是每毫秒内超过4095，当为4096时，与sequenceMask相与，sequence就等于0
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp); //自旋等待到下一毫秒
            }
        } else {
            sequence = 0L; //如果和上次生成时间不同,重置sequence，就是下一毫秒开始，sequence计数重新从0开始累加
        }
        lastTimestamp = timestamp;
        // 最后按照规则拼出ID。
        // 000000000000000000000000000000000000000000  00000            00000       000000000000
        //        time                             datacenterId      workerId      sequence
        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift) | sequence;
        // org.apache.commons.lang.time.DateFormatUtils;
        //DateFormatUtils.format(timestamp, "yyyyMMdd-HHmmss-SSS-")
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }
}
