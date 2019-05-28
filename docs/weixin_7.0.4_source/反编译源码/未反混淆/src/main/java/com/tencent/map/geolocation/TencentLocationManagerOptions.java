package com.tencent.map.geolocation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationManagerOptions {
    private static boolean a = true;
    private static String b = "";

    public static void setLoadLibraryEnabled(boolean z) {
        a = z;
    }

    public static boolean isLoadLibraryEnabled() {
        return a;
    }

    public static boolean setKey(String str) {
        AppMethodBeat.i(136468);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(136468);
            return false;
        }
        b = str;
        AppMethodBeat.o(136468);
        return true;
    }

    public static String getKey() {
        return b;
    }
}
