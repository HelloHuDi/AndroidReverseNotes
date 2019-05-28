package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class li extends a {
    public String csB;
    public String kLN;
    public int qzj;
    public int vOO;
    public int vOP;
    public int vOQ;
    public String vOR;
    public int vOS;
    public int vOT;
    public int vOU;
    public String vOV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124290);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            aVar.iz(2, this.vOO);
            aVar.iz(3, this.vOP);
            if (this.kLN != null) {
                aVar.e(4, this.kLN);
            }
            aVar.iz(5, this.vOQ);
            if (this.vOR != null) {
                aVar.e(6, this.vOR);
            }
            aVar.iz(7, this.vOS);
            aVar.iz(8, this.vOT);
            aVar.iz(9, this.vOU);
            if (this.vOV != null) {
                aVar.e(10, this.vOV);
            }
            aVar.iz(15, this.qzj);
            AppMethodBeat.o(124290);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.vOO)) + e.a.a.b.b.a.bs(3, this.vOP);
            if (this.kLN != null) {
                f += e.a.a.b.b.a.f(4, this.kLN);
            }
            f += e.a.a.b.b.a.bs(5, this.vOQ);
            if (this.vOR != null) {
                f += e.a.a.b.b.a.f(6, this.vOR);
            }
            f = ((f + e.a.a.b.b.a.bs(7, this.vOS)) + e.a.a.b.b.a.bs(8, this.vOT)) + e.a.a.b.b.a.bs(9, this.vOU);
            if (this.vOV != null) {
                f += e.a.a.b.b.a.f(10, this.vOV);
            }
            int bs = f + e.a.a.b.b.a.bs(15, this.qzj);
            AppMethodBeat.o(124290);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124290);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            li liVar = (li) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    liVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(124290);
                    return 0;
                case 2:
                    liVar.vOO = aVar3.BTU.vd();
                    AppMethodBeat.o(124290);
                    return 0;
                case 3:
                    liVar.vOP = aVar3.BTU.vd();
                    AppMethodBeat.o(124290);
                    return 0;
                case 4:
                    liVar.kLN = aVar3.BTU.readString();
                    AppMethodBeat.o(124290);
                    return 0;
                case 5:
                    liVar.vOQ = aVar3.BTU.vd();
                    AppMethodBeat.o(124290);
                    return 0;
                case 6:
                    liVar.vOR = aVar3.BTU.readString();
                    AppMethodBeat.o(124290);
                    return 0;
                case 7:
                    liVar.vOS = aVar3.BTU.vd();
                    AppMethodBeat.o(124290);
                    return 0;
                case 8:
                    liVar.vOT = aVar3.BTU.vd();
                    AppMethodBeat.o(124290);
                    return 0;
                case 9:
                    liVar.vOU = aVar3.BTU.vd();
                    AppMethodBeat.o(124290);
                    return 0;
                case 10:
                    liVar.vOV = aVar3.BTU.readString();
                    AppMethodBeat.o(124290);
                    return 0;
                case 15:
                    liVar.qzj = aVar3.BTU.vd();
                    AppMethodBeat.o(124290);
                    return 0;
                default:
                    AppMethodBeat.o(124290);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124290);
            return -1;
        }
    }
}
