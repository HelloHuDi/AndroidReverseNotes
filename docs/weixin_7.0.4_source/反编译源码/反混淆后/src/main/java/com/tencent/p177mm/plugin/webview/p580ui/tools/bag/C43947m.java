package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.p1326d.C22783a;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.m */
public final class C43947m implements C22783a {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.m$2 */
    class C402892 implements Runnable {
        C402892() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8244);
            C29879l.uzq.mo48112nU(false);
            AppMethodBeat.m2505o(8244);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.m$1 */
    class C439481 implements Runnable {
        C439481() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8243);
            C29879l.uzq.cYT();
            AppMethodBeat.m2505o(8243);
        }
    }

    public final void cYT() {
        AppMethodBeat.m2504i(8245);
        C5004al.m7441d(new C439481());
        AppMethodBeat.m2505o(8245);
    }

    public final void cYU() {
        AppMethodBeat.m2504i(8246);
        C5004al.m7441d(new C402892());
        AppMethodBeat.m2505o(8246);
    }
}
