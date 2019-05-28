package com.tencent.mm.memory.a.a.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.c;
import com.tencent.mm.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b<T, V> {
    b<T, V> feA;
    private ConcurrentLinkedQueue<Pair<T, f<T, V>>> fex = new ConcurrentLinkedQueue();
    private a fey = null;
    a<T, V> fez;

    public interface a<K, O> {
        void r(K k, K k2);
    }

    public interface b<K, O> {
        int d(K k, K k2, O o);
    }

    public b(a aVar, a<T, V> aVar2, b<T, V> bVar) {
        AppMethodBeat.i(115464);
        this.fey = aVar;
        this.fez = aVar2;
        this.feA = bVar;
        AppMethodBeat.o(115464);
    }

    /* Access modifiers changed, original: final */
    public final f<T, V> aY(final T t) {
        Pair pair;
        AppMethodBeat.i(115466);
        Iterator it = this.fex.iterator();
        while (it.hasNext()) {
            pair = (Pair) it.next();
            if (pair != null && pair.first != null && pair.first.equals(t)) {
                f fVar = (f) pair.second;
                AppMethodBeat.o(115466);
                return fVar;
            }
        }
        if (this.fex.size() >= this.fey.fev) {
            pair = (Pair) this.fex.poll();
            if (!(pair == null || pair.second == null)) {
                ((f) pair.second).trimToSize(-1);
            }
        }
        a aVar = this.fey;
        ab.i("MicroMsg.ExtraLruMap", "handlerMap %s %s", t, Integer.valueOf((int) (((aVar.feu * ((double) aVar.fer)) * 1.0d) / ((double) aVar.fev))));
        Pair pair2 = new Pair(t, new h(r0, new com.tencent.mm.a.f.b<T, V>() {
            public final void c(T t, V v, V v2) {
                AppMethodBeat.i(115462);
                if (b.this.fez != null) {
                    b.this.fez.r(t, t);
                }
                AppMethodBeat.o(115462);
            }
        }, new c<T, V>() {
            public final int l(T t, V v) {
                AppMethodBeat.i(115463);
                if (b.this.feA != null) {
                    int d = b.this.feA.d(t, t, v);
                    AppMethodBeat.o(115463);
                    return d;
                }
                AppMethodBeat.o(115463);
                return 0;
            }
        }));
        this.fex.add(pair2);
        f<T, V> fVar2 = (f) pair2.second;
        AppMethodBeat.o(115466);
        return fVar2;
    }

    public final boolean q(T t, T t2) {
        f fVar;
        AppMethodBeat.i(115465);
        Iterator it = this.fex.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair != null && pair.first != null && pair.first.equals(t)) {
                fVar = (f) pair.second;
                break;
            }
        }
        fVar = null;
        if (fVar != null) {
            boolean aj = fVar.aj(t2);
            AppMethodBeat.o(115465);
            return aj;
        }
        AppMethodBeat.o(115465);
        return false;
    }
}
