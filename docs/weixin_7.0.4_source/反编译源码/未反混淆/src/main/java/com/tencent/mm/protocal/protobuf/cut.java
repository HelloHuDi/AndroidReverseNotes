package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cut extends a {
    public int jBv;
    public int jCt;
    public String ndF;
    public int pcX;
    public String vEG;
    public int wFW;
    public int xqR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28761);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ndF != null) {
                aVar.e(1, this.ndF);
            }
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.jBv);
            aVar.iz(4, this.pcX);
            aVar.iz(5, this.wFW);
            if (this.vEG != null) {
                aVar.e(6, this.vEG);
            }
            aVar.iz(7, this.xqR);
            AppMethodBeat.o(28761);
            return 0;
        } else if (i == 1) {
            if (this.ndF != null) {
                f = e.a.a.b.b.a.f(1, this.ndF) + 0;
            } else {
                f = 0;
            }
            f = (((f + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.jBv)) + e.a.a.b.b.a.bs(4, this.pcX)) + e.a.a.b.b.a.bs(5, this.wFW);
            if (this.vEG != null) {
                f += e.a.a.b.b.a.f(6, this.vEG);
            }
            int bs = f + e.a.a.b.b.a.bs(7, this.xqR);
            AppMethodBeat.o(28761);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28761);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cut cut = (cut) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cut.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28761);
                    return 0;
                case 2:
                    cut.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28761);
                    return 0;
                case 3:
                    cut.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(28761);
                    return 0;
                case 4:
                    cut.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(28761);
                    return 0;
                case 5:
                    cut.wFW = aVar3.BTU.vd();
                    AppMethodBeat.o(28761);
                    return 0;
                case 6:
                    cut.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(28761);
                    return 0;
                case 7:
                    cut.xqR = aVar3.BTU.vd();
                    AppMethodBeat.o(28761);
                    return 0;
                default:
                    AppMethodBeat.o(28761);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28761);
            return -1;
        }
    }
}
