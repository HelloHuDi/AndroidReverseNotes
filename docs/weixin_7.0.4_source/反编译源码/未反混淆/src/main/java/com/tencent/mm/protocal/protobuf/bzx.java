package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bzx extends a {
    public boolean wYS = false;
    public boolean wYT = false;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102390);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.wYS);
            aVar.aO(2, this.wYT);
            AppMethodBeat.o(102390);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 1) + 0) + (e.a.a.b.b.a.fv(2) + 1);
            AppMethodBeat.o(102390);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102390);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzx bzx = (bzx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzx.wYS = aVar3.BTU.ehX();
                    AppMethodBeat.o(102390);
                    return 0;
                case 2:
                    bzx.wYT = aVar3.BTU.ehX();
                    AppMethodBeat.o(102390);
                    return 0;
                default:
                    AppMethodBeat.o(102390);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102390);
            return -1;
        }
    }
}
