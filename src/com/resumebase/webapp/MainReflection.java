package com.resumebase.webapp;

import com.resumebase.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.*;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        field.get(r);
        System.out.println(r);
        field.set(r, "new_uuid");
        System.out.println(r);

        //TODO invoke r.toString() via Reflection
        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);


    }
}
