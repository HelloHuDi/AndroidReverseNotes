package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class h extends a {
    public int ptD;
    public long ptF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(67927);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ptD);
            aVar.ai(2, this.ptF);
            AppMethodBeat.o(67927);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.ptD) + 0) + e.a.a.b.b.a.o(2, this.ptF);
            AppMethodBeat.o(67927);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(67927);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(67927);
                    return 0;
                case 2:
                    hVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(67927);
                    return 0;
                default:
                    AppMethodBeat.o(67927);
                    return -1;
            }
        } else {
            AppMethodBeat.o(67927);
            return -1;
        }
    }
}
