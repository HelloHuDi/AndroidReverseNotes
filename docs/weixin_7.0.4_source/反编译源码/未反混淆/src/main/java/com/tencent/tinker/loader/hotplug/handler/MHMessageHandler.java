package com.tencent.tinker.loader.hotplug.handler;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor.MessageHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MHMessageHandler implements MessageHandler {
    private static final int xHf;
    private final Context mContext;

    static {
        int i = 100;
        if (VERSION.SDK_INT < 27) {
            try {
                i = ShareReflectUtil.d(Class.forName("android.app.ActivityThread$H"), "LAUNCH_ACTIVITY").getInt(null);
            } catch (Throwable th) {
            }
        }
        xHf = i;
    }

    public MHMessageHandler(Context context) {
        Context context2;
        while (true) {
            context2 = context;
            if (!(context2 instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context2).getBaseContext();
            if (context == null) {
                break;
            }
        }
        this.mContext = context2;
    }

    public final boolean handleMessage(Message message) {
        int i = 2;
        if (message.what == xHf) {
            try {
                Object obj = message.obj;
                if (obj == null) {
                    new StringBuilder("msg: [").append(message.what).append("] has no 'obj' value.");
                } else {
                    Intent intent = (Intent) ShareReflectUtil.b(obj, "intent").get(obj);
                    if (intent != null) {
                        ShareIntentUtil.a(intent, this.mContext.getClassLoader());
                        ComponentName componentName = (ComponentName) intent.getParcelableExtra("tinker_iek_old_component");
                        if (componentName == null) {
                            new StringBuilder("oldComponent was null, start ").append(intent.getComponent()).append(" next.");
                        } else {
                            ActivityInfo activityInfo = (ActivityInfo) ShareReflectUtil.b(obj, "activityInfo").get(obj);
                            if (activityInfo != null) {
                                ActivityInfo aun = IncrementComponentManager.aun(componentName.getClassName());
                                if (aun == null) {
                                    new StringBuilder("Failed to query target activity's info, perhaps the target is not hotpluged component. Target: ").append(componentName.getClassName());
                                } else {
                                    int i2 = aun.screenOrientation;
                                    if (i2 != -1) {
                                        i = i2;
                                    }
                                    try {
                                        Object obj2 = ShareReflectUtil.b(obj, "token").get(obj);
                                        obj = ShareReflectUtil.c(Class.forName("android.app.ActivityManagerNative"), "getDefault", new Class[0]).invoke(null, new Object[0]);
                                        ShareReflectUtil.b(obj, "setRequestedOrientation", IBinder.class, Integer.TYPE).invoke(obj, new Object[]{obj2, Integer.valueOf(i)});
                                    } catch (Throwable th) {
                                    }
                                    G(aun, activityInfo);
                                    intent.setComponent(componentName);
                                    intent.removeExtra("tinker_iek_old_component");
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
            }
        }
        return false;
    }

    private static <T> void G(T t, T t2) {
        if (t != null && t2 != null) {
            for (Object obj = t.getClass(); !obj.equals(Object.class); obj = obj.getSuperclass()) {
                for (Field field : obj.getDeclaredFields()) {
                    if (!(field.isSynthetic() || Modifier.isStatic(field.getModifiers()))) {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                        try {
                            field.set(t2, field.get(t));
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        }
    }
}
