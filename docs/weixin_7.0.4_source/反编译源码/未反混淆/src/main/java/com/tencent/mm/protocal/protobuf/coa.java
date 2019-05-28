package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class coa extends a {
    public int vHo;
    public int vHp;
    public int vHq;
    public int vHr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28701);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vHo);
            aVar.iz(2, this.vHp);
            aVar.iz(3, this.vHq);
            aVar.iz(4, this.vHr);
            AppMethodBeat.o(28701);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.vHo) + 0) + e.a.a.b.b.a.bs(2, this.vHp)) + e.a.a.b.b.a.bs(3, this.vHq)) + e.a.a.b.b.a.bs(4, this.vHr);
            AppMethodBeat.o(28701);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28701);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            coa coa = (coa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    coa.vHo = aVar3.BTU.vd();
                    AppMethodBeat.o(28701);
                    return 0;
                case 2:
                    coa.vHp = aVar3.BTU.vd();
                    AppMethodBeat.o(28701);
                    return 0;
                case 3:
                    coa.vHq = aVar3.BTU.vd();
                    AppMethodBeat.o(28701);
                    return 0;
                case 4:
                    coa.vHr = aVar3.BTU.vd();
                    AppMethodBeat.o(28701);
                    return 0;
                default:
                    AppMethodBeat.o(28701);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28701);
            return -1;
        }
    }
}
