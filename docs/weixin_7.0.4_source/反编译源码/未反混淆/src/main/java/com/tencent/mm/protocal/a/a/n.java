package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class n extends a {
    public int type;
    public int vyQ;
    public int vzA;
    public int vzB;
    public int vzC;
    public int vzD;
    public int vzE;
    public int vzz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72834);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vyQ);
            aVar.iz(2, this.vzz);
            aVar.iz(3, this.vzA);
            aVar.iz(4, this.vzB);
            aVar.iz(5, this.vzC);
            aVar.iz(6, this.vzD);
            aVar.iz(7, this.vzE);
            aVar.iz(8, this.type);
            AppMethodBeat.o(72834);
            return 0;
        } else if (i == 1) {
            bs = (((((((e.a.a.b.b.a.bs(1, this.vyQ) + 0) + e.a.a.b.b.a.bs(2, this.vzz)) + e.a.a.b.b.a.bs(3, this.vzA)) + e.a.a.b.b.a.bs(4, this.vzB)) + e.a.a.b.b.a.bs(5, this.vzC)) + e.a.a.b.b.a.bs(6, this.vzD)) + e.a.a.b.b.a.bs(7, this.vzE)) + e.a.a.b.b.a.bs(8, this.type);
            AppMethodBeat.o(72834);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72834);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.vyQ = aVar3.BTU.vd();
                    AppMethodBeat.o(72834);
                    return 0;
                case 2:
                    nVar.vzz = aVar3.BTU.vd();
                    AppMethodBeat.o(72834);
                    return 0;
                case 3:
                    nVar.vzA = aVar3.BTU.vd();
                    AppMethodBeat.o(72834);
                    return 0;
                case 4:
                    nVar.vzB = aVar3.BTU.vd();
                    AppMethodBeat.o(72834);
                    return 0;
                case 5:
                    nVar.vzC = aVar3.BTU.vd();
                    AppMethodBeat.o(72834);
                    return 0;
                case 6:
                    nVar.vzD = aVar3.BTU.vd();
                    AppMethodBeat.o(72834);
                    return 0;
                case 7:
                    nVar.vzE = aVar3.BTU.vd();
                    AppMethodBeat.o(72834);
                    return 0;
                case 8:
                    nVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(72834);
                    return 0;
                default:
                    AppMethodBeat.o(72834);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72834);
            return -1;
        }
    }
}
