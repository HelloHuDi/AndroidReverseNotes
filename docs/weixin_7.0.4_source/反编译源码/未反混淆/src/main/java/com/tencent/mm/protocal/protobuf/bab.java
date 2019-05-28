package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bab extends a {
    public String cEh;
    public String nZb;
    public String nZc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48884);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cEh != null) {
                aVar.e(1, this.cEh);
            }
            if (this.nZb != null) {
                aVar.e(2, this.nZb);
            }
            if (this.nZc != null) {
                aVar.e(4, this.nZc);
            }
            AppMethodBeat.o(48884);
            return 0;
        } else if (i == 1) {
            if (this.cEh != null) {
                f = e.a.a.b.b.a.f(1, this.cEh) + 0;
            } else {
                f = 0;
            }
            if (this.nZb != null) {
                f += e.a.a.b.b.a.f(2, this.nZb);
            }
            if (this.nZc != null) {
                f += e.a.a.b.b.a.f(4, this.nZc);
            }
            AppMethodBeat.o(48884);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48884);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bab bab = (bab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bab.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(48884);
                    return 0;
                case 2:
                    bab.nZb = aVar3.BTU.readString();
                    AppMethodBeat.o(48884);
                    return 0;
                case 4:
                    bab.nZc = aVar3.BTU.readString();
                    AppMethodBeat.o(48884);
                    return 0;
                default:
                    AppMethodBeat.o(48884);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48884);
            return -1;
        }
    }
}
