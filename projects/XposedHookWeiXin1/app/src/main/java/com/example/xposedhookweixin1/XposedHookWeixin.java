package com.example.xposedhookweixin1;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.util.Objects;
import java.util.Set;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookWeixin implements IXposedHookLoadPackage {

    private static final String weixinPackageName = "com.tencent.mm";

    private static final String weixinContactInfoClassName = weixinPackageName + ".plugin.profile.ui.ContactInfoUI";

    private static final String TAG = "xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(weixinPackageName)) {
            handleContactInfo(lpparam);
        }
    }
    //com.tencent.mm.storage.ad
    //com.tencent.mm.n.a
    //com.tencent.mm.g.c.ap

    //com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
    private void handleContactInfo(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(weixinContactInfoClassName, lpparam.classLoader,
                "onCreate",Bundle.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.i(TAG, "打印 handleContactInfo beforeHookedMethod：" + param.method);
                    }

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Activity activity = (Activity) param.thisObject;
                        Intent intent = activity.getIntent();
                        Set<String> keys = Objects.requireNonNull(intent.getExtras()).keySet();
                        //Contact_Mobile_MD5  string
                        //Contact_User  string
                        //CONTACT_INFO_UI_SOURCE  int
                        for (String string : keys) {
                            Log.i(TAG, "打印 handleContactInfo keys 内容 ：" + string);
                        }
                        Log.i(TAG, "打印 handleContactInfo keys 内容11 ：" + intent.getStringExtra("Contact_Mobile_MD5"));
                        Log.i(TAG, "打印 handleContactInfo keys 内容11 ：" + intent.getStringExtra("Contact_User"));
                        Log.i(TAG, "打印 handleContactInfo keys 内容11 ：" + intent.getIntExtra("CONTACT_INFO_UI_SOURCE", -1));
                    }
                });
    }
}
