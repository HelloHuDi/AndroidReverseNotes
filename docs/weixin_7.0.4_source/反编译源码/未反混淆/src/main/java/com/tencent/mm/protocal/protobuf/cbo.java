package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cbo extends a {
    public int vEq;
    public int xaT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94593);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vEq);
            aVar.iz(2, this.xaT);
            AppMethodBeat.o(94593);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vEq) + 0) + e.a.a.b.b.a.bs(2, this.xaT);
            AppMethodBeat.o(94593);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94593);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbo cbo = (cbo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbo.vEq = aVar3.BTU.vd();
                    AppMethodBeat.o(94593);
                    return 0;
                case 2:
                    cbo.xaT = aVar3.BTU.vd();
                    AppMethodBeat.o(94593);
                    return 0;
                default:
                    AppMethodBeat.o(94593);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94593);
            return -1;
        }
    }
}
