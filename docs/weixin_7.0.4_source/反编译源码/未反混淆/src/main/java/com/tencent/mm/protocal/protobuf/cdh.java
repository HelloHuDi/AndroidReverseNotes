package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cdh extends a {
    public int cvd;
    public int qUe;
    public String reJ;
    public String xcV;
    public String xcW;
    public int xcX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94632);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.qUe);
            if (this.xcV != null) {
                aVar.e(2, this.xcV);
            }
            if (this.xcW != null) {
                aVar.e(3, this.xcW);
            }
            aVar.iz(4, this.cvd);
            if (this.reJ != null) {
                aVar.e(5, this.reJ);
            }
            aVar.iz(6, this.xcX);
            AppMethodBeat.o(94632);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.qUe) + 0;
            if (this.xcV != null) {
                bs += e.a.a.b.b.a.f(2, this.xcV);
            }
            if (this.xcW != null) {
                bs += e.a.a.b.b.a.f(3, this.xcW);
            }
            bs += e.a.a.b.b.a.bs(4, this.cvd);
            if (this.reJ != null) {
                bs += e.a.a.b.b.a.f(5, this.reJ);
            }
            bs += e.a.a.b.b.a.bs(6, this.xcX);
            AppMethodBeat.o(94632);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94632);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdh cdh = (cdh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdh.qUe = aVar3.BTU.vd();
                    AppMethodBeat.o(94632);
                    return 0;
                case 2:
                    cdh.xcV = aVar3.BTU.readString();
                    AppMethodBeat.o(94632);
                    return 0;
                case 3:
                    cdh.xcW = aVar3.BTU.readString();
                    AppMethodBeat.o(94632);
                    return 0;
                case 4:
                    cdh.cvd = aVar3.BTU.vd();
                    AppMethodBeat.o(94632);
                    return 0;
                case 5:
                    cdh.reJ = aVar3.BTU.readString();
                    AppMethodBeat.o(94632);
                    return 0;
                case 6:
                    cdh.xcX = aVar3.BTU.vd();
                    AppMethodBeat.o(94632);
                    return 0;
                default:
                    AppMethodBeat.o(94632);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94632);
            return -1;
        }
    }
}
