package com.example.common.util;

import com.example.common.annotation.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hechengjin on 17-8-2.
 */
public class ValidUtils {
    public static  <T> void validNotNull(T t) throws IllegalAccessException {
        Field[] fields= t.getClass().getDeclaredFields();
        for(Field field:fields){
            NotNull notNull=field.getAnnotation(NotNull.class);
            if(notNull!=null){
                String defaultValue = notNull.value();
                field.setAccessible(true);
                Object value=field.get(t);
                if(value==null){
                    if(defaultValue.length()==0){
                        defaultValue="field ["+field.getName()+"] is null";
                    }
                    throw new IllegalArgumentException(defaultValue);
                }
            }
        }
    }

    public static  <T> void validNotNullEx(T t, String validFields) throws IllegalAccessException {
        List<String> fieldList = new ArrayList<String>();
        if (validFields.length() > 0 ){
            String[] fieldArray = validFields.split(",");
            for (String fieldName: fieldArray) {
                fieldList.add(fieldName);
            }
        }
        Field [] fields= t.getClass().getDeclaredFields();
        for(Field field:fields){
            for (String fieldName : fieldList){
                if (field.getName().equals(fieldName)){
                    String defaultValue= "";
                    field.setAccessible(true);
                    Object value=field.get(t);
                    if(value==null){
                        if(defaultValue.length()==0){
                            defaultValue="field ["+field.getName()+"] is null";
                        }
                        throw new IllegalArgumentException(defaultValue);
                    }
                }
            }
        }
    }
}
