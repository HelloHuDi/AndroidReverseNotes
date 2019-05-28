package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class d extends a {
    public int count;
    public int qsz;
    public int vyQ;
    public b vyZ;
    public int vza;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72819);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vyZ == null) {
                bVar = new e.a.a.b("Not all required fields were included: value");
                AppMethodBeat.o(72819);
                throw bVar;
            }
            aVar.iz(1, this.vyQ);
            if (this.vyZ != null) {
                aVar.c(2, this.vyZ);
            }
            aVar.iz(3, this.vza);
            aVar.iz(4, this.qsz);
            aVar.iz(5, this.count);
            AppMethodBeat.o(72819);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vyQ) + 0;
            if (this.vyZ != null) {
                bs += e.a.a.b.b.a.b(2, this.vyZ);
            }
            bs = ((bs + e.a.a.b.b.a.bs(3, this.vza)) + e.a.a.b.b.a.bs(4, this.qsz)) + e.a.a.b.b.a.bs(5, this.count);
            AppMethodBeat.o(72819);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vyZ == null) {
                bVar = new e.a.a.b("Not all required fields were included: value");
                AppMethodBeat.o(72819);
                throw bVar;
            }
            AppMethodBeat.o(72819);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.vyQ = aVar3.BTU.vd();
                    AppMethodBeat.o(72819);
                    return 0;
                case 2:
                    dVar.vyZ = aVar3.BTU.emu();
                    AppMethodBeat.o(72819);
                    return 0;
                case 3:
                    dVar.vza = aVar3.BTU.vd();
                    AppMethodBeat.o(72819);
                    return 0;
                case 4:
                    dVar.qsz = aVar3.BTU.vd();
                    AppMethodBeat.o(72819);
                    return 0;
                case 5:
                    dVar.count = aVar3.BTU.vd();
                    AppMethodBeat.o(72819);
                    return 0;
                default:
                    AppMethodBeat.o(72819);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72819);
            return -1;
        }
    }
}
