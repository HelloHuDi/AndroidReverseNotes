package com.example.xposedhookweixin1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookWeixin implements IXposedHookLoadPackage {

   private static final String selfPackageName="com.example.xposedhookweixin1";

   private static final String weixinPackageName = "com.tencent.mm";

   private static final String weixinMainActivityClassName = weixinPackageName + ".ui.LauncherUI";

   private static final String weixinNearbyClassName = weixinPackageName + ".plugin.nearby.ui.NearbyFriendsUI";

   private static final String TAG = "xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(weixinPackageName)) {
            Log.d(TAG, "进入微信");
            openWeixinNearbyActivity(lpparam);
        }else if(lpparam.packageName.equals(selfPackageName)){
            hookSelfClickEvent(lpparam);
        }
    }

    private void hookSelfClickEvent(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(selfPackageName + ".MainActivity",
                lpparam.classLoader, "getNearbyFriends", View.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Log.d(TAG, "打开微信");
                        openWeiXinMainActivity((Activity) param.thisObject);
                    }
                });
    }

    private void openWeiXinMainActivity(Activity activity) {
        try {
            updateState(false);
            Intent intent = new Intent(Intent.ACTION_MAIN);
            ComponentName cmp = new ComponentName(weixinPackageName, weixinMainActivityClassName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(cmp);
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openWeixinNearbyActivity(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(weixinMainActivityClassName, lpparam.classLoader,
                "onResume", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                if (!getState()) {
                    Log.d(TAG, "开始打开附近的人");
                    Activity activity = (Activity) param.thisObject;
                    activity.startActivity(new Intent(activity, XposedHelpers.findClass(weixinNearbyClassName, lpparam.classLoader)));
                }
            }
        });
        getNearbyInfo(lpparam);
    }

    private void getNearbyInfo(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(weixinNearbyClassName, lpparam.classLoader, "onSceneEnd",
                int.class, int.class, String.class,
                XposedHelpers.findClassIfExists("com.tencent.mm.ai.m", lpparam.classLoader),
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
                        if (!intent.getBooleanExtra("auto", false)) return;
                        Log.d(TAG, "继续执行");
                        getNearbyInfo(param, lpparam);
                    }
                });
    }

    private void getNearbyInfo(XC_MethodHook.MethodHookParam param, XC_LoadPackage.LoadPackageParam lpparam)
            throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Field field = lpparam.classLoader.loadClass(weixinNearbyClassName).getDeclaredField("lQs");
        field.setAccessible(true);
        List list = (List) field.get(param.thisObject);
        Log.i(TAG, "打印附近人结果：" + list.size());
        Class axv = list.get(0).getClass();
        Field[] fields = axv.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        String msg;
        for (int i = 0; i < list.size(); i++) {
            msg = "第" + (i + 1) + "人\n";
            builder.append(msg);
            for (Field field1 : fields) {
                try {
                    field1.setAccessible(true);
                    msg = "打印附近人详情属性：" + field1.getName()
                            + "===" + field1.getType().toString()
                            + "===" + field1.get(list.get(i)) + "\n";
                    builder.append(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        printMsg(builder.toString());
    }

    private static final String nearby_info_path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "weixin_nearby.txt";

    private void printMsg(String msg) {
        Log.i(TAG, "写入是否成功：" + FileIOUtils.writeFileFromBytesByStream(nearby_info_path, msg.getBytes()));
        updateState(true);
    }

    private static final String state_path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "state.txt";

    /**
     * true : 从打开微信到获取附近的人流程已经走完
     */
    private void updateState(boolean completed) {
        Log.i(TAG, "状态是否更新完成 ：" + FileIOUtils.writeFileFromBytesByStream(state_path, String.valueOf(completed).getBytes()));
    }

    private boolean getState() {
        byte[] data = FileIOUtils.readFile2BytesByStream(state_path);
        if (null != data && data.length > 0) {
            String stateS = new String(data);
            boolean state = Boolean.valueOf(stateS);
            Log.i(TAG, "当前操作状态 ：" + state);
            return state;
        }
        return false;
    }

}
