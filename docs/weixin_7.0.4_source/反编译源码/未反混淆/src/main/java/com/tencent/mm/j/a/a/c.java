package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class c extends a {
    public long eoC;
    public long eoD;
    public long eoE;
    public long eoF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(59617);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.eoC);
            aVar.ai(2, this.eoD);
            aVar.ai(3, this.eoE);
            aVar.ai(4, this.eoF);
            AppMethodBeat.o(59617);
            return 0;
        } else if (i == 1) {
            o = (((e.a.a.b.b.a.o(1, this.eoC) + 0) + e.a.a.b.b.a.o(2, this.eoD)) + e.a.a.b.b.a.o(3, this.eoE)) + e.a.a.b.b.a.o(4, this.eoF);
            AppMethodBeat.o(59617);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(59617);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.eoC = aVar3.BTU.ve();
                    AppMethodBeat.o(59617);
                    return 0;
                case 2:
                    cVar.eoD = aVar3.BTU.ve();
                    AppMethodBeat.o(59617);
                    return 0;
                case 3:
                    cVar.eoE = aVar3.BTU.ve();
                    AppMethodBeat.o(59617);
                    return 0;
                case 4:
                    cVar.eoF = aVar3.BTU.ve();
                    AppMethodBeat.o(59617);
                    return 0;
                default:
                    AppMethodBeat.o(59617);
                    return -1;
            }
        } else {
            AppMethodBeat.o(59617);
            return -1;
        }
    }
}
