package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cvv extends a {
    public String csB;
    public int vOP;
    public String xrN;
    public String xrO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10250);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            aVar.iz(2, this.vOP);
            if (this.xrN != null) {
                aVar.e(3, this.xrN);
            }
            if (this.xrO != null) {
                aVar.e(4, this.xrO);
            }
            AppMethodBeat.o(10250);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vOP);
            if (this.xrN != null) {
                f += e.a.a.b.b.a.f(3, this.xrN);
            }
            if (this.xrO != null) {
                f += e.a.a.b.b.a.f(4, this.xrO);
            }
            AppMethodBeat.o(10250);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10250);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvv cvv = (cvv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvv.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(10250);
                    return 0;
                case 2:
                    cvv.vOP = aVar3.BTU.vd();
                    AppMethodBeat.o(10250);
                    return 0;
                case 3:
                    cvv.xrN = aVar3.BTU.readString();
                    AppMethodBeat.o(10250);
                    return 0;
                case 4:
                    cvv.xrO = aVar3.BTU.readString();
                    AppMethodBeat.o(10250);
                    return 0;
                default:
                    AppMethodBeat.o(10250);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10250);
            return -1;
        }
    }
}
