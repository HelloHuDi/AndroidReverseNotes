package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class blt extends a {
    public String wCK;
    public int wOO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28574);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wCK == null) {
                bVar = new b("Not all required fields were included: Ip");
                AppMethodBeat.o(28574);
                throw bVar;
            }
            if (this.wCK != null) {
                aVar.e(1, this.wCK);
            }
            aVar.iz(2, this.wOO);
            AppMethodBeat.o(28574);
            return 0;
        } else if (i == 1) {
            if (this.wCK != null) {
                f = e.a.a.b.b.a.f(1, this.wCK) + 0;
            } else {
                f = 0;
            }
            int bs = f + e.a.a.b.b.a.bs(2, this.wOO);
            AppMethodBeat.o(28574);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wCK == null) {
                bVar = new b("Not all required fields were included: Ip");
                AppMethodBeat.o(28574);
                throw bVar;
            }
            AppMethodBeat.o(28574);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blt blt = (blt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    blt.wCK = aVar3.BTU.readString();
                    AppMethodBeat.o(28574);
                    return 0;
                case 2:
                    blt.wOO = aVar3.BTU.vd();
                    AppMethodBeat.o(28574);
                    return 0;
                default:
                    AppMethodBeat.o(28574);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28574);
            return -1;
        }
    }
}
