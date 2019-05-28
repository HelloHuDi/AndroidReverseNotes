package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class nb extends a {
    public int vRF;
    public int vRG;
    public String vRH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56734);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vRF);
            aVar.iz(2, this.vRG);
            if (this.vRH != null) {
                aVar.e(3, this.vRH);
            }
            AppMethodBeat.o(56734);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vRF) + 0) + e.a.a.b.b.a.bs(2, this.vRG);
            if (this.vRH != null) {
                bs += e.a.a.b.b.a.f(3, this.vRH);
            }
            AppMethodBeat.o(56734);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56734);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nb nbVar = (nb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nbVar.vRF = aVar3.BTU.vd();
                    AppMethodBeat.o(56734);
                    return 0;
                case 2:
                    nbVar.vRG = aVar3.BTU.vd();
                    AppMethodBeat.o(56734);
                    return 0;
                case 3:
                    nbVar.vRH = aVar3.BTU.readString();
                    AppMethodBeat.o(56734);
                    return 0;
                default:
                    AppMethodBeat.o(56734);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56734);
            return -1;
        }
    }
}
