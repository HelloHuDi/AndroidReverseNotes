package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bdx extends a {
    public int nao;
    public String ndF;
    public String ndG;
    public int ptD;
    public long ptF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60052);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ndG != null) {
                aVar.e(1, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(2, this.ndF);
            }
            aVar.iz(3, this.ptD);
            aVar.iz(4, this.nao);
            aVar.ai(5, this.ptF);
            AppMethodBeat.o(60052);
            return 0;
        } else if (i == 1) {
            if (this.ndG != null) {
                f = e.a.a.b.b.a.f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.ndF != null) {
                f += e.a.a.b.b.a.f(2, this.ndF);
            }
            int bs = ((f + e.a.a.b.b.a.bs(3, this.ptD)) + e.a.a.b.b.a.bs(4, this.nao)) + e.a.a.b.b.a.o(5, this.ptF);
            AppMethodBeat.o(60052);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60052);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdx bdx = (bdx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdx.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(60052);
                    return 0;
                case 2:
                    bdx.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(60052);
                    return 0;
                case 3:
                    bdx.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(60052);
                    return 0;
                case 4:
                    bdx.nao = aVar3.BTU.vd();
                    AppMethodBeat.o(60052);
                    return 0;
                case 5:
                    bdx.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(60052);
                    return 0;
                default:
                    AppMethodBeat.o(60052);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60052);
            return -1;
        }
    }
}
