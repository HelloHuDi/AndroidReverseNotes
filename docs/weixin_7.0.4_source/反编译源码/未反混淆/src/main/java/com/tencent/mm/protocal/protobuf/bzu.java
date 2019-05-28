package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class bzu extends a {
    public int Version;
    public b wYR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80189);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYR == null) {
                bVar = new e.a.a.b("Not all required fields were included: Signature");
                AppMethodBeat.o(80189);
                throw bVar;
            }
            aVar.iz(1, this.Version);
            if (this.wYR != null) {
                aVar.c(2, this.wYR);
            }
            AppMethodBeat.o(80189);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Version) + 0;
            if (this.wYR != null) {
                bs += e.a.a.b.b.a.b(2, this.wYR);
            }
            AppMethodBeat.o(80189);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wYR == null) {
                bVar = new e.a.a.b("Not all required fields were included: Signature");
                AppMethodBeat.o(80189);
                throw bVar;
            }
            AppMethodBeat.o(80189);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzu bzu = (bzu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzu.Version = aVar3.BTU.vd();
                    AppMethodBeat.o(80189);
                    return 0;
                case 2:
                    bzu.wYR = aVar3.BTU.emu();
                    AppMethodBeat.o(80189);
                    return 0;
                default:
                    AppMethodBeat.o(80189);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80189);
            return -1;
        }
    }
}
