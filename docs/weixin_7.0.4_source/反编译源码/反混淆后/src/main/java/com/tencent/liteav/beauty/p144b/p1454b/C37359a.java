package com.tencent.liteav.beauty.p144b.p1454b;

import com.tencent.liteav.beauty.p144b.C16518b;
import com.tencent.liteav.beauty.p144b.C45107p;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.b.a */
public class C37359a extends C16518b {
    /* renamed from: r */
    private C32151b f15899r = null;
    /* renamed from: s */
    private C45107p f15900s = null;
    /* renamed from: t */
    private String f15901t = "TXCBeauty3Filter";
    /* renamed from: u */
    private float f15902u = 0.0f;
    /* renamed from: v */
    private float f15903v = 0.0f;
    /* renamed from: w */
    private float f15904w = 0.0f;
    /* renamed from: x */
    private float f15905x = 0.0f;

    /* renamed from: b */
    public boolean mo3841b(int i, int i2) {
        AppMethodBeat.m2504i(67016);
        boolean c = m62802c(i, i2);
        AppMethodBeat.m2505o(67016);
        return c;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(67017);
        if (this.f2620e == i && this.f2621f == i2) {
            AppMethodBeat.m2505o(67017);
            return;
        }
        this.f2620e = i;
        this.f2621f = i2;
        m62802c(i, i2);
        AppMethodBeat.m2505o(67017);
    }

    /* renamed from: c */
    private boolean m62802c(int i, int i2) {
        AppMethodBeat.m2504i(67018);
        if (this.f15899r == null) {
            this.f15899r = new C32151b();
            this.f15899r.mo19873a(true);
            if (!this.f15899r.mo19876a()) {
                AppMethodBeat.m2505o(67018);
                return false;
            }
        }
        this.f15899r.mo3839a(i, i2);
        if (this.f15900s == null) {
            this.f15900s = new C45107p();
            this.f15900s.mo19873a(true);
            if (!this.f15900s.mo19876a()) {
                AppMethodBeat.m2505o(67018);
                return false;
            }
        }
        this.f15900s.mo3839a(i, i2);
        AppMethodBeat.m2505o(67018);
        return true;
    }

    /* renamed from: b */
    public int mo3840b(int i) {
        AppMethodBeat.m2504i(67019);
        if (this.f15902u > 0.0f || this.f15903v > 0.0f || this.f15904w > 0.0f) {
            i = this.f15899r.mo3840b(i);
        }
        if (this.f15905x > 0.0f) {
            i = this.f15900s.mo3840b(i);
        }
        AppMethodBeat.m2505o(67019);
        return i;
    }

    /* renamed from: c */
    public void mo3842c(int i) {
        AppMethodBeat.m2504i(67020);
        this.f15902u = ((float) i) / 10.0f;
        if (this.f15899r != null) {
            this.f15899r.mo52749a(this.f15902u);
        }
        AppMethodBeat.m2505o(67020);
    }

    /* renamed from: d */
    public void mo3843d(int i) {
        AppMethodBeat.m2504i(67021);
        this.f15903v = ((float) i) / 10.0f;
        if (this.f15899r != null) {
            this.f15899r.mo52750b(this.f15903v);
        }
        AppMethodBeat.m2505o(67021);
    }

    /* renamed from: e */
    public void mo3845e(int i) {
        AppMethodBeat.m2504i(67022);
        this.f15904w = ((float) i) / 10.0f;
        if (this.f15899r != null) {
            this.f15899r.mo52752c(this.f15904w);
        }
        AppMethodBeat.m2505o(67022);
    }

    /* renamed from: f */
    public void mo3846f(int i) {
        AppMethodBeat.m2504i(67023);
        this.f15905x = ((float) i) / 20.0f;
        if (this.f15900s != null) {
            this.f15900s.mo72889a(this.f15905x);
        }
        AppMethodBeat.m2505o(67023);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: q */
    public void mo60125q() {
        AppMethodBeat.m2504i(67024);
        if (this.f15899r != null) {
            this.f15899r.mo3844e();
            this.f15899r = null;
        }
        if (this.f15900s != null) {
            this.f15900s.mo3844e();
            this.f15900s = null;
        }
        AppMethodBeat.m2505o(67024);
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(67025);
        super.mo3844e();
        mo60125q();
        AppMethodBeat.m2505o(67025);
    }
}
