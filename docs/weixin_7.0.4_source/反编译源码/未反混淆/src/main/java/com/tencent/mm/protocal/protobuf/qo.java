package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class qo extends a {
    public String vXB;
    public String vXC;
    public String vXD;
    public int vXE;
    public int vXF;
    public String vXG;
    public int vXH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51377);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vXB != null) {
                aVar.e(1, this.vXB);
            }
            if (this.vXC != null) {
                aVar.e(2, this.vXC);
            }
            if (this.vXD != null) {
                aVar.e(3, this.vXD);
            }
            aVar.iz(4, this.vXE);
            aVar.iz(5, this.vXF);
            if (this.vXG != null) {
                aVar.e(6, this.vXG);
            }
            aVar.iz(7, this.vXH);
            AppMethodBeat.o(51377);
            return 0;
        } else if (i == 1) {
            if (this.vXB != null) {
                f = e.a.a.b.b.a.f(1, this.vXB) + 0;
            } else {
                f = 0;
            }
            if (this.vXC != null) {
                f += e.a.a.b.b.a.f(2, this.vXC);
            }
            if (this.vXD != null) {
                f += e.a.a.b.b.a.f(3, this.vXD);
            }
            f = (f + e.a.a.b.b.a.bs(4, this.vXE)) + e.a.a.b.b.a.bs(5, this.vXF);
            if (this.vXG != null) {
                f += e.a.a.b.b.a.f(6, this.vXG);
            }
            int bs = f + e.a.a.b.b.a.bs(7, this.vXH);
            AppMethodBeat.o(51377);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51377);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            qo qoVar = (qo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qoVar.vXB = aVar3.BTU.readString();
                    AppMethodBeat.o(51377);
                    return 0;
                case 2:
                    qoVar.vXC = aVar3.BTU.readString();
                    AppMethodBeat.o(51377);
                    return 0;
                case 3:
                    qoVar.vXD = aVar3.BTU.readString();
                    AppMethodBeat.o(51377);
                    return 0;
                case 4:
                    qoVar.vXE = aVar3.BTU.vd();
                    AppMethodBeat.o(51377);
                    return 0;
                case 5:
                    qoVar.vXF = aVar3.BTU.vd();
                    AppMethodBeat.o(51377);
                    return 0;
                case 6:
                    qoVar.vXG = aVar3.BTU.readString();
                    AppMethodBeat.o(51377);
                    return 0;
                case 7:
                    qoVar.vXH = aVar3.BTU.vd();
                    AppMethodBeat.o(51377);
                    return 0;
                default:
                    AppMethodBeat.o(51377);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51377);
            return -1;
        }
    }
}
