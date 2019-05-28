package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

/* renamed from: com.tencent.mm.sdk.platformtools.bk */
public final class C5040bk {
    private static final HashMap<String, String> xBO = new HashMap();

    static {
        AppMethodBeat.m2504i(52280);
        AppMethodBeat.m2505o(52280);
    }

    public static String getProperty(String str) {
        AppMethodBeat.m2504i(52278);
        String str2 = (String) xBO.get(str);
        AppMethodBeat.m2505o(52278);
        return str2;
    }

    public static void setProperty(String str, String str2) {
        AppMethodBeat.m2504i(52279);
        xBO.put(str, str2);
        AppMethodBeat.m2505o(52279);
    }
}
