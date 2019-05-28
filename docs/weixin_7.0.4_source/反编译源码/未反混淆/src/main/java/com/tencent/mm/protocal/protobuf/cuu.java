package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cuu extends a {
    public int Ret;
    public int vHX;
    public long vIs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28762);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Ret);
            aVar.iz(2, this.vHX);
            aVar.ai(3, this.vIs);
            AppMethodBeat.o(28762);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.Ret) + 0) + e.a.a.b.b.a.bs(2, this.vHX)) + e.a.a.b.b.a.o(3, this.vIs);
            AppMethodBeat.o(28762);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28762);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuu cuu = (cuu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuu.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(28762);
                    return 0;
                case 2:
                    cuu.vHX = aVar3.BTU.vd();
                    AppMethodBeat.o(28762);
                    return 0;
                case 3:
                    cuu.vIs = aVar3.BTU.ve();
                    AppMethodBeat.o(28762);
                    return 0;
                default:
                    AppMethodBeat.o(28762);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28762);
            return -1;
        }
    }
}
