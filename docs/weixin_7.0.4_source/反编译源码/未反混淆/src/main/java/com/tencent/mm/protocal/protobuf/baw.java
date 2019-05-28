package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class baw extends a {
    public float wFx;
    public float wFy;
    public float wFz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94542);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.r(1, this.wFx);
            aVar.r(2, this.wFy);
            aVar.r(3, this.wFz);
            AppMethodBeat.o(94542);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 4) + 0) + (e.a.a.b.b.a.fv(2) + 4)) + (e.a.a.b.b.a.fv(3) + 4);
            AppMethodBeat.o(94542);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94542);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            baw baw = (baw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    baw.wFx = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94542);
                    return 0;
                case 2:
                    baw.wFy = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94542);
                    return 0;
                case 3:
                    baw.wFz = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94542);
                    return 0;
                default:
                    AppMethodBeat.o(94542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94542);
            return -1;
        }
    }
}
