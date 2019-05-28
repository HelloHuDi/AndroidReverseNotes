package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ccl extends a {
    public int guY;
    public String guZ;
    public long gva;
    public int xbQ;
    public int xbR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60070);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.guY);
            if (this.guZ != null) {
                aVar.e(2, this.guZ);
            }
            aVar.ai(3, this.gva);
            aVar.iz(4, this.xbQ);
            aVar.iz(5, this.xbR);
            AppMethodBeat.o(60070);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.guY) + 0;
            if (this.guZ != null) {
                bs += e.a.a.b.b.a.f(2, this.guZ);
            }
            bs = ((bs + e.a.a.b.b.a.o(3, this.gva)) + e.a.a.b.b.a.bs(4, this.xbQ)) + e.a.a.b.b.a.bs(5, this.xbR);
            AppMethodBeat.o(60070);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60070);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccl ccl = (ccl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccl.guY = aVar3.BTU.vd();
                    AppMethodBeat.o(60070);
                    return 0;
                case 2:
                    ccl.guZ = aVar3.BTU.readString();
                    AppMethodBeat.o(60070);
                    return 0;
                case 3:
                    ccl.gva = aVar3.BTU.ve();
                    AppMethodBeat.o(60070);
                    return 0;
                case 4:
                    ccl.xbQ = aVar3.BTU.vd();
                    AppMethodBeat.o(60070);
                    return 0;
                case 5:
                    ccl.xbR = aVar3.BTU.vd();
                    AppMethodBeat.o(60070);
                    return 0;
                default:
                    AppMethodBeat.o(60070);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60070);
            return -1;
        }
    }
}
