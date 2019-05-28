package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cyf extends a {
    public String ndR;
    public String ndT;
    public String ndU;
    public int ndV;
    public String vMJ;
    public int xtB;
    public String xtC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80213);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xtB);
            if (this.vMJ != null) {
                aVar.e(2, this.vMJ);
            }
            if (this.ndR != null) {
                aVar.e(3, this.ndR);
            }
            if (this.xtC != null) {
                aVar.e(4, this.xtC);
            }
            if (this.ndT != null) {
                aVar.e(5, this.ndT);
            }
            if (this.ndU != null) {
                aVar.e(6, this.ndU);
            }
            aVar.iz(7, this.ndV);
            AppMethodBeat.o(80213);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xtB) + 0;
            if (this.vMJ != null) {
                bs += e.a.a.b.b.a.f(2, this.vMJ);
            }
            if (this.ndR != null) {
                bs += e.a.a.b.b.a.f(3, this.ndR);
            }
            if (this.xtC != null) {
                bs += e.a.a.b.b.a.f(4, this.xtC);
            }
            if (this.ndT != null) {
                bs += e.a.a.b.b.a.f(5, this.ndT);
            }
            if (this.ndU != null) {
                bs += e.a.a.b.b.a.f(6, this.ndU);
            }
            bs += e.a.a.b.b.a.bs(7, this.ndV);
            AppMethodBeat.o(80213);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80213);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cyf cyf = (cyf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyf.xtB = aVar3.BTU.vd();
                    AppMethodBeat.o(80213);
                    return 0;
                case 2:
                    cyf.vMJ = aVar3.BTU.readString();
                    AppMethodBeat.o(80213);
                    return 0;
                case 3:
                    cyf.ndR = aVar3.BTU.readString();
                    AppMethodBeat.o(80213);
                    return 0;
                case 4:
                    cyf.xtC = aVar3.BTU.readString();
                    AppMethodBeat.o(80213);
                    return 0;
                case 5:
                    cyf.ndT = aVar3.BTU.readString();
                    AppMethodBeat.o(80213);
                    return 0;
                case 6:
                    cyf.ndU = aVar3.BTU.readString();
                    AppMethodBeat.o(80213);
                    return 0;
                case 7:
                    cyf.ndV = aVar3.BTU.vd();
                    AppMethodBeat.o(80213);
                    return 0;
                default:
                    AppMethodBeat.o(80213);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80213);
            return -1;
        }
    }
}
