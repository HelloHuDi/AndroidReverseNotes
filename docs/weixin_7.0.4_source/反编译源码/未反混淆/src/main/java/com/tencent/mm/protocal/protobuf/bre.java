package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class bre extends a {
    public int jCt;
    public int lvf;
    public int wOI;
    public String wTy;
    public b wcJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(118282);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wTy != null) {
                aVar.e(1, this.wTy);
            }
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.lvf);
            aVar.iz(4, this.wOI);
            if (this.wcJ != null) {
                aVar.c(5, this.wcJ);
            }
            AppMethodBeat.o(118282);
            return 0;
        } else if (i == 1) {
            if (this.wTy != null) {
                f = e.a.a.b.b.a.f(1, this.wTy) + 0;
            } else {
                f = 0;
            }
            f = ((f + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.lvf)) + e.a.a.b.b.a.bs(4, this.wOI);
            if (this.wcJ != null) {
                f += e.a.a.b.b.a.b(5, this.wcJ);
            }
            AppMethodBeat.o(118282);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(118282);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bre bre = (bre) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bre.wTy = aVar3.BTU.readString();
                    AppMethodBeat.o(118282);
                    return 0;
                case 2:
                    bre.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(118282);
                    return 0;
                case 3:
                    bre.lvf = aVar3.BTU.vd();
                    AppMethodBeat.o(118282);
                    return 0;
                case 4:
                    bre.wOI = aVar3.BTU.vd();
                    AppMethodBeat.o(118282);
                    return 0;
                case 5:
                    bre.wcJ = aVar3.BTU.emu();
                    AppMethodBeat.o(118282);
                    return 0;
                default:
                    AppMethodBeat.o(118282);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118282);
            return -1;
        }
    }
}
