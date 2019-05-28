package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class g extends a {
    public int FileSize;
    public int jBT;
    public int ptD;
    public String ptE;
    public long ptF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(67926);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ptD);
            if (this.ptE != null) {
                aVar.e(2, this.ptE);
            }
            aVar.iz(3, this.jBT);
            aVar.iz(4, this.FileSize);
            aVar.ai(5, this.ptF);
            AppMethodBeat.o(67926);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ptD) + 0;
            if (this.ptE != null) {
                bs += e.a.a.b.b.a.f(2, this.ptE);
            }
            bs = ((bs + e.a.a.b.b.a.bs(3, this.jBT)) + e.a.a.b.b.a.bs(4, this.FileSize)) + e.a.a.b.b.a.o(5, this.ptF);
            AppMethodBeat.o(67926);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(67926);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(67926);
                    return 0;
                case 2:
                    gVar.ptE = aVar3.BTU.readString();
                    AppMethodBeat.o(67926);
                    return 0;
                case 3:
                    gVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(67926);
                    return 0;
                case 4:
                    gVar.FileSize = aVar3.BTU.vd();
                    AppMethodBeat.o(67926);
                    return 0;
                case 5:
                    gVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(67926);
                    return 0;
                default:
                    AppMethodBeat.o(67926);
                    return -1;
            }
        } else {
            AppMethodBeat.o(67926);
            return -1;
        }
    }
}
