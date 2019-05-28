package com.bumptech.glide.c.d.e;

import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.d.c.b;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends b<c> implements q {
    public e(c cVar) {
        super(cVar);
    }

    public final Class<c> mK() {
        return c.class;
    }

    public final int getSize() {
        AppMethodBeat.i(92334);
        g gVar = ((c) this.drawable).aFU.aGa;
        int j = j.j(gVar.nD().getWidth(), gVar.nD().getHeight(), gVar.nD().getConfig()) + gVar.aGb.lW();
        AppMethodBeat.o(92334);
        return j;
    }

    public final void recycle() {
        AppMethodBeat.i(92335);
        ((c) this.drawable).stop();
        c cVar = (c) this.drawable;
        cVar.aBU = true;
        g gVar = cVar.aFU.aGa;
        gVar.callbacks.clear();
        gVar.nF();
        gVar.isRunning = false;
        if (gVar.aGf != null) {
            gVar.awX.c(gVar.aGf);
            gVar.aGf = null;
        }
        if (gVar.aGh != null) {
            gVar.awX.c(gVar.aGh);
            gVar.aGh = null;
        }
        if (gVar.aGj != null) {
            gVar.awX.c(gVar.aGj);
            gVar.aGj = null;
        }
        gVar.aGb.clear();
        gVar.aGg = true;
        AppMethodBeat.o(92335);
    }

    public final void initialize() {
        AppMethodBeat.i(92336);
        ((c) this.drawable).ny().prepareToDraw();
        AppMethodBeat.o(92336);
    }
}
