package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class d extends a {
    public int mZp;
    public int mZq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116989);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.mZp);
            aVar.iz(2, this.mZq);
            AppMethodBeat.o(116989);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.mZp) + 0) + e.a.a.b.b.a.bs(2, this.mZq);
            AppMethodBeat.o(116989);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(116989);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.mZp = aVar3.BTU.vd();
                    AppMethodBeat.o(116989);
                    return 0;
                case 2:
                    dVar.mZq = aVar3.BTU.vd();
                    AppMethodBeat.o(116989);
                    return 0;
                default:
                    AppMethodBeat.o(116989);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116989);
            return -1;
        }
    }
}
