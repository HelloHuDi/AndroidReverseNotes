package com.tencent.p177mm.memory.p259a.p260a.p261a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p178a.C1177f.C1176c;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.memory.a.a.a.b */
public final class C1795b<T, V> {
    C1794b<T, V> feA;
    private ConcurrentLinkedQueue<Pair<T, C1177f<T, V>>> fex = new ConcurrentLinkedQueue();
    private C1792a fey = null;
    C1793a<T, V> fez;

    /* renamed from: com.tencent.mm.memory.a.a.a.b$a */
    public interface C1793a<K, O> {
        /* renamed from: r */
        void mo5352r(K k, K k2);
    }

    /* renamed from: com.tencent.mm.memory.a.a.a.b$b */
    public interface C1794b<K, O> {
        /* renamed from: d */
        int mo5353d(K k, K k2, O o);
    }

    public C1795b(C1792a c1792a, C1793a<T, V> c1793a, C1794b<T, V> c1794b) {
        AppMethodBeat.m2504i(115464);
        this.fey = c1792a;
        this.fez = c1793a;
        this.feA = c1794b;
        AppMethodBeat.m2505o(115464);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aY */
    public final C1177f<T, V> mo5354aY(final T t) {
        Pair pair;
        AppMethodBeat.m2504i(115466);
        Iterator it = this.fex.iterator();
        while (it.hasNext()) {
            pair = (Pair) it.next();
            if (pair != null && pair.first != null && pair.first.equals(t)) {
                C1177f c1177f = (C1177f) pair.second;
                AppMethodBeat.m2505o(115466);
                return c1177f;
            }
        }
        if (this.fex.size() >= this.fey.fev) {
            pair = (Pair) this.fex.poll();
            if (!(pair == null || pair.second == null)) {
                ((C1177f) pair.second).trimToSize(-1);
            }
        }
        C1792a c1792a = this.fey;
        C4990ab.m7417i("MicroMsg.ExtraLruMap", "handlerMap %s %s", t, Integer.valueOf((int) (((c1792a.feu * ((double) c1792a.fer)) * 1.0d) / ((double) c1792a.fev))));
        Pair pair2 = new Pair(t, new C6294h(r0, new C1175b<T, V>() {
            /* renamed from: c */
            public final void mo4401c(T t, V v, V v2) {
                AppMethodBeat.m2504i(115462);
                if (C1795b.this.fez != null) {
                    C1795b.this.fez.mo5352r(t, t);
                }
                AppMethodBeat.m2505o(115462);
            }
        }, new C1176c<T, V>() {
            /* renamed from: l */
            public final int mo4402l(T t, V v) {
                AppMethodBeat.m2504i(115463);
                if (C1795b.this.feA != null) {
                    int d = C1795b.this.feA.mo5353d(t, t, v);
                    AppMethodBeat.m2505o(115463);
                    return d;
                }
                AppMethodBeat.m2505o(115463);
                return 0;
            }
        }));
        this.fex.add(pair2);
        C1177f<T, V> c1177f2 = (C1177f) pair2.second;
        AppMethodBeat.m2505o(115466);
        return c1177f2;
    }

    /* renamed from: q */
    public final boolean mo5355q(T t, T t2) {
        C1177f c1177f;
        AppMethodBeat.m2504i(115465);
        Iterator it = this.fex.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair != null && pair.first != null && pair.first.equals(t)) {
                c1177f = (C1177f) pair.second;
                break;
            }
        }
        c1177f = null;
        if (c1177f != null) {
            boolean aj = c1177f.mo4405aj(t2);
            AppMethodBeat.m2505o(115465);
            return aj;
        }
        AppMethodBeat.m2505o(115465);
        return false;
    }
}
