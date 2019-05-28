package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cqu extends a {
    public String wbe;
    public String xoA;
    public String xoB;
    public int xoC;
    public float xoD;
    public float xoE;
    public String xoF;
    public String xoz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102402);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xoz != null) {
                aVar.e(1, this.xoz);
            }
            if (this.wbe != null) {
                aVar.e(2, this.wbe);
            }
            if (this.xoA != null) {
                aVar.e(3, this.xoA);
            }
            if (this.xoB != null) {
                aVar.e(4, this.xoB);
            }
            aVar.iz(5, this.xoC);
            aVar.r(6, this.xoD);
            aVar.r(7, this.xoE);
            if (this.xoF != null) {
                aVar.e(8, this.xoF);
            }
            AppMethodBeat.o(102402);
            return 0;
        } else if (i == 1) {
            if (this.xoz != null) {
                f = e.a.a.b.b.a.f(1, this.xoz) + 0;
            } else {
                f = 0;
            }
            if (this.wbe != null) {
                f += e.a.a.b.b.a.f(2, this.wbe);
            }
            if (this.xoA != null) {
                f += e.a.a.b.b.a.f(3, this.xoA);
            }
            if (this.xoB != null) {
                f += e.a.a.b.b.a.f(4, this.xoB);
            }
            f = ((f + e.a.a.b.b.a.bs(5, this.xoC)) + (e.a.a.b.b.a.fv(6) + 4)) + (e.a.a.b.b.a.fv(7) + 4);
            if (this.xoF != null) {
                f += e.a.a.b.b.a.f(8, this.xoF);
            }
            AppMethodBeat.o(102402);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102402);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqu cqu = (cqu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqu.xoz = aVar3.BTU.readString();
                    AppMethodBeat.o(102402);
                    return 0;
                case 2:
                    cqu.wbe = aVar3.BTU.readString();
                    AppMethodBeat.o(102402);
                    return 0;
                case 3:
                    cqu.xoA = aVar3.BTU.readString();
                    AppMethodBeat.o(102402);
                    return 0;
                case 4:
                    cqu.xoB = aVar3.BTU.readString();
                    AppMethodBeat.o(102402);
                    return 0;
                case 5:
                    cqu.xoC = aVar3.BTU.vd();
                    AppMethodBeat.o(102402);
                    return 0;
                case 6:
                    cqu.xoD = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(102402);
                    return 0;
                case 7:
                    cqu.xoE = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(102402);
                    return 0;
                case 8:
                    cqu.xoF = aVar3.BTU.readString();
                    AppMethodBeat.o(102402);
                    return 0;
                default:
                    AppMethodBeat.o(102402);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102402);
            return -1;
        }
    }
}
