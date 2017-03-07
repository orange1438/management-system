package indi.orange1438.managementsystem.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;


/**
 * 对象操作工具
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/06 23:07
 */
public class BeanUtils {

    private static final String GET = "get";
    private static final String IS = "is";
    private static final String SET = "set";

    /**
     * 复制属性
     *
     * @param dest 目的地对象
     * @param src  源对象
     */
    public static void copyProperties(Object dest, Object src) {
        String[] srcPropertyNames = getPropertyNames(src);
        String[] destNames = getPropertyNames(dest);
        for (String property : srcPropertyNames) {
            Object value = getValue(src, property);
            if (!(value instanceof Map) && !(value instanceof Collection) && isStringInArray(property, destNames)) {
                setValue(dest, property, value);
            }
        }
    }

    /**
     * 复制属性
     *
     * @param dest 目的地对象
     * @param src  源对象Map
     */
    public static void copyProperties(Object dest, Map<String, Object> src) {
        String[] destNames = getPropertyNames(dest);
        for (String property : src.keySet()) {
            Object value = src.get(property);
            if (!(value instanceof Map) && !(value instanceof Collection) && isStringInArray(property, destNames)) {
                setValue(dest, property, value);
            }
        }
    }

    /**
     * copy属性，把src中的属性复制到dest中,其中忽略ignore中的属性
     *
     * @param dest   目的地对象
     * @param src    源对象
     * @param ignore 要忽略的属性
     */
    public static void copyPropertiesIgnore(Object dest, Object src, String[] ignore) {
        String[] srcPropertyNames = getPropertyNames(src);
        String[] destNames = getPropertyNames(dest);
        for (String property : srcPropertyNames) {
            Object value = getValue(src, property);
            if (!(value instanceof Map) && !(value instanceof Collection) && isStringInArray(property, destNames)) {
                if (!isStringInArray(property, ignore)) {
                    setValue(dest, property, value);
                }
            }
        }
    }

    /**
     * copy属性，把src中的属性复制到dest中,其中只复制include中的属性
     *
     * @param dest    目的地对象
     * @param src     源对象
     * @param include 要复制的属性
     */
    public static void copyProperties(Object dest, Object src, String[] include) {
        String[] srcPropertyNames = getPropertyNames(src);
        String[] destNames = getPropertyNames(dest);
        for (String property : srcPropertyNames) {
            Object value = getValue(src, property);
            if (!(value instanceof Map) && !(value instanceof Collection) && isStringInArray(property, destNames)) {
                if (isStringInArray(property, include)) {
                    setValue(dest, property, value);
                }
            }
        }
    }

    /**
     * copy非空属性，把src中的非空属性复制到dest中,
     *
     * @param dest 目的地对象
     * @param src  源对象
     */
    public static void copyNotNullProperties(Object dest, Object src) {
        if (dest != null && src != null) {
            String[] properties = getPropertyNames(src);
            String[] destNames = getPropertyNames(dest);
            for (String property : properties) {
                Object value = getValue(src, property);
                if (value != null && isStringInArray(property, destNames)) {
                    setValue(dest, property, value);
                }
            }
        }
    }


    /**
     * copy非空属性，把src中的非空属性复制到dest中,
     *
     * @param dest 目的地对象
     * @param src  源对象
     */
    public static void copyPropertiesEmptyString(Object dest, Object src) {
        if (dest != null && src != null) {
            String[] properties = getPropertyNames(src);
            String[] destNames = getPropertyNames(dest);
            for (String property : properties) {
                Object value = getValue(src, property);
                if (value != null && isStringInArray(property, destNames)) {
                    setValue(dest, property, value);
                } else if (value == null && isStringInArray(property, destNames)) {
                    setValue(dest, property, "");
                }
            }
        }
    }

    /**
     * 复制属性, 如果dest中的属性为空, 则将src中的属性复制过去
     *
     * @param dest 目的地对象
     * @param src  源对象
     */
    public static void copyPropertiesIfNull(Object dest, Object src) {
        if (dest != null && src != null) {
            String[] properties = getPropertyNames(src);
            String[] destNames = getPropertyNames(dest);
            for (String property : properties) {
                Object srcValue = getValue(src, property);
                Object destValue = getValue(dest, property);
                if (destValue == null && isStringInArray(property, destNames)) {
                    setValue(dest, property, srcValue);
                }
            }
        }
    }

    /**
     * copy非空属性，把src中的非空属性复制到dest中,其中忽略ignore中的属性
     *
     * @param dest   目的地对象
     * @param src    源对象
     * @param ignore 要忽略的属性
     */
    public static void copyNotNullPropertiesIgnore(Object dest, Object src, String[] ignore) {
        if (dest != null && src != null) {
            String[] properties = getPropertyNames(src);
            String[] destNames = getPropertyNames(dest);
            for (String property : properties) {
                Object value = getValue(src, property);
                if (value != null && isStringInArray(property, destNames) && !isStringInArray(property, ignore)) {
                    setValue(dest, property, value);
                }
            }
        }
    }

