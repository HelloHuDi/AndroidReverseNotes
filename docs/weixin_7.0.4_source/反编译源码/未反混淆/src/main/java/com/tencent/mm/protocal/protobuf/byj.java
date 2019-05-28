package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class byj extends a {
    public int Scene;
    public int wXG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11810);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Scene);
            aVar.iz(2, this.wXG);
            AppMethodBeat.o(11810);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.Scene) + 0) + e.a.a.b.b.a.bs(2, this.wXG);
            AppMethodBeat.o(11810);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11810);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byj byj = (byj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byj.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(11810);
                    return 0;
                case 2:
                    byj.wXG = aVar3.BTU.vd();
                    AppMethodBeat.o(11810);
                    return 0;
                default:
                    AppMethodBeat.o(11810);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11810);
            return -1;
        }
    }
}
