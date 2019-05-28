package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class chz extends a {
    public b vPM;
    public int vPN;
    public int xhl;
    public int xhm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56990);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(7, this.xhl);
            if (this.vPM != null) {
                aVar.c(8, this.vPM);
            }
            aVar.iz(9, this.vPN);
            aVar.iz(10, this.xhm);
            AppMethodBeat.o(56990);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(7, this.xhl) + 0;
            if (this.vPM != null) {
                bs += e.a.a.b.b.a.b(8, this.vPM);
            }
            bs = (bs + e.a.a.b.b.a.bs(9, this.vPN)) + e.a.a.b.b.a.bs(10, this.xhm);
            AppMethodBeat.o(56990);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56990);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chz chz = (chz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 7:
                    chz.xhl = aVar3.BTU.vd();
                    AppMethodBeat.o(56990);
                    return 0;
                case 8:
                    chz.vPM = aVar3.BTU.emu();
                    AppMethodBeat.o(56990);
                    return 0;
                case 9:
                    chz.vPN = aVar3.BTU.vd();
                    AppMethodBeat.o(56990);
                    return 0;
                case 10:
                    chz.xhm = aVar3.BTU.vd();
                    AppMethodBeat.o(56990);
                    return 0;
                default:
                    AppMethodBeat.o(56990);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56990);
            return -1;
        }
    }
}
