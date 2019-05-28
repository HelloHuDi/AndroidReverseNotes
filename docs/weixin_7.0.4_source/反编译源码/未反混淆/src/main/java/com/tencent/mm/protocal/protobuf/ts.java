package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ts extends a {
    public int kzN;
    public int kzO;
    public int kzP;
    public int kzQ;
    public int kzR;
    public int kzS;
    public int kzT;
    public int kzU;
    public int kzV;
    public int waQ;
    public int waR;
    public int waS;
    public int waT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135598);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.kzN);
            aVar.iz(2, this.waQ);
            aVar.iz(3, this.kzO);
            aVar.iz(4, this.kzP);
            aVar.iz(5, this.kzQ);
            aVar.iz(6, this.waR);
            aVar.iz(7, this.kzR);
            aVar.iz(8, this.kzS);
            aVar.iz(9, this.waS);
            aVar.iz(10, this.waT);
            aVar.iz(11, this.kzT);
            aVar.iz(12, this.kzU);
            aVar.iz(13, this.kzV);
            AppMethodBeat.o(135598);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((((e.a.a.b.b.a.bs(1, this.kzN) + 0) + e.a.a.b.b.a.bs(2, this.waQ)) + e.a.a.b.b.a.bs(3, this.kzO)) + e.a.a.b.b.a.bs(4, this.kzP)) + e.a.a.b.b.a.bs(5, this.kzQ)) + e.a.a.b.b.a.bs(6, this.waR)) + e.a.a.b.b.a.bs(7, this.kzR)) + e.a.a.b.b.a.bs(8, this.kzS)) + e.a.a.b.b.a.bs(9, this.waS)) + e.a.a.b.b.a.bs(10, this.waT)) + e.a.a.b.b.a.bs(11, this.kzT)) + e.a.a.b.b.a.bs(12, this.kzU)) + e.a.a.b.b.a.bs(13, this.kzV);
            AppMethodBeat.o(135598);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(135598);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ts tsVar = (ts) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tsVar.kzN = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 2:
                    tsVar.waQ = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 3:
                    tsVar.kzO = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 4:
                    tsVar.kzP = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 5:
                    tsVar.kzQ = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 6:
                    tsVar.waR = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 7:
                    tsVar.kzR = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 8:
                    tsVar.kzS = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 9:
                    tsVar.waS = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 10:
                    tsVar.waT = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 11:
                    tsVar.kzT = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 12:
                    tsVar.kzU = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                case 13:
                    tsVar.kzV = aVar3.BTU.vd();
                    AppMethodBeat.o(135598);
                    return 0;
                default:
                    AppMethodBeat.o(135598);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135598);
            return -1;
        }
    }
}
