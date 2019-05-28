package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fg */
public class C5872fg implements Cloneable {
    /* renamed from: d */
    private static final C36503fi<Integer> f1591d = new C46784fc();
    /* renamed from: e */
    private static final C36503fi<Number> f1592e = new C16221ez();
    /* renamed from: a */
    int f1593a;
    /* renamed from: b */
    Class<?> f1594b;
    /* renamed from: c */
    C16224fe f1595c;
    /* renamed from: f */
    private C36503fi f1596f;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fg$a */
    static class C5874a extends C5872fg {
        /* renamed from: d */
        C46783fa f1597d;

        /* renamed from: a */
        public /* synthetic */ C5872fg mo12430a() {
            AppMethodBeat.m2504i(98888);
            C5874a c = mo12437c();
            AppMethodBeat.m2505o(98888);
            return c;
        }

        public /* synthetic */ Object clone() {
            AppMethodBeat.m2504i(98889);
            C5874a c = mo12437c();
            AppMethodBeat.m2505o(98889);
            return c;
        }

        public C5874a(int i, double... dArr) {
            super(i);
            AppMethodBeat.m2504i(98885);
            mo12432a(dArr);
            AppMethodBeat.m2505o(98885);
        }

        /* renamed from: a */
        public void mo12432a(double... dArr) {
            AppMethodBeat.m2504i(98886);
            super.mo12432a(dArr);
            this.f1597d = (C46783fa) this.f1595c;
            AppMethodBeat.m2505o(98886);
        }

        /* renamed from: c */
        public C5874a mo12437c() {
            AppMethodBeat.m2504i(98887);
            C5874a c5874a = (C5874a) super.mo12430a();
            c5874a.f1597d = (C46783fa) c5874a.f1595c;
            AppMethodBeat.m2505o(98887);
            return c5874a;
        }
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(98897);
        C5872fg a = mo12430a();
        AppMethodBeat.m2505o(98897);
        return a;
    }

    static {
        AppMethodBeat.m2504i(98898);
        AppMethodBeat.m2505o(98898);
    }

    private C5872fg(int i) {
        this.f1595c = null;
        this.f1593a = i;
    }

    /* renamed from: a */
    public static C5872fg m9059a(int i, double... dArr) {
        AppMethodBeat.m2504i(98890);
        C5874a c5874a = new C5874a(i, dArr);
        AppMethodBeat.m2505o(98890);
        return c5874a;
    }

    /* renamed from: a */
    public static C5872fg m9058a(int i, C36503fi<Object> c36503fi, Object... objArr) {
        AppMethodBeat.m2504i(98891);
        C5872fg c5872fg = new C5872fg(i);
        c5872fg.mo12433a(objArr);
        c5872fg.mo12431a((C36503fi) c36503fi);
        AppMethodBeat.m2505o(98891);
        return c5872fg;
    }

    /* renamed from: a */
    public void mo12432a(double... dArr) {
        AppMethodBeat.m2504i(98892);
        this.f1594b = Double.TYPE;
        this.f1595c = C16224fe.m24746a(dArr);
        AppMethodBeat.m2505o(98892);
    }

    /* renamed from: a */
    public void mo12433a(Object... objArr) {
        AppMethodBeat.m2504i(98893);
        this.f1594b = objArr[0].getClass();
        this.f1595c = C16224fe.m24747a(objArr);
        AppMethodBeat.m2505o(98893);
    }

    /* renamed from: a */
    public C5872fg mo12430a() {
        AppMethodBeat.m2504i(98894);
        try {
            C5872fg c5872fg = (C5872fg) super.clone();
            c5872fg.f1593a = this.f1593a;
            c5872fg.f1595c = this.f1595c.mo29280b();
            c5872fg.f1596f = this.f1596f;
            AppMethodBeat.m2505o(98894);
            return c5872fg;
        } catch (CloneNotSupportedException e) {
            AppMethodBeat.m2505o(98894);
            return null;
        }
    }

    /* renamed from: a */
    public void mo12431a(C36503fi c36503fi) {
        AppMethodBeat.m2504i(98895);
        this.f1596f = c36503fi;
        this.f1595c.mo29279a(c36503fi);
        AppMethodBeat.m2505o(98895);
    }

    /* renamed from: b */
    public int mo12434b() {
        return this.f1593a;
    }

    public String toString() {
        AppMethodBeat.m2504i(98896);
        String str = this.f1593a + ": " + this.f1595c.toString();
        AppMethodBeat.m2505o(98896);
        return str;
    }
}
