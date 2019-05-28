package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class om extends a {
    public String vUO;
    public String vUP;
    public int vUQ;
    public int vUR;
    public int vUS;
    public int vUT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96210);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUO != null) {
                aVar.e(1, this.vUO);
            }
            if (this.vUP != null) {
                aVar.e(2, this.vUP);
            }
            aVar.iz(3, this.vUQ);
            aVar.iz(4, this.vUR);
            aVar.iz(5, this.vUS);
            aVar.iz(6, this.vUT);
            AppMethodBeat.o(96210);
            return 0;
        } else if (i == 1) {
            if (this.vUO != null) {
                f = e.a.a.b.b.a.f(1, this.vUO) + 0;
            } else {
                f = 0;
            }
            if (this.vUP != null) {
                f += e.a.a.b.b.a.f(2, this.vUP);
            }
            int bs = (((f + e.a.a.b.b.a.bs(3, this.vUQ)) + e.a.a.b.b.a.bs(4, this.vUR)) + e.a.a.b.b.a.bs(5, this.vUS)) + e.a.a.b.b.a.bs(6, this.vUT);
            AppMethodBeat.o(96210);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96210);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            om omVar = (om) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    omVar.vUO = aVar3.BTU.readString();
                    AppMethodBeat.o(96210);
                    return 0;
                case 2:
                    omVar.vUP = aVar3.BTU.readString();
                    AppMethodBeat.o(96210);
                    return 0;
                case 3:
                    omVar.vUQ = aVar3.BTU.vd();
                    AppMethodBeat.o(96210);
                    return 0;
                case 4:
                    omVar.vUR = aVar3.BTU.vd();
                    AppMethodBeat.o(96210);
                    return 0;
                case 5:
                    omVar.vUS = aVar3.BTU.vd();
                    AppMethodBeat.o(96210);
                    return 0;
                case 6:
                    omVar.vUT = aVar3.BTU.vd();
                    AppMethodBeat.o(96210);
                    return 0;
                default:
                    AppMethodBeat.o(96210);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96210);
            return -1;
        }
    }
}
