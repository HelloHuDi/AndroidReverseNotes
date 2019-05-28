package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class asp extends a {
    public long wwg;
    public int wwh;
    public long wwi;
    public int wwj;
    public long wwk;
    public int wwl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5217);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.wwg);
            aVar.iz(2, this.wwh);
            aVar.ai(3, this.wwi);
            aVar.iz(4, this.wwj);
            aVar.ai(5, this.wwk);
            aVar.iz(6, this.wwl);
            AppMethodBeat.o(5217);
            return 0;
        } else if (i == 1) {
            o = (((((e.a.a.b.b.a.o(1, this.wwg) + 0) + e.a.a.b.b.a.bs(2, this.wwh)) + e.a.a.b.b.a.o(3, this.wwi)) + e.a.a.b.b.a.bs(4, this.wwj)) + e.a.a.b.b.a.o(5, this.wwk)) + e.a.a.b.b.a.bs(6, this.wwl);
            AppMethodBeat.o(5217);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5217);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asp asp = (asp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asp.wwg = aVar3.BTU.ve();
                    AppMethodBeat.o(5217);
                    return 0;
                case 2:
                    asp.wwh = aVar3.BTU.vd();
                    AppMethodBeat.o(5217);
                    return 0;
                case 3:
                    asp.wwi = aVar3.BTU.ve();
                    AppMethodBeat.o(5217);
                    return 0;
                case 4:
                    asp.wwj = aVar3.BTU.vd();
                    AppMethodBeat.o(5217);
                    return 0;
                case 5:
                    asp.wwk = aVar3.BTU.ve();
                    AppMethodBeat.o(5217);
                    return 0;
                case 6:
                    asp.wwl = aVar3.BTU.vd();
                    AppMethodBeat.o(5217);
                    return 0;
                default:
                    AppMethodBeat.o(5217);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5217);
            return -1;
        }
    }
}
