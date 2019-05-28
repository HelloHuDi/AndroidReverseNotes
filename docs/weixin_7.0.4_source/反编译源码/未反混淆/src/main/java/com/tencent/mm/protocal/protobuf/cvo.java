package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cvo extends a {
    public String xrA;
    public boolean xrB;
    public int xrC;
    public int xrD;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63695);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xrA != null) {
                aVar.e(1, this.xrA);
            }
            aVar.aO(2, this.xrB);
            aVar.iz(3, this.xrC);
            aVar.iz(4, this.xrD);
            AppMethodBeat.o(63695);
            return 0;
        } else if (i == 1) {
            if (this.xrA != null) {
                f = e.a.a.b.b.a.f(1, this.xrA) + 0;
            } else {
                f = 0;
            }
            int fv = ((f + (e.a.a.b.b.a.fv(2) + 1)) + e.a.a.b.b.a.bs(3, this.xrC)) + e.a.a.b.b.a.bs(4, this.xrD);
            AppMethodBeat.o(63695);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(63695);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvo cvo = (cvo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvo.xrA = aVar3.BTU.readString();
                    AppMethodBeat.o(63695);
                    return 0;
                case 2:
                    cvo.xrB = aVar3.BTU.ehX();
                    AppMethodBeat.o(63695);
                    return 0;
                case 3:
                    cvo.xrC = aVar3.BTU.vd();
                    AppMethodBeat.o(63695);
                    return 0;
                case 4:
                    cvo.xrD = aVar3.BTU.vd();
                    AppMethodBeat.o(63695);
                    return 0;
                default:
                    AppMethodBeat.o(63695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63695);
            return -1;
        }
    }
}
