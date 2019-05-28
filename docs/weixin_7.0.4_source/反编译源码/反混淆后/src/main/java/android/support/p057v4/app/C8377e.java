package android.support.p057v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.app.e */
public final class C8377e {

    /* renamed from: android.support.v4.app.e$a */
    static class C8378a {
        /* renamed from: Ct */
        private static Method f2333Ct;
        /* renamed from: Cu */
        private static boolean f2334Cu;
        /* renamed from: Cv */
        private static Method f2335Cv;
        /* renamed from: Cw */
        private static boolean f2336Cw;

        /* renamed from: c */
        public static IBinder m14785c(Bundle bundle, String str) {
            if (!f2334Cu) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f2333Ct = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                f2334Cu = true;
            }
            if (f2333Ct != null) {
                try {
                    return (IBinder) f2333Ct.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    f2333Ct = null;
                }
            }
            return null;
        }

        /* renamed from: a */
        public static void m14784a(Bundle bundle, String str, IBinder iBinder) {
            if (!f2336Cw) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f2335Cv = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                f2336Cw = true;
            }
            if (f2335Cv != null) {
                try {
                    f2335Cv.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    f2335Cv = null;
                }
            }
        }
    }

    /* renamed from: c */
    public static IBinder m14783c(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return C8378a.m14785c(bundle, str);
    }

    /* renamed from: a */
    public static void m14782a(Bundle bundle, String str, IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            C8378a.m14784a(bundle, str, iBinder);
        }
    }
}
