package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class bcq extends a {
    public int vOw;
    public String vXm;
    public String vXn;
    public int wGT;
    public b wGU;
    public String wGV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28556);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vOw);
            aVar.iz(2, this.wGT);
            if (this.wGU != null) {
                aVar.c(3, this.wGU);
            }
            if (this.wGV != null) {
                aVar.e(4, this.wGV);
            }
            if (this.vXm != null) {
                aVar.e(5, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(6, this.vXn);
            }
            AppMethodBeat.o(28556);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vOw) + 0) + e.a.a.b.b.a.bs(2, this.wGT);
            if (this.wGU != null) {
                bs += e.a.a.b.b.a.b(3, this.wGU);
            }
            if (this.wGV != null) {
                bs += e.a.a.b.b.a.f(4, this.wGV);
            }
            if (this.vXm != null) {
                bs += e.a.a.b.b.a.f(5, this.vXm);
            }
            if (this.vXn != null) {
                bs += e.a.a.b.b.a.f(6, this.vXn);
            }
            AppMethodBeat.o(28556);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28556);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcq bcq = (bcq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcq.vOw = aVar3.BTU.vd();
                    AppMethodBeat.o(28556);
                    return 0;
                case 2:
                    bcq.wGT = aVar3.BTU.vd();
                    AppMethodBeat.o(28556);
                    return 0;
                case 3:
                    bcq.wGU = aVar3.BTU.emu();
                    AppMethodBeat.o(28556);
                    return 0;
                case 4:
                    bcq.wGV = aVar3.BTU.readString();
                    AppMethodBeat.o(28556);
                    return 0;
                case 5:
                    bcq.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(28556);
                    return 0;
                case 6:
                    bcq.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(28556);
                    return 0;
                default:
                    AppMethodBeat.o(28556);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28556);
            return -1;
        }
    }
}
