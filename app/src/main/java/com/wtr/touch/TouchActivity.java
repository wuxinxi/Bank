package com.wtr.touch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.wxx.bank.R;

/**
 * 作者：Tangren_ on 2017/5/2 0002.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class TouchActivity extends AppCompatActivity {

    private static final String TAG = "TouchActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        MyLinearLayout layout = (MyLinearLayout) findViewById(R.id.linearLayout);
        Button button = (Button) findViewById(R.id.button);
        layout.requestDisallowInterceptTouchEvent(true);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "layout__touch");
                return false;
            }
        });

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "button----ACTION_DOWN……");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "button----ACTION_MOVE……");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "button----ACTION_UP……");
                        break;

                }
                return false;
            }
        });

    }

}
