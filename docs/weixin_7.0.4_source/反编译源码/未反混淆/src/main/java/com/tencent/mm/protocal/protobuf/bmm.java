package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bmm extends a {
    public String cDL;
    public String cvZ;
    public String url;
    public int version;
    public boolean wPt;
    public int wPu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96282);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.wPt);
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.cvZ != null) {
                aVar.e(3, this.cvZ);
            }
            aVar.iz(4, this.version);
            aVar.iz(5, this.wPu);
            if (this.cDL != null) {
                aVar.e(6, this.cDL);
            }
            AppMethodBeat.o(96282);
            return 0;
        } else if (i == 1) {
            fv = (e.a.a.b.b.a.fv(1) + 1) + 0;
            if (this.url != null) {
                fv += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.cvZ != null) {
                fv += e.a.a.b.b.a.f(3, this.cvZ);
            }
            fv = (fv + e.a.a.b.b.a.bs(4, this.version)) + e.a.a.b.b.a.bs(5, this.wPu);
            if (this.cDL != null) {
                fv += e.a.a.b.b.a.f(6, this.cDL);
            }
            AppMethodBeat.o(96282);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96282);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmm bmm = (bmm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmm.wPt = aVar3.BTU.ehX();
                    AppMethodBeat.o(96282);
                    return 0;
                case 2:
                    bmm.url = aVar3.BTU.readString();
                    AppMethodBeat.o(96282);
                    return 0;
                case 3:
                    bmm.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(96282);
                    return 0;
                case 4:
                    bmm.version = aVar3.BTU.vd();
                    AppMethodBeat.o(96282);
                    return 0;
                case 5:
                    bmm.wPu = aVar3.BTU.vd();
                    AppMethodBeat.o(96282);
                    return 0;
                case 6:
                    bmm.cDL = aVar3.BTU.readString();
                    AppMethodBeat.o(96282);
                    return 0;
                default:
                    AppMethodBeat.o(96282);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96282);
            return -1;
        }
    }
}
