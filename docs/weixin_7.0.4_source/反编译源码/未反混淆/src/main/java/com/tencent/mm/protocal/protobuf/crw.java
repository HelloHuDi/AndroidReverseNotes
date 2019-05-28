package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class crw extends a {
    public String guW;
    public String xpw;
    public int xpx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28708);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xpw != null) {
                aVar.e(1, this.xpw);
            }
            if (this.guW != null) {
                aVar.e(2, this.guW);
            }
            aVar.iz(3, this.xpx);
            AppMethodBeat.o(28708);
            return 0;
        } else if (i == 1) {
            if (this.xpw != null) {
                f = e.a.a.b.b.a.f(1, this.xpw) + 0;
            } else {
                f = 0;
            }
            if (this.guW != null) {
                f += e.a.a.b.b.a.f(2, this.guW);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.xpx);
            AppMethodBeat.o(28708);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28708);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crw crw = (crw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crw.xpw = aVar3.BTU.readString();
                    AppMethodBeat.o(28708);
                    return 0;
                case 2:
                    crw.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(28708);
                    return 0;
                case 3:
                    crw.xpx = aVar3.BTU.vd();
                    AppMethodBeat.o(28708);
                    return 0;
                default:
                    AppMethodBeat.o(28708);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28708);
            return -1;
        }
    }
}
