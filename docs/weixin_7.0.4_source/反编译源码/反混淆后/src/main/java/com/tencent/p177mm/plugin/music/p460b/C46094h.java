package com.tencent.p177mm.plugin.music.p460b;

import android.net.Uri;
import android.os.Looper;
import android.support.p057v4.content.C0380b;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1176ag.C17875b;
import com.tencent.p177mm.p1176ag.C41729d;
import com.tencent.p177mm.p230g.p231a.C18405u;
import com.tencent.p177mm.plugin.music.cache.C21343c;
import com.tencent.p177mm.plugin.music.cache.C39432e;
import com.tencent.p177mm.plugin.music.cache.C39433g;
import com.tencent.p177mm.plugin.music.p1362g.C24801b;
import com.tencent.p177mm.plugin.music.p1362g.p1493a.C39437b;
import com.tencent.p177mm.plugin.music.p460b.C39429g.C394301;
import com.tencent.p177mm.plugin.music.p460b.p996a.C28540d;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C12665a;
import com.tencent.p177mm.plugin.music.p997h.C46101e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5031ax;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.music.b.h */
public final class C46094h extends C39429g {
    AudioType audioType;
    int bqQ;
    String ckD;
    String cle;
    protected C17875b csL;
    long eDL;
    boolean fqY;
    C7306ak ilv;
    int lqz;
    C28540d oJL;
    CommonPlayer oKc;
    private C41729d oKd;
    boolean oKe;
    boolean oKf;
    C39431a oKg;
    private IMediaHTTPService oKh;
    boolean oKi;
    private long oKj;
    boolean oKk;
    long oKl;
    private PlayerListenerCallback oKm;
    int startTime;

    /* renamed from: com.tencent.mm.plugin.music.b.h$1 */
    class C285471 implements PlayerListenerCallback {
        C17875b oKn = null;

        /* renamed from: com.tencent.mm.plugin.music.b.h$1$2 */
        class C285492 implements Runnable {
            C285492() {
            }

