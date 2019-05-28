package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class csh extends a {
    public b xpD;
    public b xpE;
    public b xpF;
    public b xpG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56997);
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xpD != null) {
                aVar.c(1, this.xpD);
            }
            if (this.xpE != null) {
                aVar.c(2, this.xpE);
            }
            if (this.xpF != null) {
                aVar.c(3, this.xpF);
            }
            if (this.xpG != null) {
                aVar.c(4, this.xpG);
            }
            AppMethodBeat.o(56997);
            return 0;
        } else if (i == 1) {
            if (this.xpD != null) {
                b = e.a.a.b.b.a.b(1, this.xpD) + 0;
            } else {
                b = 0;
            }
            if (this.xpE != null) {
                b += e.a.a.b.b.a.b(2, this.xpE);
            }
            if (this.xpF != null) {
                b += e.a.a.b.b.a.b(3, this.xpF);
            }
            if (this.xpG != null) {
                b += e.a.a.b.b.a.b(4, this.xpG);
            }
            AppMethodBeat.o(56997);
            return b;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56997);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csh csh = (csh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csh.xpD = aVar3.BTU.emu();
                    AppMethodBeat.o(56997);
                    return 0;
                case 2:
                    csh.xpE = aVar3.BTU.emu();
                    AppMethodBeat.o(56997);
                    return 0;
                case 3:
                    csh.xpF = aVar3.BTU.emu();
                    AppMethodBeat.o(56997);
                    return 0;
                case 4:
                    csh.xpG = aVar3.BTU.emu();
                    AppMethodBeat.o(56997);
                    return 0;
                default:
                    AppMethodBeat.o(56997);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56997);
            return -1;
        }
    }
}
