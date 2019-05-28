package com.tencent.p177mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.appbrand.report.g */
public enum C42671g {
    X5,
    Sys,
    XWalk,
    Invalid;

    static {
        AppMethodBeat.m2505o(132568);
    }

    public static C42671g aLe() {
        AppMethodBeat.m2504i(132567);
        boolean isSys = WebView.isSys();
        boolean isXWalk = WebView.isXWalk();
        boolean isX5 = WebView.isX5();
        C42671g c42671g;
        if ((!isSys || isXWalk || isX5) && ((isSys || !isXWalk || isX5) && (isSys || isXWalk || !isX5))) {
            if (C5058f.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("WebViewType invalid");
                AppMethodBeat.m2505o(132567);
                throw illegalStateException;
            }
            c42671g = Invalid;
            AppMethodBeat.m2505o(132567);
            return c42671g;
        } else if (isX5) {
            c42671g = X5;
            AppMethodBeat.m2505o(132567);
            return c42671g;
        } else if (isXWalk) {
            c42671g = XWalk;
            AppMethodBeat.m2505o(132567);
            return c42671g;
        } else {
            c42671g = Sys;
            AppMethodBeat.m2505o(132567);
            return c42671g;
        }
    }
}
