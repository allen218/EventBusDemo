package com.example.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.eventbus.bus.EventBus;
import com.example.eventbus.bus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        //Fragment1 切换到首页
        EventBus.getDefault().post("main");
    }

    @Subscribe({"main"})
    private void test() {
        //Fragment2
        Log.e(TAG, "显示首页");
    }

    @Subscribe({"1", "2"})
    private void test(String msg, Integer msg1) {
        Log.e(TAG, "test   msg:" + msg + " msg1:" + msg1);
    }

    @Subscribe({"1"})
    private void test2(String msg, String msg1) {
        Log.e(TAG, "test2   msg:" + msg + " msg1:" + msg1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}
