package com.example.xposedhookweixin1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookWeixin implements IXposedHookLoadPackage {

    private static final String selfPackageName = "com.example.xposedhookweixin1";

    static final String intentFilterMsg = selfPackageName + ".notify_open";

    private static final String weixinPackageName = "com.tencent.mm";

    private static final String weixinMainActivityClassName = weixinPackageName + ".ui.LauncherUI";

    private static final String weixinNearbyClassName = weixinPackageName + ".plugin.nearby.ui.NearbyFriendsUI";

    static final String TAG = "xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(weixinPackageName)) {
            addWeixinBroadcast(lpparam);
            getNearbyInfo(lpparam);
        }
    }

    private void addWeixinBroadcast(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(weixinMainActivityClassName, //
                                        lpparam.classLoader, //
                                        "onCreate", Bundle.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Log.d(TAG, "添加广播");
                        addBroadcastReceiver(lpparam, param);
                    }
                });
    }


    private void addBroadcastReceiver(final XC_LoadPackage.LoadPackageParam lpparam, //
                                      XC_MethodHook.MethodHookParam param) {
        final Activity activity = (Activity) param.thisObject;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(intentFilterMsg);
        activity.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG, "接收到广播：" + intent.getAction());
                Intent intent1 = new Intent();
                //自定义状态
                intent1.putExtra("auto", true);
                intent1.setClass(activity, XposedHelpers.findClass(weixinNearbyClassName, lpparam.classLoader));
                activity.startActivity(intent1);
            }
        }, intentFilter);
    }

    private void getNearbyInfo(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(weixinNearbyClassName, lpparam.classLoader, //
                                        "onSceneEnd", int.class,//
                                        int.class, String.class, //
                                        XposedHelpers.findClassIfExists("com.tencent.mm.ai.m", lpparam.classLoader),//
                                        new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Activity activity = (Activity) param.thisObject;
                Intent intent = activity.getIntent();
                //不是自动不会继续执行
                if (!intent.getBooleanExtra("auto", false))
                    return;
                Log.d(TAG, "继续执行");
                getNearbyInfo(param, lpparam);
            }
        });
    }

    private static final String nearby_info_path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "weixin_nearby.txt";

    private void getNearbyInfo(XC_MethodHook.MethodHookParam param, XC_LoadPackage.LoadPackageParam lpparam) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Field field = lpparam.classLoader.loadClass(weixinNearbyClassName).getDeclaredField("lQs");
        field.setAccessible(true);
        List list = (List) field.get(param.thisObject);
        Log.i(TAG, "打印附近人结果：" + list.size());
        Class axv = list.get(0).getClass();
        Field[] fields = axv.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        String msg = "";
        for (int i = 0; i < list.size(); i++) {
            msg = "第" + (i + 1) + "人\n";
            builder.append(msg);
            for (Field field1 : fields) {
                try {
                    field1.setAccessible(true);
                    msg = "打印附近人详情属性：" + field1.getName() + "===" + field1.getType().toString() + "===" + field1.get(list.get(i)) + "\n";
                    builder.append(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (msg.isEmpty()) {
            Log.i(TAG, "无好友");
        } else {
            Log.i(TAG, "写入是否成功：" + FileIOUtils.writeFileFromBytesByStream(nearby_info_path, msg.getBytes()));
        }
    }

}
