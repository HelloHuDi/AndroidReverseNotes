package com.tencent.mm.at.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import java.util.Map;

public final class a<K, V> {
    public f<K, V> eRT;

    public a(int i) {
        AppMethodBeat.i(116095);
        this.eRT = new c(i);
        AppMethodBeat.o(116095);
    }

    public final synchronized boolean aj(K k) {
        boolean aj;
        AppMethodBeat.i(116097);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(116097);
            throw nullPointerException;
        }
        aj = this.eRT.aj(k);
        AppMethodBeat.o(116097);
        return aj;
    }

    public final V get(K k) {
        AppMethodBeat.i(116098);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(116098);
            throw nullPointerException;
        }
        Object obj = this.eRT.get(k);
        AppMethodBeat.o(116098);
        return obj;
    }

    public final V put(K k, V v) {
        AppMethodBeat.i(116099);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(116099);
            throw nullPointerException;
        }
        Object put = this.eRT.put(k, v);
        AppMethodBeat.o(116099);
        return put;
    }

    public final synchronized Map<K, V> snapshot() {
        Map snapshot;
        AppMethodBeat.i(116100);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(116100);
            throw nullPointerException;
        }
        snapshot = this.eRT.snapshot();
        AppMethodBeat.o(116100);
        return snapshot;
    }

    public final synchronized String toString() {
        String obj;
        AppMethodBeat.i(116101);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(116101);
            throw nullPointerException;
        }
        obj = this.eRT.toString();
        AppMethodBeat.o(116101);
        return obj;
    }
}
