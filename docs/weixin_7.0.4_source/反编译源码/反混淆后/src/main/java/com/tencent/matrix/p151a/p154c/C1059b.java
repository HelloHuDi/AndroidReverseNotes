package com.tencent.matrix.p151a.p154c;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.matrix.p157d.C1070c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* renamed from: com.tencent.matrix.a.c.b */
public final class C1059b {
    private final String bWb;
    private final String bWc;
    private final C1057b bWd;
    private IBinder bWe;

    /* renamed from: com.tencent.matrix.a.c.b$a */
    static final class C1056a implements InvocationHandler {
        private final IBinder bWf;
        private final Object bWg;

        C1056a(IBinder iBinder, Object obj) {
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

    /* renamed from: com.tencent.matrix.a.c.b$b */
    public interface C1057b {
        /* renamed from: b */
        void mo4170b(Method method, Object[] objArr);
    }

    /* renamed from: com.tencent.matrix.a.c.b$c */
    static class C1058c implements InvocationHandler {
        final Object bWh;
        final C1057b bWi;

        C1058c(Object obj, C1057b c1057b) {
            this.bWh = obj;
            this.bWi = c1057b;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (this.bWi != null) {
                this.bWi.mo4170b(method, objArr);
            }
            return method.invoke(this.bWh, objArr);
        }
    }

    public C1059b(String str, String str2, C1057b c1057b) {
        this.bWb = str;
        this.bWc = str2;
        this.bWd = c1057b;
    }

    public final boolean doHook() {
        C1070c.m2368i("Matrix.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", this.bWb, this.bWc);
        try {
            Class cls = Class.forName("android.os.ServiceManager");
            this.bWe = (IBinder) cls.getDeclaredMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{this.bWb});
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                C1070c.m2367e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
                return false;
            }
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, new C1056a(this.bWe, m2336za()));
            Field declaredField = cls.getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.bWb, iBinder);
            return true;
        } catch (Throwable th) {
            C1070c.m2367e("Matrix.SystemServiceBinderHooker", "doHook exp : " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    public final boolean doUnHook() {
        if (this.bWe == null) {
            C1070c.m2368i("Matrix.SystemServiceBinderHooker", "doUnHook sOriginPowerManagerService null", new Object[0]);
            return false;
        }
        try {
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.bWb, this.bWe);
            return true;
        } catch (Throwable th) {
            C1070c.m2367e("Matrix.SystemServiceBinderHooker", "doUnHook exp : " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    /* renamed from: za */
    private Object m2336za() {
        try {
            Class cls = Class.forName(this.bWc);
            Class cls2 = Class.forName(String.format("%s$Stub", new Object[]{this.bWc}));
            Object invoke = cls2.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{this.bWe});
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                C1070c.m2367e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
                return Boolean.FALSE;
            }
            return Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new C1058c(invoke, this.bWd));
        } catch (Throwable th) {
            C1070c.m2370w("Matrix.SystemServiceBinderHooker", "createPowerManagerServiceProxy exp:%s", th.getLocalizedMessage());
            return null;
        }
    }
}
