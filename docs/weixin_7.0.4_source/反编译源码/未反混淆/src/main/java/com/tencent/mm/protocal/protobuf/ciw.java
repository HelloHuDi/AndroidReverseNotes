package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class ciw extends a {
    public int uin;
    public b xhL;
    public String xhM;
    public b xhN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10244);
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xhL != null) {
                aVar.c(1, this.xhL);
            }
            if (this.xhM != null) {
                aVar.e(2, this.xhM);
            }
            if (this.xhN != null) {
                aVar.c(3, this.xhN);
            }
            aVar.iz(4, this.uin);
            AppMethodBeat.o(10244);
            return 0;
        } else if (i == 1) {
            if (this.xhL != null) {
                b = e.a.a.b.b.a.b(1, this.xhL) + 0;
            } else {
                b = 0;
            }
            if (this.xhM != null) {
                b += e.a.a.b.b.a.f(2, this.xhM);
            }
            if (this.xhN != null) {
                b += e.a.a.b.b.a.b(3, this.xhN);
            }
            int bs = b + e.a.a.b.b.a.bs(4, this.uin);
            AppMethodBeat.o(10244);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10244);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ciw ciw = (ciw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ciw.xhL = aVar3.BTU.emu();
                    AppMethodBeat.o(10244);
                    return 0;
                case 2:
                    ciw.xhM = aVar3.BTU.readString();
                    AppMethodBeat.o(10244);
                    return 0;
                case 3:
                    ciw.xhN = aVar3.BTU.emu();
                    AppMethodBeat.o(10244);
                    return 0;
                case 4:
                    ciw.uin = aVar3.BTU.vd();
                    AppMethodBeat.o(10244);
                    return 0;
                default:
                    AppMethodBeat.o(10244);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10244);
            return -1;
        }
    }
}
