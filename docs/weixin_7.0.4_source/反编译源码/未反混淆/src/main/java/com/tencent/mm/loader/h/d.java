package com.tencent.mm.loader.h;

import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V> {
    private f<K, V> eRT;

    public d(int i) {
        this.eRT = new c(i);
    }

    public final V ai(K k) {
        if (this.eRT != null) {
            return this.eRT.ai(k);
        }
        throw new NullPointerException("mData == null");
    }

    public final synchronized boolean aj(K k) {
        if (this.eRT == null) {
            throw new NullPointerException("mData == null");
        }
        return this.eRT.aj(k);
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
