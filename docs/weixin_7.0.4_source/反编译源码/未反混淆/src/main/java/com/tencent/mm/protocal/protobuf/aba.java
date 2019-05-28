package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aba extends a {
    public int jBT;
    public int vEp;
    public int vEq;
    public int vEr;
    public int vEs;
    public String vEv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51401);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vEp);
            aVar.iz(2, this.jBT);
            if (this.vEv != null) {
                aVar.e(3, this.vEv);
            }
            aVar.iz(4, this.vEq);
            aVar.iz(5, this.vEr);
            aVar.iz(6, this.vEs);
            AppMethodBeat.o(51401);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vEp) + 0) + e.a.a.b.b.a.bs(2, this.jBT);
            if (this.vEv != null) {
                bs += e.a.a.b.b.a.f(3, this.vEv);
            }
            bs = ((bs + e.a.a.b.b.a.bs(4, this.vEq)) + e.a.a.b.b.a.bs(5, this.vEr)) + e.a.a.b.b.a.bs(6, this.vEs);
            AppMethodBeat.o(51401);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51401);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aba aba = (aba) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aba.vEp = aVar3.BTU.vd();
                    AppMethodBeat.o(51401);
                    return 0;
                case 2:
                    aba.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(51401);
                    return 0;
                case 3:
                    aba.vEv = aVar3.BTU.readString();
                    AppMethodBeat.o(51401);
                    return 0;
                case 4:
                    aba.vEq = aVar3.BTU.vd();
                    AppMethodBeat.o(51401);
                    return 0;
                case 5:
                    aba.vEr = aVar3.BTU.vd();
                    AppMethodBeat.o(51401);
                    return 0;
                case 6:
                    aba.vEs = aVar3.BTU.vd();
                    AppMethodBeat.o(51401);
                    return 0;
                default:
                    AppMethodBeat.o(51401);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51401);
            return -1;
        }
    }
}
