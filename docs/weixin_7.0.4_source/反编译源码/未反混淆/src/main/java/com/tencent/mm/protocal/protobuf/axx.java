package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class axx extends a {
    public float vRp;
    public float vRq;
    public int wfG;
    public String wfH;
    public String wfI;
    public int wfJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80113);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.r(1, this.vRp);
            aVar.r(2, this.vRq);
            aVar.iz(3, this.wfG);
            if (this.wfH != null) {
                aVar.e(4, this.wfH);
            }
            if (this.wfI != null) {
                aVar.e(5, this.wfI);
            }
            aVar.iz(6, this.wfJ);
            AppMethodBeat.o(80113);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 4) + 0) + (e.a.a.b.b.a.fv(2) + 4)) + e.a.a.b.b.a.bs(3, this.wfG);
            if (this.wfH != null) {
                fv += e.a.a.b.b.a.f(4, this.wfH);
            }
            if (this.wfI != null) {
                fv += e.a.a.b.b.a.f(5, this.wfI);
            }
            fv += e.a.a.b.b.a.bs(6, this.wfJ);
            AppMethodBeat.o(80113);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80113);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axx axx = (axx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axx.vRp = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(80113);
                    return 0;
                case 2:
                    axx.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(80113);
                    return 0;
                case 3:
                    axx.wfG = aVar3.BTU.vd();
                    AppMethodBeat.o(80113);
                    return 0;
                case 4:
                    axx.wfH = aVar3.BTU.readString();
                    AppMethodBeat.o(80113);
                    return 0;
                case 5:
                    axx.wfI = aVar3.BTU.readString();
                    AppMethodBeat.o(80113);
                    return 0;
                case 6:
                    axx.wfJ = aVar3.BTU.vd();
                    AppMethodBeat.o(80113);
                    return 0;
                default:
                    AppMethodBeat.o(80113);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80113);
            return -1;
        }
    }
}
