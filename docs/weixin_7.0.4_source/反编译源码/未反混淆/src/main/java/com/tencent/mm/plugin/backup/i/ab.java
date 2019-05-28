package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class ab extends a {
    public long jBS;
    public int jBh;
    public b jBi;
    public int jCI;
    public int jCJ;
    public long jCK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18077);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jBh);
            if (this.jBi != null) {
                aVar.c(2, this.jBi);
            }
            aVar.iz(3, this.jCI);
            aVar.iz(4, this.jCJ);
            aVar.ai(5, this.jCK);
            aVar.ai(6, this.jBS);
            AppMethodBeat.o(18077);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jBh) + 0;
            if (this.jBi != null) {
                bs += e.a.a.b.b.a.b(2, this.jBi);
            }
            bs = (((bs + e.a.a.b.b.a.bs(3, this.jCI)) + e.a.a.b.b.a.bs(4, this.jCJ)) + e.a.a.b.b.a.o(5, this.jCK)) + e.a.a.b.b.a.o(6, this.jBS);
            AppMethodBeat.o(18077);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(18077);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ab abVar = (ab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abVar.jBh = aVar3.BTU.vd();
                    AppMethodBeat.o(18077);
                    return 0;
                case 2:
                    abVar.jBi = aVar3.BTU.emu();
                    AppMethodBeat.o(18077);
                    return 0;
                case 3:
                    abVar.jCI = aVar3.BTU.vd();
                    AppMethodBeat.o(18077);
                    return 0;
                case 4:
                    abVar.jCJ = aVar3.BTU.vd();
                    AppMethodBeat.o(18077);
                    return 0;
                case 5:
                    abVar.jCK = aVar3.BTU.ve();
                    AppMethodBeat.o(18077);
                    return 0;
                case 6:
                    abVar.jBS = aVar3.BTU.ve();
                    AppMethodBeat.o(18077);
                    return 0;
                default:
                    AppMethodBeat.o(18077);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18077);
            return -1;
        }
    }
}
