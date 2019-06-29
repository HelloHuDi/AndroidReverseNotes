package com.hd.smalidemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String testS = "heh";
    private static boolean testB = false;
    public  char testC = 'a';
    private float testF = 34.f;
    private final double testD = 334.d;
    private final short testSh = 2;
    private List<String>list=new ArrayList<>();
    private TextView tvT;
    private EditText etT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        tvT=findViewById(R.id.tvT);
        etT=findViewById(R.id.etT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        testB = !testB;
        ((Button) v).setText("原内容 ：" + etT.getText());
        invokeMethod();
    }

    private void invokeMethod(){
        if (testB) {
            Toast.makeText(this, "测试:" + testS, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "测试:" + testC, Toast.LENGTH_LONG).show();
        }
        if (testF > testD) {
            Log.d("tag", "就是要这样搞1:"+testSh);
        }
        if (testC==1) {
            Log.d("tag", "就是要这样搞2");
        }
        Log.d("tag", "就是要这样搞3"+list);
        tvT.setText(etT.getText().toString().trim());
    }

}
