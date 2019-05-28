package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ctu extends a {
    public int ndE;
    public String xmI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28731);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xmI == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(28731);
                throw bVar;
            }
            aVar.iz(1, this.ndE);
            if (this.xmI != null) {
                aVar.e(2, this.xmI);
            }
            AppMethodBeat.o(28731);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ndE) + 0;
            if (this.xmI != null) {
                bs += e.a.a.b.b.a.f(2, this.xmI);
            }
            AppMethodBeat.o(28731);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.xmI == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(28731);
                throw bVar;
            }
            AppMethodBeat.o(28731);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctu ctu = (ctu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctu.ndE = aVar3.BTU.vd();
                    AppMethodBeat.o(28731);
                    return 0;
                case 2:
                    ctu.xmI = aVar3.BTU.readString();
                    AppMethodBeat.o(28731);
                    return 0;
                default:
                    AppMethodBeat.o(28731);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28731);
            return -1;
        }
    }
}
