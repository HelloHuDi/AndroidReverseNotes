package com.tencent.mm.a;

import com.tencent.mm.a.f.a;
import com.tencent.mm.a.f.b;
import com.tencent.mm.a.f.c;
import com.tencent.mm.sdk.platformtools.ae;

public class h<K, O> extends ae<K, O> implements f<K, O> {
    private b<K, O> cbY = null;
    private c<K, O> cbZ = null;

    public h(int i) {
        super(i);
    }

    public final void k(K k, O o) {
        if (o != null && k != null) {
            put(k, o);
        }
    }

    public final O ai(K k) {
        return get(k);
    }

    public h(int i, b<K, O> bVar) {
        super(i);
        this.cbY = bVar;
    }

    public h(int i, b<K, O> bVar, c<K, O> cVar) {
        super(i);
        this.cbY = bVar;
        this.cbZ = cVar;
    }

    public final void trimToSize(int i) {
        super.trimToSize(i);
    }

    public final O create(K k) {
        return super.create(k);
    }

    public void entryRemoved(boolean z, K k, O o, O o2) {
        super.entryRemoved(z, k, o, o2);
        if (this.cbY != null) {
            this.cbY.c(k, o, o2);
        }
    }

    public int sizeOf(K k, O o) {
        if (this.cbZ != null) {
            return this.cbZ.l(k, o);
        }
        return super.sizeOf(k, o);
    }

    public void a(a<K, O> aVar) {
        clear();
    }

    public void clear() {
        super.trimToSize(-1);
    }
}
