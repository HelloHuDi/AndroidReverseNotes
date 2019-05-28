package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class hf extends a {
    public String vJP;
    public String vJQ;
    public String vJR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11694);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJP != null) {
                aVar.e(1, this.vJP);
            }
            if (this.vJQ != null) {
                aVar.e(2, this.vJQ);
            }
            if (this.vJR != null) {
                aVar.e(3, this.vJR);
            }
            AppMethodBeat.o(11694);
            return 0;
        } else if (i == 1) {
            if (this.vJP != null) {
                f = e.a.a.b.b.a.f(1, this.vJP) + 0;
            } else {
                f = 0;
            }
            if (this.vJQ != null) {
                f += e.a.a.b.b.a.f(2, this.vJQ);
            }
            if (this.vJR != null) {
                f += e.a.a.b.b.a.f(3, this.vJR);
            }
            AppMethodBeat.o(11694);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11694);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hf hfVar = (hf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hfVar.vJP = aVar3.BTU.readString();
                    AppMethodBeat.o(11694);
                    return 0;
                case 2:
                    hfVar.vJQ = aVar3.BTU.readString();
                    AppMethodBeat.o(11694);
                    return 0;
                case 3:
                    hfVar.vJR = aVar3.BTU.readString();
                    AppMethodBeat.o(11694);
                    return 0;
                default:
                    AppMethodBeat.o(11694);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11694);
            return -1;
        }
    }
}
