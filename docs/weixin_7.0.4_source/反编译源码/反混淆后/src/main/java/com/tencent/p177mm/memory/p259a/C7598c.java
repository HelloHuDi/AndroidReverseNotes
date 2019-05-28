package com.tencent.p177mm.memory.p259a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import java.util.Map;

/* renamed from: com.tencent.mm.memory.a.c */
public final class C7598c<T, V> extends C7483a<T, V, V, V> {
    public C7598c(int i) {
        super(i);
    }

    public C7598c(C1175b<T, V> c1175b) {
        super((C1175b) c1175b);
    }

    /* renamed from: aX */
    public final V mo14877aX(V v) {
        return v;
    }

    /* renamed from: aV */
    public final V mo14876aV(V v) {
        return v;
    }

    /* renamed from: o */
    public final V mo14879o(T t, V v) {
        return v;
    }

    /* renamed from: Xn */
    public final T mo14873Xn() {
        return null;
    }

    public final Map<T, V> snapshot() {
        AppMethodBeat.m2504i(115443);
        Map snapshot = this.feD.snapshot();
        AppMethodBeat.m2505o(115443);
        return snapshot;
    }
}
