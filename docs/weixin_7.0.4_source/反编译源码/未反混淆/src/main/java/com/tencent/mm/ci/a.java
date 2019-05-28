package com.tencent.mm.ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.d;
import java.util.Iterator;

public class a<_Callback> extends com.tencent.mm.vending.b.a<_Callback> {

    public interface a<_Callback> {
        void ax(_Callback _callback);
    }

    public a() {
        super(new e());
        AppMethodBeat.i(123360);
        AppMethodBeat.o(123360);
    }

    public a(d dVar) {
        super(dVar);
    }

    public final void a(final a<_Callback> aVar) {
        AppMethodBeat.i(123361);
        Iterator it = dMf().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.zXD != null) {
                    this.zXB.c(bVar.zXD);
                    this.zXB.a(new com.tencent.mm.vending.c.a<Void, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(123359);
                            Void voidR = (Void) obj;
                            aVar.ax(bVar.d);
                            AppMethodBeat.o(123359);
                            return voidR;
                        }
                    }, com.tencent.mm.vending.c.a.zXH, true);
                } else {
                    aVar.ax(bVar.d);
                }
            }
        }
        AppMethodBeat.o(123361);
    }

    public b<_Callback> aD(_Callback _callback) {
        AppMethodBeat.i(123362);
        b a = super.a(new b(_callback, this));
        AppMethodBeat.o(123362);
        return a;
    }

    public final void remove(_Callback _callback) {
        AppMethodBeat.i(123363);
        super.b(new b(_callback, this));
        AppMethodBeat.o(123363);
    }
}
