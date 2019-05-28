package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.bo;

public final class k {
    public static void agC(String str) {
        AppMethodBeat.i(9839);
        if (!bo.isNullOrNil(str) && str.startsWith("http")) {
            o.ahk().a(str, null);
        }
        AppMethodBeat.o(9839);
    }
}
