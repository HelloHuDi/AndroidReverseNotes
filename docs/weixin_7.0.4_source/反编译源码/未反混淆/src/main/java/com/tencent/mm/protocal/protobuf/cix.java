package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cix extends a {
    public int xhO;
    public int xhP;
    public String xhQ;
    public b xhR;
    public int xhS;
    public int xhT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10245);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xhO);
            aVar.iz(2, this.xhP);
            if (this.xhQ != null) {
                aVar.e(3, this.xhQ);
            }
            if (this.xhR != null) {
                aVar.c(4, this.xhR);
            }
            aVar.iz(5, this.xhS);
            aVar.iz(6, this.xhT);
            AppMethodBeat.o(10245);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.xhO) + 0) + e.a.a.b.b.a.bs(2, this.xhP);
            if (this.xhQ != null) {
                bs += e.a.a.b.b.a.f(3, this.xhQ);
            }
            if (this.xhR != null) {
                bs += e.a.a.b.b.a.b(4, this.xhR);
            }
            bs = (bs + e.a.a.b.b.a.bs(5, this.xhS)) + e.a.a.b.b.a.bs(6, this.xhT);
            AppMethodBeat.o(10245);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10245);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cix cix = (cix) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cix.xhO = aVar3.BTU.vd();
                    AppMethodBeat.o(10245);
                    return 0;
                case 2:
                    cix.xhP = aVar3.BTU.vd();
                    AppMethodBeat.o(10245);
                    return 0;
                case 3:
                    cix.xhQ = aVar3.BTU.readString();
                    AppMethodBeat.o(10245);
                    return 0;
                case 4:
                    cix.xhR = aVar3.BTU.emu();
                    AppMethodBeat.o(10245);
                    return 0;
                case 5:
                    cix.xhS = aVar3.BTU.vd();
                    AppMethodBeat.o(10245);
                    return 0;
                case 6:
                    cix.xhT = aVar3.BTU.vd();
                    AppMethodBeat.o(10245);
                    return 0;
                default:
                    AppMethodBeat.o(10245);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10245);
            return -1;
        }
    }
}
