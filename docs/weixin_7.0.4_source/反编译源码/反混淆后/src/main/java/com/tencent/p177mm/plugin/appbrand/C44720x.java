package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C37673t;
import com.tencent.p177mm.p224d.p225a.C37673t.C1492a;
import com.tencent.p177mm.plugin.appbrand.C42329ae.C18995a;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.p329s.C42685u;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.x */
public final class C44720x extends C42701w {
    public C44720x(C38492q c38492q) {
        super(c38492q);
    }

    /* Access modifiers changed, original: protected|final */
    public final C37673t auv() {
        AppMethodBeat.m2504i(129131);
        C42329ae c42329ae = new C42329ae(this.ciG);
        AppMethodBeat.m2505o(129131);
        return c42329ae;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: xi */
    public final C1492a mo68101xi(String str) {
        AppMethodBeat.m2504i(129132);
        C18995a c18995a = new C18995a(super.mo68101xi(str), C42685u.m75594a(this.gNC.getRuntime(), str, this.gNC.aug()), this.gNC.getAppId(), this.gNC.atU());
        AppMethodBeat.m2505o(129132);
        return c18995a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo68097b(ArrayList<C1492a> arrayList, String str) {
        AppMethodBeat.m2504i(129133);
        super.mo68097b(arrayList, str);
        arrayList.add(new C18995a(this.gNC.auf() + "WAWorker.js", C33082aw.m54068a(this.gNC.getRuntime(), "WAWorker.js"), this.gNC.getAppId(), this.gNC.atU()));
        arrayList.add(new C1492a(this.gNC.auf() + "sourcemapSysinfo", C42685u.getSysInfo()));
        arrayList.add(new C1492a(this.gNC.auf() + "WASourceMap.js", C33082aw.m54068a(this.gNC.getRuntime(), "WASourceMap.js")));
        AppMethodBeat.m2505o(129133);
    }
}
