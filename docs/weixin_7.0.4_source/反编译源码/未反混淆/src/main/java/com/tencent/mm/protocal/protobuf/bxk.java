package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bxk extends a {
    public int wXr;
    public int wXs;
    public int wXt;
    public int wXu;
    public int wXv;
    public int wXw;
    public int wXx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11805);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wXr);
            aVar.iz(2, this.wXs);
            aVar.iz(3, this.wXt);
            aVar.iz(4, this.wXu);
            aVar.iz(5, this.wXv);
            aVar.iz(6, this.wXw);
            aVar.iz(7, this.wXx);
            AppMethodBeat.o(11805);
            return 0;
        } else if (i == 1) {
            bs = ((((((e.a.a.b.b.a.bs(1, this.wXr) + 0) + e.a.a.b.b.a.bs(2, this.wXs)) + e.a.a.b.b.a.bs(3, this.wXt)) + e.a.a.b.b.a.bs(4, this.wXu)) + e.a.a.b.b.a.bs(5, this.wXv)) + e.a.a.b.b.a.bs(6, this.wXw)) + e.a.a.b.b.a.bs(7, this.wXx);
            AppMethodBeat.o(11805);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11805);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxk bxk = (bxk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxk.wXr = aVar3.BTU.vd();
                    AppMethodBeat.o(11805);
                    return 0;
                case 2:
                    bxk.wXs = aVar3.BTU.vd();
                    AppMethodBeat.o(11805);
                    return 0;
                case 3:
                    bxk.wXt = aVar3.BTU.vd();
                    AppMethodBeat.o(11805);
                    return 0;
                case 4:
                    bxk.wXu = aVar3.BTU.vd();
                    AppMethodBeat.o(11805);
                    return 0;
                case 5:
                    bxk.wXv = aVar3.BTU.vd();
                    AppMethodBeat.o(11805);
                    return 0;
                case 6:
                    bxk.wXw = aVar3.BTU.vd();
                    AppMethodBeat.o(11805);
                    return 0;
                case 7:
                    bxk.wXx = aVar3.BTU.vd();
                    AppMethodBeat.o(11805);
                    return 0;
                default:
                    AppMethodBeat.o(11805);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11805);
            return -1;
        }
    }
}
