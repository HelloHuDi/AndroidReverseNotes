package com.tencent.p177mm.plugin.appbrand.p297h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C1482g;
import com.tencent.p177mm.p224d.p225a.C32488l;
import com.tencent.p177mm.p224d.p225a.C37665i;
import com.tencent.p177mm.p224d.p225a.C37665i.C376663;
import com.tencent.p177mm.p224d.p225a.C45301c;

/* renamed from: com.tencent.mm.plugin.appbrand.h.v */
public final class C42451v extends C16613a {
    public C42451v() {
        super(null, null);
    }

    public C42451v(String str, byte[] bArr) {
        super(str, bArr);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: r */
    public final C45301c mo30587r(String str, byte[] bArr) {
        AppMethodBeat.m2504i(113944);
        C37665i g = C1482g.m3102g(str, bArr);
        AppMethodBeat.m2505o(113944);
        return g;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C32488l mo30572a(C45301c c45301c, int i) {
        AppMethodBeat.m2504i(113945);
        C37665i c37665i = (C37665i) c45301c;
        if (c37665i.chD == null) {
            c37665i.chD = new C32488l(c37665i, c37665i.mo76047Cr(), new C376663());
        }
        C32488l c32488l = c37665i.chD;
        AppMethodBeat.m2505o(113945);
        return c32488l;
    }
}
