package com.tencent.p177mm.plugin.appbrand.launching.p906b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C10590a.C10593a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrand404PageUI;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.b.c */
public final class C16686c extends C10590a {
    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo22104a(String str, Uri uri, C10593a c10593a) {
        AppMethodBeat.m2504i(132036);
        switch (c10593a) {
            case ERR_URL_INVALID:
                AppBrand404PageUI.show(C25738R.string.f8888i_);
                AppMethodBeat.m2505o(132036);
                return;
            case ERR_DEV_CODE_EXPIRED:
                AppBrand404PageUI.show(C25738R.string.f8888i_);
                AppMethodBeat.m2505o(132036);
                return;
            case ERR_UIN_INVALID:
                AppBrand404PageUI.show(C25738R.string.f8888i_);
                AppMethodBeat.m2505o(132036);
                return;
            case OK:
                AppMethodBeat.m2505o(132036);
                return;
            default:
                AppBrand404PageUI.show(C25738R.string.f8888i_);
                AppMethodBeat.m2505o(132036);
                return;
        }
    }
}
