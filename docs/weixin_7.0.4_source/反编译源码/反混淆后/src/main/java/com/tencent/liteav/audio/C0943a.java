package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.C17769b;
import com.tencent.liteav.audio.impl.C25642c;
import com.tencent.liteav.audio.impl.C32136a;
import com.tencent.liteav.audio.impl.C45101e;
import com.tencent.liteav.audio.impl.Play.C41675b;
import com.tencent.liteav.audio.impl.Play.C41676c;
import com.tencent.liteav.audio.impl.Play.C45098d;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.audio.a */
public class C0943a implements C45101e {
    /* renamed from: a */
    public static final int f1039a = TXEAudioDef.TXE_AEC_NONE;
    /* renamed from: b */
    public static float f1040b = 5.0f;
    /* renamed from: c */
    public static boolean f1041c = true;
    /* renamed from: d */
    public static float f1042d = 5.0f;
    /* renamed from: e */
    public static float f1043e = 1.0f;
    /* renamed from: f */
    public static boolean f1044f = false;
    /* renamed from: g */
    private static final String f1045g = ("AudioCenter:" + C0943a.class.getSimpleName());
    /* renamed from: h */
    private TXCAudioBasePlayController f1046h = null;
    /* renamed from: i */
    private C8791c f1047i;
    /* renamed from: j */
    private int f1048j = f1039a;
    /* renamed from: k */
    private float f1049k = f1040b;
    /* renamed from: l */
    private boolean f1050l = f1041c;
    /* renamed from: m */
    private float f1051m = f1042d;
    /* renamed from: n */
    private float f1052n = f1043e;
    /* renamed from: o */
    private boolean f1053o = false;
    /* renamed from: p */
    private boolean f1054p = false;
    /* renamed from: q */
    private boolean f1055q = f1044f;
    /* renamed from: r */
    private int f1056r = 0;
    /* renamed from: s */
    private Context f1057s;

    static {
        AppMethodBeat.m2504i(66541);
        AppMethodBeat.m2505o(66541);
    }

    /* renamed from: a */
    public synchronized int mo3787a(Context context) {
        int i;
        AppMethodBeat.m2504i(66518);
        if (context == null) {
            TXCLog.m15676e(f1045g, "invalid param, start play failed!");
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.m2505o(66518);
        } else {
            if (C17769b.m27680c(this.f1048j) != TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK) {
                TXCLog.m15679w(f1045g, "start player failed, with aec type " + this.f1048j + ", invalid aec recorder has started!");
            }
            if (this.f1046h == null || !this.f1046h.isPlaying()) {
                this.f1057s = context;
                C32136a.m52261a().mo52717a(context);
                C25642c.m40631a().mo43365a(this.f1057s);
                C25642c.m40631a().mo43366a((C45101e) this);
                if (this.f1046h == null) {
                    if (this.f1048j == TXEAudioDef.TXE_AEC_TRAE) {
                        this.f1046h = new C41676c(context.getApplicationContext());
                    } else {
                        this.f1046h = new C41675b(context.getApplicationContext());
                    }
                }
                if (this.f1046h != null) {
                    m2118a(this.f1048j, this.f1057s);
                    mo3791a(this.f1047i);
                    mo3789a(this.f1049k);
                    mo3792a(this.f1050l);
                    mo3795b(this.f1051m);
                    mo3799c(this.f1052n);
                    mo3800c(this.f1053o);
                    mo3797b(this.f1054p);
                    mo3790a(this.f1056r);
                    mo3802d(this.f1055q);
                    i = this.f1046h.startPlay();
                    AppMethodBeat.m2505o(66518);
                } else {
                    TXCLog.m15676e(f1045g, "start play failed! controller is null!");
                    i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
                    AppMethodBeat.m2505o(66518);
                }
            } else {
                TXCLog.m15676e(f1045g, "play has started, can not start again!");
                i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
                AppMethodBeat.m2505o(66518);
            }
        }
        return i;
    }

    /* renamed from: a */
    public synchronized int mo3786a() {
        int i;
        AppMethodBeat.m2504i(66519);
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        this.f1047i = null;
        this.f1049k = f1040b;
        this.f1050l = f1041c;
        this.f1051m = f1042d;
        this.f1052n = f1043e;
        this.f1053o = false;
        this.f1054p = false;
        this.f1055q = f1044f;
        this.f1056r = 0;
        this.f1057s = null;
        if (this.f1046h != null) {
            i = this.f1046h.stopPlay();
            this.f1046h = null;
        }
        C25642c.m40631a().mo43367b((C45101e) this);
        AppMethodBeat.m2505o(66519);
        return i;
    }

