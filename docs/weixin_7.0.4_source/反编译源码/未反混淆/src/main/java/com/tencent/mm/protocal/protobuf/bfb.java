package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bfb extends a {
    public int mXP;
    public String vNN;
    public int wIV;
    public int wIW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14733);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNN != null) {
                aVar.e(1, this.vNN);
            }
            aVar.iz(2, this.wIV);
            aVar.iz(3, this.mXP);
            aVar.iz(4, this.wIW);
            AppMethodBeat.o(14733);
            return 0;
        } else if (i == 1) {
            if (this.vNN != null) {
                f = e.a.a.b.b.a.f(1, this.vNN) + 0;
            } else {
                f = 0;
            }
            int bs = ((f + e.a.a.b.b.a.bs(2, this.wIV)) + e.a.a.b.b.a.bs(3, this.mXP)) + e.a.a.b.b.a.bs(4, this.wIW);
            AppMethodBeat.o(14733);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14733);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfb bfb = (bfb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfb.vNN = aVar3.BTU.readString();
                    AppMethodBeat.o(14733);
                    return 0;
                case 2:
                    bfb.wIV = aVar3.BTU.vd();
                    AppMethodBeat.o(14733);
                    return 0;
                case 3:
                    bfb.mXP = aVar3.BTU.vd();
                    AppMethodBeat.o(14733);
                    return 0;
                case 4:
                    bfb.wIW = aVar3.BTU.vd();
                    AppMethodBeat.o(14733);
                    return 0;
                default:
                    AppMethodBeat.o(14733);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14733);
            return -1;
        }
    }
}
