package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.launching.b.a.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

public final class c extends a {
    /* Access modifiers changed, original: final */
    public final void a(String str, Uri uri, a aVar) {
        AppMethodBeat.i(132036);
        switch (aVar) {
            case ERR_URL_INVALID:
                AppBrand404PageUI.show(R.string.i_);
                AppMethodBeat.o(132036);
                return;
            case ERR_DEV_CODE_EXPIRED:
                AppBrand404PageUI.show(R.string.i_);
                AppMethodBeat.o(132036);
                return;
            case ERR_UIN_INVALID:
                AppBrand404PageUI.show(R.string.i_);
                AppMethodBeat.o(132036);
                return;
            case OK:
                AppMethodBeat.o(132036);
                return;
            default:
                AppBrand404PageUI.show(R.string.i_);
                AppMethodBeat.o(132036);
                return;
        }
    }
}
