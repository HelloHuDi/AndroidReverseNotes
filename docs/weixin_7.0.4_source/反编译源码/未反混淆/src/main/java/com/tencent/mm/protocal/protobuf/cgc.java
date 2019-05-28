package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cgc extends a {
    public String jBB;
    public String vXl;
    public int wPH;
    public int wbH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28662);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            if (this.vXl != null) {
                aVar.e(2, this.vXl);
            }
            aVar.iz(3, this.wPH);
            aVar.iz(4, this.wbH);
            AppMethodBeat.o(28662);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.vXl != null) {
                f += e.a.a.b.b.a.f(2, this.vXl);
            }
            int bs = (f + e.a.a.b.b.a.bs(3, this.wPH)) + e.a.a.b.b.a.bs(4, this.wbH);
            AppMethodBeat.o(28662);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28662);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgc cgc = (cgc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgc.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28662);
                    return 0;
                case 2:
                    cgc.vXl = aVar3.BTU.readString();
                    AppMethodBeat.o(28662);
                    return 0;
                case 3:
                    cgc.wPH = aVar3.BTU.vd();
                    AppMethodBeat.o(28662);
                    return 0;
                case 4:
                    cgc.wbH = aVar3.BTU.vd();
                    AppMethodBeat.o(28662);
                    return 0;
                default:
                    AppMethodBeat.o(28662);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28662);
            return -1;
        }
    }
}
