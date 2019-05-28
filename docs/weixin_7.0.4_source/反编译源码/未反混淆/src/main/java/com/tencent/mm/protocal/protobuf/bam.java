package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bam extends a {
    public float bottom;
    public float left;
    public float right;
    public float top;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48885);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.r(1, this.top);
            aVar.r(2, this.bottom);
            aVar.r(3, this.left);
            aVar.r(4, this.right);
            AppMethodBeat.o(48885);
            return 0;
        } else if (i == 1) {
            fv = ((((e.a.a.b.b.a.fv(1) + 4) + 0) + (e.a.a.b.b.a.fv(2) + 4)) + (e.a.a.b.b.a.fv(3) + 4)) + (e.a.a.b.b.a.fv(4) + 4);
            AppMethodBeat.o(48885);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48885);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bam bam = (bam) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bam.top = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(48885);
                    return 0;
                case 2:
                    bam.bottom = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(48885);
                    return 0;
                case 3:
                    bam.left = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(48885);
                    return 0;
                case 4:
                    bam.right = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(48885);
                    return 0;
                default:
                    AppMethodBeat.o(48885);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48885);
            return -1;
        }
    }
}
