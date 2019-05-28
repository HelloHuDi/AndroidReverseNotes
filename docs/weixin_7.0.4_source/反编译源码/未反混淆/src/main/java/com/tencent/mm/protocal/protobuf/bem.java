package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bem extends a {
    public int wIA;
    public long wIB;
    public long wIC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124332);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wIA);
            aVar.ai(2, this.wIB);
            aVar.ai(3, this.wIC);
            AppMethodBeat.o(124332);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wIA) + 0) + e.a.a.b.b.a.o(2, this.wIB)) + e.a.a.b.b.a.o(3, this.wIC);
            AppMethodBeat.o(124332);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124332);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bem bem = (bem) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bem.wIA = aVar3.BTU.vd();
                    AppMethodBeat.o(124332);
                    return 0;
                case 2:
                    bem.wIB = aVar3.BTU.ve();
                    AppMethodBeat.o(124332);
                    return 0;
                case 3:
                    bem.wIC = aVar3.BTU.ve();
                    AppMethodBeat.o(124332);
                    return 0;
                default:
                    AppMethodBeat.o(124332);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124332);
            return -1;
        }
    }
}
