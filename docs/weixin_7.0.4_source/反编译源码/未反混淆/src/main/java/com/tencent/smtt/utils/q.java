package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class q {
    private static Class a;
    private static Method b;

    static {
        AppMethodBeat.i(65285);
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            a = cls;
            b = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
            AppMethodBeat.o(65285);
        } catch (Throwable th) {
            AppMethodBeat.o(65285);
        }
    }

    public static String a(String str, String str2) {
        AppMethodBeat.i(65283);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(65283);
            return str2;
        }
        str2 = b(str, str2);
        AppMethodBeat.o(65283);
        return str2;
    }

    private static String b(String str, String str2) {
        AppMethodBeat.i(65284);
        if (a == null || b == null) {
            AppMethodBeat.o(65284);
            return str2;
        }
        String str3;
        try {
            str3 = (String) b.invoke(a, new Object[]{str, str2});
        } catch (Throwable th) {
            str3 = str2;
        }
        AppMethodBeat.o(65284);
        return str3;
    }
}
