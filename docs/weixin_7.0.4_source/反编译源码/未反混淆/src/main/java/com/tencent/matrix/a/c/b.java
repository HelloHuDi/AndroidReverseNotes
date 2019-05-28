package com.tencent.matrix.a.c;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class b {
    private final String bWb;
    private final String bWc;
    private final b bWd;
    private IBinder bWe;

    static final class a implements InvocationHandler {
        private final IBinder bWf;
        private final Object bWg;

        a(IBinder iBinder, Object obj) {
            this.bWf = iBinder;
            this.bWg = obj;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"queryLocalInterface".equals(method.getName()) || this.bWg == null) {
                return method.invoke(this.bWf, objArr);
            }
            return this.bWg;
        }
    }

    public interface b {
        void b(Method method, Object[] objArr);
    }

    static class c implements InvocationHandler {
        final Object bWh;
        final b bWi;

        c(Object obj, b bVar) {
            this.bWh = obj;
            this.bWi = bVar;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (this.bWi != null) {
                this.bWi.b(method, objArr);
            }
            return method.invoke(this.bWh, objArr);
        }
    }

    public b(String str, String str2, b bVar) {
        this.bWb = str;
        this.bWc = str2;
        this.bWd = bVar;
    }

    public final boolean doHook() {
        com.tencent.matrix.d.c.i("Matrix.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", this.bWb, this.bWc);
        try {
            Class cls = Class.forName("android.os.ServiceManager");
            this.bWe = (IBinder) cls.getDeclaredMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{this.bWb});
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                com.tencent.matrix.d.c.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
                return false;
            }
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, new a(this.bWe, za()));
            Field declaredField = cls.getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.bWb, iBinder);
            return true;
        } catch (Throwable th) {
            com.tencent.matrix.d.c.e("Matrix.SystemServiceBinderHooker", "doHook exp : " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    public final boolean doUnHook() {
        if (this.bWe == null) {
            com.tencent.matrix.d.c.i("Matrix.SystemServiceBinderHooker", "doUnHook sOriginPowerManagerService null", new Object[0]);
            return false;
        }
        try {
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.bWb, this.bWe);
            return true;
        } catch (Throwable th) {
            com.tencent.matrix.d.c.e("Matrix.SystemServiceBinderHooker", "doUnHook exp : " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    private Object za() {
        try {
            Class cls = Class.forName(this.bWc);
            Class cls2 = Class.forName(String.format("%s$Stub", new Object[]{this.bWc}));
            Object invoke = cls2.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{this.bWe});
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                com.tencent.matrix.d.c.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
                return Boolean.FALSE;
            }
            return Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new c(invoke, this.bWd));
        } catch (Throwable th) {
            com.tencent.matrix.d.c.w("Matrix.SystemServiceBinderHooker", "createPowerManagerServiceProxy exp:%s", th.getLocalizedMessage());
            return null;
        }
    }
}
