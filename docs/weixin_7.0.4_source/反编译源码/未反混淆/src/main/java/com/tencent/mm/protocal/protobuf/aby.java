package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aby extends a {
    public long endTime = 0;
    public long startTime = 0;
    public int wjO = 0;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73649);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.startTime);
            aVar.ai(2, this.endTime);
            aVar.iz(3, this.wjO);
            AppMethodBeat.o(73649);
            return 0;
        } else if (i == 1) {
            o = ((e.a.a.b.b.a.o(1, this.startTime) + 0) + e.a.a.b.b.a.o(2, this.endTime)) + e.a.a.b.b.a.bs(3, this.wjO);
            AppMethodBeat.o(73649);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73649);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aby aby = (aby) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aby.startTime = aVar3.BTU.ve();
                    AppMethodBeat.o(73649);
                    return 0;
                case 2:
                    aby.endTime = aVar3.BTU.ve();
                    AppMethodBeat.o(73649);
                    return 0;
                case 3:
                    aby.wjO = aVar3.BTU.vd();
                    AppMethodBeat.o(73649);
                    return 0;
                default:
                    AppMethodBeat.o(73649);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73649);
            return -1;
        }
    }
}
