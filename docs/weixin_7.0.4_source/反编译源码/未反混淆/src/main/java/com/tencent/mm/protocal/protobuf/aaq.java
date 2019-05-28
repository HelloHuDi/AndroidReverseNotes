package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aaq extends a {
    public int jBT;
    public String vRw;
    public int vRx;
    public String vXB;
    public String vXC;
    public String vXD;
    public int vXE;
    public String wfP;
    public String wfQ;
    public int wfR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51389);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXB != null) {
                aVar.e(1, this.vXB);
            }
            if (this.vXC != null) {
                aVar.e(2, this.vXC);
            }
            if (this.vXD != null) {
                aVar.e(3, this.vXD);
            }
            aVar.iz(4, this.vXE);
            if (this.wfP != null) {
                aVar.e(5, this.wfP);
            }
            if (this.vRw != null) {
                aVar.e(6, this.vRw);
            }
            aVar.iz(7, this.vRx);
            if (this.wfQ != null) {
                aVar.e(8, this.wfQ);
            }
            aVar.iz(9, this.jBT);
            aVar.iz(10, this.wfR);
            AppMethodBeat.o(51389);
            return 0;
        } else if (i == 1) {
            if (this.vXB != null) {
                f = e.a.a.b.b.a.f(1, this.vXB) + 0;
            } else {
                f = 0;
            }
            if (this.vXC != null) {
                f += e.a.a.b.b.a.f(2, this.vXC);
            }
            if (this.vXD != null) {
                f += e.a.a.b.b.a.f(3, this.vXD);
            }
            f += e.a.a.b.b.a.bs(4, this.vXE);
            if (this.wfP != null) {
                f += e.a.a.b.b.a.f(5, this.wfP);
            }
            if (this.vRw != null) {
                f += e.a.a.b.b.a.f(6, this.vRw);
            }
            f += e.a.a.b.b.a.bs(7, this.vRx);
            if (this.wfQ != null) {
                f += e.a.a.b.b.a.f(8, this.wfQ);
            }
            int bs = (f + e.a.a.b.b.a.bs(9, this.jBT)) + e.a.a.b.b.a.bs(10, this.wfR);
            AppMethodBeat.o(51389);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51389);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aaq aaq = (aaq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaq.vXB = aVar3.BTU.readString();
                    AppMethodBeat.o(51389);
                    return 0;
                case 2:
                    aaq.vXC = aVar3.BTU.readString();
                    AppMethodBeat.o(51389);
                    return 0;
                case 3:
                    aaq.vXD = aVar3.BTU.readString();
                    AppMethodBeat.o(51389);
                    return 0;
                case 4:
                    aaq.vXE = aVar3.BTU.vd();
                    AppMethodBeat.o(51389);
                    return 0;
                case 5:
                    aaq.wfP = aVar3.BTU.readString();
                    AppMethodBeat.o(51389);
                    return 0;
                case 6:
                    aaq.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(51389);
                    return 0;
                case 7:
                    aaq.vRx = aVar3.BTU.vd();
                    AppMethodBeat.o(51389);
                    return 0;
                case 8:
                    aaq.wfQ = aVar3.BTU.readString();
                    AppMethodBeat.o(51389);
                    return 0;
                case 9:
                    aaq.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(51389);
                    return 0;
                case 10:
                    aaq.wfR = aVar3.BTU.vd();
                    AppMethodBeat.o(51389);
                    return 0;
                default:
                    AppMethodBeat.o(51389);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51389);
            return -1;
        }
    }
}
