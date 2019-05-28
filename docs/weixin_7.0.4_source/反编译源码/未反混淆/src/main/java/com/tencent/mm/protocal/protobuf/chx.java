package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class chx extends a {
    public String cHr;
    public long xha;
    public long xhj;
    public long xhk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55712);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cHr != null) {
                aVar.e(1, this.cHr);
            }
            aVar.ai(2, this.xhj);
            aVar.ai(3, this.xhk);
            aVar.ai(4, this.xha);
            AppMethodBeat.o(55712);
            return 0;
        } else if (i == 1) {
            if (this.cHr != null) {
                f = e.a.a.b.b.a.f(1, this.cHr) + 0;
            } else {
                f = 0;
            }
            int o = ((f + e.a.a.b.b.a.o(2, this.xhj)) + e.a.a.b.b.a.o(3, this.xhk)) + e.a.a.b.b.a.o(4, this.xha);
            AppMethodBeat.o(55712);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55712);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chx chx = (chx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chx.cHr = aVar3.BTU.readString();
                    AppMethodBeat.o(55712);
                    return 0;
                case 2:
                    chx.xhj = aVar3.BTU.ve();
                    AppMethodBeat.o(55712);
                    return 0;
                case 3:
                    chx.xhk = aVar3.BTU.ve();
                    AppMethodBeat.o(55712);
                    return 0;
                case 4:
                    chx.xha = aVar3.BTU.ve();
                    AppMethodBeat.o(55712);
                    return 0;
                default:
                    AppMethodBeat.o(55712);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55712);
            return -1;
        }
    }
}
