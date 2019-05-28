package com.tencent.p177mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.p1532e.C42132c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22935h.C22936a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43949n.C35647a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.webview.luggage.t */
public final class C31478t implements C22936a {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.t$a */
    static class C22872a implements C45413i<Bundle, Bundle> {
        private C22872a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(6240);
            Bundle af = C35647a.m58499af((Bundle) obj);
            AppMethodBeat.m2505o(6240);
            return af;
        }
    }

    /* renamed from: T */
    public final Bundle mo38533T(Bundle bundle) {
        AppMethodBeat.m2504i(6241);
        try {
            Bundle bundle2 = (Bundle) C9549f.m17010a("com.tencent.mm", bundle, C22872a.class);
            AppMethodBeat.m2505o(6241);
            return bundle2;
        } catch (C42132c e) {
            C4990ab.m7413e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic exp=%s", e.getLocalizedMessage());
            AppMethodBeat.m2505o(6241);
            return null;
        }
    }

    /* renamed from: y */
    public final void mo38534y(Object[] objArr) {
        AppMethodBeat.m2504i(6242);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 4) {
            try {
                arrayList.add(String.valueOf(objArr[i]));
                i++;
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewUIBagIPCDelegate", "kvReport, ex = " + e.getMessage());
                AppMethodBeat.m2505o(6242);
                return;
            }
        }
        C7060h c7060h = C7060h.pYm;
        C7060h.m11802g(11576, arrayList);
        AppMethodBeat.m2505o(6242);
    }
}
