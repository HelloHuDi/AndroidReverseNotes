package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e {

    static class a {
        private static Method Ct;
        private static boolean Cu;
        private static Method Cv;
        private static boolean Cw;

        public static IBinder c(Bundle bundle, String str) {
            if (!Cu) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    Ct = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                Cu = true;
            }
            if (Ct != null) {
                try {
                    return (IBinder) Ct.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Ct = null;
                }
            }
            return null;
        }

        public static void a(Bundle bundle, String str, IBinder iBinder) {
            if (!Cw) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    Cv = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                Cw = true;
            }
            if (Cv != null) {
                try {
                    Cv.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Cv = null;
                }
            }
        }
    }

    public static IBinder c(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return a.c(bundle, str);
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.a(bundle, str, iBinder);
        }
    }
}
