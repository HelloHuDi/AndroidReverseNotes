package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.plugin.music.f.d;
import com.tencent.mm.plugin.music.f.e;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public abstract class h implements c {
    private d oLS = new d();
    private e oLT = new e();
    private a oLU = new a();
    private Runnable oLV = new Runnable() {
        public final void run() {
            AppMethodBeat.i(137531);
            ab.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", Boolean.valueOf(h.this.bTS().aig()), Boolean.valueOf(h.this.bTS().aie()));
            if (h.this.bTS().aig() && !r1) {
                h.this.bTS().stopPlay();
            }
            AppMethodBeat.o(137531);
        }
    };

    public final void q(com.tencent.mm.aw.e eVar) {
        if (c.L(eVar)) {
            ab.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
            bUd();
            this.oLU.f(eVar);
        } else if (c.zX(eVar.fJS)) {
            ab.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
            bUd();
            this.oLT.f(eVar);
        } else {
            ab.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
            bUd();
            this.oLS.f(eVar);
        }
        if (eVar.fJS != 11) {
            bUe();
        }
    }

    public com.tencent.mm.plugin.music.f.a.d bTS() {
        com.tencent.mm.aw.e bTQ = bTQ();
        if (c.L(bTQ)) {
            return this.oLU;
        }
        if (bTQ == null || !c.zX(bTQ.fJS)) {
            return this.oLS;
        }
        return this.oLT;
    }

    private void bUd() {
        if (this.oLS.aie()) {
            this.oLS.stopPlay();
        }
        if (this.oLT.aie()) {
            this.oLT.stopPlay();
        }
        if (this.oLU.aie()) {
            this.oLU.stopPlay();
        }
    }

    public void aic() {
        this.oLS.stopPlay();
        if (this.oLT != null) {
            this.oLT.stopPlay();
        }
        if (this.oLU != null) {
            this.oLU.stopPlay();
        }
        al.af(this.oLV);
    }

    public void release() {
        ab.i("MicroMsg.Music.MusicBasePlayEngine", "release");
        if (this.oLT != null) {
            this.oLT.release();
        }
        if (this.oLU != null) {
            this.oLU.release();
        }
        al.af(this.oLV);
    }

    public void finish() {
        aic();
        release();
    }

    public void ju(boolean z) {
        if (this.oLS.aie()) {
            this.oLS.cFK = z;
        }
        if (this.oLT.aie()) {
            this.oLT.cFK = z;
        }
        if (this.oLU.aie()) {
            this.oLU.cFK = z;
        }
    }

    public com.tencent.mm.aw.e bTQ() {
        return null;
    }

    public final void r(com.tencent.mm.aw.e eVar) {
        if (c.L(eVar)) {
            this.oLU.H(eVar);
        } else if (eVar == null || !c.zX(eVar.fJS)) {
            this.oLS.H(eVar);
        } else {
            this.oLT.H(eVar);
        }
    }

    public static void bUe() {
        ab.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
        b keVar = new ke();
        keVar.cFH.action = 10;
        keVar.cFH.state = "preempted";
        keVar.cFH.appId = "not from app brand appid";
        keVar.cFH.cFJ = true;
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
    }

    public void zI(int i) {
        ab.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", Integer.valueOf(i));
        al.af(this.oLV);
        al.n(this.oLV, (long) i);
    }
}
