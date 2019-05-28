package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.es */
public final class C24371es {
    /* renamed from: a */
    private static boolean f4679a = true;
    /* renamed from: b */
    private static boolean f4680b = true;

    /* renamed from: a */
    public static void m37717a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        AppMethodBeat.m2504i(98825);
        C31027bx.m49843a(str, i, i2, str2, map, map2, z, 1);
        AppMethodBeat.m2505o(98825);
    }

    /* renamed from: a */
    public static boolean m37718a(String str, int i, Map<String, String> map) {
        boolean z;
        AppMethodBeat.m2504i(98827);
        if (i == C46772bt.m88739c()) {
            if (f4679a && ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str))) {
                f4679a = false;
                z = true;
                AppMethodBeat.m2505o(98827);
                return z;
            } else if (f4680b && "HLHttpDirect".equals(str)) {
                String str2 = (String) map.get("B15");
                if (!C24373eu.m37738a(str2) && str2.equals("app")) {
                    f4680b = false;
                    z = true;
                    AppMethodBeat.m2505o(98827);
                    return z;
                }
            }
        }
        z = false;
        AppMethodBeat.m2505o(98827);
        return z;
    }

    /* renamed from: b */
    public static void m37719b(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        AppMethodBeat.m2504i(98826);
        C31027bx.m49842a(str, i, i2, str2, map, map2, z);
        AppMethodBeat.m2505o(98826);
    }
}
