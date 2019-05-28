package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class arv extends a {
    public String vLf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73721);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLf != null) {
                aVar.e(1, this.vLf);
            }
            AppMethodBeat.o(73721);
            return 0;
        } else if (i == 1) {
            if (this.vLf != null) {
                f = e.a.a.b.b.a.f(1, this.vLf) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.o(73721);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73721);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arv arv = (arv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arv.vLf = aVar3.BTU.readString();
                    AppMethodBeat.o(73721);
                    return 0;
                default:
                    AppMethodBeat.o(73721);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73721);
            return -1;
        }
    }
}
