package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class d extends a<s> {
    private static final int CTRL_INDEX = 70;
    private static final String NAME = "hideKeyboard";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130204);
        final s sVar = (s) cVar;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130203);
                w aun = sVar.aun();
                if (aun == null) {
                    AppMethodBeat.o(130203);
                    return;
                }
                com.tencent.mm.plugin.appbrand.game.widget.input.a ck = com.tencent.mm.plugin.appbrand.game.widget.input.a.ck(aun.getContentView());
                if (ck != null) {
                    ck.hide();
                }
                AppMethodBeat.o(130203);
            }
        });
        sVar.M(i, j("ok", null));
        AppMethodBeat.o(130204);
    }
}
