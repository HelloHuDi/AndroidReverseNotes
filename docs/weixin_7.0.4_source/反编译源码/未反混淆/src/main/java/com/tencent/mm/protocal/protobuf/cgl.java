package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cgl extends a {
    public int wOO;
    public int xfs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28667);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xfs);
            aVar.iz(2, this.wOO);
            AppMethodBeat.o(28667);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.xfs) + 0) + e.a.a.b.b.a.bs(2, this.wOO);
            AppMethodBeat.o(28667);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28667);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgl cgl = (cgl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgl.xfs = aVar3.BTU.vd();
                    AppMethodBeat.o(28667);
                    return 0;
                case 2:
                    cgl.wOO = aVar3.BTU.vd();
                    AppMethodBeat.o(28667);
                    return 0;
                default:
                    AppMethodBeat.o(28667);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28667);
            return -1;
        }
    }
}
