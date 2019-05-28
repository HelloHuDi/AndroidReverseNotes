package com.tencent.map.lib.basemap.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.map.lib.basemap.data.b */
public class C45133b implements Cloneable {
    /* renamed from: a */
    private double f17851a = Double.MIN_VALUE;
    /* renamed from: b */
    private double f17852b = Double.MIN_VALUE;

    public /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(97858);
        C45133b c = mo72956c();
        AppMethodBeat.m2505o(97858);
        return c;
    }

    public String toString() {
        AppMethodBeat.m2504i(97851);
        String str = "x=" + this.f17852b + ",y=" + this.f17851a;
        AppMethodBeat.m2505o(97851);
        return str;
    }

    public C45133b(double d, double d2) {
        AppMethodBeat.m2504i(97852);
        mo72955b(d);
        mo72953a(d2);
        AppMethodBeat.m2505o(97852);
    }

    /* renamed from: a */
    public double mo72952a() {
        return this.f17851a;
    }

    /* renamed from: a */
    public void mo72953a(double d) {
        AppMethodBeat.m2504i(97853);
        this.f17851a = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d));
        AppMethodBeat.m2505o(97853);
    }

    /* renamed from: b */
    public double mo72954b() {
        return this.f17852b;
    }

    /* renamed from: b */
    public void mo72955b(double d) {
        AppMethodBeat.m2504i(97854);
        this.f17852b = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d));
        AppMethodBeat.m2505o(97854);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(97855);
        if (obj == this) {
            AppMethodBeat.m2505o(97855);
            return true;
        } else if (obj.hashCode() != hashCode()) {
            AppMethodBeat.m2505o(97855);
            return false;
        } else if (obj instanceof C45133b) {
            C45133b c45133b = (C45133b) obj;
            if (Double.doubleToLongBits(c45133b.f17852b) == Double.doubleToLongBits(this.f17852b) && Double.doubleToLongBits(c45133b.f17851a) == Double.doubleToLongBits(this.f17851a)) {
                AppMethodBeat.m2505o(97855);
                return true;
            }
            AppMethodBeat.m2505o(97855);
            return false;
        } else {
            AppMethodBeat.m2505o(97855);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(97856);
        long doubleToLongBits = Double.doubleToLongBits(this.f17852b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f17851a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + ((((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32))) + 31) * 31);
        AppMethodBeat.m2505o(97856);
        return i;
    }

    /* renamed from: c */
    public C45133b mo72956c() {
        AppMethodBeat.m2504i(97857);
        C45133b c45133b = new C45133b(this.f17852b, this.f17851a);
        AppMethodBeat.m2505o(97857);
        return c45133b;
    }
}
