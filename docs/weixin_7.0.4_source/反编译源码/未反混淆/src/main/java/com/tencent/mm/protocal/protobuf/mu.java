package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class mu extends a {
    public String cJF;
    public String ubv;
    public String vQO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48786);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQO != null) {
                aVar.e(1, this.vQO);
            }
            if (this.ubv != null) {
                aVar.e(2, this.ubv);
            }
            if (this.cJF != null) {
                aVar.e(3, this.cJF);
            }
            AppMethodBeat.o(48786);
            return 0;
        } else if (i == 1) {
            if (this.vQO != null) {
                f = e.a.a.b.b.a.f(1, this.vQO) + 0;
            } else {
                f = 0;
            }
            if (this.ubv != null) {
                f += e.a.a.b.b.a.f(2, this.ubv);
            }
            if (this.cJF != null) {
                f += e.a.a.b.b.a.f(3, this.cJF);
            }
            AppMethodBeat.o(48786);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48786);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mu muVar = (mu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    muVar.vQO = aVar3.BTU.readString();
                    AppMethodBeat.o(48786);
                    return 0;
                case 2:
                    muVar.ubv = aVar3.BTU.readString();
                    AppMethodBeat.o(48786);
                    return 0;
                case 3:
                    muVar.cJF = aVar3.BTU.readString();
                    AppMethodBeat.o(48786);
                    return 0;
                default:
                    AppMethodBeat.o(48786);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48786);
            return -1;
        }
    }
}
