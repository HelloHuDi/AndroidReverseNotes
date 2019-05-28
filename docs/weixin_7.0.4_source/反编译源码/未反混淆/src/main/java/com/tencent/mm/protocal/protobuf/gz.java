package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class gz extends a {
    public String nuL;
    public String pbn;
    public String pbo;
    public String tuk;
    public String vJB;
    public String vJC;
    public String vJD;
    public String vJE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56708);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJB != null) {
                aVar.e(1, this.vJB);
            }
            if (this.tuk != null) {
                aVar.e(2, this.tuk);
            }
            if (this.pbn != null) {
                aVar.e(3, this.pbn);
            }
            if (this.pbo != null) {
                aVar.e(4, this.pbo);
            }
            if (this.nuL != null) {
                aVar.e(5, this.nuL);
            }
            if (this.vJC != null) {
                aVar.e(6, this.vJC);
            }
            if (this.vJD != null) {
                aVar.e(7, this.vJD);
            }
            if (this.vJE != null) {
                aVar.e(8, this.vJE);
            }
            AppMethodBeat.o(56708);
            return 0;
        } else if (i == 1) {
            if (this.vJB != null) {
                f = e.a.a.b.b.a.f(1, this.vJB) + 0;
            } else {
                f = 0;
            }
            if (this.tuk != null) {
                f += e.a.a.b.b.a.f(2, this.tuk);
            }
            if (this.pbn != null) {
                f += e.a.a.b.b.a.f(3, this.pbn);
            }
            if (this.pbo != null) {
                f += e.a.a.b.b.a.f(4, this.pbo);
            }
            if (this.nuL != null) {
                f += e.a.a.b.b.a.f(5, this.nuL);
            }
            if (this.vJC != null) {
                f += e.a.a.b.b.a.f(6, this.vJC);
            }
            if (this.vJD != null) {
                f += e.a.a.b.b.a.f(7, this.vJD);
            }
            if (this.vJE != null) {
                f += e.a.a.b.b.a.f(8, this.vJE);
            }
            AppMethodBeat.o(56708);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56708);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gz gzVar = (gz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gzVar.vJB = aVar3.BTU.readString();
                    AppMethodBeat.o(56708);
                    return 0;
                case 2:
                    gzVar.tuk = aVar3.BTU.readString();
                    AppMethodBeat.o(56708);
                    return 0;
                case 3:
                    gzVar.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(56708);
                    return 0;
                case 4:
                    gzVar.pbo = aVar3.BTU.readString();
                    AppMethodBeat.o(56708);
                    return 0;
                case 5:
                    gzVar.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(56708);
                    return 0;
                case 6:
                    gzVar.vJC = aVar3.BTU.readString();
                    AppMethodBeat.o(56708);
                    return 0;
                case 7:
                    gzVar.vJD = aVar3.BTU.readString();
                    AppMethodBeat.o(56708);
                    return 0;
                case 8:
                    gzVar.vJE = aVar3.BTU.readString();
                    AppMethodBeat.o(56708);
                    return 0;
                default:
                    AppMethodBeat.o(56708);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56708);
            return -1;
        }
    }
}
