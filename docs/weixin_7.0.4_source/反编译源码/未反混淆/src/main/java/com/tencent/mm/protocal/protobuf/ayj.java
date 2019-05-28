package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ayj extends a {
    public String vLl;
    public String vLm;
    public String vLn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60043);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLm != null) {
                aVar.e(1, this.vLm);
            }
            if (this.vLl != null) {
                aVar.e(2, this.vLl);
            }
            if (this.vLn != null) {
                aVar.e(3, this.vLn);
            }
            AppMethodBeat.o(60043);
            return 0;
        } else if (i == 1) {
            if (this.vLm != null) {
                f = e.a.a.b.b.a.f(1, this.vLm) + 0;
            } else {
                f = 0;
            }
            if (this.vLl != null) {
                f += e.a.a.b.b.a.f(2, this.vLl);
            }
            if (this.vLn != null) {
                f += e.a.a.b.b.a.f(3, this.vLn);
            }
            AppMethodBeat.o(60043);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60043);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayj ayj = (ayj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayj.vLm = aVar3.BTU.readString();
                    AppMethodBeat.o(60043);
                    return 0;
                case 2:
                    ayj.vLl = aVar3.BTU.readString();
                    AppMethodBeat.o(60043);
                    return 0;
                case 3:
                    ayj.vLn = aVar3.BTU.readString();
                    AppMethodBeat.o(60043);
                    return 0;
                default:
                    AppMethodBeat.o(60043);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60043);
            return -1;
        }
    }
}
