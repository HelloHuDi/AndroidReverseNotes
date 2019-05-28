package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bvl extends a {
    public String cFl;
    public int wWA;
    public String wWz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80180);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWz != null) {
                aVar.e(1, this.wWz);
            }
            if (this.cFl != null) {
                aVar.e(2, this.cFl);
            }
            aVar.iz(3, this.wWA);
            AppMethodBeat.o(80180);
            return 0;
        } else if (i == 1) {
            if (this.wWz != null) {
                f = e.a.a.b.b.a.f(1, this.wWz) + 0;
            } else {
                f = 0;
            }
            if (this.cFl != null) {
                f += e.a.a.b.b.a.f(2, this.cFl);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.wWA);
            AppMethodBeat.o(80180);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80180);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvl bvl = (bvl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bvl.wWz = aVar3.BTU.readString();
                    AppMethodBeat.o(80180);
                    return 0;
                case 2:
                    bvl.cFl = aVar3.BTU.readString();
                    AppMethodBeat.o(80180);
                    return 0;
                case 3:
                    bvl.wWA = aVar3.BTU.vd();
                    AppMethodBeat.o(80180);
                    return 0;
                default:
                    AppMethodBeat.o(80180);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80180);
            return -1;
        }
    }
}
