package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import org.json.JSONObject;

public final class j extends i {
    private static final int CTRL_INDEX = 111;
    private static final String NAME = "updateTextArea";

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ boolean a(f fVar, JSONObject jSONObject, u uVar, int i) {
        Boolean bool;
        AppMethodBeat.i(123565);
        h hVar = (h) fVar;
        boolean a = super.a(hVar, jSONObject, uVar, i);
        hVar.jjF = Boolean.TRUE;
        hVar.jjL = Boolean.FALSE;
        Object opt = jSONObject.opt("confirm");
        if (opt == null) {
            bool = null;
        } else {
            bool = k.bG(opt);
        }
        hVar.jjG = bool;
        AppMethodBeat.o(123565);
        return a;
    }

    public final void a(u uVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(123564);
        super.a(uVar, jSONObject, i);
        AppMethodBeat.o(123564);
    }
}
