package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class arp extends a {
    public int vBA;
    public String vBB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89110);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vBA);
            if (this.vBB != null) {
                aVar.e(2, this.vBB);
            }
            AppMethodBeat.o(89110);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vBA) + 0;
            if (this.vBB != null) {
                bs += e.a.a.b.b.a.f(2, this.vBB);
            }
            AppMethodBeat.o(89110);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89110);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arp arp = (arp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arp.vBA = aVar3.BTU.vd();
                    AppMethodBeat.o(89110);
                    return 0;
                case 2:
                    arp.vBB = aVar3.BTU.readString();
                    AppMethodBeat.o(89110);
                    return 0;
                default:
                    AppMethodBeat.o(89110);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89110);
            return -1;
        }
    }
}
