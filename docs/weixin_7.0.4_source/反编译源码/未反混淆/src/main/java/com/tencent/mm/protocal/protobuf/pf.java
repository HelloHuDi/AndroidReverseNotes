package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class pf extends a {
    public String cMC;
    public int kbZ;
    public String kfO;
    public int vWx;
    public String vWy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89048);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cMC != null) {
                aVar.e(1, this.cMC);
            }
            if (this.kfO != null) {
                aVar.e(2, this.kfO);
            }
            aVar.iz(3, this.kbZ);
            aVar.iz(4, this.vWx);
            if (this.vWy != null) {
                aVar.e(5, this.vWy);
            }
            AppMethodBeat.o(89048);
            return 0;
        } else if (i == 1) {
            if (this.cMC != null) {
                f = e.a.a.b.b.a.f(1, this.cMC) + 0;
            } else {
                f = 0;
            }
            if (this.kfO != null) {
                f += e.a.a.b.b.a.f(2, this.kfO);
            }
            f = (f + e.a.a.b.b.a.bs(3, this.kbZ)) + e.a.a.b.b.a.bs(4, this.vWx);
            if (this.vWy != null) {
                f += e.a.a.b.b.a.f(5, this.vWy);
            }
            AppMethodBeat.o(89048);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89048);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pf pfVar = (pf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pfVar.cMC = aVar3.BTU.readString();
                    AppMethodBeat.o(89048);
                    return 0;
                case 2:
                    pfVar.kfO = aVar3.BTU.readString();
                    AppMethodBeat.o(89048);
                    return 0;
                case 3:
                    pfVar.kbZ = aVar3.BTU.vd();
                    AppMethodBeat.o(89048);
                    return 0;
                case 4:
                    pfVar.vWx = aVar3.BTU.vd();
                    AppMethodBeat.o(89048);
                    return 0;
                case 5:
                    pfVar.vWy = aVar3.BTU.readString();
                    AppMethodBeat.o(89048);
                    return 0;
                default:
                    AppMethodBeat.o(89048);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89048);
            return -1;
        }
    }
}
