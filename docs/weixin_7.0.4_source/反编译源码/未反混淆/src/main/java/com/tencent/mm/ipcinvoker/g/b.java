package com.tencent.mm.ipcinvoker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class b {
    public static <T> T c(String str, Class<?> cls) {
        T t = null;
        AppMethodBeat.i(114120);
        if (str == null || str.length() == 0) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.o(114120);
        } else if (cls == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
            AppMethodBeat.o(114120);
        } else {
            try {
                Class cls2 = Class.forName(str);
                if (cls.isAssignableFrom(cls2)) {
                    Constructor declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    t = declaredConstructor.newInstance(new Object[0]);
                    AppMethodBeat.o(114120);
                } else {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls, cls2);
                    AppMethodBeat.o(114120);
                }
            } catch (ClassNotFoundException e) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e);
                AppMethodBeat.o(114120);
                return t;
            } catch (IllegalAccessException e2) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.o(114120);
                return t;
            } catch (InstantiationException e3) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.o(114120);
                return t;
            } catch (NoSuchMethodException e4) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.o(114120);
                return t;
            } catch (InvocationTargetException e5) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e5);
                AppMethodBeat.o(114120);
                return t;
            }
        }
        return t;
    }

    public static <T> T j(Class<?> cls, Class<?> cls2) {
        T t = null;
        AppMethodBeat.i(114121);
        if (cls == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.o(114121);
        } else if (cls2 == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, parent class is null.", new Object[0]);
            AppMethodBeat.o(114121);
        } else {
            try {
                if (cls2.isAssignableFrom(cls)) {
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    t = declaredConstructor.newInstance(new Object[0]);
                    AppMethodBeat.o(114121);
                } else {
                    com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "%s isAssignableFrom %s return false", cls2, cls);
                    AppMethodBeat.o(114121);
                }
            } catch (IllegalAccessException e) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e);
                AppMethodBeat.o(114121);
                return t;
            } catch (InstantiationException e2) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.o(114121);
                return t;
            } catch (NoSuchMethodException e3) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.o(114121);
                return t;
            } catch (InvocationTargetException e4) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.o(114121);
                return t;
            }
        }
        return t;
    }

    public static <T> T H(Class<?> cls) {
        T t = null;
        AppMethodBeat.i(114122);
        if (cls == null) {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "newInstance failed, class is null or nil.", new Object[0]);
            AppMethodBeat.o(114122);
        } else {
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                t = declaredConstructor.newInstance(new Object[0]);
                AppMethodBeat.o(114122);
            } catch (IllegalAccessException e) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e);
                AppMethodBeat.o(114122);
                return t;
            } catch (InstantiationException e2) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e2);
                AppMethodBeat.o(114122);
                return t;
            } catch (NoSuchMethodException e3) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e3);
                AppMethodBeat.o(114122);
                return t;
            } catch (InvocationTargetException e4) {
                com.tencent.mm.ipcinvoker.h.b.e("IPC.ReflectUtil", "reflect error : %s", e4);
                AppMethodBeat.o(114122);
                return t;
            }
        }
        return t;
    }
}
