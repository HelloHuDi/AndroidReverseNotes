package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cat extends a {
    public int jCt;
    public String ncM;
    public int pcX;
    public int vFH;
    public String vHl;
    public String wCW;
    public int wGu;
    public int wZF;
    public int wZG;
    public int wZH;
    public long wZI;
    public long wZJ;
    public int wZL;
    public String xaa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94570);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHl != null) {
                aVar.e(1, this.vHl);
            }
            if (this.wCW != null) {
                aVar.e(2, this.wCW);
            }
            aVar.iz(3, this.vFH);
            aVar.iz(4, this.jCt);
            if (this.ncM != null) {
                aVar.e(5, this.ncM);
            }
            aVar.iz(6, this.pcX);
            aVar.iz(7, this.wZG);
            aVar.iz(8, this.wZF);
            if (this.xaa != null) {
                aVar.e(9, this.xaa);
            }
            aVar.iz(10, this.wZH);
            aVar.ai(11, this.wZI);
            aVar.ai(12, this.wZJ);
            aVar.iz(13, this.wGu);
            aVar.iz(14, this.wZL);
            AppMethodBeat.o(94570);
            return 0;
        } else if (i == 1) {
            if (this.vHl != null) {
                f = e.a.a.b.b.a.f(1, this.vHl) + 0;
            } else {
                f = 0;
            }
            if (this.wCW != null) {
                f += e.a.a.b.b.a.f(2, this.wCW);
            }
            f = (f + e.a.a.b.b.a.bs(3, this.vFH)) + e.a.a.b.b.a.bs(4, this.jCt);
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(5, this.ncM);
            }
            f = ((f + e.a.a.b.b.a.bs(6, this.pcX)) + e.a.a.b.b.a.bs(7, this.wZG)) + e.a.a.b.b.a.bs(8, this.wZF);
            if (this.xaa != null) {
                f += e.a.a.b.b.a.f(9, this.xaa);
            }
            int bs = ((((f + e.a.a.b.b.a.bs(10, this.wZH)) + e.a.a.b.b.a.o(11, this.wZI)) + e.a.a.b.b.a.o(12, this.wZJ)) + e.a.a.b.b.a.bs(13, this.wGu)) + e.a.a.b.b.a.bs(14, this.wZL);
            AppMethodBeat.o(94570);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94570);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cat cat = (cat) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cat.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(94570);
                    return 0;
                case 2:
                    cat.wCW = aVar3.BTU.readString();
                    AppMethodBeat.o(94570);
                    return 0;
                case 3:
                    cat.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(94570);
                    return 0;
                case 4:
                    cat.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(94570);
                    return 0;
                case 5:
                    cat.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(94570);
                    return 0;
                case 6:
                    cat.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(94570);
                    return 0;
                case 7:
                    cat.wZG = aVar3.BTU.vd();
                    AppMethodBeat.o(94570);
                    return 0;
                case 8:
                    cat.wZF = aVar3.BTU.vd();
                    AppMethodBeat.o(94570);
                    return 0;
                case 9:
                    cat.xaa = aVar3.BTU.readString();
                    AppMethodBeat.o(94570);
                    return 0;
                case 10:
                    cat.wZH = aVar3.BTU.vd();
                    AppMethodBeat.o(94570);
                    return 0;
                case 11:
                    cat.wZI = aVar3.BTU.ve();
                    AppMethodBeat.o(94570);
                    return 0;
                case 12:
                    cat.wZJ = aVar3.BTU.ve();
                    AppMethodBeat.o(94570);
                    return 0;
                case 13:
                    cat.wGu = aVar3.BTU.vd();
                    AppMethodBeat.o(94570);
                    return 0;
                case 14:
                    cat.wZL = aVar3.BTU.vd();
                    AppMethodBeat.o(94570);
                    return 0;
                default:
                    AppMethodBeat.o(94570);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94570);
            return -1;
        }
    }
}
