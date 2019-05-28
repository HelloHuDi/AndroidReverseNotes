package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class axk extends a {
    public int wBs;
    public String wBt;
    public int wkB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80637);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wBs);
            if (this.wBt != null) {
                aVar.e(2, this.wBt);
            }
            aVar.iz(3, this.wkB);
            AppMethodBeat.o(80637);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wBs) + 0;
            if (this.wBt != null) {
                bs += e.a.a.b.b.a.f(2, this.wBt);
            }
            bs += e.a.a.b.b.a.bs(3, this.wkB);
            AppMethodBeat.o(80637);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80637);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axk axk = (axk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axk.wBs = aVar3.BTU.vd();
                    AppMethodBeat.o(80637);
                    return 0;
                case 2:
                    axk.wBt = aVar3.BTU.readString();
                    AppMethodBeat.o(80637);
                    return 0;
                case 3:
                    axk.wkB = aVar3.BTU.vd();
                    AppMethodBeat.o(80637);
                    return 0;
                default:
                    AppMethodBeat.o(80637);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80637);
            return -1;
        }
    }
}
