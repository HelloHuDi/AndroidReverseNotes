package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class zq extends a {
    public int weH;
    public String weI;
    public String weJ;
    public String weV;
    public String weW;
    public int weX;
    public int weY;
    public String weZ;
    public String wfa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28402);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.weH);
            if (this.weI != null) {
                aVar.e(2, this.weI);
            }
            if (this.weV != null) {
                aVar.e(3, this.weV);
            }
            if (this.weW != null) {
                aVar.e(4, this.weW);
            }
            aVar.iz(5, this.weX);
            aVar.iz(6, this.weY);
            if (this.weZ != null) {
                aVar.e(7, this.weZ);
            }
            if (this.weJ != null) {
                aVar.e(8, this.weJ);
            }
            if (this.wfa != null) {
                aVar.e(9, this.wfa);
            }
            AppMethodBeat.o(28402);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.weH) + 0;
            if (this.weI != null) {
                bs += e.a.a.b.b.a.f(2, this.weI);
            }
            if (this.weV != null) {
                bs += e.a.a.b.b.a.f(3, this.weV);
            }
            if (this.weW != null) {
                bs += e.a.a.b.b.a.f(4, this.weW);
            }
            bs = (bs + e.a.a.b.b.a.bs(5, this.weX)) + e.a.a.b.b.a.bs(6, this.weY);
            if (this.weZ != null) {
                bs += e.a.a.b.b.a.f(7, this.weZ);
            }
            if (this.weJ != null) {
                bs += e.a.a.b.b.a.f(8, this.weJ);
            }
            if (this.wfa != null) {
                bs += e.a.a.b.b.a.f(9, this.wfa);
            }
            AppMethodBeat.o(28402);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28402);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zq zqVar = (zq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zqVar.weH = aVar3.BTU.vd();
                    AppMethodBeat.o(28402);
                    return 0;
                case 2:
                    zqVar.weI = aVar3.BTU.readString();
                    AppMethodBeat.o(28402);
                    return 0;
                case 3:
                    zqVar.weV = aVar3.BTU.readString();
                    AppMethodBeat.o(28402);
                    return 0;
                case 4:
                    zqVar.weW = aVar3.BTU.readString();
                    AppMethodBeat.o(28402);
                    return 0;
                case 5:
                    zqVar.weX = aVar3.BTU.vd();
                    AppMethodBeat.o(28402);
                    return 0;
                case 6:
                    zqVar.weY = aVar3.BTU.vd();
                    AppMethodBeat.o(28402);
                    return 0;
                case 7:
                    zqVar.weZ = aVar3.BTU.readString();
                    AppMethodBeat.o(28402);
                    return 0;
                case 8:
                    zqVar.weJ = aVar3.BTU.readString();
                    AppMethodBeat.o(28402);
                    return 0;
                case 9:
                    zqVar.wfa = aVar3.BTU.readString();
                    AppMethodBeat.o(28402);
                    return 0;
                default:
                    AppMethodBeat.o(28402);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28402);
            return -1;
        }
    }
}
