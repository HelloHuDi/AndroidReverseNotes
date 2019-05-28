package com.tencent.liteav.beauty.p144b.p145a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.p144b.C16518b;
import com.tencent.liteav.beauty.p144b.C32155h;
import com.tencent.liteav.beauty.p144b.C37360o;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.a.a */
public class C0957a extends C16518b {
    /* renamed from: A */
    private int f1091A = 0;
    /* renamed from: B */
    private float f1092B = 1.0f;
    /* renamed from: C */
    private final float f1093C = 0.7f;
    /* renamed from: D */
    private float f1094D = 0.8f;
    /* renamed from: E */
    private float f1095E = 2.0f;
    /* renamed from: F */
    private int f1096F = 0;
    /* renamed from: G */
    private int f1097G = 0;
    /* renamed from: H */
    private int f1098H = 0;
    /* renamed from: I */
    private int f1099I = 0;
    /* renamed from: r */
    private C37357c f1100r = null;
    /* renamed from: s */
    private C45105d f1101s = null;
    /* renamed from: t */
    private C37358e f1102t = null;
    /* renamed from: u */
    private C32155h f1103u = null;
    /* renamed from: v */
    private C37360o f1104v = null;
    /* renamed from: w */
    private C32150b f1105w = null;
    /* renamed from: x */
    private String f1106x = "TXCBeauty2Filter";
    /* renamed from: y */
    private int f1107y = 0;
    /* renamed from: z */
    private int f1108z = 0;

