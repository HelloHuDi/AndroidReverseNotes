package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class e extends a {
    public int erD;
    public String nWy;
    public String nWz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56608);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.erD);
            if (this.nWy != null) {
                aVar.e(2, this.nWy);
            }
            if (this.nWz != null) {
                aVar.e(3, this.nWz);
            }
            AppMethodBeat.o(56608);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.erD) + 0;
            if (this.nWy != null) {
                bs += e.a.a.b.b.a.f(2, this.nWy);
            }
            if (this.nWz != null) {
                bs += e.a.a.b.b.a.f(3, this.nWz);
            }
            AppMethodBeat.o(56608);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56608);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.erD = aVar3.BTU.vd();
                    AppMethodBeat.o(56608);
                    return 0;
                case 2:
                    eVar.nWy = aVar3.BTU.readString();
                    AppMethodBeat.o(56608);
                    return 0;
                case 3:
                    eVar.nWz = aVar3.BTU.readString();
                    AppMethodBeat.o(56608);
                    return 0;
                default:
                    AppMethodBeat.o(56608);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56608);
            return -1;
        }
    }
}
