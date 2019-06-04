package com.example.xposedhookweixin1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getNearbyFriends(View view) {
        Intent intent = new Intent();
        intent.setAction(XposedHookWeixin.intentFilterMsg);
        sendBroadcast(intent);
        Log.d(XposedHookWeixin.TAG, "发送广播");
    }
}
