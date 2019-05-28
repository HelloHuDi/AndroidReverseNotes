package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class brm extends a {
    public int ndr;
    public String vMR;
    public long wTJ;
    public int wTK;
    public boolean wTL;
    public boolean wTM;
    public int wTN;
    public boolean wTO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11801);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMR != null) {
                aVar.e(1, this.vMR);
            }
            aVar.ai(2, this.wTJ);
            aVar.iz(3, this.wTK);
            aVar.aO(4, this.wTL);
            aVar.aO(5, this.wTM);
            aVar.iz(6, this.wTN);
            aVar.iz(7, this.ndr);
            aVar.aO(8, this.wTO);
            AppMethodBeat.o(11801);
            return 0;
        } else if (i == 1) {
            if (this.vMR != null) {
                f = e.a.a.b.b.a.f(1, this.vMR) + 0;
            } else {
                f = 0;
            }
            int o = ((((((f + e.a.a.b.b.a.o(2, this.wTJ)) + e.a.a.b.b.a.bs(3, this.wTK)) + (e.a.a.b.b.a.fv(4) + 1)) + (e.a.a.b.b.a.fv(5) + 1)) + e.a.a.b.b.a.bs(6, this.wTN)) + e.a.a.b.b.a.bs(7, this.ndr)) + (e.a.a.b.b.a.fv(8) + 1);
            AppMethodBeat.o(11801);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11801);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brm brm = (brm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brm.vMR = aVar3.BTU.readString();
                    AppMethodBeat.o(11801);
                    return 0;
                case 2:
                    brm.wTJ = aVar3.BTU.ve();
                    AppMethodBeat.o(11801);
                    return 0;
                case 3:
                    brm.wTK = aVar3.BTU.vd();
                    AppMethodBeat.o(11801);
                    return 0;
                case 4:
                    brm.wTL = aVar3.BTU.ehX();
                    AppMethodBeat.o(11801);
                    return 0;
                case 5:
                    brm.wTM = aVar3.BTU.ehX();
                    AppMethodBeat.o(11801);
                    return 0;
                case 6:
                    brm.wTN = aVar3.BTU.vd();
                    AppMethodBeat.o(11801);
                    return 0;
                case 7:
                    brm.ndr = aVar3.BTU.vd();
                    AppMethodBeat.o(11801);
                    return 0;
                case 8:
                    brm.wTO = aVar3.BTU.ehX();
                    AppMethodBeat.o(11801);
                    return 0;
                default:
                    AppMethodBeat.o(11801);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11801);
            return -1;
        }
    }
}
