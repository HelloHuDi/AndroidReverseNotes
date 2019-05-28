package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.C17769b;
import com.tencent.liteav.audio.impl.C25642c;
import com.tencent.liteav.audio.impl.C32136a;
import com.tencent.liteav.audio.impl.C45101e;
import com.tencent.liteav.audio.impl.Record.C0944g;
import com.tencent.liteav.audio.impl.Record.C37349c;
import com.tencent.liteav.audio.impl.Record.C45100f;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.liteav.audio.b */
public class C8790b implements C45101e {
    /* renamed from: a */
    public static final int f2444a = C41678a.f16923e;
    /* renamed from: b */
    public static final int f2445b = C41678a.f16924f;
    /* renamed from: c */
    public static final int f2446c = C41678a.f16926h;
    /* renamed from: d */
    public static final int f2447d = TXEAudioDef.TXE_REVERB_TYPE_0;
    /* renamed from: e */
    public static final int f2448e = TXEAudioDef.TXE_AEC_NONE;
    /* renamed from: f */
    public static final int f2449f = TXEAudioDef.TXE_AUDIO_TYPE_AAC;
    /* renamed from: g */
    static C8790b f2450g = new C8790b();
    /* renamed from: h */
    private static final String f2451h = ("AudioCenter:" + C8790b.class.getSimpleName());
    /* renamed from: i */
    private WeakReference<C8792d> f2452i;
    /* renamed from: j */
    private int f2453j = f2444a;
    /* renamed from: k */
    private int f2454k = f2445b;
    /* renamed from: l */
    private int f2455l = C41678a.f16926h;
    /* renamed from: m */
    private int f2456m = f2447d;
    /* renamed from: n */
    private boolean f2457n = false;
    /* renamed from: o */
    private int f2458o = f2448e;
    /* renamed from: p */
    private boolean f2459p = false;
    /* renamed from: q */
    private boolean f2460q = false;
    /* renamed from: r */
    private Context f2461r;
    /* renamed from: s */
    private float f2462s = 1.0f;
    /* renamed from: t */
    private int f2463t = -1;
    /* renamed from: u */
    private int f2464u = -1;
    /* renamed from: v */
    private C37349c f2465v = null;

    static {
        AppMethodBeat.m2504i(66743);
        AppMethodBeat.m2505o(66743);
    }

    private C8790b() {
    }

    /* renamed from: a */
    public static C8790b m15606a() {
        return f2450g;
    }

    /* renamed from: a */
    public int mo19834a(Context context) {
        AppMethodBeat.m2504i(66726);
        int i;
        if (context == null) {
            TXCLog.m15676e(f2451h, "invalid param, start record failed!");
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.m2505o(66726);
            return i;
        }
        this.f2461r = context.getApplicationContext();
        C32136a.m52261a().mo52717a(this.f2461r);
        C25642c.m40631a().mo43365a(this.f2461r);
        C25642c.m40631a().mo43366a((C45101e) this);
        if (C17769b.m27679b(this.f2458o) != TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK) {
            TXCLog.m15679w(f2451h, "start recorder failed, with aec type " + this.f2458o + ", invalid aec player has started!");
        }
        if (this.f2465v == null || !this.f2465v.isRecording()) {
            if (this.f2465v == null) {
                if (this.f2458o == TXEAudioDef.TXE_AEC_TRAE) {
                    this.f2465v = new C0944g();
                } else {
                    this.f2465v = new TXCAudioSysRecordController();
                }
            }
            if (this.f2465v != null) {
                m15608g();
                i = this.f2465v.startRecord(this.f2461r);
                AppMethodBeat.m2505o(66726);
                return i;
            }
            TXCLog.m15676e(f2451h, "start Record failed! controller is null!");
            i = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
            AppMethodBeat.m2505o(66726);
            return i;
        }
        TXCLog.m15676e(f2451h, "record has started, can not start again!");
        i = TXEAudioDef.TXE_AUDIO_RECORD_ERR_REPEAT_OPTION;
        AppMethodBeat.m2505o(66726);
        return i;
    }

