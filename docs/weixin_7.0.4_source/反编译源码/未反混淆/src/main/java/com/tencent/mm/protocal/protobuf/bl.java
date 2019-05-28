package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bl extends a {
    public long endTime;
    public int qDF;
    public int qDG;
    public long startTime;
    public float vDD;
    public float vDE;
    public float vDF;
    public long vDG;
    public long vDH;
    public long vDI;
    public long vDJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94496);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.qDF);
            aVar.iz(2, this.qDG);
            aVar.r(3, this.vDD);
            aVar.r(4, this.vDE);
            aVar.r(5, this.vDF);
            aVar.ai(6, this.startTime);
            aVar.ai(7, this.endTime);
            aVar.ai(8, this.vDG);
            aVar.ai(9, this.vDH);
            aVar.ai(10, this.vDI);
            aVar.ai(11, this.vDJ);
            AppMethodBeat.o(94496);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((e.a.a.b.b.a.bs(1, this.qDF) + 0) + e.a.a.b.b.a.bs(2, this.qDG)) + (e.a.a.b.b.a.fv(3) + 4)) + (e.a.a.b.b.a.fv(4) + 4)) + (e.a.a.b.b.a.fv(5) + 4)) + e.a.a.b.b.a.o(6, this.startTime)) + e.a.a.b.b.a.o(7, this.endTime)) + e.a.a.b.b.a.o(8, this.vDG)) + e.a.a.b.b.a.o(9, this.vDH)) + e.a.a.b.b.a.o(10, this.vDI)) + e.a.a.b.b.a.o(11, this.vDJ);
            AppMethodBeat.o(94496);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94496);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bl blVar = (bl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    blVar.qDF = aVar3.BTU.vd();
                    AppMethodBeat.o(94496);
                    return 0;
                case 2:
                    blVar.qDG = aVar3.BTU.vd();
                    AppMethodBeat.o(94496);
                    return 0;
                case 3:
                    blVar.vDD = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94496);
                    return 0;
                case 4:
                    blVar.vDE = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94496);
                    return 0;
                case 5:
                    blVar.vDF = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(94496);
                    return 0;
                case 6:
                    blVar.startTime = aVar3.BTU.ve();
                    AppMethodBeat.o(94496);
                    return 0;
                case 7:
                    blVar.endTime = aVar3.BTU.ve();
                    AppMethodBeat.o(94496);
                    return 0;
                case 8:
                    blVar.vDG = aVar3.BTU.ve();
                    AppMethodBeat.o(94496);
                    return 0;
                case 9:
                    blVar.vDH = aVar3.BTU.ve();
                    AppMethodBeat.o(94496);
                    return 0;
                case 10:
                    blVar.vDI = aVar3.BTU.ve();
                    AppMethodBeat.o(94496);
                    return 0;
                case 11:
                    blVar.vDJ = aVar3.BTU.ve();
                    AppMethodBeat.o(94496);
                    return 0;
                default:
                    AppMethodBeat.o(94496);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94496);
            return -1;
        }
    }
}
