package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ha */
public class C44516ha implements C31044fv {
    /* renamed from: a */
    private C46789gm f17422a = null;
    /* renamed from: b */
    private C16269gz f17423b = null;
    /* renamed from: c */
    private C24386hf f17424c = null;

    public C44516ha(C46789gm c46789gm, C24386hf c24386hf) {
        this.f17422a = c46789gm;
        this.f17424c = c24386hf;
    }

    /* renamed from: b */
    public void mo70889b() {
        AppMethodBeat.m2504i(99514);
        if (this.f17422a == null) {
            AppMethodBeat.m2505o(99514);
            return;
        }
        this.f17422a.mo12440a().mo58806a((C31044fv) this);
        if (this.f17423b == null) {
            this.f17423b = new C16269gz(this.f17422a, this.f17424c);
        }
        try {
            this.f17423b.start();
            AppMethodBeat.m2505o(99514);
        } catch (Exception e) {
            AppMethodBeat.m2505o(99514);
        }
    }

    /* renamed from: c */
    public void mo70890c() {
        AppMethodBeat.m2504i(99515);
        if (this.f17423b != null) {
            this.f17423b.mo29433a();
        }
        AppMethodBeat.m2505o(99515);
    }

    /* renamed from: d */
    public void mo70891d() {
        AppMethodBeat.m2504i(99516);
        if (this.f17423b != null) {
            this.f17423b.mo29434b();
            mo29059a();
        }
        AppMethodBeat.m2505o(99516);
    }

    /* renamed from: e */
    public void mo70892e() {
        AppMethodBeat.m2504i(99517);
        if (this.f17422a == null) {
            AppMethodBeat.m2505o(99517);
            return;
        }
        this.f17422a.mo12440a().mo58824b((C31044fv) this);
        if (this.f17423b != null) {
            this.f17423b.mo29435c();
            this.f17423b = null;
        }
        AppMethodBeat.m2505o(99517);
    }

    /* renamed from: a */
    public void mo29059a() {
        AppMethodBeat.m2504i(99518);
        if (this.f17423b != null) {
            synchronized (this.f17423b) {
                try {
                    this.f17423b.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99518);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(99518);
    }

    /* renamed from: f */
    public void mo70893f() {
        AppMethodBeat.m2504i(99519);
        mo70892e();
        AppMethodBeat.m2505o(99519);
    }
}
