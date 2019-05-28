package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.mm.aw.c;
import com.tencent.mm.g.a.u;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ax;

public abstract class g implements d {
    protected c oJR = null;
    ax oJY;
    protected boolean oJZ;
    protected a oKa;

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

    public final c bSP() {
        return null;
    }

    public final void bSR() {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
        b uVar = new u();
        uVar.csP.action = 7;
        uVar.csP.state = "canplay";
        uVar.csP.duration = (long) getDuration();
        uVar.csP.ckD = bSQ();
        uVar.csP.appId = getAppId();
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
    }

    public final void bSS() {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", Boolean.valueOf(aie()));
        b uVar = new u();
        uVar.csP.action = 0;
        uVar.csP.state = "play";
        uVar.csP.ckD = bSQ();
        uVar.csP.appId = getAppId();
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.onStart(bSQ());
        }
    }

    public final void bST() {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
        b uVar = new u();
        uVar.csP.action = 1;
        uVar.csP.state = "play";
        uVar.csP.ckD = bSQ();
        uVar.csP.appId = getAppId();
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.onStart(bSQ());
        }
    }

    public final void bSU() {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
        b uVar = new u();
        uVar.csP.action = 2;
        uVar.csP.state = "pause";
        uVar.csP.ckD = bSQ();
        uVar.csP.appId = getAppId();
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.Ss(bSQ());
        }
    }

    public final void bSV() {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        b uVar = new u();
        uVar.csP.action = 3;
        uVar.csP.state = "stop";
        uVar.csP.ckD = bSQ();
        uVar.csP.appId = getAppId();
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.Lu(bSQ());
        }
    }

    public final void bSW() {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
        b uVar = new u();
        uVar.csP.action = 6;
        uVar.csP.state = "seeked";
        uVar.csP.ckD = bSQ();
        uVar.csP.appId = getAppId();
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
    }

    public final void bSX() {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        b uVar = new u();
        uVar.csP.action = 5;
        uVar.csP.state = "ended";
        uVar.csP.ckD = bSQ();
        uVar.csP.appId = getAppId();
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.dO(bSQ());
        }
    }

    public final void zl(int i) {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", Integer.valueOf(i));
        b uVar = new u();
        uVar.csP.action = 4;
        uVar.csP.state = "error";
        uVar.csP.errCode = e.zS(i);
        uVar.csP.aIm = e.ph(i);
        uVar.csP.ckD = bSQ();
        uVar.csP.appId = getAppId();
        com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
        if (this.oJR != null) {
            this.oJR.onError(bSQ());
        }
    }

    public final void bSY() {
        ab.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
        zl(-1);
    }

    public final void a(a aVar) {
        this.oKa = aVar;
    }

    public final void a(c cVar) {
        this.oJR = cVar;
    }
}
