package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aec extends a {
    public String fKh;
    public int jCt;
    public int vFs;
    public int wmf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96220);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fKh != null) {
                aVar.e(1, this.fKh);
            }
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.vFs);
            aVar.iz(4, this.wmf);
            AppMethodBeat.o(96220);
            return 0;
        } else if (i == 1) {
            if (this.fKh != null) {
                f = e.a.a.b.b.a.f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            int bs = ((f + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.vFs)) + e.a.a.b.b.a.bs(4, this.wmf);
            AppMethodBeat.o(96220);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96220);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aec aec = (aec) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aec.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(96220);
                    return 0;
                case 2:
                    aec.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(96220);
                    return 0;
                case 3:
                    aec.vFs = aVar3.BTU.vd();
                    AppMethodBeat.o(96220);
                    return 0;
                case 4:
                    aec.wmf = aVar3.BTU.vd();
                    AppMethodBeat.o(96220);
                    return 0;
                default:
                    AppMethodBeat.o(96220);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96220);
            return -1;
        }
    }
}
