package com.tencent.p177mm.plugin.appbrand.launching.p906b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C10590a.C10593a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrand404PageUI;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.b.d */
final class C16688d extends C10590a {
    C16688d() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo22104a(String str, Uri uri, C10593a c10593a) {
        AppMethodBeat.m2504i(132038);
        switch (c10593a) {
            case ERR_URL_INVALID:
                AppBrand404PageUI.show(C25738R.string.f8854h6);
                AppMethodBeat.m2505o(132038);
                return;
            case ERR_DEV_CODE_EXPIRED:
                AppBrand404PageUI.show(C25738R.string.f8855h7);
                AppMethodBeat.m2505o(132038);
                return;
            case ERR_UIN_INVALID:
                AppBrand404PageUI.show(C25738R.string.f9027mx);
                AppMethodBeat.m2505o(132038);
                return;
            case OK:
                AppMethodBeat.m2505o(132038);
                return;
            default:
                AppBrand404PageUI.show(C25738R.string.f8888i_);
                AppMethodBeat.m2505o(132038);
                return;
        }
    }
}
