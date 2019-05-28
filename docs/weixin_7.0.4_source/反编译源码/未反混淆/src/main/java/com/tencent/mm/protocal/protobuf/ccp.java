package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ccp extends a {
    public int wBs;
    public int wcL;
    public int xbW;
    public int xbX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94627);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wcL);
            aVar.iz(2, this.wBs);
            aVar.iz(3, this.xbW);
            aVar.iz(4, this.xbX);
            AppMethodBeat.o(94627);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wcL) + 0) + e.a.a.b.b.a.bs(2, this.wBs)) + e.a.a.b.b.a.bs(3, this.xbW)) + e.a.a.b.b.a.bs(4, this.xbX);
            AppMethodBeat.o(94627);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94627);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccp ccp = (ccp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccp.wcL = aVar3.BTU.vd();
                    AppMethodBeat.o(94627);
                    return 0;
                case 2:
                    ccp.wBs = aVar3.BTU.vd();
                    AppMethodBeat.o(94627);
                    return 0;
                case 3:
                    ccp.xbW = aVar3.BTU.vd();
                    AppMethodBeat.o(94627);
                    return 0;
                case 4:
                    ccp.xbX = aVar3.BTU.vd();
                    AppMethodBeat.o(94627);
                    return 0;
                default:
                    AppMethodBeat.o(94627);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94627);
            return -1;
        }
    }
}
