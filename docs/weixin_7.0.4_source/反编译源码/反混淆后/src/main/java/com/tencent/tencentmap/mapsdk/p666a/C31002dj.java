package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dj */
public final class C31002dj implements C36472cv {
    /* renamed from: a */
    private C16192dk f13977a = null;
    /* renamed from: b */
    private String f13978b = "";
    /* renamed from: c */
    private C46753ba f13979c = null;

    public C31002dj(C16192dk c16192dk, C46753ba c46753ba, String str) {
        this.f13978b = str;
        this.f13977a = c16192dk;
        this.f13979c = c46753ba;
    }

    /* renamed from: b */
    public final void mo50200b() {
        AppMethodBeat.m2504i(101037);
        if (this.f13979c == null) {
            AppMethodBeat.m2505o(101037);
            return;
        }
        this.f13979c.mo75297a(this.f13978b);
        AppMethodBeat.m2505o(101037);
    }

    /* renamed from: c */
    public final String mo50202c() {
        return this.f13978b;
    }

    /* renamed from: a */
    public final void mo50197a(List<C24343db> list) {
        AppMethodBeat.m2504i(101038);
        if (this.f13979c == null) {
            AppMethodBeat.m2505o(101038);
            return;
        }
        this.f13979c.mo75300a(this.f13978b, (List) list);
        this.f13977a.mo29145a((Iterable) list);
        AppMethodBeat.m2505o(101038);
    }

    /* renamed from: d */
    public final List<C24343db> mo50204d() {
        AppMethodBeat.m2504i(101039);
        List a = this.f13977a.mo29144a();
        AppMethodBeat.m2505o(101039);
        return a;
    }

    /* renamed from: a */
    public final void mo50195a(float f) {
        AppMethodBeat.m2504i(101040);
        this.f13979c.mo75298a(this.f13978b, f);
        this.f13977a.mo29141a(f);
        AppMethodBeat.m2505o(101040);
    }

    /* renamed from: e */
    public final float mo50206e() {
        AppMethodBeat.m2504i(101041);
        float b = this.f13977a.mo29146b();
        AppMethodBeat.m2505o(101041);
        return b;
    }

    /* renamed from: a */
    public final void mo50196a(int i) {
        AppMethodBeat.m2504i(101042);
        this.f13979c.mo75305b(this.f13978b, i);
        this.f13977a.mo29142a(i);
        AppMethodBeat.m2505o(101042);
    }

    /* renamed from: f */
    public final int mo50208f() {
        AppMethodBeat.m2504i(101043);
        int c = this.f13977a.mo29149c();
        AppMethodBeat.m2505o(101043);
        return c;
    }

    /* renamed from: b */
    public final void mo50201b(int i) {
        AppMethodBeat.m2504i(101044);
        this.f13979c.mo75299a(this.f13978b, i);
        this.f13977a.mo29147b(i);
        AppMethodBeat.m2505o(101044);
    }

    /* renamed from: g */
    public final int mo50209g() {
        AppMethodBeat.m2504i(101045);
        int d = this.f13977a.mo29151d();
        AppMethodBeat.m2505o(101045);
        return d;
    }

    /* renamed from: c */
    public final void mo50203c(int i) {
        AppMethodBeat.m2504i(101046);
        this.f13979c.mo75304b(this.f13978b, (float) i);
        this.f13977a.mo29150c(i);
        AppMethodBeat.m2505o(101046);
    }

    /* renamed from: h */
    public final float mo50210h() {
        AppMethodBeat.m2504i(101047);
        float e = this.f13977a.mo29153e();
        AppMethodBeat.m2505o(101047);
        return e;
    }

    /* renamed from: a */
    public final void mo50198a(boolean z) {
        AppMethodBeat.m2504i(101048);
        this.f13979c.mo75301a(this.f13978b, z);
        this.f13977a.mo29143a(z);
        AppMethodBeat.m2505o(101048);
    }

    /* renamed from: i */
    public final boolean mo50212i() {
        AppMethodBeat.m2504i(101049);
        boolean f = this.f13977a.mo29154f();
        AppMethodBeat.m2505o(101049);
        return f;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(101050);
        if (obj instanceof C31002dj) {
            boolean equals = this.f13978b.equals(((C31002dj) obj).f13978b);
            AppMethodBeat.m2505o(101050);
            return equals;
        }
        AppMethodBeat.m2505o(101050);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(101051);
        int hashCode = this.f13978b.hashCode();
        AppMethodBeat.m2505o(101051);
        return hashCode;
    }

    /* renamed from: a */
    public final boolean mo50199a(C24343db c24343db) {
        AppMethodBeat.m2504i(101052);
        List d = mo50204d();
        if (d == null || d.size() < 3 || c24343db == null) {
            AppMethodBeat.m2505o(101052);
            return false;
        }
        int size = d.size() - 1;
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= d.size()) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 < d.size()) {
                        if (((((C24343db) d.get(i2)).f4615a < c24343db.f4615a && ((C24343db) d.get(size)).f4615a >= c24343db.f4615a) || (((C24343db) d.get(size)).f4615a < c24343db.f4615a && ((C24343db) d.get(i2)).f4615a >= c24343db.f4615a)) && (((C24343db) d.get(i2)).f4616b <= c24343db.f4616b || ((C24343db) d.get(size)).f4616b <= c24343db.f4616b)) {
                            if (((C24343db) d.get(i2)).f4616b + (((c24343db.f4615a - ((C24343db) d.get(i2)).f4615a) / (((C24343db) d.get(size)).f4615a - ((C24343db) d.get(i2)).f4615a)) * (((C24343db) d.get(size)).f4616b - ((C24343db) d.get(i2)).f4616b)) <= c24343db.f4616b) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            z ^= i;
                        }
                        i = i2 + 1;
                        size = i2;
                    } else {
                        AppMethodBeat.m2505o(101052);
                        return z;
                    }
                }
            } else if (((C24343db) d.get(i2)).equals(c24343db)) {
                AppMethodBeat.m2505o(101052);
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    /* renamed from: a */
    public final List<C41717j> mo12330a() {
        AppMethodBeat.m2504i(101053);
        if (this.f13979c != null) {
            List b = this.f13979c.mo75302b(this.f13978b);
            AppMethodBeat.m2505o(101053);
            return b;
        }
        AppMethodBeat.m2505o(101053);
        return null;
    }

    /* renamed from: j */
    public final int mo50213j() {
        AppMethodBeat.m2504i(101054);
        int h = this.f13977a.mo29156h();
        AppMethodBeat.m2505o(101054);
        return h;
    }

    /* renamed from: d */
    public final void mo50205d(int i) {
        AppMethodBeat.m2504i(101055);
        if (i < C24347di.f4621a || i > C24347di.f4623c) {
            AppMethodBeat.m2505o(101055);
            return;
        }
        this.f13979c.mo75306c(this.f13978b, i);
        this.f13977a.mo29152d(i);
        AppMethodBeat.m2505o(101055);
    }
}
