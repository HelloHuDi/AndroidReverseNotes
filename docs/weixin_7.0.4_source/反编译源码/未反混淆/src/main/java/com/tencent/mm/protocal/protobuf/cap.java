package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cap extends a {
    public String jBB;
    public int wCd;
    public String wZP;
    public int wZQ;
    public String wZR;
    public int wZS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94565);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZP != null) {
                aVar.e(1, this.wZP);
            }
            aVar.iz(2, this.wZQ);
            if (this.jBB != null) {
                aVar.e(3, this.jBB);
            }
            if (this.wZR != null) {
                aVar.e(4, this.wZR);
            }
            aVar.iz(5, this.wCd);
            aVar.iz(6, this.wZS);
            AppMethodBeat.o(94565);
            return 0;
        } else if (i == 1) {
            if (this.wZP != null) {
                f = e.a.a.b.b.a.f(1, this.wZP) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wZQ);
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(3, this.jBB);
            }
            if (this.wZR != null) {
                f += e.a.a.b.b.a.f(4, this.wZR);
            }
            int bs = (f + e.a.a.b.b.a.bs(5, this.wCd)) + e.a.a.b.b.a.bs(6, this.wZS);
            AppMethodBeat.o(94565);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94565);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cap cap = (cap) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cap.wZP = aVar3.BTU.readString();
                    AppMethodBeat.o(94565);
                    return 0;
                case 2:
                    cap.wZQ = aVar3.BTU.vd();
                    AppMethodBeat.o(94565);
                    return 0;
                case 3:
                    cap.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(94565);
                    return 0;
                case 4:
                    cap.wZR = aVar3.BTU.readString();
                    AppMethodBeat.o(94565);
                    return 0;
                case 5:
                    cap.wCd = aVar3.BTU.vd();
                    AppMethodBeat.o(94565);
                    return 0;
                case 6:
                    cap.wZS = aVar3.BTU.vd();
                    AppMethodBeat.o(94565);
                    return 0;
                default:
                    AppMethodBeat.o(94565);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94565);
            return -1;
        }
    }
}
