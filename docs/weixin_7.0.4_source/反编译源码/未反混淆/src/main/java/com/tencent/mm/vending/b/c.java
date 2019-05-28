package com.tencent.mm.vending.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.j.a;
import java.util.Iterator;

public abstract class c<_Callback> extends a<_Callback> {
    public abstract void a(_Callback _callback, a aVar);

    public c(d dVar) {
        super(dVar);
    }

    public final synchronized void aDt() {
        b(null);
    }

    public final synchronized void a(a aVar) {
        b(aVar);
    }

    private void b(final a aVar) {
        Iterator it = dMg().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.zXD != null) {
                    this.zXB.c(bVar.zXD);
                } else {
                    this.zXB.c(d.dMq());
                }
                this.zXB.a(new com.tencent.mm.vending.c.a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(126107);
                        Void voidR = (Void) obj;
                        c.this.a(bVar.d, aVar);
                        AppMethodBeat.o(126107);
                        return voidR;
                    }
                }, com.tencent.mm.vending.c.a.zXH, true);
            }
        }
    }

    public final b<_Callback> aD(_Callback _callback) {
        return a(new b(_callback, this));
    }

    public final void remove(_Callback _callback) {
        b(new b(_callback, this));
    }
}
