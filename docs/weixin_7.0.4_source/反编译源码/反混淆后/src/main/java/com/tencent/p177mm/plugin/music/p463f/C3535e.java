package com.tencent.p177mm.plugin.music.p463f;

import android.net.Uri;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p198aw.C37496c;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.music.cache.C39433g;
import com.tencent.p177mm.plugin.music.p1362g.p1493a.C39437b;
import com.tencent.p177mm.plugin.music.p462e.C39434d;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C12665a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.music.f.e */
public final class C3535e extends C36792a {
    AudioType audioType = AudioType.UNSUPPORT;
    int bqQ = 0;
    String cle = "";
    CommonPlayer oKc;
    boolean oKe;
    private IMediaHTTPService oKh;
    private long oKj = 0;
    private boolean oKk = false;
    private PlayerListenerCallback oKm = new C35371();
    C9058e oLA;
    private C37496c oLB;
    public boolean oLN = false;
    C3536a oNI;
    private String oNJ;
    int startTime = 0;

    /* renamed from: com.tencent.mm.plugin.music.f.e$a */
    class C3536a implements Runnable {
        boolean isStop;

        private C3536a() {
            this.isStop = true;
        }

        /* synthetic */ C3536a(C3535e c3535e, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(137610);
            C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (C3535e.this.oKc != null && C3535e.this.aie()) {
                        C3535e.this.bTk();
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
            AppMethodBeat.m2505o(137610);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.e$1 */
    class C35371 implements PlayerListenerCallback {
        C9058e oNK = null;

        /* renamed from: com.tencent.mm.plugin.music.f.e$1$1 */
        class C35381 implements Runnable {
            C35381() {
            }

            public final void run() {
                AppMethodBeat.m2504i(137602);
                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d3y), 0).show();
                AppMethodBeat.m2505o(137602);
            }
        }

        C35371() {
        }

        public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
        }

        public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.m2504i(137603);
            C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
            AppMethodBeat.m2505o(137603);
        }

