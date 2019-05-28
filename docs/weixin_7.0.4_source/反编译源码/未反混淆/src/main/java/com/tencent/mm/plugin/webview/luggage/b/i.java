package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.ui.base.l;

public final class i extends a {
    public i() {
        super(31);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6440);
        lVar.a(31, context.getString(R.string.g2s), (int) R.raw.bottomsheet_icon_search);
        AppMethodBeat.o(6440);
    }

    public final void a(Context context, d dVar) {
        AppMethodBeat.i(6441);
        if (!dVar.uhW.isShown()) {
            dVar.uhW.reset();
            dVar.uhW.dcX();
            dVar.uhW.show();
        }
        h.pYm.k(982, 8, 1);
        AppMethodBeat.o(6441);
    }
}
