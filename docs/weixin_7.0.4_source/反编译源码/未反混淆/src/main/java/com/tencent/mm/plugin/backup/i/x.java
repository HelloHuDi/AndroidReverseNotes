package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class x extends a {
    public b jBi;
    public int jCA;
    public int jCB;
    public int jCC;
    public int jCD;
    public String jCx;
    public int jCy;
    public int jCz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18072);
        e.a.a.b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jCx == null) {
                bVar = new e.a.a.b("Not all required fields were included: DataID");
                AppMethodBeat.o(18072);
                throw bVar;
            }
            if (this.jCx != null) {
                aVar.e(1, this.jCx);
            }
            aVar.iz(2, this.jCy);
            aVar.iz(3, this.jCz);
            aVar.iz(4, this.jCA);
            aVar.iz(5, this.jCB);
            aVar.iz(6, this.jCC);
            if (this.jBi != null) {
                aVar.c(7, this.jBi);
            }
            aVar.iz(8, this.jCD);
            AppMethodBeat.o(18072);
            return 0;
        } else if (i == 1) {
            if (this.jCx != null) {
                f = e.a.a.b.b.a.f(1, this.jCx) + 0;
            } else {
                f = 0;
            }
            f = ((((f + e.a.a.b.b.a.bs(2, this.jCy)) + e.a.a.b.b.a.bs(3, this.jCz)) + e.a.a.b.b.a.bs(4, this.jCA)) + e.a.a.b.b.a.bs(5, this.jCB)) + e.a.a.b.b.a.bs(6, this.jCC);
            if (this.jBi != null) {
                f += e.a.a.b.b.a.b(7, this.jBi);
            }
            int bs = f + e.a.a.b.b.a.bs(8, this.jCD);
            AppMethodBeat.o(18072);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jCx == null) {
                bVar = new e.a.a.b("Not all required fields were included: DataID");
                AppMethodBeat.o(18072);
                throw bVar;
            }
            AppMethodBeat.o(18072);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xVar.jCx = aVar3.BTU.readString();
                    AppMethodBeat.o(18072);
                    return 0;
                case 2:
                    xVar.jCy = aVar3.BTU.vd();
                    AppMethodBeat.o(18072);
                    return 0;
                case 3:
                    xVar.jCz = aVar3.BTU.vd();
                    AppMethodBeat.o(18072);
                    return 0;
                case 4:
                    xVar.jCA = aVar3.BTU.vd();
                    AppMethodBeat.o(18072);
                    return 0;
                case 5:
                    xVar.jCB = aVar3.BTU.vd();
                    AppMethodBeat.o(18072);
                    return 0;
                case 6:
                    xVar.jCC = aVar3.BTU.vd();
                    AppMethodBeat.o(18072);
                    return 0;
                case 7:
                    xVar.jBi = aVar3.BTU.emu();
                    AppMethodBeat.o(18072);
                    return 0;
                case 8:
                    xVar.jCD = aVar3.BTU.vd();
                    AppMethodBeat.o(18072);
                    return 0;
                default:
                    AppMethodBeat.o(18072);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18072);
            return -1;
        }
    }
}
