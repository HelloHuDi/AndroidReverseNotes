package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class eu extends a {
    public long jVD;
    public int jVE;
    public String url;
    public String vGE;
    public int vGF;
    public int vGG;
    public long vGH;
    public int vGI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11691);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGE != null) {
                aVar.e(1, this.vGE);
            }
            aVar.ai(2, this.jVD);
            aVar.iz(3, this.jVE);
            aVar.iz(4, this.vGF);
            aVar.iz(5, this.vGG);
            aVar.ai(6, this.vGH);
            aVar.iz(7, this.vGI);
            if (this.url != null) {
                aVar.e(8, this.url);
            }
            AppMethodBeat.o(11691);
            return 0;
        } else if (i == 1) {
            if (this.vGE != null) {
                f = e.a.a.b.b.a.f(1, this.vGE) + 0;
            } else {
                f = 0;
            }
            f = (((((f + e.a.a.b.b.a.o(2, this.jVD)) + e.a.a.b.b.a.bs(3, this.jVE)) + e.a.a.b.b.a.bs(4, this.vGF)) + e.a.a.b.b.a.bs(5, this.vGG)) + e.a.a.b.b.a.o(6, this.vGH)) + e.a.a.b.b.a.bs(7, this.vGI);
            if (this.url != null) {
                f += e.a.a.b.b.a.f(8, this.url);
            }
            AppMethodBeat.o(11691);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11691);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            eu euVar = (eu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    euVar.vGE = aVar3.BTU.readString();
                    AppMethodBeat.o(11691);
                    return 0;
                case 2:
                    euVar.jVD = aVar3.BTU.ve();
                    AppMethodBeat.o(11691);
                    return 0;
                case 3:
                    euVar.jVE = aVar3.BTU.vd();
                    AppMethodBeat.o(11691);
                    return 0;
                case 4:
                    euVar.vGF = aVar3.BTU.vd();
                    AppMethodBeat.o(11691);
                    return 0;
                case 5:
                    euVar.vGG = aVar3.BTU.vd();
                    AppMethodBeat.o(11691);
                    return 0;
                case 6:
                    euVar.vGH = aVar3.BTU.ve();
                    AppMethodBeat.o(11691);
                    return 0;
                case 7:
                    euVar.vGI = aVar3.BTU.vd();
                    AppMethodBeat.o(11691);
                    return 0;
                case 8:
                    euVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(11691);
                    return 0;
                default:
                    AppMethodBeat.o(11691);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11691);
            return -1;
        }
    }
}
