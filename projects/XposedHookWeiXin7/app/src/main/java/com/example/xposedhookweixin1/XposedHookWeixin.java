package com.example.xposedhookweixin1;

import android.content.ContentValues;
import android.util.Log;

import java.util.Arrays;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookWeixin implements IXposedHookLoadPackage {

    private static final String weixinPackageName = "com.tencent.mm";

    private static final String weixinSqlitClassName = "com.tencent.wcdb.database.SQLiteDatabase";

    private static final String TAG="xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if(lpparam.packageName.equals(weixinPackageName)) {
            addLuckyMoneyListener(lpparam);
        }
    }

    private void addLuckyMoneyListener(XC_LoadPackage.LoadPackageParam lpparam) {
        Class sqlitCls=XposedHelpers.findClassIfExists(weixinSqlitClassName,lpparam.classLoader);
        if(sqlitCls!=null) {
            XposedHelpers.findAndHookMethod(sqlitCls, "insertWithOnConflict", //
                                            String.class, String.class, ContentValues.class,//
                                            int.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Log.d(TAG,"数据库参数："+ Arrays.toString(param.args));

                }
            });
        }
    }

}
