package indi.orange1438.managementsystem.util.helper;

import java.io.*;
import java.math.BigDecimal;

/**
 * 字符串工具类
 * 封装了常用字符串操作的方法
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         data: 2017/02/18 21:40
 */
public final class StringHelper {
    //-----------------------------------
    //该类不能被继承，不能被实例化
    //-------------------------------------

    /**
     * 字符串是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    /**
     * 字符串是否不为空
     *
     * @param s
     * @return
     */
    public static boolean notEmpty(String s) {
        return s != null || s.length() > 0;
    }

    /**
     * 字符串去掉空格后是否为空
     *
     * @param s
     * @return
     */
    public static boolean isTrimEmpty(String s) {
        return s == null || s.length() == 0 || s.trim().length() == 0;
    }

    /**
     * Object 转String
     *
     * @param value
     * @return
     */
    public static String toString(Object value) {
        return (value == null) ? "" : value.toString();
    }

    /**
     * InputStream 转String
     *
     * @param is
     * @return
     */
    public String stream2String(InputStream is) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringWriter sw = new StringWriter();
            int i = -1;
            while ((i = br.read()) != -1) {
                sw.write(i);
            }
            return sw.getBuffer().toString();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    /**
     * String 转InputStream
     *
     * @param str
     * @return
     */
    public InputStream string2Stream(String str) {
        ByteArrayInputStream is = new ByteArrayInputStream(str.getBytes());
        return is;
    }

    /**
     * 根据Unicode编码完美的判断中文汉字和符号
     *
     * @param c
     * @return
     */
    private boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符)
     * Character.isLetter(char c);
     *
     * @param c, 需要判断的字符
     * @return boolean, 返回true,Ascill字符
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param s ,需要得到长度的字符串
     * @return int, 得到的字符串长度
     */
    public static int length(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;  //是单字符加1
            if (!isLetter(c[i])) {
                len++;//是汉字再加1
            }
        }
        return len;
    }

    /**
     * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
     *
     * @param origin, 原始字符串
     * @param len,    截取长度(一个汉字长度按2算的)
     * @return String, 返回的字符串
     */
    public static String substring(String origin, int len) {
        if (origin == null || origin.equals("") || len < 1)
            return ""; //如果原字符串为空则返回;
        byte[] strByte = new byte[len];
        if (len > length(origin)) {
            return origin;
        }
        System.arraycopy(origin.getBytes(), 0, strByte, 0, len);//将要截取的字符串拷贝到新的byte数组中.
        int count = 0;
        for (int i = 0; i < len; i++) {
            int value = strByte[i];
            if (value < 0) { //如是字符为汉字,那么value值将小于0;
                count++;
            }
        }
        if (count % 2 != 0) {
            len = (len == 1) ? ++len : --len;
        }
        return new String(strByte, 0, len);
    }

    /**
     * 判断是否包含中文汉字
     *
     * @param strName
     * @return
     */
    public boolean isChineseHave(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否只有中文汉字
     *
     * @param strName
     * @return
     */
    public boolean isChineseAll(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串中是否是整型数字
     *
     * @param str
     * @return
     */
    public boolean isInt(String str) {
        if (notEmpty(str)) {
            return str.toString().matches("^[-]?\\d+$");
        }
        return false;
    }

    /**
     * 字符串转整型
     *
     * @param str
     * @return
     */
    public int getInt(String str) {
        if (notEmpty(str)) {
            String newValue = str.toString().replaceAll("\\D+", "");
            if (notEmpty(newValue)) {
                return 0;
            }
            return Integer.parseInt(newValue);
        }
        return 0;
    }

    /**
     * 判断字符串中是否是Double
     *
     * @param str
     * @return
     */
    public boolean isDouble(String str) {
        if (notEmpty(str)) {
            return str.toString().matches("^\\d+(\\.[\\d]+)?$");
        }
        return false;
    }

    /**
     * 字符串转Double
     *
     * @param str
     * @return
     */
    public double getDouble(String str) {
        if (notEmpty(str)) {
            if (isDouble(str))
                return Double.parseDouble(str);
            else
                return 0.0D;
        }
        return 0.0D;
    }

    /**
     * 字符串转Double,并进行四舍五入
     *
     * @param str
     * @param scale
     * @return
     */
    public double getDouble(String str, int scale) {
        Double v = getDouble(str);
        return getDouble(v, scale);
    }

    /**
     * Double进行四舍五入
     *
     * @param v
     * @param scale
     * @return
     */
    public double getDouble(Double v, int scale) {
        if (scale < 0) {
            scale = 0;
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 得到指定位数的小数
     *
     * @param v
     * @param scale
     * @return
     */
    public String getDecimals(Double v, int scale) {
        return String.format("%." + String.valueOf(scale) + "f", v);
    }
}
