package com.tencent.mm.plugin.music.b;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.b;
import com.tencent.mm.g.a.u;
import com.tencent.mm.plugin.music.b.a.d;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.net.URL;

public final class h extends g {
    AudioType audioType;
    int bqQ;
    String ckD;
    String cle;
    protected b csL;
    long eDL;
    boolean fqY;
    ak ilv;
    int lqz;
    d oJL;
    CommonPlayer oKc;
    private com.tencent.mm.ag.d oKd;
    boolean oKe;
    boolean oKf;
    a oKg;
    private IMediaHTTPService oKh;
    boolean oKi;
    private long oKj;
    boolean oKk;
    long oKl;
    private PlayerListenerCallback oKm;
    int startTime;

    class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(137363);
            ab.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (h.this.oKc != null && h.this.aie()) {
                        h.this.bTk();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
            AppMethodBeat.o(137363);
        }
    }

    static /* synthetic */ void a(h hVar, int i) {
        AppMethodBeat.i(137392);
        hVar.zm(i);
        AppMethodBeat.o(137392);
    }

    public h() {
        AppMethodBeat.i(137364);
        this.ckD = "";
        this.oKf = false;
        this.fqY = false;
        this.cle = "";
        this.bqQ = 0;
        this.lqz = 0;
        this.startTime = 0;
        this.oKi = false;
        this.oKj = 0;
        this.audioType = AudioType.UNSUPPORT;
        this.oKk = false;
        this.oKl = 0;
        this.eDL = 0;
        this.oKm = new PlayerListenerCallback() {
            b oKn = null;

            public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
            }

            public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
                AppMethodBeat.i(137350);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
                AppMethodBeat.o(137350);
            }

            public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer, final int i) {
                AppMethodBeat.i(137351);
                h.this.ilv.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(137347);
                        ab.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", Integer.valueOf(i));
                        if (h.this.startTime != 0) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", Integer.valueOf(h.this.startTime));
                            h.this.startTime = 0;
                            AnonymousClass1.a(AnonymousClass1.this);
                            AppMethodBeat.o(137347);
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        ab.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
                        h.this.bSW();
                        if (h.this.aie()) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
                            h.this.bST();
                        }
                        AppMethodBeat.o(137347);
                    }
                });
                AppMethodBeat.o(137351);
            }

            public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
                AppMethodBeat.i(137352);
                ab.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), h.this.ckD);
                if (this.oKn == null) {
                    ab.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
                    AppMethodBeat.o(137352);
                    return;
                }
                boolean isNetworkConnected = at.isNetworkConnected(ah.getContext());
                if (i2 == 80 && isNetworkConnected) {
                    ab.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
                }
                if (h.this.bqQ > 0) {
                    ab.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", Integer.valueOf(h.this.bqQ));
                    AppMethodBeat.o(137352);
                    return;
                }
                h.this.oKe = false;
                h hVar = h.this;
                hVar.bqQ++;
                h.this.lqz = i2;
                h.this.eDL = System.currentTimeMillis();
                h.a(h.this, i2);
                if (h.this.ckD.equalsIgnoreCase(this.oKn.ckD)) {
                    h.this.stopPlay();
                    al.d(new Runnable() {
                        public final void run() {
                            boolean bTz;
                            AppMethodBeat.i(137348);
                            if (e.bTG()) {
                                bTz = ((c) com.tencent.mm.plugin.music.f.c.b.ar(c.class)).bTz();
                            } else {
                                ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                                bTz = false;
                            }
                            if (bTz) {
                                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d3y), 0).show();
                            }
                            AppMethodBeat.o(137348);
                        }
                    });
                }
                h.this.zl(i2);
                if (h.this.oKg != null) {
                    h.this.oKg.isStop = true;
                    h.this.oKg = null;
                }
                if (i == 91 && i2 == 55) {
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
                    g.HS(h.this.cle);
                }
                AppMethodBeat.o(137352);
            }

            public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
                AppMethodBeat.i(137353);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
                AppMethodBeat.o(137353);
            }

            public final void onStateChanged(BaseMediaPlayer baseMediaPlayer, final int i) {
                AppMethodBeat.i(137354);
                h.this.ilv.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(137349);
                        String str = h.this.ckD;
                        ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", Integer.valueOf(i), str);
                        if (i == 3) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
                            AnonymousClass1.b(AnonymousClass1.this);
                            h.this.oKl = System.currentTimeMillis();
                            AppMethodBeat.o(137349);
                        } else if (i == 2) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", Long.valueOf(System.currentTimeMillis() - h.this.oKl));
                            AnonymousClass1.a(AnonymousClass1.this);
                            AppMethodBeat.o(137349);
                        } else if (i == 4) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", Long.valueOf(System.currentTimeMillis() - h.this.oKl));
                            AnonymousClass1.c(AnonymousClass1.this);
                            AppMethodBeat.o(137349);
                        } else if (i == 5) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
                            AnonymousClass1.d(AnonymousClass1.this);
                            AppMethodBeat.o(137349);
                        } else if (i == 6) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
                            AnonymousClass1.e(AnonymousClass1.this);
                            AppMethodBeat.o(137349);
                        } else if (i == 7) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                            AnonymousClass1.f(AnonymousClass1.this);
                            AppMethodBeat.o(137349);
                        } else if (i == 8) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
                            AnonymousClass1.bTl();
                            AppMethodBeat.o(137349);
                        } else {
                            if (i == 9) {
                                ab.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
                            }
                            AppMethodBeat.o(137349);
                        }
                    }
                });
                AppMethodBeat.o(137354);
            }

            public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
                AppMethodBeat.i(137355);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
                AppMethodBeat.o(137355);
            }

            static /* synthetic */ void a(AnonymousClass1 anonymousClass1) {
                AppMethodBeat.i(137356);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "_onPrepared");
                anonymousClass1.oKn = h.this.csL;
                if (h.this.fqY || h.this.oKf) {
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    if (h.this.fqY && h.this.oKc != null) {
                        h.this.oKc.stop();
                    }
                    if (h.this.oKf) {
                        h.this.bSU();
                    }
                    AppMethodBeat.o(137356);
                } else if (h.this.startTime != 0) {
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "seek to startTime:%d", Integer.valueOf(h.this.startTime));
                    h.this.lP(h.this.startTime);
                    AppMethodBeat.o(137356);
                } else {
                    if (!(h.this.oKc == null || h.this.oKc.getCurrentAudioInformation() == null || h.this.oKc.getCurrentAudioInformation().getAudioType() == null)) {
                        h.this.audioType = h.this.oKc.getCurrentAudioInformation().getAudioType();
                        if (h.this.audioType != null) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "getAudioType:%d", Integer.valueOf(h.this.audioType.getValue()));
                        }
                        h hVar = h.this;
                        if (hVar.audioType != null) {
                            ab.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(hVar.audioType.getValue()), Boolean.valueOf(hVar.oKk));
                            if (!hVar.oKk) {
                                ab.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType OK");
                                hVar.oKk = true;
                                if (hVar.oJL != null) {
                                    hVar.oJL.zp(hVar.audioType.getValue());
                                }
                            }
                        }
                    }
                    h.this.bSR();
                    if (h.this.oKi) {
                        ab.i("MicroMsg.Audio.QQAudioPlayer", "start to play");
                        try {
                            if (h.this.oKc != null) {
                                h.this.oKc.setVolume((float) h.this.csL.fqN, (float) h.this.csL.fqN);
                                h.this.oKc.start();
                            }
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "_onPrepared", new Object[0]);
                            h.this.zl(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                            h.a(h.this, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                        }
                        h.this.oKe = true;
                        AppMethodBeat.o(137356);
                        return;
                    }
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "autoplay is false, don't start auto play!");
                    AppMethodBeat.o(137356);
                }
            }

            static /* synthetic */ void b(AnonymousClass1 anonymousClass1) {
                AppMethodBeat.i(137357);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "_onPreparing");
                anonymousClass1.oKn = h.this.csL;
                if (anonymousClass1.oKn == null) {
                    ab.e("MicroMsg.Audio.QQAudioPlayer", "cbMusic is null");
                    AppMethodBeat.o(137357);
                } else if (h.this.fqY || h.this.oKf) {
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    AppMethodBeat.o(137357);
                } else {
                    h hVar = h.this;
                    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onPreparintEvent");
                    com.tencent.mm.sdk.b.b uVar = new u();
                    uVar.csP.action = 9;
                    uVar.csP.state = "waiting";
                    uVar.csP.ckD = hVar.bSQ();
                    uVar.csP.appId = hVar.getAppId();
                    com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
                    AppMethodBeat.o(137357);
                }
            }

            static /* synthetic */ void c(AnonymousClass1 anonymousClass1) {
                AppMethodBeat.i(137358);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "_onStart");
                if (h.this.oJL != null) {
                    h.this.oJL.a(h.this.csL.ckD, h.this.csL.clP, System.currentTimeMillis() - h.this.csL.fqO, h.this.csL.fqP, h.this.csL.fqQ);
                }
                anonymousClass1.oKn = h.this.csL;
                if (h.this.fqY || h.this.oKf) {
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    if (h.this.oKc != null && h.this.oKe) {
                        h.this.oKe = false;
                        h.this.oKc.stop();
                    }
                    AppMethodBeat.o(137358);
                    return;
                }
                h.this.bSS();
                if (h.this.oKg != null) {
                    h.this.oKg.isStop = true;
                }
                h.this.oKg = new a(h.this, (byte) 0);
                h.this.oKg.isStop = false;
                AppMethodBeat.o(137358);
            }

            static /* synthetic */ void d(AnonymousClass1 anonymousClass1) {
                AppMethodBeat.i(137359);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "_onPause");
                h.this.bSU();
                AppMethodBeat.o(137359);
            }

            static /* synthetic */ void e(AnonymousClass1 anonymousClass1) {
                AppMethodBeat.i(137360);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "_onStop");
                if (anonymousClass1.oKn == null) {
                    ab.e("MicroMsg.Audio.QQAudioPlayer", "currentMusic is null");
                    AppMethodBeat.o(137360);
                    return;
                }
                h.this.oKe = false;
                h.this.eDL = System.currentTimeMillis();
                if (h.this.ckD.equalsIgnoreCase(anonymousClass1.oKn.ckD)) {
                    if (h.this.fqY) {
                        ab.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
                        h.this.bSU();
                        AppMethodBeat.o(137360);
                        return;
                    }
                    h.this.bSV();
                }
                AppMethodBeat.o(137360);
            }

            static /* synthetic */ void f(AnonymousClass1 anonymousClass1) {
                AppMethodBeat.i(137361);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "_onCompletion");
                if (!h.this.csL.fqL) {
                    h.this.bSX();
                }
                if (h.this.oKg != null) {
                    h.this.oKg.isStop = true;
                    h.this.oKg = null;
                }
                h.this.eDL = System.currentTimeMillis();
                ab.i("MicroMsg.Audio.QQAudioPlayer", "play end, isPausedOnBackground:%b, playParam.loop:%b, isStartPlaying:%b, ", Boolean.valueOf(h.this.fqY), Boolean.valueOf(h.this.csL.fqL), Boolean.valueOf(h.this.oKe));
                if (h.this.fqY) {
                    h.this.oKe = false;
                    h.this.startTime = 0;
                    h.this.oKi = true;
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground is true, do stop player and don't play again");
                    AppMethodBeat.o(137361);
                } else if (h.this.oKf) {
                    h.this.oKe = false;
                    h.this.startTime = 0;
                    h.this.oKi = true;
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "isForcePause is true, do stop player and don't play again");
                    AppMethodBeat.o(137361);
                } else if (h.this.csL.fqL && h.this.oKe) {
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "play end normally and loop play again");
                    h.this.oKe = false;
                    h.this.startTime = 0;
                    h.this.oKi = true;
                    h.b(h.this);
                    AppMethodBeat.o(137361);
                } else {
                    ab.i("MicroMsg.Audio.QQAudioPlayer", "play end, but not loop play");
                    h.this.oKe = false;
                    h.this.startTime = 0;
                    h.this.oKi = true;
                    AppMethodBeat.o(137361);
                }
            }

            static /* synthetic */ void bTl() {
                AppMethodBeat.i(137362);
                ab.i("MicroMsg.Audio.QQAudioPlayer", "_onEnd");
                AppMethodBeat.o(137362);
            }
        };
        this.ckD = e.bSy();
        com.tencent.mm.plugin.music.f.a.a.bUE();
        if (android.support.v4.content.b.checkSelfPermission(ah.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
            ab.e("MicroMsg.Audio.BaseAudioPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
        } else {
            this.oJY = new ax();
            this.oJY.gK(ah.getContext());
            this.oJY.a(new com.tencent.mm.sdk.platformtools.ax.a() {
                public final void ih(int i) {
                    AppMethodBeat.i(137346);
                    switch (i) {
                        case 0:
                            if (g.this.oJZ) {
                                g.this.oJZ = false;
                                g.this.resume();
                                AppMethodBeat.o(137346);
                                return;
                            }
                            break;
                        case 1:
                        case 2:
                            if (g.this.aie()) {
                                g.this.oJZ = true;
                                g.this.pause();
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(137346);
                }
            });
        }
        ab.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
        this.ilv = new ak(Looper.myLooper());
        AppMethodBeat.o(137364);
    }

    public final void SN(String str) {
        AppMethodBeat.i(137365);
        ab.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", str);
        this.ckD = str;
        AppMethodBeat.o(137365);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(137366);
        this.csL = bVar;
        this.startTime = bVar.startTime;
        this.oKi = bVar.fqK;
        if (this.oKc != null && aie()) {
            ab.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", this.ckD, this.cle, Double.valueOf(this.csL.fqN));
            this.oKc.setVolume((float) this.csL.fqN, (float) this.csL.fqN);
        }
        AppMethodBeat.o(137366);
    }

    public final void l(b bVar) {
        AppMethodBeat.i(137367);
        if (bVar == null) {
            ab.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
            bSY();
            AppMethodBeat.o(137367);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKj;
        if (this.csL == null || !this.csL.e(bVar) || j > 100) {
            this.oJL = (d) com.tencent.mm.plugin.music.f.c.b.ar(d.class);
            if (this.oJL != null) {
                this.oJL.zo(bVar.fromScene);
            }
            this.oKj = currentTimeMillis;
            this.csL = bVar;
            ab.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", Integer.valueOf(this.csL.fromScene), this.ckD);
            if (this.oKc != null && aie()) {
                this.oKc.stop();
            }
            this.bqQ = 0;
            this.startTime = bVar.startTime;
            this.oKi = bVar.fqK;
            this.audioType = null;
            this.oKk = false;
            this.fqY = false;
            this.oKf = false;
            bSZ();
            AppMethodBeat.o(137367);
            return;
        }
        this.csL = bVar;
        this.startTime = bVar.startTime;
        this.oKi = bVar.fqK;
        ab.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", this.cle, Long.valueOf(j));
        AppMethodBeat.o(137367);
    }

    private void bSZ() {
        AppMethodBeat.i(137368);
        ab.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
        if (!TextUtils.isEmpty(this.csL.filePath) && this.csL.fqV == null) {
            ab.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", this.csL.filePath);
            if (this.oKc == null) {
                this.oKc = new CommonPlayer(this.oKm);
            }
            this.oKc.reset();
            try {
                this.oKc.setDataSource(this.csL.filePath);
                this.oKc.prepare();
                AppMethodBeat.o(137368);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "initPlayer exception", new Object[0]);
                zl(501);
                zm(501);
                AppMethodBeat.o(137368);
            }
        } else if (TextUtils.isEmpty(this.csL.filePath) || this.csL.fqV == null) {
            URL url;
            ab.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", this.csL.clP);
            bTa();
            try {
                url = new URL(this.cle);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "initPlayer", new Object[0]);
                url = null;
            }
            if (url == null) {
                ab.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
                zl(500);
                zm(500);
                AppMethodBeat.o(137368);
                return;
            }
            if (this.oKc == null) {
                this.oKc = new CommonPlayer(this.oKm);
            }
            this.oKc.reset();
            if (this.oKh == null) {
                this.oKh = new com.tencent.mm.plugin.music.g.a.b();
            }
            try {
                this.oKc.setDataSource(this.oKh, Uri.parse(url.toString()));
                this.oKc.prepare();
                AppMethodBeat.o(137368);
            } catch (Exception e22) {
                ab.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e22.getMessage());
                ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e22, "initPlayer", new Object[0]);
                zl(501);
                zm(501);
                AppMethodBeat.o(137368);
            }
        } else {
            ab.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", this.csL.filePath);
            if (this.oKc == null) {
                this.oKc = new CommonPlayer(this.oKm);
            }
            this.oKc.reset();
            try {
                this.oKc.setDataSource(new com.tencent.mm.plugin.music.g.b(this.csL.fqV));
                this.oKc.prepare();
                AppMethodBeat.o(137368);
            } catch (Exception e222) {
                ab.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e222.getMessage());
                ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e222, "initPlayer", new Object[0]);
                zl(501);
                zm(501);
                AppMethodBeat.o(137368);
            }
        }
    }

    private void bTa() {
        boolean z;
        AppMethodBeat.i(137369);
        this.cle = this.csL.clP;
        if (com.tencent.mm.plugin.music.h.e.Tw(this.cle)) {
            ab.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", this.cle);
        g.SV(this.cle);
        g.aV(this.cle, z);
        AppMethodBeat.o(137369);
    }

    public final void pause() {
        AppMethodBeat.i(137370);
        ab.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", this.ckD);
        this.oKf = true;
        if (this.oKc == null || !aie()) {
            if (this.oKc != null && isCompleted()) {
                ab.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
                this.oKe = false;
            }
            AppMethodBeat.o(137370);
            return;
        }
        try {
            ab.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
            this.oKc.pause();
            AppMethodBeat.o(137370);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "pause", new Object[0]);
            zl(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            zm(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            AppMethodBeat.o(137370);
        }
    }

    public final void bTb() {
        AppMethodBeat.i(137371);
        ab.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
        pause();
        AppMethodBeat.o(137371);
    }

    public final void resume() {
        AppMethodBeat.i(137372);
        this.bqQ = 0;
        boolean bTc = bTc();
        boolean aie = aie();
        this.oKf = false;
        this.fqY = false;
        ab.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", Boolean.valueOf(bTc), Boolean.valueOf(aie), Boolean.valueOf(this.oKe), this.ckD);
        if (this.oKc != null && !bTd() && !bTc && !aie && !this.oKe) {
            ab.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
            this.startTime = 0;
            this.oKi = true;
            bSZ();
            if (this.oJL != null) {
                this.oJL.zo(this.csL.fromScene);
                AppMethodBeat.o(137372);
                return;
            }
        } else if (this.oKc != null && ((isPaused() || bTd()) && !aie)) {
            ab.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
            try {
                this.oKc.setVolume((float) this.csL.fqN, (float) this.csL.fqN);
                this.oKc.start();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "resume", new Object[0]);
                zl(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                zm(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
            }
            this.oKe = true;
        }
        AppMethodBeat.o(137372);
    }

    public final boolean aie() {
        AppMethodBeat.i(137373);
        if (this.oKc == null) {
            AppMethodBeat.o(137373);
            return false;
        } else if (this.oKc.getPlayerState() == 4) {
            AppMethodBeat.o(137373);
            return true;
        } else {
            AppMethodBeat.o(137373);
            return false;
        }
    }

    public final boolean bTc() {
        AppMethodBeat.i(137374);
        if (this.oKc == null) {
            AppMethodBeat.o(137374);
            return false;
        } else if (this.oKc.getPlayerState() == 3) {
            AppMethodBeat.o(137374);
            return true;
        } else {
            AppMethodBeat.o(137374);
            return false;
        }
    }

    public final boolean bTd() {
        AppMethodBeat.i(137375);
        if (this.oKc == null) {
            AppMethodBeat.o(137375);
            return false;
        } else if (this.oKc.getPlayerState() == 2) {
            AppMethodBeat.o(137375);
            return true;
        } else {
            AppMethodBeat.o(137375);
            return false;
        }
    }

    public final boolean isPaused() {
        AppMethodBeat.i(137376);
        if (this.oKc == null) {
            AppMethodBeat.o(137376);
            return false;
        } else if (this.oKc.getPlayerState() == 5) {
            AppMethodBeat.o(137376);
            return true;
        } else {
            AppMethodBeat.o(137376);
            return false;
        }
    }

    public final boolean isCompleted() {
        AppMethodBeat.i(137377);
        if (this.oKc == null) {
            AppMethodBeat.o(137377);
            return false;
        } else if (this.oKc.getPlayerState() == 7) {
            AppMethodBeat.o(137377);
            return true;
        } else {
            AppMethodBeat.o(137377);
            return false;
        }
    }

    public final boolean isStopped() {
        AppMethodBeat.i(137378);
        if (this.oKc == null) {
            AppMethodBeat.o(137378);
            return false;
        } else if (this.oKc.getPlayerState() == 6) {
            AppMethodBeat.o(137378);
            return true;
        } else {
            AppMethodBeat.o(137378);
            return false;
        }
    }

    public final boolean aig() {
        AppMethodBeat.i(137379);
        if (!this.oKe || bTc()) {
            AppMethodBeat.o(137379);
            return false;
        }
        AppMethodBeat.o(137379);
        return true;
    }

    public final void bTe() {
        AppMethodBeat.i(137380);
        ab.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
        this.fqY = true;
        this.oKf = true;
        AppMethodBeat.o(137380);
    }

    public final void bTf() {
        AppMethodBeat.i(137381);
        ab.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
        this.fqY = true;
        bTh();
        AppMethodBeat.o(137381);
    }

    public final void bTg() {
        AppMethodBeat.i(137382);
        this.fqY = false;
        this.oKf = true;
        bSV();
        this.eDL = System.currentTimeMillis();
        AppMethodBeat.o(137382);
    }

    public final void stopPlay() {
        AppMethodBeat.i(137383);
        ab.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
        this.fqY = false;
        bTh();
        AppMethodBeat.o(137383);
    }

    private void bTh() {
        AppMethodBeat.i(137384);
        try {
            if (this.oKc != null) {
                this.oKc.setVolume(0.0f, 0.0f);
                this.oKc.stop();
            }
            if (this.oKg != null) {
                this.oKg.isStop = true;
                this.oKg = null;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "stopPlay", new Object[0]);
            zl(504);
            zm(504);
        }
        this.oKe = false;
        this.oKf = true;
        this.eDL = System.currentTimeMillis();
        AppMethodBeat.o(137384);
    }

    public final int bTi() {
        AppMethodBeat.i(137385);
        if (this.oKc != null) {
            int currentPosition = (int) this.oKc.getCurrentPosition();
            AppMethodBeat.o(137385);
            return currentPosition;
        }
        AppMethodBeat.o(137385);
        return -1;
    }

    public final int getDuration() {
        AppMethodBeat.i(137386);
        if (this.oKc != null) {
            int duration = this.oKc.getDuration();
            AppMethodBeat.o(137386);
            return duration;
        }
        AppMethodBeat.o(137386);
        return -1;
    }

    public final boolean lP(int i) {
        AppMethodBeat.i(137387);
        int duration = getDuration();
        ab.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0) {
            ab.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            stopPlay();
            AppMethodBeat.o(137387);
            return false;
        } else if (i > duration) {
            ab.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            AppMethodBeat.o(137387);
            return false;
        } else {
            if (this.oKc != null) {
                ab.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
                com.tencent.mm.sdk.b.b uVar = new u();
                uVar.csP.action = 10;
                uVar.csP.state = "seeking";
                uVar.csP.ckD = bSQ();
                uVar.csP.appId = getAppId();
                com.tencent.mm.sdk.b.a.xxA.a(uVar, Looper.getMainLooper());
                this.oKc.seekTo(i);
            }
            AppMethodBeat.o(137387);
            return true;
        }
    }

    public final com.tencent.mm.ag.d bTj() {
        int bufferedPercentage;
        boolean z = false;
        AppMethodBeat.i(137388);
        if (this.oKd == null) {
            this.oKd = new com.tencent.mm.ag.d();
        }
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
        this.oKd.csK = bTi;
        this.oKd.duration = duration;
        com.tencent.mm.ag.d dVar = this.oKd;
        if (!aie) {
            z = true;
        }
        dVar.rw = z;
        this.oKd.fqY = this.fqY;
        this.oKd.fqZ = (bufferedPercentage * duration) / 100;
        if (this.csL != null) {
            this.oKd.startTime = this.csL.fqJ;
            this.oKd.ckz = this.csL.clP;
            com.tencent.mm.ag.d dVar2 = this.oKd;
            AppMethodBeat.o(137388);
            return dVar2;
        }
        AppMethodBeat.o(137388);
        return null;
    }

    public final String bSQ() {
        return this.ckD;
    }

    public final String getAppId() {
        if (this.csL != null) {
            return this.csL.appId;
        }
        return "";
    }

    private void zm(int i) {
        AppMethodBeat.i(137389);
        if (this.oJL != null) {
            this.oJL.eD(this.csL.fromScene, i);
        }
        AppMethodBeat.o(137389);
    }

    public final void release() {
        AppMethodBeat.i(137390);
        ab.i("MicroMsg.Audio.QQAudioPlayer", "release");
        this.oJR = null;
        if (this.oKc != null) {
            this.oKc.release();
            this.oKc = null;
        }
        bSM();
        AppMethodBeat.o(137390);
    }

    public final void bTk() {
        AppMethodBeat.i(137391);
        if (this.ckD.equalsIgnoreCase(this.csL.ckD) && this.oKc != null && aie()) {
            int currentPosition = (int) this.oKc.getCurrentPosition();
            int duration = this.oKc.getDuration();
            if (currentPosition > 0 && duration > 0 && this.oKa != null) {
                this.oKa.dN(currentPosition, duration);
            }
        }
        AppMethodBeat.o(137391);
    }

    public final boolean bSO() {
        return true;
    }
}
