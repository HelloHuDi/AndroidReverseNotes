package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bsy extends a {
    public int wVd;
    public String wVe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80163);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wVe == null) {
                bVar = new b("Not all required fields were included: ResKey");
                AppMethodBeat.o(80163);
                throw bVar;
            }
            aVar.iz(1, this.wVd);
            if (this.wVe != null) {
                aVar.e(2, this.wVe);
            }
            AppMethodBeat.o(80163);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wVd) + 0;
            if (this.wVe != null) {
                bs += e.a.a.b.b.a.f(2, this.wVe);
            }
            AppMethodBeat.o(80163);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wVe == null) {
                bVar = new b("Not all required fields were included: ResKey");
                AppMethodBeat.o(80163);
                throw bVar;
            }
            AppMethodBeat.o(80163);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsy bsy = (bsy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsy.wVd = aVar3.BTU.vd();
                    AppMethodBeat.o(80163);
                    return 0;
                case 2:
                    bsy.wVe = aVar3.BTU.readString();
                    AppMethodBeat.o(80163);
                    return 0;
                default:
                    AppMethodBeat.o(80163);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80163);
            return -1;
        }
    }
}
