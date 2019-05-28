package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class axc extends a {
    public int jBv;
    public int wBd;
    public b wBe;
    public int wBl;
    public int wBm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(70483);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wBd);
            if (this.wBe != null) {
                aVar.c(2, this.wBe);
            }
            aVar.iz(3, this.wBl);
            aVar.iz(4, this.jBv);
            aVar.iz(5, this.wBm);
            AppMethodBeat.o(70483);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wBd) + 0;
            if (this.wBe != null) {
                bs += e.a.a.b.b.a.b(2, this.wBe);
            }
            bs = ((bs + e.a.a.b.b.a.bs(3, this.wBl)) + e.a.a.b.b.a.bs(4, this.jBv)) + e.a.a.b.b.a.bs(5, this.wBm);
            AppMethodBeat.o(70483);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(70483);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axc axc = (axc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axc.wBd = aVar3.BTU.vd();
                    AppMethodBeat.o(70483);
                    return 0;
                case 2:
                    axc.wBe = aVar3.BTU.emu();
                    AppMethodBeat.o(70483);
                    return 0;
                case 3:
                    axc.wBl = aVar3.BTU.vd();
                    AppMethodBeat.o(70483);
                    return 0;
                case 4:
                    axc.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(70483);
                    return 0;
                case 5:
                    axc.wBm = aVar3.BTU.vd();
                    AppMethodBeat.o(70483);
                    return 0;
                default:
                    AppMethodBeat.o(70483);
                    return -1;
            }
        } else {
            AppMethodBeat.o(70483);
            return -1;
        }
    }
}
