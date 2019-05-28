package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class kf extends a {
    public String kfT;
    public String vNc;
    public int ver;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11702);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNc != null) {
                aVar.e(1, this.vNc);
            }
            if (this.kfT != null) {
                aVar.e(2, this.kfT);
            }
            aVar.iz(3, this.ver);
            AppMethodBeat.o(11702);
            return 0;
        } else if (i == 1) {
            if (this.vNc != null) {
                f = e.a.a.b.b.a.f(1, this.vNc) + 0;
            } else {
                f = 0;
            }
            if (this.kfT != null) {
                f += e.a.a.b.b.a.f(2, this.kfT);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.ver);
            AppMethodBeat.o(11702);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11702);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kf kfVar = (kf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kfVar.vNc = aVar3.BTU.readString();
                    AppMethodBeat.o(11702);
                    return 0;
                case 2:
                    kfVar.kfT = aVar3.BTU.readString();
                    AppMethodBeat.o(11702);
                    return 0;
                case 3:
                    kfVar.ver = aVar3.BTU.vd();
                    AppMethodBeat.o(11702);
                    return 0;
                default:
                    AppMethodBeat.o(11702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11702);
            return -1;
        }
    }
}
