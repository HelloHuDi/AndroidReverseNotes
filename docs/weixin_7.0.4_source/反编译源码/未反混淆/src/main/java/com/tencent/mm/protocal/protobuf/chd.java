package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class chd extends a {
    public String kbV;
    public String vGE;
    public int weight;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11819);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGE != null) {
                aVar.e(1, this.vGE);
            }
            if (this.kbV != null) {
                aVar.e(2, this.kbV);
            }
            aVar.iz(3, this.weight);
            AppMethodBeat.o(11819);
            return 0;
        } else if (i == 1) {
            if (this.vGE != null) {
                f = e.a.a.b.b.a.f(1, this.vGE) + 0;
            } else {
                f = 0;
            }
            if (this.kbV != null) {
                f += e.a.a.b.b.a.f(2, this.kbV);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.weight);
            AppMethodBeat.o(11819);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11819);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chd chd = (chd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chd.vGE = aVar3.BTU.readString();
                    AppMethodBeat.o(11819);
                    return 0;
                case 2:
                    chd.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(11819);
                    return 0;
                case 3:
                    chd.weight = aVar3.BTU.vd();
                    AppMethodBeat.o(11819);
                    return 0;
                default:
                    AppMethodBeat.o(11819);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11819);
            return -1;
        }
    }
}
