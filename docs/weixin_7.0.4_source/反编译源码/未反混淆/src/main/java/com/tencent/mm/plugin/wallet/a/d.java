package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class d extends a {
    public String pOz;
    public int tmM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56645);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pOz != null) {
                aVar.e(1, this.pOz);
            }
            aVar.iz(2, this.tmM);
            AppMethodBeat.o(56645);
            return 0;
        } else if (i == 1) {
            if (this.pOz != null) {
                f = e.a.a.b.b.a.f(1, this.pOz) + 0;
            } else {
                f = 0;
            }
            int bs = f + e.a.a.b.b.a.bs(2, this.tmM);
            AppMethodBeat.o(56645);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56645);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.pOz = aVar3.BTU.readString();
                    AppMethodBeat.o(56645);
                    return 0;
                case 2:
                    dVar.tmM = aVar3.BTU.vd();
                    AppMethodBeat.o(56645);
                    return 0;
                default:
                    AppMethodBeat.o(56645);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56645);
            return -1;
        }
    }
}
