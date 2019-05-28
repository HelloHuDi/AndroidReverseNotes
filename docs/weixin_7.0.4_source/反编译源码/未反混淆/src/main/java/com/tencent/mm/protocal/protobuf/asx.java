package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class asx extends a {
    public int nbk;
    public b vKc;
    public b vKe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11772);
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKe != null) {
                aVar.c(1, this.vKe);
            }
            if (this.vKc != null) {
                aVar.c(2, this.vKc);
            }
            aVar.iz(3, this.nbk);
            AppMethodBeat.o(11772);
            return 0;
        } else if (i == 1) {
            if (this.vKe != null) {
                b = e.a.a.b.b.a.b(1, this.vKe) + 0;
            } else {
                b = 0;
            }
            if (this.vKc != null) {
                b += e.a.a.b.b.a.b(2, this.vKc);
            }
            int bs = b + e.a.a.b.b.a.bs(3, this.nbk);
            AppMethodBeat.o(11772);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11772);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asx asx = (asx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asx.vKe = aVar3.BTU.emu();
                    AppMethodBeat.o(11772);
                    return 0;
                case 2:
                    asx.vKc = aVar3.BTU.emu();
                    AppMethodBeat.o(11772);
                    return 0;
                case 3:
                    asx.nbk = aVar3.BTU.vd();
                    AppMethodBeat.o(11772);
                    return 0;
                default:
                    AppMethodBeat.o(11772);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11772);
            return -1;
        }
    }
}
