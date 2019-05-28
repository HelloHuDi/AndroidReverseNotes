package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;

public class c {
    private static c ckN;
    private ArrayList<d> ckL = new ArrayList();
    private Object sLock = new Object();

    private c() {
        AppMethodBeat.i(136987);
        AppMethodBeat.o(136987);
    }

    public static c Dk() {
        AppMethodBeat.i(136988);
        if (ckN == null) {
            synchronized (c.class) {
                try {
                    if (ckN == null) {
                        ckN = new c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136988);
                    }
                }
            }
        }
        c cVar = ckN;
        AppMethodBeat.o(136988);
        return cVar;
    }

    public final d Dj() {
        d dVar;
        AppMethodBeat.i(136989);
        synchronized (this.sLock) {
            try {
                if (this.ckL.size() > 0) {
                    dVar = (d) this.ckL.remove(this.ckL.size() - 1);
                } else {
                    dVar = new d();
                    AppMethodBeat.o(136989);
                    return dVar;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136989);
            }
        }
        return dVar;
    }

    public final void b(d dVar) {
        AppMethodBeat.i(136990);
        if (dVar == null || dVar.ckv == null) {
            AppMethodBeat.o(136990);
            return;
        }
        dVar.reset();
        synchronized (this.sLock) {
            try {
                this.ckL.add(0, dVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136990);
            }
        }
    }

    public final synchronized long Dl() {
        long size;
        AppMethodBeat.i(136991);
        size = (long) (this.ckL.size() * 3536);
        AppMethodBeat.o(136991);
        return size;
    }
}
