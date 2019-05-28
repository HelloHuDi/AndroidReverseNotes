package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.ap;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class j extends a {
    public j() {
        super(1);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6442);
        if (dVar.wD(21)) {
            lVar.a(this.id, context.getString(R.string.dhh), (int) R.raw.bottomsheet_icon_transmit);
        }
        AppMethodBeat.o(6442);
    }

    public final void a(Context context, d dVar) {
        AppMethodBeat.i(6443);
        ap.IF(0);
        dVar.cWN().aen("sendAppMessage");
        dVar.bPN.a(new c() {
            public final String name() {
                return "menu:share:appmessage";
            }

            public final JSONObject wQ() {
                return null;
            }
        });
        h.pYm.k(982, 9, 1);
        AppMethodBeat.o(6443);
    }
}
