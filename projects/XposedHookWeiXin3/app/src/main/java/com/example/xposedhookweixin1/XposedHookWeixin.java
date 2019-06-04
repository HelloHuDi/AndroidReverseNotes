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

     static final String intentFilterMsg = selfPackageName+".notify_open";

   private static final String weixinPackageName = "com.tencent.mm";

   private static final String weixinMainActivityClassName = weixinPackageName + ".ui.LauncherUI";

   private static final String weixinNearbyClassName = weixinPackageName + ".plugin.nearby.ui.NearbyFriendsUI";

    static final String TAG = "xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

    }
}
