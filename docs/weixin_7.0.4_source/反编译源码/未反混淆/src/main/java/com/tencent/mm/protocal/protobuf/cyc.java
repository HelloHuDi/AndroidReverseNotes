package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cyc extends a {
    public int Scene;
    public int vMG;
    public int wzF;
    public int xtw;
    public int xtx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96348);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wzF);
            aVar.iz(2, this.vMG);
            aVar.iz(3, this.xtw);
            aVar.iz(4, this.Scene);
            aVar.iz(10, this.xtx);
            AppMethodBeat.o(96348);
            return 0;
        } else if (i == 1) {
            bs = ((((e.a.a.b.b.a.bs(1, this.wzF) + 0) + e.a.a.b.b.a.bs(2, this.vMG)) + e.a.a.b.b.a.bs(3, this.xtw)) + e.a.a.b.b.a.bs(4, this.Scene)) + e.a.a.b.b.a.bs(10, this.xtx);
            AppMethodBeat.o(96348);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96348);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cyc cyc = (cyc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyc.wzF = aVar3.BTU.vd();
                    AppMethodBeat.o(96348);
                    return 0;
                case 2:
                    cyc.vMG = aVar3.BTU.vd();
                    AppMethodBeat.o(96348);
                    return 0;
                case 3:
                    cyc.xtw = aVar3.BTU.vd();
                    AppMethodBeat.o(96348);
                    return 0;
                case 4:
                    cyc.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(96348);
                    return 0;
                case 10:
                    cyc.xtx = aVar3.BTU.vd();
                    AppMethodBeat.o(96348);
                    return 0;
                default:
                    AppMethodBeat.o(96348);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96348);
            return -1;
        }
    }
}
