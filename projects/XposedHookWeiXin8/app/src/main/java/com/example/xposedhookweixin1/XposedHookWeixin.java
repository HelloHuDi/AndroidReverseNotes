package com.example.xposedhookweixin1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.Log;
import android.util.SparseArray;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedHookWeixin implements IXposedHookLoadPackage {

    private static final String TAG = "xposed";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        hook(lpparam.classLoader);
    }

    private static void hook(ClassLoader classLoader) {
        try {
            Class clazz = XposedHelpers.findClass("android.hardware.SystemSensorManager$SensorEventQueue", classLoader);
            XposedBridge.hookAllMethods(clazz, "dispatchSensorEvent", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int intValue = (Integer) param.args[0];
                    Field declaredField = param.thisObject.getClass().getDeclaredField("mSensorsEvents");
                    declaredField.setAccessible(true);
                    Sensor sensor = ((SensorEvent) ((SparseArray) declaredField.get(param.thisObject)).get(intValue)).sensor;
                    if (sensor == null) {
                        Log.d(TAG, "打印 1 ：" + "传感器为NULL");
                    } else {
                        int sensortype = sensor.getType();
                        if (sensortype == 19 || sensortype == 18) {
                            float nowstep = ((float[]) param.args[1])[0];
                            Log.d(TAG, "打印当前步数 ：" + nowstep);
                            ((float[]) param.args[1])[0] = nowstep * 10;//倍数，微信有自己的统计算法
                            Log.d(TAG, "打印修改步数 ：" + ((float[]) param.args[1])[0]);
                        }
                    }
                }
            });
        } catch (Error | Exception e) {
            e.printStackTrace();
        }
    }
}
