package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ff */
public final class C16225ff extends C36506fj {
    /* renamed from: b */
    int f3217b;

    /* renamed from: a */
    public final /* synthetic */ C46782ey mo29283a() {
        AppMethodBeat.m2504i(98883);
        C16225ff b = mo29287b();
        AppMethodBeat.m2505o(98883);
        return b;
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(98884);
        C16225ff b = mo29287b();
        AppMethodBeat.m2505o(98884);
        return b;
    }

    /* renamed from: a */
    public final void mo29284a(int i) {
        AppMethodBeat.m2504i(98875);
        if (this.f15352e != null) {
            C5872fg c5872fg = this.f15352e[0];
            this.f15353f.remove(Integer.valueOf(c5872fg.mo12434b()));
            this.f15353f.put(Integer.valueOf(i), c5872fg);
        }
        this.f3217b = i;
        AppMethodBeat.m2505o(98875);
    }

    private C16225ff(C41047ex c41047ex, int i) {
        super(c41047ex);
        AppMethodBeat.m2504i(98876);
        mo29284a(i);
        AppMethodBeat.m2505o(98876);
    }

    /* renamed from: a */
    public static C16225ff m24751a(C41047ex c41047ex, int i, double... dArr) {
        AppMethodBeat.m2504i(98877);
        C16225ff c16225ff = new C16225ff(c41047ex, i);
        c16225ff.mo29285a(dArr);
        AppMethodBeat.m2505o(98877);
        return c16225ff;
    }

    /* renamed from: a */
    public static C16225ff m24750a(C41047ex c41047ex, int i, C36503fi c36503fi, Object... objArr) {
        AppMethodBeat.m2504i(98878);
        C16225ff c16225ff = new C16225ff(c41047ex, i);
        c16225ff.mo29286a(objArr);
        c16225ff.mo57730a(c36503fi);
        AppMethodBeat.m2505o(98878);
        return c16225ff;
    }

    /* renamed from: a */
    public final void mo29285a(double... dArr) {
        AppMethodBeat.m2504i(98879);
        if (this.f15352e == null || this.f15352e.length == 0) {
            mo57731a(C5872fg.m9059a(this.f3217b, dArr));
            AppMethodBeat.m2505o(98879);
            return;
        }
        super.mo29285a(dArr);
        AppMethodBeat.m2505o(98879);
    }

    /* renamed from: a */
    public final void mo29286a(Object... objArr) {
        AppMethodBeat.m2504i(98880);
        if (this.f15352e == null || this.f15352e.length == 0) {
            mo57731a(C5872fg.m9058a(this.f3217b, null, objArr));
            AppMethodBeat.m2505o(98880);
            return;
        }
        super.mo29286a(objArr);
        AppMethodBeat.m2505o(98880);
    }

    /* renamed from: b */
    public final C16225ff mo29287b() {
        AppMethodBeat.m2504i(98881);
        C16225ff c16225ff = (C16225ff) super.mo29283a();
        AppMethodBeat.m2505o(98881);
        return c16225ff;
    }

    public final String toString() {
        AppMethodBeat.m2504i(98882);
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f15354g;
        if (this.f15352e != null) {
            for (C5872fg c5872fg : this.f15352e) {
                str = str + "\n    " + c5872fg.toString();
            }
        }
        AppMethodBeat.m2505o(98882);
        return str;
    }
}
