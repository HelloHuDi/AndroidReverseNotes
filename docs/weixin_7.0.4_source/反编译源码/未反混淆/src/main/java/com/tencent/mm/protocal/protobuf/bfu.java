package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bfu extends a {
    public String mZJ;
    public String mZr;
    public int mZx;
    public String ncH;
    public String vDm;
    public String vDo;
    public String vMD;
    public int vMG;
    public String wJA;
    public String wJB;
    public String wJC;
    public String wJD;
    public String wJE;
    public String wJF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80124);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZr != null) {
                aVar.e(1, this.mZr);
            }
            if (this.ncH != null) {
                aVar.e(2, this.ncH);
            }
            if (this.wJA != null) {
                aVar.e(3, this.wJA);
            }
            if (this.vDm != null) {
                aVar.e(4, this.vDm);
            }
            if (this.mZJ != null) {
                aVar.e(5, this.mZJ);
            }
            aVar.iz(6, this.vMG);
            if (this.wJB != null) {
                aVar.e(7, this.wJB);
            }
            if (this.vDo != null) {
                aVar.e(8, this.vDo);
            }
            if (this.vMD != null) {
                aVar.e(9, this.vMD);
            }
            if (this.wJC != null) {
                aVar.e(10, this.wJC);
            }
            if (this.wJD != null) {
                aVar.e(11, this.wJD);
            }
            if (this.wJE != null) {
                aVar.e(12, this.wJE);
            }
            if (this.wJF != null) {
                aVar.e(13, this.wJF);
            }
            aVar.iz(14, this.mZx);
            AppMethodBeat.o(80124);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = e.a.a.b.b.a.f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(2, this.ncH);
            }
            if (this.wJA != null) {
                f += e.a.a.b.b.a.f(3, this.wJA);
            }
            if (this.vDm != null) {
                f += e.a.a.b.b.a.f(4, this.vDm);
            }
            if (this.mZJ != null) {
                f += e.a.a.b.b.a.f(5, this.mZJ);
            }
            f += e.a.a.b.b.a.bs(6, this.vMG);
            if (this.wJB != null) {
                f += e.a.a.b.b.a.f(7, this.wJB);
            }
            if (this.vDo != null) {
                f += e.a.a.b.b.a.f(8, this.vDo);
            }
            if (this.vMD != null) {
                f += e.a.a.b.b.a.f(9, this.vMD);
            }
            if (this.wJC != null) {
                f += e.a.a.b.b.a.f(10, this.wJC);
            }
            if (this.wJD != null) {
                f += e.a.a.b.b.a.f(11, this.wJD);
            }
            if (this.wJE != null) {
                f += e.a.a.b.b.a.f(12, this.wJE);
            }
            if (this.wJF != null) {
                f += e.a.a.b.b.a.f(13, this.wJF);
            }
            int bs = f + e.a.a.b.b.a.bs(14, this.mZx);
            AppMethodBeat.o(80124);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80124);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfu bfu = (bfu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfu.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 2:
                    bfu.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 3:
                    bfu.wJA = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 4:
                    bfu.vDm = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 5:
                    bfu.mZJ = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 6:
                    bfu.vMG = aVar3.BTU.vd();
                    AppMethodBeat.o(80124);
                    return 0;
                case 7:
                    bfu.wJB = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 8:
                    bfu.vDo = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 9:
                    bfu.vMD = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 10:
                    bfu.wJC = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 11:
                    bfu.wJD = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 12:
                    bfu.wJE = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 13:
                    bfu.wJF = aVar3.BTU.readString();
                    AppMethodBeat.o(80124);
                    return 0;
                case 14:
                    bfu.mZx = aVar3.BTU.vd();
                    AppMethodBeat.o(80124);
                    return 0;
                default:
                    AppMethodBeat.o(80124);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80124);
            return -1;
        }
    }
}
