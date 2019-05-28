package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class axh extends a {
    public String value;
    public String wBp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(851);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wBp != null) {
                aVar.e(1, this.wBp);
            }
            if (this.value != null) {
                aVar.e(2, this.value);
            }
            AppMethodBeat.o(851);
            return 0;
        } else if (i == 1) {
            if (this.wBp != null) {
                f = e.a.a.b.b.a.f(1, this.wBp) + 0;
            } else {
                f = 0;
            }
            if (this.value != null) {
                f += e.a.a.b.b.a.f(2, this.value);
            }
            AppMethodBeat.o(851);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(851);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axh axh = (axh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axh.wBp = aVar3.BTU.readString();
                    AppMethodBeat.o(851);
                    return 0;
                case 2:
                    axh.value = aVar3.BTU.readString();
                    AppMethodBeat.o(851);
                    return 0;
                default:
                    AppMethodBeat.o(851);
                    return -1;
            }
        } else {
            AppMethodBeat.o(851);
            return -1;
        }
    }
}
