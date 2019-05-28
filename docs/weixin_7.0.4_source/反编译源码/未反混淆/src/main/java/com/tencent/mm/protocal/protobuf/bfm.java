package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bfm extends a {
    public int vPb;
    public int vZF;
    public int wJq;
    public String wJr;
    public String wJs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28564);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vPb);
            if (this.wJs != null) {
                aVar.e(3, this.wJs);
            }
            aVar.iz(4, this.wJq);
            aVar.iz(5, this.vZF);
            if (this.wJr != null) {
                aVar.e(6, this.wJr);
            }
            AppMethodBeat.o(28564);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vPb) + 0;
            if (this.wJs != null) {
                bs += e.a.a.b.b.a.f(3, this.wJs);
            }
            bs = (bs + e.a.a.b.b.a.bs(4, this.wJq)) + e.a.a.b.b.a.bs(5, this.vZF);
            if (this.wJr != null) {
                bs += e.a.a.b.b.a.f(6, this.wJr);
            }
            AppMethodBeat.o(28564);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28564);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfm bfm = (bfm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfm.vPb = aVar3.BTU.vd();
                    AppMethodBeat.o(28564);
                    return 0;
                case 3:
                    bfm.wJs = aVar3.BTU.readString();
                    AppMethodBeat.o(28564);
                    return 0;
                case 4:
                    bfm.wJq = aVar3.BTU.vd();
                    AppMethodBeat.o(28564);
                    return 0;
                case 5:
                    bfm.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(28564);
                    return 0;
                case 6:
                    bfm.wJr = aVar3.BTU.readString();
                    AppMethodBeat.o(28564);
                    return 0;
                default:
                    AppMethodBeat.o(28564);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28564);
            return -1;
        }
    }
}
