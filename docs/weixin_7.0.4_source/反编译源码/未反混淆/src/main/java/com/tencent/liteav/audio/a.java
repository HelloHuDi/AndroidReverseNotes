package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.audio.impl.c;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a implements e {
    public static final int a = TXEAudioDef.TXE_AEC_NONE;
    public static float b = 5.0f;
    public static boolean c = true;
    public static float d = 5.0f;
    public static float e = 1.0f;
    public static boolean f = false;
    private static final String g = ("AudioCenter:" + a.class.getSimpleName());
    private TXCAudioBasePlayController h = null;
    private c i;
    private int j = a;
    private float k = b;
    private boolean l = c;
    private float m = d;
    private float n = e;
    private boolean o = false;
    private boolean p = false;
    private boolean q = f;
    private int r = 0;
    private Context s;

    static {
        AppMethodBeat.i(66541);
        AppMethodBeat.o(66541);
    }

    public synchronized int a(Context context) {
        int i;
        AppMethodBeat.i(66518);
        if (context == null) {
            TXCLog.e(g, "invalid param, start play failed!");
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.o(66518);
        } else {
            if (b.c(this.j) != TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK) {
                TXCLog.w(g, "start player failed, with aec type " + this.j + ", invalid aec recorder has started!");
            }
            if (this.h == null || !this.h.isPlaying()) {
                this.s = context;
                com.tencent.liteav.audio.impl.a.a().a(context);
                c.a().a(this.s);
                c.a().a((e) this);
                if (this.h == null) {
                    if (this.j == TXEAudioDef.TXE_AEC_TRAE) {
                        this.h = new com.tencent.liteav.audio.impl.Play.c(context.getApplicationContext());
                    } else {
                        this.h = new com.tencent.liteav.audio.impl.Play.b(context.getApplicationContext());
                    }
                }
                if (this.h != null) {
                    a(this.j, this.s);
                    a(this.i);
                    a(this.k);
                    a(this.l);
                    b(this.m);
                    c(this.n);
                    c(this.o);
                    b(this.p);
                    a(this.r);
                    d(this.q);
                    i = this.h.startPlay();
                    AppMethodBeat.o(66518);
                } else {
                    TXCLog.e(g, "start play failed! controller is null!");
                    i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
                    AppMethodBeat.o(66518);
                }
            } else {
                TXCLog.e(g, "play has started, can not start again!");
                i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
                AppMethodBeat.o(66518);
            }
        }
        return i;
    }

    public synchronized int a() {
        int i;
        AppMethodBeat.i(66519);
        i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
        this.i = null;
        this.k = b;
        this.l = c;
        this.m = d;
        this.n = e;
        this.o = false;
        this.p = false;
        this.q = f;
        this.r = 0;
        this.s = null;
        if (this.h != null) {
            i = this.h.stopPlay();
            this.h = null;
        }
        c.a().b((e) this);
        AppMethodBeat.o(66519);
        return i;
    }

    public void a(boolean z, Context context) {
        AppMethodBeat.i(66520);
        if (!z) {
            a(TXEAudioDef.TXE_AEC_NONE, context);
            AppMethodBeat.o(66520);
        } else if (com.tencent.liteav.basic.f.b.a().g()) {
            a(TXEAudioDef.TXE_AEC_SYSTEM, context);
            AppMethodBeat.o(66520);
        } else {
            com.tencent.liteav.audio.impl.a.a(com.tencent.liteav.basic.f.b.a().b());
            a(TXEAudioDef.TXE_AEC_TRAE, context);
            AppMethodBeat.o(66520);
        }
    }

    private void a(int i, Context context) {
        AppMethodBeat.i(66521);
        if (i != TXEAudioDef.TXE_AEC_TRAE || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            TXCLog.i(g, "set aec type to " + i + ", cur type " + this.j);
            this.j = i;
            AppMethodBeat.o(66521);
            return;
        }
        TXCLog.e(g, "set aec type failed, check trae library failed!!");
        AppMethodBeat.o(66521);
    }

    public synchronized int a(com.tencent.liteav.basic.g.a aVar) {
        int i;
        AppMethodBeat.i(66522);
        if (this.h == null) {
            TXCLog.e(g, "play audio failed, controller not created yet!");
            i = TXEAudioDef.TXE_AUDIO_PLAY_ERR_INVALID_STATE;
            AppMethodBeat.o(66522);
        } else {
            i = this.h.playData(aVar);
            AppMethodBeat.o(66522);
        }
        return i;
    }

    public void a(c cVar) {
        AppMethodBeat.i(66523);
        this.i = cVar;
        if (this.h != null) {
            this.h.setListener(cVar);
        }
        AppMethodBeat.o(66523);
    }

    public void a(float f) {
        AppMethodBeat.i(66524);
        this.k = f;
        if (this.h != null) {
            this.h.setCacheTime(f);
        }
        AppMethodBeat.o(66524);
    }

    public void a(boolean z) {
        AppMethodBeat.i(66525);
        this.l = z;
        if (this.h != null) {
            this.h.enableAutojustCache(z);
        }
        AppMethodBeat.o(66525);
    }

    public void b(float f) {
        AppMethodBeat.i(66526);
        this.m = f;
        if (this.h != null) {
            this.h.setAutoAdjustMaxCache(f);
        }
        AppMethodBeat.o(66526);
    }

    public void c(float f) {
        AppMethodBeat.i(66527);
        this.n = f;
        if (this.h != null) {
            this.h.setAutoAdjustMinCache(f);
        }
        AppMethodBeat.o(66527);
    }

    public synchronized long b() {
        long cacheDuration;
        AppMethodBeat.i(66528);
        if (this.h != null) {
            cacheDuration = this.h.getCacheDuration();
            AppMethodBeat.o(66528);
        } else {
            cacheDuration = 0;
            AppMethodBeat.o(66528);
        }
        return cacheDuration;
    }

    public synchronized long c() {
        long curPts;
        AppMethodBeat.i(66529);
        if (this.h != null) {
            curPts = this.h.getCurPts();
            AppMethodBeat.o(66529);
        } else {
            curPts = 0;
            AppMethodBeat.o(66529);
        }
        return curPts;
    }

    public synchronized int d() {
        int recvJitter;
        AppMethodBeat.i(66530);
        if (this.h != null) {
            recvJitter = this.h.getRecvJitter();
            AppMethodBeat.o(66530);
        } else {
            recvJitter = 0;
            AppMethodBeat.o(66530);
        }
        return recvJitter;
    }

    public synchronized long e() {
        long curRecvTS;
        AppMethodBeat.i(66531);
        if (this.h != null) {
            curRecvTS = this.h.getCurRecvTS();
            AppMethodBeat.o(66531);
        } else {
            curRecvTS = 0;
            AppMethodBeat.o(66531);
        }
        return curRecvTS;
    }

    public synchronized float f() {
        float cacheThreshold;
        AppMethodBeat.i(66532);
        if (this.h != null) {
            cacheThreshold = this.h.getCacheThreshold();
            AppMethodBeat.o(66532);
        } else {
            cacheThreshold = 0.0f;
            AppMethodBeat.o(66532);
        }
        return cacheThreshold;
    }

    public void b(boolean z) {
        AppMethodBeat.i(66533);
        this.p = z;
        if (this.h != null) {
            this.h.enableHWAcceleration(z);
        }
        AppMethodBeat.o(66533);
    }

    public void c(boolean z) {
        AppMethodBeat.i(66534);
        this.o = z;
        if (this.h != null) {
            this.h.enableRealTimePlay(z);
        }
        AppMethodBeat.o(66534);
    }

    public void d(boolean z) {
        AppMethodBeat.i(66535);
        this.q = z;
        if (this.h != null) {
            this.h.setMute(z);
        }
        AppMethodBeat.o(66535);
    }

    public static void a(Context context, int i) {
        AppMethodBeat.i(66536);
        TXCAudioBasePlayController.setAudioMode(context, i);
        AppMethodBeat.o(66536);
    }

    public void a(int i) {
        AppMethodBeat.i(66537);
        this.r = i;
        if (this.h != null) {
            this.h.setSmootheMode(this.r);
        }
        AppMethodBeat.o(66537);
    }

    public int g() {
        AppMethodBeat.i(66538);
        int i;
        if (d.a().d()) {
            if (this.j == TXEAudioDef.TXE_AEC_TRAE) {
                TXCLog.e(g, "audio track has start, but aec type is trae!!" + this.j);
                i = TXEAudioDef.TXE_AEC_NONE;
                AppMethodBeat.o(66538);
                return i;
            }
            i = this.j;
            AppMethodBeat.o(66538);
            return i;
        } else if (!TXCTraeJNI.nativeTraeIsPlaying()) {
            i = TXEAudioDef.TXE_AEC_NONE;
            AppMethodBeat.o(66538);
            return i;
        } else if (this.j != TXEAudioDef.TXE_AEC_TRAE) {
            TXCLog.e(g, "trae engine has start, but aec type is not trae!!" + this.j);
            i = TXEAudioDef.TXE_AEC_TRAE;
            AppMethodBeat.o(66538);
            return i;
        } else {
            i = this.j;
            AppMethodBeat.o(66538);
            return i;
        }
    }

    public TXAudioJitterBufferReportInfo h() {
        AppMethodBeat.i(66539);
        if (this.h != null) {
            TXAudioJitterBufferReportInfo reportInfo = this.h.getReportInfo();
            AppMethodBeat.o(66539);
            return reportInfo;
        }
        AppMethodBeat.o(66539);
        return null;
    }

    public void b(int i) {
        AppMethodBeat.i(66540);
        switch (i) {
            case 0:
                if (this.h != null) {
                    this.h.setMute(this.q);
                    break;
                }
                break;
            case 1:
                if (this.h != null) {
                    this.h.setMute(true);
                    AppMethodBeat.o(66540);
                    return;
                }
                break;
            case 2:
                if (this.h != null) {
                    this.h.setMute(true);
                    AppMethodBeat.o(66540);
                    return;
                }
                break;
        }
        AppMethodBeat.o(66540);
    }
}
