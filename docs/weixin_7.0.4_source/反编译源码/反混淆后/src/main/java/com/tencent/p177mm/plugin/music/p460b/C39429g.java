package com.tencent.p177mm.plugin.music.p460b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C37496c;
import com.tencent.p177mm.p230g.p231a.C18405u;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d.C34579a;
import com.tencent.p177mm.plugin.music.p463f.p464a.C39436e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5031ax;
import com.tencent.p177mm.sdk.platformtools.C5031ax.C5030a;

/* renamed from: com.tencent.mm.plugin.music.b.g */
public abstract class C39429g implements C34578d {
    protected C28541c oJR = null;
    C5031ax oJY;
    protected boolean oJZ;
    protected C34579a oKa;

    /* renamed from: com.tencent.mm.plugin.music.b.g$1 */
    class C394301 implements C5030a {
        C394301() {
        }

        /* renamed from: ih */
        public final void mo4652ih(int i) {
            AppMethodBeat.m2504i(137346);
            switch (i) {
                case 0:
                    if (C39429g.this.oJZ) {
                        C39429g.this.oJZ = false;
                        C39429g.this.resume();
                        AppMethodBeat.m2505o(137346);
                        return;
                    }
                    break;
                case 1:
                case 2:
                    if (C39429g.this.aie()) {
                        C39429g.this.oJZ = true;
                        C39429g.this.pause();
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(137346);
        }
    }

    public abstract String bSQ();

    public abstract String getAppId();

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void bSM() {
        if (this.oJY != null) {
            this.oJY.end();
            this.oJY.dpf();
            this.oJY = null;
        }
    }

    public final void bSN() {
    }

    public final boolean aif() {
        return false;
    }

    public boolean bSO() {
        return false;
    }

    public final C37496c bSP() {
        return null;
    }

    public final void bSR() {
        C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 7;
        c18405u.csP.state = "canplay";
        c18405u.csP.duration = (long) getDuration();
        c18405u.csP.ckD = bSQ();
        c18405u.csP.appId = getAppId();
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
    }

    public final void bSS() {
        C4990ab.m7417i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", Boolean.valueOf(aie()));
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 0;
        c18405u.csP.state = "play";
        c18405u.csP.ckD = bSQ();
        c18405u.csP.appId = getAppId();
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.onStart(bSQ());
        }
    }

    public final void bST() {
        C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 1;
        c18405u.csP.state = "play";
        c18405u.csP.ckD = bSQ();
        c18405u.csP.appId = getAppId();
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.onStart(bSQ());
        }
    }

    public final void bSU() {
        C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 2;
        c18405u.csP.state = "pause";
        c18405u.csP.ckD = bSQ();
        c18405u.csP.appId = getAppId();
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.mo46562Ss(bSQ());
        }
    }

    public final void bSV() {
        C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 3;
        c18405u.csP.state = "stop";
        c18405u.csP.ckD = bSQ();
        c18405u.csP.appId = getAppId();
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.mo46561Lu(bSQ());
        }
    }

    public final void bSW() {
        C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 6;
        c18405u.csP.state = "seeked";
        c18405u.csP.ckD = bSQ();
        c18405u.csP.appId = getAppId();
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
    }

    public final void bSX() {
        C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 5;
        c18405u.csP.state = "ended";
        c18405u.csP.ckD = bSQ();
        c18405u.csP.appId = getAppId();
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.mo46563dO(bSQ());
        }
    }

    /* renamed from: zl */
    public final void mo62386zl(int i) {
        C4990ab.m7417i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", Integer.valueOf(i));
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 4;
        c18405u.csP.state = "error";
        c18405u.csP.errCode = C39436e.m67373zS(i);
        c18405u.csP.aIm = C39436e.m67372ph(i);
        c18405u.csP.ckD = bSQ();
        c18405u.csP.appId = getAppId();
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.onError(bSQ());
        }
    }

    public final void bSY() {
        C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
        mo62386zl(-1);
    }

    /* renamed from: a */
    public final void mo55147a(C34579a c34579a) {
        this.oKa = c34579a;
    }

    /* renamed from: a */
    public final void mo62374a(C28541c c28541c) {
        this.oJR = c28541c;
    }
}
