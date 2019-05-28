package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bei extends a {
    public int jCt;
    public int wBd;
    public int wIq;
    public int wIr;
    public int wIs;
    public int wIt;
    public int wIu;
    public int wIv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72861);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wBd);
            aVar.iz(2, this.wIq);
            aVar.iz(3, this.wIr);
            aVar.iz(4, this.wIs);
            aVar.iz(5, this.wIt);
            aVar.iz(6, this.wIu);
            aVar.iz(7, this.wIv);
            aVar.iz(8, this.jCt);
            AppMethodBeat.o(72861);
            return 0;
        } else if (i == 1) {
            bs = (((((((e.a.a.b.b.a.bs(1, this.wBd) + 0) + e.a.a.b.b.a.bs(2, this.wIq)) + e.a.a.b.b.a.bs(3, this.wIr)) + e.a.a.b.b.a.bs(4, this.wIs)) + e.a.a.b.b.a.bs(5, this.wIt)) + e.a.a.b.b.a.bs(6, this.wIu)) + e.a.a.b.b.a.bs(7, this.wIv)) + e.a.a.b.b.a.bs(8, this.jCt);
            AppMethodBeat.o(72861);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72861);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bei bei = (bei) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bei.wBd = aVar3.BTU.vd();
                    AppMethodBeat.o(72861);
                    return 0;
                case 2:
                    bei.wIq = aVar3.BTU.vd();
                    AppMethodBeat.o(72861);
                    return 0;
                case 3:
                    bei.wIr = aVar3.BTU.vd();
                    AppMethodBeat.o(72861);
                    return 0;
                case 4:
                    bei.wIs = aVar3.BTU.vd();
                    AppMethodBeat.o(72861);
                    return 0;
                case 5:
                    bei.wIt = aVar3.BTU.vd();
                    AppMethodBeat.o(72861);
                    return 0;
                case 6:
                    bei.wIu = aVar3.BTU.vd();
                    AppMethodBeat.o(72861);
                    return 0;
                case 7:
                    bei.wIv = aVar3.BTU.vd();
                    AppMethodBeat.o(72861);
                    return 0;
                case 8:
                    bei.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(72861);
                    return 0;
                default:
                    AppMethodBeat.o(72861);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72861);
            return -1;
        }
    }
}
