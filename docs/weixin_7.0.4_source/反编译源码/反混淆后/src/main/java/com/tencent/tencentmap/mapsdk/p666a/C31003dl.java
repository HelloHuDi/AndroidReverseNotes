package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dl */
public final class C31003dl implements C36472cv {
    /* renamed from: a */
    private C31004dm f13980a = null;
    /* renamed from: b */
    private String f13981b = "";
    /* renamed from: c */
    private C16185bc f13982c = null;

    public C31003dl(C31004dm c31004dm, C16185bc c16185bc, String str) {
        this.f13981b = str;
        this.f13980a = c31004dm;
        this.f13982c = c16185bc;
    }

    /* renamed from: b */
    public final void mo50220b() {
        AppMethodBeat.m2504i(101059);
        if (this.f13982c == null) {
            AppMethodBeat.m2505o(101059);
            return;
        }
        this.f13982c.mo29076a(this.f13981b);
        AppMethodBeat.m2505o(101059);
    }

    /* renamed from: c */
    public final String mo50223c() {
        return this.f13981b;
    }

    /* renamed from: a */
    public final void mo50218a(List<C24343db> list) {
        AppMethodBeat.m2504i(101060);
        this.f13982c.mo29081a(this.f13981b, (List) list);
        this.f13980a.mo50244a((List) list);
        AppMethodBeat.m2505o(101060);
    }

    /* renamed from: d */
    public final List<C24343db> mo50225d() {
        AppMethodBeat.m2504i(101061);
        List e = this.f13980a.mo50257e();
        AppMethodBeat.m2505o(101061);
        return e;
    }

    /* renamed from: a */
    public final void mo50214a(float f) {
        AppMethodBeat.m2504i(101062);
        if (f < 0.0f) {
            f = 1.0f;
        }
        this.f13982c.mo29077a(this.f13981b, f);
        this.f13980a.mo50236a(f);
        AppMethodBeat.m2505o(101062);
    }

    /* renamed from: e */
    public final float mo50226e() {
        AppMethodBeat.m2504i(101063);
        float f = this.f13980a.mo50258f();
        AppMethodBeat.m2505o(101063);
        return f;
    }

    /* renamed from: a */
    public final void mo50215a(int i) {
        AppMethodBeat.m2504i(101064);
        this.f13982c.mo29078a(this.f13981b, i);
        this.f13980a.mo50237a(i);
        AppMethodBeat.m2505o(101064);
    }

    /* renamed from: a */
    public final void mo50217a(C41018cm c41018cm) {
        AppMethodBeat.m2504i(101065);
        this.f13982c.mo29080a(this.f13981b, c41018cm);
        AppMethodBeat.m2505o(101065);
    }

    /* renamed from: f */
    public final int mo50228f() {
        AppMethodBeat.m2504i(101066);
        int g = this.f13980a.mo50260g();
        AppMethodBeat.m2505o(101066);
        return g;
    }

    /* renamed from: b */
    public final void mo50221b(int i) {
        AppMethodBeat.m2504i(101067);
        this.f13982c.mo29085b(this.f13981b, (float) Math.max(0, i));
        this.f13980a.mo50255d(Math.max(0, i));
        AppMethodBeat.m2505o(101067);
    }

    /* renamed from: g */
    public final int mo50229g() {
        AppMethodBeat.m2504i(101068);
        int i = this.f13980a.mo50263i();
        AppMethodBeat.m2505o(101068);
        return i;
    }

    /* renamed from: a */
    public final void mo50219a(boolean z) {
        AppMethodBeat.m2504i(101069);
        this.f13982c.mo29082a(this.f13981b, z);
        this.f13980a.mo50242a(z);
        AppMethodBeat.m2505o(101069);
    }

    /* renamed from: h */
    public final boolean mo50230h() {
        AppMethodBeat.m2504i(101070);
        boolean k = this.f13980a.mo50265k();
        AppMethodBeat.m2505o(101070);
        return k;
    }

    /* renamed from: i */
    public final List<Integer> mo50232i() {
        AppMethodBeat.m2504i(101071);
        List x = this.f13980a.mo50278x();
        AppMethodBeat.m2505o(101071);
        return x;
    }

    /* renamed from: a */
    public final void mo50216a(int i, C24343db c24343db) {
        AppMethodBeat.m2504i(101072);
        this.f13982c.mo29079a(this.f13981b, i, c24343db);
        AppMethodBeat.m2505o(101072);
    }

    /* renamed from: b */
    public final void mo50222b(boolean z) {
        AppMethodBeat.m2504i(101073);
        this.f13982c.mo29087b(this.f13981b, z);
        AppMethodBeat.m2505o(101073);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(101074);
        if (obj instanceof C31003dl) {
            boolean equals = this.f13981b.equals(((C31003dl) obj).f13981b);
            AppMethodBeat.m2505o(101074);
            return equals;
        }
        AppMethodBeat.m2505o(101074);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(101075);
        int hashCode = this.f13981b.hashCode();
        AppMethodBeat.m2505o(101075);
        return hashCode;
    }

    /* renamed from: a */
    public final List<C41717j> mo12330a() {
        AppMethodBeat.m2504i(101076);
        List b = this.f13982c.mo29083b(this.f13981b);
        AppMethodBeat.m2505o(101076);
        return b;
    }

    /* renamed from: j */
    public final boolean mo50233j() {
        AppMethodBeat.m2504i(101077);
        if (this.f13980a != null) {
            boolean w = this.f13980a.mo50277w();
            AppMethodBeat.m2505o(101077);
            return w;
        }
        AppMethodBeat.m2505o(101077);
        return false;
    }

    /* renamed from: k */
    public final int mo50234k() {
        AppMethodBeat.m2504i(101078);
        int t = this.f13980a.mo50274t();
        AppMethodBeat.m2505o(101078);
        return t;
    }

    /* renamed from: c */
    public final void mo50224c(int i) {
        AppMethodBeat.m2504i(101079);
        if (i < C24347di.f4621a || i > C24347di.f4623c) {
            AppMethodBeat.m2505o(101079);
            return;
        }
        this.f13982c.mo29086b(this.f13981b, i);
        this.f13980a.mo50259f(i);
        AppMethodBeat.m2505o(101079);
    }
}
