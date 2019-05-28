package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends btd, P extends com.tencent.mm.ai.a<K>> {
    protected List<a<K>> callbacks = new ArrayList();
    protected P fsz;
    protected boolean okX = false;

    public interface a<K> {
        void bX(K k);

        void bY(K k);
    }

    public abstract K bLr();

    public abstract void e(com.tencent.mm.ai.a.a<K> aVar);

    public final void a(a<K> aVar) {
        ab.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s", Boolean.TRUE);
        aVar.bY(bLr());
        if (!this.callbacks.contains(aVar)) {
            this.callbacks.add(aVar);
        }
        ab.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", Boolean.valueOf(this.okX));
        if (!this.okX) {
            this.okX = true;
            com.tencent.mm.ai.a aVar2 = this.fsz;
            Assert.assertNotNull("cgi must not be null", aVar2);
            aVar2.acy().h(new com.tencent.mm.vending.c.a<K, com.tencent.mm.ai.a.a<K>>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(49021);
                    com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                    a.this.e(aVar);
                    btd btd = aVar.fsy;
                    AppMethodBeat.o(49021);
                    return btd;
                }
            }).b(new com.tencent.mm.vending.c.a<Object, K>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(49020);
                    btd btd = (btd) obj;
                    a.this.okX = false;
                    a.a(a.this, btd);
                    AppMethodBeat.o(49020);
                    return null;
                }
            });
        }
    }

    public final void b(P p) {
        this.fsz = p;
    }

    static /* synthetic */ void a(a aVar, btd btd) {
        for (int size = aVar.callbacks.size() - 1; size >= 0; size--) {
            a aVar2 = (a) aVar.callbacks.get(size);
            aVar2.bX(btd);
            aVar.callbacks.remove(aVar2);
        }
    }
}
