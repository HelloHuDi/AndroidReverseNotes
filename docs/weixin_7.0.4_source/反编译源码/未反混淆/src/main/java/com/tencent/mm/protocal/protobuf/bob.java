package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bob extends a {
    public String lWq;
    public int nbk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123513);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.lWq == null) {
                bVar = new b("Not all required fields were included: jsonData");
                AppMethodBeat.o(123513);
                throw bVar;
            }
            aVar.iz(1, this.nbk);
            if (this.lWq != null) {
                aVar.e(2, this.lWq);
            }
            AppMethodBeat.o(123513);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.nbk) + 0;
            if (this.lWq != null) {
                bs += e.a.a.b.b.a.f(2, this.lWq);
            }
            AppMethodBeat.o(123513);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.lWq == null) {
                bVar = new b("Not all required fields were included: jsonData");
                AppMethodBeat.o(123513);
                throw bVar;
            }
            AppMethodBeat.o(123513);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bob bob = (bob) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bob.nbk = aVar3.BTU.vd();
                    AppMethodBeat.o(123513);
                    return 0;
                case 2:
                    bob.lWq = aVar3.BTU.readString();
                    AppMethodBeat.o(123513);
                    return 0;
                default:
                    AppMethodBeat.o(123513);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123513);
            return -1;
        }
    }
}
