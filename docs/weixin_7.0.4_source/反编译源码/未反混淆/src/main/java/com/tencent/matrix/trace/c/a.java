package com.tencent.matrix.trace.c;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class a {
    private static long bZk = 0;
    private static long bZl = 0;
    private static long bZm = 0;
    public static com.tencent.matrix.trace.core.AppMethodBeat.a bZn = new com.tencent.matrix.trace.core.AppMethodBeat.a();
    public static com.tencent.matrix.trace.core.AppMethodBeat.a bZo = new com.tencent.matrix.trace.core.AppMethodBeat.a();
    public static int bZp = -100;

    static final class a implements Callback {
        private static boolean bZq = false;
        private static int bZr = 10;
        private final Callback bZs;
        private Method method = null;

        a(Callback callback) {
            this.bZs = callback;
        }

        public final boolean handleMessage(Message message) {
            if (AppMethodBeat.isRealTrace()) {
                boolean g = g(message);
                if (bZr > 0) {
                    c.i("Matrix.ActivityThreadHacker", "[handleMessage] msg.what:%s begin:%s isLaunchActivity:%s", Integer.valueOf(message.what), Long.valueOf(SystemClock.uptimeMillis()), Boolean.valueOf(g));
                    bZr--;
                }
                if (g) {
                    a.bZm = SystemClock.uptimeMillis();
                    a.bZn = AppMethodBeat.getInstance().maskIndex("LastLaunchActivityMethodIndex");
                }
                if (!bZq && (g || message.what == 114 || message.what == 113)) {
                    a.bZl = SystemClock.uptimeMillis();
                    a.bZp = message.what;
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

        private boolean g(Message message) {
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
                        c.e("Matrix.ActivityThreadHacker", "[isLaunchActivity] %s", e);
                    }
                }
                return message.what == 100;
            }
        }
    }

    public static void zy() {
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
            declaredField3.set(obj, new a((Callback) declaredField3.get(obj)));
            c.i("Matrix.ActivityThreadHacker", "hook system handler completed. start:%s SDK_INT:%s", Long.valueOf(bZk), Integer.valueOf(VERSION.SDK_INT));
        } catch (Exception e) {
            c.e("Matrix.ActivityThreadHacker", "hook system handler err! %s", e.getCause().toString());
        }
    }

    public static long zz() {
        return bZl - bZk;
    }

    public static long zA() {
        return bZk;
    }

    public static long zB() {
        return bZm;
    }
}
