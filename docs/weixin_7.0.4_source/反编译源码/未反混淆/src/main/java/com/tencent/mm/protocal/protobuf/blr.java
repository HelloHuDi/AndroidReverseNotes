package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class blr extends a {
    public String cEh;
    public String url;
    public String wOM;
    public int wON;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(852);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cEh != null) {
                aVar.e(1, this.cEh);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.wOM != null) {
                aVar.e(3, this.wOM);
            }
            aVar.iz(4, this.wON);
            AppMethodBeat.o(852);
            return 0;
        } else if (i == 1) {
            if (this.cEh != null) {
                f = e.a.a.b.b.a.f(1, this.cEh) + 0;
            } else {
                f = 0;
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.wOM != null) {
                f += e.a.a.b.b.a.f(3, this.wOM);
            }
            int bs = f + e.a.a.b.b.a.bs(4, this.wON);
            AppMethodBeat.o(852);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(852);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blr blr = (blr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    blr.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(852);
                    return 0;
                case 2:
                    blr.url = aVar3.BTU.readString();
                    AppMethodBeat.o(852);
                    return 0;
                case 3:
                    blr.wOM = aVar3.BTU.readString();
                    AppMethodBeat.o(852);
                    return 0;
                case 4:
                    blr.wON = aVar3.BTU.vd();
                    AppMethodBeat.o(852);
                    return 0;
                default:
                    AppMethodBeat.o(852);
                    return -1;
            }
        } else {
            AppMethodBeat.o(852);
            return -1;
        }
    }
}
