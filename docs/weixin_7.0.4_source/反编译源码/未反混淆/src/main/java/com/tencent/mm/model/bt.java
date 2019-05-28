package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bt extends a {
    public long eRt;
    public String fns;
    public int key;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72614);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.key);
            if (this.fns != null) {
                aVar.e(2, this.fns);
            }
            aVar.ai(3, this.eRt);
            AppMethodBeat.o(72614);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.key) + 0;
            if (this.fns != null) {
                bs += e.a.a.b.b.a.f(2, this.fns);
            }
            bs += e.a.a.b.b.a.o(3, this.eRt);
            AppMethodBeat.o(72614);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72614);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bt btVar = (bt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btVar.key = aVar3.BTU.vd();
                    AppMethodBeat.o(72614);
                    return 0;
                case 2:
                    btVar.fns = aVar3.BTU.readString();
                    AppMethodBeat.o(72614);
                    return 0;
                case 3:
                    btVar.eRt = aVar3.BTU.ve();
                    AppMethodBeat.o(72614);
                    return 0;
                default:
                    AppMethodBeat.o(72614);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72614);
            return -1;
        }
    }
}
