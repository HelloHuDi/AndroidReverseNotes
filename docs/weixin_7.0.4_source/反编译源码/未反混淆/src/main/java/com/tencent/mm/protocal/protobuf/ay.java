package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ay extends a {
    public boolean vCK;
    public boolean vCL;
    public int vCM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96189);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.vCK);
            aVar.aO(2, this.vCL);
            aVar.iz(3, this.vCM);
            AppMethodBeat.o(96189);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 1) + 0) + (e.a.a.b.b.a.fv(2) + 1)) + e.a.a.b.b.a.bs(3, this.vCM);
            AppMethodBeat.o(96189);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96189);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ay ayVar = (ay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayVar.vCK = aVar3.BTU.ehX();
                    AppMethodBeat.o(96189);
                    return 0;
                case 2:
                    ayVar.vCL = aVar3.BTU.ehX();
                    AppMethodBeat.o(96189);
                    return 0;
                case 3:
                    ayVar.vCM = aVar3.BTU.vd();
                    AppMethodBeat.o(96189);
                    return 0;
                default:
                    AppMethodBeat.o(96189);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96189);
            return -1;
        }
    }
}
