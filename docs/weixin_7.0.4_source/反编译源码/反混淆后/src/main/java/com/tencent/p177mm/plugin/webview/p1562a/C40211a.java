package com.tencent.p177mm.plugin.webview.p1562a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.C23244m;
import com.tencent.p177mm.pluginsdk.C23255n;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.sdk.p604g.C7305d;

/* renamed from: com.tencent.mm.plugin.webview.a.a */
public final class C40211a implements C23256o {
    public static C23255n gkE;
    public static C23244m gkF;

    /* renamed from: a */
    public final void mo7223a(C23255n c23255n) {
        gkE = c23255n;
    }

    /* renamed from: a */
    public final void mo7222a(C23244m c23244m) {
        gkF = c23244m;
    }

    /* renamed from: R */
    public static void m68966R(Runnable runnable) {
        AppMethodBeat.m2504i(5622);
        String str = "WebViewWorkerThread";
        if (0 > 0) {
            C7305d.xDG.mo10152b(runnable, str, 0);
            AppMethodBeat.m2505o(5622);
            return;
        }
        C7305d.xDG.mo10151b(runnable, str);
        AppMethodBeat.m2505o(5622);
    }
}
