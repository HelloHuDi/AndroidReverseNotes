package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ke extends a {
    public String vMV;
    public String vNb;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11701);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNb != null) {
                aVar.e(2, this.vNb);
            }
            if (this.vMV != null) {
                aVar.e(3, this.vMV);
            }
            AppMethodBeat.o(11701);
            return 0;
        } else if (i == 1) {
            if (this.vNb != null) {
                f = e.a.a.b.b.a.f(2, this.vNb) + 0;
            } else {
                f = 0;
            }
            if (this.vMV != null) {
                f += e.a.a.b.b.a.f(3, this.vMV);
            }
            AppMethodBeat.o(11701);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11701);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ke keVar = (ke) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    keVar.vNb = aVar3.BTU.readString();
                    AppMethodBeat.o(11701);
                    return 0;
                case 3:
                    keVar.vMV = aVar3.BTU.readString();
                    AppMethodBeat.o(11701);
                    return 0;
                default:
                    AppMethodBeat.o(11701);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11701);
            return -1;
        }
    }
}
