package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class f extends a {
    public String tmO;
    public String tmP;
    public String tmQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56647);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.tmO != null) {
                aVar.e(1, this.tmO);
            }
            if (this.tmP != null) {
                aVar.e(2, this.tmP);
            }
            if (this.tmQ != null) {
                aVar.e(3, this.tmQ);
            }
            AppMethodBeat.o(56647);
            return 0;
        } else if (i == 1) {
            if (this.tmO != null) {
                f = e.a.a.b.b.a.f(1, this.tmO) + 0;
            } else {
                f = 0;
            }
            if (this.tmP != null) {
                f += e.a.a.b.b.a.f(2, this.tmP);
            }
            if (this.tmQ != null) {
                f += e.a.a.b.b.a.f(3, this.tmQ);
            }
            AppMethodBeat.o(56647);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56647);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.tmO = aVar3.BTU.readString();
                    AppMethodBeat.o(56647);
                    return 0;
                case 2:
                    fVar.tmP = aVar3.BTU.readString();
                    AppMethodBeat.o(56647);
                    return 0;
                case 3:
                    fVar.tmQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56647);
                    return 0;
                default:
                    AppMethodBeat.o(56647);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56647);
            return -1;
        }
    }
}
