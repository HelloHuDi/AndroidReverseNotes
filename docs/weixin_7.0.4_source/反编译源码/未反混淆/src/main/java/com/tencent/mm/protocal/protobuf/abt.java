package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class abt extends a {
    public int fileCount;
    public int wiK;
    public int wiL;
    public int wiM;
    public int wiN;
    public int wiO;
    public int wiP;
    public int wiQ;
    public int wiR;
    public int wiS;
    public int wiT;
    public int wiU;
    public int wiV;
    public int wiW;
    public int wiX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51423);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wiK);
            aVar.iz(2, this.wiL);
            aVar.iz(3, this.wiM);
            aVar.iz(4, this.wiN);
            aVar.iz(5, this.wiO);
            aVar.iz(6, this.wiP);
            aVar.iz(7, this.wiQ);
            aVar.iz(8, this.fileCount);
            aVar.iz(9, this.wiR);
            aVar.iz(10, this.wiS);
            aVar.iz(11, this.wiT);
            aVar.iz(12, this.wiU);
            aVar.iz(13, this.wiV);
            aVar.iz(14, this.wiW);
            aVar.iz(15, this.wiX);
            AppMethodBeat.o(51423);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((((((e.a.a.b.b.a.bs(1, this.wiK) + 0) + e.a.a.b.b.a.bs(2, this.wiL)) + e.a.a.b.b.a.bs(3, this.wiM)) + e.a.a.b.b.a.bs(4, this.wiN)) + e.a.a.b.b.a.bs(5, this.wiO)) + e.a.a.b.b.a.bs(6, this.wiP)) + e.a.a.b.b.a.bs(7, this.wiQ)) + e.a.a.b.b.a.bs(8, this.fileCount)) + e.a.a.b.b.a.bs(9, this.wiR)) + e.a.a.b.b.a.bs(10, this.wiS)) + e.a.a.b.b.a.bs(11, this.wiT)) + e.a.a.b.b.a.bs(12, this.wiU)) + e.a.a.b.b.a.bs(13, this.wiV)) + e.a.a.b.b.a.bs(14, this.wiW)) + e.a.a.b.b.a.bs(15, this.wiX);
            AppMethodBeat.o(51423);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51423);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abt abt = (abt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abt.wiK = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 2:
                    abt.wiL = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 3:
                    abt.wiM = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 4:
                    abt.wiN = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 5:
                    abt.wiO = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 6:
                    abt.wiP = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 7:
                    abt.wiQ = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 8:
                    abt.fileCount = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 9:
                    abt.wiR = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 10:
                    abt.wiS = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 11:
                    abt.wiT = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 12:
                    abt.wiU = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 13:
                    abt.wiV = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 14:
                    abt.wiW = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                case 15:
                    abt.wiX = aVar3.BTU.vd();
                    AppMethodBeat.o(51423);
                    return 0;
                default:
                    AppMethodBeat.o(51423);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51423);
            return -1;
        }
    }
}
