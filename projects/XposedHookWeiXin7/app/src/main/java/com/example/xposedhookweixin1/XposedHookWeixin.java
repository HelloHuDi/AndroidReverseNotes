package com.example.xposedhookweixin1;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findClass;

public class XposedHookWeixin implements IXposedHookLoadPackage {

    private static final String weixinPackageName = "com.tencent.mm";

    private static final String weixinLauncherUIName = weixinPackageName + ".ui.LauncherUI";

    private static final String weixinLuchyMoneyUIName = weixinPackageName + ".plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI";

    private static final String weixinLuchyMoneyDetailsUIName = weixinPackageName + ".plugin.luckymoney.ui.LuckyMoneyDetailUI";

    private static final String weixinSqlitClassName = "com.tencent.wcdb.database.SQLiteDatabase";

    private static final String TAG = "xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(weixinPackageName)) {
            initHook(lpparam);
            hookNewMessage(lpparam);
            hookOpenLuckyMoney(lpparam);
            hookCloseLuckyMoneyDetailUI(lpparam);
        }
    }

    private String lastTalkerName = "";
    private String lastNativeUrl = "";
    private Activity launcherUiActivity;

    /**
     * 初始化微信红包勾子
     */
    private void initHook(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        XposedHelpers.findAndHookMethod(weixinLauncherUIName, loadPackageParam.classLoader, //
                                        "onCreate", Bundle.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        launcherUiActivity = (Activity) param.thisObject;
                    }
                });
    }

    /**
     * 过滤红包消息
     */
    private void hookNewMessage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        XposedHelpers.findAndHookMethod(weixinSqlitClassName, loadPackageParam.classLoader, //
                                        "insertWithOnConflict", String.class, String.class, //
                                        ContentValues.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Log.d(TAG, "table=" + param.args[0] + "\n");
                        ContentValues contentValues = (ContentValues) param.args[2];
                        if ("WalletLuckyMoney".equals(param.args[0])) {
                            Log.d(TAG, "mNativeUrl:" + contentValues.getAsString("mNativeUrl"));
                            lastNativeUrl = contentValues.getAsString("mNativeUrl");
                        } else if ("message".equals(param.args[0]) //
                                && null != contentValues.getAsString("reserved") //
                                && contentValues.getAsString("reserved").contains("微信红包")) {
                            Log.d(TAG, "talker:" + contentValues.getAsString("talker"));
                            lastTalkerName = contentValues.getAsString("talker");
                            Log.d(TAG, "content:" + contentValues.getAsString("content"));
                            // 启动红包页面
                            if (launcherUiActivity != null) {
                                Intent paramau = new Intent();
                                paramau.putExtra("key_way", 0);
                                paramau.putExtra("key_native_url", lastNativeUrl);
                                paramau.putExtra("key_username", lastTalkerName);
                                paramau.putExtra("key_cropname", (String) null);
                                XposedHelpers.callStaticMethod(findClass(
                                        "com.tencent.mm.bp.d", //
                                        loadPackageParam.classLoader), "b", launcherUiActivity,//
                                                               "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", paramau);
                            } else {
                                Log.d(TAG, "launcherUiActivity == null" + "\n");
                            }
                        }
                    }
                });
    }

    /**
     * 触发开红包动作
     */
    private void hookOpenLuckyMoney(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        XposedHelpers.findAndHookMethod(weixinLuchyMoneyUIName, loadPackageParam.classLoader, "onResume", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(TAG, "LuckyMoneyNotHookReceiveUI");
                Field buttonField = XposedHelpers.findField(param.thisObject.getClass(), "nTE");
                final Button kaiButton = (Button) buttonField.get(param.thisObject);
                if (kaiButton.getVisibility() != View.VISIBLE) {
                    ((Activity) param.thisObject).finish();
                } else {
                    kaiButton.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            kaiButton.performClick();
                        }
                    }, 500);
                }
            }
        });
    }

    /**
     * 关闭红包详情页
     */
    private void hookCloseLuckyMoneyDetailUI(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        XposedHelpers.findAndHookMethod(weixinLuchyMoneyDetailsUIName, loadPackageParam.classLoader, //
                                        "onCreate", Bundle.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        ((Activity) param.thisObject).finish();
                    }
                });
    }

}