    /**
     * 取得一个对象的属性和值, 做成一个Map
     *
     * @param obj        目标对象
     * @param ignoreNull 是否忽略空值属性
     * @return Map, key是属性名, value为属性值
     */
    public static Map<String, Object> getValues(Object obj, boolean ignoreNull) {
        Map<String, Object> values = new HashMap<String, Object>();
        String[] propertyNames = getPropertyNames(obj);
        if (propertyNames != null) {
            for (String property : propertyNames) {
                Object value = getValue(obj, property);
                if (!(ignoreNull && value == null)) {
                    values.put(property, value);
                }
            }
        }
        return values;
    }

    /**
     * Get list of property names of bean.
     *
     * @param obj Object to query for property names.
     * @return Array of property names, or null if an error occurred.
     */
    public static String[] getPropertyNames(Object obj) {
        try {
            BeanInfo info = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] properties = info.getPropertyDescriptors();
            List<String> result = new ArrayList<String>();

            for (PropertyDescriptor property : properties) {
                if (!property.getName().equals("class")) {
                    result.add(property.getName());
                }
            }

            return result.toArray(new String[result.size()]);
        } catch (IntrospectionException e) {
            return new String[0];
        }
    }


    /**
     * Set a single property of the bean.
     *
     * @param object   The object to be manipulated.
     * @param property Name of property to set.
     * @param value    Value to set property to.
     * @return Boolean indicating success.
     */
    public static boolean setValue(Object object, String property, Object value) {
        if ((property == null) || (object == null)) {
            return false;
        }

        // Split out property on dots ( "person.name.first" ->
        // "person","name","first" -> getPerson().getName().getFirst() )
        StringTokenizer st = new StringTokenizer(property, ".");

        if (st.countTokens() == 0) {
            return false;
        }

        // Holder for Object at current depth along chain.
        Object current = object;

        try {
            // Loop through properties in chain.
            for (int i = 0; st.hasMoreTokens(); i++) {
                String currentPropertyName = st.nextToken();

                if (i < st.countTokens()) {
                    // This is a getter
                    current = invokeProperty(current, currentPropertyName);
                } else {
                    // Final property in chain, hence setter
                    try {
                        // Call setter
                        PropertyDescriptor pd = new PropertyDescriptor(currentPropertyName, current.getClass());
                        pd.getWriteMethod().invoke(current, value);

                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            }

            // Return holder Object
            return true;
        } catch (NullPointerException e) {
            // It is very likely that one of the properties returned null. If
            // so, catch the exception and return null.
            return false;
        }
    }

    /**
     * Get a single property of the bean.
     *
     * @param object   The object to be accessed.
     * @param property Name of property to get.
     * @return Value of property. If property was not found, null is returned.
     */
    public static Object getValue(Object object, String property) {
        if ((property == null) || (object == null)) {
            return null;
        }

        // Split out property on dots ( "person.name.first" ->
        // "person","name","first" -> getPerson().getName().getFirst() )
        StringTokenizer st = new StringTokenizer(property, ".");

        if (st.countTokens() == 0) {
            return null;
        }

        // Holder for Object at current depth along chain.
        Object result = object;

        try {
            // Loop through properties in chain.
            while (st.hasMoreTokens()) {
                String currentPropertyName = st.nextToken();

                // Assign to holder the next property in the chain.
                result = invokeProperty(result, currentPropertyName);
            }

            // Return holder Object
            return result;
        } catch (NullPointerException e) {
            // It is very likely that one of the properties returned null. If
            // so, catch the exception and return null.
            return null;
        }
    }

    /**
     * 返回obj对象的property属性的类型
     *
     * @param obj      对象实例
     * @param property 属性名
     * @return 类型
     */

    public static Class getPropertyClass(Object obj, String property) {
        String[] propertyNames = getPropertyNames(obj);
        if (!isStringInArray(property, propertyNames)) {
            return null;
        } else {
            Class cls = obj.getClass();
            try {
                PropertyDescriptor pd = new PropertyDescriptor(property, cls);
                return pd.getPropertyType();
            } catch (IntrospectionException e) {
                return null;
            }
        }
    }

    /**
     * 验证某个类的属性是否被标注为指定的Annotation
     *
     * @param cls          类
     * @param propertyName 属性名
     * @param ann          标注
     * @return false
     */
    public static boolean isPropertyAnnotatedBy(Class cls, String propertyName, Class<? extends Annotation> ann) {
        Annotation[] annotations = getPropertyAnnotations(cls, propertyName);
        for (Annotation annotation : annotations) {
            if (annotation.getClass().equals(ann) || ann.isAssignableFrom(annotation.getClass())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从GET, SET, 和field上查找标注的Annotation
     *
     * @param cls          类
     * @param proeprtyName 属性名
     * @return 所有的Annotation
     */
    public static Annotation[] getPropertyAnnotations(Class cls, String proeprtyName) {
        List<Annotation> list = new ArrayList<Annotation>();

        // 先找Field上定义的Annotation

        Field field = getField(cls, proeprtyName);
        if (field != null) {
            list.addAll(Arrays.asList(field.getDeclaredAnnotations()));
        }

        // 在到get方法上找
        Method getter = getGetMethod(cls, proeprtyName);
        if (getter != null) {
            list.addAll(Arrays.asList(getter.getAnnotations()));
        }

        // 最后到set方法上找
        Method setter = getSetMethod(cls, proeprtyName);
        if (setter != null) {
            list.addAll(Arrays.asList(setter.getAnnotations()));
        }

        return list.toArray(new Annotation[list.size()]);
    }

    /**
     * 得到一个类的某个属性的范型参数类
     *
     * @param targetClass 目标类型
     * @param property    属性
     * @return 范型参数类
     */
    public static Class getGenericType(Class targetClass, String property) {

        try {
            Field field = getField(targetClass, property);
            Type genericType = null;
            // 先检查field类型
            if (field != null) {
                genericType = field.getGenericType();
            }
            // 尝试得到setter方法的参数类型
            if (genericType == null || !(genericType instanceof ParameterizedType)) {
                Method setter = getSetMethod(targetClass, property);
                if (setter != null) {
                    genericType = setter.getGenericParameterTypes()[0];
                }
            }

            // 尝试得到getter方法的返回类型
            if (genericType == null || !(genericType instanceof ParameterizedType)) {
                Method getter = getGetMethod(targetClass, property);
                if (getter != null) {
                    genericType = getter.getGenericReturnType();
                }
            }

            // 如果这个类型是一个有范型参数的类型
            if (genericType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) genericType;
                int index = 0;
                Type resultType = type.getActualTypeArguments()[index];
                if (resultType instanceof ParameterizedType) {
                    return resultType.getClass();
                }
                return (Class) resultType;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取得targetClass的指定属性的Field实例.
     *
     * @param targetClass 目标类
     * @param property    属性
     * @return Field实例, 没有返回null
     */
    public static Field getField(Class targetClass, String property) {
        try {
            return targetClass.getDeclaredField(property);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 取得targetClass的指定属性的get方法.
     *
     * @param targetClass 目标类
     * @param property    属性名
     * @return Get方法, 没有返回null
     */
    public static Method getGetMethod(Class targetClass, String property) {
        try {
            return targetClass.getDeclaredMethod(createMethodName(GET, property));
        } catch (NoSuchMethodException e) {
            try {
                return targetClass.getDeclaredMethod(createMethodName(IS, property));
            } catch (NoSuchMethodException e1) {
                return null;
            }
        }
    }

    /**
     * 取得targetClass的指定属性的set方法.
     *
     * @param targetClass 目标类
     * @param property    属性名
     * @return Set方法, 没有返回null
     */
    public static Method getSetMethod(Class targetClass, String property) {
        Field field = getField(targetClass, property);
        if (field != null) {
            try {
                return targetClass.getDeclaredMethod(createMethodName(SET, property), field.getType());
            } catch (NoSuchMethodException e) {
                return null;
            }
        } else {
            Method[] methods = targetClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(createMethodName(SET, property))) {
                    return method;
                }
            }
            return null;
        }

    }

    /**
     * 判断str是否在strArray中
     *
     * @param str      字符串
     * @param strArray 字符串数组
     * @return true存在；false不存在
     */
    public static boolean isStringInArray(String str, String[] strArray) {
        if (Arrays.asList(strArray).contains(str)) {
            return true;
        }
        return false;
    }

    private static Object invokeProperty(Object obj, String property) {
        if ((property == null) || (property.length() == 0)) {
            return null; // just in case something silly happens.
        }

        Class cls = obj.getClass();
        Object[] oParams = {};
        Class[] cParams = {};

        try {
            // First try object.getProperty()
            Method method = cls.getMethod(createMethodName(GET, property), cParams);

            return method.invoke(obj, oParams);
        } catch (Exception e1) {
            try {
                // First try object.isProperty()
                Method method = cls.getMethod(createMethodName(IS, property), cParams);

                return method.invoke(obj, oParams);
            } catch (Exception e2) {
                try {
                    // Now try object.property()
                    Method method = cls.getMethod(property, cParams);

                    return method.invoke(obj, oParams);
                } catch (Exception e3) {
                    try {
                        // Now try object.property()
                        Field field = cls.getField(property);


                        return field.get(obj);
                    } catch (Exception e4) {
                        // oh well
                        return null;
                    }
                }
            }
        }
    }

    private static String createMethodName(String prefix, String propertyName) {
        return prefix + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
    }
}
