package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class w extends a {
    public String ID;
    public int Version;
    public int jBT;
    public b jBi;
    public int jCs;
    public int jCt;
    public int jCu;
    public b jCw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18071);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                bVar = new e.a.a.b("Not all required fields were included: ID");
                AppMethodBeat.o(18071);
                throw bVar;
            }
            aVar.iz(1, this.jCs);
            aVar.iz(2, this.jBT);
            if (this.ID != null) {
                aVar.e(3, this.ID);
            }
            if (this.jBi != null) {
                aVar.c(4, this.jBi);
            }
            aVar.iz(5, this.Version);
            aVar.iz(6, this.jCt);
            aVar.iz(7, this.jCu);
            if (this.jCw != null) {
                aVar.c(8, this.jCw);
            }
            AppMethodBeat.o(18071);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.jCs) + 0) + e.a.a.b.b.a.bs(2, this.jBT);
            if (this.ID != null) {
                bs += e.a.a.b.b.a.f(3, this.ID);
            }
            if (this.jBi != null) {
                bs += e.a.a.b.b.a.b(4, this.jBi);
            }
            bs = ((bs + e.a.a.b.b.a.bs(5, this.Version)) + e.a.a.b.b.a.bs(6, this.jCt)) + e.a.a.b.b.a.bs(7, this.jCu);
            if (this.jCw != null) {
                bs += e.a.a.b.b.a.b(8, this.jCw);
            }
            AppMethodBeat.o(18071);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.ID == null) {
                bVar = new e.a.a.b("Not all required fields were included: ID");
                AppMethodBeat.o(18071);
                throw bVar;
            }
            AppMethodBeat.o(18071);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wVar.jCs = aVar3.BTU.vd();
                    AppMethodBeat.o(18071);
                    return 0;
                case 2:
                    wVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(18071);
                    return 0;
                case 3:
                    wVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(18071);
                    return 0;
                case 4:
                    wVar.jBi = aVar3.BTU.emu();
                    AppMethodBeat.o(18071);
                    return 0;
                case 5:
                    wVar.Version = aVar3.BTU.vd();
                    AppMethodBeat.o(18071);
                    return 0;
                case 6:
                    wVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(18071);
                    return 0;
                case 7:
                    wVar.jCu = aVar3.BTU.vd();
                    AppMethodBeat.o(18071);
                    return 0;
                case 8:
                    wVar.jCw = aVar3.BTU.emu();
                    AppMethodBeat.o(18071);
                    return 0;
                default:
                    AppMethodBeat.o(18071);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18071);
            return -1;
        }
    }
}
