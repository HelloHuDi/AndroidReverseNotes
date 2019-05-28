package com.tencent.matrix.iocanary.p159b;

import com.tencent.matrix.p156c.C1064c.C1063a;
import com.tencent.matrix.p157d.C1070c;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.tencent.matrix.iocanary.b.a */
public final class C1076a {
    private static volatile Object bWl;
    public volatile boolean bWk;
    private final C1063a bWm;

    public C1076a(C1063a c1063a) {
        this.bWm = c1063a;
    }

    /* renamed from: zf */
    public final boolean mo4216zf() {
        try {
            Class cls = Class.forName("dalvik.system.CloseGuard");
            Class cls2 = Class.forName("dalvik.system.CloseGuard$Reporter");
            Method declaredMethod = cls.getDeclaredMethod("getReporter", new Class[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("setReporter", new Class[]{cls2});
            Method declaredMethod3 = cls.getDeclaredMethod("setEnabled", new Class[]{Boolean.TYPE});
            bWl = declaredMethod.invoke(null, new Object[0]);
            declaredMethod3.invoke(null, new Object[]{Boolean.TRUE});
            C1078c.setEnabled(true);
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                return false;
            }
            Object[] objArr = new Object[1];
            objArr[0] = Proxy.newProxyInstance(classLoader, new Class[]{cls2}, new C6285b(this.bWm, bWl));
            declaredMethod2.invoke(null, objArr);
            return true;
        } catch (Throwable th) {
            C1070c.m2367e("Matrix.CloseGuardHooker", "tryHook exp=%s", th);
            return false;
        }
    }

    /* renamed from: zg */
    public static boolean m2384zg() {
        try {
            Class cls = Class.forName("dalvik.system.CloseGuard");
            Method declaredMethod = cls.getDeclaredMethod("setReporter", new Class[]{Class.forName("dalvik.system.CloseGuard$Reporter")});
            Method declaredMethod2 = cls.getDeclaredMethod("setEnabled", new Class[]{Boolean.TYPE});
            declaredMethod.invoke(null, new Object[]{bWl});
            declaredMethod2.invoke(null, new Object[]{Boolean.FALSE});
            C1078c.setEnabled(false);
            return true;
        } catch (Throwable th) {
            C1070c.m2367e("Matrix.CloseGuardHooker", "tryHook exp=%s", th);
            return false;
        }
    }
}
