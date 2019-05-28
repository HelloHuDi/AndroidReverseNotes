package com.tencent.mm.cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class d extends a {
    public int max;
    public int min;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62665);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.min);
            aVar.iz(2, this.max);
            AppMethodBeat.o(62665);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.min) + 0) + e.a.a.b.b.a.bs(2, this.max);
            AppMethodBeat.o(62665);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62665);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.min = aVar3.BTU.vd();
                    AppMethodBeat.o(62665);
                    return 0;
                case 2:
                    dVar.max = aVar3.BTU.vd();
                    AppMethodBeat.o(62665);
                    return 0;
                default:
                    AppMethodBeat.o(62665);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62665);
            return -1;
        }
    }
}
