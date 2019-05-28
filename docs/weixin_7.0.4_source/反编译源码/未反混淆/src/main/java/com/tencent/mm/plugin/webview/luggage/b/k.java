package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class k extends a {
    public k() {
        super(2);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6444);
        if (dVar.wD(23)) {
            lVar.a(2, context.getString(R.string.dhi), (int) R.raw.bottomsheet_icon_moment);
        }
        AppMethodBeat.o(6444);
    }

    public final void a(Context context, d dVar) {
        AppMethodBeat.i(6445);
        dVar.cWN().aen(f.NAME);
        dVar.bPN.a(new c() {
            public final String name() {
                return "menu:share:timeline";
            }

            public final JSONObject wQ() {
                return null;
            }
        });
        h.pYm.k(982, 10, 1);
        AppMethodBeat.o(6445);
    }
}
