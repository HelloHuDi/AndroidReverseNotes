package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aq extends a {
    public String kcU;
    public String kcV;
    public String kcW;
    public String kcX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89002);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kcU != null) {
                aVar.e(1, this.kcU);
            }
            if (this.kcV != null) {
                aVar.e(2, this.kcV);
            }
            if (this.kcW != null) {
                aVar.e(3, this.kcW);
            }
            if (this.kcX != null) {
                aVar.e(4, this.kcX);
            }
            AppMethodBeat.o(89002);
            return 0;
        } else if (i == 1) {
            if (this.kcU != null) {
                f = e.a.a.b.b.a.f(1, this.kcU) + 0;
            } else {
                f = 0;
            }
            if (this.kcV != null) {
                f += e.a.a.b.b.a.f(2, this.kcV);
            }
            if (this.kcW != null) {
                f += e.a.a.b.b.a.f(3, this.kcW);
            }
            if (this.kcX != null) {
                f += e.a.a.b.b.a.f(4, this.kcX);
            }
            AppMethodBeat.o(89002);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89002);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aq aqVar = (aq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aqVar.kcU = aVar3.BTU.readString();
                    AppMethodBeat.o(89002);
                    return 0;
                case 2:
                    aqVar.kcV = aVar3.BTU.readString();
                    AppMethodBeat.o(89002);
                    return 0;
                case 3:
                    aqVar.kcW = aVar3.BTU.readString();
                    AppMethodBeat.o(89002);
                    return 0;
                case 4:
                    aqVar.kcX = aVar3.BTU.readString();
                    AppMethodBeat.o(89002);
                    return 0;
                default:
                    AppMethodBeat.o(89002);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89002);
            return -1;
        }
    }
}
