package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class na extends a {
    public String vJY;
    public String vRB;
    public int vRC;
    public String vRD;
    public String vRE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2537);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vRB != null) {
                aVar.e(1, this.vRB);
            }
            aVar.iz(2, this.vRC);
            if (this.vRD != null) {
                aVar.e(3, this.vRD);
            }
            if (this.vJY != null) {
                aVar.e(4, this.vJY);
            }
            if (this.vRE != null) {
                aVar.e(5, this.vRE);
            }
            AppMethodBeat.o(2537);
            return 0;
        } else if (i == 1) {
            if (this.vRB != null) {
                f = e.a.a.b.b.a.f(1, this.vRB) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vRC);
            if (this.vRD != null) {
                f += e.a.a.b.b.a.f(3, this.vRD);
            }
            if (this.vJY != null) {
                f += e.a.a.b.b.a.f(4, this.vJY);
            }
            if (this.vRE != null) {
                f += e.a.a.b.b.a.f(5, this.vRE);
            }
            AppMethodBeat.o(2537);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(2537);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            na naVar = (na) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    naVar.vRB = aVar3.BTU.readString();
                    AppMethodBeat.o(2537);
                    return 0;
                case 2:
                    naVar.vRC = aVar3.BTU.vd();
                    AppMethodBeat.o(2537);
                    return 0;
                case 3:
                    naVar.vRD = aVar3.BTU.readString();
                    AppMethodBeat.o(2537);
                    return 0;
                case 4:
                    naVar.vJY = aVar3.BTU.readString();
                    AppMethodBeat.o(2537);
                    return 0;
                case 5:
                    naVar.vRE = aVar3.BTU.readString();
                    AppMethodBeat.o(2537);
                    return 0;
                default:
                    AppMethodBeat.o(2537);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2537);
            return -1;
        }
    }
}
