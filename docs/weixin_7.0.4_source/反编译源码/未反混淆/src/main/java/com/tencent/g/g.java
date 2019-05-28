package com.tencent.g;

import com.tencent.g.b.a;
import com.tencent.g.b.b;
import com.tencent.g.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g implements b {
    private f AHI;
    d AHJ;
    b AHK;
    a AHL;
    int mReferenceCount = 0;
    int mState;

    public g(f fVar, d dVar) {
        this.AHI = fVar;
        this.AHJ = dVar;
    }

    public final void start() {
        AppMethodBeat.i(127761);
        this.AHI.a(this);
        AppMethodBeat.o(127761);
    }
}
