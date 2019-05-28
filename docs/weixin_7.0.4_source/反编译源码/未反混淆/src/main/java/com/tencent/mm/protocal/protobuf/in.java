package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class in extends a {
    public String vKF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10154);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKF == null) {
                bVar = new b("Not all required fields were included: Mac");
                AppMethodBeat.o(10154);
                throw bVar;
            }
            if (this.vKF != null) {
                aVar.e(1, this.vKF);
            }
            AppMethodBeat.o(10154);
            return 0;
        } else if (i == 1) {
            if (this.vKF != null) {
                f = e.a.a.b.b.a.f(1, this.vKF) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.o(10154);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vKF == null) {
                bVar = new b("Not all required fields were included: Mac");
                AppMethodBeat.o(10154);
                throw bVar;
            }
            AppMethodBeat.o(10154);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            in inVar = (in) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    inVar.vKF = aVar3.BTU.readString();
                    AppMethodBeat.o(10154);
                    return 0;
                default:
                    AppMethodBeat.o(10154);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10154);
            return -1;
        }
    }
}
