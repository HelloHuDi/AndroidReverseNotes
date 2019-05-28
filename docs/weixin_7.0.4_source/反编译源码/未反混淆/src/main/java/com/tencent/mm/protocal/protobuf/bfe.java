package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bfe extends a {
    public int kaG;
    public int mXP;
    public String vNN;
    public int wIV;
    public int wIW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14737);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNN != null) {
                aVar.e(1, this.vNN);
            }
            aVar.iz(2, this.wIV);
            aVar.iz(3, this.mXP);
            aVar.iz(4, this.wIW);
            aVar.iz(5, this.kaG);
            AppMethodBeat.o(14737);
            return 0;
        } else if (i == 1) {
            if (this.vNN != null) {
                f = e.a.a.b.b.a.f(1, this.vNN) + 0;
            } else {
                f = 0;
            }
            int bs = (((f + e.a.a.b.b.a.bs(2, this.wIV)) + e.a.a.b.b.a.bs(3, this.mXP)) + e.a.a.b.b.a.bs(4, this.wIW)) + e.a.a.b.b.a.bs(5, this.kaG);
            AppMethodBeat.o(14737);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14737);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfe bfe = (bfe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfe.vNN = aVar3.BTU.readString();
                    AppMethodBeat.o(14737);
                    return 0;
                case 2:
                    bfe.wIV = aVar3.BTU.vd();
                    AppMethodBeat.o(14737);
                    return 0;
                case 3:
                    bfe.mXP = aVar3.BTU.vd();
                    AppMethodBeat.o(14737);
                    return 0;
                case 4:
                    bfe.wIW = aVar3.BTU.vd();
                    AppMethodBeat.o(14737);
                    return 0;
                case 5:
                    bfe.kaG = aVar3.BTU.vd();
                    AppMethodBeat.o(14737);
                    return 0;
                default:
                    AppMethodBeat.o(14737);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14737);
            return -1;
        }
    }
}
