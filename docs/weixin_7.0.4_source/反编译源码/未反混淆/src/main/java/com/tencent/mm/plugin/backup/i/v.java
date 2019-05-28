package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class v extends a {
    public String ID;
    public int Version;
    public b jBi;
    public int jCs;
    public int jCt;
    public int jCu;
    public int jCv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18070);
        e.a.a.b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                bVar = new e.a.a.b("Not all required fields were included: ID");
                AppMethodBeat.o(18070);
                throw bVar;
            }
            aVar.iz(1, this.jCs);
            if (this.ID != null) {
                aVar.e(2, this.ID);
            }
            if (this.jBi != null) {
                aVar.c(3, this.jBi);
            }
            aVar.iz(4, this.Version);
            aVar.iz(5, this.jCt);
            aVar.iz(6, this.jCu);
            aVar.iz(7, this.jCv);
            AppMethodBeat.o(18070);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jCs) + 0;
            if (this.ID != null) {
                bs += e.a.a.b.b.a.f(2, this.ID);
            }
            if (this.jBi != null) {
                bs += e.a.a.b.b.a.b(3, this.jBi);
            }
            bs = (((bs + e.a.a.b.b.a.bs(4, this.Version)) + e.a.a.b.b.a.bs(5, this.jCt)) + e.a.a.b.b.a.bs(6, this.jCu)) + e.a.a.b.b.a.bs(7, this.jCv);
            AppMethodBeat.o(18070);
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
                AppMethodBeat.o(18070);
                throw bVar;
            }
            AppMethodBeat.o(18070);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vVar.jCs = aVar3.BTU.vd();
                    AppMethodBeat.o(18070);
                    return 0;
                case 2:
                    vVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(18070);
                    return 0;
                case 3:
                    vVar.jBi = aVar3.BTU.emu();
                    AppMethodBeat.o(18070);
                    return 0;
                case 4:
                    vVar.Version = aVar3.BTU.vd();
                    AppMethodBeat.o(18070);
                    return 0;
                case 5:
                    vVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(18070);
                    return 0;
                case 6:
                    vVar.jCu = aVar3.BTU.vd();
                    AppMethodBeat.o(18070);
                    return 0;
                case 7:
                    vVar.jCv = aVar3.BTU.vd();
                    AppMethodBeat.o(18070);
                    return 0;
                default:
                    AppMethodBeat.o(18070);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18070);
            return -1;
        }
    }
}
