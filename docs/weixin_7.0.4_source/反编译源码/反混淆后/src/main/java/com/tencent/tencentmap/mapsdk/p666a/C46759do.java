package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.do */
public final class C46759do {
    /* renamed from: a */
    public final C24343db f18041a;
    /* renamed from: b */
    public final C24343db f18042b;
    /* renamed from: c */
    public final C24343db f18043c;
    /* renamed from: d */
    public final C24343db f18044d;
    /* renamed from: e */
    public final C24345dc f18045e;

    public C46759do(C24343db c24343db, C24343db c24343db2, C24343db c24343db3, C24343db c24343db4, C24345dc c24345dc) {
        this.f18041a = c24343db;
        this.f18042b = c24343db2;
        this.f18043c = c24343db3;
        this.f18044d = c24343db4;
        this.f18045e = c24345dc;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(101090);
        if (this == obj) {
            AppMethodBeat.m2505o(101090);
            return true;
        } else if (obj instanceof C46759do) {
            C46759do c46759do = (C46759do) obj;
            if (this.f18041a.equals(c46759do.f18041a) && this.f18042b.equals(c46759do.f18042b) && this.f18043c.equals(c46759do.f18043c) && this.f18044d.equals(c46759do.f18044d) && this.f18045e.equals(c46759do.f18045e)) {
                AppMethodBeat.m2505o(101090);
                return true;
            }
            AppMethodBeat.m2505o(101090);
            return false;
        } else {
            AppMethodBeat.m2505o(101090);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(101091);
        String str = "nearLeft" + this.f18041a + "nearRight" + this.f18042b + "farLeft" + this.f18043c + "farRight" + this.f18044d + "latLngBounds" + this.f18045e;
        AppMethodBeat.m2505o(101091);
        return str;
    }
}
