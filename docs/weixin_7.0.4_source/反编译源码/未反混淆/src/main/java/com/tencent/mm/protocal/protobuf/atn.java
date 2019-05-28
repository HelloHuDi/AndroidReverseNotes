package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class atn extends a {
    public String wxE;
    public String wxF;
    public int wxG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58908);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wxE != null) {
                aVar.e(1, this.wxE);
            }
            if (this.wxF != null) {
                aVar.e(2, this.wxF);
            }
            aVar.iz(3, this.wxG);
            AppMethodBeat.o(58908);
            return 0;
        } else if (i == 1) {
            if (this.wxE != null) {
                f = e.a.a.b.b.a.f(1, this.wxE) + 0;
            } else {
                f = 0;
            }
            if (this.wxF != null) {
                f += e.a.a.b.b.a.f(2, this.wxF);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.wxG);
            AppMethodBeat.o(58908);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58908);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atn atn = (atn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atn.wxE = aVar3.BTU.readString();
                    AppMethodBeat.o(58908);
                    return 0;
                case 2:
                    atn.wxF = aVar3.BTU.readString();
                    AppMethodBeat.o(58908);
                    return 0;
                case 3:
                    atn.wxG = aVar3.BTU.vd();
                    AppMethodBeat.o(58908);
                    return 0;
                default:
                    AppMethodBeat.o(58908);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58908);
            return -1;
        }
    }
}