    /* renamed from: a */
    public void mo3793a(boolean z, Context context) {
        AppMethodBeat.m2504i(66520);
        if (!z) {
            m2118a(TXEAudioDef.TXE_AEC_NONE, context);
            AppMethodBeat.m2505o(66520);
        } else if (C45104b.m82752a().mo72884g()) {
            m2118a(TXEAudioDef.TXE_AEC_SYSTEM, context);
            AppMethodBeat.m2505o(66520);
        } else {
            C32136a.m52267a(C45104b.m82752a().mo72879b());
            m2118a(TXEAudioDef.TXE_AEC_TRAE, context);
            AppMethodBeat.m2505o(66520);
        }
    }

    /* renamed from: a */
    private void m2118a(int i, Context context) {
        AppMethodBeat.m2504i(66521);
        if (i != TXEAudioDef.TXE_AEC_TRAE || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            TXCLog.m15677i(f1045g, "set aec type to " + i + ", cur type " + this.f1048j);
            this.f1048j = i;
            AppMethodBeat.m2505o(66521);
            return;
        }
        TXCLog.m15676e(f1045g, "set aec type failed, check trae library failed!!");
        AppMethodBeat.m2505o(66521);
    }

    /* renamed from: a */
    public synchronized int mo3788a(C25648a c25648a) {
        int i;
        AppMethodBeat.m2504i(66522);
        if (this.f1046h == null) {
            TXCLog.m15676e(f1045g, "play audio failed, controller not created yet!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
            AppMethodBeat.m2505o(66522);
        } else {
            i = this.f1046h.playData(c25648a);
            AppMethodBeat.m2505o(66522);
        }
        return i;
    }

    /* renamed from: a */
    public void mo3791a(C8791c c8791c) {
        AppMethodBeat.m2504i(66523);
        this.f1047i = c8791c;
        if (this.f1046h != null) {
            this.f1046h.setListener(c8791c);
        }
        AppMethodBeat.m2505o(66523);
    }

    /* renamed from: a */
    public void mo3789a(float f) {
        AppMethodBeat.m2504i(66524);
        this.f1049k = f;
        if (this.f1046h != null) {
            this.f1046h.setCacheTime(f);
        }
        AppMethodBeat.m2505o(66524);
    }

    /* renamed from: a */
    public void mo3792a(boolean z) {
        AppMethodBeat.m2504i(66525);
        this.f1050l = z;
        if (this.f1046h != null) {
            this.f1046h.enableAutojustCache(z);
        }
        AppMethodBeat.m2505o(66525);
    }

    /* renamed from: b */
    public void mo3795b(float f) {
        AppMethodBeat.m2504i(66526);
        this.f1051m = f;
        if (this.f1046h != null) {
            this.f1046h.setAutoAdjustMaxCache(f);
        }
        AppMethodBeat.m2505o(66526);
    }

    /* renamed from: c */
    public void mo3799c(float f) {
        AppMethodBeat.m2504i(66527);
        this.f1052n = f;
        if (this.f1046h != null) {
            this.f1046h.setAutoAdjustMinCache(f);
        }
        AppMethodBeat.m2505o(66527);
    }

    /* renamed from: b */
    public synchronized long mo3794b() {
        long cacheDuration;
        AppMethodBeat.m2504i(66528);
        if (this.f1046h != null) {
            cacheDuration = this.f1046h.getCacheDuration();
            AppMethodBeat.m2505o(66528);
        } else {
            cacheDuration = 0;
            AppMethodBeat.m2505o(66528);
        }
        return cacheDuration;
    }

    /* renamed from: c */
    public synchronized long mo3798c() {
        long curPts;
        AppMethodBeat.m2504i(66529);
        if (this.f1046h != null) {
            curPts = this.f1046h.getCurPts();
            AppMethodBeat.m2505o(66529);
        } else {
            curPts = 0;
            AppMethodBeat.m2505o(66529);
        }
        return curPts;
    }

    /* renamed from: d */
    public synchronized int mo3801d() {
        int recvJitter;
        AppMethodBeat.m2504i(66530);
        if (this.f1046h != null) {
            recvJitter = this.f1046h.getRecvJitter();
            AppMethodBeat.m2505o(66530);
        } else {
            recvJitter = 0;
            AppMethodBeat.m2505o(66530);
        }
        return recvJitter;
    }

    /* renamed from: e */
    public synchronized long mo3803e() {
        long curRecvTS;
        AppMethodBeat.m2504i(66531);
        if (this.f1046h != null) {
            curRecvTS = this.f1046h.getCurRecvTS();
            AppMethodBeat.m2505o(66531);
        } else {
            curRecvTS = 0;
            AppMethodBeat.m2505o(66531);
        }
        return curRecvTS;
    }

    /* renamed from: f */
    public synchronized float mo3804f() {
        float cacheThreshold;
        AppMethodBeat.m2504i(66532);
        if (this.f1046h != null) {
            cacheThreshold = this.f1046h.getCacheThreshold();
            AppMethodBeat.m2505o(66532);
        } else {
            cacheThreshold = 0.0f;
            AppMethodBeat.m2505o(66532);
        }
        return cacheThreshold;
    }

    /* renamed from: b */
    public void mo3797b(boolean z) {
        AppMethodBeat.m2504i(66533);
        this.f1054p = z;
        if (this.f1046h != null) {
            this.f1046h.enableHWAcceleration(z);
        }
        AppMethodBeat.m2505o(66533);
    }

    /* renamed from: c */
    public void mo3800c(boolean z) {
        AppMethodBeat.m2504i(66534);
        this.f1053o = z;
        if (this.f1046h != null) {
            this.f1046h.enableRealTimePlay(z);
        }
        AppMethodBeat.m2505o(66534);
    }

    /* renamed from: d */
    public void mo3802d(boolean z) {
        AppMethodBeat.m2504i(66535);
        this.f1055q = z;
        if (this.f1046h != null) {
            this.f1046h.setMute(z);
        }
        AppMethodBeat.m2505o(66535);
    }

    /* renamed from: a */
    public static void m2119a(Context context, int i) {
        AppMethodBeat.m2504i(66536);
        TXCAudioBasePlayController.setAudioMode(context, i);
        AppMethodBeat.m2505o(66536);
    }

    /* renamed from: a */
    public void mo3790a(int i) {
        AppMethodBeat.m2504i(66537);
        this.f1056r = i;
        if (this.f1046h != null) {
            this.f1046h.setSmootheMode(this.f1056r);
        }
        AppMethodBeat.m2505o(66537);
    }

    /* renamed from: g */
    public int mo3805g() {
        AppMethodBeat.m2504i(66538);
        int i;
        if (C45098d.m82718a().mo72864d()) {
            if (this.f1048j == TXEAudioDef.TXE_AEC_TRAE) {
                TXCLog.m15676e(f1045g, "audio track has start, but aec type is trae!!" + this.f1048j);
                i = TXEAudioDef.TXE_AEC_NONE;
                AppMethodBeat.m2505o(66538);
                return i;
            }
            i = this.f1048j;
            AppMethodBeat.m2505o(66538);
            return i;
        } else if (!TXCTraeJNI.nativeTraeIsPlaying()) {
            i = TXEAudioDef.TXE_AEC_NONE;
            AppMethodBeat.m2505o(66538);
            return i;
        } else if (this.f1048j != TXEAudioDef.TXE_AEC_TRAE) {
            TXCLog.m15676e(f1045g, "trae engine has start, but aec type is not trae!!" + this.f1048j);
            i = TXEAudioDef.TXE_AEC_TRAE;
            AppMethodBeat.m2505o(66538);
            return i;
        } else {
            i = this.f1048j;
            AppMethodBeat.m2505o(66538);
            return i;
        }
    }

    /* renamed from: h */
    public TXAudioJitterBufferReportInfo mo3806h() {
        AppMethodBeat.m2504i(66539);
        if (this.f1046h != null) {
            TXAudioJitterBufferReportInfo reportInfo = this.f1046h.getReportInfo();
            AppMethodBeat.m2505o(66539);
            return reportInfo;
        }
        AppMethodBeat.m2505o(66539);
        return null;
    }

    /* renamed from: b */
    public void mo3796b(int i) {
        AppMethodBeat.m2504i(66540);
        switch (i) {
            case 0:
                if (this.f1046h != null) {
                    this.f1046h.setMute(this.f1055q);
                    break;
                }
                break;
            case 1:
                if (this.f1046h != null) {
                    this.f1046h.setMute(true);
                    AppMethodBeat.m2505o(66540);
                    return;
                }
                break;
            case 2:
                if (this.f1046h != null) {
                    this.f1046h.setMute(true);
                    AppMethodBeat.m2505o(66540);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(66540);
    }
}
