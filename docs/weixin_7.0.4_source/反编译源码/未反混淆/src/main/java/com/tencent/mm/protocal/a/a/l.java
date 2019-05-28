package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class l extends a {
    public int action;
    public int vzp;
    public int vzq;
    public int vzr;
    public int vzs;
    public int vzt;
    public int vzu;
    public int vzv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72831);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vzp);
            aVar.iz(2, this.action);
            aVar.iz(3, this.vzq);
            aVar.iz(4, this.vzr);
            aVar.iz(5, this.vzs);
            aVar.iz(6, this.vzt);
            aVar.iz(7, this.vzu);
            aVar.iz(8, this.vzv);
            AppMethodBeat.o(72831);
            return 0;
        } else if (i == 1) {
            bs = (((((((e.a.a.b.b.a.bs(1, this.vzp) + 0) + e.a.a.b.b.a.bs(2, this.action)) + e.a.a.b.b.a.bs(3, this.vzq)) + e.a.a.b.b.a.bs(4, this.vzr)) + e.a.a.b.b.a.bs(5, this.vzs)) + e.a.a.b.b.a.bs(6, this.vzt)) + e.a.a.b.b.a.bs(7, this.vzu)) + e.a.a.b.b.a.bs(8, this.vzv);
            AppMethodBeat.o(72831);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72831);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.vzp = aVar3.BTU.vd();
                    AppMethodBeat.o(72831);
                    return 0;
                case 2:
                    lVar.action = aVar3.BTU.vd();
                    AppMethodBeat.o(72831);
                    return 0;
                case 3:
                    lVar.vzq = aVar3.BTU.vd();
                    AppMethodBeat.o(72831);
                    return 0;
                case 4:
                    lVar.vzr = aVar3.BTU.vd();
                    AppMethodBeat.o(72831);
                    return 0;
                case 5:
                    lVar.vzs = aVar3.BTU.vd();
                    AppMethodBeat.o(72831);
                    return 0;
                case 6:
                    lVar.vzt = aVar3.BTU.vd();
                    AppMethodBeat.o(72831);
                    return 0;
                case 7:
                    lVar.vzu = aVar3.BTU.vd();
                    AppMethodBeat.o(72831);
                    return 0;
                case 8:
                    lVar.vzv = aVar3.BTU.vd();
                    AppMethodBeat.o(72831);
                    return 0;
                default:
                    AppMethodBeat.o(72831);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72831);
            return -1;
        }
    }
}
