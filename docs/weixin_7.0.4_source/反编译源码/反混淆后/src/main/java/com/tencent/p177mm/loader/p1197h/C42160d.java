package com.tencent.p177mm.loader.p1197h;

import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;

/* renamed from: com.tencent.mm.loader.h.d */
public final class C42160d<K, V> {
    private C1177f<K, V> eRT;

    public C42160d(int i) {
        this.eRT = new C7598c(i);
    }

    /* renamed from: ai */
    public final V mo67700ai(K k) {
        if (this.eRT != null) {
            return this.eRT.mo4404ai(k);
        }
        throw new NullPointerException("mData == null");
    }

    /* renamed from: aj */
    public final synchronized boolean mo67701aj(K k) {
        if (this.eRT == null) {
            throw new NullPointerException("mData == null");
        }
        return this.eRT.mo4405aj(k);
    }

    public final V get(K k) {
        if (this.eRT != null) {
            return this.eRT.get(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final V put(K k, V v) {
        if (this.eRT != null) {
            return this.eRT.put(k, v);
        }
        throw new NullPointerException("mData == null");
    }

    public final synchronized String toString() {
        if (this.eRT == null) {
            throw new NullPointerException("mData == null");
        }
        return this.eRT.toString();
    }
}
