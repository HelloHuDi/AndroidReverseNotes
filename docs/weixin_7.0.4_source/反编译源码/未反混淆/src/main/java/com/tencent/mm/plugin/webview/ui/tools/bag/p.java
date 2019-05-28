package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.bag.h.a;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class p implements a {
    private final d uzS;

    public p(d dVar) {
        this.uzS = dVar;
    }

    public final Bundle T(Bundle bundle) {
        Bundle bundle2 = null;
        AppMethodBeat.i(8274);
        if (this.uzS == null) {
            ab.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic mInvoker null");
            AppMethodBeat.o(8274);
        } else {
            try {
                bundle2 = this.uzS.g(103, bundle);
                AppMethodBeat.o(8274);
            } catch (RemoteException e) {
                ab.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic exp=%s", e.getLocalizedMessage());
                AppMethodBeat.o(8274);
            }
        }
        return bundle2;
    }

    public final void y(Object[] objArr) {
        AppMethodBeat.i(8275);
        if (this.uzS != null) {
            g.a(this.uzS, 11576, objArr);
        }
        AppMethodBeat.o(8275);
    }
}
