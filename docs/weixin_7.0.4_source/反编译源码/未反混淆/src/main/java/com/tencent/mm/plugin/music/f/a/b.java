package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public abstract class b {
    protected e oLt;
    protected f oNQ;
    public g oNR = new g();

    public abstract void Tr(String str);

    public abstract int bUA();

    public abstract String bUB();

    public abstract boolean bUz();

    public abstract int getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j);

    public abstract void stop();

    public final void a(f fVar) {
        this.oNQ = fVar;
    }

    public final void J(e eVar) {
        this.oLt = eVar;
    }

    public void jy(final boolean z) {
        if (this.oNQ != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(137649);
                    ab.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", Boolean.valueOf(z));
                    b.this.oNQ.c(b.this.oLt, z);
                    AppMethodBeat.o(137649);
                }
            });
        }
    }

    public final void onStart() {
        if (this.oNQ != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(137650);
                    ab.i("MicroMsg.Music.BasePlayer", "onStart %b", Boolean.valueOf(b.this.isPlaying()));
                    b.this.oNQ.k(b.this.oLt);
                    AppMethodBeat.o(137650);
                }
            });
        }
    }

    public final void zR(final int i) {
        if (this.oNQ != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(137651);
                    if (b.this.bUz()) {
                        b.this.oNQ.I(b.this.oLt);
                    }
                    AppMethodBeat.o(137651);
                }
            });
        }
    }

    public void jz(final boolean z) {
        if (this.oNQ != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(137652);
                    ab.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", Boolean.valueOf(z));
                    b.this.oNQ.b(b.this.oLt, z);
                    AppMethodBeat.o(137652);
                }
            });
        }
    }
}
