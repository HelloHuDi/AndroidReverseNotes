package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r {
    public static String Ei(String str) {
        AppMethodBeat.i(91185);
        if (str == null) {
            AppMethodBeat.o(91185);
            return null;
        }
        String replace = str.replace(8232, 10).replace(8233, 10);
        AppMethodBeat.o(91185);
        return replace;
    }

    public static boolean t(String str, String str2) {
        AppMethodBeat.i(91186);
        if (str == null || str.length() < 0 || str2.length() < 0) {
            AppMethodBeat.o(91186);
            return false;
        } else if (str2.length() > str.length()) {
            AppMethodBeat.o(91186);
            return false;
        } else if (str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            AppMethodBeat.o(91186);
            return true;
        } else {
            AppMethodBeat.o(91186);
            return false;
        }
    }
}
