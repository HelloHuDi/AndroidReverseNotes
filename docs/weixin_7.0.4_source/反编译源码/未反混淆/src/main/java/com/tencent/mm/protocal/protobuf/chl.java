package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class chl extends a {
    public String kmr;
    public String sign;
    public String wmb;
    public String xgh;
    public int xgi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56989);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgh != null) {
                aVar.e(4, this.xgh);
            }
            if (this.sign != null) {
                aVar.e(5, this.sign);
            }
            if (this.kmr != null) {
                aVar.e(6, this.kmr);
            }
            aVar.iz(7, this.xgi);
            if (this.wmb != null) {
                aVar.e(8, this.wmb);
            }
            AppMethodBeat.o(56989);
            return 0;
        } else if (i == 1) {
            if (this.xgh != null) {
                f = e.a.a.b.b.a.f(4, this.xgh) + 0;
            } else {
                f = 0;
            }
            if (this.sign != null) {
                f += e.a.a.b.b.a.f(5, this.sign);
            }
            if (this.kmr != null) {
                f += e.a.a.b.b.a.f(6, this.kmr);
            }
            f += e.a.a.b.b.a.bs(7, this.xgi);
            if (this.wmb != null) {
                f += e.a.a.b.b.a.f(8, this.wmb);
            }
            AppMethodBeat.o(56989);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56989);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chl chl = (chl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 4:
                    chl.xgh = aVar3.BTU.readString();
                    AppMethodBeat.o(56989);
                    return 0;
                case 5:
                    chl.sign = aVar3.BTU.readString();
                    AppMethodBeat.o(56989);
                    return 0;
                case 6:
                    chl.kmr = aVar3.BTU.readString();
                    AppMethodBeat.o(56989);
                    return 0;
                case 7:
                    chl.xgi = aVar3.BTU.vd();
                    AppMethodBeat.o(56989);
                    return 0;
                case 8:
                    chl.wmb = aVar3.BTU.readString();
                    AppMethodBeat.o(56989);
                    return 0;
                default:
                    AppMethodBeat.o(56989);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56989);
            return -1;
        }
    }
}
