package com.tencent.mm.plugin.normsg.b;

import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public final class h {
    private static final LruCache<String, LruCache<String, Field>> oVj = new LruCache(50);
    private static final LruCache<String, LruCache<String, Method>> oVk = new LruCache(50);
    private static final LruCache<String, LruCache<String, Constructor<?>>> oVl = new LruCache(50);

    public static class a extends RuntimeException {
        a(Throwable th) {
            super(th);
        }
    }

    static {
        AppMethodBeat.i(10452);
        AppMethodBeat.o(10452);
    }

    public static Class<?> findClass(String str) {
        AppMethodBeat.i(10442);
        try {
            Class cls = Class.forName(str);
            AppMethodBeat.o(10442);
            return cls;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(10442);
        }
    }

    public static <T> T f(Object obj, String str) {
        AppMethodBeat.i(10443);
        try {
            Object obj2 = b(obj.getClass(), str).get(obj);
            AppMethodBeat.o(10443);
            return obj2;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(10443);
        }
    }

    public static <T> T fx(String str, String str2) {
        AppMethodBeat.i(10444);
        Object a = a(findClass(str), str2);
        AppMethodBeat.o(10444);
        return a;
    }

    private static <T> T a(Class<?> cls, String str) {
        AppMethodBeat.i(10445);
        try {
            Object obj = b(cls, str).get(null);
            AppMethodBeat.o(10445);
            return obj;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(10445);
        }
    }

    public static <T> void b(Object obj, String str, T t) {
        AppMethodBeat.i(10446);
        try {
            b(obj.getClass(), str).set(obj, t);
            AppMethodBeat.o(10446);
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(10446);
        }
    }

    public static <T> T b(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(10447);
        try {
            Object invoke = a(obj.getClass(), str, clsArr).invoke(obj, objArr);
            AppMethodBeat.o(10447);
            return invoke;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(10447);
        }
    }

    public static <T> T a(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(10448);
        Object b = b(findClass(str), str2, (Class[]) clsArr, objArr);
        AppMethodBeat.o(10448);
        return b;
    }

    public static <T> T b(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(10449);
        try {
            Object invoke = a(cls, str, clsArr).invoke(null, objArr);
            AppMethodBeat.o(10449);
            return invoke;
        } catch (Throwable th) {
            a aVar = new a(th);
            AppMethodBeat.o(10449);
        }
    }

    public static Class<?>[] b(Class<?>... clsArr) {
        return clsArr;
    }

    private static Field b(Class<?> cls, String str) {
        LruCache lruCache;
        AppMethodBeat.i(10450);
        LruCache lruCache2 = (LruCache) oVj.get(cls.getName());
        if (lruCache2 == null) {
            lruCache2 = new LruCache(30);
            oVj.put(cls.getName(), lruCache2);
            lruCache = lruCache2;
        } else {
            lruCache = lruCache2;
        }
        Field field = (Field) lruCache.get(str);
        if (field != null) {
            AppMethodBeat.o(10450);
        } else {
            while (true) {
                Class cls2;
                try {
                    field = cls2.getDeclaredField(str);
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    lruCache.put(str, field);
                    AppMethodBeat.o(10450);
                } catch (Throwable th) {
                    if (cls2.getSuperclass() == null || cls2 == Object.class) {
                        AppMethodBeat.o(10450);
                    } else {
                        cls2 = cls2.getSuperclass();
                    }
                }
            }
            AppMethodBeat.o(10450);
        }
        return field;
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        LruCache lruCache;
        AppMethodBeat.i(10451);
        LruCache lruCache2 = (LruCache) oVk.get(cls.getName());
        if (lruCache2 == null) {
            lruCache2 = new LruCache(30);
            oVk.put(cls.getName(), lruCache2);
            lruCache = lruCache2;
        } else {
            lruCache = lruCache2;
        }
        String str2 = str + "#" + (clsArr != null ? Arrays.toString(clsArr) : "[]");
        Method method = (Method) lruCache.get(str2);
        if (method != null) {
            AppMethodBeat.o(10451);
        } else {
            while (true) {
                Class cls2;
                try {
                    method = cls2.getDeclaredMethod(str, clsArr);
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    lruCache.put(str2, method);
                    AppMethodBeat.o(10451);
                } catch (Throwable th) {
                    if (cls2.getSuperclass() == null || cls2 == Object.class) {
                        AppMethodBeat.o(10451);
                    } else {
                        cls2 = cls2.getSuperclass();
                    }
                }
            }
        }
        return method;
    }
}
