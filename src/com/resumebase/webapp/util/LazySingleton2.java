package com.resumebase.webapp.util;

public class LazySingleton2 {

    private LazySingleton2() {
    }

    //initialization-on-demand holder idiom
    private static  class LasySingletonHolder {
        private static final LazySingleton2 INSTANCE = new LazySingleton2();
    }

    public static LazySingleton2 getInstance() {

        return LasySingletonHolder.INSTANCE;
    }
}