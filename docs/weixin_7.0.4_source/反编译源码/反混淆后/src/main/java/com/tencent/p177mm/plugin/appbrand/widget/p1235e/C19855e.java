package com.tencent.p177mm.plugin.appbrand.widget.p1235e;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.e.e */
public final class C19855e {
    /* renamed from: x */
    public final double f4363x;
    /* renamed from: y */
    public final double f4364y;

    public C19855e(double d, double d2) {
        this.f4363x = d;
        this.f4364y = d2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C19855e) {
            return this.f4363x == ((C19855e) obj).f4363x && this.f4364y == ((C19855e) obj).f4364y;
        } else {
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(51275);
        String str = "Point{x=" + this.f4363x + ", y=" + this.f4364y + '}';
        AppMethodBeat.m2505o(51275);
        return str;
    }
}
