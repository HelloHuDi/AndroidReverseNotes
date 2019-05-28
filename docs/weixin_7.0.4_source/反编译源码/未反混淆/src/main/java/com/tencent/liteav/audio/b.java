package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController;
import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.g;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class b implements e {
    public static final int a = a.e;
    public static final int b = a.f;
    public static final int c = a.h;
    public static final int d = TXEAudioDef.TXE_REVERB_TYPE_0;
    public static final int e = TXEAudioDef.TXE_AEC_NONE;
    public static final int f = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
    static b g = new b();
    private static final String h = ("AudioCenter:" + b.class.getSimpleName());
    private WeakReference<d> i;
    private int j = a;
    private int k = b;
    private int l = a.h;
    private int m = d;
    private boolean n = false;
    private int o = e;
    private boolean p = false;
    private boolean q = false;
    private Context r;
    private float s = 1.0f;
    private int t = -1;
    private int u = -1;
    private c v = null;

    static {
        AppMethodBeat.i(66743);
        AppMethodBeat.o(66743);
    }

    private b() {
    }

    public static b a() {
        return g;
    }

    public int a(Context context) {
        AppMethodBeat.i(66726);
        int i;
        if (context == null) {
            TXCLog.e(h, "invalid param, start record failed!");
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.o(66726);
            return i;
        }
        this.r = context.getApplicationContext();
        com.tencent.liteav.audio.impl.a.a().a(this.r);
        com.tencent.liteav.audio.impl.c.a().a(this.r);
        com.tencent.liteav.audio.impl.c.a().a((e) this);
        if (com.tencent.liteav.audio.impl.b.b(this.o) != TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK) {
            TXCLog.w(h, "start recorder failed, with aec type " + this.o + ", invalid aec player has started!");
        }
        if (this.v == null || !this.v.isRecording()) {
            if (this.v == null) {
                if (this.o == TXEAudioDef.TXE_AEC_TRAE) {
                    this.v = new g();
                } else {
                    this.v = new TXCAudioSysRecordController();
                }
            }
            if (this.v != null) {
                g();
                i = this.v.startRecord(this.r);
                AppMethodBeat.o(66726);
                return i;
            }
            TXCLog.e(h, "start Record failed! controller is null!");
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.o(66726);
            return i;
        }
        TXCLog.e(h, "record has started, can not start again!");
        i = TXEAudioDef.TXE_AUDIO_RECORD_ERR_REPEAT_OPTION;
        AppMethodBeat.o(66726);
        return i;
    }

    public int b() {
        AppMethodBeat.i(66727);
        int i = TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK;
        if (this.v != null) {
            i = this.v.stopRecord();
            this.v = null;
        }
        this.i = null;
        this.j = a;
        this.k = b;
        this.l = a.h;
        this.m = d;
        this.n = false;
        this.o = e;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = 1.0f;
        this.t = -1;
        this.u = -1;
        g();
        com.tencent.liteav.audio.impl.c.a().b((e) this);
        AppMethodBeat.o(66727);
        return i;
    }

    public boolean c() {
        AppMethodBeat.i(66728);
        if (this.v != null) {
            boolean isRecording = this.v.isRecording();
            AppMethodBeat.o(66728);
            return isRecording;
        }
        AppMethodBeat.o(66728);
        return false;
    }

    public void a(boolean z) {
        AppMethodBeat.i(66729);
        this.q = z;
        if (this.v != null) {
            this.v.setIsCustomRecord(z);
        }
        AppMethodBeat.o(66729);
    }

    public void a(d dVar) {
        AppMethodBeat.i(66730);
        this.i = new WeakReference(dVar);
        if (this.v != null) {
            this.v.setListener(dVar);
        }
        AppMethodBeat.o(66730);
    }

    public int d() {
        return this.k;
    }

    public int e() {
        return this.j;
    }

    public void a(int i) {
        AppMethodBeat.i(66731);
        TXCLog.i(h, "setSampleRate: ".concat(String.valueOf(i)));
        this.j = i;
        if (this.v != null) {
            this.v.setSamplerate(i);
        }
        AppMethodBeat.o(66731);
    }

    public void c(int i) {
        AppMethodBeat.i(66732);
        TXCLog.i(h, "setChannels: ".concat(String.valueOf(i)));
        this.k = i;
        if (this.v != null) {
            this.v.setChannels(i);
        }
        AppMethodBeat.o(66732);
    }

    public void d(int i) {
        AppMethodBeat.i(66733);
        TXCLog.i(h, "setReverbType: ".concat(String.valueOf(i)));
        this.m = i;
        if (this.v != null) {
            this.v.setReverbType(i);
        }
        AppMethodBeat.o(66733);
    }

    public void a(boolean z, Context context) {
        AppMethodBeat.i(66734);
        if (!z) {
            a(TXEAudioDef.TXE_AEC_NONE, context);
            AppMethodBeat.o(66734);
        } else if (com.tencent.liteav.basic.f.b.a().g()) {
            a(TXEAudioDef.TXE_AEC_SYSTEM, context);
            AppMethodBeat.o(66734);
        } else {
            com.tencent.liteav.audio.impl.a.a(com.tencent.liteav.basic.f.b.a().b());
            a(TXEAudioDef.TXE_AEC_TRAE, context);
            AppMethodBeat.o(66734);
        }
    }

    private void a(int i, Context context) {
        AppMethodBeat.i(66735);
        if (i != TXEAudioDef.TXE_AEC_TRAE || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            if (this.o != i) {
                if (this.v != null && this.v.isRecording()) {
                    this.v.stopRecord();
                    this.v = null;
                    this.o = i;
                    a(this.r);
                }
                this.o = i;
            }
            if (this.v != null) {
                this.v.setAECType(i);
            }
            AppMethodBeat.o(66735);
            return;
        }
        TXCLog.e(h, "set aec type failed, check trae library failed!!");
        AppMethodBeat.o(66735);
    }

    public void b(boolean z) {
    }

    public void c(boolean z) {
        AppMethodBeat.i(66736);
        TXCLog.i(h, "setMute: ".concat(String.valueOf(z)));
        this.n = z;
        if (this.v != null) {
            this.v.setMute(z);
        }
        AppMethodBeat.o(66736);
    }

    public void a(float f) {
        AppMethodBeat.i(66737);
        TXCLog.i(h, "setVolume: ".concat(String.valueOf(f)));
        this.s = f;
        if (this.v != null) {
            this.v.setVolume(f);
        }
        AppMethodBeat.o(66737);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(66738);
        TXCLog.i(h, "setChangerType: " + i + " " + i2);
        this.t = i;
        this.u = i2;
        if (this.v != null) {
            this.v.setChangerType(i, i2);
        }
        AppMethodBeat.o(66738);
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(66739);
        if (this.v != null) {
            this.v.sendCustomPCMData(bArr);
        }
        AppMethodBeat.o(66739);
    }

    public int f() {
        AppMethodBeat.i(66740);
        int i;
        if (f.a().c()) {
            if (this.o == TXEAudioDef.TXE_AEC_TRAE) {
                TXCLog.e(h, "audio mic has start, but aec type is trae!!" + this.o);
                i = TXEAudioDef.TXE_AEC_NONE;
                AppMethodBeat.o(66740);
                return i;
            }
            i = this.o;
            AppMethodBeat.o(66740);
            return i;
        } else if (!TXCTraeJNI.nativeTraeIsRecording()) {
            i = TXEAudioDef.TXE_AEC_NONE;
            AppMethodBeat.o(66740);
            return i;
        } else if (this.o != TXEAudioDef.TXE_AEC_TRAE) {
            TXCLog.e(h, "trae engine has start, but aec type is not trae!!" + this.o);
            i = TXEAudioDef.TXE_AEC_TRAE;
            AppMethodBeat.o(66740);
            return i;
        } else {
            i = this.o;
            AppMethodBeat.o(66740);
            return i;
        }
    }

    private void g() {
        AppMethodBeat.i(66741);
        if (this.i != null) {
            a((d) this.i.get());
        }
        a(this.q);
        a(this.j);
        c(this.k);
        d(this.m);
        a(this.o, this.r);
        b(this.p);
        c(this.n);
        a(this.s);
        a(this.t, this.u);
        AppMethodBeat.o(66741);
    }

    public void b(int i) {
        AppMethodBeat.i(66742);
        switch (i) {
            case 0:
                if (this.v != null) {
                    this.v.setMute(this.n);
                    break;
                }
                break;
            case 1:
                if (this.v != null) {
                    this.v.setMute(true);
                    AppMethodBeat.o(66742);
                    return;
                }
                break;
            case 2:
                if (this.v != null) {
                    this.v.setMute(true);
                    AppMethodBeat.o(66742);
                    return;
                }
                break;
        }
        AppMethodBeat.o(66742);
    }
}
