package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gn */
public class C36512gn {
    /* renamed from: a */
    private static String[] f15372a = new String[0];

    /* renamed from: a */
    public static boolean m60419a() {
        AppMethodBeat.m2504i(99386);
        String str = Build.MODEL;
        for (String equalsIgnoreCase : f15372a) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                AppMethodBeat.m2505o(99386);
                return true;
            }
        }
        AppMethodBeat.m2505o(99386);
        return false;
    }
}
