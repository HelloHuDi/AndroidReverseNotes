package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cg extends a {
    public int jCt;
    public int vEp;
    public int vEq;
    public int vEr;
    public int vEs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51362);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vEp);
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.vEq);
            aVar.iz(4, this.vEr);
            aVar.iz(5, this.vEs);
            AppMethodBeat.o(51362);
            return 0;
        } else if (i == 1) {
            bs = ((((e.a.a.b.b.a.bs(1, this.vEp) + 0) + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.vEq)) + e.a.a.b.b.a.bs(4, this.vEr)) + e.a.a.b.b.a.bs(5, this.vEs);
            AppMethodBeat.o(51362);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51362);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cg cgVar = (cg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgVar.vEp = aVar3.BTU.vd();
                    AppMethodBeat.o(51362);
                    return 0;
                case 2:
                    cgVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(51362);
                    return 0;
                case 3:
                    cgVar.vEq = aVar3.BTU.vd();
                    AppMethodBeat.o(51362);
                    return 0;
                case 4:
                    cgVar.vEr = aVar3.BTU.vd();
                    AppMethodBeat.o(51362);
                    return 0;
                case 5:
                    cgVar.vEs = aVar3.BTU.vd();
                    AppMethodBeat.o(51362);
                    return 0;
                default:
                    AppMethodBeat.o(51362);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51362);
            return -1;
        }
    }
}
