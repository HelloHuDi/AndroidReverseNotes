package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class bk {
    private static final HashMap<String, String> xBO = new HashMap();

    static {
        AppMethodBeat.i(52280);
        AppMethodBeat.o(52280);
    }

    public static String getProperty(String str) {
        AppMethodBeat.i(52278);
        String str2 = (String) xBO.get(str);
        AppMethodBeat.o(52278);
        return str2;
    }

    public static void setProperty(String str, String str2) {
        AppMethodBeat.i(52279);
        xBO.put(str, str2);
        AppMethodBeat.o(52279);
    }
}
