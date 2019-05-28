package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class baa extends a {
    public String csB;
    public boolean wDO;
    public boolean wDP;
    public int wDQ;
    public int wDR;
    public String wDS;
    public boolean wDT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51000);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.wDO);
            aVar.aO(2, this.wDP);
            aVar.iz(3, this.wDQ);
            aVar.iz(4, this.wDR);
            if (this.wDS != null) {
                aVar.e(5, this.wDS);
            }
            aVar.aO(6, this.wDT);
            if (this.csB != null) {
                aVar.e(7, this.csB);
            }
            AppMethodBeat.o(51000);
            return 0;
        } else if (i == 1) {
            fv = ((((e.a.a.b.b.a.fv(1) + 1) + 0) + (e.a.a.b.b.a.fv(2) + 1)) + e.a.a.b.b.a.bs(3, this.wDQ)) + e.a.a.b.b.a.bs(4, this.wDR);
            if (this.wDS != null) {
                fv += e.a.a.b.b.a.f(5, this.wDS);
            }
            fv += e.a.a.b.b.a.fv(6) + 1;
            if (this.csB != null) {
                fv += e.a.a.b.b.a.f(7, this.csB);
            }
            AppMethodBeat.o(51000);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51000);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            baa baa = (baa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    baa.wDO = aVar3.BTU.ehX();
                    AppMethodBeat.o(51000);
                    return 0;
                case 2:
                    baa.wDP = aVar3.BTU.ehX();
                    AppMethodBeat.o(51000);
                    return 0;
                case 3:
                    baa.wDQ = aVar3.BTU.vd();
                    AppMethodBeat.o(51000);
                    return 0;
                case 4:
                    baa.wDR = aVar3.BTU.vd();
                    AppMethodBeat.o(51000);
                    return 0;
                case 5:
                    baa.wDS = aVar3.BTU.readString();
                    AppMethodBeat.o(51000);
                    return 0;
                case 6:
                    baa.wDT = aVar3.BTU.ehX();
                    AppMethodBeat.o(51000);
                    return 0;
                case 7:
                    baa.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(51000);
                    return 0;
                default:
                    AppMethodBeat.o(51000);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51000);
            return -1;
        }
    }
}
