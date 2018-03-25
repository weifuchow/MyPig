package com.pig.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by chuangang.li on 2017/1/18.
 */
public class DataTypeUtils {
    public DataTypeUtils() {
    }

    public static Integer getIntegerValue(Object value) {
        return value == null ? null : (value instanceof Integer ? (Integer) value : (value instanceof Long ? Integer.valueOf(((Long) value).intValue()) : (value instanceof Double ? Integer.valueOf(((Double) value).intValue()) : (value instanceof BigDecimal ? Integer.valueOf(((BigDecimal) value).intValue()) : Integer.valueOf(value.toString())))));
    }

    public static Long getLongValue(Object value) {
        return value == null ? null : (value instanceof Integer ? Long.valueOf(((Integer) value).longValue()) : (value instanceof Long ? (Long) value : (value instanceof Double ? Long.valueOf(((Double) value).longValue()) : (value instanceof BigDecimal ? Long.valueOf(((BigDecimal) value).longValue()) : Long.valueOf(value.toString())))));
    }

    public static BigDecimal getBigDecimalValue(Object value) {
        return value == null ? null : (value instanceof Integer ? BigDecimal.valueOf((long) ((Integer) value).intValue()) : (value instanceof Long ? BigDecimal.valueOf(((Long) value).longValue()) : (value instanceof Double ? BigDecimal.valueOf(((Double) value).doubleValue()) : (value instanceof BigDecimal ? (BigDecimal) value : new BigDecimal(value.toString())))));
    }

    public static String getStringValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static Date getDateValue(Object value) {
        return value == null ? null : (Date) value;
    }

    public static Boolean getBooleanValue(Object value) {
        return (Boolean) value;
    }

//    public static <T extends Enum<T>> T getEnumValue(Object value, Class<T> type) {
//        return value == null?null:(value instanceof Enum?(Enum)value:Enum.valueOf(type, value.toString()));
//    }
}
