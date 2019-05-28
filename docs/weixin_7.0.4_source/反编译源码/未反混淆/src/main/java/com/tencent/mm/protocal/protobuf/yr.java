package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class yr extends a {
    public int score;
    public String vGv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114959);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.score);
            if (this.vGv != null) {
                aVar.e(2, this.vGv);
            }
            AppMethodBeat.o(114959);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.score) + 0;
            if (this.vGv != null) {
                bs += e.a.a.b.b.a.f(2, this.vGv);
            }
            AppMethodBeat.o(114959);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114959);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yr yrVar = (yr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yrVar.score = aVar3.BTU.vd();
                    AppMethodBeat.o(114959);
                    return 0;
                case 2:
                    yrVar.vGv = aVar3.BTU.readString();
                    AppMethodBeat.o(114959);
                    return 0;
                default:
                    AppMethodBeat.o(114959);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114959);
            return -1;
        }
    }
}
