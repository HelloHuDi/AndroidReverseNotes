package com.example.xposedtest;


import java.util.Arrays;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHook  implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.droider.crackme0201")) {
            XposedHelpers.findAndHookMethod("com.droider.crackme0201.MainActivity",
                    loadPackageParam.classLoader,
                    "checkSN", String.class, String.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                            XposedBridge.log("beforeHookedMethod1 :"+ Arrays.toString(param.args));
                            XposedBridge.log("beforeHookedMethod2 :"+param.method.getName());
                            XposedBridge.log("beforeHookedMethod3 :"+param.getResult());
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            XposedBridge.log("afterHookedMethod1 :"+param.getResult());
                            param.setResult(true);
                            XposedBridge.log("afterHookedMethod2 :"+param.getResult());
                            XposedBridge.log("afterHookedMethod3 :"+param.hasThrowable());
                        }
                    });
        }else{
            XposedBridge.log("不是目标："+loadPackageParam.packageName
                    +"=="+loadPackageParam.processName
                    +"=="+loadPackageParam.appInfo);
        }
    }
}