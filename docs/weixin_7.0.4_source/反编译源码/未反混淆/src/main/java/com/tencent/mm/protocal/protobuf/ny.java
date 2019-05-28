package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ny extends a {
    public int tIE;
    public String ttg;
    public String tzW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89035);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.tzW != null) {
                aVar.e(1, this.tzW);
            }
            if (this.ttg != null) {
                aVar.e(2, this.ttg);
            }
            aVar.iz(3, this.tIE);
            AppMethodBeat.o(89035);
            return 0;
        } else if (i == 1) {
            if (this.tzW != null) {
                f = e.a.a.b.b.a.f(1, this.tzW) + 0;
            } else {
                f = 0;
            }
            if (this.ttg != null) {
                f += e.a.a.b.b.a.f(2, this.ttg);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.tIE);
            AppMethodBeat.o(89035);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89035);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ny nyVar = (ny) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nyVar.tzW = aVar3.BTU.readString();
                    AppMethodBeat.o(89035);
                    return 0;
                case 2:
                    nyVar.ttg = aVar3.BTU.readString();
                    AppMethodBeat.o(89035);
                    return 0;
                case 3:
                    nyVar.tIE = aVar3.BTU.vd();
                    AppMethodBeat.o(89035);
                    return 0;
                default:
                    AppMethodBeat.o(89035);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89035);
            return -1;
        }
    }
}
