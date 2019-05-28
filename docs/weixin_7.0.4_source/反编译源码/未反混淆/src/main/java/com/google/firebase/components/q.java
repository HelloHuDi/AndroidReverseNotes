package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class q implements a {
    private final d bvk;
    private final b bvl;

    q(d dVar, b bVar) {
        this.bvk = dVar;
        this.bvl = bVar;
    }

    public final Object get() {
        AppMethodBeat.i(10629);
        Object a = p.a(this.bvk, this.bvl);
        AppMethodBeat.o(10629);
        return a;
    }
}