    /* renamed from: b */
    public int mo19842b() {
        AppMethodBeat.m2504i(66727);
        int i = TXEAudioDef.TXE_AUDIO_RECORD_ERR_OK;
        if (this.f2465v != null) {
            i = this.f2465v.stopRecord();
            this.f2465v = null;
        }
        this.f2452i = null;
        this.f2453j = f2444a;
        this.f2454k = f2445b;
        this.f2455l = C41678a.f16926h;
        this.f2456m = f2447d;
        this.f2457n = false;
        this.f2458o = f2448e;
        this.f2459p = false;
        this.f2460q = false;
        this.f2461r = null;
        this.f2462s = 1.0f;
        this.f2463t = -1;
        this.f2464u = -1;
        m15608g();
        C25642c.m40631a().mo43367b((C45101e) this);
        AppMethodBeat.m2505o(66727);
        return i;
    }

    /* renamed from: c */
    public boolean mo19846c() {
        AppMethodBeat.m2504i(66728);
        if (this.f2465v != null) {
            boolean isRecording = this.f2465v.isRecording();
            AppMethodBeat.m2505o(66728);
            return isRecording;
        }
        AppMethodBeat.m2505o(66728);
        return false;
    }

    /* renamed from: a */
    public void mo19839a(boolean z) {
        AppMethodBeat.m2504i(66729);
        this.f2460q = z;
        if (this.f2465v != null) {
            this.f2465v.setIsCustomRecord(z);
        }
        AppMethodBeat.m2505o(66729);
    }

    /* renamed from: a */
    public void mo19838a(C8792d c8792d) {
        AppMethodBeat.m2504i(66730);
        this.f2452i = new WeakReference(c8792d);
        if (this.f2465v != null) {
            this.f2465v.setListener(c8792d);
        }
        AppMethodBeat.m2505o(66730);
    }

    /* renamed from: d */
    public int mo19847d() {
        return this.f2454k;
    }

    /* renamed from: e */
    public int mo19849e() {
        return this.f2453j;
    }

    /* renamed from: a */
    public void mo19836a(int i) {
        AppMethodBeat.m2504i(66731);
        TXCLog.m15677i(f2451h, "setSampleRate: ".concat(String.valueOf(i)));
        this.f2453j = i;
        if (this.f2465v != null) {
            this.f2465v.setSamplerate(i);
        }
        AppMethodBeat.m2505o(66731);
    }

    /* renamed from: c */
    public void mo19844c(int i) {
        AppMethodBeat.m2504i(66732);
        TXCLog.m15677i(f2451h, "setChannels: ".concat(String.valueOf(i)));
        this.f2454k = i;
        if (this.f2465v != null) {
            this.f2465v.setChannels(i);
        }
        AppMethodBeat.m2505o(66732);
    }

    /* renamed from: d */
    public void mo19848d(int i) {
        AppMethodBeat.m2504i(66733);
        TXCLog.m15677i(f2451h, "setReverbType: ".concat(String.valueOf(i)));
        this.f2456m = i;
        if (this.f2465v != null) {
            this.f2465v.setReverbType(i);
        }
        AppMethodBeat.m2505o(66733);
    }

    /* renamed from: a */
    public void mo19840a(boolean z, Context context) {
        AppMethodBeat.m2504i(66734);
        if (!z) {
            m15607a(TXEAudioDef.TXE_AEC_NONE, context);
            AppMethodBeat.m2505o(66734);
        } else if (C45104b.m82752a().mo72884g()) {
            m15607a(TXEAudioDef.TXE_AEC_SYSTEM, context);
            AppMethodBeat.m2505o(66734);
        } else {
            C32136a.m52267a(C45104b.m82752a().mo72879b());
            m15607a(TXEAudioDef.TXE_AEC_TRAE, context);
            AppMethodBeat.m2505o(66734);
        }
    }

    /* renamed from: a */
    private void m15607a(int i, Context context) {
        AppMethodBeat.m2504i(66735);
        if (i != TXEAudioDef.TXE_AEC_TRAE || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            if (this.f2458o != i) {
                if (this.f2465v != null && this.f2465v.isRecording()) {
                    this.f2465v.stopRecord();
                    this.f2465v = null;
                    this.f2458o = i;
                    mo19834a(this.f2461r);
                }
                this.f2458o = i;
            }
            if (this.f2465v != null) {
                this.f2465v.setAECType(i);
            }
            AppMethodBeat.m2505o(66735);
            return;
        }
        TXCLog.m15676e(f2451h, "set aec type failed, check trae library failed!!");
        AppMethodBeat.m2505o(66735);
    }

