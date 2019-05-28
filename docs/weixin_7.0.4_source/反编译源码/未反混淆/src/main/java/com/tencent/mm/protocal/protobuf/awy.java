package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class awy extends a {
    public int jBv;
    public int wBd;
    public b wBe;
    public int wBf;
    public int wBg;
    public int wdc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72858);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wBd);
            if (this.wBe != null) {
                aVar.c(2, this.wBe);
            }
            aVar.iz(3, this.wBf);
            aVar.iz(4, this.wdc);
            aVar.iz(5, this.jBv);
            aVar.iz(6, this.wBg);
            AppMethodBeat.o(72858);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wBd) + 0;
            if (this.wBe != null) {
                bs += e.a.a.b.b.a.b(2, this.wBe);
            }
            bs = (((bs + e.a.a.b.b.a.bs(3, this.wBf)) + e.a.a.b.b.a.bs(4, this.wdc)) + e.a.a.b.b.a.bs(5, this.jBv)) + e.a.a.b.b.a.bs(6, this.wBg);
            AppMethodBeat.o(72858);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72858);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awy awy = (awy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awy.wBd = aVar3.BTU.vd();
                    AppMethodBeat.o(72858);
                    return 0;
                case 2:
                    awy.wBe = aVar3.BTU.emu();
                    AppMethodBeat.o(72858);
                    return 0;
                case 3:
                    awy.wBf = aVar3.BTU.vd();
                    AppMethodBeat.o(72858);
                    return 0;
                case 4:
                    awy.wdc = aVar3.BTU.vd();
                    AppMethodBeat.o(72858);
                    return 0;
                case 5:
                    awy.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(72858);
                    return 0;
                case 6:
                    awy.wBg = aVar3.BTU.vd();
                    AppMethodBeat.o(72858);
                    return 0;
                default:
                    AppMethodBeat.o(72858);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72858);
            return -1;
        }
    }
}
