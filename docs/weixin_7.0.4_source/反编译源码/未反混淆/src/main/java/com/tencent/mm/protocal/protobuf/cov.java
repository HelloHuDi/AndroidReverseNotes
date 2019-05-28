package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cov extends a {
    public long wen;
    public long xeF;
    public int xmD;
    public int xmE;
    public int xmF;
    public int xmG;
    public b xmH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135450);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.xeF);
            aVar.ai(2, this.wen);
            aVar.iz(3, this.xmD);
            aVar.iz(4, this.xmE);
            aVar.iz(5, this.xmF);
            aVar.iz(6, this.xmG);
            if (this.xmH != null) {
                aVar.c(7, this.xmH);
            }
            AppMethodBeat.o(135450);
            return 0;
        } else if (i == 1) {
            o = (((((e.a.a.b.b.a.o(1, this.xeF) + 0) + e.a.a.b.b.a.o(2, this.wen)) + e.a.a.b.b.a.bs(3, this.xmD)) + e.a.a.b.b.a.bs(4, this.xmE)) + e.a.a.b.b.a.bs(5, this.xmF)) + e.a.a.b.b.a.bs(6, this.xmG);
            if (this.xmH != null) {
                o += e.a.a.b.b.a.b(7, this.xmH);
            }
            AppMethodBeat.o(135450);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(135450);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cov cov = (cov) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cov.xeF = aVar3.BTU.ve();
                    AppMethodBeat.o(135450);
                    return 0;
                case 2:
                    cov.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(135450);
                    return 0;
                case 3:
                    cov.xmD = aVar3.BTU.vd();
                    AppMethodBeat.o(135450);
                    return 0;
                case 4:
                    cov.xmE = aVar3.BTU.vd();
                    AppMethodBeat.o(135450);
                    return 0;
                case 5:
                    cov.xmF = aVar3.BTU.vd();
                    AppMethodBeat.o(135450);
                    return 0;
                case 6:
                    cov.xmG = aVar3.BTU.vd();
                    AppMethodBeat.o(135450);
                    return 0;
                case 7:
                    cov.xmH = aVar3.BTU.emu();
                    AppMethodBeat.o(135450);
                    return 0;
                default:
                    AppMethodBeat.o(135450);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135450);
            return -1;
        }
    }
}
