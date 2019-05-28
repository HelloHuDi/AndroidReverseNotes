package com.tencent.p177mm.plugin.appbrand.p1231o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.plugin.appbrand.o.a */
public final class C38452a {
    public static boolean aLC() {
        boolean z;
        AppMethodBeat.m2504i(132712);
        C5141c ll = C18624c.abi().mo17131ll("100159");
        if (ll.isValid() && "1".equals(ll.dru().get("isCloseWeappSearch"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.m2505o(132712);
            return false;
        }
        AppMethodBeat.m2505o(132712);
        return true;
    }
}
