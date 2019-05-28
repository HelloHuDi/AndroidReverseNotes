package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cyd extends a {
    public boolean xtA;
    public int xty;
    public boolean xtz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96349);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xty);
            aVar.aO(2, this.xtz);
            aVar.aO(3, this.xtA);
            AppMethodBeat.o(96349);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.xty) + 0) + (e.a.a.b.b.a.fv(2) + 1)) + (e.a.a.b.b.a.fv(3) + 1);
            AppMethodBeat.o(96349);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96349);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cyd cyd = (cyd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyd.xty = aVar3.BTU.vd();
                    AppMethodBeat.o(96349);
                    return 0;
                case 2:
                    cyd.xtz = aVar3.BTU.ehX();
                    AppMethodBeat.o(96349);
                    return 0;
                case 3:
                    cyd.xtA = aVar3.BTU.ehX();
                    AppMethodBeat.o(96349);
                    return 0;
                default:
                    AppMethodBeat.o(96349);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96349);
            return -1;
        }
    }
}
