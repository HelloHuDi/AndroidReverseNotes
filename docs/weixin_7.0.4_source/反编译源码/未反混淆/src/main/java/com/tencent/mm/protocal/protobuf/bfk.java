package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class bfk extends a {
    public int wJl;
    public b wJm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(93799);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wJl);
            if (this.wJm != null) {
                aVar.c(2, this.wJm);
            }
            AppMethodBeat.o(93799);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wJl) + 0;
            if (this.wJm != null) {
                bs += e.a.a.b.b.a.b(2, this.wJm);
            }
            AppMethodBeat.o(93799);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(93799);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfk bfk = (bfk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfk.wJl = aVar3.BTU.vd();
                    AppMethodBeat.o(93799);
                    return 0;
                case 2:
                    bfk.wJm = aVar3.BTU.emu();
                    AppMethodBeat.o(93799);
                    return 0;
                default:
                    AppMethodBeat.o(93799);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93799);
            return -1;
        }
    }
}
