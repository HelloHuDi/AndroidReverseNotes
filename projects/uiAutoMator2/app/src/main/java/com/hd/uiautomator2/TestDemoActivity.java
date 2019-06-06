package com.hd.uiautomator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestDemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_demo);
        findViewById(R.id.button1).setOnClickListener(this);
    }


    /**
     * package_name.uiautomator_class_name manifest_instrumentation_targetPackage_name
     */
    public static final String FUNCTION_MODEL = "am instrument -w -r  -e debug false -e class %s.%s#%s %s/android.support.test.runner.AndroidJUnitRunner";

    public static final String FUNCTION_MODEL2 = "am instrument --user 0 -w -r   -e debug false -e class %s.%s#%s %s/android.support.test.runner.AndroidJUnitRunner";

    private static final String targetPackageName = "com.hd.uiautomator2";

    private static final String targetClassName = "UITestDemo";

    private static final String targetModuleName = "startTestCases";

    //手机需要root
    //参考 https://www.jianshu.com/p/f4e73575f7a1
    @Override
    public void onClick(View v) {
        try {
            String cmd = String.format(FUNCTION_MODEL, targetPackageName,//
                                       targetClassName, targetModuleName, targetPackageName);
            ShellUtils.CommandResult result = ShellUtils.execCommand(cmd);
            Log.d("test ui auto ", "成功发送指令:" + result.successMsg);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("test ui auto ", "失败：" + e);
        }
    }
}
