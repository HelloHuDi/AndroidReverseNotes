package com.tencent.p177mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.tencent.mm.kernel.f */
public final class C1718f {
    private static volatile boolean eKg = false;

    /* renamed from: com.tencent.mm.kernel.f$a */
    static class C1716a implements InvocationHandler {
        public int level;

        private C1716a() {
            this.level = 0;
        }

        /* synthetic */ C1716a(byte b) {
            this();
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.m2504i(123247);
            Class returnType = method.getReturnType();
            Object valueOf;
            if (returnType.equals(Integer.TYPE)) {
                Integer valueOf2 = Integer.valueOf(0);
                AppMethodBeat.m2505o(123247);
                return valueOf2;
            } else if (returnType.equals(Long.TYPE)) {
                valueOf = Long.valueOf(0);
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else if (returnType.equals(Double.TYPE)) {
                valueOf = Double.valueOf(0.0d);
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else if (returnType.equals(Float.TYPE)) {
                valueOf = Float.valueOf(0.0f);
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else if (returnType.equals(Short.TYPE)) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else if (returnType.equals(Byte.TYPE)) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else if (returnType.equals(Character.TYPE)) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else if (returnType.equals(Boolean.TYPE)) {
                valueOf = Boolean.FALSE;
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else if (returnType.equals(Boolean.class)) {
                valueOf = Boolean.FALSE;
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else if (returnType.isInterface()) {
                valueOf = C1718f.m3527b(returnType, this.level + 1);
                AppMethodBeat.m2505o(123247);
                return valueOf;
            } else {
                AppMethodBeat.m2505o(123247);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.kernel.f$b */
    interface C1717b {
    }

    /* renamed from: b */
    static /* synthetic */ Object m3527b(Class cls, int i) {
        AppMethodBeat.m2504i(123250);
        Object a = C1718f.m3525a(cls, i);
        AppMethodBeat.m2505o(123250);
        return a;
    }

    /* renamed from: ay */
    public static boolean m3526ay(Object obj) {
        if (obj instanceof C1717b) {
            return true;
        }
        return false;
    }

    /* renamed from: P */
    public static <T> T m3524P(Class<T> cls) {
        AppMethodBeat.m2504i(123248);
        if (eKg) {
            T a = C1718f.m3525a(cls, 0);
            AppMethodBeat.m2505o(123248);
            return a;
        }
        AppMethodBeat.m2505o(123248);
        return null;
    }

    /* renamed from: a */
    private static <T> T m3525a(Class<T> cls, int i) {
        AppMethodBeat.m2504i(123249);
        if (!eKg) {
            AppMethodBeat.m2505o(123249);
            return null;
        } else if (i > 3) {
            C1736j.m3585e("MMSkeleton.DummyMode", "dummy level > 3, return null.", new Object[0]);
            AppMethodBeat.m2505o(123249);
            return null;
        } else if (cls.isInterface()) {
            try {
                C1716a c1716a = new C1716a();
                c1716a.level = i;
                C1736j.m3587i("MMSkeleton.DummyMode", "dummy instance(%s) for class(%s), dummy level %s", Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls, C1717b.class}, c1716a), cls, Integer.valueOf(i));
                AppMethodBeat.m2505o(123249);
                return r1;
            } catch (Throwable th) {
                C1736j.printErrStackTrace("MMSkeleton.DummyMode", th, "", new Object[0]);
                AppMethodBeat.m2505o(123249);
                return null;
            }
        } else {
            AppMethodBeat.m2505o(123249);
            return null;
        }
    }
}
