package com.tencent.p177mm.plugin.music.p463f;

import android.os.Looper;
import android.support.p057v4.content.C0380b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p230g.p231a.C37752ke.C9394a;
import com.tencent.p177mm.plugin.music.p462e.C39434d;
import com.tencent.p177mm.plugin.music.p462e.C46096a;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d.C34579a;
import com.tencent.p177mm.plugin.music.p463f.p464a.C39436e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5031ax;
import com.tencent.p177mm.sdk.platformtools.C5031ax.C5030a;

/* renamed from: com.tencent.mm.plugin.music.f.a */
public abstract class C36792a implements C34578d {
    public boolean cFK;
    private C5031ax oJY;
    protected boolean oJZ;
    protected C34579a oKa;
    protected String oNs = "";
    protected C39434d oNt;
    protected C46096a oNu;

    /* renamed from: com.tencent.mm.plugin.music.f.a$1 */
    class C126641 implements C5030a {
        C126641() {
        }

        /* renamed from: ih */
        public final void mo4652ih(int i) {
            AppMethodBeat.m2504i(137547);
            switch (i) {
                case 0:
                    if (C36792a.this.oJZ) {
                        C36792a.this.oJZ = false;
                        C36792a.this.resume();
                        AppMethodBeat.m2505o(137547);
                        return;
                    }
                    break;
                case 1:
                case 2:
                    if (C36792a.this.aie()) {
                        C36792a.this.oJZ = true;
                        C36792a.this.pause();
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(137547);
        }
    }

    public abstract void bTI();

    /* Access modifiers changed, original: protected|final */
    public final void bUx() {
        if (this.oJY == null) {
            if (C0380b.checkSelfPermission(C4996ah.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
                C4990ab.m7412e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
                return;
            }
            this.oJY = new C5031ax();
            this.oJY.mo10368gK(C4996ah.getContext());
            this.oJY.mo10365a(new C126641());
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bSM() {
        if (this.oJY != null) {
            this.oJY.end();
            this.oJY.dpf();
            this.oJY = null;
        }
    }

    /* renamed from: f */
    public void mo8035f(C9058e c9058e) {
        bTI();
    }

    /* renamed from: y */
    public final void mo58652y(C9058e c9058e) {
        C4990ab.m7417i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", Boolean.valueOf(aie()));
        this.oNs = "waiting";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 11;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "waiting";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
    }

    /* renamed from: z */
    public final void mo58653z(C9058e c9058e) {
        C4990ab.m7417i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", Boolean.valueOf(aie()));
        this.oNs = "canplay";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 9;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "canplay";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
    }

    /* renamed from: A */
    public final void mo58640A(C9058e c9058e) {
        C4990ab.m7417i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", Boolean.valueOf(aie()));
        this.oNs = "play";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 0;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "play";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.mo46663k(c9058e);
        }
    }

    /* renamed from: B */
    public final void mo58641B(C9058e c9058e) {
        C4990ab.m7416i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
        this.oNs = "play";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 1;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "play";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.mo46664l(c9058e);
        }
    }

    /* renamed from: C */
    public final void mo58642C(C9058e c9058e) {
        C4990ab.m7416i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
        this.oNs = "pause";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 3;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "pause";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.mo46666m(c9058e);
        }
    }

    /* renamed from: D */
    public final void mo58643D(C9058e c9058e) {
        C4990ab.m7416i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.oNs = "stop";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 2;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "stop";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C9394a c9394a = c37752ke.cFH;
        boolean z = this.cFK;
        this.cFK = false;
        c9394a.cFK = z;
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.mo46667n(c9058e);
        }
    }

    /* renamed from: E */
    public final void mo58644E(C9058e c9058e) {
        C4990ab.m7416i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
        this.oNs = "seeked";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 8;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "seeked";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
    }

    /* renamed from: F */
    public final void mo58645F(C9058e c9058e) {
        C4990ab.m7416i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
        this.oNs = "seeking";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 12;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "seeking";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
    }

    /* renamed from: G */
    public final void mo58646G(C9058e c9058e) {
        C4990ab.m7416i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.oNs = "ended";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 7;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "ended";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.mo46668o(c9058e);
        }
    }

    /* renamed from: d */
    public final void mo58651d(C9058e c9058e, int i) {
        C4990ab.m7417i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", Integer.valueOf(i));
        this.oNs = "error";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 4;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "error";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = bSO();
        c37752ke.cFH.errCode = C39436e.m67373zS(i);
        c37752ke.cFH.aIm = C39436e.m67372ph(i);
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.mo46654a(c9058e, i);
        }
    }

    /* renamed from: a */
    public void mo46630a(C9058e c9058e, int i, int i2) {
        C4990ab.m7416i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        mo58651d(c9058e, -1);
    }

    /* renamed from: H */
    public final void mo58647H(C9058e c9058e) {
        C4990ab.m7416i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        mo58651d(c9058e, -1);
    }

    /* renamed from: a */
    public final void mo55147a(C34579a c34579a) {
        this.oKa = c34579a;
    }

    /* Access modifiers changed, original: protected|final */
    public final String bUy() {
        return this.oNs;
    }
}
