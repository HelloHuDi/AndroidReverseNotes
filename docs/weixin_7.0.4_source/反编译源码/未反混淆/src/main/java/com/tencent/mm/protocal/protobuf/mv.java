package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class mv extends a {
    public int vQP;
    public int vQQ;
    public int vQR;
    public int vQS;
    public int vQT;
    public int vQU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58897);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vQP);
            aVar.iz(2, this.vQQ);
            aVar.iz(3, this.vQR);
            aVar.iz(4, this.vQS);
            aVar.iz(5, this.vQT);
            aVar.iz(6, this.vQU);
            AppMethodBeat.o(58897);
            return 0;
        } else if (i == 1) {
            bs = (((((e.a.a.b.b.a.bs(1, this.vQP) + 0) + e.a.a.b.b.a.bs(2, this.vQQ)) + e.a.a.b.b.a.bs(3, this.vQR)) + e.a.a.b.b.a.bs(4, this.vQS)) + e.a.a.b.b.a.bs(5, this.vQT)) + e.a.a.b.b.a.bs(6, this.vQU);
            AppMethodBeat.o(58897);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58897);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mv mvVar = (mv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mvVar.vQP = aVar3.BTU.vd();
                    AppMethodBeat.o(58897);
                    return 0;
                case 2:
                    mvVar.vQQ = aVar3.BTU.vd();
                    AppMethodBeat.o(58897);
                    return 0;
                case 3:
                    mvVar.vQR = aVar3.BTU.vd();
                    AppMethodBeat.o(58897);
                    return 0;
                case 4:
                    mvVar.vQS = aVar3.BTU.vd();
                    AppMethodBeat.o(58897);
                    return 0;
                case 5:
                    mvVar.vQT = aVar3.BTU.vd();
                    AppMethodBeat.o(58897);
                    return 0;
                case 6:
                    mvVar.vQU = aVar3.BTU.vd();
                    AppMethodBeat.o(58897);
                    return 0;
                default:
                    AppMethodBeat.o(58897);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58897);
            return -1;
        }
    }
}
