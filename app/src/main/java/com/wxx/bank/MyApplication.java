package com.wxx.bank;

import android.app.Application;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        if (instance == null) {
            synchronized (MyApplication.class) {
                if (instance == null) {
                    instance = new MyApplication();
                }
            }

        }
        return instance;
    }
}
