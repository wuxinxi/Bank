package com.wtr.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * 作者：Tangren_ on 2017/5/2 0002.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class MyButton extends Button {
    private static final String TAG = "MyButton";

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                Log.d(TAG,"MotionEvent.ACTION_UP……");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG,"MotionEvent.ACTION_DOWN……");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG,"MotionEvent.ACTION_MOVE……");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                Log.d(TAG,"dispatchTouchEvent--MotionEvent.ACTION_UP……");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG,"dispatchTouchEvent--MotionEvent.ACTION_DOWN      ……");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG,"dispatchTouchEvent--MotionEvent.ACTION_MOVE……");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
