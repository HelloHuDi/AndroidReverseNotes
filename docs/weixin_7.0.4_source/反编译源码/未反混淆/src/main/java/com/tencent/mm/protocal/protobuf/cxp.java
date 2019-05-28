package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cxp extends a {
    public int xsV;
    public int xsW;
    public int xsX;
    public int xsY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115015);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xsV);
            aVar.iz(2, this.xsW);
            aVar.iz(3, this.xsX);
            aVar.iz(4, this.xsY);
            AppMethodBeat.o(115015);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.xsV) + 0) + e.a.a.b.b.a.bs(2, this.xsW)) + e.a.a.b.b.a.bs(3, this.xsX)) + e.a.a.b.b.a.bs(4, this.xsY);
            AppMethodBeat.o(115015);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115015);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxp cxp = (cxp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxp.xsV = aVar3.BTU.vd();
                    AppMethodBeat.o(115015);
                    return 0;
                case 2:
                    cxp.xsW = aVar3.BTU.vd();
                    AppMethodBeat.o(115015);
                    return 0;
                case 3:
                    cxp.xsX = aVar3.BTU.vd();
                    AppMethodBeat.o(115015);
                    return 0;
                case 4:
                    cxp.xsY = aVar3.BTU.vd();
                    AppMethodBeat.o(115015);
                    return 0;
                default:
                    AppMethodBeat.o(115015);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115015);
            return -1;
        }
    }
}
