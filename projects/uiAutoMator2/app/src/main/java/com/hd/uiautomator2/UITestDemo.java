package com.hd.uiautomator2;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by hd on 2019-06-05 .
 * 模拟点击，实现添加微信附件的人为好友
 */
@RunWith(AndroidJUnit4.class)
public class UITestDemo {

    @Before
    public void beforeTestCases() {

    }

    @After
    public void afterTestCases() {

    }

    @Test
    public void startTestCases() {
        testA();
    }

    private static final String weixinPackageName = "com.tencent.mm";

    private static final String TAG = "uiautomator";

    private UiDevice uiDevice;

    public void testA() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(instrumentation);
        Context context = instrumentation.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(weixinPackageName);
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            Log.d(TAG, "没有装微信");
            return;
        }
        sleep(1000);
        openNearbyFriendActivity();
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final String nearbyText = "附近的人";

    private static final String findText = "发现";

    private void openNearbyFriendActivity() {
        UiObject2 uiO2 = uiDevice.findObject(By.text(findText));
        uiO2.clickAndWait(Until.newWindow(), 100L);
        uiO2 = uiDevice.findObject(By.text(nearbyText));
        uiO2.clickAndWait(Until.newWindow(), 100L);
        openFriendInfo();
    }

    private static final String nearbyListViewId = "com.tencent.mm:id/dgh";

    private static final String noMoreFriends = "朋友不够多？";

    private int count = 5;

    private void openFriendInfo() {
        if (count > 0 && !uiDevice.hasObject(By.res(nearbyListViewId))) {
            sleep(1000);
            Log.d(TAG, "尝试：" + count);
            count--;
            openFriendInfo();
            return;
        } else if (count < 0) {
            Log.d(TAG, "尝试失败");
            return;
        }
        UiObject2 uio2 = uiDevice.findObject(By.res(nearbyListViewId));
        List<UiObject2> uio2s = uio2.getChildren();
        if (uio2s.get(0).hasObject(By.text(noMoreFriends))) {
            uio2s.remove(0);
        }
        //添加第一个好友
        uio2s.get(0).clickAndWait(Until.newWindow(), 100L);
        addFriend();
    }

    private static final String sayHello = "打招呼";

    private static final String send = "发送";

    private static final String inputId = "com.tencent.mm:id/e49";

    private void addFriend() {
        UiObject2 uio2 = uiDevice.findObject(By.text(sayHello));
        uio2.clickAndWait(Until.newWindow(), 100L);
        sleep(100);
        uiDevice.findObject(By.res(inputId)).setText("你好啊，测试下加好友");
        uiDevice.findObject(By.text(send)).clickAndWait(Until.newWindow(), 100L);
    }

}
