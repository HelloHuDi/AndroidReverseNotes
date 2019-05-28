package com.tencent.p177mm.plugin.appbrand.widget.p340i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.i.c */
public class C33611c {
    /* renamed from: a */
    public void mo6339a(String str, C33612d c33612d) {
        AppMethodBeat.m2504i(87563);
        C4990ab.m7410d("IconLoadErrorHandler ", "setTabBarFail: ".concat(String.valueOf(str)));
        if (c33612d.jpw != null) {
            c33612d.jpw.destroy(c33612d.index);
        }
        AppMethodBeat.m2505o(87563);
    }
}
