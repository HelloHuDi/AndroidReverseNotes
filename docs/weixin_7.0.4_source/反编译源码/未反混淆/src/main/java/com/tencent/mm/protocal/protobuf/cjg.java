package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cjg extends a {
    public String kbV;
    public String nuL;
    public String pbn;
    public String pbo;
    public String vJC;
    public String vJD;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48977);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pbn != null) {
                aVar.e(1, this.pbn);
            }
            if (this.kbV != null) {
                aVar.e(2, this.kbV);
            }
            if (this.nuL != null) {
                aVar.e(3, this.nuL);
            }
            if (this.pbo != null) {
                aVar.e(4, this.pbo);
            }
            if (this.vJC != null) {
                aVar.e(5, this.vJC);
            }
            if (this.vJD != null) {
                aVar.e(6, this.vJD);
            }
            AppMethodBeat.o(48977);
            return 0;
        } else if (i == 1) {
            if (this.pbn != null) {
                f = e.a.a.b.b.a.f(1, this.pbn) + 0;
            } else {
                f = 0;
            }
            if (this.kbV != null) {
                f += e.a.a.b.b.a.f(2, this.kbV);
            }
            if (this.nuL != null) {
                f += e.a.a.b.b.a.f(3, this.nuL);
            }
            if (this.pbo != null) {
                f += e.a.a.b.b.a.f(4, this.pbo);
            }
            if (this.vJC != null) {
                f += e.a.a.b.b.a.f(5, this.vJC);
            }
            if (this.vJD != null) {
                f += e.a.a.b.b.a.f(6, this.vJD);
            }
            AppMethodBeat.o(48977);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48977);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cjg cjg = (cjg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjg.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48977);
                    return 0;
                case 2:
                    cjg.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(48977);
                    return 0;
                case 3:
                    cjg.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(48977);
                    return 0;
                case 4:
                    cjg.pbo = aVar3.BTU.readString();
                    AppMethodBeat.o(48977);
                    return 0;
                case 5:
                    cjg.vJC = aVar3.BTU.readString();
                    AppMethodBeat.o(48977);
                    return 0;
                case 6:
                    cjg.vJD = aVar3.BTU.readString();
                    AppMethodBeat.o(48977);
                    return 0;
                default:
                    AppMethodBeat.o(48977);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48977);
            return -1;
        }
    }
}
