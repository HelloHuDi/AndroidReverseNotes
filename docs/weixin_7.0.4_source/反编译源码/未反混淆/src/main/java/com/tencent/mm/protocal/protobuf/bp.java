package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class bp extends a {
    public int vDS;
    public b vDT;
    public long vDU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94500);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vDS);
            if (this.vDT != null) {
                aVar.c(2, this.vDT);
            }
            aVar.ai(3, this.vDU);
            AppMethodBeat.o(94500);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vDS) + 0;
            if (this.vDT != null) {
                bs += e.a.a.b.b.a.b(2, this.vDT);
            }
            bs += e.a.a.b.b.a.o(3, this.vDU);
            AppMethodBeat.o(94500);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94500);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bp bpVar = (bp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpVar.vDS = aVar3.BTU.vd();
                    AppMethodBeat.o(94500);
                    return 0;
                case 2:
                    bpVar.vDT = aVar3.BTU.emu();
                    AppMethodBeat.o(94500);
                    return 0;
                case 3:
                    bpVar.vDU = aVar3.BTU.ve();
                    AppMethodBeat.o(94500);
                    return 0;
                default:
                    AppMethodBeat.o(94500);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94500);
            return -1;
        }
    }
}
