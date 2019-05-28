package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class azv extends a {
    public int jCt;
    public int scene;
    public String vOy;
    public String vQg;
    public long wDD;
    public long wDE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124323);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.scene);
            if (this.vOy != null) {
                aVar.e(2, this.vOy);
            }
            aVar.ai(3, this.wDD);
            aVar.ai(4, this.wDE);
            if (this.vQg != null) {
                aVar.e(5, this.vQg);
            }
            aVar.iz(6, this.jCt);
            AppMethodBeat.o(124323);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.scene) + 0;
            if (this.vOy != null) {
                bs += e.a.a.b.b.a.f(2, this.vOy);
            }
            bs = (bs + e.a.a.b.b.a.o(3, this.wDD)) + e.a.a.b.b.a.o(4, this.wDE);
            if (this.vQg != null) {
                bs += e.a.a.b.b.a.f(5, this.vQg);
            }
            bs += e.a.a.b.b.a.bs(6, this.jCt);
            AppMethodBeat.o(124323);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124323);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azv azv = (azv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azv.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124323);
                    return 0;
                case 2:
                    azv.vOy = aVar3.BTU.readString();
                    AppMethodBeat.o(124323);
                    return 0;
                case 3:
                    azv.wDD = aVar3.BTU.ve();
                    AppMethodBeat.o(124323);
                    return 0;
                case 4:
                    azv.wDE = aVar3.BTU.ve();
                    AppMethodBeat.o(124323);
                    return 0;
                case 5:
                    azv.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(124323);
                    return 0;
                case 6:
                    azv.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(124323);
                    return 0;
                default:
                    AppMethodBeat.o(124323);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124323);
            return -1;
        }
    }
}
