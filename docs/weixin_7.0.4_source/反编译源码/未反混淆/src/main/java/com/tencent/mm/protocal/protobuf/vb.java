package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class vb extends a {
    public boolean wcx;
    public boolean wcy = false;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124313);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.wcx);
            aVar.aO(2, this.wcy);
            AppMethodBeat.o(124313);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 1) + 0) + (e.a.a.b.b.a.fv(2) + 1);
            AppMethodBeat.o(124313);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124313);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vb vbVar = (vb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vbVar.wcx = aVar3.BTU.ehX();
                    AppMethodBeat.o(124313);
                    return 0;
                case 2:
                    vbVar.wcy = aVar3.BTU.ehX();
                    AppMethodBeat.o(124313);
                    return 0;
                default:
                    AppMethodBeat.o(124313);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124313);
            return -1;
        }
    }
}
