package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bba extends a {
    public int ggb;
    public int wFN;
    public int wFO;
    public int wFP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2543);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wFN);
            aVar.iz(2, this.wFO);
            aVar.iz(3, this.wFP);
            aVar.iz(4, this.ggb);
            AppMethodBeat.o(2543);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wFN) + 0) + e.a.a.b.b.a.bs(2, this.wFO)) + e.a.a.b.b.a.bs(3, this.wFP)) + e.a.a.b.b.a.bs(4, this.ggb);
            AppMethodBeat.o(2543);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(2543);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bba bba = (bba) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bba.wFN = aVar3.BTU.vd();
                    AppMethodBeat.o(2543);
                    return 0;
                case 2:
                    bba.wFO = aVar3.BTU.vd();
                    AppMethodBeat.o(2543);
                    return 0;
                case 3:
                    bba.wFP = aVar3.BTU.vd();
                    AppMethodBeat.o(2543);
                    return 0;
                case 4:
                    bba.ggb = aVar3.BTU.vd();
                    AppMethodBeat.o(2543);
                    return 0;
                default:
                    AppMethodBeat.o(2543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2543);
            return -1;
        }
    }
}
