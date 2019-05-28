package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.d.c;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a {
    private static volatile Object bWl;
    public volatile boolean bWk;
    private final com.tencent.matrix.c.c.a bWm;

    public a(com.tencent.matrix.c.c.a aVar) {
        this.bWm = aVar;
    }

    public final boolean zf() {
        try {
            Class cls = Class.forName("dalvik.system.CloseGuard");
            Class cls2 = Class.forName("dalvik.system.CloseGuard$Reporter");
            Method declaredMethod = cls.getDeclaredMethod("getReporter", new Class[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("setReporter", new Class[]{cls2});
            Method declaredMethod3 = cls.getDeclaredMethod("setEnabled", new Class[]{Boolean.TYPE});
            bWl = declaredMethod.invoke(null, new Object[0]);
            declaredMethod3.invoke(null, new Object[]{Boolean.TRUE});
            c.setEnabled(true);
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                return false;
            }
            Object[] objArr = new Object[1];
            objArr[0] = Proxy.newProxyInstance(classLoader, new Class[]{cls2}, new b(this.bWm, bWl));
            declaredMethod2.invoke(null, objArr);
            return true;
        } catch (Throwable th) {
            c.e("Matrix.CloseGuardHooker", "tryHook exp=%s", th);
            return false;
        }
    }

    public static boolean zg() {
        try {
            Class cls = Class.forName("dalvik.system.CloseGuard");
            Method declaredMethod = cls.getDeclaredMethod("setReporter", new Class[]{Class.forName("dalvik.system.CloseGuard$Reporter")});
            Method declaredMethod2 = cls.getDeclaredMethod("setEnabled", new Class[]{Boolean.TYPE});
            declaredMethod.invoke(null, new Object[]{bWl});
            declaredMethod2.invoke(null, new Object[]{Boolean.FALSE});
            c.setEnabled(false);
            return true;
        } catch (Throwable th) {
            c.e("Matrix.CloseGuardHooker", "tryHook exp=%s", th);
            return false;
        }
    }
}