    /* renamed from: b */
    public boolean mo3841b(int i, int i2) {
        AppMethodBeat.m2504i(66965);
        boolean c = m2163c(i, i2);
        AppMethodBeat.m2505o(66965);
        return c;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66966);
        if (this.f2620e == i && this.f2621f == i2) {
            AppMethodBeat.m2505o(66966);
            return;
        }
        this.f2620e = i;
        this.f2621f = i2;
        m2163c(i, i2);
        AppMethodBeat.m2505o(66966);
    }

    /* renamed from: c */
    public void mo3842c(int i) {
        AppMethodBeat.m2504i(66967);
        if (this.f1102t != null) {
            this.f1102t.mo60123a(((float) i) / 10.0f);
        }
        this.f1107y = i;
        m2164g(i);
        AppMethodBeat.m2505o(66967);
    }

    /* renamed from: d */
    public void mo3843d(int i) {
        AppMethodBeat.m2504i(66968);
        if (this.f1105w != null) {
            this.f1105w.mo52747a(((float) i) / 10.0f);
        }
        this.f1108z = i;
        AppMethodBeat.m2505o(66968);
    }

    /* renamed from: e */
    public void mo3845e(int i) {
        AppMethodBeat.m2504i(66969);
        if (this.f1105w != null) {
            this.f1105w.mo52748b(((float) i) / 10.0f);
        }
        this.f1091A = i;
        AppMethodBeat.m2505o(66969);
    }

    /* renamed from: g */
    private void m2164g(int i) {
        AppMethodBeat.m2504i(66970);
        this.f1092B = 1.0f - (((float) i) / 50.0f);
        if (this.f1103u != null) {
            this.f1103u.mo52754a(this.f1092B);
        }
        AppMethodBeat.m2505o(66970);
    }

    /* renamed from: f */
    public void mo3846f(int i) {
        AppMethodBeat.m2504i(66971);
        this.f1094D = 0.7f + (((float) i) / 12.0f);
        TXCLog.m15677i(this.f1106x, "set mSharpenLevel ".concat(String.valueOf(i)));
        if (this.f1104v != null) {
            this.f1104v.mo60126a(this.f1094D);
        }
        AppMethodBeat.m2505o(66971);
    }

    /* renamed from: b */
    public int mo3840b(int i) {
        AppMethodBeat.m2504i(66972);
        if (1.0f != this.f1095E) {
            GLES20.glViewport(0, 0, this.f1098H, this.f1099I);
        }
        int b = this.f1102t.mo43384b(this.f1101s.mo3840b(i), i);
        if (1.0f != this.f1095E) {
            GLES20.glViewport(0, 0, this.f1096F, this.f1097G);
        }
        if (this.f1094D > 0.7f) {
            b = this.f1104v.mo3840b(b);
        }
        b = this.f1105w.mo43384b(b, i);
        AppMethodBeat.m2505o(66972);
        return b;
    }

    /* renamed from: c */
    private boolean m2163c(int i, int i2) {
        AppMethodBeat.m2504i(66973);
        this.f1096F = i;
        this.f1097G = i2;
        this.f1098H = i;
        this.f1099I = i2;
        if (1.0f != this.f1095E) {
            this.f1098H = (int) (((float) this.f1098H) / this.f1095E);
            this.f1099I = (int) (((float) this.f1099I) / this.f1095E);
        }
        TXCLog.m15677i(this.f1106x, "mResampleRatio " + this.f1095E + " mResampleWidth " + this.f1098H + " mResampleHeight " + this.f1099I);
        if (this.f1105w == null) {
            this.f1105w = new C32150b();
            this.f1105w.mo19873a(true);
            if (!this.f1105w.mo19876a()) {
                TXCLog.m15676e(this.f1106x, "mBeautyBlendFilter init failed!!, break init");
                AppMethodBeat.m2505o(66973);
                return false;
            }
        }
        this.f1105w.mo3839a(i, i2);
        if (this.f1101s == null) {
            this.f1101s = new C45105d();
            this.f1101s.mo19873a(true);
            if (!this.f1101s.mo19876a()) {
                TXCLog.m15676e(this.f1106x, "m_horizontalFilter init failed!!, break init");
                AppMethodBeat.m2505o(66973);
                return false;
            }
        }
        this.f1101s.mo3839a(this.f1098H, this.f1099I);
        if (this.f1102t == null) {
            boolean z;
            this.f1102t = new C37358e();
            this.f1102t.mo19873a(true);
            if (1.0f == this.f1095E) {
                z = false;
            } else {
                z = true;
            }
            this.f1102t.mo19880b(z);
            if (!this.f1102t.mo19876a()) {
                TXCLog.m15676e(this.f1106x, "m_verticalFilter init failed!!, break init");
                AppMethodBeat.m2505o(66973);
                return false;
            }
        }
        this.f1102t.mo3839a(this.f1098H, this.f1099I);
        if (this.f1103u == null) {
            this.f1103u = new C32155h(1.0f);
            this.f1103u.mo19873a(true);
            if (!this.f1103u.mo19876a()) {
                TXCLog.m15676e(this.f1106x, "m_gammaFilter init failed!!, break init");
                AppMethodBeat.m2505o(66973);
                return false;
            }
        }
        this.f1103u.mo3839a(this.f1098H, this.f1099I);
        if (this.f1104v == null) {
            this.f1104v = new C37360o();
            this.f1104v.mo19873a(true);
            if (!this.f1104v.mo19876a()) {
                TXCLog.m15676e(this.f1106x, "mSharpenFilter init failed!!, break init");
                AppMethodBeat.m2505o(66973);
                return false;
            }
        }
        this.f1104v.mo3839a(i, i2);
        AppMethodBeat.m2505o(66973);
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: q */
    public void mo3847q() {
        AppMethodBeat.m2504i(66974);
        if (this.f1105w != null) {
            this.f1105w.mo19883d();
            this.f1105w = null;
        }
        if (this.f1101s != null) {
            this.f1101s.mo19883d();
            this.f1101s = null;
        }
        if (this.f1102t != null) {
            this.f1102t.mo19883d();
            this.f1102t = null;
        }
        if (this.f1103u != null) {
            this.f1103u.mo19883d();
            this.f1103u = null;
        }
        if (this.f1104v != null) {
            this.f1104v.mo19883d();
            this.f1104v = null;
        }
        AppMethodBeat.m2505o(66974);
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(66975);
        super.mo3844e();
        mo3847q();
        AppMethodBeat.m2505o(66975);
    }
}
