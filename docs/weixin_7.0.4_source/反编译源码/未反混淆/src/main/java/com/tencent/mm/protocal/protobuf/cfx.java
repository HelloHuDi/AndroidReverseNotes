package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cfx extends a {
    public int jCt;
    public int xeW;
    public String xeX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114989);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.xeW);
            if (this.xeX != null) {
                aVar.e(4, this.xeX);
            }
            AppMethodBeat.o(114989);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(2, this.jCt) + 0) + e.a.a.b.b.a.bs(3, this.xeW);
            if (this.xeX != null) {
                bs += e.a.a.b.b.a.f(4, this.xeX);
            }
            AppMethodBeat.o(114989);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114989);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfx cfx = (cfx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    cfx.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(114989);
                    return 0;
                case 3:
                    cfx.xeW = aVar3.BTU.vd();
                    AppMethodBeat.o(114989);
                    return 0;
                case 4:
                    cfx.xeX = aVar3.BTU.readString();
                    AppMethodBeat.o(114989);
                    return 0;
                default:
                    AppMethodBeat.o(114989);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114989);
            return -1;
        }
    }
}
