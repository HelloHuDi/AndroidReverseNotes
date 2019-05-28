package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class jz {
    public double a;
    public double b;

    public boolean equals(Object obj) {
        AppMethodBeat.i(100154);
        if (this == obj) {
            AppMethodBeat.o(100154);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(100154);
            return false;
        } else {
            jz jzVar = (jz) obj;
            if (Double.compare(jzVar.a, this.a) != 0) {
                AppMethodBeat.o(100154);
                return false;
            } else if (Double.compare(jzVar.b, this.b) != 0) {
                AppMethodBeat.o(100154);
                return false;
            } else {
                AppMethodBeat.o(100154);
                return true;
            }
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        long j = 0;
        AppMethodBeat.i(100155);
        if (this.a != 0.0d) {
            doubleToLongBits = Double.doubleToLongBits(this.a);
        } else {
            doubleToLongBits = 0;
        }
        doubleToLongBits = (long) (((int) doubleToLongBits) * 31);
        if (this.b != 0.0d) {
            j = Double.doubleToLongBits(this.b);
        }
        int i = (int) (doubleToLongBits + j);
        AppMethodBeat.o(100155);
        return i;
    }

    public String toString() {
        AppMethodBeat.i(100156);
        String str = this.a + "," + this.b;
        AppMethodBeat.o(100156);
        return str;
    }
}
