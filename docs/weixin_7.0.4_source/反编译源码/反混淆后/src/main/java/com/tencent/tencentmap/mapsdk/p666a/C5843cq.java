package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46791id;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.cq */
public final class C5843cq implements C36472cv {
    /* renamed from: a */
    private C5844cr f1470a = null;
    /* renamed from: b */
    private String f1471b = "";
    /* renamed from: c */
    private C41011bp f1472c = null;

    public C5843cq(C5844cr c5844cr, C41011bp c41011bp, String str) {
        this.f1471b = str;
        this.f1470a = c5844cr;
        this.f1472c = c41011bp;
    }

    /* renamed from: a */
    public final boolean mo12335a(C24343db c24343db) {
        AppMethodBeat.m2504i(100955);
        if (C46791id.m88924a(mo12341d(), c24343db) < mo12343e()) {
            AppMethodBeat.m2505o(100955);
            return true;
        }
        AppMethodBeat.m2505o(100955);
        return false;
    }

    /* renamed from: b */
    public final void mo12336b() {
        AppMethodBeat.m2504i(100956);
        if (this.f1472c == null) {
            AppMethodBeat.m2505o(100956);
            return;
        }
        this.f1472c.mo64993a(this.f1471b);
        AppMethodBeat.m2505o(100956);
    }

    /* renamed from: c */
    public final String mo12339c() {
        return this.f1471b;
    }

    /* renamed from: b */
    public final void mo12338b(C24343db c24343db) {
        AppMethodBeat.m2504i(100957);
        if (this.f1472c == null) {
            AppMethodBeat.m2505o(100957);
            return;
        }
        this.f1472c.mo64997a(this.f1471b, c24343db);
        this.f1470a.mo12355a(c24343db);
        AppMethodBeat.m2505o(100957);
    }

    /* renamed from: d */
    public final C24343db mo12341d() {
        AppMethodBeat.m2504i(100958);
        C24343db c24343db = new C24343db(this.f1470a.mo12357a().f4615a, this.f1470a.mo12357a().f4616b);
        AppMethodBeat.m2505o(100958);
        return c24343db;
    }

    /* renamed from: a */
    public final void mo12331a(double d) {
        AppMethodBeat.m2504i(100959);
        if (d < 0.0d) {
            AppMethodBeat.m2505o(100959);
        } else if (this.f1472c == null) {
            AppMethodBeat.m2505o(100959);
        } else {
            this.f1472c.mo64994a(this.f1471b, d);
            this.f1470a.mo12352a(d);
            AppMethodBeat.m2505o(100959);
        }
    }

    /* renamed from: e */
    public final double mo12343e() {
        AppMethodBeat.m2504i(100960);
        double b = this.f1470a.mo12358b();
        AppMethodBeat.m2505o(100960);
        return b;
    }

    /* renamed from: a */
    public final void mo12332a(float f) {
        AppMethodBeat.m2504i(100961);
        if (f < 0.0f) {
            AppMethodBeat.m2505o(100961);
            return;
        }
        this.f1472c.mo64995a(this.f1471b, f);
        this.f1470a.mo12353a(f);
        AppMethodBeat.m2505o(100961);
    }

    /* renamed from: f */
    public final float mo12345f() {
        AppMethodBeat.m2504i(100962);
        float c = this.f1470a.mo12360c();
        AppMethodBeat.m2505o(100962);
        return c;
    }

    /* renamed from: a */
    public final void mo12333a(int i) {
        AppMethodBeat.m2504i(100963);
        this.f1472c.mo65002b(this.f1471b, i);
        this.f1470a.mo12354a(i);
        AppMethodBeat.m2505o(100963);
    }

    /* renamed from: g */
    public final int mo12346g() {
        AppMethodBeat.m2504i(100964);
        int d = this.f1470a.mo12362d();
        AppMethodBeat.m2505o(100964);
        return d;
    }

    /* renamed from: b */
    public final void mo12337b(int i) {
        AppMethodBeat.m2504i(100965);
        this.f1472c.mo64996a(this.f1471b, i);
        this.f1470a.mo12359b(i);
        AppMethodBeat.m2505o(100965);
    }

    /* renamed from: h */
    public final int mo12347h() {
        AppMethodBeat.m2504i(100966);
        int e = this.f1470a.mo12364e();
        AppMethodBeat.m2505o(100966);
        return e;
    }

    /* renamed from: c */
    public final void mo12340c(int i) {
        AppMethodBeat.m2504i(100967);
        this.f1472c.mo65001b(this.f1471b, (float) i);
        this.f1470a.mo12361c(i);
        AppMethodBeat.m2505o(100967);
    }

    /* renamed from: i */
    public final float mo12349i() {
        AppMethodBeat.m2504i(100968);
        float f = (float) this.f1470a.mo12365f();
        AppMethodBeat.m2505o(100968);
        return f;
    }

    /* renamed from: a */
    public final void mo12334a(boolean z) {
        AppMethodBeat.m2504i(100969);
        this.f1472c.mo64998a(this.f1471b, z);
        this.f1470a.mo12356a(z);
        AppMethodBeat.m2505o(100969);
    }

    /* renamed from: j */
    public final boolean mo12350j() {
        AppMethodBeat.m2504i(100970);
        boolean g = this.f1470a.mo12366g();
        AppMethodBeat.m2505o(100970);
        return g;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(100971);
        if (obj instanceof C5843cq) {
            boolean equals = this.f1471b.equals(((C5843cq) obj).f1471b);
            AppMethodBeat.m2505o(100971);
            return equals;
        }
        AppMethodBeat.m2505o(100971);
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    /* renamed from: a */
    public final List<C41717j> mo12330a() {
        AppMethodBeat.m2504i(100972);
        if (this.f1472c != null) {
            List b = this.f1472c.mo64999b(this.f1471b);
            AppMethodBeat.m2505o(100972);
            return b;
        }
        AppMethodBeat.m2505o(100972);
        return null;
    }

    /* renamed from: k */
    public final int mo12351k() {
        AppMethodBeat.m2504i(100973);
        int h = this.f1470a.mo12367h();
        AppMethodBeat.m2505o(100973);
        return h;
    }

    /* renamed from: d */
    public final void mo12342d(int i) {
        AppMethodBeat.m2504i(100974);
        if (i < C24347di.f4621a || i > C24347di.f4623c) {
            AppMethodBeat.m2505o(100974);
            return;
        }
        this.f1472c.mo65003c(this.f1471b, i);
        this.f1470a.mo12363d(i);
        AppMethodBeat.m2505o(100974);
    }
}
