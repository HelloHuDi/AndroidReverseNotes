package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class jz extends a {
    public int enabled;
    public int jVA;
    public int vGw;
    public int vMN;
    public int vMO;
    public int vMP;
    public int vMQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14711);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.enabled);
            aVar.iz(2, this.vMN);
            aVar.iz(3, this.vMO);
            aVar.iz(4, this.vMP);
            aVar.iz(5, this.vMQ);
            aVar.iz(6, this.jVA);
            aVar.iz(7, this.vGw);
            AppMethodBeat.o(14711);
            return 0;
        } else if (i == 1) {
            bs = ((((((e.a.a.b.b.a.bs(1, this.enabled) + 0) + e.a.a.b.b.a.bs(2, this.vMN)) + e.a.a.b.b.a.bs(3, this.vMO)) + e.a.a.b.b.a.bs(4, this.vMP)) + e.a.a.b.b.a.bs(5, this.vMQ)) + e.a.a.b.b.a.bs(6, this.jVA)) + e.a.a.b.b.a.bs(7, this.vGw);
            AppMethodBeat.o(14711);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14711);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jz jzVar = (jz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jzVar.enabled = aVar3.BTU.vd();
                    AppMethodBeat.o(14711);
                    return 0;
                case 2:
                    jzVar.vMN = aVar3.BTU.vd();
                    AppMethodBeat.o(14711);
                    return 0;
                case 3:
                    jzVar.vMO = aVar3.BTU.vd();
                    AppMethodBeat.o(14711);
                    return 0;
                case 4:
                    jzVar.vMP = aVar3.BTU.vd();
                    AppMethodBeat.o(14711);
                    return 0;
                case 5:
                    jzVar.vMQ = aVar3.BTU.vd();
                    AppMethodBeat.o(14711);
                    return 0;
                case 6:
                    jzVar.jVA = aVar3.BTU.vd();
                    AppMethodBeat.o(14711);
                    return 0;
                case 7:
                    jzVar.vGw = aVar3.BTU.vd();
                    AppMethodBeat.o(14711);
                    return 0;
                default:
                    AppMethodBeat.o(14711);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14711);
            return -1;
        }
    }
}
