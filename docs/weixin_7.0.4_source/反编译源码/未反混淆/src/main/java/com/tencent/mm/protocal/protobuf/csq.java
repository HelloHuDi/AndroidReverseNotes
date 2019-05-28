package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class csq extends a {
    public int Scene;
    public int gtF;
    public String pdu;
    public String wDM;
    public String wUo;
    public String xpS;
    public String xpT;
    public String xpU;
    public String xpV;
    public String xpW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(93804);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xpS != null) {
                aVar.e(1, this.xpS);
            }
            if (this.xpT != null) {
                aVar.e(2, this.xpT);
            }
            if (this.wDM != null) {
                aVar.e(3, this.wDM);
            }
            if (this.wUo != null) {
                aVar.e(4, this.wUo);
            }
            aVar.iz(5, this.gtF);
            if (this.pdu != null) {
                aVar.e(6, this.pdu);
            }
            if (this.xpU != null) {
                aVar.e(7, this.xpU);
            }
            if (this.xpV != null) {
                aVar.e(8, this.xpV);
            }
            aVar.iz(9, this.Scene);
            if (this.xpW != null) {
                aVar.e(19, this.xpW);
            }
            AppMethodBeat.o(93804);
            return 0;
        } else if (i == 1) {
            if (this.xpS != null) {
                f = e.a.a.b.b.a.f(1, this.xpS) + 0;
            } else {
                f = 0;
            }
            if (this.xpT != null) {
                f += e.a.a.b.b.a.f(2, this.xpT);
            }
            if (this.wDM != null) {
                f += e.a.a.b.b.a.f(3, this.wDM);
            }
            if (this.wUo != null) {
                f += e.a.a.b.b.a.f(4, this.wUo);
            }
            f += e.a.a.b.b.a.bs(5, this.gtF);
            if (this.pdu != null) {
                f += e.a.a.b.b.a.f(6, this.pdu);
            }
            if (this.xpU != null) {
                f += e.a.a.b.b.a.f(7, this.xpU);
            }
            if (this.xpV != null) {
                f += e.a.a.b.b.a.f(8, this.xpV);
            }
            f += e.a.a.b.b.a.bs(9, this.Scene);
            if (this.xpW != null) {
                f += e.a.a.b.b.a.f(19, this.xpW);
            }
            AppMethodBeat.o(93804);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(93804);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csq csq = (csq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csq.xpS = aVar3.BTU.readString();
                    AppMethodBeat.o(93804);
                    return 0;
                case 2:
                    csq.xpT = aVar3.BTU.readString();
                    AppMethodBeat.o(93804);
                    return 0;
                case 3:
                    csq.wDM = aVar3.BTU.readString();
                    AppMethodBeat.o(93804);
                    return 0;
                case 4:
                    csq.wUo = aVar3.BTU.readString();
                    AppMethodBeat.o(93804);
                    return 0;
                case 5:
                    csq.gtF = aVar3.BTU.vd();
                    AppMethodBeat.o(93804);
                    return 0;
                case 6:
                    csq.pdu = aVar3.BTU.readString();
                    AppMethodBeat.o(93804);
                    return 0;
                case 7:
                    csq.xpU = aVar3.BTU.readString();
                    AppMethodBeat.o(93804);
                    return 0;
                case 8:
                    csq.xpV = aVar3.BTU.readString();
                    AppMethodBeat.o(93804);
                    return 0;
                case 9:
                    csq.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(93804);
                    return 0;
                case 19:
                    csq.xpW = aVar3.BTU.readString();
                    AppMethodBeat.o(93804);
                    return 0;
                default:
                    AppMethodBeat.o(93804);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93804);
            return -1;
        }
    }
}
