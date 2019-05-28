package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class acp extends a {
    public int fQi = 0;
    public int wkl = 7;
    public long wkm = 0;
    public int wkn = 0;
    public String wko = "";
    public String wkp = "";
    public boolean wkq = false;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73650);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wkl);
            aVar.ai(2, this.wkm);
            aVar.iz(3, this.wkn);
            if (this.wko != null) {
                aVar.e(4, this.wko);
            }
            if (this.wkp != null) {
                aVar.e(5, this.wkp);
            }
            aVar.iz(6, this.fQi);
            aVar.aO(7, this.wkq);
            AppMethodBeat.o(73650);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wkl) + 0) + e.a.a.b.b.a.o(2, this.wkm)) + e.a.a.b.b.a.bs(3, this.wkn);
            if (this.wko != null) {
                bs += e.a.a.b.b.a.f(4, this.wko);
            }
            if (this.wkp != null) {
                bs += e.a.a.b.b.a.f(5, this.wkp);
            }
            bs = (bs + e.a.a.b.b.a.bs(6, this.fQi)) + (e.a.a.b.b.a.fv(7) + 1);
            AppMethodBeat.o(73650);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73650);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acp acp = (acp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acp.wkl = aVar3.BTU.vd();
                    AppMethodBeat.o(73650);
                    return 0;
                case 2:
                    acp.wkm = aVar3.BTU.ve();
                    AppMethodBeat.o(73650);
                    return 0;
                case 3:
                    acp.wkn = aVar3.BTU.vd();
                    AppMethodBeat.o(73650);
                    return 0;
                case 4:
                    acp.wko = aVar3.BTU.readString();
                    AppMethodBeat.o(73650);
                    return 0;
                case 5:
                    acp.wkp = aVar3.BTU.readString();
                    AppMethodBeat.o(73650);
                    return 0;
                case 6:
                    acp.fQi = aVar3.BTU.vd();
                    AppMethodBeat.o(73650);
                    return 0;
                case 7:
                    acp.wkq = aVar3.BTU.ehX();
                    AppMethodBeat.o(73650);
                    return 0;
                default:
                    AppMethodBeat.o(73650);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73650);
            return -1;
        }
    }
}
