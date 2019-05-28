package com.tencent.mm.plugin.appbrand.t;

import com.tencent.mm.plugin.appbrand.t.d.d;
import com.tencent.mm.plugin.appbrand.t.e.a;
import com.tencent.mm.plugin.appbrand.t.e.e;
import com.tencent.mm.plugin.appbrand.t.e.i;

public abstract class b implements d {
    protected boolean iSt;

    public final i aOh() {
        return new e();
    }

    public void b(a aVar) {
    }

    public void c(d dVar) {
    }

    public final void a(a aVar, d dVar) {
        com.tencent.mm.plugin.appbrand.t.d.e eVar = new com.tencent.mm.plugin.appbrand.t.d.e(dVar);
        eVar.a(d.a.PONG);
        aVar.b(eVar);
    }

    public final void setTcpNoDelay(boolean z) {
        this.iSt = z;
    }
}
