package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cmm extends a {
    public int xko;
    public b xkp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5224);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xko);
            if (this.xkp != null) {
                aVar.c(2, this.xkp);
            }
            AppMethodBeat.o(5224);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xko) + 0;
            if (this.xkp != null) {
                bs += e.a.a.b.b.a.b(2, this.xkp);
            }
            AppMethodBeat.o(5224);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5224);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmm cmm = (cmm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmm.xko = aVar3.BTU.vd();
                    AppMethodBeat.o(5224);
                    return 0;
                case 2:
                    cmm.xkp = aVar3.BTU.emu();
                    AppMethodBeat.o(5224);
                    return 0;
                default:
                    AppMethodBeat.o(5224);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5224);
            return -1;
        }
    }
}
