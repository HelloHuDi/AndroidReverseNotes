package com.tencent.p177mm.plugin.music.p463f;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p198aw.C37496c;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.music.cache.C39432e;
import com.tencent.p177mm.plugin.music.p1282c.C21339b;
import com.tencent.p177mm.plugin.music.p1282c.C21339b.C21341b;
import com.tencent.p177mm.plugin.music.p462e.C39434d;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C28564b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C46099f;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.plugin.music.f.d */
public final class C3529d extends C36792a {
    boolean oKe;
    C9058e oLA;
    public boolean oLN = false;
    C28564b oNA;
    boolean oNB;
    private C37496c oNC;
    C21341b oND = new C35322();
    C21339b oNh;

    /* renamed from: com.tencent.mm.plugin.music.f.d$1 */
    class C35301 implements C46099f {
        long oNE;

        /* renamed from: com.tencent.mm.plugin.music.f.d$1$1 */
        class C35311 implements Runnable {
            C35311() {
            }

            public final void run() {
                AppMethodBeat.m2504i(137577);
                if (System.currentTimeMillis() - C35301.this.oNE > 10000) {
                    C35301.this.oNE = System.currentTimeMillis();
                    Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d3y), 0).show();
                }
                AppMethodBeat.m2505o(137577);
            }
        }

        C35301() {
        }

        /* renamed from: k */
        public final void mo8044k(C9058e c9058e) {
            AppMethodBeat.m2504i(137578);
            C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
            C3529d.this.mo58640A(c9058e);
            AppMethodBeat.m2505o(137578);
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: I */
        public final void mo8041I(C9058e c9058e) {
            AppMethodBeat.m2504i(137579);
            C9058e bTQ = C39435k.bUf().bTQ();
            if (bTQ == null) {
                AppMethodBeat.m2505o(137579);
                return;
            }
            if (bTQ.mo20537e(c9058e) && C3529d.this.oNA != null && C3529d.this.oNA.isPlaying()) {
                int bUA = C3529d.this.oNA.bUA();
                int duration = C3529d.this.oNA.getDuration();
                if (bUA > 0 && duration > 0) {
                    float f = ((float) bUA) / ((float) duration);
                    if (C3529d.this.oNh != null) {
                        float f2;
                        C21339b c21339b = C3529d.this.oNh;
                        c21339b.oLv = f;
                        boolean isNetworkConnected = C5023at.isNetworkConnected(C4996ah.getContext());
                        if (c21339b.isStop && isNetworkConnected) {
                            if (c21339b.mgU) {
                                if (c21339b.oLu.oLr != 0) {
                                    f2 = ((float) c21339b.oLu.oLp) / ((float) c21339b.oLu.oLr);
                                }
                            } else if (c21339b.oLu.oLo != 0) {
                                f2 = ((float) c21339b.oLu.oLn) / ((float) c21339b.oLu.oLo);
                            }
                            if (f2 < 1.0f && f2 - f <= 0.15f && isNetworkConnected) {
                                C4990ab.m7419v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(isNetworkConnected));
                                c21339b.start();
                            }
                        }
                        if (C3529d.this.oNh != null && C3529d.this.oNh.isStop) {
                            Object obj;
                            C21339b c21339b2 = C3529d.this.oNh;
                            if (c21339b2.mgU) {
                                if (c21339b2.oLu.oLr != 0) {
                                    f2 = ((float) c21339b2.oLu.oLp) / ((float) c21339b2.oLu.oLr);
                                }
                                obj = null;
                                if (obj == null) {
                                    C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                    C3529d.this.stopPlay();
                                }
                            } else {
                                if (c21339b2.oLu.oLo != 0) {
                                    f2 = ((float) c21339b2.oLu.oLn) / ((float) c21339b2.oLu.oLo);
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
                    if (C3529d.this.oKa != null) {
                        C3529d.this.oKa.mo46715dN(bUA, duration);
                    }
                }
            }
            AppMethodBeat.m2505o(137579);
        }

        /* renamed from: b */
        public final void mo8042b(C9058e c9058e, boolean z) {
            AppMethodBeat.m2504i(137580);
            C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
            C9058e bTQ = C39435k.bUf().bTQ();
            if (bTQ == null) {
                AppMethodBeat.m2505o(137580);
                return;
            }
            if (bTQ.mo20537e(c9058e)) {
                C3529d.this.stopPlay();
            }
            C3529d.this.mo58643D(C3529d.this.oLA);
            if (z) {
                C3529d.this.mo58646G(C3529d.this.oLA);
            }
            AppMethodBeat.m2505o(137580);
        }

        /* renamed from: c */
        public final void mo8043c(C9058e c9058e, boolean z) {
            AppMethodBeat.m2504i(137581);
            C9058e bTQ = C39435k.bUf().bTQ();
            if (bTQ == null) {
                AppMethodBeat.m2505o(137581);
                return;
            }
            C4990ab.m7417i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", Boolean.valueOf(z));
            if (z) {
                C3529d.m5814a(C3529d.this, c9058e, 20);
            } else {
                C3529d.m5814a(C3529d.this, c9058e, 21);
            }
            if (bTQ.mo20537e(c9058e)) {
                C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "stop");
                C3529d.this.stopPlay();
                if (z) {
                    C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "retry system media player again");
                    C3529d.this.mo8025a(bTQ, true);
                    C3529d.this.oNh = new C21339b(c9058e, C39432e.m67339SU(c9058e.fJU));
                    C3529d.this.oNh.oLy = C3529d.this.oND;
                    C3529d.this.oNh.start();
                    if (C3529d.this.oNt != null) {
                        C3529d.this.oNt.mo24645a(C3529d.this.oNh);
                        AppMethodBeat.m2505o(137581);
                        return;
                    }
                }
                C5004al.m7441d(new C35311());
                C3529d.this.mo58643D(C3529d.this.oLA);
                AppMethodBeat.m2505o(137581);
                return;
            }
            C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "send stop event");
            C3529d.this.mo58643D(C3529d.this.oLA);
            AppMethodBeat.m2505o(137581);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.d$2 */
    class C35322 implements C21341b {

        /* renamed from: com.tencent.mm.plugin.music.f.d$2$2 */
        class C35332 implements Runnable {
            C35332() {
            }

            public final void run() {
                AppMethodBeat.m2504i(137583);
                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d47), 1).show();
                AppMethodBeat.m2505o(137583);
            }
        }

        C35322() {
        }

        /* renamed from: zD */
        public final void mo8046zD(final int i) {
            AppMethodBeat.m2504i(137584);
            if (i == 1) {
                if (!(C3529d.this.oNh == null || C3529d.this.oKe || C3529d.this.oNA == null)) {
                    C3529d.this.oNA.mo46681Tr(C12673b.m20673aW(C3529d.this.oNh.oLt.fJU, C3529d.this.oNh.mgU));
                    C3529d c3529d = C3529d.this;
                    if (C39435k.bUh().requestFocus()) {
                        C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "startPlay");
                        try {
                            if (c3529d.oNA != null) {
                                c3529d.oNA.play();
                            }
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "startPlay", new Object[0]);
                        }
                        c3529d.oKe = true;
                        c3529d.oNB = false;
                        AppMethodBeat.m2505o(137584);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.Music.MusicPlayer", "request focus error");
                    AppMethodBeat.m2505o(137584);
                    return;
                }
            } else if (i == -2 || i == 5 || i == 19) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(137582);
                        Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d47), 0).show();
                        C3529d.m5814a(C3529d.this, C3529d.this.oLA, i);
                        AppMethodBeat.m2505o(137582);
                    }
                });
                AppMethodBeat.m2505o(137584);
                return;
            } else if (i == -1 || i == 6 || i == 4) {
                C5004al.m7441d(new C35332());
                C3529d.m5814a(C3529d.this, C3529d.this.oLA, i);
            }
            AppMethodBeat.m2505o(137584);
        }
    }

    public C3529d() {
        AppMethodBeat.m2504i(137585);
        AppMethodBeat.m2505o(137585);
    }

    /* renamed from: f */
    public final void mo8035f(C9058e c9058e) {
        AppMethodBeat.m2504i(137586);
        super.mo8035f(c9058e);
        C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "init and start download");
        stopPlay();
        if (c9058e == null) {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "music is null");
            AppMethodBeat.m2505o(137586);
            return;
        }
        this.oNh = new C21339b(c9058e, C39432e.m67339SU(c9058e.fJU));
        this.oNh.oLy = this.oND;
        if (this.oNt != null) {
            this.oNt.mo24651s(c9058e);
            C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
            this.oNt.bTT();
            this.oNt.mo24645a(this.oNh);
        }
        this.oLA = c9058e;
        mo8025a(c9058e, false);
        C4990ab.m7417i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", c9058e.fKa, c9058e.playUrl);
        this.oNh.start();
        bUx();
        AppMethodBeat.m2505o(137586);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bTI() {
        AppMethodBeat.m2504i(137587);
        this.oNt = (C39434d) C43329b.m77295ar(C39434d.class);
        this.oNu = C39435k.bUf().oLX;
        AppMethodBeat.m2505o(137587);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo8025a(C9058e c9058e, boolean z) {
        AppMethodBeat.m2504i(137588);
        if (this.oNA == null) {
            if (z || !C1443d.m3069iX(15)) {
                C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
                this.oNA = new C43327b();
            } else {
                C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
                this.oNA = new C31375c();
            }
            this.oNA.mo46680J(c9058e);
            this.oNA.mo46682a(new C35301());
        }
        AppMethodBeat.m2505o(137588);
    }

    public final void pause() {
        AppMethodBeat.m2504i(137589);
        this.oLN = false;
        C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "pause");
        try {
            if (this.oNA != null && this.oNA.isPlaying()) {
                this.oNA.pause();
                this.oNB = true;
                mo58642C(this.oLA);
            }
            AppMethodBeat.m2505o(137589);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "pause", new Object[0]);
            AppMethodBeat.m2505o(137589);
        }
    }

    public final void bTb() {
        AppMethodBeat.m2504i(137590);
        C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
        pause();
        C39435k.bUh().bSK();
        AppMethodBeat.m2505o(137590);
    }

    public final boolean aif() {
        return this.oKe && this.oLN;
    }

    public final void bSN() {
        AppMethodBeat.m2504i(137591);
        this.oLN = true;
        C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "passivePause");
        try {
            if (this.oNA != null && this.oNA.isPlaying()) {
                this.oNA.pause();
                mo58642C(this.oLA);
            }
            AppMethodBeat.m2505o(137591);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "passivePause", new Object[0]);
            AppMethodBeat.m2505o(137591);
        }
    }

    public final void resume() {
        AppMethodBeat.m2504i(137592);
        try {
            if (this.oNA == null || this.oNA.isPlaying()) {
                C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "music is playing");
                AppMethodBeat.m2505o(137592);
                return;
            }
            C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "resume");
            if (C39435k.bUh().requestFocus()) {
                this.oNA.play();
                mo58641B(this.oLA);
                AppMethodBeat.m2505o(137592);
                return;
            }
            C4990ab.m7412e("MicroMsg.Music.MusicPlayer", "request focus error");
            AppMethodBeat.m2505o(137592);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "resume", new Object[0]);
            AppMethodBeat.m2505o(137592);
        }
    }

    public final boolean aie() {
        boolean z = false;
        AppMethodBeat.m2504i(137593);
        if (this.oNA != null) {
            try {
                z = this.oNA.isPlaying();
                AppMethodBeat.m2505o(137593);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(137593);
            }
        } else {
            AppMethodBeat.m2505o(137593);
        }
        return z;
    }

    public final boolean aig() {
        return this.oKe;
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(137594);
        C4990ab.m7416i("MicroMsg.Music.MusicPlayer", "stopPlay");
        if (this.oNA != null && (this.oNA instanceof C31375c)) {
            m5813Ts(this.oNA.bUB());
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
            C4990ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "stopPlay", new Object[0]);
        }
        C39435k.bUh().bSK();
        this.oKe = false;
        this.oLN = false;
        AppMethodBeat.m2505o(137594);
    }

    public final int bTi() {
        AppMethodBeat.m2504i(137595);
        if (this.oNA != null) {
            int bUA = this.oNA.bUA();
            AppMethodBeat.m2505o(137595);
            return bUA;
        }
        AppMethodBeat.m2505o(137595);
        return -1;
    }

    public final int getDuration() {
        AppMethodBeat.m2504i(137596);
        if (this.oNA != null) {
            int duration = this.oNA.getDuration();
            AppMethodBeat.m2505o(137596);
            return duration;
        }
        AppMethodBeat.m2505o(137596);
        return -1;
    }

    private int getDownloadPercent() {
        AppMethodBeat.m2504i(137597);
        if (this.oNh != null) {
            int i;
            C21339b c21339b = this.oNh;
            if (c21339b.mgU) {
                C4990ab.m7419v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", Long.valueOf(c21339b.oLu.oLr), Long.valueOf(c21339b.oLu.oLp));
                i = c21339b.oLu.oLr != 0 ? (int) ((c21339b.oLu.oLp * 100) / c21339b.oLu.oLr) : 0;
            } else {
                C4990ab.m7419v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", Long.valueOf(c21339b.oLu.oLo), Long.valueOf(c21339b.oLu.oLn));
                i = c21339b.oLu.oLo != 0 ? (int) ((c21339b.oLu.oLn * 100) / c21339b.oLu.oLo) : 0;
            }
            if (i > 0) {
                AppMethodBeat.m2505o(137597);
                return i;
            }
            AppMethodBeat.m2505o(137597);
            return 0;
        }
        AppMethodBeat.m2505o(137597);
        return 0;
    }

    /* renamed from: lP */
    public final boolean mo8037lP(int i) {
        AppMethodBeat.m2504i(137598);
        C4990ab.m7417i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", Integer.valueOf(i));
        try {
            int duration = getDuration();
            int downloadPercent = getDownloadPercent();
            if (duration < 0 || i > duration) {
                C4990ab.m7412e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
                stopPlay();
                AppMethodBeat.m2505o(137598);
                return false;
            }
            duration = (int) ((((double) downloadPercent) / 100.0d) * ((double) duration));
            if (downloadPercent != 100 && i > duration) {
                i = duration - 2000;
                C4990ab.m7417i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", Integer.valueOf(i));
            }
            if (this.oNA != null && i >= 0) {
                this.oNA.seek((long) i);
                mo58644E(this.oLA);
                AppMethodBeat.m2505o(137598);
                return true;
            }
            AppMethodBeat.m2505o(137598);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "seekTo", new Object[0]);
        }
    }

    public final C37496c bSP() {
        int i;
        AppMethodBeat.m2504i(137599);
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
        C4990ab.m7417i("MicroMsg.Music.MusicPlayer", "get music status = %d", Integer.valueOf(i));
        int downloadPercent = getDownloadPercent();
        if (duration <= 0) {
            downloadPercent = 0;
        }
        if (this.oNC != null) {
            this.oNC.mo60427t(duration, bTi, i, downloadPercent);
        } else {
            this.oNC = new C37496c(duration, bTi, i, downloadPercent);
        }
        this.oNC.cFJ = false;
        this.oNC.fJR = bUy();
        C37496c c37496c = this.oNC;
        AppMethodBeat.m2505o(137599);
        return c37496c;
    }

    public final boolean bSO() {
        return false;
    }

    /* renamed from: Ts */
    private void m5813Ts(String str) {
        AppMethodBeat.m2504i(137600);
        if (this.oNt != null) {
            this.oNt.mo24644a(this.oLA, str);
        }
        AppMethodBeat.m2505o(137600);
    }

    /* renamed from: a */
    static /* synthetic */ void m5814a(C3529d c3529d, C9058e c9058e, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(137601);
        if (c9058e == null) {
            C4990ab.m7412e("MicroMsg.Music.MusicPlayer", "currentMusic is null, don't idKeyReportMusicError");
            AppMethodBeat.m2505o(137601);
            return;
        }
        C4990ab.m7417i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicError, action:%d", Integer.valueOf(i));
        if (c3529d.oNA != null && (c3529d.oNA instanceof C31375c)) {
            i2 = ((C31375c) c3529d.oNA).clN;
        }
        if (c3529d.oNt != null) {
            c3529d.oNt.mo24649c(c3529d.oLA, i, i2);
        }
        AppMethodBeat.m2505o(137601);
    }
}
