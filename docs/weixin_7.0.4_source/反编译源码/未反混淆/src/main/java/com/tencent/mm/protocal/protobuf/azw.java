package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class azw extends a {
    public int Scene;
    public String vOy;
    public long wDE;
    public long wDF;
    public int wDG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124324);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Scene);
            if (this.vOy != null) {
                aVar.e(2, this.vOy);
            }
            aVar.ai(3, this.wDF);
            aVar.ai(4, this.wDE);
            aVar.iz(5, this.wDG);
            AppMethodBeat.o(124324);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Scene) + 0;
            if (this.vOy != null) {
                bs += e.a.a.b.b.a.f(2, this.vOy);
            }
            bs = ((bs + e.a.a.b.b.a.o(3, this.wDF)) + e.a.a.b.b.a.o(4, this.wDE)) + e.a.a.b.b.a.bs(5, this.wDG);
            AppMethodBeat.o(124324);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124324);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azw azw = (azw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azw.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124324);
                    return 0;
                case 2:
                    azw.vOy = aVar3.BTU.readString();
                    AppMethodBeat.o(124324);
                    return 0;
                case 3:
                    azw.wDF = aVar3.BTU.ve();
                    AppMethodBeat.o(124324);
                    return 0;
                case 4:
                    azw.wDE = aVar3.BTU.ve();
                    AppMethodBeat.o(124324);
                    return 0;
                case 5:
                    azw.wDG = aVar3.BTU.vd();
                    AppMethodBeat.o(124324);
                    return 0;
                default:
                    AppMethodBeat.o(124324);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124324);
            return -1;
        }
    }
}
