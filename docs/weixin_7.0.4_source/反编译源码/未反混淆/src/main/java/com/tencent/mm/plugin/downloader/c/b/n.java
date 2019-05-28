package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class n extends a {
    public String egm;
    public int kLK;
    public String kLL;
    public String kLM;
    public String kLN;
    public String kLO;
    public int kLP;
    public String kLQ;
    public String kLR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35540);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.kLK);
            if (this.egm != null) {
                aVar.e(2, this.egm);
            }
            if (this.kLL != null) {
                aVar.e(3, this.kLL);
            }
            if (this.kLM != null) {
                aVar.e(4, this.kLM);
            }
            if (this.kLN != null) {
                aVar.e(5, this.kLN);
            }
            if (this.kLO != null) {
                aVar.e(6, this.kLO);
            }
            aVar.iz(7, this.kLP);
            if (this.kLQ != null) {
                aVar.e(8, this.kLQ);
            }
            if (this.kLR != null) {
                aVar.e(9, this.kLR);
            }
            AppMethodBeat.o(35540);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.kLK) + 0;
            if (this.egm != null) {
                bs += e.a.a.b.b.a.f(2, this.egm);
            }
            if (this.kLL != null) {
                bs += e.a.a.b.b.a.f(3, this.kLL);
            }
            if (this.kLM != null) {
                bs += e.a.a.b.b.a.f(4, this.kLM);
            }
            if (this.kLN != null) {
                bs += e.a.a.b.b.a.f(5, this.kLN);
            }
            if (this.kLO != null) {
                bs += e.a.a.b.b.a.f(6, this.kLO);
            }
            bs += e.a.a.b.b.a.bs(7, this.kLP);
            if (this.kLQ != null) {
                bs += e.a.a.b.b.a.f(8, this.kLQ);
            }
            if (this.kLR != null) {
                bs += e.a.a.b.b.a.f(9, this.kLR);
            }
            AppMethodBeat.o(35540);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35540);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.kLK = aVar3.BTU.vd();
                    AppMethodBeat.o(35540);
                    return 0;
                case 2:
                    nVar.egm = aVar3.BTU.readString();
                    AppMethodBeat.o(35540);
                    return 0;
                case 3:
                    nVar.kLL = aVar3.BTU.readString();
                    AppMethodBeat.o(35540);
                    return 0;
                case 4:
                    nVar.kLM = aVar3.BTU.readString();
                    AppMethodBeat.o(35540);
                    return 0;
                case 5:
                    nVar.kLN = aVar3.BTU.readString();
                    AppMethodBeat.o(35540);
                    return 0;
                case 6:
                    nVar.kLO = aVar3.BTU.readString();
                    AppMethodBeat.o(35540);
                    return 0;
                case 7:
                    nVar.kLP = aVar3.BTU.vd();
                    AppMethodBeat.o(35540);
                    return 0;
                case 8:
                    nVar.kLQ = aVar3.BTU.readString();
                    AppMethodBeat.o(35540);
                    return 0;
                case 9:
                    nVar.kLR = aVar3.BTU.readString();
                    AppMethodBeat.o(35540);
                    return 0;
                default:
                    AppMethodBeat.o(35540);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35540);
            return -1;
        }
    }
}
