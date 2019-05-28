package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bnc extends a {
    public String data;
    public String kdG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89123);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kdG != null) {
                aVar.e(1, this.kdG);
            }
            if (this.data != null) {
                aVar.e(2, this.data);
            }
            AppMethodBeat.o(89123);
            return 0;
        } else if (i == 1) {
            if (this.kdG != null) {
                f = e.a.a.b.b.a.f(1, this.kdG) + 0;
            } else {
                f = 0;
            }
            if (this.data != null) {
                f += e.a.a.b.b.a.f(2, this.data);
            }
            AppMethodBeat.o(89123);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89123);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnc bnc = (bnc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnc.kdG = aVar3.BTU.readString();
                    AppMethodBeat.o(89123);
                    return 0;
                case 2:
                    bnc.data = aVar3.BTU.readString();
                    AppMethodBeat.o(89123);
                    return 0;
                default:
                    AppMethodBeat.o(89123);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89123);
            return -1;
        }
    }
}
