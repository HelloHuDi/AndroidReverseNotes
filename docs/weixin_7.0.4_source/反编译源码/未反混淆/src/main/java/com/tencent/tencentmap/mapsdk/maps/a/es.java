package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class es {
    private static boolean a = true;
    private static boolean b = true;

    public static void a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        AppMethodBeat.i(98825);
        bx.a(str, i, i2, str2, map, map2, z, 1);
        AppMethodBeat.o(98825);
    }

    public static boolean a(String str, int i, Map<String, String> map) {
        boolean z;
        AppMethodBeat.i(98827);
        if (i == bt.c()) {
            if (a && ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str))) {
                a = false;
                z = true;
                AppMethodBeat.o(98827);
                return z;
            } else if (b && "HLHttpDirect".equals(str)) {
                String str2 = (String) map.get("B15");
                if (!eu.a(str2) && str2.equals("app")) {
                    b = false;
                    z = true;
                    AppMethodBeat.o(98827);
                    return z;
                }
            }
        }
        z = false;
        AppMethodBeat.o(98827);
        return z;
    }

    public static void b(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        AppMethodBeat.i(98826);
        bx.a(str, i, i2, str2, map, map2, z);
        AppMethodBeat.o(98826);
    }
}
