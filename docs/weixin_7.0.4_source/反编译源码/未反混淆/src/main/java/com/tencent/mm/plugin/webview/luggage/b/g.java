package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class g extends a {
    private a uju = new a();

    public g() {
        super(7);
        AppMethodBeat.i(6435);
        AppMethodBeat.o(6435);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6436);
        lVar.a(7, context.getString(R.string.g20), (int) R.raw.bottomsheet_icon_brower);
        AppMethodBeat.o(6436);
    }

    public final void a(Context context, d dVar) {
        AppMethodBeat.i(6437);
        String aek = dVar.cWM().aek(dVar.getUrl());
        if (bo.isNullOrNil(aek)) {
            aek = dVar.getUrl();
        }
        if (context instanceof Activity) {
            a.e((Activity) context, aek);
        }
        h.pYm.k(982, 6, 1);
        AppMethodBeat.o(6437);
    }
}
