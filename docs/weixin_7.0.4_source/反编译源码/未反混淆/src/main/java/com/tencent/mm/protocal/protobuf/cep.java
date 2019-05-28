package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cep extends a {
    public long xdq;
    public int xel;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56532);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.xdq);
            aVar.iz(2, this.xel);
            AppMethodBeat.o(56532);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.xdq) + 0) + e.a.a.b.b.a.bs(2, this.xel);
            AppMethodBeat.o(56532);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56532);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cep cep = (cep) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cep.xdq = aVar3.BTU.ve();
                    AppMethodBeat.o(56532);
                    return 0;
                case 2:
                    cep.xel = aVar3.BTU.vd();
                    AppMethodBeat.o(56532);
                    return 0;
                default:
                    AppMethodBeat.o(56532);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56532);
            return -1;
        }
    }
}
