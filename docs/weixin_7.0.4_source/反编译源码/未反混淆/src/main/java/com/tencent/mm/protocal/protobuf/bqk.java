package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bqk extends a {
    public int wSJ;
    public int wSK;
    public int wSL;
    public int wSM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(108898);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wSJ);
            aVar.iz(2, this.wSK);
            aVar.iz(3, this.wSL);
            aVar.iz(4, this.wSM);
            AppMethodBeat.o(108898);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wSJ) + 0) + e.a.a.b.b.a.bs(2, this.wSK)) + e.a.a.b.b.a.bs(3, this.wSL)) + e.a.a.b.b.a.bs(4, this.wSM);
            AppMethodBeat.o(108898);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(108898);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqk bqk = (bqk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqk.wSJ = aVar3.BTU.vd();
                    AppMethodBeat.o(108898);
                    return 0;
                case 2:
                    bqk.wSK = aVar3.BTU.vd();
                    AppMethodBeat.o(108898);
                    return 0;
                case 3:
                    bqk.wSL = aVar3.BTU.vd();
                    AppMethodBeat.o(108898);
                    return 0;
                case 4:
                    bqk.wSM = aVar3.BTU.vd();
                    AppMethodBeat.o(108898);
                    return 0;
                default:
                    AppMethodBeat.o(108898);
                    return -1;
            }
        } else {
            AppMethodBeat.o(108898);
            return -1;
        }
    }
}
