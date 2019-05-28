package com.tencent.p177mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C29879l.C14591b;

/* renamed from: com.tencent.mm.plugin.webview.luggage.s */
public final class C29809s {
    public static int ujF;
    public static C14591b ujG;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.s$1 */
    public static class C228711 implements C14591b {
        public final void cXm() {
            AppMethodBeat.m2504i(6238);
            ToolsProcessIPCService.m63913a(null, C29810a.class, null);
            AppMethodBeat.m2505o(6238);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.s$a */
    static class C29810a implements C37866a {
        private C29810a() {
        }

        /* renamed from: a */
        public final void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(6239);
            C22868m.remove(C29809s.ujF);
            AppMethodBeat.m2505o(6239);
        }
    }
}
