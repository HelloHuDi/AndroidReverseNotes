package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class yd extends a {
    public int Ret;
    public long ptF;
    public int ptw;
    public int ptx;
    public String wdO;
    public int wdU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(53872);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Ret);
            aVar.iz(2, this.ptx);
            aVar.iz(3, this.ptw);
            if (this.wdO != null) {
                aVar.e(4, this.wdO);
            }
            aVar.iz(5, this.wdU);
            aVar.ai(6, this.ptF);
            AppMethodBeat.o(53872);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.Ret) + 0) + e.a.a.b.b.a.bs(2, this.ptx)) + e.a.a.b.b.a.bs(3, this.ptw);
            if (this.wdO != null) {
                bs += e.a.a.b.b.a.f(4, this.wdO);
            }
            bs = (bs + e.a.a.b.b.a.bs(5, this.wdU)) + e.a.a.b.b.a.o(6, this.ptF);
            AppMethodBeat.o(53872);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(53872);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yd ydVar = (yd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ydVar.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(53872);
                    return 0;
                case 2:
                    ydVar.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(53872);
                    return 0;
                case 3:
                    ydVar.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(53872);
                    return 0;
                case 4:
                    ydVar.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(53872);
                    return 0;
                case 5:
                    ydVar.wdU = aVar3.BTU.vd();
                    AppMethodBeat.o(53872);
                    return 0;
                case 6:
                    ydVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(53872);
                    return 0;
                default:
                    AppMethodBeat.o(53872);
                    return -1;
            }
        } else {
            AppMethodBeat.o(53872);
            return -1;
        }
    }
}
