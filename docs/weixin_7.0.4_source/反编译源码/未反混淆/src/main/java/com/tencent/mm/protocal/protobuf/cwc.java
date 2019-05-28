package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cwc extends a {
    public int xrX;
    public String xrY;
    public String xrZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11825);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xrX);
            if (this.xrY != null) {
                aVar.e(2, this.xrY);
            }
            if (this.xrZ != null) {
                aVar.e(3, this.xrZ);
            }
            AppMethodBeat.o(11825);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xrX) + 0;
            if (this.xrY != null) {
                bs += e.a.a.b.b.a.f(2, this.xrY);
            }
            if (this.xrZ != null) {
                bs += e.a.a.b.b.a.f(3, this.xrZ);
            }
            AppMethodBeat.o(11825);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11825);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwc cwc = (cwc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwc.xrX = aVar3.BTU.vd();
                    AppMethodBeat.o(11825);
                    return 0;
                case 2:
                    cwc.xrY = aVar3.BTU.readString();
                    AppMethodBeat.o(11825);
                    return 0;
                case 3:
                    cwc.xrZ = aVar3.BTU.readString();
                    AppMethodBeat.o(11825);
                    return 0;
                default:
                    AppMethodBeat.o(11825);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11825);
            return -1;
        }
    }
}
