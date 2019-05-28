package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class axy extends a {
    public float vRp;
    public float vRq;
    public String wCf;
    public int wfG;
    public String wfH;
    public String wfI;
    public int wfJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124320);
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
            if (this.wCf != null) {
                aVar.e(7, this.wCf);
            }
            AppMethodBeat.o(124320);
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
            if (this.wCf != null) {
                fv += e.a.a.b.b.a.f(7, this.wCf);
            }
            AppMethodBeat.o(124320);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124320);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axy axy = (axy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axy.vRp = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(124320);
                    return 0;
                case 2:
                    axy.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(124320);
                    return 0;
                case 3:
                    axy.wfG = aVar3.BTU.vd();
                    AppMethodBeat.o(124320);
                    return 0;
                case 4:
                    axy.wfH = aVar3.BTU.readString();
                    AppMethodBeat.o(124320);
                    return 0;
                case 5:
                    axy.wfI = aVar3.BTU.readString();
                    AppMethodBeat.o(124320);
                    return 0;
                case 6:
                    axy.wfJ = aVar3.BTU.vd();
                    AppMethodBeat.o(124320);
                    return 0;
                case 7:
                    axy.wCf = aVar3.BTU.readString();
                    AppMethodBeat.o(124320);
                    return 0;
                default:
                    AppMethodBeat.o(124320);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124320);
            return -1;
        }
    }
}
