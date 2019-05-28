package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bzt extends a {
    public String wYO;
    public String wYP;
    public String wYQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28657);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYO != null) {
                aVar.e(1, this.wYO);
            }
            if (this.wYP != null) {
                aVar.e(2, this.wYP);
            }
            if (this.wYQ != null) {
                aVar.e(3, this.wYQ);
            }
            AppMethodBeat.o(28657);
            return 0;
        } else if (i == 1) {
            if (this.wYO != null) {
                f = e.a.a.b.b.a.f(1, this.wYO) + 0;
            } else {
                f = 0;
            }
            if (this.wYP != null) {
                f += e.a.a.b.b.a.f(2, this.wYP);
            }
            if (this.wYQ != null) {
                f += e.a.a.b.b.a.f(3, this.wYQ);
            }
            AppMethodBeat.o(28657);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28657);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzt bzt = (bzt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzt.wYO = aVar3.BTU.readString();
                    AppMethodBeat.o(28657);
                    return 0;
                case 2:
                    bzt.wYP = aVar3.BTU.readString();
                    AppMethodBeat.o(28657);
                    return 0;
                case 3:
                    bzt.wYQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28657);
                    return 0;
                default:
                    AppMethodBeat.o(28657);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28657);
            return -1;
        }
    }
}
