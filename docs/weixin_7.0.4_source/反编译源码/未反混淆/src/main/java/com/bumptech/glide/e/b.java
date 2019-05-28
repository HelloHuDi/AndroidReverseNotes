package com.bumptech.glide.e;

import com.bumptech.glide.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private final List<f> azH = new ArrayList();

    public b() {
        AppMethodBeat.i(92432);
        AppMethodBeat.o(92432);
    }

    public final synchronized List<f> nK() {
        return this.azH;
    }

    public final synchronized void a(f fVar) {
        AppMethodBeat.i(92433);
        this.azH.add(fVar);
        AppMethodBeat.o(92433);
    }
}
