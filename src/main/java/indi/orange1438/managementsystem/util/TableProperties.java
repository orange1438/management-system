package indi.orange1438.managementsystem.util;

import indi.orange1438.managementsystem.util.helper.DateHelper;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 通用表属性设置
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/28 21:15
 */
public class TableProperties {

    /**
     * 创建属性
     *
     * @param object  类
     * @param creater 创建人
     */
    public static final void createProperties(Object object, String creater) {
        Class<?> clazz = object.getClass();
        try {
            Method method = clazz.getDeclaredMethod("setCreater", String.class);
            method.invoke(object, creater);

            method = clazz.getDeclaredMethod("setCreateTime", Date.class);
            method.invoke(object, DateHelper.getDateTimeNow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改属性
     *
     * @param object   类
     * @param modifier 修改人
     */
    public static final void modifyProperties(Object object, String modifier) {
        Class<?> clazz = object.getClass();
        try {
            Method method = clazz.getDeclaredMethod("setModifier", String.class);
            method.invoke(object, modifier);

            method = clazz.getDeclaredMethod("setModifyTime", Date.class);
            method.invoke(object, DateHelper.getDateTimeNow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
