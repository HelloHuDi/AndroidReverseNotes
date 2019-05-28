package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class t implements com.tencent.mm.plugin.webview.ui.tools.bag.h.a {

    static class a implements i<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(6240);
            Bundle af = com.tencent.mm.plugin.webview.ui.tools.bag.n.a.af((Bundle) obj);
            AppMethodBeat.o(6240);
            return af;
        }
    }

    public final Bundle T(Bundle bundle) {
        AppMethodBeat.i(6241);
        try {
            Bundle bundle2 = (Bundle) f.a("com.tencent.mm", bundle, a.class);
            AppMethodBeat.o(6241);
            return bundle2;
        } catch (c e) {
            ab.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic exp=%s", e.getLocalizedMessage());
            AppMethodBeat.o(6241);
            return null;
        }
    }

    public final void y(Object[] objArr) {
        AppMethodBeat.i(6242);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 4) {
            try {
                arrayList.add(String.valueOf(objArr[i]));
                i++;
            } catch (Exception e) {
                ab.w("MicroMsg.WebViewUIBagIPCDelegate", "kvReport, ex = " + e.getMessage());
                AppMethodBeat.o(6242);
                return;
            }
        }
        h hVar = h.pYm;
        h.g(11576, arrayList);
        AppMethodBeat.o(6242);
    }
}
