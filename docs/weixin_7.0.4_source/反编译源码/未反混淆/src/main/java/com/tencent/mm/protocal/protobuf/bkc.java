package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bkc extends a {
    public String pbn;
    public String wNi;
    public String wNj;
    public String wNk;
    public String wNl;
    public boolean wNm;
    public String wNn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48921);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wNi != null) {
                aVar.e(1, this.wNi);
            }
            if (this.wNj != null) {
                aVar.e(2, this.wNj);
            }
            if (this.pbn != null) {
                aVar.e(3, this.pbn);
            }
            if (this.wNk != null) {
                aVar.e(4, this.wNk);
            }
            if (this.wNl != null) {
                aVar.e(5, this.wNl);
            }
            aVar.aO(6, this.wNm);
            if (this.wNn != null) {
                aVar.e(7, this.wNn);
            }
            AppMethodBeat.o(48921);
            return 0;
        } else if (i == 1) {
            if (this.wNi != null) {
                f = e.a.a.b.b.a.f(1, this.wNi) + 0;
            } else {
                f = 0;
            }
            if (this.wNj != null) {
                f += e.a.a.b.b.a.f(2, this.wNj);
            }
            if (this.pbn != null) {
                f += e.a.a.b.b.a.f(3, this.pbn);
            }
            if (this.wNk != null) {
                f += e.a.a.b.b.a.f(4, this.wNk);
            }
            if (this.wNl != null) {
                f += e.a.a.b.b.a.f(5, this.wNl);
            }
            f += e.a.a.b.b.a.fv(6) + 1;
            if (this.wNn != null) {
                f += e.a.a.b.b.a.f(7, this.wNn);
            }
            AppMethodBeat.o(48921);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48921);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkc bkc = (bkc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkc.wNi = aVar3.BTU.readString();
                    AppMethodBeat.o(48921);
                    return 0;
                case 2:
                    bkc.wNj = aVar3.BTU.readString();
                    AppMethodBeat.o(48921);
                    return 0;
                case 3:
                    bkc.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48921);
                    return 0;
                case 4:
                    bkc.wNk = aVar3.BTU.readString();
                    AppMethodBeat.o(48921);
                    return 0;
                case 5:
                    bkc.wNl = aVar3.BTU.readString();
                    AppMethodBeat.o(48921);
                    return 0;
                case 6:
                    bkc.wNm = aVar3.BTU.ehX();
                    AppMethodBeat.o(48921);
                    return 0;
                case 7:
                    bkc.wNn = aVar3.BTU.readString();
                    AppMethodBeat.o(48921);
                    return 0;
                default:
                    AppMethodBeat.o(48921);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48921);
            return -1;
        }
    }
}
