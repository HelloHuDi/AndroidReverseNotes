package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cvw extends a {
    public String cvZ;
    public String url;
    public int vOO;
    public int xrP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96317);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xrP);
            aVar.iz(2, this.vOO);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.cvZ != null) {
                aVar.e(4, this.cvZ);
            }
            AppMethodBeat.o(96317);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.xrP) + 0) + e.a.a.b.b.a.bs(2, this.vOO);
            if (this.url != null) {
                bs += e.a.a.b.b.a.f(3, this.url);
            }
            if (this.cvZ != null) {
                bs += e.a.a.b.b.a.f(4, this.cvZ);
            }
            AppMethodBeat.o(96317);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96317);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvw cvw = (cvw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvw.xrP = aVar3.BTU.vd();
                    AppMethodBeat.o(96317);
                    return 0;
                case 2:
                    cvw.vOO = aVar3.BTU.vd();
                    AppMethodBeat.o(96317);
                    return 0;
                case 3:
                    cvw.url = aVar3.BTU.readString();
                    AppMethodBeat.o(96317);
                    return 0;
                case 4:
                    cvw.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(96317);
                    return 0;
                default:
                    AppMethodBeat.o(96317);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96317);
            return -1;
        }
    }
}
