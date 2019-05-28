package com.tencent.p177mm.plugin.appbrand.p328r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.plugin.appbrand.r.l */
public final class C38495l {
    /* renamed from: a */
    public static Object m65145a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr) {
        AppMethodBeat.m2504i(91170);
        Object a = C38495l.m65146a(cls, str, obj, clsArr, objArr, null);
        AppMethodBeat.m2505o(91170);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A:{Splitter:B:6:0x001b, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0031, code skipped:
            r1.getSuperclass();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(91171);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static <T> T m65146a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr, T t) {
        AppMethodBeat.m2504i(91171);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("instance cannot be null");
            AppMethodBeat.m2505o(91171);
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
            AppMethodBeat.m2505o(91171);
        } else {
            try {
                method.setAccessible(true);
                t = method.invoke(obj, objArr);
                AppMethodBeat.m2505o(91171);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.ReflectUtil", e2, "", new Object[0]);
                AppMethodBeat.m2505o(91171);
            }
        }
        return t;
    }

    /* renamed from: a */
    public static <T> T m65147a(String str, Object obj, Class<?>[] clsArr, Object[] objArr) {
        AppMethodBeat.m2504i(91172);
        Object a = C38495l.m65146a(null, str, obj, clsArr, objArr, null);
        AppMethodBeat.m2505o(91172);
        return a;
    }
}
