package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.protocal.protobuf.bbb;
import org.json.JSONObject;

public final class e extends a {
    public e() {
        super(10);
    }

    public final void a(Context context, d dVar, final bbb bbb) {
        AppMethodBeat.i(135903);
        dVar.bPN.a(new c() {
            public final String name() {
                return "onCustomGameMenuClicked";
            }

            public final JSONObject wQ() {
                AppMethodBeat.i(135902);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("itemId", bbb.wFQ);
                    AppMethodBeat.o(135902);
                    return jSONObject;
                } catch (Exception e) {
                    AppMethodBeat.o(135902);
                    return null;
                }
            }
        });
        AppMethodBeat.o(135903);
    }
}
