package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10332b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.j */
public final class C42562j implements C45612a {
    public final int aEN() {
        AppMethodBeat.m2504i(131433);
        if (C42562j.aER()) {
            AppMethodBeat.m2505o(131433);
            return 5;
        }
        AppMethodBeat.m2505o(131433);
        return 20;
    }

    public final int aEO() {
        AppMethodBeat.m2504i(131434);
        if (C42562j.aER()) {
            AppMethodBeat.m2505o(131434);
            return 20;
        }
        AppMethodBeat.m2505o(131434);
        return 200;
    }

    private static boolean aER() {
        AppMethodBeat.m2504i(131436);
        if (WebView.getUsingTbsCoreVersion(C4996ah.getContext()) >= 36867) {
            AppMethodBeat.m2505o(131436);
            return true;
        } else if (WebView.getCurWebType() == C44570d.WV_KIND_CW) {
            AppMethodBeat.m2505o(131436);
            return true;
        } else {
            AppMethodBeat.m2505o(131436);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo53859a(C2241c c2241c, C42467ah c42467ah) {
        boolean z;
        AppMethodBeat.m2504i(131435);
        if (!c2241c.isRunning()) {
            z = false;
        } else if (c2241c instanceof C33327h) {
            C33327h c33327h = (C33327h) c2241c;
            if (c33327h.getRuntime() instanceof C41243o) {
                z = ((C41243o) c33327h.getRuntime()).mo43488xY().mo53979a(c2241c, (C10332b) c42467ah);
            } else {
                C4990ab.m7412e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
                z = false;
            }
        } else {
            C4990ab.m7412e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
            z = false;
        }
        if (z) {
            AppMethodBeat.m2505o(131435);
            return true;
        }
        AppMethodBeat.m2505o(131435);
        return false;
    }
}
