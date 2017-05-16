package com.wxx.bank;

import android.util.Log;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class Logger {
    public static final void error(String tag, Exception e) {
        Log.e(tag, e.getMessage());

    }

    public static final void debug(String tag, int size) {
        Log.d(tag, size + "");
    }

}
