package com.resumebase.webapp;

public class LazySingleton {

    static int i;
    volatile private static LazySingleton INSTANCE;

    double sin = Math.sin(13.);

    //double checked locking
    public static LazySingleton getInstance() {
        if(INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    i = 13;
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }

    private LazySingleton() {
    }
}
