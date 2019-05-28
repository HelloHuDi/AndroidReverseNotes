package com.tencent.mm.memory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f.b;
import java.util.Map;

public final class c<T, V> extends a<T, V, V, V> {
    public c(int i) {
        super(i);
    }

    public c(b<T, V> bVar) {
        super((b) bVar);
    }

    public final V aX(V v) {
        return v;
    }

    public final V aV(V v) {
        return v;
    }

    public final V o(T t, V v) {
        return v;
    }

    public final T Xn() {
        return null;
    }

    public final Map<T, V> snapshot() {
        AppMethodBeat.i(115443);
        Map snapshot = this.feD.snapshot();
        AppMethodBeat.o(115443);
        return snapshot;
    }
}
