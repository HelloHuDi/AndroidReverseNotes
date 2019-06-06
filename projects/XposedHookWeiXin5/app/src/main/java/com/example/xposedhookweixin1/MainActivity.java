package com.example.xposedhookweixin1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction(XposedHookWeixin.intentFilterMsg);
        intent.putExtra(XposedHookWeixin.intentSendFriendType, //
                        Integer.valueOf(String.valueOf(v.getTag())));
        sendBroadcast(intent);
        Log.d(XposedHookWeixin.TAG, "发送广播");
    }
}
