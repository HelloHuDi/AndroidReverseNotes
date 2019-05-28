package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends i {
    private final d bmz;

    public e(d dVar) {
        this.bmz = dVar;
    }

    public final void release() {
        AppMethodBeat.i(95616);
        d dVar = this.bmz;
        clear();
        dVar.bmw.add(this);
        AppMethodBeat.o(95616);
    }
}
