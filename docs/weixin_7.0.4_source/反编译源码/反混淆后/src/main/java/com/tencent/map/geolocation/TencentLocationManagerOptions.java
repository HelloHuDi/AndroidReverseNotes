package com.tencent.map.geolocation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationManagerOptions {
    /* renamed from: a */
    private static boolean f14971a = true;
    /* renamed from: b */
    private static String f14972b = "";

    public static void setLoadLibraryEnabled(boolean z) {
        f14971a = z;
    }

    public static boolean isLoadLibraryEnabled() {
        return f14971a;
    }

    public static boolean setKey(String str) {
        AppMethodBeat.m2504i(136468);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(136468);
            return false;
        }
        f14972b = str;
        AppMethodBeat.m2505o(136468);
        return true;
    }

    public static String getKey() {
        return f14972b;
    }
}
