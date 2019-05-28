package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.ui.base.l;

public final class e extends a {
    public e() {
        super(27);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6431);
        if (dVar.isFullScreen()) {
            lVar.a(27, context.getString(R.string.dhq), (int) R.raw.bottomsheet_icon_exit);
        }
        AppMethodBeat.o(6431);
    }

    public final void a(Context context, d dVar) {
        AppMethodBeat.i(6432);
        if (!(dVar.cWG() || dVar.bPe.xi().xb())) {
            ((Activity) dVar.mContext).finish();
        }
        h.pYm.k(982, 11, 1);
        AppMethodBeat.o(6432);
    }
}
