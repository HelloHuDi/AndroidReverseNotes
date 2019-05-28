package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class r extends a {
    public int cRT;
    public String nSX;
    public String nWR;
    public long nWU;
    public long nWW;
    public String nWX;
    public String nXL;
    public long nXM;
    public String nXN;
    public String nXO;
    public String nXP;
    public long nXQ;
    public int nXR;
    public int nXi;
    public int status;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56614);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nXL != null) {
                aVar.e(1, this.nXL);
            }
            if (this.nWR != null) {
                aVar.e(2, this.nWR);
            }
            aVar.ai(3, this.nXM);
            if (this.nXN != null) {
                aVar.e(4, this.nXN);
            }
            aVar.iz(5, this.cRT);
            if (this.nXO != null) {
                aVar.e(6, this.nXO);
            }
            if (this.nXP != null) {
                aVar.e(7, this.nXP);
            }
            aVar.ai(8, this.nWW);
            aVar.ai(9, this.nXQ);
            aVar.ai(10, this.nWU);
            aVar.iz(11, this.status);
            aVar.iz(12, this.nXR);
            if (this.nWX != null) {
                aVar.e(13, this.nWX);
            }
            if (this.nSX != null) {
                aVar.e(14, this.nSX);
            }
            aVar.iz(15, this.nXi);
            AppMethodBeat.o(56614);
            return 0;
        } else if (i == 1) {
            if (this.nXL != null) {
                f = e.a.a.b.b.a.f(1, this.nXL) + 0;
            } else {
                f = 0;
            }
            if (this.nWR != null) {
                f += e.a.a.b.b.a.f(2, this.nWR);
            }
            f += e.a.a.b.b.a.o(3, this.nXM);
            if (this.nXN != null) {
                f += e.a.a.b.b.a.f(4, this.nXN);
            }
            f += e.a.a.b.b.a.bs(5, this.cRT);
            if (this.nXO != null) {
                f += e.a.a.b.b.a.f(6, this.nXO);
            }
            if (this.nXP != null) {
                f += e.a.a.b.b.a.f(7, this.nXP);
            }
            f = ((((f + e.a.a.b.b.a.o(8, this.nWW)) + e.a.a.b.b.a.o(9, this.nXQ)) + e.a.a.b.b.a.o(10, this.nWU)) + e.a.a.b.b.a.bs(11, this.status)) + e.a.a.b.b.a.bs(12, this.nXR);
            if (this.nWX != null) {
                f += e.a.a.b.b.a.f(13, this.nWX);
            }
            if (this.nSX != null) {
                f += e.a.a.b.b.a.f(14, this.nSX);
            }
            int bs = f + e.a.a.b.b.a.bs(15, this.nXi);
            AppMethodBeat.o(56614);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56614);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rVar.nXL = aVar3.BTU.readString();
                    AppMethodBeat.o(56614);
                    return 0;
                case 2:
                    rVar.nWR = aVar3.BTU.readString();
                    AppMethodBeat.o(56614);
                    return 0;
                case 3:
                    rVar.nXM = aVar3.BTU.ve();
                    AppMethodBeat.o(56614);
                    return 0;
                case 4:
                    rVar.nXN = aVar3.BTU.readString();
                    AppMethodBeat.o(56614);
                    return 0;
                case 5:
                    rVar.cRT = aVar3.BTU.vd();
                    AppMethodBeat.o(56614);
                    return 0;
                case 6:
                    rVar.nXO = aVar3.BTU.readString();
                    AppMethodBeat.o(56614);
                    return 0;
                case 7:
                    rVar.nXP = aVar3.BTU.readString();
                    AppMethodBeat.o(56614);
                    return 0;
                case 8:
                    rVar.nWW = aVar3.BTU.ve();
                    AppMethodBeat.o(56614);
                    return 0;
                case 9:
                    rVar.nXQ = aVar3.BTU.ve();
                    AppMethodBeat.o(56614);
                    return 0;
                case 10:
                    rVar.nWU = aVar3.BTU.ve();
                    AppMethodBeat.o(56614);
                    return 0;
                case 11:
                    rVar.status = aVar3.BTU.vd();
                    AppMethodBeat.o(56614);
                    return 0;
                case 12:
                    rVar.nXR = aVar3.BTU.vd();
                    AppMethodBeat.o(56614);
                    return 0;
                case 13:
                    rVar.nWX = aVar3.BTU.readString();
                    AppMethodBeat.o(56614);
                    return 0;
                case 14:
                    rVar.nSX = aVar3.BTU.readString();
                    AppMethodBeat.o(56614);
                    return 0;
                case 15:
                    rVar.nXi = aVar3.BTU.vd();
                    AppMethodBeat.o(56614);
                    return 0;
                default:
                    AppMethodBeat.o(56614);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56614);
            return -1;
        }
    }
}
