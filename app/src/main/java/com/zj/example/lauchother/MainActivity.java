package com.zj.example.lauchother;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 启动方式1
         */
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.zj.example.taskstack", "com.zj.example.taskstack.MainActivity");
                //这两种一样
                //intent.setComponent(new ComponentName("com.zj.example.taskstack", "com.zj.example.taskstack.MainActivity"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        /**
         * 启动方式2
         */
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("task.zj.com1");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivity(intent);
            }
        });
        /**
         * 启动方式3
         */
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    //intent.addCategory(Intent.CATEGORY_BROWSABLE);//只能通过浏览器启动
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    /*
                     * 如果manifest配置的是path,那stack.do必须完全匹配才行,stack.dooo都不行
                     * 如果是pathPrefix,那只需要前部分是stack.do就行后面是什么都可以匹配
                     */

                    intent.setData(Uri.parse("task://www.zj.com:99/stack.do?name=zhengjiong"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /**
         * 启动方式4
         */
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    //intent.addCategory(Intent.CATEGORY_BROWSABLE);//只能通过浏览器启动
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setData(Uri.parse("task://www.zj.com:99/zj.dododo?name=zhengjiong"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
