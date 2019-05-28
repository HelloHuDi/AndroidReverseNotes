package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class go extends a {
    public long endTime;
    public long startTime;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28324);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.startTime);
            aVar.ai(2, this.endTime);
            AppMethodBeat.o(28324);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.startTime) + 0) + e.a.a.b.b.a.o(2, this.endTime);
            AppMethodBeat.o(28324);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28324);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            go goVar = (go) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    goVar.startTime = aVar3.BTU.ve();
                    AppMethodBeat.o(28324);
                    return 0;
                case 2:
                    goVar.endTime = aVar3.BTU.ve();
                    AppMethodBeat.o(28324);
                    return 0;
                default:
                    AppMethodBeat.o(28324);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28324);
            return -1;
        }
    }
}
