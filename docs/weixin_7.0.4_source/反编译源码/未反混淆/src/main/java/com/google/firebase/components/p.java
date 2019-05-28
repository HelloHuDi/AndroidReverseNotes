package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p<T> implements a<T> {
    private static final Object bvh = new Object();
    private volatile Object bvi = bvh;
    private volatile a<T> bvj;

    static {
        AppMethodBeat.i(10628);
        AppMethodBeat.o(10628);
    }

    p(d<T> dVar, b bVar) {
        AppMethodBeat.i(10625);
        this.bvj = new q(dVar, bVar);
        AppMethodBeat.o(10625);
    }

    static final /* synthetic */ Object a(d dVar, b bVar) {
        AppMethodBeat.i(10627);
        Object a = dVar.a(bVar);
        AppMethodBeat.o(10627);
        return a;
    }

    public final T get() {
        AppMethodBeat.i(10626);
        T t = this.bvi;
        if (t == bvh) {
            synchronized (this) {
                try {
                    t = this.bvi;
                    if (t == bvh) {
                        t = this.bvj.get();
                        this.bvi = t;
                        this.bvj = null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10626);
                    }
                }
            }
        }
        AppMethodBeat.o(10626);
        return t;
    }
}
