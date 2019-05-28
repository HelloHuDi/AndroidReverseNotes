package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bta extends a {
    public int vek;
    public int wOI;
    public int wVd;
    public int wVf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80166);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wOI);
            aVar.iz(2, this.wVf);
            aVar.iz(3, this.wVd);
            aVar.iz(4, this.vek);
            AppMethodBeat.o(80166);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wOI) + 0) + e.a.a.b.b.a.bs(2, this.wVf)) + e.a.a.b.b.a.bs(3, this.wVd)) + e.a.a.b.b.a.bs(4, this.vek);
            AppMethodBeat.o(80166);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80166);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bta bta = (bta) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bta.wOI = aVar3.BTU.vd();
                    AppMethodBeat.o(80166);
                    return 0;
                case 2:
                    bta.wVf = aVar3.BTU.vd();
                    AppMethodBeat.o(80166);
                    return 0;
                case 3:
                    bta.wVd = aVar3.BTU.vd();
                    AppMethodBeat.o(80166);
                    return 0;
                case 4:
                    bta.vek = aVar3.BTU.vd();
                    AppMethodBeat.o(80166);
                    return 0;
                default:
                    AppMethodBeat.o(80166);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80166);
            return -1;
        }
    }
}
