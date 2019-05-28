package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cgy extends a {
    public long xfQ;
    public long xfR;
    public int xfS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94635);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.xfQ);
            aVar.ai(2, this.xfR);
            aVar.iz(3, this.xfS);
            AppMethodBeat.o(94635);
            return 0;
        } else if (i == 1) {
            o = ((e.a.a.b.b.a.o(1, this.xfQ) + 0) + e.a.a.b.b.a.o(2, this.xfR)) + e.a.a.b.b.a.bs(3, this.xfS);
            AppMethodBeat.o(94635);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94635);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgy cgy = (cgy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgy.xfQ = aVar3.BTU.ve();
                    AppMethodBeat.o(94635);
                    return 0;
                case 2:
                    cgy.xfR = aVar3.BTU.ve();
                    AppMethodBeat.o(94635);
                    return 0;
                case 3:
                    cgy.xfS = aVar3.BTU.vd();
                    AppMethodBeat.o(94635);
                    return 0;
                default:
                    AppMethodBeat.o(94635);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94635);
            return -1;
        }
    }
}
