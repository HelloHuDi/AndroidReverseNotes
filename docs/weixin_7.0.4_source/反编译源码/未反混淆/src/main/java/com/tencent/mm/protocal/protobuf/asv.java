package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class asv extends a {
    public b vKc;
    public b vKe;
    public b wwF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28521);
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKe != null) {
                aVar.c(1, this.vKe);
            }
            if (this.vKc != null) {
                aVar.c(2, this.vKc);
            }
            if (this.wwF != null) {
                aVar.c(3, this.wwF);
            }
            AppMethodBeat.o(28521);
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
            if (this.wwF != null) {
                b += e.a.a.b.b.a.b(3, this.wwF);
            }
            AppMethodBeat.o(28521);
            return b;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28521);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asv asv = (asv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asv.vKe = aVar3.BTU.emu();
                    AppMethodBeat.o(28521);
                    return 0;
                case 2:
                    asv.vKc = aVar3.BTU.emu();
                    AppMethodBeat.o(28521);
                    return 0;
                case 3:
                    asv.wwF = aVar3.BTU.emu();
                    AppMethodBeat.o(28521);
                    return 0;
                default:
                    AppMethodBeat.o(28521);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28521);
            return -1;
        }
    }
}
