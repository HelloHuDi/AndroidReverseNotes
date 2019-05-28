package com.tencent.mm.plugin.webview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.g.d;

public final class a implements o {
    public static n gkE;
    public static m gkF;

    public final void a(n nVar) {
        gkE = nVar;
    }

    public final void a(m mVar) {
        gkF = mVar;
    }

    public static void R(Runnable runnable) {
        AppMethodBeat.i(5622);
        String str = "WebViewWorkerThread";
        if (0 > 0) {
            d.xDG.b(runnable, str, 0);
            AppMethodBeat.o(5622);
            return;
        }
        d.xDG.b(runnable, str);
        AppMethodBeat.o(5622);
    }
}
