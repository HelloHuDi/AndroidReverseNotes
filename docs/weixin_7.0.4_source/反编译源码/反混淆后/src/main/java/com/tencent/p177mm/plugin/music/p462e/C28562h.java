package com.tencent.p177mm.plugin.music.p462e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.plugin.music.p461d.C28555a;
import com.tencent.p177mm.plugin.music.p463f.C3529d;
import com.tencent.p177mm.plugin.music.p463f.C3535e;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d;
import com.tencent.p177mm.plugin.music.p997h.C34585c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.music.e.h */
public abstract class C28562h implements C46097c {
    private C3529d oLS = new C3529d();
    private C3535e oLT = new C3535e();
    private C28555a oLU = new C28555a();
    private Runnable oLV = new C35261();

    /* renamed from: com.tencent.mm.plugin.music.e.h$1 */
    class C35261 implements Runnable {
        C35261() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137531);
            C4990ab.m7417i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", Boolean.valueOf(C28562h.this.bTS().aig()), Boolean.valueOf(C28562h.this.bTS().aie()));
            if (C28562h.this.bTS().aig() && !r1) {
                C28562h.this.bTS().stopPlay();
            }
            AppMethodBeat.m2505o(137531);
        }
    }

    /* renamed from: q */
    public final void mo46675q(C9058e c9058e) {
        if (C34585c.m56719L(c9058e)) {
            C4990ab.m7416i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
            bUd();
            this.oLU.mo8035f(c9058e);
        } else if (C34585c.m56720zX(c9058e.fJS)) {
            C4990ab.m7416i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
            bUd();
            this.oLT.mo8035f(c9058e);
        } else {
            C4990ab.m7416i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
            bUd();
            this.oLS.mo8035f(c9058e);
        }
        if (c9058e.fJS != 11) {
            C28562h.bUe();
        }
    }

    public C34578d bTS() {
        C9058e bTQ = bTQ();
        if (C34585c.m56719L(bTQ)) {
            return this.oLU;
        }
        if (bTQ == null || !C34585c.m56720zX(bTQ.fJS)) {
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
        C5004al.m7439af(this.oLV);
    }

    public void release() {
        C4990ab.m7416i("MicroMsg.Music.MusicBasePlayEngine", "release");
        if (this.oLT != null) {
            this.oLT.release();
        }
        if (this.oLU != null) {
            this.oLU.release();
        }
        C5004al.m7439af(this.oLV);
    }

    public void finish() {
        aic();
        release();
    }

    /* renamed from: ju */
    public void mo46674ju(boolean z) {
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

    public C9058e bTQ() {
        return null;
    }

    /* renamed from: r */
    public final void mo46676r(C9058e c9058e) {
        if (C34585c.m56719L(c9058e)) {
            this.oLU.mo58647H(c9058e);
        } else if (c9058e == null || !C34585c.m56720zX(c9058e.fJS)) {
            this.oLS.mo58647H(c9058e);
        } else {
            this.oLT.mo58647H(c9058e);
        }
    }

    public static void bUe() {
        C4990ab.m7416i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 10;
        c37752ke.cFH.state = "preempted";
        c37752ke.cFH.appId = "not from app brand appid";
        c37752ke.cFH.cFJ = true;
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
    }

    /* renamed from: zI */
    public void mo46678zI(int i) {
        C4990ab.m7417i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", Integer.valueOf(i));
        C5004al.m7439af(this.oLV);
        C5004al.m7442n(this.oLV, (long) i);
    }
}
