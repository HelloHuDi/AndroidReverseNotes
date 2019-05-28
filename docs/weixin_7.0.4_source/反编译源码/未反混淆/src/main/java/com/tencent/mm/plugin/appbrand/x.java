package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.t;
import com.tencent.mm.d.a.t.a;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.s.u;
import java.util.ArrayList;

public final class x extends w {
    public x(q qVar) {
        super(qVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final t auv() {
        AppMethodBeat.i(129131);
        ae aeVar = new ae(this.ciG);
        AppMethodBeat.o(129131);
        return aeVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final a xi(String str) {
        AppMethodBeat.i(129132);
        a aVar = new a(super.xi(str), u.a(this.gNC.getRuntime(), str, this.gNC.aug()), this.gNC.getAppId(), this.gNC.atU());
        AppMethodBeat.o(129132);
        return aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(ArrayList<a> arrayList, String str) {
        AppMethodBeat.i(129133);
        super.b(arrayList, str);
        arrayList.add(new a(this.gNC.auf() + "WAWorker.js", aw.a(this.gNC.getRuntime(), "WAWorker.js"), this.gNC.getAppId(), this.gNC.atU()));
        arrayList.add(new a(this.gNC.auf() + "sourcemapSysinfo", u.getSysInfo()));
        arrayList.add(new a(this.gNC.auf() + "WASourceMap.js", aw.a(this.gNC.getRuntime(), "WASourceMap.js")));
        AppMethodBeat.o(129133);
    }
}
