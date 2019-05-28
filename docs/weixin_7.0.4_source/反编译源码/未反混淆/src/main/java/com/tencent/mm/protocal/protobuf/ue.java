package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ue extends a {
    public String wbI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124311);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wbI != null) {
                aVar.e(4, this.wbI);
            }
            AppMethodBeat.o(124311);
            return 0;
        } else if (i == 1) {
            if (this.wbI != null) {
                f = e.a.a.b.b.a.f(4, this.wbI) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.o(124311);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124311);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ue ueVar = (ue) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 4:
                    ueVar.wbI = aVar3.BTU.readString();
                    AppMethodBeat.o(124311);
                    return 0;
                default:
                    AppMethodBeat.o(124311);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124311);
            return -1;
        }
    }
}