    /* renamed from: b */
    public void mo19843b(boolean z) {
    }

    /* renamed from: c */
    public void mo19845c(boolean z) {
        AppMethodBeat.m2504i(66736);
        TXCLog.m15677i(f2451h, "setMute: ".concat(String.valueOf(z)));
        this.f2457n = z;
        if (this.f2465v != null) {
            this.f2465v.setMute(z);
        }
        AppMethodBeat.m2505o(66736);
    }

    /* renamed from: a */
    public void mo19835a(float f) {
        AppMethodBeat.m2504i(66737);
        TXCLog.m15677i(f2451h, "setVolume: ".concat(String.valueOf(f)));
        this.f2462s = f;
        if (this.f2465v != null) {
            this.f2465v.setVolume(f);
        }
        AppMethodBeat.m2505o(66737);
    }

    /* renamed from: a */
    public void mo19837a(int i, int i2) {
        AppMethodBeat.m2504i(66738);
        TXCLog.m15677i(f2451h, "setChangerType: " + i + " " + i2);
        this.f2463t = i;
        this.f2464u = i2;
        if (this.f2465v != null) {
            this.f2465v.setChangerType(i, i2);
        }
        AppMethodBeat.m2505o(66738);
    }

    /* renamed from: a */
    public void mo19841a(byte[] bArr) {
        AppMethodBeat.m2504i(66739);
        if (this.f2465v != null) {
            this.f2465v.sendCustomPCMData(bArr);
        }
        AppMethodBeat.m2505o(66739);
    }

    /* renamed from: f */
    public int mo19850f() {
        AppMethodBeat.m2504i(66740);
        int i;
        if (C45100f.m82736a().mo72872c()) {
            if (this.f2458o == TXEAudioDef.TXE_AEC_TRAE) {
                TXCLog.m15676e(f2451h, "audio mic has start, but aec type is trae!!" + this.f2458o);
                i = TXEAudioDef.TXE_AEC_NONE;
                AppMethodBeat.m2505o(66740);
                return i;
            }
            i = this.f2458o;
            AppMethodBeat.m2505o(66740);
            return i;
        } else if (!TXCTraeJNI.nativeTraeIsRecording()) {
            i = TXEAudioDef.TXE_AEC_NONE;
            AppMethodBeat.m2505o(66740);
            return i;
        } else if (this.f2458o != TXEAudioDef.TXE_AEC_TRAE) {
            TXCLog.m15676e(f2451h, "trae engine has start, but aec type is not trae!!" + this.f2458o);
            i = TXEAudioDef.TXE_AEC_TRAE;
            AppMethodBeat.m2505o(66740);
            return i;
        } else {
            i = this.f2458o;
            AppMethodBeat.m2505o(66740);
            return i;
        }
    }

    /* renamed from: g */
    private void m15608g() {
        AppMethodBeat.m2504i(66741);
        if (this.f2452i != null) {
            mo19838a((C8792d) this.f2452i.get());
        }
        mo19839a(this.f2460q);
        mo19836a(this.f2453j);
        mo19844c(this.f2454k);
        mo19848d(this.f2456m);
        m15607a(this.f2458o, this.f2461r);
        mo19843b(this.f2459p);
        mo19845c(this.f2457n);
        mo19835a(this.f2462s);
        mo19837a(this.f2463t, this.f2464u);
        AppMethodBeat.m2505o(66741);
    }

    /* renamed from: b */
    public void mo3796b(int i) {
        AppMethodBeat.m2504i(66742);
        switch (i) {
            case 0:
                if (this.f2465v != null) {
                    this.f2465v.setMute(this.f2457n);
                    break;
                }
                break;
            case 1:
                if (this.f2465v != null) {
                    this.f2465v.setMute(true);
                    AppMethodBeat.m2505o(66742);
                    return;
                }
                break;
            case 2:
                if (this.f2465v != null) {
                    this.f2465v.setMute(true);
                    AppMethodBeat.m2505o(66742);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(66742);
    }
}
