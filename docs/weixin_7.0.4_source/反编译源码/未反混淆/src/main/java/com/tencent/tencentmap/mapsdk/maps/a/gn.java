package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class gn {
    private static String[] a = new String[0];

    public static boolean a() {
        AppMethodBeat.i(99386);
        String str = Build.MODEL;
        for (String equalsIgnoreCase : a) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                AppMethodBeat.o(99386);
                return true;
            }
        }
        AppMethodBeat.o(99386);
        return false;
    }
}
