package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.h.a;
import com.tencent.mm.plugin.music.h.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends h {
    static k oLY;
    public a oLX = null;
    private a oLZ;

    private k(a aVar) {
        this.oLX = aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (k.class) {
            AppMethodBeat.i(137534);
            if (oLY != null) {
                ab.e("MicroMsg.Music.MusicPlayerManager", "music player mgr is init, don't it again");
                oLY.oLX = aVar;
                aVar.a(oLY);
                aVar.init();
                AppMethodBeat.o(137534);
            } else {
                oLY = new k(aVar);
                aVar.a(oLY);
                aVar.init();
                AppMethodBeat.o(137534);
            }
        }
    }

    public static k bUf() {
        AppMethodBeat.i(137535);
        if (oLY == null) {
            NullPointerException nullPointerException = new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
            AppMethodBeat.o(137535);
            throw nullPointerException;
        }
        if (oLY.oLX == null) {
            oLY.oLX = new i();
        }
        k kVar = oLY;
        AppMethodBeat.o(137535);
        return kVar;
    }

    public static synchronized void bUg() {
        synchronized (k.class) {
            AppMethodBeat.i(137536);
            if (oLY != null) {
                oLY.finish();
            }
            AppMethodBeat.o(137536);
        }
    }

    public final void p(e eVar) {
        AppMethodBeat.i(137537);
        if (eVar != null) {
            ab.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", Integer.valueOf(eVar.fJS));
        }
        ab.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
        t(this.oLX.i(eVar));
        AppMethodBeat.o(137537);
    }

    /* Access modifiers changed, original: final */
    public final void t(e eVar) {
        AppMethodBeat.i(137538);
        d.M(eVar);
        if (this.oLX.g(eVar)) {
            q(eVar);
            AppMethodBeat.o(137538);
            return;
        }
        ab.e("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
        AppMethodBeat.o(137538);
    }

    public final com.tencent.mm.plugin.music.f.a.d bTS() {
        AppMethodBeat.i(137539);
        com.tencent.mm.plugin.music.f.a.d bTS = super.bTS();
        AppMethodBeat.o(137539);
        return bTS;
    }

    public final void aic() {
        AppMethodBeat.i(137540);
        super.aic();
        AppMethodBeat.o(137540);
    }

    public final void release() {
        AppMethodBeat.i(137541);
        ab.i("MicroMsg.Music.MusicPlayerManager", "release");
        super.release();
        AppMethodBeat.o(137541);
    }

    public final void finish() {
        AppMethodBeat.i(137542);
        super.finish();
        this.oLX.release();
        this.oLZ = null;
        AppMethodBeat.o(137542);
    }

    public final void ju(boolean z) {
        AppMethodBeat.i(137543);
        super.ju(z);
        AppMethodBeat.o(137543);
    }

    public final void zI(int i) {
        AppMethodBeat.i(137544);
        super.zI(i);
        AppMethodBeat.o(137544);
    }

    public final e bTQ() {
        AppMethodBeat.i(137545);
        e bTQ = this.oLX.bTQ();
        AppMethodBeat.o(137545);
        return bTQ;
    }

    public static a bUh() {
        AppMethodBeat.i(137546);
        if (bUf().oLZ == null) {
            bUf().oLZ = new a();
        }
        a aVar = bUf().oLZ;
        AppMethodBeat.o(137546);
        return aVar;
    }
}
