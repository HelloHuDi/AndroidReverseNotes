package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;
import com.tencent.mm.ui.base.l;

public final class f extends a {
    public f() {
        super(35);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6433);
        h cWP = dVar.cWP();
        if (dVar.cWO() && cWP != null) {
            if (cWP.dbd()) {
                lVar.a(35, context.getString(R.string.dhm), (int) R.raw.bottomsheet_icon_webview_cancel_minimize);
            } else {
                lVar.a(35, context.getString(R.string.dhw), (int) R.raw.bottomsheet_icon_webview_minimize);
                AppMethodBeat.o(6433);
                return;
            }
        }
        AppMethodBeat.o(6433);
    }

    public final void a(Context context, d dVar) {
        AppMethodBeat.i(6434);
        h cWP = dVar.cWP();
        if (cWP != null) {
            if (cWP.dbd()) {
                cWP.nT(true);
                com.tencent.mm.plugin.report.service.h.pYm.k(982, 5, 1);
            } else {
                cWP.nT(false);
                com.tencent.mm.plugin.report.service.h.pYm.k(982, 4, 1);
                AppMethodBeat.o(6434);
                return;
            }
        }
        AppMethodBeat.o(6434);
    }
}
