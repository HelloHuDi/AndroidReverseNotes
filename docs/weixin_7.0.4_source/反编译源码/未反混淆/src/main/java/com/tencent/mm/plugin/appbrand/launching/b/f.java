package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.launching.b.a.a;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class f extends a {
    f() {
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, Uri uri, a aVar) {
        int i = 1;
        AppMethodBeat.i(132040);
        String queryParameter = uri == null ? "" : uri.getQueryParameter("appid");
        switch (aVar) {
            case ERR_URL_INVALID:
                int i2;
                if (uri == null || !uri.getBooleanQueryParameter("debug", false)) {
                    boolean i22 = false;
                } else {
                    i22 = 1;
                }
                AppBrand404PageUI.show(R.string.no);
                if (i22 == 0) {
                    i = 0;
                }
                c.K(queryParameter, 2, i + 1);
                AppMethodBeat.o(132040);
                return;
            case ERR_DEV_CODE_EXPIRED:
                AppBrand404PageUI.show(R.string.mw);
                c.K("", 3, 2);
                AppMethodBeat.o(132040);
                return;
            case ERR_UIN_INVALID:
                AppBrand404PageUI.show(R.string.mx);
                c.K("", 4, 2);
                AppMethodBeat.o(132040);
                return;
            case OK:
                AppMethodBeat.o(132040);
                return;
            default:
                AppBrand404PageUI.show(R.string.i_);
                AppMethodBeat.o(132040);
                return;
        }
    }
}
