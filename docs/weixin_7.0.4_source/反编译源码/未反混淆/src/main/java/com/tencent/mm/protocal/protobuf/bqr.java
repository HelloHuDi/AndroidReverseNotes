package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bqr extends a {
    public int wOl;
    public String wTb;
    public String wTc;
    public int wTd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56956);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wOl);
            if (this.wTb != null) {
                aVar.e(2, this.wTb);
            }
            if (this.wTc != null) {
                aVar.e(3, this.wTc);
            }
            aVar.iz(4, this.wTd);
            AppMethodBeat.o(56956);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wOl) + 0;
            if (this.wTb != null) {
                bs += e.a.a.b.b.a.f(2, this.wTb);
            }
            if (this.wTc != null) {
                bs += e.a.a.b.b.a.f(3, this.wTc);
            }
            bs += e.a.a.b.b.a.bs(4, this.wTd);
            AppMethodBeat.o(56956);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56956);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqr bqr = (bqr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqr.wOl = aVar3.BTU.vd();
                    AppMethodBeat.o(56956);
                    return 0;
                case 2:
                    bqr.wTb = aVar3.BTU.readString();
                    AppMethodBeat.o(56956);
                    return 0;
                case 3:
                    bqr.wTc = aVar3.BTU.readString();
                    AppMethodBeat.o(56956);
                    return 0;
                case 4:
                    bqr.wTd = aVar3.BTU.vd();
                    AppMethodBeat.o(56956);
                    return 0;
                default:
                    AppMethodBeat.o(56956);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56956);
            return -1;
        }
    }
}
