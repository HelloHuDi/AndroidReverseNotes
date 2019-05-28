package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.xweb.WebView;

public enum g {
    X5,
    Sys,
    XWalk,
    Invalid;

    static {
        AppMethodBeat.o(132568);
    }

    public static g aLe() {
        AppMethodBeat.i(132567);
        boolean isSys = WebView.isSys();
        boolean isXWalk = WebView.isXWalk();
        boolean isX5 = WebView.isX5();
        g gVar;
        if ((!isSys || isXWalk || isX5) && ((isSys || !isXWalk || isX5) && (isSys || isXWalk || !isX5))) {
            if (f.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("WebViewType invalid");
                AppMethodBeat.o(132567);
                throw illegalStateException;
            }
            gVar = Invalid;
            AppMethodBeat.o(132567);
            return gVar;
        } else if (isX5) {
            gVar = X5;
            AppMethodBeat.o(132567);
            return gVar;
        } else if (isXWalk) {
            gVar = XWalk;
            AppMethodBeat.o(132567);
            return gVar;
        } else {
            gVar = Sys;
            AppMethodBeat.o(132567);
            return gVar;
        }
    }
}
