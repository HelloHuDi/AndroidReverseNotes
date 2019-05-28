package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bcd extends a {
    public int jCt;
    public String ncF;
    public String pXM;
    public String wGI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51432);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ncF != null) {
                aVar.e(1, this.ncF);
            }
            if (this.wGI != null) {
                aVar.e(2, this.wGI);
            }
            if (this.pXM != null) {
                aVar.e(3, this.pXM);
            }
            aVar.iz(4, this.jCt);
            AppMethodBeat.o(51432);
            return 0;
        } else if (i == 1) {
            if (this.ncF != null) {
                f = e.a.a.b.b.a.f(1, this.ncF) + 0;
            } else {
                f = 0;
            }
            if (this.wGI != null) {
                f += e.a.a.b.b.a.f(2, this.wGI);
            }
            if (this.pXM != null) {
                f += e.a.a.b.b.a.f(3, this.pXM);
            }
            int bs = f + e.a.a.b.b.a.bs(4, this.jCt);
            AppMethodBeat.o(51432);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51432);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcd bcd = (bcd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcd.ncF = aVar3.BTU.readString();
                    AppMethodBeat.o(51432);
                    return 0;
                case 2:
                    bcd.wGI = aVar3.BTU.readString();
                    AppMethodBeat.o(51432);
                    return 0;
                case 3:
                    bcd.pXM = aVar3.BTU.readString();
                    AppMethodBeat.o(51432);
                    return 0;
                case 4:
                    bcd.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(51432);
                    return 0;
                default:
                    AppMethodBeat.o(51432);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51432);
            return -1;
        }
    }
}
