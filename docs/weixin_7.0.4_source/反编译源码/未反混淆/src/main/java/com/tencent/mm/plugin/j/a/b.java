package com.tencent.mm.plugin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class b extends a {
    public String dtV;
    public int nuH;
    public String nuI;
    public String nuJ;
    public String nuK;
    public String nuL;
    public String nuM;
    public String nuN;
    public String nuO;
    public String nuP;
    public String nuQ;
    public String title;
    public String type;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(21657);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.nuH);
            if (this.type != null) {
                aVar.e(2, this.type);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.nuI != null) {
                aVar.e(4, this.nuI);
            }
            if (this.nuJ != null) {
                aVar.e(5, this.nuJ);
            }
            if (this.nuK != null) {
                aVar.e(6, this.nuK);
            }
            if (this.nuL != null) {
                aVar.e(7, this.nuL);
            }
            if (this.nuM != null) {
                aVar.e(8, this.nuM);
            }
            if (this.nuN != null) {
                aVar.e(9, this.nuN);
            }
            if (this.nuO != null) {
                aVar.e(10, this.nuO);
            }
            if (this.dtV != null) {
                aVar.e(11, this.dtV);
            }
            if (this.nuP != null) {
                aVar.e(12, this.nuP);
            }
            if (this.nuQ != null) {
                aVar.e(13, this.nuQ);
            }
            AppMethodBeat.o(21657);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.nuH) + 0;
            if (this.type != null) {
                bs += e.a.a.b.b.a.f(2, this.type);
            }
            if (this.title != null) {
                bs += e.a.a.b.b.a.f(3, this.title);
            }
            if (this.nuI != null) {
                bs += e.a.a.b.b.a.f(4, this.nuI);
            }
            if (this.nuJ != null) {
                bs += e.a.a.b.b.a.f(5, this.nuJ);
            }
            if (this.nuK != null) {
                bs += e.a.a.b.b.a.f(6, this.nuK);
            }
            if (this.nuL != null) {
                bs += e.a.a.b.b.a.f(7, this.nuL);
            }
            if (this.nuM != null) {
                bs += e.a.a.b.b.a.f(8, this.nuM);
            }
            if (this.nuN != null) {
                bs += e.a.a.b.b.a.f(9, this.nuN);
            }
            if (this.nuO != null) {
                bs += e.a.a.b.b.a.f(10, this.nuO);
            }
            if (this.dtV != null) {
                bs += e.a.a.b.b.a.f(11, this.dtV);
            }
            if (this.nuP != null) {
                bs += e.a.a.b.b.a.f(12, this.nuP);
            }
            if (this.nuQ != null) {
                bs += e.a.a.b.b.a.f(13, this.nuQ);
            }
            AppMethodBeat.o(21657);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(21657);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.nuH = aVar3.BTU.vd();
                    AppMethodBeat.o(21657);
                    return 0;
                case 2:
                    bVar.type = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 3:
                    bVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 4:
                    bVar.nuI = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 5:
                    bVar.nuJ = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 6:
                    bVar.nuK = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 7:
                    bVar.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 8:
                    bVar.nuM = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 9:
                    bVar.nuN = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 10:
                    bVar.nuO = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 11:
                    bVar.dtV = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 12:
                    bVar.nuP = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                case 13:
                    bVar.nuQ = aVar3.BTU.readString();
                    AppMethodBeat.o(21657);
                    return 0;
                default:
                    AppMethodBeat.o(21657);
                    return -1;
            }
        } else {
            AppMethodBeat.o(21657);
            return -1;
        }
    }
}
