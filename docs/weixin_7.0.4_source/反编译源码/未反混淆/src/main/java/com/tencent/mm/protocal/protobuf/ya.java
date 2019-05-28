package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ya extends a {
    public String wdK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62525);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wdK == null) {
                bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(62525);
                throw bVar;
            }
            if (this.wdK != null) {
                aVar.e(1, this.wdK);
            }
            AppMethodBeat.o(62525);
            return 0;
        } else if (i == 1) {
            if (this.wdK != null) {
                f = e.a.a.b.b.a.f(1, this.wdK) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.o(62525);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wdK == null) {
                bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(62525);
                throw bVar;
            }
            AppMethodBeat.o(62525);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ya yaVar = (ya) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yaVar.wdK = aVar3.BTU.readString();
                    AppMethodBeat.o(62525);
                    return 0;
                default:
                    AppMethodBeat.o(62525);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62525);
            return -1;
        }
    }
}
