package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cxj extends a {
    public int wzp;
    public String wzy;
    public String xsK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96343);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wzy != null) {
                aVar.e(1, this.wzy);
            }
            aVar.iz(2, this.wzp);
            if (this.xsK != null) {
                aVar.e(3, this.xsK);
            }
            AppMethodBeat.o(96343);
            return 0;
        } else if (i == 1) {
            if (this.wzy != null) {
                f = e.a.a.b.b.a.f(1, this.wzy) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wzp);
            if (this.xsK != null) {
                f += e.a.a.b.b.a.f(3, this.xsK);
            }
            AppMethodBeat.o(96343);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96343);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxj cxj = (cxj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxj.wzy = aVar3.BTU.readString();
                    AppMethodBeat.o(96343);
                    return 0;
                case 2:
                    cxj.wzp = aVar3.BTU.vd();
                    AppMethodBeat.o(96343);
                    return 0;
                case 3:
                    cxj.xsK = aVar3.BTU.readString();
                    AppMethodBeat.o(96343);
                    return 0;
                default:
                    AppMethodBeat.o(96343);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96343);
            return -1;
        }
    }
}
