package com.example.xposedhookweixin1;

import java.lang.reflect.Method;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookWeixin implements IXposedHookLoadPackage {

    private static final String tencentMapClassName="com.tencent.map.geolocation.TencentLocationManager";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        hook(lpparam.classLoader);
    }

    //模拟地点 ：香港尖沙咀 === 22.295439999999996,114.17705000000001
    private static String latitude = "22.295439999999996";
    private static String longitude = "114.17705000000001";

    private void hook(ClassLoader classLoader) {
        try {
            Class managerClazz = XposedHelpers.findClass(tencentMapClassName, classLoader);
            XposedBridge.hookAllMethods(managerClazz, "requestLocationUpdates", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Object tencentLocationListener = param.args[1];
                    for (Method method : tencentLocationListener.getClass().getDeclaredMethods()) {
                        if (method.getParameterTypes().length == 10) {
                            XposedBridge.hookAllMethods(tencentLocationListener.getClass(), method.getName(), new XC_MethodHook() {
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    param.args[1] = Double.valueOf(latitude);
                                    param.args[2] = Double.valueOf(longitude);
                                    super.beforeHookedMethod(param);
                                }
                            });
                        }
                    }
                    super.beforeHookedMethod(param);
                }
            });
        } catch (Error | Exception e) {
            e.printStackTrace();
        }
    }
}
