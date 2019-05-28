package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hq */
public final class C46941hq extends C46803m {
    /* renamed from: a */
    public String f18310a = "";
    /* renamed from: b */
    public int f18311b = 0;
    /* renamed from: c */
    public int f18312c = 0;
    /* renamed from: d */
    public int f18313d = 0;
    /* renamed from: e */
    public String f18314e = "";
    /* renamed from: f */
    public String f18315f = "";
    /* renamed from: g */
    public int f18316g = 0;

    public final void writeTo(C24398l c24398l) {
        AppMethodBeat.m2504i(99567);
        c24398l.mo40672a(this.f18310a, 0);
        c24398l.mo40668a(this.f18311b, 1);
        c24398l.mo40668a(this.f18312c, 2);
        c24398l.mo40668a(this.f18313d, 3);
        if (this.f18314e != null) {
            c24398l.mo40672a(this.f18314e, 4);
        }
        if (this.f18315f != null) {
            c24398l.mo40672a(this.f18315f, 5);
        }
        c24398l.mo40668a(this.f18316g, 6);
        AppMethodBeat.m2505o(99567);
    }

    public final void readFrom(C31070k c31070k) {
        AppMethodBeat.m2504i(99568);
        this.f18310a = c31070k.mo50508a(0, true);
        this.f18311b = c31070k.mo50503a(this.f18311b, 1, true);
        this.f18312c = c31070k.mo50503a(this.f18312c, 2, true);
        this.f18313d = c31070k.mo50503a(this.f18313d, 3, false);
        this.f18314e = c31070k.mo50508a(4, false);
        this.f18315f = c31070k.mo50508a(5, false);
        this.f18316g = c31070k.mo50503a(this.f18316g, 6, false);
        AppMethodBeat.m2505o(99568);
    }
}
