package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class jx extends a {
    public String Name;
    public String fKh;
    public int mZx;
    public String vDo;
    public String vDp;
    public String vEA;
    public String vMA;
    public String vMB;
    public String vMC;
    public String vMD;
    public String vME;
    public String vMF;
    public int vMG;
    public int vMH;
    public String vMI;
    public String vMJ;
    public String vMK;
    public long vML;
    public String vMv;
    public String vMw;
    public String vMx;
    public String vMy;
    public String vMz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80028);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fKh != null) {
                aVar.e(1, this.fKh);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            if (this.vEA != null) {
                aVar.e(3, this.vEA);
            }
            if (this.vMv != null) {
                aVar.e(4, this.vMv);
            }
            if (this.vMw != null) {
                aVar.e(5, this.vMw);
            }
            if (this.vMx != null) {
                aVar.e(6, this.vMx);
            }
            if (this.vMy != null) {
                aVar.e(7, this.vMy);
            }
            if (this.vMz != null) {
                aVar.e(8, this.vMz);
            }
            if (this.vMA != null) {
                aVar.e(9, this.vMA);
            }
            if (this.vMB != null) {
                aVar.e(10, this.vMB);
            }
            if (this.vMC != null) {
                aVar.e(11, this.vMC);
            }
            if (this.vDo != null) {
                aVar.e(12, this.vDo);
            }
            if (this.vMD != null) {
                aVar.e(13, this.vMD);
            }
            if (this.vME != null) {
                aVar.e(14, this.vME);
            }
            if (this.vMF != null) {
                aVar.e(15, this.vMF);
            }
            aVar.iz(16, this.mZx);
            aVar.iz(17, this.vMG);
            aVar.iz(18, this.vMH);
            if (this.vMI != null) {
                aVar.e(19, this.vMI);
            }
            if (this.vMJ != null) {
                aVar.e(20, this.vMJ);
            }
            if (this.vMK != null) {
                aVar.e(21, this.vMK);
            }
            if (this.vDp != null) {
                aVar.e(22, this.vDp);
            }
            aVar.ai(23, this.vML);
            AppMethodBeat.o(80028);
            return 0;
        } else if (i == 1) {
            if (this.fKh != null) {
                f = e.a.a.b.b.a.f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.Name != null) {
                f += e.a.a.b.b.a.f(2, this.Name);
            }
            if (this.vEA != null) {
                f += e.a.a.b.b.a.f(3, this.vEA);
            }
            if (this.vMv != null) {
                f += e.a.a.b.b.a.f(4, this.vMv);
            }
            if (this.vMw != null) {
                f += e.a.a.b.b.a.f(5, this.vMw);
            }
            if (this.vMx != null) {
                f += e.a.a.b.b.a.f(6, this.vMx);
            }
            if (this.vMy != null) {
                f += e.a.a.b.b.a.f(7, this.vMy);
            }
            if (this.vMz != null) {
                f += e.a.a.b.b.a.f(8, this.vMz);
            }
            if (this.vMA != null) {
                f += e.a.a.b.b.a.f(9, this.vMA);
            }
            if (this.vMB != null) {
                f += e.a.a.b.b.a.f(10, this.vMB);
            }
            if (this.vMC != null) {
                f += e.a.a.b.b.a.f(11, this.vMC);
            }
            if (this.vDo != null) {
                f += e.a.a.b.b.a.f(12, this.vDo);
            }
            if (this.vMD != null) {
                f += e.a.a.b.b.a.f(13, this.vMD);
            }
            if (this.vME != null) {
                f += e.a.a.b.b.a.f(14, this.vME);
            }
            if (this.vMF != null) {
                f += e.a.a.b.b.a.f(15, this.vMF);
            }
            f = ((f + e.a.a.b.b.a.bs(16, this.mZx)) + e.a.a.b.b.a.bs(17, this.vMG)) + e.a.a.b.b.a.bs(18, this.vMH);
            if (this.vMI != null) {
                f += e.a.a.b.b.a.f(19, this.vMI);
            }
            if (this.vMJ != null) {
                f += e.a.a.b.b.a.f(20, this.vMJ);
            }
            if (this.vMK != null) {
                f += e.a.a.b.b.a.f(21, this.vMK);
            }
            if (this.vDp != null) {
                f += e.a.a.b.b.a.f(22, this.vDp);
            }
            int o = f + e.a.a.b.b.a.o(23, this.vML);
            AppMethodBeat.o(80028);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80028);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jx jxVar = (jx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jxVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 2:
                    jxVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 3:
                    jxVar.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 4:
                    jxVar.vMv = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 5:
                    jxVar.vMw = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 6:
                    jxVar.vMx = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 7:
                    jxVar.vMy = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 8:
                    jxVar.vMz = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 9:
                    jxVar.vMA = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 10:
                    jxVar.vMB = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 11:
                    jxVar.vMC = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 12:
                    jxVar.vDo = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 13:
                    jxVar.vMD = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 14:
                    jxVar.vME = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 15:
                    jxVar.vMF = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 16:
                    jxVar.mZx = aVar3.BTU.vd();
                    AppMethodBeat.o(80028);
                    return 0;
                case 17:
                    jxVar.vMG = aVar3.BTU.vd();
                    AppMethodBeat.o(80028);
                    return 0;
                case 18:
                    jxVar.vMH = aVar3.BTU.vd();
                    AppMethodBeat.o(80028);
                    return 0;
                case 19:
                    jxVar.vMI = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 20:
                    jxVar.vMJ = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 21:
                    jxVar.vMK = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 22:
                    jxVar.vDp = aVar3.BTU.readString();
                    AppMethodBeat.o(80028);
                    return 0;
                case 23:
                    jxVar.vML = aVar3.BTU.ve();
                    AppMethodBeat.o(80028);
                    return 0;
                default:
                    AppMethodBeat.o(80028);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80028);
            return -1;
        }
    }
}
