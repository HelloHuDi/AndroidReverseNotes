package com.google.android.exoplayer2.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c extends i {
    private final b blc;

    public c(b bVar) {
        this.blc = bVar;
    }

    public final void release() {
        AppMethodBeat.i(95635);
        this.blc.a((i) this);
        AppMethodBeat.o(95635);
    }
}
