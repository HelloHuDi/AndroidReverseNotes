package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bbs extends a {
    public String jBB;
    public int pXD;
    public String vEf;
    public int wGd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5597);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEf != null) {
                aVar.e(1, this.vEf);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            aVar.iz(3, this.wGd);
            aVar.iz(4, this.pXD);
            AppMethodBeat.o(5597);
            return 0;
        } else if (i == 1) {
            if (this.vEf != null) {
                f = e.a.a.b.b.a.f(1, this.vEf) + 0;
            } else {
                f = 0;
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(2, this.jBB);
            }
            int bs = (f + e.a.a.b.b.a.bs(3, this.wGd)) + e.a.a.b.b.a.bs(4, this.pXD);
            AppMethodBeat.o(5597);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5597);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbs bbs = (bbs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbs.vEf = aVar3.BTU.readString();
                    AppMethodBeat.o(5597);
                    return 0;
                case 2:
                    bbs.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(5597);
                    return 0;
                case 3:
                    bbs.wGd = aVar3.BTU.vd();
                    AppMethodBeat.o(5597);
                    return 0;
                case 4:
                    bbs.pXD = aVar3.BTU.vd();
                    AppMethodBeat.o(5597);
                    return 0;
                default:
                    AppMethodBeat.o(5597);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5597);
            return -1;
        }
    }
}
