package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ahx extends a {
    public double vNH;
    public double vNI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28432);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.f(1, this.vNH);
            aVar.f(2, this.vNI);
            AppMethodBeat.o(28432);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 8) + 0) + (e.a.a.b.b.a.fv(2) + 8);
            AppMethodBeat.o(28432);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28432);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahx ahx = (ahx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ahx.vNH = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(28432);
                    return 0;
                case 2:
                    ahx.vNI = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(28432);
                    return 0;
                default:
                    AppMethodBeat.o(28432);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28432);
            return -1;
        }
    }
}
