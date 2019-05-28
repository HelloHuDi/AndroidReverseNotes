package com.tencent.p177mm.compatible.p221e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.compatible.e.ab */
public final class C1414ab {
    private static Class<?> aIl;
    private static Method eug;
    private static Method euh;

    static {
        AppMethodBeat.m2504i(93021);
        aIl = null;
        eug = null;
        euh = null;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            aIl = cls;
            eug = cls.getDeclaredMethod("get", new Class[]{String.class});
            euh = aIl.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            eug.setAccessible(true);
            euh.setAccessible(true);
            AppMethodBeat.m2505o(93021);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
            AppMethodBeat.m2505o(93021);
        }
    }

    public static String get(String str) {
        AppMethodBeat.m2504i(93020);
        try {
            String str2 = (String) eug.invoke(null, new Object[]{str});
            AppMethodBeat.m2505o(93020);
            return str2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
            AppMethodBeat.m2505o(93020);
            return null;
        }
    }
}
