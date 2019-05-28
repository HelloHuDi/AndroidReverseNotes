package com.tencent.p177mm.plugin.webview.p768b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.b.e */
public final class C35583e extends C7563j<C16924d> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C16924d.ccO, "WebViewHistory")};

    /* renamed from: com.tencent.mm.plugin.webview.b.e$1 */
    public class C227811 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(5646);
            C35583e.this.mo16768hY("WebViewHistory", "delete from WebViewHistory where  timeStamp < ".concat(String.valueOf((System.currentTimeMillis() / 1000) - 604800)));
            C35583e.m58413a(C35583e.this);
            AppMethodBeat.m2505o(5646);
        }
    }

    static {
        AppMethodBeat.m2504i(5648);
        AppMethodBeat.m2505o(5648);
    }

    public C35583e(C4927e c4927e) {
        super(c4927e, C16924d.ccO, "WebViewHistory", null);
    }

    /* renamed from: a */
    static /* synthetic */ void m58413a(C35583e c35583e) {
        AppMethodBeat.m2504i(5647);
        int count = c35583e.getCount() - 500;
        if (count > 0) {
            C4990ab.m7416i("MicroMsg.WebViewHistoryStorage", "deleteItem: ".concat(String.valueOf(c35583e.mo16768hY("WebViewHistory", "delete from WebViewHistory order by timeStamp limit ".concat(String.valueOf(count))))));
        }
        AppMethodBeat.m2505o(5647);
    }
}
