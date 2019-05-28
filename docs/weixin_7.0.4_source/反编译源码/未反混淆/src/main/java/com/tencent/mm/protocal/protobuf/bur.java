package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bur extends a {
    public int Timestamp;
    public int nbk;
    public int wWg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124345);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wWg);
            aVar.iz(2, this.Timestamp);
            aVar.iz(3, this.nbk);
            AppMethodBeat.o(124345);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wWg) + 0) + e.a.a.b.b.a.bs(2, this.Timestamp)) + e.a.a.b.b.a.bs(3, this.nbk);
            AppMethodBeat.o(124345);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124345);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bur bur = (bur) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bur.wWg = aVar3.BTU.vd();
                    AppMethodBeat.o(124345);
                    return 0;
                case 2:
                    bur.Timestamp = aVar3.BTU.vd();
                    AppMethodBeat.o(124345);
                    return 0;
                case 3:
                    bur.nbk = aVar3.BTU.vd();
                    AppMethodBeat.o(124345);
                    return 0;
                default:
                    AppMethodBeat.o(124345);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124345);
            return -1;
        }
    }
}
