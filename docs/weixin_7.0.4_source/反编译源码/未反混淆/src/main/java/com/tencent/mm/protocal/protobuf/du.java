package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class du extends a {
    public String vFC;
    public String vFD;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94509);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vFC != null) {
                aVar.e(1, this.vFC);
            }
            if (this.vFD != null) {
                aVar.e(2, this.vFD);
            }
            AppMethodBeat.o(94509);
            return 0;
        } else if (i == 1) {
            if (this.vFC != null) {
                f = e.a.a.b.b.a.f(1, this.vFC) + 0;
            } else {
                f = 0;
            }
            if (this.vFD != null) {
                f += e.a.a.b.b.a.f(2, this.vFD);
            }
            AppMethodBeat.o(94509);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94509);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            du duVar = (du) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    duVar.vFC = aVar3.BTU.readString();
                    AppMethodBeat.o(94509);
                    return 0;
                case 2:
                    duVar.vFD = aVar3.BTU.readString();
                    AppMethodBeat.o(94509);
                    return 0;
                default:
                    AppMethodBeat.o(94509);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94509);
            return -1;
        }
    }
}
