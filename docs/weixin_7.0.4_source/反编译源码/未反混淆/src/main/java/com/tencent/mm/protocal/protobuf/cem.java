package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cem extends a {
    public String ndF;
    public int wZG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56529);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wZG);
            if (this.ndF != null) {
                aVar.e(2, this.ndF);
            }
            AppMethodBeat.o(56529);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wZG) + 0;
            if (this.ndF != null) {
                bs += e.a.a.b.b.a.f(2, this.ndF);
            }
            AppMethodBeat.o(56529);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56529);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cem cem = (cem) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cem.wZG = aVar3.BTU.vd();
                    AppMethodBeat.o(56529);
                    return 0;
                case 2:
                    cem.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(56529);
                    return 0;
                default:
                    AppMethodBeat.o(56529);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56529);
            return -1;
        }
    }
}
