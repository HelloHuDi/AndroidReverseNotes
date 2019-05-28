package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;

final class b extends p {
    static final int CTRL_INDEX = -2;
    static final String NAME = "onKeyboardConfirm";

    b() {
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, q qVar) {
        AppMethodBeat.i(130201);
        HashMap hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", str);
        t(hashMap).i(qVar).aCj();
        AppMethodBeat.o(130201);
    }
}
