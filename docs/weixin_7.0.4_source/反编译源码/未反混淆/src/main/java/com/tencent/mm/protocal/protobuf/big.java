package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class big extends a {
    public String csB;
    public String fBq;
    public String iAa;
    public String iAe;
    public String izZ;
    public int position;
    public String username;
    public int vFr;
    public int wLx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134434);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.izZ != null) {
                aVar.e(2, this.izZ);
            }
            if (this.fBq != null) {
                aVar.e(3, this.fBq);
            }
            if (this.iAa != null) {
                aVar.e(4, this.iAa);
            }
            if (this.csB != null) {
                aVar.e(5, this.csB);
            }
            if (this.iAe != null) {
                aVar.e(6, this.iAe);
            }
            aVar.iz(7, this.position);
            aVar.iz(8, this.wLx);
            aVar.iz(9, this.vFr);
            AppMethodBeat.o(134434);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.izZ != null) {
                f += e.a.a.b.b.a.f(2, this.izZ);
            }
            if (this.fBq != null) {
                f += e.a.a.b.b.a.f(3, this.fBq);
            }
            if (this.iAa != null) {
                f += e.a.a.b.b.a.f(4, this.iAa);
            }
            if (this.csB != null) {
                f += e.a.a.b.b.a.f(5, this.csB);
            }
            if (this.iAe != null) {
                f += e.a.a.b.b.a.f(6, this.iAe);
            }
            int bs = ((f + e.a.a.b.b.a.bs(7, this.position)) + e.a.a.b.b.a.bs(8, this.wLx)) + e.a.a.b.b.a.bs(9, this.vFr);
            AppMethodBeat.o(134434);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134434);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            big big = (big) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    big.username = aVar3.BTU.readString();
                    AppMethodBeat.o(134434);
                    return 0;
                case 2:
                    big.izZ = aVar3.BTU.readString();
                    AppMethodBeat.o(134434);
                    return 0;
                case 3:
                    big.fBq = aVar3.BTU.readString();
                    AppMethodBeat.o(134434);
                    return 0;
                case 4:
                    big.iAa = aVar3.BTU.readString();
                    AppMethodBeat.o(134434);
                    return 0;
                case 5:
                    big.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(134434);
                    return 0;
                case 6:
                    big.iAe = aVar3.BTU.readString();
                    AppMethodBeat.o(134434);
                    return 0;
                case 7:
                    big.position = aVar3.BTU.vd();
                    AppMethodBeat.o(134434);
                    return 0;
                case 8:
                    big.wLx = aVar3.BTU.vd();
                    AppMethodBeat.o(134434);
                    return 0;
                case 9:
                    big.vFr = aVar3.BTU.vd();
                    AppMethodBeat.o(134434);
                    return 0;
                default:
                    AppMethodBeat.o(134434);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134434);
            return -1;
        }
    }
}
