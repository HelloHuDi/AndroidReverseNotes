package com.tencent.mm.loader.g;

import a.f.b.j;

public final class i implements Runnable {
    private b eQR;
    private c eRp;
    private a eRq;

    public interface a {
        void b(c cVar, h hVar);
    }

    public i(c cVar, b bVar, a aVar) {
        this.eRp = cVar;
        this.eQR = bVar;
        this.eRq = aVar;
    }

    public final void run() {
        c cVar = this.eRp;
        b bVar = this.eQR;
        a aVar = this.eRq;
        j.p(bVar, "loader");
        j.p(aVar, "watch");
        cVar.eQR = bVar;
        cVar.eQS = aVar;
        cVar.Pa();
    }
}
