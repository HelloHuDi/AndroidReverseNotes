package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.c;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.g.a.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.net.URL;

public final class e extends a {
    AudioType audioType = AudioType.UNSUPPORT;
    int bqQ = 0;
    String cle = "";
    CommonPlayer oKc;
    boolean oKe;
    private IMediaHTTPService oKh;
    private long oKj = 0;
    private boolean oKk = false;
    private PlayerListenerCallback oKm = new PlayerListenerCallback() {
        com.tencent.mm.aw.e oNK = null;

        public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
        }

        public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.i(137603);
            ab.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
            AppMethodBeat.o(137603);
        }

        public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i) {
            AppMethodBeat.i(137604);
            ab.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", Integer.valueOf(i));
            if (e.this.startTime != 0) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", Integer.valueOf(e.this.startTime));
                e.this.startTime = 0;
                bUD();
                AppMethodBeat.o(137604);
                return;
            }
            ab.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
            if (this.oNK == null) {
                ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                AppMethodBeat.o(137604);
                return;
            }
            e.this.E(this.oNK);
            if (e.this.aie()) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
                e.this.B(this.oNK);
            }
            AppMethodBeat.o(137604);
        }

        public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
            AppMethodBeat.i(137605);
            ab.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            com.tencent.mm.aw.e bTQ = k.bUf().bTQ();
            if (bTQ == null) {
                ab.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
                AppMethodBeat.o(137605);
                return;
            }
            this.oNK = e.this.oLA;
            if (this.oNK == null) {
                ab.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
                AppMethodBeat.o(137605);
                return;
            }
            boolean isNetworkConnected = at.isNetworkConnected(ah.getContext());
            if (i2 == 80 && isNetworkConnected) {
                ab.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
            }
            if (e.this.bqQ > 0) {
                ab.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", Integer.valueOf(e.this.bqQ));
                AppMethodBeat.o(137605);
                return;
            }
            e eVar = e.this;
            eVar.bqQ++;
            e.a(e.this, this.oNK, i2);
            if (bTQ.e(this.oNK)) {
                e.this.stopPlay();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(137602);
                        Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d3y), 0).show();
                        AppMethodBeat.o(137602);
                    }
                });
            }
            e.this.D(this.oNK);
            e.this.d(this.oNK, i2);
            if (e.this.oNI != null) {
                e.this.oNI.isStop = true;
                e.this.oNI = null;
            }
            if (i == 91 && i2 == 55) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
                g.HS(e.this.cle);
            }
            AppMethodBeat.o(137605);
        }

        public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.i(137606);
            ab.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
            AppMethodBeat.o(137606);
        }

        public final void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i) {
            AppMethodBeat.i(137607);
            ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", Integer.valueOf(i));
            if (i == 3) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
                ab.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
                this.oNK = e.this.oLA;
                if (this.oNK == null) {
                    ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137607);
                    return;
                }
                e.this.y(this.oNK);
                AppMethodBeat.o(137607);
            } else if (i == 2) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
                bUD();
                AppMethodBeat.o(137607);
            } else if (i == 4) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
                ab.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
                this.oNK = e.this.oLA;
                if (this.oNK == null) {
                    ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137607);
                    return;
                }
                if (e.this.oNs == "pause") {
                    e.this.B(this.oNK);
                } else {
                    e.this.A(this.oNK);
                }
                if (e.this.oNI != null) {
                    e.this.oNI.isStop = true;
                }
                e.this.oNI = new a(e.this, (byte) 0);
                a aVar = e.this.oNI;
                aVar.isStop = false;
                d.post(aVar, "music_play_progress_runnable");
                AppMethodBeat.o(137607);
            } else if (i == 5) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
                ab.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
                if (this.oNK == null) {
                    ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137607);
                    return;
                }
                e.this.C(this.oNK);
                AppMethodBeat.o(137607);
            } else if (i == 6) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
                ab.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
                if (this.oNK == null) {
                    ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137607);
                    return;
                }
                com.tencent.mm.aw.e bTQ = k.bUf().bTQ();
                if (bTQ == null) {
                    ab.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
                    AppMethodBeat.o(137607);
                    return;
                }
                if (bTQ.e(this.oNK)) {
                    e.this.D(this.oNK);
                }
                AppMethodBeat.o(137607);
            } else if (i == 7) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                ab.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
                if (this.oNK == null) {
                    ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    AppMethodBeat.o(137607);
                    return;
                }
                e.this.oKe = false;
                e.this.G(e.this.oLA);
                if (e.this.oNI != null) {
                    e.this.oNI.isStop = true;
                    e.this.oNI = null;
                }
                AppMethodBeat.o(137607);
            } else if (i == 8) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
                ab.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
                AppMethodBeat.o(137607);
            } else {
                if (i == 9) {
                    ab.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
                }
                AppMethodBeat.o(137607);
            }
        }

        public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.i(137608);
            ab.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
            AppMethodBeat.o(137608);
        }

        private void bUD() {
            AppMethodBeat.i(137609);
            ab.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
            if (e.this.startTime != 0) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", Integer.valueOf(e.this.startTime));
                e.this.lP(e.this.startTime);
                AppMethodBeat.o(137609);
                return;
            }
            ab.i("MicroMsg.Music.QQMusicPlayer", "start to play");
            if (!k.bUh().requestFocus()) {
                ab.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
                AppMethodBeat.o(137609);
            } else if (e.this.oLA == null) {
                ab.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                AppMethodBeat.o(137609);
            } else {
                e.this.z(e.this.oLA);
                try {
                    if (e.this.oKc != null) {
                        e.this.oKc.start();
                        if (!(e.this.oKc.getCurrentAudioInformation() == null || e.this.oKc.getCurrentAudioInformation().getAudioType() == null)) {
                            ab.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", Integer.valueOf(e.this.oKc.getCurrentAudioInformation().getAudioType().getValue()));
                            e.this.audioType = e.this.oKc.getCurrentAudioInformation().getAudioType();
                            e.a(e.this);
                        }
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "_onPrepared", new Object[0]);
                    e.this.d(e.this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                    e.a(e.this, e.this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                }
                e.this.oKe = true;
                AppMethodBeat.o(137609);
            }
        }
    };
    com.tencent.mm.aw.e oLA;
    private c oLB;
    public boolean oLN = false;
    a oNI;
    private String oNJ;
    int startTime = 0;

    class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(137610);
            ab.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (e.this.oKc != null && e.this.aie()) {
                        e.this.bTk();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
            AppMethodBeat.o(137610);
        }
    }

    static /* synthetic */ void a(e eVar, com.tencent.mm.aw.e eVar2, int i) {
        AppMethodBeat.i(137629);
        eVar.e(eVar2, i);
        AppMethodBeat.o(137629);
    }

    public e() {
        AppMethodBeat.i(137611);
        com.tencent.mm.plugin.music.f.a.a.bUE();
        AppMethodBeat.o(137611);
    }

    public final void f(com.tencent.mm.aw.e eVar) {
        AppMethodBeat.i(137612);
        super.f(eVar);
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKj;
        if (this.oLA != null && this.oLA.e(eVar) && j <= 3000) {
            this.oLA = eVar;
            ab.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.cle, Long.valueOf(j));
            AppMethodBeat.o(137612);
        } else if (eVar == null) {
            ab.e("MicroMsg.Music.QQMusicPlayer", "music is null");
            AppMethodBeat.o(137612);
        } else {
            if (this.oNt != null) {
                this.oNt.s(eVar);
            }
            this.oKj = currentTimeMillis;
            this.oLA = eVar;
            ab.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(eVar.startTime));
            if (this.oKc != null && aie()) {
                this.oKc.stop();
            }
            com.tencent.mm.plugin.music.f.a.a.bUF();
            this.bqQ = 0;
            this.startTime = eVar.startTime;
            this.audioType = null;
            this.oKk = false;
            ab.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
            this.cle = this.oLA.playUrl;
            this.oNJ = this.oLA.fKg;
            ab.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", this.cle, this.oNJ);
            ab.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", this.oLA.fKa);
            if (!bo.isNullOrNil(this.cle) && bo.isNullOrNil(this.oNJ)) {
                g.SV(this.cle);
                g.cI(this.cle, 0);
                g.cJ(this.cle, 0);
            }
            if (bo.isNullOrNil(this.oNJ)) {
                URL url;
                try {
                    url = new URL(this.cle);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "initPlayer", new Object[0]);
                    ab.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + e.getMessage());
                    url = null;
                }
                if (url == null) {
                    ab.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
                    d(this.oLA, 500);
                    e(this.oLA, 500);
                } else {
                    if (this.oKc == null) {
                        this.oKc = new CommonPlayer(this.oKm);
                    }
                    this.oKc.reset();
                    if (this.oKh == null) {
                        this.oKh = new b();
                    }
                    try {
                        this.oKc.setDataSource(this.oKh, Uri.parse(url.toString()));
                        this.oKc.prepare();
                    } catch (Exception e2) {
                        ab.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e2.getMessage());
                        ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "initPlayer", new Object[0]);
                        d(this.oLA, 501);
                        e(this.oLA, 501);
                    }
                }
            } else {
                ab.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", this.oNJ);
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
                    ab.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e22.getMessage());
                    ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e22, "initPlayer", new Object[0]);
                    d(this.oLA, 501);
                    e(this.oLA, 501);
                }
            }
            bUx();
            AppMethodBeat.o(137612);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bTI() {
        AppMethodBeat.i(137613);
        this.oNt = (com.tencent.mm.plugin.music.e.d) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.e.d.class);
        this.oNu = k.bUf().oLX;
        AppMethodBeat.o(137613);
    }

    public final void pause() {
        AppMethodBeat.i(137614);
        this.oLN = false;
        ab.i("MicroMsg.Music.QQMusicPlayer", "pause");
        if (this.oKc != null && aie()) {
            try {
                this.oKc.pause();
                AppMethodBeat.o(137614);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "pause", new Object[0]);
                d(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
                e(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            }
        }
        AppMethodBeat.o(137614);
    }

    public final void bTb() {
        AppMethodBeat.i(137615);
        ab.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
        pause();
        k.bUh().bSK();
        AppMethodBeat.o(137615);
    }

    public final boolean aif() {
        return this.oKe && this.oLN;
    }

    public final void bSN() {
        AppMethodBeat.i(137616);
        this.oLN = true;
        ab.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
        if (this.oKc != null && aie()) {
            try {
                this.oKc.pause();
                AppMethodBeat.o(137616);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "passivePause", new Object[0]);
                d(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
                e(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            }
        }
        AppMethodBeat.o(137616);
    }

    public final void resume() {
        AppMethodBeat.i(137617);
        this.bqQ = 0;
        ab.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(bTc()), Boolean.valueOf(aie()));
        if (!(this.oKc == null || r0 || r1)) {
            if (k.bUh().requestFocus()) {
                try {
                    this.oKc.start();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "resume", new Object[0]);
                    d(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                    e(this.oLA, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                }
            } else {
                ab.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
            }
            this.oKe = true;
        }
        AppMethodBeat.o(137617);
    }

    public final boolean aie() {
        AppMethodBeat.i(137618);
        if (this.oKc == null) {
            AppMethodBeat.o(137618);
            return false;
        } else if (this.oKc.getPlayerState() == 4) {
            AppMethodBeat.o(137618);
            return true;
        } else {
            AppMethodBeat.o(137618);
            return false;
        }
    }

    private boolean bTc() {
        AppMethodBeat.i(137619);
        if (this.oKc == null) {
            AppMethodBeat.o(137619);
            return false;
        } else if (this.oKc.getPlayerState() == 3) {
            AppMethodBeat.o(137619);
            return true;
        } else {
            AppMethodBeat.o(137619);
            return false;
        }
    }

    public final boolean aig() {
        AppMethodBeat.i(137620);
        if (!this.oKe || bTc()) {
            AppMethodBeat.o(137620);
            return false;
        }
        AppMethodBeat.o(137620);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.i(137621);
        ab.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
        try {
            if (this.oKc != null) {
                this.oKc.stop();
            }
            if (this.oNI != null) {
                this.oNI.isStop = true;
                this.oNI = null;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "stopPlay", new Object[0]);
            d(this.oLA, 504);
            e(this.oLA, 504);
        }
        k.bUh().bSK();
        this.oKe = false;
        this.oLN = false;
        AppMethodBeat.o(137621);
    }

    public final int bTi() {
        AppMethodBeat.i(137622);
        if (this.oKc != null) {
            int currentPosition = (int) this.oKc.getCurrentPosition();
            AppMethodBeat.o(137622);
            return currentPosition;
        }
        AppMethodBeat.o(137622);
        return -1;
    }

    public final int getDuration() {
        AppMethodBeat.i(137623);
        if (this.oKc != null) {
            int duration = this.oKc.getDuration();
            AppMethodBeat.o(137623);
            return duration;
        }
        AppMethodBeat.o(137623);
        return -1;
    }

    public final boolean lP(int i) {
        AppMethodBeat.i(137624);
        int duration = getDuration();
        ab.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0 || i > duration) {
            ab.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            stopPlay();
            AppMethodBeat.o(137624);
            return false;
        }
        if (this.oKc != null) {
            F(this.oLA);
            this.oKc.seekTo(i);
        }
        AppMethodBeat.o(137624);
        return true;
    }

    public final c bSP() {
        int bufferedPercentage;
        int i = 0;
        AppMethodBeat.i(137625);
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
            c cVar = this.oLB;
            if (aie) {
                i = 1;
            }
            cVar.t(duration, bTi, i, bufferedPercentage);
        } else {
            if (aie) {
                i = 1;
            }
            this.oLB = new c(duration, bTi, i, bufferedPercentage);
        }
        this.oLB.cFJ = true;
        this.oLB.fJR = bUy();
        c cVar2 = this.oLB;
        AppMethodBeat.o(137625);
        return cVar2;
    }

    public final void release() {
        AppMethodBeat.i(137626);
        ab.i("MicroMsg.Music.QQMusicPlayer", "release");
        if (this.oKc != null) {
            this.oKc.release();
            this.oKc = null;
        }
        bSM();
        AppMethodBeat.o(137626);
    }

    public final void bTk() {
        AppMethodBeat.i(137627);
        com.tencent.mm.aw.e bTQ = k.bUf().bTQ();
        if (bTQ == null) {
            AppMethodBeat.o(137627);
            return;
        }
        if (bTQ.e(this.oLA) && this.oKc != null && aie()) {
            int currentPosition = (int) this.oKc.getCurrentPosition();
            int duration = this.oKc.getDuration();
            if (currentPosition > 0 && duration > 0 && this.oKa != null) {
                this.oKa.dN(currentPosition, duration);
            }
        }
        AppMethodBeat.o(137627);
    }

    public final boolean bSO() {
        return true;
    }

    private void e(com.tencent.mm.aw.e eVar, int i) {
        AppMethodBeat.i(137628);
        if (this.oNt != null) {
            this.oNt.b(eVar, i);
        }
        AppMethodBeat.o(137628);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(137630);
        if (eVar.audioType != null) {
            ab.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(eVar.audioType.getValue()), Boolean.valueOf(eVar.oKk));
            if (!eVar.oKk) {
                ab.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType OK");
                eVar.oKk = true;
                if (eVar.oNt != null) {
                    eVar.oNt.c(eVar.oLA, eVar.audioType.getValue());
                }
            }
        }
        AppMethodBeat.o(137630);
    }
}
