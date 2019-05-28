package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bml extends a {
    public int luT;
    public String luU;
    public int nwA;
    public String nwB;
    public int wPq;
    public int wPr;
    public int wPs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28595);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wPr);
            aVar.iz(2, this.wPs);
            aVar.iz(3, this.wPq);
            aVar.iz(4, this.luT);
            if (this.luU != null) {
                aVar.e(5, this.luU);
            }
            aVar.iz(6, this.nwA);
            if (this.nwB != null) {
                aVar.e(7, this.nwB);
            }
            AppMethodBeat.o(28595);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wPr) + 0) + e.a.a.b.b.a.bs(2, this.wPs)) + e.a.a.b.b.a.bs(3, this.wPq)) + e.a.a.b.b.a.bs(4, this.luT);
            if (this.luU != null) {
                bs += e.a.a.b.b.a.f(5, this.luU);
            }
            bs += e.a.a.b.b.a.bs(6, this.nwA);
            if (this.nwB != null) {
                bs += e.a.a.b.b.a.f(7, this.nwB);
            }
            AppMethodBeat.o(28595);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28595);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bml bml = (bml) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bml.wPr = aVar3.BTU.vd();
                    AppMethodBeat.o(28595);
                    return 0;
                case 2:
                    bml.wPs = aVar3.BTU.vd();
                    AppMethodBeat.o(28595);
                    return 0;
                case 3:
                    bml.wPq = aVar3.BTU.vd();
                    AppMethodBeat.o(28595);
                    return 0;
                case 4:
                    bml.luT = aVar3.BTU.vd();
                    AppMethodBeat.o(28595);
                    return 0;
                case 5:
                    bml.luU = aVar3.BTU.readString();
                    AppMethodBeat.o(28595);
                    return 0;
                case 6:
                    bml.nwA = aVar3.BTU.vd();
                    AppMethodBeat.o(28595);
                    return 0;
                case 7:
                    bml.nwB = aVar3.BTU.readString();
                    AppMethodBeat.o(28595);
                    return 0;
                default:
                    AppMethodBeat.o(28595);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28595);
            return -1;
        }
    }
}
