package com.tencent.mm.plugin.music.f;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.b;
import com.tencent.mm.plugin.music.f.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;

public final class d extends a {
    boolean oKe;
    e oLA;
    public boolean oLN = false;
    b oNA;
    boolean oNB;
    private c oNC;
    com.tencent.mm.plugin.music.c.b.b oND = new com.tencent.mm.plugin.music.c.b.b() {
        public final void zD(final int i) {
            AppMethodBeat.i(137584);
            if (i == 1) {
                if (!(d.this.oNh == null || d.this.oKe || d.this.oNA == null)) {
                    d.this.oNA.Tr(com.tencent.mm.plugin.music.h.b.aW(d.this.oNh.oLt.fJU, d.this.oNh.mgU));
                    d dVar = d.this;
                    if (k.bUh().requestFocus()) {
                        ab.i("MicroMsg.Music.MusicPlayer", "startPlay");
                        try {
                            if (dVar.oNA != null) {
                                dVar.oNA.play();
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "startPlay", new Object[0]);
                        }
                        dVar.oKe = true;
                        dVar.oNB = false;
                        AppMethodBeat.o(137584);
                        return;
                    }
                    ab.e("MicroMsg.Music.MusicPlayer", "request focus error");
                    AppMethodBeat.o(137584);
                    return;
                }
            } else if (i == -2 || i == 5 || i == 19) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(137582);
                        Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d47), 0).show();
                        d.a(d.this, d.this.oLA, i);
                        AppMethodBeat.o(137582);
                    }
                });
                AppMethodBeat.o(137584);
                return;
            } else if (i == -1 || i == 6 || i == 4) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(137583);
                        Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d47), 1).show();
                        AppMethodBeat.o(137583);
                    }
                });
                d.a(d.this, d.this.oLA, i);
            }
            AppMethodBeat.o(137584);
        }
    };
    com.tencent.mm.plugin.music.c.b oNh;

    public d() {
        AppMethodBeat.i(137585);
        AppMethodBeat.o(137585);
    }

    public final void f(e eVar) {
        AppMethodBeat.i(137586);
        super.f(eVar);
        ab.i("MicroMsg.Music.MusicPlayer", "init and start download");
        stopPlay();
        if (eVar == null) {
            ab.i("MicroMsg.Music.MusicPlayer", "music is null");
            AppMethodBeat.o(137586);
            return;
        }
        this.oNh = new com.tencent.mm.plugin.music.c.b(eVar, com.tencent.mm.plugin.music.cache.e.SU(eVar.fJU));
        this.oNh.oLy = this.oND;
        if (this.oNt != null) {
            this.oNt.s(eVar);
            ab.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
            this.oNt.bTT();
            this.oNt.a(this.oNh);
        }
        this.oLA = eVar;
        a(eVar, false);
        ab.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", eVar.fKa, eVar.playUrl);
        this.oNh.start();
        bUx();
        AppMethodBeat.o(137586);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bTI() {
        AppMethodBeat.i(137587);
        this.oNt = (com.tencent.mm.plugin.music.e.d) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.e.d.class);
        this.oNu = k.bUf().oLX;
        AppMethodBeat.o(137587);
    }

    /* Access modifiers changed, original: final */
    public final void a(e eVar, boolean z) {
        AppMethodBeat.i(137588);
        if (this.oNA == null) {
            if (z || !com.tencent.mm.compatible.util.d.iX(15)) {
                ab.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
                this.oNA = new b();
            } else {
                ab.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
                this.oNA = new c();
            }
            this.oNA.J(eVar);
            this.oNA.a(new f() {
                long oNE;

                public final void k(e eVar) {
                    AppMethodBeat.i(137578);
                    ab.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
                    d.this.A(eVar);
                    AppMethodBeat.o(137578);
                }

                /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2  */
                /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void I(e eVar) {
                    AppMethodBeat.i(137579);
                    e bTQ = k.bUf().bTQ();
                    if (bTQ == null) {
                        AppMethodBeat.o(137579);
                        return;
                    }
                    if (bTQ.e(eVar) && d.this.oNA != null && d.this.oNA.isPlaying()) {
                        int bUA = d.this.oNA.bUA();
                        int duration = d.this.oNA.getDuration();
                        if (bUA > 0 && duration > 0) {
                            float f = ((float) bUA) / ((float) duration);
                            if (d.this.oNh != null) {
                                float f2;
                                com.tencent.mm.plugin.music.c.b bVar = d.this.oNh;
                                bVar.oLv = f;
                                boolean isNetworkConnected = at.isNetworkConnected(ah.getContext());
                                if (bVar.isStop && isNetworkConnected) {
                                    if (bVar.mgU) {
                                        if (bVar.oLu.oLr != 0) {
                                            f2 = ((float) bVar.oLu.oLp) / ((float) bVar.oLu.oLr);
                                        }
                                    } else if (bVar.oLu.oLo != 0) {
                                        f2 = ((float) bVar.oLu.oLn) / ((float) bVar.oLu.oLo);
                                    }
                                    if (f2 < 1.0f && f2 - f <= 0.15f && isNetworkConnected) {
                                        ab.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(isNetworkConnected));
                                        bVar.start();
                                    }
                                }
                                if (d.this.oNh != null && d.this.oNh.isStop) {
                                    Object obj;
                                    com.tencent.mm.plugin.music.c.b bVar2 = d.this.oNh;
                                    if (bVar2.mgU) {
                                        if (bVar2.oLu.oLr != 0) {
                                            f2 = ((float) bVar2.oLu.oLp) / ((float) bVar2.oLu.oLr);
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            ab.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                            d.this.stopPlay();
                                        }
                                    } else {
                                        if (bVar2.oLu.oLo != 0) {
                                            f2 = ((float) bVar2.oLu.oLn) / ((float) bVar2.oLu.oLo);
                                        }
                                        obj = null;
                                        if (obj == null) {
                                        }
                                    }
                                    if (f2 >= 1.0f) {
                                        obj = 1;
                                    } else {
                                        if (f2 - f > 0.05f) {
                                            obj = 1;
                                        }
                                        obj = null;
                                    }
                                    if (obj == null) {
                                    }
                                }
                            }
                            if (d.this.oKa != null) {
                                d.this.oKa.dN(bUA, duration);
                            }
                        }
                    }
                    AppMethodBeat.o(137579);
                }

                public final void b(e eVar, boolean z) {
                    AppMethodBeat.i(137580);
                    ab.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
                    e bTQ = k.bUf().bTQ();
                    if (bTQ == null) {
                        AppMethodBeat.o(137580);
                        return;
                    }
                    if (bTQ.e(eVar)) {
                        d.this.stopPlay();
                    }
                    d.this.D(d.this.oLA);
                    if (z) {
                        d.this.G(d.this.oLA);
                    }
                    AppMethodBeat.o(137580);
                }

                public final void c(e eVar, boolean z) {
                    AppMethodBeat.i(137581);
                    e bTQ = k.bUf().bTQ();
                    if (bTQ == null) {
                        AppMethodBeat.o(137581);
                        return;
                    }
                    ab.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", Boolean.valueOf(z));
                    if (z) {
                        d.a(d.this, eVar, 20);
                    } else {
                        d.a(d.this, eVar, 21);
                    }
                    if (bTQ.e(eVar)) {
                        ab.i("MicroMsg.Music.MusicPlayer", "stop");
                        d.this.stopPlay();
                        if (z) {
                            ab.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
                            d.this.a(bTQ, true);
                            d.this.oNh = new com.tencent.mm.plugin.music.c.b(eVar, com.tencent.mm.plugin.music.cache.e.SU(eVar.fJU));
                            d.this.oNh.oLy = d.this.oND;
                            d.this.oNh.start();
                            if (d.this.oNt != null) {
                                d.this.oNt.a(d.this.oNh);
                                AppMethodBeat.o(137581);
                                return;
                            }
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(137577);
                                if (System.currentTimeMillis() - AnonymousClass1.this.oNE > 10000) {
                                    AnonymousClass1.this.oNE = System.currentTimeMillis();
                                    Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d3y), 0).show();
                                }
                                AppMethodBeat.o(137577);
                            }
                        });
                        d.this.D(d.this.oLA);
                        AppMethodBeat.o(137581);
                        return;
                    }
                    ab.i("MicroMsg.Music.MusicPlayer", "send stop event");
                    d.this.D(d.this.oLA);
                    AppMethodBeat.o(137581);
                }
            });
        }
        AppMethodBeat.o(137588);
    }

    public final void pause() {
        AppMethodBeat.i(137589);
        this.oLN = false;
        ab.i("MicroMsg.Music.MusicPlayer", "pause");
        try {
            if (this.oNA != null && this.oNA.isPlaying()) {
                this.oNA.pause();
                this.oNB = true;
                C(this.oLA);
            }
            AppMethodBeat.o(137589);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "pause", new Object[0]);
            AppMethodBeat.o(137589);
        }
    }

    public final void bTb() {
        AppMethodBeat.i(137590);
        ab.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
        pause();
        k.bUh().bSK();
        AppMethodBeat.o(137590);
    }

    public final boolean aif() {
        return this.oKe && this.oLN;
    }

    public final void bSN() {
        AppMethodBeat.i(137591);
        this.oLN = true;
        ab.i("MicroMsg.Music.MusicPlayer", "passivePause");
        try {
            if (this.oNA != null && this.oNA.isPlaying()) {
                this.oNA.pause();
                C(this.oLA);
            }
            AppMethodBeat.o(137591);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "passivePause", new Object[0]);
            AppMethodBeat.o(137591);
        }
    }

    public final void resume() {
        AppMethodBeat.i(137592);
        try {
            if (this.oNA == null || this.oNA.isPlaying()) {
                ab.i("MicroMsg.Music.MusicPlayer", "music is playing");
                AppMethodBeat.o(137592);
                return;
            }
            ab.i("MicroMsg.Music.MusicPlayer", "resume");
            if (k.bUh().requestFocus()) {
                this.oNA.play();
                B(this.oLA);
                AppMethodBeat.o(137592);
                return;
            }
            ab.e("MicroMsg.Music.MusicPlayer", "request focus error");
            AppMethodBeat.o(137592);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "resume", new Object[0]);
            AppMethodBeat.o(137592);
        }
    }

    public final boolean aie() {
        boolean z = false;
        AppMethodBeat.i(137593);
        if (this.oNA != null) {
            try {
                z = this.oNA.isPlaying();
                AppMethodBeat.o(137593);
            } catch (Throwable th) {
                AppMethodBeat.o(137593);
            }
        } else {
            AppMethodBeat.o(137593);
        }
        return z;
    }

    public final boolean aig() {
        return this.oKe;
    }

    public final void stopPlay() {
        AppMethodBeat.i(137594);
        ab.i("MicroMsg.Music.MusicPlayer", "stopPlay");
        if (this.oNA != null && (this.oNA instanceof c)) {
            Ts(this.oNA.bUB());
        }
        try {
            if (this.oNh != null) {
                this.oNh.isStop = true;
                this.oNh = null;
            }
            if (this.oNA != null) {
                this.oNA.stop();
                this.oNA = null;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "stopPlay", new Object[0]);
        }
        k.bUh().bSK();
        this.oKe = false;
        this.oLN = false;
        AppMethodBeat.o(137594);
    }

    public final int bTi() {
        AppMethodBeat.i(137595);
        if (this.oNA != null) {
            int bUA = this.oNA.bUA();
            AppMethodBeat.o(137595);
            return bUA;
        }
        AppMethodBeat.o(137595);
        return -1;
    }

    public final int getDuration() {
        AppMethodBeat.i(137596);
        if (this.oNA != null) {
            int duration = this.oNA.getDuration();
            AppMethodBeat.o(137596);
            return duration;
        }
        AppMethodBeat.o(137596);
        return -1;
    }

    private int getDownloadPercent() {
        AppMethodBeat.i(137597);
        if (this.oNh != null) {
            int i;
            com.tencent.mm.plugin.music.c.b bVar = this.oNh;
            if (bVar.mgU) {
                ab.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", Long.valueOf(bVar.oLu.oLr), Long.valueOf(bVar.oLu.oLp));
                i = bVar.oLu.oLr != 0 ? (int) ((bVar.oLu.oLp * 100) / bVar.oLu.oLr) : 0;
            } else {
                ab.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", Long.valueOf(bVar.oLu.oLo), Long.valueOf(bVar.oLu.oLn));
                i = bVar.oLu.oLo != 0 ? (int) ((bVar.oLu.oLn * 100) / bVar.oLu.oLo) : 0;
            }
            if (i > 0) {
                AppMethodBeat.o(137597);
                return i;
            }
            AppMethodBeat.o(137597);
            return 0;
        }
        AppMethodBeat.o(137597);
        return 0;
    }

    public final boolean lP(int i) {
        AppMethodBeat.i(137598);
        ab.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", Integer.valueOf(i));
        try {
            int duration = getDuration();
            int downloadPercent = getDownloadPercent();
            if (duration < 0 || i > duration) {
                ab.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
                stopPlay();
                AppMethodBeat.o(137598);
                return false;
            }
            duration = (int) ((((double) downloadPercent) / 100.0d) * ((double) duration));
            if (downloadPercent != 100 && i > duration) {
                i = duration - 2000;
                ab.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", Integer.valueOf(i));
            }
            if (this.oNA != null && i >= 0) {
                this.oNA.seek((long) i);
                E(this.oLA);
                AppMethodBeat.o(137598);
                return true;
            }
            AppMethodBeat.o(137598);
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "seekTo", new Object[0]);
        }
    }

    public final c bSP() {
        int i;
        AppMethodBeat.i(137599);
        int duration = getDuration();
        int bTi = bTi();
        if (aie()) {
            i = 1;
        } else {
            if (this.oKe && (this.oNB || this.oJZ)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 2;
            }
        }
        ab.i("MicroMsg.Music.MusicPlayer", "get music status = %d", Integer.valueOf(i));
        int downloadPercent = getDownloadPercent();
        if (duration <= 0) {
            downloadPercent = 0;
        }
        if (this.oNC != null) {
            this.oNC.t(duration, bTi, i, downloadPercent);
        } else {
            this.oNC = new c(duration, bTi, i, downloadPercent);
        }
        this.oNC.cFJ = false;
        this.oNC.fJR = bUy();
        c cVar = this.oNC;
        AppMethodBeat.o(137599);
        return cVar;
    }

    public final boolean bSO() {
        return false;
    }

    private void Ts(String str) {
        AppMethodBeat.i(137600);
        if (this.oNt != null) {
            this.oNt.a(this.oLA, str);
        }
        AppMethodBeat.o(137600);
    }

    static /* synthetic */ void a(d dVar, e eVar, int i) {
        int i2 = 0;
        AppMethodBeat.i(137601);
        if (eVar == null) {
            ab.e("MicroMsg.Music.MusicPlayer", "currentMusic is null, don't idKeyReportMusicError");
            AppMethodBeat.o(137601);
            return;
        }
        ab.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicError, action:%d", Integer.valueOf(i));
        if (dVar.oNA != null && (dVar.oNA instanceof c)) {
            i2 = ((c) dVar.oNA).clN;
        }
        if (dVar.oNt != null) {
            dVar.oNt.c(dVar.oLA, i, i2);
        }
        AppMethodBeat.o(137601);
    }
}
