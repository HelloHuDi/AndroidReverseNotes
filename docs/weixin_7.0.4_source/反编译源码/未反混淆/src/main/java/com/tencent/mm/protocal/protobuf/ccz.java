package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ccz extends a {
    public String appName;
    public int bIb;
    public String xcF;
    public boolean xcG;
    public boolean xcH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55723);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xcF != null) {
                aVar.e(1, this.xcF);
            }
            if (this.appName != null) {
                aVar.e(2, this.appName);
            }
            aVar.iz(3, this.bIb);
            aVar.aO(4, this.xcG);
            aVar.aO(5, this.xcH);
            AppMethodBeat.o(55723);
            return 0;
        } else if (i == 1) {
            if (this.xcF != null) {
                f = e.a.a.b.b.a.f(1, this.xcF) + 0;
            } else {
                f = 0;
            }
            if (this.appName != null) {
                f += e.a.a.b.b.a.f(2, this.appName);
            }
            int bs = ((f + e.a.a.b.b.a.bs(3, this.bIb)) + (e.a.a.b.b.a.fv(4) + 1)) + (e.a.a.b.b.a.fv(5) + 1);
            AppMethodBeat.o(55723);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55723);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccz ccz = (ccz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccz.xcF = aVar3.BTU.readString();
                    AppMethodBeat.o(55723);
                    return 0;
                case 2:
                    ccz.appName = aVar3.BTU.readString();
                    AppMethodBeat.o(55723);
                    return 0;
                case 3:
                    ccz.bIb = aVar3.BTU.vd();
                    AppMethodBeat.o(55723);
                    return 0;
                case 4:
                    ccz.xcG = aVar3.BTU.ehX();
                    AppMethodBeat.o(55723);
                    return 0;
                case 5:
                    ccz.xcH = aVar3.BTU.ehX();
                    AppMethodBeat.o(55723);
                    return 0;
                default:
                    AppMethodBeat.o(55723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55723);
            return -1;
        }
    }
}
