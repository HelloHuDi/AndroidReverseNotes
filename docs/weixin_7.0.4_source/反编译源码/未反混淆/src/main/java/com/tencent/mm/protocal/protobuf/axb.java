package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class axb extends a {
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOD;
    public String vOz;
    public int wBk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(70482);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOz != null) {
                aVar.e(1, this.vOz);
            }
            if (this.vOA != null) {
                aVar.e(2, this.vOA);
            }
            if (this.vOB != null) {
                aVar.e(3, this.vOB);
            }
            if (this.vOC != null) {
                aVar.e(4, this.vOC);
            }
            if (this.vOD != null) {
                aVar.e(5, this.vOD);
            }
            aVar.iz(6, this.wBk);
            AppMethodBeat.o(70482);
            return 0;
        } else if (i == 1) {
            if (this.vOz != null) {
                f = e.a.a.b.b.a.f(1, this.vOz) + 0;
            } else {
                f = 0;
            }
            if (this.vOA != null) {
                f += e.a.a.b.b.a.f(2, this.vOA);
            }
            if (this.vOB != null) {
                f += e.a.a.b.b.a.f(3, this.vOB);
            }
            if (this.vOC != null) {
                f += e.a.a.b.b.a.f(4, this.vOC);
            }
            if (this.vOD != null) {
                f += e.a.a.b.b.a.f(5, this.vOD);
            }
            int bs = f + e.a.a.b.b.a.bs(6, this.wBk);
            AppMethodBeat.o(70482);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(70482);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axb axb = (axb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axb.vOz = aVar3.BTU.readString();
                    AppMethodBeat.o(70482);
                    return 0;
                case 2:
                    axb.vOA = aVar3.BTU.readString();
                    AppMethodBeat.o(70482);
                    return 0;
                case 3:
                    axb.vOB = aVar3.BTU.readString();
                    AppMethodBeat.o(70482);
                    return 0;
                case 4:
                    axb.vOC = aVar3.BTU.readString();
                    AppMethodBeat.o(70482);
                    return 0;
                case 5:
                    axb.vOD = aVar3.BTU.readString();
                    AppMethodBeat.o(70482);
                    return 0;
                case 6:
                    axb.wBk = aVar3.BTU.vd();
                    AppMethodBeat.o(70482);
                    return 0;
                default:
                    AppMethodBeat.o(70482);
                    return -1;
            }
        } else {
            AppMethodBeat.o(70482);
            return -1;
        }
    }
}
