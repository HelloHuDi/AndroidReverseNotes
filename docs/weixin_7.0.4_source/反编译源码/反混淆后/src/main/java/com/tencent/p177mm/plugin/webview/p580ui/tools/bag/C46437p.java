package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C29916g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22935h.C22936a;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.p */
public final class C46437p implements C22936a {
    private final C46434d uzS;

    public C46437p(C46434d c46434d) {
        this.uzS = c46434d;
    }

    /* renamed from: T */
    public final Bundle mo38533T(Bundle bundle) {
        Bundle bundle2 = null;
        AppMethodBeat.m2504i(8274);
        if (this.uzS == null) {
            C4990ab.m7412e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic mInvoker null");
            AppMethodBeat.m2505o(8274);
        } else {
            try {
                bundle2 = this.uzS.mo15575g(103, bundle);
                AppMethodBeat.m2505o(8274);
            } catch (RemoteException e) {
                C4990ab.m7413e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic exp=%s", e.getLocalizedMessage());
                AppMethodBeat.m2505o(8274);
            }
        }
        return bundle2;
    }

    /* renamed from: y */
    public final void mo38534y(Object[] objArr) {
        AppMethodBeat.m2504i(8275);
        if (this.uzS != null) {
            C29916g.m47392a(this.uzS, 11576, objArr);
        }
        AppMethodBeat.m2505o(8275);
    }
}
