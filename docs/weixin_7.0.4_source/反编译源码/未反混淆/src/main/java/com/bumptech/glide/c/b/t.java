package com.bumptech.glide.c.b;

import android.support.v4.f.k.a;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t<Z> implements u<Z>, c {
    private static final a<t<?>> aCd = com.bumptech.glide.h.a.a.a(20, new com.bumptech.glide.h.a.a.a<t<?>>() {
        public final /* synthetic */ Object mG() {
            AppMethodBeat.i(91868);
            t tVar = new t();
            AppMethodBeat.o(91868);
            return tVar;
        }
    });
    private final b aAq = new b.a();
    private boolean aBU;
    private u<Z> aCe;
    private boolean aCf;

    static {
        AppMethodBeat.i(91876);
        AppMethodBeat.o(91876);
    }

    static <Z> t<Z> d(u<Z> uVar) {
        AppMethodBeat.i(91869);
        t tVar = (t) i.d((t) aCd.aA(), "Argument must not be null");
        tVar.aBU = false;
        tVar.aCf = true;
        tVar.aCe = uVar;
        AppMethodBeat.o(91869);
        return tVar;
    }

    t() {
        AppMethodBeat.i(91870);
        AppMethodBeat.o(91870);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void unlock() {
        AppMethodBeat.i(91871);
        this.aAq.oq();
        if (this.aCf) {
            this.aCf = false;
            if (this.aBU) {
                recycle();
            }
            AppMethodBeat.o(91871);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Already unlocked");
            AppMethodBeat.o(91871);
            throw illegalStateException;
        }
    }

    public final Class<Z> mK() {
        AppMethodBeat.i(91872);
        Class mK = this.aCe.mK();
        AppMethodBeat.o(91872);
        return mK;
    }

    public final Z get() {
        AppMethodBeat.i(91873);
        Object obj = this.aCe.get();
        AppMethodBeat.o(91873);
        return obj;
    }

    public final int getSize() {
        AppMethodBeat.i(91874);
        int size = this.aCe.getSize();
        AppMethodBeat.o(91874);
        return size;
    }

    public final synchronized void recycle() {
        AppMethodBeat.i(91875);
        this.aAq.oq();
        this.aBU = true;
        if (!this.aCf) {
            this.aCe.recycle();
            this.aCe = null;
            aCd.release(this);
        }
        AppMethodBeat.o(91875);
    }

    public final b my() {
        return this.aAq;
    }
}
