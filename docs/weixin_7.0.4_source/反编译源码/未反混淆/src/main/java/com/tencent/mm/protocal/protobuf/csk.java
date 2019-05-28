package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class csk extends a {
    public b xpM;
    public b xpN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57000);
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xpM != null) {
                aVar.c(1, this.xpM);
            }
            if (this.xpN != null) {
                aVar.c(2, this.xpN);
            }
            AppMethodBeat.o(57000);
            return 0;
        } else if (i == 1) {
            if (this.xpM != null) {
                b = e.a.a.b.b.a.b(1, this.xpM) + 0;
            } else {
                b = 0;
            }
            if (this.xpN != null) {
                b += e.a.a.b.b.a.b(2, this.xpN);
            }
            AppMethodBeat.o(57000);
            return b;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(57000);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csk csk = (csk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csk.xpM = aVar3.BTU.emu();
                    AppMethodBeat.o(57000);
                    return 0;
                case 2:
                    csk.xpN = aVar3.BTU.emu();
                    AppMethodBeat.o(57000);
                    return 0;
                default:
                    AppMethodBeat.o(57000);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57000);
            return -1;
        }
    }
}
