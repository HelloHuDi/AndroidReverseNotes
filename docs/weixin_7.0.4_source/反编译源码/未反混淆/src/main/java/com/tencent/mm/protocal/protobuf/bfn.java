package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bfn extends a {
    public int vPb;
    public int vZF;
    public int wJq;
    public String wJr;
    public String wJt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60053);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vPb);
            if (this.wJt != null) {
                aVar.e(3, this.wJt);
            }
            aVar.iz(4, this.wJq);
            aVar.iz(5, this.vZF);
            if (this.wJr != null) {
                aVar.e(6, this.wJr);
            }
            AppMethodBeat.o(60053);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vPb) + 0;
            if (this.wJt != null) {
                bs += e.a.a.b.b.a.f(3, this.wJt);
            }
            bs = (bs + e.a.a.b.b.a.bs(4, this.wJq)) + e.a.a.b.b.a.bs(5, this.vZF);
            if (this.wJr != null) {
                bs += e.a.a.b.b.a.f(6, this.wJr);
            }
            AppMethodBeat.o(60053);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60053);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfn bfn = (bfn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfn.vPb = aVar3.BTU.vd();
                    AppMethodBeat.o(60053);
                    return 0;
                case 3:
                    bfn.wJt = aVar3.BTU.readString();
                    AppMethodBeat.o(60053);
                    return 0;
                case 4:
                    bfn.wJq = aVar3.BTU.vd();
                    AppMethodBeat.o(60053);
                    return 0;
                case 5:
                    bfn.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(60053);
                    return 0;
                case 6:
                    bfn.wJr = aVar3.BTU.readString();
                    AppMethodBeat.o(60053);
                    return 0;
                default:
                    AppMethodBeat.o(60053);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60053);
            return -1;
        }
    }
}
