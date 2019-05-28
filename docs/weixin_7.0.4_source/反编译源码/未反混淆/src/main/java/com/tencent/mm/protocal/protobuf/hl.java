package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class hl extends a {
    public int Scene;
    public int luF;
    public b vKb;
    public b vKc;
    public int vKd;
    public b vKe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58892);
        int b;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKb != null) {
                aVar.c(1, this.vKb);
            }
            aVar.iz(2, this.luF);
            if (this.vKc != null) {
                aVar.c(3, this.vKc);
            }
            aVar.iz(4, this.vKd);
            if (this.vKe != null) {
                aVar.c(5, this.vKe);
            }
            aVar.iz(6, this.Scene);
            AppMethodBeat.o(58892);
            return 0;
        } else if (i == 1) {
            if (this.vKb != null) {
                b = e.a.a.b.b.a.b(1, this.vKb) + 0;
            } else {
                b = 0;
            }
            b += e.a.a.b.b.a.bs(2, this.luF);
            if (this.vKc != null) {
                b += e.a.a.b.b.a.b(3, this.vKc);
            }
            b += e.a.a.b.b.a.bs(4, this.vKd);
            if (this.vKe != null) {
                b += e.a.a.b.b.a.b(5, this.vKe);
            }
            int bs = b + e.a.a.b.b.a.bs(6, this.Scene);
            AppMethodBeat.o(58892);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58892);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hl hlVar = (hl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hlVar.vKb = aVar3.BTU.emu();
                    AppMethodBeat.o(58892);
                    return 0;
                case 2:
                    hlVar.luF = aVar3.BTU.vd();
                    AppMethodBeat.o(58892);
                    return 0;
                case 3:
                    hlVar.vKc = aVar3.BTU.emu();
                    AppMethodBeat.o(58892);
                    return 0;
                case 4:
                    hlVar.vKd = aVar3.BTU.vd();
                    AppMethodBeat.o(58892);
                    return 0;
                case 5:
                    hlVar.vKe = aVar3.BTU.emu();
                    AppMethodBeat.o(58892);
                    return 0;
                case 6:
                    hlVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(58892);
                    return 0;
                default:
                    AppMethodBeat.o(58892);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58892);
            return -1;
        }
    }
}
