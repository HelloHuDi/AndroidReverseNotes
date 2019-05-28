package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class byy extends a {
    public String cMC;
    public int kfy;
    public int vWx;
    public long wYf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89141);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cMC != null) {
                aVar.e(1, this.cMC);
            }
            aVar.iz(2, this.kfy);
            aVar.iz(3, this.vWx);
            aVar.ai(4, this.wYf);
            AppMethodBeat.o(89141);
            return 0;
        } else if (i == 1) {
            if (this.cMC != null) {
                f = e.a.a.b.b.a.f(1, this.cMC) + 0;
            } else {
                f = 0;
            }
            int bs = ((f + e.a.a.b.b.a.bs(2, this.kfy)) + e.a.a.b.b.a.bs(3, this.vWx)) + e.a.a.b.b.a.o(4, this.wYf);
            AppMethodBeat.o(89141);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89141);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byy byy = (byy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byy.cMC = aVar3.BTU.readString();
                    AppMethodBeat.o(89141);
                    return 0;
                case 2:
                    byy.kfy = aVar3.BTU.vd();
                    AppMethodBeat.o(89141);
                    return 0;
                case 3:
                    byy.vWx = aVar3.BTU.vd();
                    AppMethodBeat.o(89141);
                    return 0;
                case 4:
                    byy.wYf = aVar3.BTU.ve();
                    AppMethodBeat.o(89141);
                    return 0;
                default:
                    AppMethodBeat.o(89141);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89141);
            return -1;
        }
    }
}
