package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cxe extends a {
    public int vEr;
    public int wDC;
    public int xsE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96340);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wDC);
            aVar.iz(2, this.vEr);
            aVar.iz(3, this.xsE);
            AppMethodBeat.o(96340);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wDC) + 0) + e.a.a.b.b.a.bs(2, this.vEr)) + e.a.a.b.b.a.bs(3, this.xsE);
            AppMethodBeat.o(96340);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96340);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxe cxe = (cxe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxe.wDC = aVar3.BTU.vd();
                    AppMethodBeat.o(96340);
                    return 0;
                case 2:
                    cxe.vEr = aVar3.BTU.vd();
                    AppMethodBeat.o(96340);
                    return 0;
                case 3:
                    cxe.xsE = aVar3.BTU.vd();
                    AppMethodBeat.o(96340);
                    return 0;
                default:
                    AppMethodBeat.o(96340);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96340);
            return -1;
        }
    }
}
