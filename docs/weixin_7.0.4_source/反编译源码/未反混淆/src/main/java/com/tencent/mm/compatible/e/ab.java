package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class ab {
    private static Class<?> aIl;
    private static Method eug;
    private static Method euh;

    static {
        AppMethodBeat.i(93021);
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
            AppMethodBeat.o(93021);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
            AppMethodBeat.o(93021);
        }
    }

    public static String get(String str) {
        AppMethodBeat.i(93020);
        try {
            String str2 = (String) eug.invoke(null, new Object[]{str});
            AppMethodBeat.o(93020);
            return str2;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
            AppMethodBeat.o(93020);
            return null;
        }
    }
}
