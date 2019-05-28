package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bl extends a {
    public long cmn;
    public long cvx;
    public long hzT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60210);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.cvx);
            aVar.ai(2, this.hzT);
            aVar.ai(3, this.cmn);
            AppMethodBeat.o(60210);
            return 0;
        } else if (i == 1) {
            o = ((e.a.a.b.b.a.o(1, this.cvx) + 0) + e.a.a.b.b.a.o(2, this.hzT)) + e.a.a.b.b.a.o(3, this.cmn);
            AppMethodBeat.o(60210);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60210);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bl blVar = (bl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    blVar.cvx = aVar3.BTU.ve();
                    AppMethodBeat.o(60210);
                    return 0;
                case 2:
                    blVar.hzT = aVar3.BTU.ve();
                    AppMethodBeat.o(60210);
                    return 0;
                case 3:
                    blVar.cmn = aVar3.BTU.ve();
                    AppMethodBeat.o(60210);
                    return 0;
                default:
                    AppMethodBeat.o(60210);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60210);
            return -1;
        }
    }
}