            public final void run() {
                boolean bTz;
                AppMethodBeat.m2504i(137348);
                if (C39432e.bTG()) {
                    bTz = ((C21343c) C43329b.m77295ar(C21343c.class)).bTz();
                } else {
                    C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                    bTz = false;
                }
                if (bTz) {
                    Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d3y), 0).show();
                }
                AppMethodBeat.m2505o(137348);
            }
        }

        C285471() {
        }

        public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
        }

        public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.m2504i(137350);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
            AppMethodBeat.m2505o(137350);
        }

        public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer, final int i) {
            AppMethodBeat.m2504i(137351);
            C46094h.this.ilv.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(137347);
                    C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", Integer.valueOf(i));
                    if (C46094h.this.startTime != 0) {
                        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", Integer.valueOf(C46094h.this.startTime));
                        C46094h.this.startTime = 0;
                        C285471.m45303a(C285471.this);
                        AppMethodBeat.m2505o(137347);
                        return;
                    }
                    C285471 c285471 = C285471.this;
                    C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
                    C46094h.this.bSW();
                    if (C46094h.this.aie()) {
                        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
                        C46094h.this.bST();
                    }
                    AppMethodBeat.m2505o(137347);
                }
            });
            AppMethodBeat.m2505o(137351);
        }

        public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
            AppMethodBeat.m2504i(137352);
            C4990ab.m7413e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), C46094h.this.ckD);
            if (this.oKn == null) {
                C4990ab.m7412e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
                AppMethodBeat.m2505o(137352);
                return;
            }
            boolean isNetworkConnected = C5023at.isNetworkConnected(C4996ah.getContext());
            if (i2 == 80 && isNetworkConnected) {
                C4990ab.m7412e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
            }
            if (C46094h.this.bqQ > 0) {
                C4990ab.m7413e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", Integer.valueOf(C46094h.this.bqQ));
                AppMethodBeat.m2505o(137352);
                return;
            }
            C46094h.this.oKe = false;
            C46094h c46094h = C46094h.this;
            c46094h.bqQ++;
            C46094h.this.lqz = i2;
            C46094h.this.eDL = System.currentTimeMillis();
            C46094h.m85965a(C46094h.this, i2);
            if (C46094h.this.ckD.equalsIgnoreCase(this.oKn.ckD)) {
                C46094h.this.stopPlay();
                C5004al.m7441d(new C285492());
            }
            C46094h.this.mo62386zl(i2);
            if (C46094h.this.oKg != null) {
                C46094h.this.oKg.isStop = true;
                C46094h.this.oKg = null;
            }
            if (i == 91 && i2 == 55) {
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
                C39433g.m67343HS(C46094h.this.cle);
            }
            AppMethodBeat.m2505o(137352);
        }

        public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.m2504i(137353);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
            AppMethodBeat.m2505o(137353);
        }

        public final void onStateChanged(BaseMediaPlayer baseMediaPlayer, final int i) {
            AppMethodBeat.m2504i(137354);
            C46094h.this.ilv.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(137349);
                    String str = C46094h.this.ckD;
                    C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", Integer.valueOf(i), str);
                    if (i == 3) {
                        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
                        C285471.m45304b(C285471.this);
                        C46094h.this.oKl = System.currentTimeMillis();
                        AppMethodBeat.m2505o(137349);
                    } else if (i == 2) {
                        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
                        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", Long.valueOf(System.currentTimeMillis() - C46094h.this.oKl));
                        C285471.m45303a(C285471.this);
                        AppMethodBeat.m2505o(137349);
                    } else if (i == 4) {
                        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
                        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", Long.valueOf(System.currentTimeMillis() - C46094h.this.oKl));
                        C285471.m45305c(C285471.this);
                        AppMethodBeat.m2505o(137349);
                    } else if (i == 5) {
                        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
                        C285471.m45306d(C285471.this);
                        AppMethodBeat.m2505o(137349);
                    } else if (i == 6) {
                        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
                        C285471.m45307e(C285471.this);
                        AppMethodBeat.m2505o(137349);
                    } else if (i == 7) {
                        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                        C285471.m45308f(C285471.this);
                        AppMethodBeat.m2505o(137349);
                    } else if (i == 8) {
                        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
                        C285471.bTl();
                        AppMethodBeat.m2505o(137349);
                    } else {
                        if (i == 9) {
                            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
                        }
                        AppMethodBeat.m2505o(137349);
                    }
                }
            });
            AppMethodBeat.m2505o(137354);
        }

        public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
            AppMethodBeat.m2504i(137355);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
            AppMethodBeat.m2505o(137355);
        }

        /* renamed from: a */
        static /* synthetic */ void m45303a(C285471 c285471) {
            AppMethodBeat.m2504i(137356);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "_onPrepared");
            c285471.oKn = C46094h.this.csL;
            if (C46094h.this.fqY || C46094h.this.oKf) {
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                if (C46094h.this.fqY && C46094h.this.oKc != null) {
                    C46094h.this.oKc.stop();
                }
                if (C46094h.this.oKf) {
                    C46094h.this.bSU();
                }
                AppMethodBeat.m2505o(137356);
            } else if (C46094h.this.startTime != 0) {
                C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "seek to startTime:%d", Integer.valueOf(C46094h.this.startTime));
                C46094h.this.mo8037lP(C46094h.this.startTime);
                AppMethodBeat.m2505o(137356);
            } else {
                if (!(C46094h.this.oKc == null || C46094h.this.oKc.getCurrentAudioInformation() == null || C46094h.this.oKc.getCurrentAudioInformation().getAudioType() == null)) {
                    C46094h.this.audioType = C46094h.this.oKc.getCurrentAudioInformation().getAudioType();
                    if (C46094h.this.audioType != null) {
                        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "getAudioType:%d", Integer.valueOf(C46094h.this.audioType.getValue()));
                    }
                    C46094h c46094h = C46094h.this;
                    if (c46094h.audioType != null) {
                        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType audioType:%d, isStatMineType:%b", Integer.valueOf(c46094h.audioType.getValue()), Boolean.valueOf(c46094h.oKk));
                        if (!c46094h.oKk) {
                            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType OK");
                            c46094h.oKk = true;
                            if (c46094h.oJL != null) {
                                c46094h.oJL.mo46557zp(c46094h.audioType.getValue());
                            }
                        }
                    }
                }
                C46094h.this.bSR();
                if (C46094h.this.oKi) {
                    C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "start to play");
                    try {
                        if (C46094h.this.oKc != null) {
                            C46094h.this.oKc.setVolume((float) C46094h.this.csL.fqN, (float) C46094h.this.csL.fqN);
                            C46094h.this.oKc.start();
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "_onPrepared", new Object[0]);
                        C46094h.this.mo62386zl(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                        C46094h.m85965a(C46094h.this, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                    }
                    C46094h.this.oKe = true;
                    AppMethodBeat.m2505o(137356);
                    return;
                }
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "autoplay is false, don't start auto play!");
                AppMethodBeat.m2505o(137356);
            }
        }

        /* renamed from: b */
        static /* synthetic */ void m45304b(C285471 c285471) {
            AppMethodBeat.m2504i(137357);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "_onPreparing");
            c285471.oKn = C46094h.this.csL;
            if (c285471.oKn == null) {
                C4990ab.m7412e("MicroMsg.Audio.QQAudioPlayer", "cbMusic is null");
                AppMethodBeat.m2505o(137357);
            } else if (C46094h.this.fqY || C46094h.this.oKf) {
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                AppMethodBeat.m2505o(137357);
            } else {
                C46094h c46094h = C46094h.this;
                C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onPreparintEvent");
                C4883b c18405u = new C18405u();
                c18405u.csP.action = 9;
                c18405u.csP.state = "waiting";
                c18405u.csP.ckD = c46094h.bSQ();
                c18405u.csP.appId = c46094h.getAppId();
                C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
                AppMethodBeat.m2505o(137357);
            }
        }

        /* renamed from: c */
        static /* synthetic */ void m45305c(C285471 c285471) {
            AppMethodBeat.m2504i(137358);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "_onStart");
            if (C46094h.this.oJL != null) {
                C46094h.this.oJL.mo46549a(C46094h.this.csL.ckD, C46094h.this.csL.clP, System.currentTimeMillis() - C46094h.this.csL.fqO, C46094h.this.csL.fqP, C46094h.this.csL.fqQ);
            }
            c285471.oKn = C46094h.this.csL;
            if (C46094h.this.fqY || C46094h.this.oKf) {
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                if (C46094h.this.oKc != null && C46094h.this.oKe) {
                    C46094h.this.oKe = false;
                    C46094h.this.oKc.stop();
                }
                AppMethodBeat.m2505o(137358);
                return;
            }
            C46094h.this.bSS();
            if (C46094h.this.oKg != null) {
                C46094h.this.oKg.isStop = true;
            }
            C46094h.this.oKg = new C39431a(C46094h.this, (byte) 0);
            C46094h.this.oKg.isStop = false;
            AppMethodBeat.m2505o(137358);
        }

        /* renamed from: d */
        static /* synthetic */ void m45306d(C285471 c285471) {
            AppMethodBeat.m2504i(137359);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "_onPause");
            C46094h.this.bSU();
            AppMethodBeat.m2505o(137359);
        }

        /* renamed from: e */
        static /* synthetic */ void m45307e(C285471 c285471) {
            AppMethodBeat.m2504i(137360);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "_onStop");
            if (c285471.oKn == null) {
                C4990ab.m7412e("MicroMsg.Audio.QQAudioPlayer", "currentMusic is null");
                AppMethodBeat.m2505o(137360);
                return;
            }
            C46094h.this.oKe = false;
            C46094h.this.eDL = System.currentTimeMillis();
            if (C46094h.this.ckD.equalsIgnoreCase(c285471.oKn.ckD)) {
                if (C46094h.this.fqY) {
                    C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
                    C46094h.this.bSU();
                    AppMethodBeat.m2505o(137360);
                    return;
                }
                C46094h.this.bSV();
            }
            AppMethodBeat.m2505o(137360);
        }

        /* renamed from: f */
        static /* synthetic */ void m45308f(C285471 c285471) {
            AppMethodBeat.m2504i(137361);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "_onCompletion");
            if (!C46094h.this.csL.fqL) {
                C46094h.this.bSX();
            }
            if (C46094h.this.oKg != null) {
                C46094h.this.oKg.isStop = true;
                C46094h.this.oKg = null;
            }
            C46094h.this.eDL = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "play end, isPausedOnBackground:%b, playParam.loop:%b, isStartPlaying:%b, ", Boolean.valueOf(C46094h.this.fqY), Boolean.valueOf(C46094h.this.csL.fqL), Boolean.valueOf(C46094h.this.oKe));
            if (C46094h.this.fqY) {
                C46094h.this.oKe = false;
                C46094h.this.startTime = 0;
                C46094h.this.oKi = true;
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground is true, do stop player and don't play again");
                AppMethodBeat.m2505o(137361);
            } else if (C46094h.this.oKf) {
                C46094h.this.oKe = false;
                C46094h.this.startTime = 0;
                C46094h.this.oKi = true;
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "isForcePause is true, do stop player and don't play again");
                AppMethodBeat.m2505o(137361);
            } else if (C46094h.this.csL.fqL && C46094h.this.oKe) {
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "play end normally and loop play again");
                C46094h.this.oKe = false;
                C46094h.this.startTime = 0;
                C46094h.this.oKi = true;
                C46094h.m85966b(C46094h.this);
                AppMethodBeat.m2505o(137361);
            } else {
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "play end, but not loop play");
                C46094h.this.oKe = false;
                C46094h.this.startTime = 0;
                C46094h.this.oKi = true;
                AppMethodBeat.m2505o(137361);
            }
        }

        static /* synthetic */ void bTl() {
            AppMethodBeat.m2504i(137362);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "_onEnd");
            AppMethodBeat.m2505o(137362);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.b.h$a */
    class C39431a implements Runnable {
        boolean isStop;

        private C39431a() {
            this.isStop = true;
        }

        /* synthetic */ C39431a(C46094h c46094h, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(137363);
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (C46094h.this.oKc != null && C46094h.this.aie()) {
                        C46094h.this.bTk();
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
            AppMethodBeat.m2505o(137363);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m85965a(C46094h c46094h, int i) {
        AppMethodBeat.m2504i(137392);
        c46094h.m85967zm(i);
        AppMethodBeat.m2505o(137392);
    }

    public C46094h() {
        AppMethodBeat.m2504i(137364);
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
        this.oKm = new C285471();
        this.ckD = C28542e.bSy();
        C12665a.bUE();
        if (C0380b.checkSelfPermission(C4996ah.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
            C4990ab.m7412e("MicroMsg.Audio.BaseAudioPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
        } else {
            this.oJY = new C5031ax();
            this.oJY.mo10368gK(C4996ah.getContext());
            this.oJY.mo10365a(new C394301());
        }
        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
        this.ilv = new C7306ak(Looper.myLooper());
        AppMethodBeat.m2505o(137364);
    }

    /* renamed from: SN */
    public final void mo74008SN(String str) {
        AppMethodBeat.m2504i(137365);
        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", str);
        this.ckD = str;
        AppMethodBeat.m2505o(137365);
    }

    /* renamed from: b */
    public final void mo74009b(C17875b c17875b) {
        AppMethodBeat.m2504i(137366);
        this.csL = c17875b;
        this.startTime = c17875b.startTime;
        this.oKi = c17875b.fqK;
        if (this.oKc != null && aie()) {
            C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", this.ckD, this.cle, Double.valueOf(this.csL.fqN));
            this.oKc.setVolume((float) this.csL.fqN, (float) this.csL.fqN);
        }
        AppMethodBeat.m2505o(137366);
    }

    /* renamed from: l */
    public final void mo74020l(C17875b c17875b) {
        AppMethodBeat.m2504i(137367);
        if (c17875b == null) {
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
            bSY();
            AppMethodBeat.m2505o(137367);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKj;
        if (this.csL == null || !this.csL.mo33376e(c17875b) || j > 100) {
            this.oJL = (C28540d) C43329b.m77295ar(C28540d.class);
            if (this.oJL != null) {
                this.oJL.mo46556zo(c17875b.fromScene);
            }
            this.oKj = currentTimeMillis;
            this.csL = c17875b;
            C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", Integer.valueOf(this.csL.fromScene), this.ckD);
            if (this.oKc != null && aie()) {
                this.oKc.stop();
            }
            this.bqQ = 0;
            this.startTime = c17875b.startTime;
            this.oKi = c17875b.fqK;
            this.audioType = null;
            this.oKk = false;
            this.fqY = false;
            this.oKf = false;
            bSZ();
            AppMethodBeat.m2505o(137367);
            return;
        }
        this.csL = c17875b;
        this.startTime = c17875b.startTime;
        this.oKi = c17875b.fqK;
        C4990ab.m7413e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", this.cle, Long.valueOf(j));
        AppMethodBeat.m2505o(137367);
    }

    private void bSZ() {
        AppMethodBeat.m2504i(137368);
        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
        if (!TextUtils.isEmpty(this.csL.filePath) && this.csL.fqV == null) {
            C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", this.csL.filePath);
            if (this.oKc == null) {
                this.oKc = new CommonPlayer(this.oKm);
            }
            this.oKc.reset();
            try {
                this.oKc.setDataSource(this.csL.filePath);
                this.oKc.prepare();
                AppMethodBeat.m2505o(137368);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "initPlayer exception", new Object[0]);
                mo62386zl(501);
                m85967zm(501);
                AppMethodBeat.m2505o(137368);
            }
        } else if (TextUtils.isEmpty(this.csL.filePath) || this.csL.fqV == null) {
            URL url;
            C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", this.csL.clP);
            bTa();
            try {
                url = new URL(this.cle);
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "initPlayer", new Object[0]);
                url = null;
            }
            if (url == null) {
                C4990ab.m7412e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
                mo62386zl(500);
                m85967zm(500);
                AppMethodBeat.m2505o(137368);
                return;
            }
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
                AppMethodBeat.m2505o(137368);
            } catch (Exception e22) {
                C4990ab.m7412e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e22.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e22, "initPlayer", new Object[0]);
                mo62386zl(501);
                m85967zm(501);
                AppMethodBeat.m2505o(137368);
            }
        } else {
            C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", this.csL.filePath);
            if (this.oKc == null) {
                this.oKc = new CommonPlayer(this.oKm);
            }
            this.oKc.reset();
            try {
                this.oKc.setDataSource(new C24801b(this.csL.fqV));
                this.oKc.prepare();
                AppMethodBeat.m2505o(137368);
            } catch (Exception e222) {
                C4990ab.m7412e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e222.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e222, "initPlayer", new Object[0]);
                mo62386zl(501);
                m85967zm(501);
                AppMethodBeat.m2505o(137368);
            }
        }
    }

    private void bTa() {
        boolean z;
        AppMethodBeat.m2504i(137369);
        this.cle = this.csL.clP;
        if (C46101e.m86001Tw(this.cle)) {
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", this.cle);
        C39433g.m67344SV(this.cle);
        C39433g.m67352aV(this.cle, z);
        AppMethodBeat.m2505o(137369);
    }

    public final void pause() {
        AppMethodBeat.m2504i(137370);
        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", this.ckD);
        this.oKf = true;
        if (this.oKc == null || !aie()) {
            if (this.oKc != null && isCompleted()) {
                C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
                this.oKe = false;
            }
            AppMethodBeat.m2505o(137370);
            return;
        }
        try {
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "pause success");
            this.oKc.pause();
            AppMethodBeat.m2505o(137370);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "pause", new Object[0]);
            mo62386zl(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            m85967zm(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            AppMethodBeat.m2505o(137370);
        }
    }

    public final void bTb() {
        AppMethodBeat.m2504i(137371);
        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
        pause();
        AppMethodBeat.m2505o(137371);
    }

    public final void resume() {
        AppMethodBeat.m2504i(137372);
        this.bqQ = 0;
        boolean bTc = bTc();
        boolean aie = aie();
        this.oKf = false;
        this.fqY = false;
        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", Boolean.valueOf(bTc), Boolean.valueOf(aie), Boolean.valueOf(this.oKe), this.ckD);
        if (this.oKc != null && !bTd() && !bTc && !aie && !this.oKe) {
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
            this.startTime = 0;
            this.oKi = true;
            bSZ();
            if (this.oJL != null) {
                this.oJL.mo46556zo(this.csL.fromScene);
                AppMethodBeat.m2505o(137372);
                return;
            }
        } else if (this.oKc != null && ((isPaused() || bTd()) && !aie)) {
            C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
            try {
                this.oKc.setVolume((float) this.csL.fqN, (float) this.csL.fqN);
                this.oKc.start();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "resume", new Object[0]);
                mo62386zl(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
                m85967zm(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
            }
            this.oKe = true;
        }
        AppMethodBeat.m2505o(137372);
    }

    public final boolean aie() {
        AppMethodBeat.m2504i(137373);
        if (this.oKc == null) {
            AppMethodBeat.m2505o(137373);
            return false;
        } else if (this.oKc.getPlayerState() == 4) {
            AppMethodBeat.m2505o(137373);
            return true;
        } else {
            AppMethodBeat.m2505o(137373);
            return false;
        }
    }

    public final boolean bTc() {
        AppMethodBeat.m2504i(137374);
        if (this.oKc == null) {
            AppMethodBeat.m2505o(137374);
            return false;
        } else if (this.oKc.getPlayerState() == 3) {
            AppMethodBeat.m2505o(137374);
            return true;
        } else {
            AppMethodBeat.m2505o(137374);
            return false;
        }
    }

    public final boolean bTd() {
        AppMethodBeat.m2504i(137375);
        if (this.oKc == null) {
            AppMethodBeat.m2505o(137375);
            return false;
        } else if (this.oKc.getPlayerState() == 2) {
            AppMethodBeat.m2505o(137375);
            return true;
        } else {
            AppMethodBeat.m2505o(137375);
            return false;
        }
    }

    public final boolean isPaused() {
        AppMethodBeat.m2504i(137376);
        if (this.oKc == null) {
            AppMethodBeat.m2505o(137376);
            return false;
        } else if (this.oKc.getPlayerState() == 5) {
            AppMethodBeat.m2505o(137376);
            return true;
        } else {
            AppMethodBeat.m2505o(137376);
            return false;
        }
    }

    public final boolean isCompleted() {
        AppMethodBeat.m2504i(137377);
        if (this.oKc == null) {
            AppMethodBeat.m2505o(137377);
            return false;
        } else if (this.oKc.getPlayerState() == 7) {
            AppMethodBeat.m2505o(137377);
            return true;
        } else {
            AppMethodBeat.m2505o(137377);
            return false;
        }
    }

    public final boolean isStopped() {
        AppMethodBeat.m2504i(137378);
        if (this.oKc == null) {
            AppMethodBeat.m2505o(137378);
            return false;
        } else if (this.oKc.getPlayerState() == 6) {
            AppMethodBeat.m2505o(137378);
            return true;
        } else {
            AppMethodBeat.m2505o(137378);
            return false;
        }
    }

    public final boolean aig() {
        AppMethodBeat.m2504i(137379);
        if (!this.oKe || bTc()) {
            AppMethodBeat.m2505o(137379);
            return false;
        }
        AppMethodBeat.m2505o(137379);
        return true;
    }

    public final void bTe() {
        AppMethodBeat.m2504i(137380);
        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
        this.fqY = true;
        this.oKf = true;
        AppMethodBeat.m2505o(137380);
    }

    public final void bTf() {
        AppMethodBeat.m2504i(137381);
        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
        this.fqY = true;
        bTh();
        AppMethodBeat.m2505o(137381);
    }

    public final void bTg() {
        AppMethodBeat.m2504i(137382);
        this.fqY = false;
        this.oKf = true;
        bSV();
        this.eDL = System.currentTimeMillis();
        AppMethodBeat.m2505o(137382);
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(137383);
        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
        this.fqY = false;
        bTh();
        AppMethodBeat.m2505o(137383);
    }

    private void bTh() {
        AppMethodBeat.m2504i(137384);
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
            C4990ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "stopPlay", new Object[0]);
            mo62386zl(504);
            m85967zm(504);
        }
        this.oKe = false;
        this.oKf = true;
        this.eDL = System.currentTimeMillis();
        AppMethodBeat.m2505o(137384);
    }

    public final int bTi() {
        AppMethodBeat.m2504i(137385);
        if (this.oKc != null) {
            int currentPosition = (int) this.oKc.getCurrentPosition();
            AppMethodBeat.m2505o(137385);
            return currentPosition;
        }
        AppMethodBeat.m2505o(137385);
        return -1;
    }

    public final int getDuration() {
        AppMethodBeat.m2504i(137386);
        if (this.oKc != null) {
            int duration = this.oKc.getDuration();
            AppMethodBeat.m2505o(137386);
            return duration;
        }
        AppMethodBeat.m2505o(137386);
        return -1;
    }

    /* renamed from: lP */
    public final boolean mo8037lP(int i) {
        AppMethodBeat.m2504i(137387);
        int duration = getDuration();
        C4990ab.m7417i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0) {
            C4990ab.m7413e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            stopPlay();
            AppMethodBeat.m2505o(137387);
            return false;
        } else if (i > duration) {
            C4990ab.m7413e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            AppMethodBeat.m2505o(137387);
            return false;
        } else {
            if (this.oKc != null) {
                C4990ab.m7416i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
                C4883b c18405u = new C18405u();
                c18405u.csP.action = 10;
                c18405u.csP.state = "seeking";
                c18405u.csP.ckD = bSQ();
                c18405u.csP.appId = getAppId();
                C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
                this.oKc.seekTo(i);
            }
            AppMethodBeat.m2505o(137387);
            return true;
        }
    }

    public final C41729d bTj() {
        int bufferedPercentage;
        boolean z = false;
        AppMethodBeat.m2504i(137388);
        if (this.oKd == null) {
            this.oKd = new C41729d();
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
        C41729d c41729d = this.oKd;
        if (!aie) {
            z = true;
        }
        c41729d.f17164rw = z;
        this.oKd.fqY = this.fqY;
        this.oKd.fqZ = (bufferedPercentage * duration) / 100;
        if (this.csL != null) {
            this.oKd.startTime = this.csL.fqJ;
            this.oKd.ckz = this.csL.clP;
            C41729d c41729d2 = this.oKd;
            AppMethodBeat.m2505o(137388);
            return c41729d2;
        }
        AppMethodBeat.m2505o(137388);
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

    /* renamed from: zm */
    private void m85967zm(int i) {
        AppMethodBeat.m2504i(137389);
        if (this.oJL != null) {
            this.oJL.mo46553eD(this.csL.fromScene, i);
        }
        AppMethodBeat.m2505o(137389);
    }

    public final void release() {
        AppMethodBeat.m2504i(137390);
        C4990ab.m7416i("MicroMsg.Audio.QQAudioPlayer", "release");
        this.oJR = null;
        if (this.oKc != null) {
            this.oKc.release();
            this.oKc = null;
        }
        bSM();
        AppMethodBeat.m2505o(137390);
    }

    public final void bTk() {
        AppMethodBeat.m2504i(137391);
        if (this.ckD.equalsIgnoreCase(this.csL.ckD) && this.oKc != null && aie()) {
            int currentPosition = (int) this.oKc.getCurrentPosition();
            int duration = this.oKc.getDuration();
            if (currentPosition > 0 && duration > 0 && this.oKa != null) {
                this.oKa.mo46715dN(currentPosition, duration);
            }
        }
        AppMethodBeat.m2505o(137391);
    }

    public final boolean bSO() {
        return true;
    }
}
