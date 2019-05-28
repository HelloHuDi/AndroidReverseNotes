package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class o {

    static final class a implements com.tencent.mm.ipcinvoker.a<IPCInteger, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(80451);
            ab.i("MicroMsg.WebViewBagService", "ipc invoke:%d", Integer.valueOf(((IPCInteger) obj).value));
            o.JU(r0);
            AppMethodBeat.o(80451);
        }
    }

    static void JU(int i) {
        AppMethodBeat.i(80452);
        switch (i) {
            case 1:
                if (g.K(com.tencent.mm.plugin.webview.d.a.class) != null) {
                    ((com.tencent.mm.plugin.webview.d.a) g.K(com.tencent.mm.plugin.webview.d.a.class)).cYT();
                    AppMethodBeat.o(80452);
                    return;
                }
                ab.e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
                AppMethodBeat.o(80452);
                return;
            case 2:
                if (g.K(com.tencent.mm.plugin.webview.d.a.class) == null) {
                    ab.e("MicroMsg.WebViewBagService", "doOp MMKernel.service(IWebViewBagService.class) null");
                    break;
                }
                ((com.tencent.mm.plugin.webview.d.a) g.K(com.tencent.mm.plugin.webview.d.a.class)).cYU();
                AppMethodBeat.o(80452);
                return;
        }
        AppMethodBeat.o(80452);
    }

    public static void JV(int i) {
        AppMethodBeat.i(80453);
        if (ah.bqo()) {
            ab.i("MicroMsg.WebViewBagService", "in mm process op:%d", Integer.valueOf(i));
            JU(i);
            AppMethodBeat.o(80453);
            return;
        }
        XIPCInvoker.a("com.tencent.mm", new IPCInteger(i), a.class, new c<IPCVoid>() {
            public final /* bridge */ /* synthetic */ void ao(Object obj) {
            }
        });
        AppMethodBeat.o(80453);
    }
}
