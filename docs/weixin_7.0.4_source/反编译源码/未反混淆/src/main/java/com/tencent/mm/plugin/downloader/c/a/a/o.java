package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class o extends a {
    public long kKK;
    public int limit;
    public int offset;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35524);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.offset);
            aVar.iz(2, this.limit);
            aVar.ai(3, this.kKK);
            AppMethodBeat.o(35524);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.offset) + 0) + e.a.a.b.b.a.bs(2, this.limit)) + e.a.a.b.b.a.o(3, this.kKK);
            AppMethodBeat.o(35524);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35524);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.offset = aVar3.BTU.vd();
                    AppMethodBeat.o(35524);
                    return 0;
                case 2:
                    oVar.limit = aVar3.BTU.vd();
                    AppMethodBeat.o(35524);
                    return 0;
                case 3:
                    oVar.kKK = aVar3.BTU.ve();
                    AppMethodBeat.o(35524);
                    return 0;
                default:
                    AppMethodBeat.o(35524);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35524);
            return -1;
        }
    }
}
