package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ef extends a {
    public String Url;
    public String ncM;
    public int ptD;
    public int vFU = 600;
    public String vFV;
    public int vFW;
    public boolean vFX;
    public int vFY;
    public int vFZ;
    public int vGa;
    public int vGb;
    public int vGc = -1;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14689);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            if (this.ncM != null) {
                aVar.e(2, this.ncM);
            }
            aVar.iz(3, this.vFU);
            if (this.vFV != null) {
                aVar.e(4, this.vFV);
            }
            aVar.iz(5, this.vFW);
            aVar.aO(6, this.vFX);
            aVar.iz(7, this.vFY);
            aVar.iz(8, this.vFZ);
            aVar.iz(9, this.ptD);
            aVar.iz(10, this.vGa);
            aVar.iz(11, this.vGb);
            aVar.iz(12, this.vGc);
            AppMethodBeat.o(14689);
            return 0;
        } else if (i == 1) {
            if (this.Url != null) {
                f = e.a.a.b.b.a.f(1, this.Url) + 0;
            } else {
                f = 0;
            }
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(2, this.ncM);
            }
            f += e.a.a.b.b.a.bs(3, this.vFU);
            if (this.vFV != null) {
                f += e.a.a.b.b.a.f(4, this.vFV);
            }
            int bs = (((((((f + e.a.a.b.b.a.bs(5, this.vFW)) + (e.a.a.b.b.a.fv(6) + 1)) + e.a.a.b.b.a.bs(7, this.vFY)) + e.a.a.b.b.a.bs(8, this.vFZ)) + e.a.a.b.b.a.bs(9, this.ptD)) + e.a.a.b.b.a.bs(10, this.vGa)) + e.a.a.b.b.a.bs(11, this.vGb)) + e.a.a.b.b.a.bs(12, this.vGc);
            AppMethodBeat.o(14689);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14689);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ef efVar = (ef) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    efVar.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(14689);
                    return 0;
                case 2:
                    efVar.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(14689);
                    return 0;
                case 3:
                    efVar.vFU = aVar3.BTU.vd();
                    AppMethodBeat.o(14689);
                    return 0;
                case 4:
                    efVar.vFV = aVar3.BTU.readString();
                    AppMethodBeat.o(14689);
                    return 0;
                case 5:
                    efVar.vFW = aVar3.BTU.vd();
                    AppMethodBeat.o(14689);
                    return 0;
                case 6:
                    efVar.vFX = aVar3.BTU.ehX();
                    AppMethodBeat.o(14689);
                    return 0;
                case 7:
                    efVar.vFY = aVar3.BTU.vd();
                    AppMethodBeat.o(14689);
                    return 0;
                case 8:
                    efVar.vFZ = aVar3.BTU.vd();
                    AppMethodBeat.o(14689);
                    return 0;
                case 9:
                    efVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(14689);
                    return 0;
                case 10:
                    efVar.vGa = aVar3.BTU.vd();
                    AppMethodBeat.o(14689);
                    return 0;
                case 11:
                    efVar.vGb = aVar3.BTU.vd();
                    AppMethodBeat.o(14689);
                    return 0;
                case 12:
                    efVar.vGc = aVar3.BTU.vd();
                    AppMethodBeat.o(14689);
                    return 0;
                default:
                    AppMethodBeat.o(14689);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14689);
            return -1;
        }
    }
}
