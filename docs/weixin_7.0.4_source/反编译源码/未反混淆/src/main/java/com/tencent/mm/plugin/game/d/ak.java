package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ak extends a {
    public String mZj;
    public int naz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116998);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.naz);
            if (this.mZj != null) {
                aVar.e(2, this.mZj);
            }
            AppMethodBeat.o(116998);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.naz) + 0;
            if (this.mZj != null) {
                bs += e.a.a.b.b.a.f(2, this.mZj);
            }
            AppMethodBeat.o(116998);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(116998);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ak akVar = (ak) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akVar.naz = aVar3.BTU.vd();
                    AppMethodBeat.o(116998);
                    return 0;
                case 2:
                    akVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(116998);
                    return 0;
                default:
                    AppMethodBeat.o(116998);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116998);
            return -1;
        }
    }
}
