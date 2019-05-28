package com.tencent.p177mm.ipcinvoker.p1384g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.tencent.mm.ipcinvoker.g.b */
public final class C26339b {
    /* renamed from: c */
    public static <T> T m41912c(String str, Class<?> cls) {
        T t = null;
        AppMethodBeat.m2504i(114120);
        if (str == null || str.length() == 0) {
            C26340b.m41916e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.m2505o(114120);
        } else if (cls == null) {
            C26340b.m41916e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
            AppMethodBeat.m2505o(114120);
        } else {
            try {
                Class cls2 = Class.forName(str);
                if (cls.isAssignableFrom(cls2)) {
                    Constructor declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    t = declaredConstructor.newInstance(new Object[0]);
                    AppMethodBeat.m2505o(114120);
                } else {
                    C26340b.m41916e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls, cls2);
                    AppMethodBeat.m2505o(114120);
                }
            } catch (ClassNotFoundException e) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e);
                AppMethodBeat.m2505o(114120);
                return t;
            } catch (IllegalAccessException e2) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.m2505o(114120);
                return t;
            } catch (InstantiationException e3) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.m2505o(114120);
                return t;
            } catch (NoSuchMethodException e4) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.m2505o(114120);
                return t;
            } catch (InvocationTargetException e5) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e5);
                AppMethodBeat.m2505o(114120);
                return t;
            }
        }
        return t;
    }

    /* renamed from: j */
    public static <T> T m41913j(Class<?> cls, Class<?> cls2) {
        T t = null;
        AppMethodBeat.m2504i(114121);
        if (cls == null) {
            C26340b.m41916e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.m2505o(114121);
        } else if (cls2 == null) {
            C26340b.m41916e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
            AppMethodBeat.m2505o(114121);
        } else {
            try {
                if (cls2.isAssignableFrom(cls)) {
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    t = declaredConstructor.newInstance(new Object[0]);
                    AppMethodBeat.m2505o(114121);
                } else {
                    C26340b.m41916e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls2, cls);
                    AppMethodBeat.m2505o(114121);
                }
            } catch (IllegalAccessException e) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e);
                AppMethodBeat.m2505o(114121);
                return t;
            } catch (InstantiationException e2) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.m2505o(114121);
                return t;
            } catch (NoSuchMethodException e3) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.m2505o(114121);
                return t;
            } catch (InvocationTargetException e4) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.m2505o(114121);
                return t;
            }
        }
        return t;
    }

    /* renamed from: H */
    public static <T> T m41911H(Class<?> cls) {
        T t = null;
        AppMethodBeat.m2504i(114122);
        if (cls == null) {
            C26340b.m41916e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.m2505o(114122);
        } else {
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                t = declaredConstructor.newInstance(new Object[0]);
                AppMethodBeat.m2505o(114122);
            } catch (IllegalAccessException e) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e);
                AppMethodBeat.m2505o(114122);
                return t;
            } catch (InstantiationException e2) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.m2505o(114122);
                return t;
            } catch (NoSuchMethodException e3) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.m2505o(114122);
                return t;
            } catch (InvocationTargetException e4) {
                C26340b.m41916e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.m2505o(114122);
                return t;
            }
        }
        return t;
    }
}
