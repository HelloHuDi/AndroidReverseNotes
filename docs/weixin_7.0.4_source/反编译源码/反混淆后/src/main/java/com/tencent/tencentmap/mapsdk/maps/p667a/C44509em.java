package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.em */
public final class C44509em implements C31037dq, C31040ek {
    /* renamed from: a */
    private static C44509em f17410a = new C44509em();
    /* renamed from: b */
    private C31040ek f17411b;
    /* renamed from: c */
    private C31037dq f17412c;
    /* renamed from: d */
    private boolean f17413d = false;

    static {
        AppMethodBeat.m2504i(98797);
        AppMethodBeat.m2505o(98797);
    }

    private C44509em() {
    }

    /* renamed from: d */
    public static C44509em m80723d() {
        return f17410a;
    }

    /* renamed from: a */
    public final void mo12414a() {
        AppMethodBeat.m2504i(98791);
        this.f17411b.mo12414a();
        AppMethodBeat.m2505o(98791);
    }

    /* renamed from: a */
    public final void mo12419a(int i) {
        AppMethodBeat.m2504i(98793);
        this.f17411b.mo12419a(i);
        AppMethodBeat.m2505o(98793);
    }

    /* renamed from: a */
    public final void mo12420a(C31037dq c31037dq) {
        this.f17412c = c31037dq;
    }

    /* renamed from: a */
    public final void mo40564a(String str, String str2) {
        AppMethodBeat.m2504i(98796);
        this.f17412c.mo40564a(str, str2);
        AppMethodBeat.m2505o(98796);
    }

    /* renamed from: a */
    public final void mo50366a(String str, byte[] bArr, String str2) {
        AppMethodBeat.m2504i(98795);
        this.f17412c.mo50366a(str, bArr, str2);
        AppMethodBeat.m2505o(98795);
    }

    /* renamed from: b */
    public final void mo12421b() {
        AppMethodBeat.m2504i(98792);
        this.f17411b.mo12421b();
        AppMethodBeat.m2505o(98792);
    }

    /* renamed from: c */
    public final void mo29273c() {
        AppMethodBeat.m2504i(98794);
        this.f17412c.mo29273c();
        AppMethodBeat.m2505o(98794);
    }

    /* renamed from: e */
    public final synchronized void mo12423e() {
        AppMethodBeat.m2504i(98790);
        if (this.f17413d) {
            AppMethodBeat.m2505o(98790);
        } else {
            this.f17411b = C5868ec.m9044c();
            if (this.f17411b != null) {
                this.f17411b.mo12420a(this);
                this.f17411b.mo12423e();
            }
            this.f17413d = true;
            AppMethodBeat.m2505o(98790);
        }
    }
}