        public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i) {
            AppMethodBeat.m2504i(137604);
            C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", Integer.valueOf(i));
            if (C3535e.this.startTime != 0) {
                C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", Integer.valueOf(C3535e.this.startTime));
                C3535e.this.startTime = 0;
                bUD();
                AppMethodBeat.m2505o(137604);
                return;
            }
            C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
            if (this.oNK == null) {
                C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                AppMethodBeat.m2505o(137604);
                return;
            }
            C3535e.this.mo58644E(this.oNK);
            if (C3535e.this.aie()) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
                C3535e.this.mo58641B(this.oNK);
            }
            AppMethodBeat.m2505o(137604);
        }

        public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
            AppMethodBeat.m2504i(137605);
            C4990ab.m7413e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            C9058e bTQ = C39435k.bUf().bTQ();
            if (bTQ == null) {
                C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
                AppMethodBeat.m2505o(137605);
                return;
            }
            this.oNK = C3535e.this.oLA;
            if (this.oNK == null) {
                C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
                AppMethodBeat.m2505o(137605);
                return;
            }
            boolean isNetworkConnected = C5023at.isNetworkConnected(C4996ah.getContext());
            if (i2 == 80 && isNetworkConnected) {
                C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
            }
            if (C3535e.this.bqQ > 0) {
                C4990ab.m7413e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", Integer.valueOf(C3535e.this.bqQ));
                AppMethodBeat.m2505o(137605);
                return;
            }
            C3535e c3535e = C3535e.this;
            c3535e.bqQ++;
            C3535e.m5824a(C3535e.this, this.oNK, i2);
            if (bTQ.mo20537e(this.oNK)) {
                C3535e.this.stopPlay();
                C5004al.m7441d(new C35381());
            }
            C3535e.this.mo58643D(this.oNK);
            C3535e.this.mo58651d(this.oNK, i2);
            if (C3535e.this.oNI != null) {
                C3535e.this.oNI.isStop = true;
                C3535e.this.oNI = null;
            }
            if (i == 91 && i2 == 55) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
                C39433g.m67343HS(C3535e.this.cle);
            }
            AppMethodBeat.m2505o(137605);
        }

        public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.m2504i(137606);
            C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
            AppMethodBeat.m2505o(137606);
        }

        public final void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i) {
            AppMethodBeat.m2504i(137607);
            C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", Integer.valueOf(i));
            if (i == 3) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
                this.oNK = C3535e.this.oLA;
                if (this.oNK == null) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.m2505o(137607);
                    return;
                }
                C3535e.this.mo58652y(this.oNK);
                AppMethodBeat.m2505o(137607);
            } else if (i == 2) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
                bUD();
                AppMethodBeat.m2505o(137607);
            } else if (i == 4) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "_onStart");
                this.oNK = C3535e.this.oLA;
                if (this.oNK == null) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.m2505o(137607);
                    return;
                }
                if (C3535e.this.oNs == "pause") {
                    C3535e.this.mo58641B(this.oNK);
                } else {
                    C3535e.this.mo58640A(this.oNK);
                }
                if (C3535e.this.oNI != null) {
                    C3535e.this.oNI.isStop = true;
                }
                C3535e.this.oNI = new C3536a(C3535e.this, (byte) 0);
                C3536a c3536a = C3535e.this.oNI;
                c3536a.isStop = false;
                C7305d.post(c3536a, "music_play_progress_runnable");
                AppMethodBeat.m2505o(137607);
            } else if (i == 5) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "_onPause");
                if (this.oNK == null) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.m2505o(137607);
                    return;
                }
                C3535e.this.mo58642C(this.oNK);
                AppMethodBeat.m2505o(137607);
            } else if (i == 6) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "_onStop");
                if (this.oNK == null) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.m2505o(137607);
                    return;
                }
                C9058e bTQ = C39435k.bUf().bTQ();
                if (bTQ == null) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
                    AppMethodBeat.m2505o(137607);
                    return;
                }
                if (bTQ.mo20537e(this.oNK)) {
                    C3535e.this.mo58643D(this.oNK);
                }
                AppMethodBeat.m2505o(137607);
            } else if (i == 7) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
                if (this.oNK == null) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.m2505o(137607);
                    return;
                }
                C3535e.this.oKe = false;
                C3535e.this.mo58646G(C3535e.this.oLA);
                if (C3535e.this.oNI != null) {
                    C3535e.this.oNI.isStop = true;
                    C3535e.this.oNI = null;
                }
                AppMethodBeat.m2505o(137607);
            } else if (i == 8) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
                AppMethodBeat.m2505o(137607);
            } else {
                if (i == 9) {
                    C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
                }
                AppMethodBeat.m2505o(137607);
            }
        }

        public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.m2504i(137608);
            C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "onStarted");
            AppMethodBeat.m2505o(137608);
        }

        private void bUD() {
            AppMethodBeat.m2504i(137609);
            C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
            if (C3535e.this.startTime != 0) {
                C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", Integer.valueOf(C3535e.this.startTime));
                C3535e.this.mo8037lP(C3535e.this.startTime);
                AppMethodBeat.m2505o(137609);
                return;
            }
            C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "start to play");
            if (!C39435k.bUh().requestFocus()) {
                C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "request focus error");
                AppMethodBeat.m2505o(137609);
            } else if (C3535e.this.oLA == null) {
                C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                AppMethodBeat.m2505o(137609);
            } else {
                C3535e.this.mo58653z(C3535e.this.oLA);
                try {
                    if (C3535e.this.oKc != null) {
                        C3535e.this.oKc.start();
                        if (!(C3535e.this.oKc.getCurrentAudioInformation() == null || C3535e.this.oKc.getCurrentAudioInformation().getAudioType() == null)) {
                            C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", Integer.valueOf(C3535e.this.oKc.getCurrentAudioInformation().getAudioType().getValue()));
                            C3535e.this.audioType = C3535e.this.oKc.getCurrentAudioInformation().getAudioType();
                            C3535e.m5823a(C3535e.this);
                        }
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "_onPrepared", new Object[0]);
                    C3535e.this.mo58651d(C3535e.this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                    C3535e.m5824a(C3535e.this, C3535e.this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                }
                C3535e.this.oKe = true;
                AppMethodBeat.m2505o(137609);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5824a(C3535e c3535e, C9058e c9058e, int i) {
        AppMethodBeat.m2504i(137629);
        c3535e.m5825e(c9058e, i);
        AppMethodBeat.m2505o(137629);
    }

    public C3535e() {
        AppMethodBeat.m2504i(137611);
        C12665a.bUE();
        AppMethodBeat.m2505o(137611);
    }

    /* renamed from: f */
    public final void mo8035f(C9058e c9058e) {
        AppMethodBeat.m2504i(137612);
        super.mo8035f(c9058e);
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKj;
        if (this.oLA != null && this.oLA.mo20537e(c9058e) && j <= 3000) {
            this.oLA = c9058e;
            C4990ab.m7413e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.cle, Long.valueOf(j));
            AppMethodBeat.m2505o(137612);
        } else if (c9058e == null) {
            C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "music is null");
            AppMethodBeat.m2505o(137612);
        } else {
            if (this.oNt != null) {
                this.oNt.mo24651s(c9058e);
            }
            this.oKj = currentTimeMillis;
            this.oLA = c9058e;
            C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(c9058e.startTime));
            if (this.oKc != null && aie()) {
                this.oKc.stop();
            }
            C12665a.bUF();
            this.bqQ = 0;
            this.startTime = c9058e.startTime;
            this.audioType = null;
            this.oKk = false;
            C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
            this.cle = this.oLA.playUrl;
            this.oNJ = this.oLA.fKg;
            C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", this.cle, this.oNJ);
            C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", this.oLA.fKa);
            if (!C5046bo.isNullOrNil(this.cle) && C5046bo.isNullOrNil(this.oNJ)) {
                C39433g.m67344SV(this.cle);
                C39433g.m67354cI(this.cle, 0);
                C39433g.m67355cJ(this.cle, 0);
            }
            if (C5046bo.isNullOrNil(this.oNJ)) {
                URL url;
                try {
                    url = new URL(this.cle);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "initPlayer", new Object[0]);
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + e.getMessage());
                    url = null;
                }
                if (url == null) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
                    mo58651d(this.oLA, 500);
                    m5825e(this.oLA, 500);
                } else {
                    if (this.oKc == null) {
                        this.oKc = new CommonPlayer(this.oKm);
                    }
                    this.oKc.reset();
                    if (this.oKh == null) {
                        this.oKh = new C39437b();
                    }
                    try {
                        this.oKc.setDataSource(this.oKh, Uri.parse(url.toString()));
                        this.oKc.prepare();
                    } catch (Exception e2) {
                        C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e2.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "initPlayer", new Object[0]);
                        mo58651d(this.oLA, 501);
                        m5825e(this.oLA, 501);
                    }
                }
            } else {
                C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", this.oNJ);
                if (this.oKc == null) {
                    this.oKc = new CommonPlayer(this.oKm);
                }
                this.oKc.reset();
                if (this.oNJ.startsWith("file://")) {
                    this.oNJ = this.oNJ.substring(7);
                }
                try {
                    this.oKc.setDataSource(this.oNJ);
                    this.oKc.prepare();
                } catch (Exception e22) {
                    C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e22.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e22, "initPlayer", new Object[0]);
                    mo58651d(this.oLA, 501);
                    m5825e(this.oLA, 501);
                }
            }
            bUx();
            AppMethodBeat.m2505o(137612);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bTI() {
        AppMethodBeat.m2504i(137613);
        this.oNt = (C39434d) C43329b.m77295ar(C39434d.class);
        this.oNu = C39435k.bUf().oLX;
        AppMethodBeat.m2505o(137613);
    }

    public final void pause() {
        AppMethodBeat.m2504i(137614);
        this.oLN = false;
        C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "pause");
        if (this.oKc != null && aie()) {
            try {
                this.oKc.pause();
                AppMethodBeat.m2505o(137614);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "pause", new Object[0]);
                mo58651d(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
                m5825e(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            }
        }
        AppMethodBeat.m2505o(137614);
    }

    public final void bTb() {
        AppMethodBeat.m2504i(137615);
        C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
        pause();
        C39435k.bUh().bSK();
        AppMethodBeat.m2505o(137615);
    }

    public final boolean aif() {
        return this.oKe && this.oLN;
    }

    public final void bSN() {
        AppMethodBeat.m2504i(137616);
        this.oLN = true;
        C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "passivePause");
        if (this.oKc != null && aie()) {
            try {
                this.oKc.pause();
                AppMethodBeat.m2505o(137616);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "passivePause", new Object[0]);
                mo58651d(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
                m5825e(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            }
        }
        AppMethodBeat.m2505o(137616);
    }

    public final void resume() {
        AppMethodBeat.m2504i(137617);
        this.bqQ = 0;
        C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(bTc()), Boolean.valueOf(aie()));
        if (!(this.oKc == null || r0 || r1)) {
            if (C39435k.bUh().requestFocus()) {
                try {
                    this.oKc.start();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "resume", new Object[0]);
                    mo58651d(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                    m5825e(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                }
            } else {
                C4990ab.m7412e("MicroMsg.Music.QQMusicPlayer", "request focus error");
            }
            this.oKe = true;
        }
        AppMethodBeat.m2505o(137617);
    }

    public final boolean aie() {
        AppMethodBeat.m2504i(137618);
        if (this.oKc == null) {
            AppMethodBeat.m2505o(137618);
            return false;
        } else if (this.oKc.getPlayerState() == 4) {
            AppMethodBeat.m2505o(137618);
            return true;
        } else {
            AppMethodBeat.m2505o(137618);
            return false;
        }
    }

    private boolean bTc() {
        AppMethodBeat.m2504i(137619);
        if (this.oKc == null) {
            AppMethodBeat.m2505o(137619);
            return false;
        } else if (this.oKc.getPlayerState() == 3) {
            AppMethodBeat.m2505o(137619);
            return true;
        } else {
            AppMethodBeat.m2505o(137619);
            return false;
        }
    }

    public final boolean aig() {
        AppMethodBeat.m2504i(137620);
        if (!this.oKe || bTc()) {
            AppMethodBeat.m2505o(137620);
            return false;
        }
        AppMethodBeat.m2505o(137620);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(137621);
        C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
        try {
            if (this.oKc != null) {
                this.oKc.stop();
            }
            if (this.oNI != null) {
                this.oNI.isStop = true;
                this.oNI = null;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "stopPlay", new Object[0]);
            mo58651d(this.oLA, 504);
            m5825e(this.oLA, 504);
        }
        C39435k.bUh().bSK();
        this.oKe = false;
        this.oLN = false;
        AppMethodBeat.m2505o(137621);
    }

    public final int bTi() {
        AppMethodBeat.m2504i(137622);
        if (this.oKc != null) {
            int currentPosition = (int) this.oKc.getCurrentPosition();
            AppMethodBeat.m2505o(137622);
            return currentPosition;
        }
        AppMethodBeat.m2505o(137622);
        return -1;
    }

    public final int getDuration() {
        AppMethodBeat.m2504i(137623);
        if (this.oKc != null) {
            int duration = this.oKc.getDuration();
            AppMethodBeat.m2505o(137623);
            return duration;
        }
        AppMethodBeat.m2505o(137623);
        return -1;
    }

    /* renamed from: lP */
    public final boolean mo8037lP(int i) {
        AppMethodBeat.m2504i(137624);
        int duration = getDuration();
        C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0 || i > duration) {
            C4990ab.m7413e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            stopPlay();
            AppMethodBeat.m2505o(137624);
            return false;
        }
        if (this.oKc != null) {
            mo58645F(this.oLA);
            this.oKc.seekTo(i);
        }
        AppMethodBeat.m2505o(137624);
        return true;
    }

    public final C37496c bSP() {
        int bufferedPercentage;
        int i = 0;
        AppMethodBeat.m2504i(137625);
        int duration = getDuration();
        int bTi = bTi();
        boolean aie = aie();
        if (this.oKc != null) {
            bufferedPercentage = this.oKc.getBufferedPercentage();
        } else {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0 || bufferedPercentage > 100) {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0) {
            bufferedPercentage = 0;
        }
        if (this.oLB != null) {
            C37496c c37496c = this.oLB;
            if (aie) {
                i = 1;
            }
            c37496c.mo60427t(duration, bTi, i, bufferedPercentage);
        } else {
            if (aie) {
                i = 1;
            }
            this.oLB = new C37496c(duration, bTi, i, bufferedPercentage);
        }
        this.oLB.cFJ = true;
        this.oLB.fJR = bUy();
        C37496c c37496c2 = this.oLB;
        AppMethodBeat.m2505o(137625);
        return c37496c2;
    }

    public final void release() {
        AppMethodBeat.m2504i(137626);
        C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "release");
        if (this.oKc != null) {
            this.oKc.release();
            this.oKc = null;
        }
        bSM();
        AppMethodBeat.m2505o(137626);
    }

    public final void bTk() {
        AppMethodBeat.m2504i(137627);
        C9058e bTQ = C39435k.bUf().bTQ();
        if (bTQ == null) {
            AppMethodBeat.m2505o(137627);
            return;
        }
        if (bTQ.mo20537e(this.oLA) && this.oKc != null && aie()) {
            int currentPosition = (int) this.oKc.getCurrentPosition();
            int duration = this.oKc.getDuration();
            if (currentPosition > 0 && duration > 0 && this.oKa != null) {
                this.oKa.mo46715dN(currentPosition, duration);
            }
        }
        AppMethodBeat.m2505o(137627);
    }

    public final boolean bSO() {
        return true;
    }

    /* renamed from: e */
    private void m5825e(C9058e c9058e, int i) {
        AppMethodBeat.m2504i(137628);
        if (this.oNt != null) {
            this.oNt.mo24646b(c9058e, i);
        }
        AppMethodBeat.m2505o(137628);
    }

    /* renamed from: a */
    static /* synthetic */ void m5823a(C3535e c3535e) {
        AppMethodBeat.m2504i(137630);
        if (c3535e.audioType != null) {
            C4990ab.m7417i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(c3535e.audioType.getValue()), Boolean.valueOf(c3535e.oKk));
            if (!c3535e.oKk) {
                C4990ab.m7416i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType OK");
                c3535e.oKk = true;
                if (c3535e.oNt != null) {
                    c3535e.oNt.mo24648c(c3535e.oLA, c3535e.audioType.getValue());
                }
            }
        }
        AppMethodBeat.m2505o(137630);
    }
}
