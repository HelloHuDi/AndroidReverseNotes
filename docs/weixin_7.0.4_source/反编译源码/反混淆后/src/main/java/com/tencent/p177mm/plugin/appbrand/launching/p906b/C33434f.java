package com.tencent.p177mm.plugin.appbrand.launching.p906b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C10590a.C10593a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrand404PageUI;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.b.f */
final class C33434f extends C10590a {
    C33434f() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo22104a(String str, Uri uri, C10593a c10593a) {
        int i = 1;
        AppMethodBeat.m2504i(132040);
        String queryParameter = uri == null ? "" : uri.getQueryParameter("appid");
        switch (c10593a) {
            case ERR_URL_INVALID:
                int i2;
                if (uri == null || !uri.getBooleanQueryParameter("debug", false)) {
                    boolean i22 = false;
                } else {
                    i22 = 1;
                }
                AppBrand404PageUI.show(C25738R.string.f9044no);
                if (i22 == 0) {
                    i = 0;
                }
                C19690c.m30494K(queryParameter, 2, i + 1);
                AppMethodBeat.m2505o(132040);
                return;
            case ERR_DEV_CODE_EXPIRED:
                AppBrand404PageUI.show(C25738R.string.f9026mw);
                C19690c.m30494K("", 3, 2);
                AppMethodBeat.m2505o(132040);
                return;
            case ERR_UIN_INVALID:
                AppBrand404PageUI.show(C25738R.string.f9027mx);
                C19690c.m30494K("", 4, 2);
                AppMethodBeat.m2505o(132040);
                return;
            case OK:
                AppMethodBeat.m2505o(132040);
                return;
            default:
                AppBrand404PageUI.show(C25738R.string.f8888i_);
                AppMethodBeat.m2505o(132040);
                return;
        }
    }
}
