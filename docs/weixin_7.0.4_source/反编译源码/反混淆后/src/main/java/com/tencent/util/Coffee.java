package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Coffee {
    private static native String getDESSignKey();

    public static String dSI() {
        AppMethodBeat.m2504i(86576);
        String dESSignKey = getDESSignKey();
        AppMethodBeat.m2505o(86576);
        return dESSignKey;
    }
}
