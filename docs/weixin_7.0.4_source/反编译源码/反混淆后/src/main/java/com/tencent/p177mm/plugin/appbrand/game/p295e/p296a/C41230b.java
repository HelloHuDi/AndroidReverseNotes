package com.tencent.p177mm.plugin.appbrand.game.p295e.p296a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.b */
final class C41230b extends C38369p {
    static final int CTRL_INDEX = -2;
    static final String NAME = "onKeyboardConfirm";

    C41230b() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo65881a(String str, C38492q c38492q) {
        AppMethodBeat.m2504i(130201);
        HashMap hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", str);
        mo34958t(hashMap).mo61031i(c38492q).aCj();
        AppMethodBeat.m2505o(130201);
    }
}
