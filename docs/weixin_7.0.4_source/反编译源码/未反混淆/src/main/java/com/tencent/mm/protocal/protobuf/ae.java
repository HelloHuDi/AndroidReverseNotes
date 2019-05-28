package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ae extends a {
    public String vBj;
    public int vBk;
    public int vBl;
    public int vBm;
    public int vBn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72837);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vBj != null) {
                aVar.e(1, this.vBj);
            }
            aVar.iz(2, this.vBk);
            aVar.iz(3, this.vBl);
            aVar.iz(4, this.vBm);
            aVar.iz(5, this.vBn);
            AppMethodBeat.o(72837);
            return 0;
        } else if (i == 1) {
            if (this.vBj != null) {
                f = e.a.a.b.b.a.f(1, this.vBj) + 0;
            } else {
                f = 0;
            }
            int bs = (((f + e.a.a.b.b.a.bs(2, this.vBk)) + e.a.a.b.b.a.bs(3, this.vBl)) + e.a.a.b.b.a.bs(4, this.vBm)) + e.a.a.b.b.a.bs(5, this.vBn);
            AppMethodBeat.o(72837);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72837);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ae aeVar = (ae) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aeVar.vBj = aVar3.BTU.readString();
                    AppMethodBeat.o(72837);
                    return 0;
                case 2:
                    aeVar.vBk = aVar3.BTU.vd();
                    AppMethodBeat.o(72837);
                    return 0;
                case 3:
                    aeVar.vBl = aVar3.BTU.vd();
                    AppMethodBeat.o(72837);
                    return 0;
                case 4:
                    aeVar.vBm = aVar3.BTU.vd();
                    AppMethodBeat.o(72837);
                    return 0;
                case 5:
                    aeVar.vBn = aVar3.BTU.vd();
                    AppMethodBeat.o(72837);
                    return 0;
                default:
                    AppMethodBeat.o(72837);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72837);
            return -1;
        }
    }
}
