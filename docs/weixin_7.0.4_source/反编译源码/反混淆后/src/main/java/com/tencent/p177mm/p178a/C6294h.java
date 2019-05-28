package com.tencent.p177mm.p178a;

import com.tencent.p177mm.p178a.C1177f.C1174a;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p178a.C1177f.C1176c;
import com.tencent.p177mm.sdk.platformtools.C4993ae;

/* renamed from: com.tencent.mm.a.h */
public class C6294h<K, O> extends C4993ae<K, O> implements C1177f<K, O> {
    private C1175b<K, O> cbY = null;
    private C1176c<K, O> cbZ = null;

    public C6294h(int i) {
        super(i);
    }

    /* renamed from: k */
    public final void mo4412k(K k, O o) {
        if (o != null && k != null) {
            put(k, o);
        }
    }

    /* renamed from: ai */
    public final O mo4404ai(K k) {
        return get(k);
    }

    public C6294h(int i, C1175b<K, O> c1175b) {
        super(i);
        this.cbY = c1175b;
    }

    public C6294h(int i, C1175b<K, O> c1175b, C1176c<K, O> c1176c) {
        super(i);
        this.cbY = c1175b;
        this.cbZ = c1176c;
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
            this.cbY.mo4401c(k, o, o2);
        }
    }

    public int sizeOf(K k, O o) {
        if (this.cbZ != null) {
            return this.cbZ.mo4402l(k, o);
        }
        return super.sizeOf(k, o);
    }

    /* renamed from: a */
    public void mo4403a(C1174a<K, O> c1174a) {
        clear();
    }

    public void clear() {
        super.trimToSize(-1);
    }
}
