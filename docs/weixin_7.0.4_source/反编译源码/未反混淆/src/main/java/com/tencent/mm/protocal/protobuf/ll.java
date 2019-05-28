package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class ll extends a {
    public int port;
    public int type;
    public b vOX;
    public b vOY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58894);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            aVar.iz(2, this.port);
            if (this.vOX != null) {
                aVar.c(3, this.vOX);
            }
            if (this.vOY != null) {
                aVar.c(4, this.vOY);
            }
            AppMethodBeat.o(58894);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.type) + 0) + e.a.a.b.b.a.bs(2, this.port);
            if (this.vOX != null) {
                bs += e.a.a.b.b.a.b(3, this.vOX);
            }
            if (this.vOY != null) {
                bs += e.a.a.b.b.a.b(4, this.vOY);
            }
            AppMethodBeat.o(58894);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58894);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ll llVar = (ll) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    llVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(58894);
                    return 0;
                case 2:
                    llVar.port = aVar3.BTU.vd();
                    AppMethodBeat.o(58894);
                    return 0;
                case 3:
                    llVar.vOX = aVar3.BTU.emu();
                    AppMethodBeat.o(58894);
                    return 0;
                case 4:
                    llVar.vOY = aVar3.BTU.emu();
                    AppMethodBeat.o(58894);
                    return 0;
                default:
                    AppMethodBeat.o(58894);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58894);
            return -1;
        }
    }
}
