package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class n extends a {
    public int kKI;
    public boolean kKJ;
    public long kKK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35523);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.kKI);
            aVar.aO(2, this.kKJ);
            aVar.ai(3, this.kKK);
            AppMethodBeat.o(35523);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.kKI) + 0) + (e.a.a.b.b.a.fv(2) + 1)) + e.a.a.b.b.a.o(3, this.kKK);
            AppMethodBeat.o(35523);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35523);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.kKI = aVar3.BTU.vd();
                    AppMethodBeat.o(35523);
                    return 0;
                case 2:
                    nVar.kKJ = aVar3.BTU.ehX();
                    AppMethodBeat.o(35523);
                    return 0;
                case 3:
                    nVar.kKK = aVar3.BTU.ve();
                    AppMethodBeat.o(35523);
                    return 0;
                default:
                    AppMethodBeat.o(35523);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35523);
            return -1;
        }
    }
}
