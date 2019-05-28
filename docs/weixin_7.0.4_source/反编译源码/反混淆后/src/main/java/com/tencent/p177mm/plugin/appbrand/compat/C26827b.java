package com.tencent.p177mm.plugin.appbrand.compat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C17891h.C17889a;
import com.tencent.p177mm.p183ai.C17891h.C17892b;
import com.tencent.p177mm.p230g.p231a.C32557fk;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C38157b;
import com.tencent.p177mm.sdk.p600b.C4879a;

/* renamed from: com.tencent.mm.plugin.appbrand.compat.b */
final class C26827b implements C38157b {
    C26827b() {
    }

    /* renamed from: a */
    public final void mo44594a(String str, C17889a c17889a, C17892b c17892b) {
        AppMethodBeat.m2504i(135460);
        C32557fk c32557fk = new C32557fk();
        c32557fk.czf.f1230op = 1;
        c32557fk.czf.fileName = str;
        c32557fk.czf.czh = true;
        c32557fk.czf.com = true;
        c32557fk.czf.czi = c17889a;
        c32557fk.czf.czj = c17892b;
        C4879a.xxA.mo10055m(c32557fk);
        AppMethodBeat.m2505o(135460);
    }

    public final void pause() {
        AppMethodBeat.m2504i(135461);
        C32557fk c32557fk = new C32557fk();
        c32557fk.czf.f1230op = 4;
        C4879a.xxA.mo10055m(c32557fk);
        AppMethodBeat.m2505o(135461);
    }

    public final void stop() {
        AppMethodBeat.m2504i(135462);
        C32557fk c32557fk = new C32557fk();
        c32557fk.czf.f1230op = 2;
        C4879a.xxA.mo10055m(c32557fk);
        AppMethodBeat.m2505o(135462);
    }
}
