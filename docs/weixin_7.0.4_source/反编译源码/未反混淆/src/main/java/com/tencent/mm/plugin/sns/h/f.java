package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class f extends a {
    public int qQn;
    public long qQp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(36829);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.qQp);
            aVar.iz(2, this.qQn);
            AppMethodBeat.o(36829);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.qQp) + 0) + e.a.a.b.b.a.bs(2, this.qQn);
            AppMethodBeat.o(36829);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(36829);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.qQp = aVar3.BTU.ve();
                    AppMethodBeat.o(36829);
                    return 0;
                case 2:
                    fVar.qQn = aVar3.BTU.vd();
                    AppMethodBeat.o(36829);
                    return 0;
                default:
                    AppMethodBeat.o(36829);
                    return -1;
            }
        } else {
            AppMethodBeat.o(36829);
            return -1;
        }
    }
}
