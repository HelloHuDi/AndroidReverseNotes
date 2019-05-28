package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class asa extends a {
    public String nuQ;
    public String wcQ;
    public int wcR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102381);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcQ != null) {
                aVar.e(1, this.wcQ);
            }
            aVar.iz(2, this.wcR);
            if (this.nuQ != null) {
                aVar.e(3, this.nuQ);
            }
            AppMethodBeat.o(102381);
            return 0;
        } else if (i == 1) {
            if (this.wcQ != null) {
                f = e.a.a.b.b.a.f(1, this.wcQ) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wcR);
            if (this.nuQ != null) {
                f += e.a.a.b.b.a.f(3, this.nuQ);
            }
            AppMethodBeat.o(102381);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102381);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asa asa = (asa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asa.wcQ = aVar3.BTU.readString();
                    AppMethodBeat.o(102381);
                    return 0;
                case 2:
                    asa.wcR = aVar3.BTU.vd();
                    AppMethodBeat.o(102381);
                    return 0;
                case 3:
                    asa.nuQ = aVar3.BTU.readString();
                    AppMethodBeat.o(102381);
                    return 0;
                default:
                    AppMethodBeat.o(102381);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102381);
            return -1;
        }
    }
}
