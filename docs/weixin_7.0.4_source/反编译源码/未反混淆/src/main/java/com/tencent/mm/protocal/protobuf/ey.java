package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ey extends a {
    public long vGQ;
    public int vGR;
    public int vGS;
    public int vGT;
    public int vGU;
    public int vGV;
    public int vGW;
    public String vGX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96194);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.vGQ);
            aVar.iz(2, this.vGR);
            aVar.iz(3, this.vGS);
            aVar.iz(4, this.vGT);
            aVar.iz(5, this.vGU);
            aVar.iz(6, this.vGV);
            aVar.iz(7, this.vGW);
            if (this.vGX != null) {
                aVar.e(8, this.vGX);
            }
            AppMethodBeat.o(96194);
            return 0;
        } else if (i == 1) {
            o = ((((((e.a.a.b.b.a.o(1, this.vGQ) + 0) + e.a.a.b.b.a.bs(2, this.vGR)) + e.a.a.b.b.a.bs(3, this.vGS)) + e.a.a.b.b.a.bs(4, this.vGT)) + e.a.a.b.b.a.bs(5, this.vGU)) + e.a.a.b.b.a.bs(6, this.vGV)) + e.a.a.b.b.a.bs(7, this.vGW);
            if (this.vGX != null) {
                o += e.a.a.b.b.a.f(8, this.vGX);
            }
            AppMethodBeat.o(96194);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96194);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ey eyVar = (ey) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyVar.vGQ = aVar3.BTU.ve();
                    AppMethodBeat.o(96194);
                    return 0;
                case 2:
                    eyVar.vGR = aVar3.BTU.vd();
                    AppMethodBeat.o(96194);
                    return 0;
                case 3:
                    eyVar.vGS = aVar3.BTU.vd();
                    AppMethodBeat.o(96194);
                    return 0;
                case 4:
                    eyVar.vGT = aVar3.BTU.vd();
                    AppMethodBeat.o(96194);
                    return 0;
                case 5:
                    eyVar.vGU = aVar3.BTU.vd();
                    AppMethodBeat.o(96194);
                    return 0;
                case 6:
                    eyVar.vGV = aVar3.BTU.vd();
                    AppMethodBeat.o(96194);
                    return 0;
                case 7:
                    eyVar.vGW = aVar3.BTU.vd();
                    AppMethodBeat.o(96194);
                    return 0;
                case 8:
                    eyVar.vGX = aVar3.BTU.readString();
                    AppMethodBeat.o(96194);
                    return 0;
                default:
                    AppMethodBeat.o(96194);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96194);
            return -1;
        }
    }
}
