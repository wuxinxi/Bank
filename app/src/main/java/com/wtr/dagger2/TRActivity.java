package com.wtr.dagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wxx.bank.R;

import javax.inject.Inject;

/**
 * 作者：Tangren_ on 2017/4/28 0028.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class TRActivity extends AppCompatActivity {

    @Inject
    Person person;

    private static final String TAG = "TRActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerTRComponet.builder().tRModule(new TRModule()).build().inject(this);
        person.setMsg("Android开发工程渣");
        person.setName("吴新喜");
        Log.d(TAG, person.toString());
    }
}
