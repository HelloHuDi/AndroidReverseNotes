package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cpt extends a {
    public int jCt;
    public int xnH;
    public int xnI;
    public int xnJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5257);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCt);
            aVar.iz(2, this.xnH);
            aVar.iz(3, this.xnI);
            aVar.iz(4, this.xnJ);
            AppMethodBeat.o(5257);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.jCt) + 0) + e.a.a.b.b.a.bs(2, this.xnH)) + e.a.a.b.b.a.bs(3, this.xnI)) + e.a.a.b.b.a.bs(4, this.xnJ);
            AppMethodBeat.o(5257);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5257);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpt cpt = (cpt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cpt.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(5257);
                    return 0;
                case 2:
                    cpt.xnH = aVar3.BTU.vd();
                    AppMethodBeat.o(5257);
                    return 0;
                case 3:
                    cpt.xnI = aVar3.BTU.vd();
                    AppMethodBeat.o(5257);
                    return 0;
                case 4:
                    cpt.xnJ = aVar3.BTU.vd();
                    AppMethodBeat.o(5257);
                    return 0;
                default:
                    AppMethodBeat.o(5257);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5257);
            return -1;
        }
    }
}
