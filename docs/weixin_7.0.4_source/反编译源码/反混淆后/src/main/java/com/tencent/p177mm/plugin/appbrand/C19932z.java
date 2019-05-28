package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C10333f;

/* renamed from: com.tencent.mm.plugin.appbrand.z */
final class C19932z implements C10333f {
    C19932z() {
    }

    /* renamed from: c */
    public final C33303e mo21784c(C2241c c2241c) {
        AppMethodBeat.m2504i(86790);
        C33303e c33303e;
        if (c2241c instanceof C33303e) {
            c33303e = (C33303e) c2241c;
            AppMethodBeat.m2505o(86790);
            return c33303e;
        } else if (c2241c instanceof C38492q) {
            c33303e = ((C38492q) c2241c).getCurrentPageView();
            AppMethodBeat.m2505o(86790);
            return c33303e;
        } else {
            AppMethodBeat.m2505o(86790);
            return null;
        }
    }
}
