package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class bgt extends a {
    public int type;
    public b wKq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60054);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wKq == null) {
                bVar = new e.a.a.b("Not all required fields were included: buf");
                AppMethodBeat.o(60054);
                throw bVar;
            }
            aVar.iz(1, this.type);
            if (this.wKq != null) {
                aVar.c(2, this.wKq);
            }
            AppMethodBeat.o(60054);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.wKq != null) {
                bs += e.a.a.b.b.a.b(2, this.wKq);
            }
            AppMethodBeat.o(60054);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wKq == null) {
                bVar = new e.a.a.b("Not all required fields were included: buf");
                AppMethodBeat.o(60054);
                throw bVar;
            }
            AppMethodBeat.o(60054);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgt bgt = (bgt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgt.type = aVar3.BTU.vd();
                    AppMethodBeat.o(60054);
                    return 0;
                case 2:
                    bgt.wKq = aVar3.BTU.emu();
                    AppMethodBeat.o(60054);
                    return 0;
                default:
                    AppMethodBeat.o(60054);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60054);
            return -1;
        }
    }
}
