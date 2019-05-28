package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class tr extends a {
    public long waM;
    public int waN;
    public int waO;
    public int waP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135597);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.waM);
            aVar.iz(2, this.waN);
            aVar.iz(3, this.waO);
            aVar.iz(4, this.waP);
            AppMethodBeat.o(135597);
            return 0;
        } else if (i == 1) {
            o = (((e.a.a.b.b.a.o(1, this.waM) + 0) + e.a.a.b.b.a.bs(2, this.waN)) + e.a.a.b.b.a.bs(3, this.waO)) + e.a.a.b.b.a.bs(4, this.waP);
            AppMethodBeat.o(135597);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(135597);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tr trVar = (tr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    trVar.waM = aVar3.BTU.ve();
                    AppMethodBeat.o(135597);
                    return 0;
                case 2:
                    trVar.waN = aVar3.BTU.vd();
                    AppMethodBeat.o(135597);
                    return 0;
                case 3:
                    trVar.waO = aVar3.BTU.vd();
                    AppMethodBeat.o(135597);
                    return 0;
                case 4:
                    trVar.waP = aVar3.BTU.vd();
                    AppMethodBeat.o(135597);
                    return 0;
                default:
                    AppMethodBeat.o(135597);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135597);
            return -1;
        }
    }
}
