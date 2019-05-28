package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class f {
    private static volatile boolean eKg = false;

    static class a implements InvocationHandler {
        public int level;

        private a() {
            this.level = 0;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(123247);
            Class returnType = method.getReturnType();
            Object valueOf;
            if (returnType.equals(Integer.TYPE)) {
                Integer valueOf2 = Integer.valueOf(0);
                AppMethodBeat.o(123247);
                return valueOf2;
            } else if (returnType.equals(Long.TYPE)) {
                valueOf = Long.valueOf(0);
                AppMethodBeat.o(123247);
                return valueOf;
            } else if (returnType.equals(Double.TYPE)) {
                valueOf = Double.valueOf(0.0d);
                AppMethodBeat.o(123247);
                return valueOf;
            } else if (returnType.equals(Float.TYPE)) {
                valueOf = Float.valueOf(0.0f);
                AppMethodBeat.o(123247);
                return valueOf;
            } else if (returnType.equals(Short.TYPE)) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.o(123247);
                return valueOf;
            } else if (returnType.equals(Byte.TYPE)) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.o(123247);
                return valueOf;
            } else if (returnType.equals(Character.TYPE)) {
                valueOf = Integer.valueOf(0);
                AppMethodBeat.o(123247);
                return valueOf;
            } else if (returnType.equals(Boolean.TYPE)) {
                valueOf = Boolean.FALSE;
                AppMethodBeat.o(123247);
                return valueOf;
            } else if (returnType.equals(Boolean.class)) {
                valueOf = Boolean.FALSE;
                AppMethodBeat.o(123247);
                return valueOf;
            } else if (returnType.isInterface()) {
                valueOf = f.b(returnType, this.level + 1);
                AppMethodBeat.o(123247);
                return valueOf;
            } else {
                AppMethodBeat.o(123247);
                return null;
            }
        }
    }

    interface b {
    }

    static /* synthetic */ Object b(Class cls, int i) {
        AppMethodBeat.i(123250);
        Object a = a(cls, i);
        AppMethodBeat.o(123250);
        return a;
    }

    public static boolean ay(Object obj) {
        if (obj instanceof b) {
            return true;
        }
        return false;
    }

    public static <T> T P(Class<T> cls) {
        AppMethodBeat.i(123248);
        if (eKg) {
            T a = a(cls, 0);
            AppMethodBeat.o(123248);
            return a;
        }
        AppMethodBeat.o(123248);
        return null;
    }

    private static <T> T a(Class<T> cls, int i) {
        AppMethodBeat.i(123249);
        if (!eKg) {
            AppMethodBeat.o(123249);
            return null;
        } else if (i > 3) {
            j.e("MMSkeleton.DummyMode", "dummy level > 3, return null.", new Object[0]);
            AppMethodBeat.o(123249);
            return null;
        } else if (cls.isInterface()) {
            try {
                a aVar = new a();
                aVar.level = i;
                j.i("MMSkeleton.DummyMode", "dummy instance(%s) for class(%s), dummy level %s", Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls, b.class}, aVar), cls, Integer.valueOf(i));
                AppMethodBeat.o(123249);
                return r1;
            } catch (Throwable th) {
                j.printErrStackTrace("MMSkeleton.DummyMode", th, "", new Object[0]);
                AppMethodBeat.o(123249);
                return null;
            }
        } else {
            AppMethodBeat.o(123249);
            return null;
        }
    }
}
