package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jz */
public class C44529jz {
    /* renamed from: a */
    public double f17473a;
    /* renamed from: b */
    public double f17474b;

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(100154);
        if (this == obj) {
            AppMethodBeat.m2505o(100154);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(100154);
            return false;
        } else {
            C44529jz c44529jz = (C44529jz) obj;
            if (Double.compare(c44529jz.f17473a, this.f17473a) != 0) {
                AppMethodBeat.m2505o(100154);
                return false;
            } else if (Double.compare(c44529jz.f17474b, this.f17474b) != 0) {
                AppMethodBeat.m2505o(100154);
                return false;
            } else {
                AppMethodBeat.m2505o(100154);
                return true;
            }
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        long j = 0;
        AppMethodBeat.m2504i(100155);
        if (this.f17473a != 0.0d) {
            doubleToLongBits = Double.doubleToLongBits(this.f17473a);
        } else {
            doubleToLongBits = 0;
        }
        doubleToLongBits = (long) (((int) doubleToLongBits) * 31);
        if (this.f17474b != 0.0d) {
            j = Double.doubleToLongBits(this.f17474b);
        }
        int i = (int) (doubleToLongBits + j);
        AppMethodBeat.m2505o(100155);
        return i;
    }

    public String toString() {
        AppMethodBeat.m2504i(100156);
        String str = this.f17473a + "," + this.f17474b;
        AppMethodBeat.m2505o(100156);
        return str;
    }
}
