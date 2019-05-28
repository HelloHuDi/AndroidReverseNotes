package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ars extends a {
    public int wvG;
    public int wvH;
    public boolean wvI;
    public boolean wvJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134433);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wvG);
            aVar.iz(2, this.wvH);
            aVar.aO(3, this.wvI);
            aVar.aO(4, this.wvJ);
            AppMethodBeat.o(134433);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wvG) + 0) + e.a.a.b.b.a.bs(2, this.wvH)) + (e.a.a.b.b.a.fv(3) + 1)) + (e.a.a.b.b.a.fv(4) + 1);
            AppMethodBeat.o(134433);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134433);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ars ars = (ars) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ars.wvG = aVar3.BTU.vd();
                    AppMethodBeat.o(134433);
                    return 0;
                case 2:
                    ars.wvH = aVar3.BTU.vd();
                    AppMethodBeat.o(134433);
                    return 0;
                case 3:
                    ars.wvI = aVar3.BTU.ehX();
                    AppMethodBeat.o(134433);
                    return 0;
                case 4:
                    ars.wvJ = aVar3.BTU.ehX();
                    AppMethodBeat.o(134433);
                    return 0;
                default:
                    AppMethodBeat.o(134433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134433);
            return -1;
        }
    }
}
