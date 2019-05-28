package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class tw extends a {
    public String cuF;
    public String cuG;
    public int version;
    public int wbk;
    public int wbl;
    public String wbm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28365);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.version);
            aVar.iz(2, this.wbk);
            aVar.iz(3, this.wbl);
            if (this.cuG != null) {
                aVar.e(4, this.cuG);
            }
            if (this.wbm != null) {
                aVar.e(5, this.wbm);
            }
            if (this.cuF != null) {
                aVar.e(6, this.cuF);
            }
            AppMethodBeat.o(28365);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.version) + 0) + e.a.a.b.b.a.bs(2, this.wbk)) + e.a.a.b.b.a.bs(3, this.wbl);
            if (this.cuG != null) {
                bs += e.a.a.b.b.a.f(4, this.cuG);
            }
            if (this.wbm != null) {
                bs += e.a.a.b.b.a.f(5, this.wbm);
            }
            if (this.cuF != null) {
                bs += e.a.a.b.b.a.f(6, this.cuF);
            }
            AppMethodBeat.o(28365);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28365);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tw twVar = (tw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    twVar.version = aVar3.BTU.vd();
                    AppMethodBeat.o(28365);
                    return 0;
                case 2:
                    twVar.wbk = aVar3.BTU.vd();
                    AppMethodBeat.o(28365);
                    return 0;
                case 3:
                    twVar.wbl = aVar3.BTU.vd();
                    AppMethodBeat.o(28365);
                    return 0;
                case 4:
                    twVar.cuG = aVar3.BTU.readString();
                    AppMethodBeat.o(28365);
                    return 0;
                case 5:
                    twVar.wbm = aVar3.BTU.readString();
                    AppMethodBeat.o(28365);
                    return 0;
                case 6:
                    twVar.cuF = aVar3.BTU.readString();
                    AppMethodBeat.o(28365);
                    return 0;
                default:
                    AppMethodBeat.o(28365);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28365);
            return -1;
        }
    }
}
