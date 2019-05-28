package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.ap;
import com.tencent.mm.protocal.protobuf.bbb;
import org.json.JSONObject;

public final class j extends a {
    public j() {
        super(3);
    }

    public final void a(Context context, d dVar, bbb bbb) {
        AppMethodBeat.i(135910);
        ap.IF(0);
        dVar.bPN.a(new c() {
            public final String name() {
                return "menu:share:appmessage";
            }

            public final JSONObject wQ() {
                return null;
            }
        });
        AppMethodBeat.o(135910);
    }
}
