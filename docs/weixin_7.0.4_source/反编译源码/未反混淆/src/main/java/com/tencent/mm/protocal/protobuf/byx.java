package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class byx extends a {
    public String cMC;
    public String cMD;
    public String kbU;
    public String vBu;
    public String vBv;
    public int vBw;
    public String vGv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89140);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cMC != null) {
                aVar.e(1, this.cMC);
            }
            if (this.kbU != null) {
                aVar.e(2, this.kbU);
            }
            if (this.cMD != null) {
                aVar.e(3, this.cMD);
            }
            if (this.vBu != null) {
                aVar.e(4, this.vBu);
            }
            if (this.vBv != null) {
                aVar.e(5, this.vBv);
            }
            aVar.iz(6, this.vBw);
            if (this.vGv != null) {
                aVar.e(7, this.vGv);
            }
            AppMethodBeat.o(89140);
            return 0;
        } else if (i == 1) {
            if (this.cMC != null) {
                f = e.a.a.b.b.a.f(1, this.cMC) + 0;
            } else {
                f = 0;
            }
            if (this.kbU != null) {
                f += e.a.a.b.b.a.f(2, this.kbU);
            }
            if (this.cMD != null) {
                f += e.a.a.b.b.a.f(3, this.cMD);
            }
            if (this.vBu != null) {
                f += e.a.a.b.b.a.f(4, this.vBu);
            }
            if (this.vBv != null) {
                f += e.a.a.b.b.a.f(5, this.vBv);
            }
            f += e.a.a.b.b.a.bs(6, this.vBw);
            if (this.vGv != null) {
                f += e.a.a.b.b.a.f(7, this.vGv);
            }
            AppMethodBeat.o(89140);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89140);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byx byx = (byx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byx.cMC = aVar3.BTU.readString();
                    AppMethodBeat.o(89140);
                    return 0;
                case 2:
                    byx.kbU = aVar3.BTU.readString();
                    AppMethodBeat.o(89140);
                    return 0;
                case 3:
                    byx.cMD = aVar3.BTU.readString();
                    AppMethodBeat.o(89140);
                    return 0;
                case 4:
                    byx.vBu = aVar3.BTU.readString();
                    AppMethodBeat.o(89140);
                    return 0;
                case 5:
                    byx.vBv = aVar3.BTU.readString();
                    AppMethodBeat.o(89140);
                    return 0;
                case 6:
                    byx.vBw = aVar3.BTU.vd();
                    AppMethodBeat.o(89140);
                    return 0;
                case 7:
                    byx.vGv = aVar3.BTU.readString();
                    AppMethodBeat.o(89140);
                    return 0;
                default:
                    AppMethodBeat.o(89140);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89140);
            return -1;
        }
    }
}
