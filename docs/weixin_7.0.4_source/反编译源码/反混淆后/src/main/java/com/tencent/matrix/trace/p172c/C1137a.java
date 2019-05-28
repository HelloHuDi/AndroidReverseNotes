package com.tencent.matrix.trace.p172c;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.C1141a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: com.tencent.matrix.trace.c.a */
public final class C1137a {
    private static long bZk = 0;
    private static long bZl = 0;
    private static long bZm = 0;
    public static C1141a bZn = new C1141a();
    public static C1141a bZo = new C1141a();
    public static int bZp = -100;

    /* renamed from: com.tencent.matrix.trace.c.a$a */
    static final class C1136a implements Callback {
        private static boolean bZq = false;
        private static int bZr = 10;
        private final Callback bZs;
        private Method method = null;

        C1136a(Callback callback) {
            this.bZs = callback;
        }

        public final boolean handleMessage(Message message) {
            if (AppMethodBeat.isRealTrace()) {
                boolean g = m2496g(message);
                if (bZr > 0) {
                    C1070c.m2368i("Matrix.ActivityThreadHacker", "[handleMessage] msg.what:%s begin:%s isLaunchActivity:%s", Integer.valueOf(message.what), Long.valueOf(SystemClock.uptimeMillis()), Boolean.valueOf(g));
                    bZr--;
                }
                if (g) {
                    C1137a.bZm = SystemClock.uptimeMillis();
                    C1137a.bZn = AppMethodBeat.getInstance().maskIndex("LastLaunchActivityMethodIndex");
                }
                if (!bZq && (g || message.what == 114 || message.what == 113)) {
                    C1137a.bZl = SystemClock.uptimeMillis();
                    C1137a.bZp = message.what;
                    bZq = true;
                }
                if (this.bZs != null) {
                    return this.bZs.handleMessage(message);
                }
                return false;
            } else if (this.bZs == null) {
                return false;
            } else {
                return this.bZs.handleMessage(message);
            }
        }

        /* renamed from: g */
        private boolean m2496g(Message message) {
            if (VERSION.SDK_INT <= 27) {
                return message.what == 100;
            } else {
                if (message.what == JsApiGetBackgroundAudioState.CTRL_INDEX && message.obj != null) {
                    try {
                        if (this.method == null) {
                            this.method = Class.forName("android.app.servertransaction.ClientTransaction").getDeclaredMethod("getCallbacks", new Class[0]);
                            this.method.setAccessible(true);
                        }
                        List list = (List) this.method.invoke(message.obj, new Object[0]);
                        if (!list.isEmpty()) {
                            return list.get(0).getClass().getName().endsWith(".LaunchActivityItem");
                        }
                    } catch (Exception e) {
                        C1070c.m2367e("Matrix.ActivityThreadHacker", "[isLaunchActivity] %s", e);
                    }
                }
                return message.what == 100;
            }
        }
    }

    /* renamed from: zy */
    public static void m2501zy() {
        try {
            bZk = SystemClock.uptimeMillis();
            bZo = AppMethodBeat.getInstance().maskIndex("ApplicationCreateBeginMethodIndex");
            Class cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            obj = declaredField2.get(obj);
            Field declaredField3 = obj.getClass().getSuperclass().getDeclaredField("mCallback");
            declaredField3.setAccessible(true);
            declaredField3.set(obj, new C1136a((Callback) declaredField3.get(obj)));
            C1070c.m2368i("Matrix.ActivityThreadHacker", "hook system handler completed. start:%s SDK_INT:%s", Long.valueOf(bZk), Integer.valueOf(VERSION.SDK_INT));
        } catch (Exception e) {
            C1070c.m2367e("Matrix.ActivityThreadHacker", "hook system handler err! %s", e.getCause().toString());
        }
    }

    /* renamed from: zz */
    public static long m2502zz() {
        return bZl - bZk;
    }

    /* renamed from: zA */
    public static long m2499zA() {
        return bZk;
    }

    /* renamed from: zB */
    public static long m2500zB() {
        return bZm;
    }
}
