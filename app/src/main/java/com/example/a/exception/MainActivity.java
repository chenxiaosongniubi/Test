package com.example.a.exception;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 技术的深度
 * 高并发线程安全之弱引用案例详解
 * 弱引用：在内存中的能力不是那么强的
 * WeakReference<对象>节约内存占用，间接引用
 * 强引用
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
