package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Method;

public final class l {
    public static Object a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr) {
        AppMethodBeat.i(91170);
        Object a = a(cls, str, obj, clsArr, objArr, null);
        AppMethodBeat.o(91170);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A:{Splitter:B:6:0x001b, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0031, code skipped:
            r1.getSuperclass();
            com.tencent.matrix.trace.core.AppMethodBeat.o(91171);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr, T t) {
        AppMethodBeat.i(91171);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("instance cannot be null");
            AppMethodBeat.o(91171);
            throw illegalArgumentException;
        }
        Method method = null;
        Class<?> cls2 = obj.getClass();
        while (cls2 != null) {
            try {
                method = cls2.getDeclaredMethod(str, clsArr);
                cls2 = cls2.getSuperclass();
            } catch (Exception e) {
                if (cls == cls2) {
                    method = cls2.getDeclaredMethod(str, clsArr);
                }
                cls2 = cls2.getSuperclass();
            } catch (Throwable th) {
            }
        }
        if (method == null) {
            AppMethodBeat.o(91171);
        } else {
            try {
                method.setAccessible(true);
                t = method.invoke(obj, objArr);
                AppMethodBeat.o(91171);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.ReflectUtil", e2, "", new Object[0]);
                AppMethodBeat.o(91171);
            }
        }
        return t;
    }

    public static <T> T a(String str, Object obj, Class<?>[] clsArr, Object[] objArr) {
        AppMethodBeat.i(91172);
        Object a = a(null, str, obj, clsArr, objArr, null);
        AppMethodBeat.o(91172);
        return a;
    }
}
