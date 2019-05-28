package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cua extends a {
    public long vIs;
    public boolean xqC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28738);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.vIs);
            aVar.aO(2, this.xqC);
            AppMethodBeat.o(28738);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.vIs) + 0) + (e.a.a.b.b.a.fv(2) + 1);
            AppMethodBeat.o(28738);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28738);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cua cua = (cua) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cua.vIs = aVar3.BTU.ve();
                    AppMethodBeat.o(28738);
                    return 0;
                case 2:
                    cua.xqC = aVar3.BTU.ehX();
                    AppMethodBeat.o(28738);
                    return 0;
                default:
                    AppMethodBeat.o(28738);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28738);
            return -1;
        }
    }
}
