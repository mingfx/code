package com.ming.fun;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Son extends Father {
    private static void sonMethod(){

        try {
            Class clazz = Class.forName("com.ming.fun.Father");
            Method method = clazz.getDeclaredMethod("method1");
            method.setAccessible(true);
            method.invoke(clazz.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sonMethod();
    }
}
