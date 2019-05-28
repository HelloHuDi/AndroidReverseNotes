package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cqt extends a {
    public int akv;
    public String category;
    public int fQi;
    public int wWK;
    public b wdt;
    public int xoy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102401);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.fQi);
            aVar.iz(2, this.akv);
            if (this.category != null) {
                aVar.e(3, this.category);
            }
            if (this.wdt != null) {
                aVar.c(4, this.wdt);
            }
            aVar.iz(5, this.wWK);
            aVar.iz(6, this.xoy);
            AppMethodBeat.o(102401);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.fQi) + 0) + e.a.a.b.b.a.bs(2, this.akv);
            if (this.category != null) {
                bs += e.a.a.b.b.a.f(3, this.category);
            }
            if (this.wdt != null) {
                bs += e.a.a.b.b.a.b(4, this.wdt);
            }
            bs = (bs + e.a.a.b.b.a.bs(5, this.wWK)) + e.a.a.b.b.a.bs(6, this.xoy);
            AppMethodBeat.o(102401);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102401);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqt cqt = (cqt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqt.fQi = aVar3.BTU.vd();
                    AppMethodBeat.o(102401);
                    return 0;
                case 2:
                    cqt.akv = aVar3.BTU.vd();
                    AppMethodBeat.o(102401);
                    return 0;
                case 3:
                    cqt.category = aVar3.BTU.readString();
                    AppMethodBeat.o(102401);
                    return 0;
                case 4:
                    cqt.wdt = aVar3.BTU.emu();
                    AppMethodBeat.o(102401);
                    return 0;
                case 5:
                    cqt.wWK = aVar3.BTU.vd();
                    AppMethodBeat.o(102401);
                    return 0;
                case 6:
                    cqt.xoy = aVar3.BTU.vd();
                    AppMethodBeat.o(102401);
                    return 0;
                default:
                    AppMethodBeat.o(102401);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102401);
            return -1;
        }
    }
}
