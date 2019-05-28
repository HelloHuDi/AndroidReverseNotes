package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;

public final class b {
    private static b ckK;
    private ArrayList<d> ckL = new ArrayList();
    private long ckM = 3000000;
    private int count = 0;
    private Object sLock = new Object();
    private int size = 0;

    private b() {
        AppMethodBeat.i(136983);
        AppMethodBeat.o(136983);
    }

    public static b Di() {
        AppMethodBeat.i(136984);
        if (ckK == null) {
            synchronized (c.class) {
                try {
                    if (ckK == null) {
                        ckK = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136984);
                    }
                }
            }
        }
        b bVar = ckK;
        AppMethodBeat.o(136984);
        return bVar;
    }

    public final d Dj() {
        d dVar;
        AppMethodBeat.i(136985);
        synchronized (this.sLock) {
            try {
                if (this.ckL.size() > 0) {
                    dVar = (d) this.ckL.remove(this.ckL.size() - 1);
                } else if (((long) this.size) >= this.ckM) {
                    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "size >= FIX_SIZE, size:%d", Integer.valueOf(this.size));
                    AppMethodBeat.o(136985);
                    return null;
                } else {
                    this.count++;
                    this.size = this.count * 3536;
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "pool tract count:%d", Integer.valueOf(this.count));
                    dVar = new d();
                    dVar.ckH = true;
                    AppMethodBeat.o(136985);
                    return dVar;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(136985);
            }
        }
        return dVar;
    }

    public final void b(d dVar) {
        AppMethodBeat.i(136986);
        if (dVar == null || dVar.ckv == null) {
            AppMethodBeat.o(136986);
        } else if (dVar.ckH) {
            dVar.reset();
            synchronized (this.sLock) {
                try {
                    this.ckL.add(0, dVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(136986);
                }
            }
        } else {
            AppMethodBeat.o(136986);
        }
    }
}
