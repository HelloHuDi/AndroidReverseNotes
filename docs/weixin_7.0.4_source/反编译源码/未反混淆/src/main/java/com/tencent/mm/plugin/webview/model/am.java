package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class am extends j<al> {
    public static final String[] fnj = new String[]{j.a(al.ccO, "WebviewLocalData")};

    static {
        AppMethodBeat.i(6738);
        AppMethodBeat.o(6738);
    }

    public am(e eVar) {
        super(eVar, al.ccO, "WebviewLocalData", null);
    }

    public static int au(String str, String str2, String str3) {
        AppMethodBeat.i(6737);
        int hashCode = (str + str2 + str3).hashCode();
        AppMethodBeat.o(6737);
        return hashCode;
    }
}
