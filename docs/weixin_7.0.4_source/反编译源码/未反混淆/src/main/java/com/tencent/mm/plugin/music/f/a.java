package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ax;

public abstract class a implements d {
    public boolean cFK;
    private ax oJY;
    protected boolean oJZ;
    protected com.tencent.mm.plugin.music.f.a.d.a oKa;
    protected String oNs = "";
    protected com.tencent.mm.plugin.music.e.d oNt;
    protected com.tencent.mm.plugin.music.e.a oNu;

    public abstract void bTI();

    /* Access modifiers changed, original: protected|final */
    public final void bUx() {
        if (this.oJY == null) {
            if (b.checkSelfPermission(ah.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
                ab.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
                return;
            }
            this.oJY = new ax();
            this.oJY.gK(ah.getContext());
            this.oJY.a(new com.tencent.mm.sdk.platformtools.ax.a() {
                public final void ih(int i) {
                    AppMethodBeat.i(137547);
                    switch (i) {
                        case 0:
                            if (a.this.oJZ) {
                                a.this.oJZ = false;
                                a.this.resume();
                                AppMethodBeat.o(137547);
                                return;
                            }
                            break;
                        case 1:
                        case 2:
                            if (a.this.aie()) {
                                a.this.oJZ = true;
                                a.this.pause();
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(137547);
                }
            });
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

    public void f(e eVar) {
        bTI();
    }

    public final void y(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", Boolean.valueOf(aie()));
        this.oNs = "waiting";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 11;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "waiting";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
    }

    public final void z(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", Boolean.valueOf(aie()));
        this.oNs = "canplay";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 9;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "canplay";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
    }

    public final void A(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", Boolean.valueOf(aie()));
        this.oNs = "play";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 0;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "play";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.k(eVar);
        }
    }

    public final void B(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
        this.oNs = "play";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 1;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "play";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.l(eVar);
        }
    }

    public final void C(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
        this.oNs = "pause";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 3;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "pause";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.m(eVar);
        }
    }

    public final void D(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.oNs = "stop";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 2;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "stop";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.g.a.ke.a aVar = keVar.cFH;
        boolean z = this.cFK;
        this.cFK = false;
        aVar.cFK = z;
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.n(eVar);
        }
    }

    public final void E(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
        this.oNs = "seeked";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 8;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "seeked";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
    }

    public final void F(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
        this.oNs = "seeking";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 12;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "seeking";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
    }

    public final void G(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.oNs = "ended";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 7;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "ended";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.o(eVar);
        }
    }

    public final void d(e eVar, int i) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", Integer.valueOf(i));
        this.oNs = "error";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 4;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "error";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = bSO();
        keVar.cFH.errCode = com.tencent.mm.plugin.music.f.a.e.zS(i);
        keVar.cFH.aIm = com.tencent.mm.plugin.music.f.a.e.ph(i);
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
        if (this.oNu != null) {
            this.oNu.a(eVar, i);
        }
    }

    public void a(e eVar, int i, int i2) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        d(eVar, -1);
    }

    public final void H(e eVar) {
        ab.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        d(eVar, -1);
    }

    public final void a(com.tencent.mm.plugin.music.f.a.d.a aVar) {
        this.oKa = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final String bUy() {
        return this.oNs;
    }
}
