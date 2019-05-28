package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cvn extends a {
    public boolean xry;
    public boolean xrz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63694);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.xry);
            aVar.aO(2, this.xrz);
            AppMethodBeat.o(63694);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 1) + 0) + (e.a.a.b.b.a.fv(2) + 1);
            AppMethodBeat.o(63694);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(63694);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvn cvn = (cvn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvn.xry = aVar3.BTU.ehX();
                    AppMethodBeat.o(63694);
                    return 0;
                case 2:
                    cvn.xrz = aVar3.BTU.ehX();
                    AppMethodBeat.o(63694);
                    return 0;
                default:
                    AppMethodBeat.o(63694);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63694);
            return -1;
        }
    }
}
