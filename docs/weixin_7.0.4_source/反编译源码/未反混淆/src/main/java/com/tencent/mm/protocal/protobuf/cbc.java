package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cbc extends a {
    public String cxb;
    public String nSX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94577);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nSX != null) {
                aVar.e(1, this.nSX);
            }
            if (this.cxb != null) {
                aVar.e(2, this.cxb);
            }
            AppMethodBeat.o(94577);
            return 0;
        } else if (i == 1) {
            if (this.nSX != null) {
                f = e.a.a.b.b.a.f(1, this.nSX) + 0;
            } else {
                f = 0;
            }
            if (this.cxb != null) {
                f += e.a.a.b.b.a.f(2, this.cxb);
            }
            AppMethodBeat.o(94577);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94577);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbc cbc = (cbc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbc.nSX = aVar3.BTU.readString();
                    AppMethodBeat.o(94577);
                    return 0;
                case 2:
                    cbc.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(94577);
                    return 0;
                default:
                    AppMethodBeat.o(94577);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94577);
            return -1;
        }
    }
}
