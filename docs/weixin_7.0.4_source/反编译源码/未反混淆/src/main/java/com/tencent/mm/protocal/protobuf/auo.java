package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class auo extends a {
    public int key;
    public int length;
    public long wyJ;
    public int wyK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28535);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.key);
            aVar.ai(2, this.wyJ);
            aVar.iz(3, this.length);
            aVar.iz(4, this.wyK);
            AppMethodBeat.o(28535);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.key) + 0) + e.a.a.b.b.a.o(2, this.wyJ)) + e.a.a.b.b.a.bs(3, this.length)) + e.a.a.b.b.a.bs(4, this.wyK);
            AppMethodBeat.o(28535);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28535);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            auo auo = (auo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auo.key = aVar3.BTU.vd();
                    AppMethodBeat.o(28535);
                    return 0;
                case 2:
                    auo.wyJ = aVar3.BTU.ve();
                    AppMethodBeat.o(28535);
                    return 0;
                case 3:
                    auo.length = aVar3.BTU.vd();
                    AppMethodBeat.o(28535);
                    return 0;
                case 4:
                    auo.wyK = aVar3.BTU.vd();
                    AppMethodBeat.o(28535);
                    return 0;
                default:
                    AppMethodBeat.o(28535);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28535);
            return -1;
        }
    }
}
