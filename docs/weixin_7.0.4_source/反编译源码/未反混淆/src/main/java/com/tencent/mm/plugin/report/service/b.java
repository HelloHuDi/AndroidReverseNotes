package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class b extends a {
    public int ID;
    public int pXC;
    public int pXD;
    public boolean pXE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72702);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ID);
            aVar.iz(2, this.pXC);
            aVar.iz(3, this.pXD);
            aVar.aO(4, this.pXE);
            AppMethodBeat.o(72702);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.ID) + 0) + e.a.a.b.b.a.bs(2, this.pXC)) + e.a.a.b.b.a.bs(3, this.pXD)) + (e.a.a.b.b.a.fv(4) + 1);
            AppMethodBeat.o(72702);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72702);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.ID = aVar3.BTU.vd();
                    AppMethodBeat.o(72702);
                    return 0;
                case 2:
                    bVar.pXC = aVar3.BTU.vd();
                    AppMethodBeat.o(72702);
                    return 0;
                case 3:
                    bVar.pXD = aVar3.BTU.vd();
                    AppMethodBeat.o(72702);
                    return 0;
                case 4:
                    bVar.pXE = aVar3.BTU.ehX();
                    AppMethodBeat.o(72702);
                    return 0;
                default:
                    AppMethodBeat.o(72702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72702);
            return -1;
        }
    }
}
