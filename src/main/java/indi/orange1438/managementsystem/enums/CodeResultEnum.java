package indi.orange1438.managementsystem.enums;

/**
 * code结果枚举
 * 对应 BaseResult
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/04/11 17:09
 */
public enum CodeResultEnum {

    FAIL(2005),

    SUCCESS(2000);

    private int value;

    CodeResultEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
