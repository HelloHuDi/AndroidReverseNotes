package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class acu extends a {
    public boolean wkx;
    public boolean wky;
    public boolean wkz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2541);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.wkx);
            aVar.aO(2, this.wky);
            aVar.aO(3, this.wkz);
            AppMethodBeat.o(2541);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 1) + 0) + (e.a.a.b.b.a.fv(2) + 1)) + (e.a.a.b.b.a.fv(3) + 1);
            AppMethodBeat.o(2541);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(2541);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acu acu = (acu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acu.wkx = aVar3.BTU.ehX();
                    AppMethodBeat.o(2541);
                    return 0;
                case 2:
                    acu.wky = aVar3.BTU.ehX();
                    AppMethodBeat.o(2541);
                    return 0;
                case 3:
                    acu.wkz = aVar3.BTU.ehX();
                    AppMethodBeat.o(2541);
                    return 0;
                default:
                    AppMethodBeat.o(2541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2541);
            return -1;
        }
    }
}
