package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static boolean a(int i) {
        return i == 36 || i == 46;
    }

    public static boolean b(String str) {
        AppMethodBeat.i(128074);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(128074);
            return true;
        }
        AppMethodBeat.o(128074);
        return false;
    }

    public static int c(String str) {
        int i = 0;
        AppMethodBeat.i(128075);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                    AppMethodBeat.o(128075);
                    return i;
                }
            } catch (Exception e) {
                AppMethodBeat.o(128075);
            }
        }
        AppMethodBeat.o(128075);
        return i;
    }
}
