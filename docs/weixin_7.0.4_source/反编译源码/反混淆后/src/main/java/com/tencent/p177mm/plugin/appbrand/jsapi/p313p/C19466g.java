package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.p329s.C45688t.C45687a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.g */
final class C19466g extends C42467ah {
    static final int CTRL_INDEX = 473;
    static final String NAME = "onDeviceOrientationChange";

    C19466g() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo34593a(C45687a c45687a) {
        AppMethodBeat.m2504i(126385);
        String replace = c45687a.name().replace("_", "");
        HashMap hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", replace);
        mo34958t(hashMap).aCj();
        AppMethodBeat.m2505o(126385);
    }
}
