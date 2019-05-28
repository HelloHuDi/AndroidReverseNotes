package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class brr extends a {
    public String jCg;
    public int qBF;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOz;
    public int wTR;
    public int wTS;
    public String wTT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96283);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jCg != null) {
                aVar.e(1, this.jCg);
            }
            aVar.iz(2, this.wTR);
            if (this.vOz != null) {
                aVar.e(3, this.vOz);
            }
            if (this.vOA != null) {
                aVar.e(4, this.vOA);
            }
            aVar.iz(5, this.qBF);
            aVar.iz(6, this.wTS);
            if (this.vOB != null) {
                aVar.e(7, this.vOB);
            }
            if (this.vOC != null) {
                aVar.e(8, this.vOC);
            }
            if (this.wTT != null) {
                aVar.e(9, this.wTT);
            }
            AppMethodBeat.o(96283);
            return 0;
        } else if (i == 1) {
            if (this.jCg != null) {
                f = e.a.a.b.b.a.f(1, this.jCg) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wTR);
            if (this.vOz != null) {
                f += e.a.a.b.b.a.f(3, this.vOz);
            }
            if (this.vOA != null) {
                f += e.a.a.b.b.a.f(4, this.vOA);
            }
            f = (f + e.a.a.b.b.a.bs(5, this.qBF)) + e.a.a.b.b.a.bs(6, this.wTS);
            if (this.vOB != null) {
                f += e.a.a.b.b.a.f(7, this.vOB);
            }
            if (this.vOC != null) {
                f += e.a.a.b.b.a.f(8, this.vOC);
            }
            if (this.wTT != null) {
                f += e.a.a.b.b.a.f(9, this.wTT);
            }
            AppMethodBeat.o(96283);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96283);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brr brr = (brr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brr.jCg = aVar3.BTU.readString();
                    AppMethodBeat.o(96283);
                    return 0;
                case 2:
                    brr.wTR = aVar3.BTU.vd();
                    AppMethodBeat.o(96283);
                    return 0;
                case 3:
                    brr.vOz = aVar3.BTU.readString();
                    AppMethodBeat.o(96283);
                    return 0;
                case 4:
                    brr.vOA = aVar3.BTU.readString();
                    AppMethodBeat.o(96283);
                    return 0;
                case 5:
                    brr.qBF = aVar3.BTU.vd();
                    AppMethodBeat.o(96283);
                    return 0;
                case 6:
                    brr.wTS = aVar3.BTU.vd();
                    AppMethodBeat.o(96283);
                    return 0;
                case 7:
                    brr.vOB = aVar3.BTU.readString();
                    AppMethodBeat.o(96283);
                    return 0;
                case 8:
                    brr.vOC = aVar3.BTU.readString();
                    AppMethodBeat.o(96283);
                    return 0;
                case 9:
                    brr.wTT = aVar3.BTU.readString();
                    AppMethodBeat.o(96283);
                    return 0;
                default:
                    AppMethodBeat.o(96283);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96283);
            return -1;
        }
    }
}
