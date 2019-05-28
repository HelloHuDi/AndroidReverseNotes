package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cwa extends a {
    public String mZW;
    public String wCW;
    public String xrU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11824);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xrU != null) {
                aVar.e(1, this.xrU);
            }
            if (this.mZW != null) {
                aVar.e(2, this.mZW);
            }
            if (this.wCW != null) {
                aVar.e(3, this.wCW);
            }
            AppMethodBeat.o(11824);
            return 0;
        } else if (i == 1) {
            if (this.xrU != null) {
                f = e.a.a.b.b.a.f(1, this.xrU) + 0;
            } else {
                f = 0;
            }
            if (this.mZW != null) {
                f += e.a.a.b.b.a.f(2, this.mZW);
            }
            if (this.wCW != null) {
                f += e.a.a.b.b.a.f(3, this.wCW);
            }
            AppMethodBeat.o(11824);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11824);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwa cwa = (cwa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwa.xrU = aVar3.BTU.readString();
                    AppMethodBeat.o(11824);
                    return 0;
                case 2:
                    cwa.mZW = aVar3.BTU.readString();
                    AppMethodBeat.o(11824);
                    return 0;
                case 3:
                    cwa.wCW = aVar3.BTU.readString();
                    AppMethodBeat.o(11824);
                    return 0;
                default:
                    AppMethodBeat.o(11824);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11824);
            return -1;
        }
    }
}
