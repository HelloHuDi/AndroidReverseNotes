package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bku extends a {
    public double vNH;
    public double vNI;
    public double wNP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113788);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.f(1, this.vNI);
            aVar.f(2, this.vNH);
            aVar.f(3, this.wNP);
            AppMethodBeat.o(113788);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 8) + 0) + (e.a.a.b.b.a.fv(2) + 8)) + (e.a.a.b.b.a.fv(3) + 8);
            AppMethodBeat.o(113788);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(113788);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bku bku = (bku) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bku.vNI = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113788);
                    return 0;
                case 2:
                    bku.vNH = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113788);
                    return 0;
                case 3:
                    bku.wNP = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113788);
                    return 0;
                default:
                    AppMethodBeat.o(113788);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113788);
            return -1;
        }
    }
}
