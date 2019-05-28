package com.tencent.d.d.b;

import android.text.TextUtils;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class e {
    private static Field c(Class<?> cls, String str) {
        AppMethodBeat.i(114526);
        if (cls == null) {
            AppMethodBeat.o(114526);
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField == null) {
                AppMethodBeat.o(114526);
                return null;
            }
            declaredField.setAccessible(true);
            AppMethodBeat.o(114526);
            return declaredField;
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(114526);
            return null;
        }
    }

    private static Class<?> atT(String str) {
        Class<?> cls;
        AppMethodBeat.i(114527);
        try {
            cls = Class.forName(str);
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(114527);
            return null;
        }
        if (cls == null) {
            AppMethodBeat.o(114527);
            return null;
        }
        AppMethodBeat.o(114527);
        return cls;
    }

    public static Object a(Class<?> cls, String str, Object obj) {
        Object obj2 = null;
        AppMethodBeat.i(114528);
        try {
            Field c = c(cls, str);
            if (c == null) {
                AppMethodBeat.o(114528);
            } else {
                obj2 = c.get(obj);
                AppMethodBeat.o(114528);
            }
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(114528);
        }
        return obj2;
    }

    public static Object iB(String str, String str2) {
        Object obj = null;
        AppMethodBeat.i(114529);
        try {
            obj = a(atT(str), str2, null);
            AppMethodBeat.o(114529);
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(114529);
        }
        return obj;
    }

    private static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(114530);
        if (cls != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    if (declaredMethod == null) {
                        AppMethodBeat.o(114530);
                        return null;
                    }
                    declaredMethod.setAccessible(true);
                    AppMethodBeat.o(114530);
                    return declaredMethod;
                }
            } catch (Throwable th) {
                h.w(th);
                AppMethodBeat.o(114530);
                return null;
            }
        }
        AppMethodBeat.o(114530);
        return null;
    }

    public static Method a(String str, String str2, Class<?>... clsArr) {
        AppMethodBeat.i(114531);
        try {
            Method b = b(atT(str), str2, clsArr);
            AppMethodBeat.o(114531);
            return b;
        } catch (Throwable th) {
            h.w(th);
            AppMethodBeat.o(114531);
            return null;
        }
    }
}
