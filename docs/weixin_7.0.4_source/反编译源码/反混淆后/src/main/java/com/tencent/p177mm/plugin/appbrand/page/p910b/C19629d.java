package com.tencent.p177mm.plugin.appbrand.page.p910b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.page.b.d */
public final class C19629d extends C38369p {
    private static final int CTRL_INDEX = 633;
    private static final String NAME = "onCustomRightButtonClick";
    private static C19629d ivx = new C19629d();

    static {
        AppMethodBeat.m2504i(87378);
        AppMethodBeat.m2505o(87378);
    }

    /* renamed from: c */
    public static void m30427c(C44709u c44709u) {
        AppMethodBeat.m2504i(87377);
        C4990ab.m7416i("onCustomRightButtonClickEvent", "onCustomRightButtonClickEvent dispatch");
        ivx.mo61031i(c44709u.mo44926xT()).aCj();
        AppMethodBeat.m2505o(87377);
    }
}
