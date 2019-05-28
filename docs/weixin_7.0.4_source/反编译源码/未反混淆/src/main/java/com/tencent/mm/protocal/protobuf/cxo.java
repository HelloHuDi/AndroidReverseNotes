package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cxo extends a {
    public String session_id;
    public String xrS;
    public int xsP;
    public int xsQ;
    public String xsR;
    public int xsS;
    public boolean xsT = false;
    public boolean xsU = false;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124389);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xsP);
            aVar.iz(2, this.xsQ);
            if (this.session_id != null) {
                aVar.e(3, this.session_id);
            }
            if (this.xsR != null) {
                aVar.e(4, this.xsR);
            }
            if (this.xrS != null) {
                aVar.e(5, this.xrS);
            }
            aVar.iz(6, this.xsS);
            aVar.aO(7, this.xsT);
            aVar.aO(8, this.xsU);
            AppMethodBeat.o(124389);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.xsP) + 0) + e.a.a.b.b.a.bs(2, this.xsQ);
            if (this.session_id != null) {
                bs += e.a.a.b.b.a.f(3, this.session_id);
            }
            if (this.xsR != null) {
                bs += e.a.a.b.b.a.f(4, this.xsR);
            }
            if (this.xrS != null) {
                bs += e.a.a.b.b.a.f(5, this.xrS);
            }
            bs = ((bs + e.a.a.b.b.a.bs(6, this.xsS)) + (e.a.a.b.b.a.fv(7) + 1)) + (e.a.a.b.b.a.fv(8) + 1);
            AppMethodBeat.o(124389);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124389);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxo cxo = (cxo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxo.xsP = aVar3.BTU.vd();
                    AppMethodBeat.o(124389);
                    return 0;
                case 2:
                    cxo.xsQ = aVar3.BTU.vd();
                    AppMethodBeat.o(124389);
                    return 0;
                case 3:
                    cxo.session_id = aVar3.BTU.readString();
                    AppMethodBeat.o(124389);
                    return 0;
                case 4:
                    cxo.xsR = aVar3.BTU.readString();
                    AppMethodBeat.o(124389);
                    return 0;
                case 5:
                    cxo.xrS = aVar3.BTU.readString();
                    AppMethodBeat.o(124389);
                    return 0;
                case 6:
                    cxo.xsS = aVar3.BTU.vd();
                    AppMethodBeat.o(124389);
                    return 0;
                case 7:
                    cxo.xsT = aVar3.BTU.ehX();
                    AppMethodBeat.o(124389);
                    return 0;
                case 8:
                    cxo.xsU = aVar3.BTU.ehX();
                    AppMethodBeat.o(124389);
                    return 0;
                default:
                    AppMethodBeat.o(124389);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124389);
            return -1;
        }
    }
}
