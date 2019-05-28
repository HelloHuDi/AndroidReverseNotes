package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.i;

public final class e extends i {
    private f ckS;

    public e(f fVar, String str) {
        super(str);
        this.ckS = fVar;
    }

    public final void run() {
        AppMethodBeat.i(137007);
        if (this.ckS != null) {
            this.ckS.Dp();
            this.ckS.end();
        }
        this.ckS = null;
        h.b(this);
        AppMethodBeat.o(137007);
    }
}
