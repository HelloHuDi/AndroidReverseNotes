package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class fu extends a {
    public String scope;
    public int state;
    public String vHE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102369);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            if (this.vHE != null) {
                aVar.e(2, this.vHE);
            }
            aVar.iz(3, this.state);
            AppMethodBeat.o(102369);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                f = e.a.a.b.b.a.f(1, this.scope) + 0;
            } else {
                f = 0;
            }
            if (this.vHE != null) {
                f += e.a.a.b.b.a.f(2, this.vHE);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.state);
            AppMethodBeat.o(102369);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102369);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fu fuVar = (fu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fuVar.scope = aVar3.BTU.readString();
                    AppMethodBeat.o(102369);
                    return 0;
                case 2:
                    fuVar.vHE = aVar3.BTU.readString();
                    AppMethodBeat.o(102369);
                    return 0;
                case 3:
                    fuVar.state = aVar3.BTU.vd();
                    AppMethodBeat.o(102369);
                    return 0;
                default:
                    AppMethodBeat.o(102369);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102369);
            return -1;
        }
    }
}
