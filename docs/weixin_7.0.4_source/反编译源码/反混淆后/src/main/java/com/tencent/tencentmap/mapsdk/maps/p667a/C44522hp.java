package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hp */
public final class C44522hp extends C46803m {
    /* renamed from: a */
    public String f17436a = "";
    /* renamed from: b */
    public int f17437b = 0;
    /* renamed from: c */
    public String f17438c = "";

    public C44522hp(String str, int i, String str2) {
        this.f17436a = str;
        this.f17437b = i;
        this.f17438c = str2;
    }

    public final void writeTo(C24398l c24398l) {
        AppMethodBeat.m2504i(99565);
        c24398l.mo40672a(this.f17436a, 0);
        c24398l.mo40668a(this.f17437b, 1);
        if (this.f17438c != null) {
            c24398l.mo40672a(this.f17438c, 2);
        }
        AppMethodBeat.m2505o(99565);
    }

    public final void readFrom(C31070k c31070k) {
        AppMethodBeat.m2504i(99566);
        this.f17436a = c31070k.mo50508a(0, true);
        this.f17437b = c31070k.mo50503a(this.f17437b, 1, true);
        this.f17438c = c31070k.mo50508a(2, false);
        AppMethodBeat.m2505o(99566);
    }
}
