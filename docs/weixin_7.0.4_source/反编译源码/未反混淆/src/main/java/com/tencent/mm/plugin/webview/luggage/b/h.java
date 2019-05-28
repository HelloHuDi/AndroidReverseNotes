package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.ui.base.l;

public final class h extends a {
    public h() {
        super(28);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6438);
        lVar.a(28, context.getString(R.string.fxx), (int) R.raw.bottomsheet_icon_refresh);
        AppMethodBeat.o(6438);
    }

    public final void a(Context context, d dVar) {
        AppMethodBeat.i(6439);
        dVar.reload();
        com.tencent.mm.plugin.report.service.h.pYm.k(982, 7, 1);
        AppMethodBeat.o(6439);
    }
}
