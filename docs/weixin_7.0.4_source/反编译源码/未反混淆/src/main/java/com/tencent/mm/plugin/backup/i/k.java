package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class k extends a {
    public int jBA;
    public String jBB;
    public int jBz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18057);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(18057);
                throw bVar;
            }
            aVar.iz(1, this.jBz);
            aVar.iz(2, this.jBA);
            if (this.jBB != null) {
                aVar.e(3, this.jBB);
            }
            AppMethodBeat.o(18057);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.jBz) + 0) + e.a.a.b.b.a.bs(2, this.jBA);
            if (this.jBB != null) {
                bs += e.a.a.b.b.a.f(3, this.jBB);
            }
            AppMethodBeat.o(18057);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(18057);
                throw bVar;
            }
            AppMethodBeat.o(18057);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.jBz = aVar3.BTU.vd();
                    AppMethodBeat.o(18057);
                    return 0;
                case 2:
                    kVar.jBA = aVar3.BTU.vd();
                    AppMethodBeat.o(18057);
                    return 0;
                case 3:
                    kVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(18057);
                    return 0;
                default:
                    AppMethodBeat.o(18057);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18057);
            return -1;
        }
    }
}
