package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class p extends a {
    public String ID;
    public long jBS;
    public int jBV;
    public int jBW;
    public int jBX;
    public long jBY;
    public long jBZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18063);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18063);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.iz(2, this.jBV);
            aVar.iz(3, this.jBW);
            aVar.iz(4, this.jBX);
            aVar.ai(5, this.jBS);
            aVar.ai(6, this.jBY);
            aVar.ai(7, this.jBZ);
            AppMethodBeat.o(18063);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                f = e.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                f = 0;
            }
            int bs = (((((f + e.a.a.b.b.a.bs(2, this.jBV)) + e.a.a.b.b.a.bs(3, this.jBW)) + e.a.a.b.b.a.bs(4, this.jBX)) + e.a.a.b.b.a.o(5, this.jBS)) + e.a.a.b.b.a.o(6, this.jBY)) + e.a.a.b.b.a.o(7, this.jBZ);
            AppMethodBeat.o(18063);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18063);
                throw bVar;
            }
            AppMethodBeat.o(18063);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(18063);
                    return 0;
                case 2:
                    pVar.jBV = aVar3.BTU.vd();
                    AppMethodBeat.o(18063);
                    return 0;
                case 3:
                    pVar.jBW = aVar3.BTU.vd();
                    AppMethodBeat.o(18063);
                    return 0;
                case 4:
                    pVar.jBX = aVar3.BTU.vd();
                    AppMethodBeat.o(18063);
                    return 0;
                case 5:
                    pVar.jBS = aVar3.BTU.ve();
                    AppMethodBeat.o(18063);
                    return 0;
                case 6:
                    pVar.jBY = aVar3.BTU.ve();
                    AppMethodBeat.o(18063);
                    return 0;
                case 7:
                    pVar.jBZ = aVar3.BTU.ve();
                    AppMethodBeat.o(18063);
                    return 0;
                default:
                    AppMethodBeat.o(18063);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18063);
            return -1;
        }
    }
}
