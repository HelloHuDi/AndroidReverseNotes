package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cxk extends a {
    public String nSa;
    public String nickname;
    public int vNm;
    public boolean xsL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115012);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vNm);
            if (this.nSa != null) {
                aVar.e(2, this.nSa);
            }
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            aVar.aO(4, this.xsL);
            AppMethodBeat.o(115012);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vNm) + 0;
            if (this.nSa != null) {
                bs += e.a.a.b.b.a.f(2, this.nSa);
            }
            if (this.nickname != null) {
                bs += e.a.a.b.b.a.f(3, this.nickname);
            }
            bs += e.a.a.b.b.a.fv(4) + 1;
            AppMethodBeat.o(115012);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115012);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxk cxk = (cxk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxk.vNm = aVar3.BTU.vd();
                    AppMethodBeat.o(115012);
                    return 0;
                case 2:
                    cxk.nSa = aVar3.BTU.readString();
                    AppMethodBeat.o(115012);
                    return 0;
                case 3:
                    cxk.nickname = aVar3.BTU.readString();
                    AppMethodBeat.o(115012);
                    return 0;
                case 4:
                    cxk.xsL = aVar3.BTU.ehX();
                    AppMethodBeat.o(115012);
                    return 0;
                default:
                    AppMethodBeat.o(115012);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115012);
            return -1;
        }
    }
}
