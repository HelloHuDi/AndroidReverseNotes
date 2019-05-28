package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cfi extends a {
    public int pXC;
    public String xeN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58933);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.pXC);
            if (this.xeN != null) {
                aVar.e(2, this.xeN);
            }
            AppMethodBeat.o(58933);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.pXC) + 0;
            if (this.xeN != null) {
                bs += e.a.a.b.b.a.f(2, this.xeN);
            }
            AppMethodBeat.o(58933);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58933);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfi cfi = (cfi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfi.pXC = aVar3.BTU.vd();
                    AppMethodBeat.o(58933);
                    return 0;
                case 2:
                    cfi.xeN = aVar3.BTU.readString();
                    AppMethodBeat.o(58933);
                    return 0;
                default:
                    AppMethodBeat.o(58933);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58933);
            return -1;
        }
    }
}
