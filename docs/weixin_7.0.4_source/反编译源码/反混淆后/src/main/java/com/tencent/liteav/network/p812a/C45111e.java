package com.tencent.liteav.network.p812a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.network.a.e */
public final class C45111e {
    /* renamed from: a */
    public final String f17796a;
    /* renamed from: b */
    public final int f17797b;
    /* renamed from: c */
    public final int f17798c;
    /* renamed from: d */
    public final long f17799d;

    public C45111e(String str, int i, int i2, long j) {
        AppMethodBeat.m2504i(67651);
        this.f17796a = str;
        this.f17797b = i;
        if (i2 < 600) {
            i2 = 600;
        }
        this.f17798c = i2;
        this.f17799d = j;
        AppMethodBeat.m2505o(67651);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(67652);
        if (this == obj) {
            AppMethodBeat.m2505o(67652);
            return true;
        } else if (obj == null || !(obj instanceof C45111e)) {
            AppMethodBeat.m2505o(67652);
            return false;
        } else {
            C45111e c45111e = (C45111e) obj;
            if (this.f17796a.equals(c45111e.f17796a) && this.f17797b == c45111e.f17797b && this.f17798c == c45111e.f17798c && this.f17799d == c45111e.f17799d) {
                AppMethodBeat.m2505o(67652);
                return true;
            }
            AppMethodBeat.m2505o(67652);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo72895a() {
        return this.f17797b == 5;
    }
}
