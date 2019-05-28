package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kb */
public class C41069kb {
    /* renamed from: a */
    private DoublePoint f16526a;
    /* renamed from: b */
    private double f16527b;

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(100196);
        if ((obj instanceof C41069kb) && ((C41069kb) obj).f16526a.equals(this.f16526a)) {
            AppMethodBeat.m2505o(100196);
            return true;
        }
        AppMethodBeat.m2505o(100196);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(100197);
        int hashCode = this.f16526a.hashCode();
        AppMethodBeat.m2505o(100197);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.m2504i(100198);
        String str = "x:" + this.f16526a.f2800x + ", y:" + this.f16526a.f2801y;
        AppMethodBeat.m2505o(100198);
        return str;
    }

    public C41069kb(C44529jz c44529jz, double d) {
        AppMethodBeat.m2504i(100199);
        this.f16526a = new DoublePoint(c44529jz.f17473a, c44529jz.f17474b);
        this.f16527b = d;
        AppMethodBeat.m2505o(100199);
    }

    /* renamed from: a */
    public DoublePoint mo65154a() {
        return this.f16526a;
    }

    /* renamed from: b */
    public double mo65156b() {
        return this.f16527b;
    }

    /* renamed from: a */
    public void mo65155a(double d) {
        this.f16527b = d;
    }
}
