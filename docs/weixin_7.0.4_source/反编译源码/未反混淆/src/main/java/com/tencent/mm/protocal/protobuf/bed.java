package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bed extends a {
    public String jBB;
    public String jCH;
    public int luF;
    public String vLe;
    public String wHM;
    public String wbw;
    public int weB;
    public int wyY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73744);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.luF);
            if (this.jCH != null) {
                aVar.e(2, this.jCH);
            }
            if (this.vLe != null) {
                aVar.e(3, this.vLe);
            }
            if (this.wbw != null) {
                aVar.e(4, this.wbw);
            }
            if (this.jBB != null) {
                aVar.e(5, this.jBB);
            }
            aVar.iz(6, this.wyY);
            aVar.iz(7, this.weB);
            if (this.wHM != null) {
                aVar.e(8, this.wHM);
            }
            AppMethodBeat.o(73744);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.luF) + 0;
            if (this.jCH != null) {
                bs += e.a.a.b.b.a.f(2, this.jCH);
            }
            if (this.vLe != null) {
                bs += e.a.a.b.b.a.f(3, this.vLe);
            }
            if (this.wbw != null) {
                bs += e.a.a.b.b.a.f(4, this.wbw);
            }
            if (this.jBB != null) {
                bs += e.a.a.b.b.a.f(5, this.jBB);
            }
            bs = (bs + e.a.a.b.b.a.bs(6, this.wyY)) + e.a.a.b.b.a.bs(7, this.weB);
            if (this.wHM != null) {
                bs += e.a.a.b.b.a.f(8, this.wHM);
            }
            AppMethodBeat.o(73744);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73744);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bed bed = (bed) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bed.luF = aVar3.BTU.vd();
                    AppMethodBeat.o(73744);
                    return 0;
                case 2:
                    bed.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(73744);
                    return 0;
                case 3:
                    bed.vLe = aVar3.BTU.readString();
                    AppMethodBeat.o(73744);
                    return 0;
                case 4:
                    bed.wbw = aVar3.BTU.readString();
                    AppMethodBeat.o(73744);
                    return 0;
                case 5:
                    bed.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(73744);
                    return 0;
                case 6:
                    bed.wyY = aVar3.BTU.vd();
                    AppMethodBeat.o(73744);
                    return 0;
                case 7:
                    bed.weB = aVar3.BTU.vd();
                    AppMethodBeat.o(73744);
                    return 0;
                case 8:
                    bed.wHM = aVar3.BTU.readString();
                    AppMethodBeat.o(73744);
                    return 0;
                default:
                    AppMethodBeat.o(73744);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73744);
            return -1;
        }
    }
}
