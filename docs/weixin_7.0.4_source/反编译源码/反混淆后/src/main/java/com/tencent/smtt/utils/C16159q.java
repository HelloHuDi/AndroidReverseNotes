package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

/* renamed from: com.tencent.smtt.utils.q */
public class C16159q {
    /* renamed from: a */
    private static Class f3055a;
    /* renamed from: b */
    private static Method f3056b;

    static {
        AppMethodBeat.m2504i(65285);
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            f3055a = cls;
            f3056b = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
            AppMethodBeat.m2505o(65285);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(65285);
        }
    }

    /* renamed from: a */
    public static String m24514a(String str, String str2) {
        AppMethodBeat.m2504i(65283);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(65283);
            return str2;
        }
        str2 = C16159q.m24515b(str, str2);
        AppMethodBeat.m2505o(65283);
        return str2;
    }

    /* renamed from: b */
    private static String m24515b(String str, String str2) {
        AppMethodBeat.m2504i(65284);
        if (f3055a == null || f3056b == null) {
            AppMethodBeat.m2505o(65284);
            return str2;
        }
        String str3;
        try {
            str3 = (String) f3056b.invoke(f3055a, new Object[]{str, str2});
        } catch (Throwable th) {
            str3 = str2;
        }
        AppMethodBeat.m2505o(65284);
        return str3;
    }
}
