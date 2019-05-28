package com.tencent.p177mm.plugin.normsg.p474b;

import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.normsg.b.h */
public final class C43351h {
    private static final LruCache<String, LruCache<String, Field>> oVj = new LruCache(50);
    private static final LruCache<String, LruCache<String, Method>> oVk = new LruCache(50);
    private static final LruCache<String, LruCache<String, Constructor<?>>> oVl = new LruCache(50);

    /* renamed from: com.tencent.mm.plugin.normsg.b.h$a */
    public static class C21395a extends RuntimeException {
        C21395a(Throwable th) {
            super(th);
        }
    }

    static {
        AppMethodBeat.m2504i(10452);
        AppMethodBeat.m2505o(10452);
    }

    public static Class<?> findClass(String str) {
        AppMethodBeat.m2504i(10442);
        try {
            Class cls = Class.forName(str);
            AppMethodBeat.m2505o(10442);
            return cls;
        } catch (Throwable th) {
            C21395a c21395a = new C21395a(th);
            AppMethodBeat.m2505o(10442);
        }
    }

    /* renamed from: f */
    public static <T> T m77372f(Object obj, String str) {
        AppMethodBeat.m2504i(10443);
        try {
            Object obj2 = C43351h.m77369b(obj.getClass(), str).get(obj);
            AppMethodBeat.m2505o(10443);
            return obj2;
        } catch (Throwable th) {
            C21395a c21395a = new C21395a(th);
            AppMethodBeat.m2505o(10443);
        }
    }

    /* renamed from: fx */
    public static <T> T m77373fx(String str, String str2) {
        AppMethodBeat.m2504i(10444);
        Object a = C43351h.m77364a(C43351h.findClass(str), str2);
        AppMethodBeat.m2505o(10444);
        return a;
    }

    /* renamed from: a */
    private static <T> T m77364a(Class<?> cls, String str) {
        AppMethodBeat.m2504i(10445);
        try {
            Object obj = C43351h.m77369b(cls, str).get(null);
            AppMethodBeat.m2505o(10445);
            return obj;
        } catch (Throwable th) {
            C21395a c21395a = new C21395a(th);
            AppMethodBeat.m2505o(10445);
        }
    }

    /* renamed from: b */
    public static <T> void m77370b(Object obj, String str, T t) {
        AppMethodBeat.m2504i(10446);
        try {
            C43351h.m77369b(obj.getClass(), str).set(obj, t);
            AppMethodBeat.m2505o(10446);
        } catch (Throwable th) {
            C21395a c21395a = new C21395a(th);
            AppMethodBeat.m2505o(10446);
        }
    }

    /* renamed from: b */
    public static <T> T m77368b(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.m2504i(10447);
        try {
            Object invoke = C43351h.m77366a(obj.getClass(), str, clsArr).invoke(obj, objArr);
            AppMethodBeat.m2505o(10447);
            return invoke;
        } catch (Throwable th) {
            C21395a c21395a = new C21395a(th);
            AppMethodBeat.m2505o(10447);
        }
    }

    /* renamed from: a */
    public static <T> T m77365a(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.m2504i(10448);
        Object b = C43351h.m77367b(C43351h.findClass(str), str2, (Class[]) clsArr, objArr);
        AppMethodBeat.m2505o(10448);
        return b;
    }

    /* renamed from: b */
    public static <T> T m77367b(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.m2504i(10449);
        try {
            Object invoke = C43351h.m77366a(cls, str, clsArr).invoke(null, objArr);
            AppMethodBeat.m2505o(10449);
            return invoke;
        } catch (Throwable th) {
            C21395a c21395a = new C21395a(th);
            AppMethodBeat.m2505o(10449);
        }
    }

    /* renamed from: b */
    public static Class<?>[] m77371b(Class<?>... clsArr) {
        return clsArr;
    }

    /* renamed from: b */
    private static Field m77369b(Class<?> cls, String str) {
        LruCache lruCache;
        AppMethodBeat.m2504i(10450);
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
            AppMethodBeat.m2505o(10450);
        } else {
            while (true) {
                Class cls2;
                try {
                    field = cls2.getDeclaredField(str);
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    lruCache.put(str, field);
                    AppMethodBeat.m2505o(10450);
                } catch (Throwable th) {
                    if (cls2.getSuperclass() == null || cls2 == Object.class) {
                        AppMethodBeat.m2505o(10450);
                    } else {
                        cls2 = cls2.getSuperclass();
                    }
                }
            }
            AppMethodBeat.m2505o(10450);
        }
        return field;
    }

    /* renamed from: a */
    private static Method m77366a(Class<?> cls, String str, Class<?>... clsArr) {
        LruCache lruCache;
        AppMethodBeat.m2504i(10451);
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
            AppMethodBeat.m2505o(10451);
        } else {
            while (true) {
                Class cls2;
                try {
                    method = cls2.getDeclaredMethod(str, clsArr);
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    lruCache.put(str2, method);
                    AppMethodBeat.m2505o(10451);
                } catch (Throwable th) {
                    if (cls2.getSuperclass() == null || cls2 == Object.class) {
                        AppMethodBeat.m2505o(10451);
                    } else {
                        cls2 = cls2.getSuperclass();
                    }
                }
            }
        }
        return method;
    }
}
