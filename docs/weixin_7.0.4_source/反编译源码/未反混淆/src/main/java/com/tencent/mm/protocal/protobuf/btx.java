package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class btx extends a {
    public int jBv;
    public String wOG;
    public String wOH;
    public String wrm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56962);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wrm != null) {
                aVar.e(1, this.wrm);
            }
            if (this.wOH != null) {
                aVar.e(2, this.wOH);
            }
            aVar.iz(3, this.jBv);
            if (this.wOG != null) {
                aVar.e(4, this.wOG);
            }
            AppMethodBeat.o(56962);
            return 0;
        } else if (i == 1) {
            if (this.wrm != null) {
                f = e.a.a.b.b.a.f(1, this.wrm) + 0;
            } else {
                f = 0;
            }
            if (this.wOH != null) {
                f += e.a.a.b.b.a.f(2, this.wOH);
            }
            f += e.a.a.b.b.a.bs(3, this.jBv);
            if (this.wOG != null) {
                f += e.a.a.b.b.a.f(4, this.wOG);
            }
            AppMethodBeat.o(56962);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56962);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btx btx = (btx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btx.wrm = aVar3.BTU.readString();
                    AppMethodBeat.o(56962);
                    return 0;
                case 2:
                    btx.wOH = aVar3.BTU.readString();
                    AppMethodBeat.o(56962);
                    return 0;
                case 3:
                    btx.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(56962);
                    return 0;
                case 4:
                    btx.wOG = aVar3.BTU.readString();
                    AppMethodBeat.o(56962);
                    return 0;
                default:
                    AppMethodBeat.o(56962);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56962);
            return -1;
        }
    }
}
