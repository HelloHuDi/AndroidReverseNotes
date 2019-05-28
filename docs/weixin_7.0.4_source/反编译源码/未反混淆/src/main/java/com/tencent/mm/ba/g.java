package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class g extends a {
    public int cKB;
    public int fMk;
    public int fMl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(78445);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.cKB);
            aVar.iz(2, this.fMk);
            aVar.iz(3, this.fMl);
            AppMethodBeat.o(78445);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.cKB) + 0) + e.a.a.b.b.a.bs(2, this.fMk)) + e.a.a.b.b.a.bs(3, this.fMl);
            AppMethodBeat.o(78445);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(78445);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.cKB = aVar3.BTU.vd();
                    AppMethodBeat.o(78445);
                    return 0;
                case 2:
                    gVar.fMk = aVar3.BTU.vd();
                    AppMethodBeat.o(78445);
                    return 0;
                case 3:
                    gVar.fMl = aVar3.BTU.vd();
                    AppMethodBeat.o(78445);
                    return 0;
                default:
                    AppMethodBeat.o(78445);
                    return -1;
            }
        } else {
            AppMethodBeat.o(78445);
            return -1;
        }
    }
}
