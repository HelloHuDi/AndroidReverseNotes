package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ayu extends a {
    public String luG;
    public double vNH;
    public double vNI;
    public String wCI;
    public String wCJ;
    public String wCK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28541);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.f(1, this.vNI);
            aVar.f(2, this.vNH);
            if (this.luG != null) {
                aVar.e(3, this.luG);
            }
            if (this.wCI != null) {
                aVar.e(4, this.wCI);
            }
            if (this.wCJ != null) {
                aVar.e(5, this.wCJ);
            }
            if (this.wCK != null) {
                aVar.e(6, this.wCK);
            }
            AppMethodBeat.o(28541);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 8) + 0) + (e.a.a.b.b.a.fv(2) + 8);
            if (this.luG != null) {
                fv += e.a.a.b.b.a.f(3, this.luG);
            }
            if (this.wCI != null) {
                fv += e.a.a.b.b.a.f(4, this.wCI);
            }
            if (this.wCJ != null) {
                fv += e.a.a.b.b.a.f(5, this.wCJ);
            }
            if (this.wCK != null) {
                fv += e.a.a.b.b.a.f(6, this.wCK);
            }
            AppMethodBeat.o(28541);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28541);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayu ayu = (ayu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayu.vNI = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(28541);
                    return 0;
                case 2:
                    ayu.vNH = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(28541);
                    return 0;
                case 3:
                    ayu.luG = aVar3.BTU.readString();
                    AppMethodBeat.o(28541);
                    return 0;
                case 4:
                    ayu.wCI = aVar3.BTU.readString();
                    AppMethodBeat.o(28541);
                    return 0;
                case 5:
                    ayu.wCJ = aVar3.BTU.readString();
                    AppMethodBeat.o(28541);
                    return 0;
                case 6:
                    ayu.wCK = aVar3.BTU.readString();
                    AppMethodBeat.o(28541);
                    return 0;
                default:
                    AppMethodBeat.o(28541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28541);
            return -1;
        }
    }
}
