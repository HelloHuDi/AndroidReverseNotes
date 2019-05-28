package com.tencent.p127d.p130d.p131b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p135f.C45085h;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.tencent.d.d.b.e */
public final class C17727e {
    /* renamed from: c */
    private static Field m27653c(Class<?> cls, String str) {
        AppMethodBeat.m2504i(114526);
        if (cls == null) {
            AppMethodBeat.m2505o(114526);
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField == null) {
                AppMethodBeat.m2505o(114526);
                return null;
            }
            declaredField.setAccessible(true);
            AppMethodBeat.m2505o(114526);
            return declaredField;
        } catch (Throwable th) {
            C45085h.m82713w(th);
            AppMethodBeat.m2505o(114526);
            return null;
        }
    }

    private static Class<?> atT(String str) {
        Class<?> cls;
        AppMethodBeat.m2504i(114527);
        try {
            cls = Class.forName(str);
        } catch (Throwable th) {
            C45085h.m82713w(th);
            AppMethodBeat.m2505o(114527);
            return null;
        }
        if (cls == null) {
            AppMethodBeat.m2505o(114527);
            return null;
        }
        AppMethodBeat.m2505o(114527);
        return cls;
    }

    /* renamed from: a */
    public static Object m27650a(Class<?> cls, String str, Object obj) {
        Object obj2 = null;
        AppMethodBeat.m2504i(114528);
        try {
            Field c = C17727e.m27653c(cls, str);
            if (c == null) {
                AppMethodBeat.m2505o(114528);
            } else {
                obj2 = c.get(obj);
                AppMethodBeat.m2505o(114528);
            }
        } catch (Throwable th) {
            C45085h.m82713w(th);
            AppMethodBeat.m2505o(114528);
        }
        return obj2;
    }

    /* renamed from: iB */
    public static Object m27654iB(String str, String str2) {
        Object obj = null;
        AppMethodBeat.m2504i(114529);
        try {
            obj = C17727e.m27650a(C17727e.atT(str), str2, null);
            AppMethodBeat.m2505o(114529);
        } catch (Throwable th) {
            C45085h.m82713w(th);
            AppMethodBeat.m2505o(114529);
        }
        return obj;
    }

    /* renamed from: b */
    private static Method m27652b(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.m2504i(114530);
        if (cls != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    if (declaredMethod == null) {
                        AppMethodBeat.m2505o(114530);
                        return null;
                    }
                    declaredMethod.setAccessible(true);
                    AppMethodBeat.m2505o(114530);
                    return declaredMethod;
                }
            } catch (Throwable th) {
                C45085h.m82713w(th);
                AppMethodBeat.m2505o(114530);
                return null;
            }
        }
        AppMethodBeat.m2505o(114530);
        return null;
    }

    /* renamed from: a */
    public static Method m27651a(String str, String str2, Class<?>... clsArr) {
        AppMethodBeat.m2504i(114531);
        try {
            Method b = C17727e.m27652b(C17727e.atT(str), str2, clsArr);
            AppMethodBeat.m2505o(114531);
            return b;
        } catch (Throwable th) {
            C45085h.m82713w(th);
            AppMethodBeat.m2505o(114531);
            return null;
        }
    }
}
