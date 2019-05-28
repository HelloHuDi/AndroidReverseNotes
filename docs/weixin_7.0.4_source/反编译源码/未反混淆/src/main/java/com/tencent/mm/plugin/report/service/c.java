package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class c extends a {
    public int jCt;
    public boolean pXE;
    public int pXL;
    public String pXM;
    public boolean pXN;
    public boolean pXO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72718);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pXM == null) {
                bVar = new b("Not all required fields were included: Value");
                AppMethodBeat.o(72718);
                throw bVar;
            }
            aVar.iz(1, this.pXL);
            if (this.pXM != null) {
                aVar.e(2, this.pXM);
            }
            aVar.aO(3, this.pXN);
            aVar.aO(4, this.pXE);
            aVar.iz(5, this.jCt);
            aVar.aO(6, this.pXO);
            AppMethodBeat.o(72718);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.pXL) + 0;
            if (this.pXM != null) {
                bs += e.a.a.b.b.a.f(2, this.pXM);
            }
            bs = (((bs + (e.a.a.b.b.a.fv(3) + 1)) + (e.a.a.b.b.a.fv(4) + 1)) + e.a.a.b.b.a.bs(5, this.jCt)) + (e.a.a.b.b.a.fv(6) + 1);
            AppMethodBeat.o(72718);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.pXM == null) {
                bVar = new b("Not all required fields were included: Value");
                AppMethodBeat.o(72718);
                throw bVar;
            }
            AppMethodBeat.o(72718);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.pXL = aVar3.BTU.vd();
                    AppMethodBeat.o(72718);
                    return 0;
                case 2:
                    cVar.pXM = aVar3.BTU.readString();
                    AppMethodBeat.o(72718);
                    return 0;
                case 3:
                    cVar.pXN = aVar3.BTU.ehX();
                    AppMethodBeat.o(72718);
                    return 0;
                case 4:
                    cVar.pXE = aVar3.BTU.ehX();
                    AppMethodBeat.o(72718);
                    return 0;
                case 5:
                    cVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(72718);
                    return 0;
                case 6:
                    cVar.pXO = aVar3.BTU.ehX();
                    AppMethodBeat.o(72718);
                    return 0;
                default:
                    AppMethodBeat.o(72718);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72718);
            return -1;
        }
    }
}
