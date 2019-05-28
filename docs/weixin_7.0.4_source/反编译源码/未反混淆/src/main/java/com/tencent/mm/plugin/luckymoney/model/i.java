package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class i extends a {
    public int kCv;
    public int nRO;
    public double nRP;
    public double nRQ;
    public double nRR;
    public double nRS;
    public String nRT;
    public String nRU;
    public String nWH;
    public String nWI;
    public int nWJ;
    public String nWK;
    public String nWL;
    public String nWM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56609);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.nRO);
            aVar.f(2, this.nRR);
            if (this.nWH != null) {
                aVar.e(3, this.nWH);
            }
            if (this.nWI != null) {
                aVar.e(4, this.nWI);
            }
            aVar.f(5, this.nRP);
            aVar.f(6, this.nRS);
            aVar.f(7, this.nRQ);
            aVar.iz(8, this.nWJ);
            aVar.iz(9, this.kCv);
            if (this.nRT != null) {
                aVar.e(10, this.nRT);
            }
            if (this.nRU != null) {
                aVar.e(11, this.nRU);
            }
            if (this.nWK != null) {
                aVar.e(12, this.nWK);
            }
            if (this.nWL != null) {
                aVar.e(13, this.nWL);
            }
            if (this.nWM != null) {
                aVar.e(14, this.nWM);
            }
            AppMethodBeat.o(56609);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.nRO) + 0) + (e.a.a.b.b.a.fv(2) + 8);
            if (this.nWH != null) {
                bs += e.a.a.b.b.a.f(3, this.nWH);
            }
            if (this.nWI != null) {
                bs += e.a.a.b.b.a.f(4, this.nWI);
            }
            bs = ((((bs + (e.a.a.b.b.a.fv(5) + 8)) + (e.a.a.b.b.a.fv(6) + 8)) + (e.a.a.b.b.a.fv(7) + 8)) + e.a.a.b.b.a.bs(8, this.nWJ)) + e.a.a.b.b.a.bs(9, this.kCv);
            if (this.nRT != null) {
                bs += e.a.a.b.b.a.f(10, this.nRT);
            }
            if (this.nRU != null) {
                bs += e.a.a.b.b.a.f(11, this.nRU);
            }
            if (this.nWK != null) {
                bs += e.a.a.b.b.a.f(12, this.nWK);
            }
            if (this.nWL != null) {
                bs += e.a.a.b.b.a.f(13, this.nWL);
            }
            if (this.nWM != null) {
                bs += e.a.a.b.b.a.f(14, this.nWM);
            }
            AppMethodBeat.o(56609);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56609);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.nRO = aVar3.BTU.vd();
                    AppMethodBeat.o(56609);
                    return 0;
                case 2:
                    iVar.nRR = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56609);
                    return 0;
                case 3:
                    iVar.nWH = aVar3.BTU.readString();
                    AppMethodBeat.o(56609);
                    return 0;
                case 4:
                    iVar.nWI = aVar3.BTU.readString();
                    AppMethodBeat.o(56609);
                    return 0;
                case 5:
                    iVar.nRP = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56609);
                    return 0;
                case 6:
                    iVar.nRS = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56609);
                    return 0;
                case 7:
                    iVar.nRQ = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56609);
                    return 0;
                case 8:
                    iVar.nWJ = aVar3.BTU.vd();
                    AppMethodBeat.o(56609);
                    return 0;
                case 9:
                    iVar.kCv = aVar3.BTU.vd();
                    AppMethodBeat.o(56609);
                    return 0;
                case 10:
                    iVar.nRT = aVar3.BTU.readString();
                    AppMethodBeat.o(56609);
                    return 0;
                case 11:
                    iVar.nRU = aVar3.BTU.readString();
                    AppMethodBeat.o(56609);
                    return 0;
                case 12:
                    iVar.nWK = aVar3.BTU.readString();
                    AppMethodBeat.o(56609);
                    return 0;
                case 13:
                    iVar.nWL = aVar3.BTU.readString();
                    AppMethodBeat.o(56609);
                    return 0;
                case 14:
                    iVar.nWM = aVar3.BTU.readString();
                    AppMethodBeat.o(56609);
                    return 0;
                default:
                    AppMethodBeat.o(56609);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56609);
            return -1;
        }
    }
}
