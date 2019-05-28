package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.webview.p1326d.C22783a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.o */
public final class C29970o {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.o$a */
    static final class C14706a implements C37866a<IPCInteger, IPCVoid> {
        private C14706a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(80451);
            C4990ab.m7417i("MicroMsg.WebViewBagService", "ipc invoke:%d", Integer.valueOf(((IPCInteger) obj).value));
            C29970o.m47416JU(r0);
            AppMethodBeat.m2505o(80451);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.o$1 */
    static class C299711 implements C18507c<IPCVoid> {
        C299711() {
        }

        /* renamed from: ao */
        public final /* bridge */ /* synthetic */ void mo5960ao(Object obj) {
        }
    }

    /* renamed from: JU */
    static void m47416JU(int i) {
        AppMethodBeat.m2504i(80452);
        switch (i) {
            case 1:
                if (C1720g.m3528K(C22783a.class) != null) {
                    ((C22783a) C1720g.m3528K(C22783a.class)).cYT();
                    AppMethodBeat.m2505o(80452);
                    return;
                }
                C4990ab.m7412e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
                AppMethodBeat.m2505o(80452);
                return;
            case 2:
                if (C1720g.m3528K(C22783a.class) == null) {
                    C4990ab.m7412e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
                    break;
                }
                ((C22783a) C1720g.m3528K(C22783a.class)).cYU();
                AppMethodBeat.m2505o(80452);
                return;
        }
        AppMethodBeat.m2505o(80452);
    }

    /* renamed from: JV */
    public static void m47417JV(int i) {
        AppMethodBeat.m2504i(80453);
        if (C4996ah.bqo()) {
            C4990ab.m7417i("MicroMsg.WebViewBagService", "in mm process op:%d", Integer.valueOf(i));
            C29970o.m47416JU(i);
            AppMethodBeat.m2505o(80453);
            return;
        }
        XIPCInvoker.m83629a("com.tencent.mm", new IPCInteger(i), C14706a.class, new C299711());
        AppMethodBeat.m2505o(80453);
    }
}
