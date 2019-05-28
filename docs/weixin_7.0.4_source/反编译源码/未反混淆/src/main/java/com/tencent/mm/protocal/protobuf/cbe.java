package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cbe extends a {
    public int xal;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94580);
        int bs;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).iz(1, this.xal);
            AppMethodBeat.o(94580);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xal) + 0;
            AppMethodBeat.o(94580);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar); bs > 0; bs = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, bs)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(94580);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            cbe cbe = (cbe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbe.xal = aVar2.BTU.vd();
                    AppMethodBeat.o(94580);
                    return 0;
                default:
                    AppMethodBeat.o(94580);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94580);
            return -1;
        }
    }
}
