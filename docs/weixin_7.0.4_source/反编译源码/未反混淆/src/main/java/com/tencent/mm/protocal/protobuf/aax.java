package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aax extends a {
    public int vEp;
    public String vEv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51398);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vEp);
            if (this.vEv != null) {
                aVar.e(2, this.vEv);
            }
            AppMethodBeat.o(51398);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vEp) + 0;
            if (this.vEv != null) {
                bs += e.a.a.b.b.a.f(2, this.vEv);
            }
            AppMethodBeat.o(51398);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51398);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aax aax = (aax) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aax.vEp = aVar3.BTU.vd();
                    AppMethodBeat.o(51398);
                    return 0;
                case 2:
                    aax.vEv = aVar3.BTU.readString();
                    AppMethodBeat.o(51398);
                    return 0;
                default:
                    AppMethodBeat.o(51398);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51398);
            return -1;
        }
    }
}
