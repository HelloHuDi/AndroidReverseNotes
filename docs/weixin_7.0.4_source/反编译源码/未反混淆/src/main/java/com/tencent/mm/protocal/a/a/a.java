package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends com.tencent.mm.bt.a {
    public int count;
    public int value;
    public int vyQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72815);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vyQ);
            aVar.iz(2, this.value);
            aVar.iz(3, this.count);
            AppMethodBeat.o(72815);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.vyQ) + 0) + e.a.a.b.b.a.bs(2, this.value)) + e.a.a.b.b.a.bs(3, this.count);
            AppMethodBeat.o(72815);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); bs > 0; bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72815);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.vyQ = aVar3.BTU.vd();
                    AppMethodBeat.o(72815);
                    return 0;
                case 2:
                    aVar4.value = aVar3.BTU.vd();
                    AppMethodBeat.o(72815);
                    return 0;
                case 3:
                    aVar4.count = aVar3.BTU.vd();
                    AppMethodBeat.o(72815);
                    return 0;
                default:
                    AppMethodBeat.o(72815);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72815);
            return -1;
        }
    }
}
