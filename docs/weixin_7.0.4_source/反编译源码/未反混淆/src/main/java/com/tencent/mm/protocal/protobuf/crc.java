package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class crc extends a {
    public long xoL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102412);
        int o;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).ai(1, this.xoL);
            AppMethodBeat.o(102412);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.xoL) + 0;
            AppMethodBeat.o(102412);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar); o > 0; o = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, o)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(102412);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            crc crc = (crc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crc.xoL = aVar2.BTU.ve();
                    AppMethodBeat.o(102412);
                    return 0;
                default:
                    AppMethodBeat.o(102412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102412);
            return -1;
        }
    }
}
