package com.example.xposedhookweixin1;

import android.util.Log;

import java.util.Arrays;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookWeixin implements IXposedHookLoadPackage {

    private static final String weixinPackageName = "com.tencent.mm";

    private static final String weixinToolsBo = weixinPackageName + ".sdk.platformtools.bo";

    private static final String TAG = "xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(weixinPackageName)) {
            handlePlugin(lpparam);
        }
    }

    //摇骰子和猜拳作弊器
    //com.tencent.mm.view.a.i
    // id =yw   0x7f1103bf   2131821503
    // [2,0] 结果 1 == 猜拳 石头
    // [2,0] 结果 0 == 猜拳 剪刀
    // [2,0] 结果 2 == 猜拳 布
    // [5,0] 结果 2 == 摇骰子 4
    // [5,0] 结果 2 == 摇骰子 3
    // [5,0] 结果 4 == 摇骰子 5
    private void handlePlugin(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(weixinToolsBo, lpparam.classLoader, "gV", //
                                        int.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.d(TAG, "结果：" + Arrays.toString(param.args));
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Log.d(TAG, "结果：" + param.getResult());
                        switch ((int) param.args[0]) {
                            case 2:
                                Log.d(TAG, "娱乐模式：猜拳,设置永远为布");
                                param.setResult(2);
                                break;
                            case 5:
                                Log.d(TAG, "娱乐模式：摇骰子,设置永远为6");
                                param.setResult(5);
                                break;
                        }
                    }
                });
    }
}
