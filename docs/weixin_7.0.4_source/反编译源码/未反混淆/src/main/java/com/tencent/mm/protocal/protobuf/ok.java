package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ok extends a {
    public int jBT;
    public int vEr;
    public String vUK;
    public long vUL;
    public int vUM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114434);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vUK != null) {
                aVar.e(1, this.vUK);
            }
            aVar.ai(2, this.vUL);
            aVar.iz(3, this.vUM);
            aVar.iz(4, this.vEr);
            aVar.iz(5, this.jBT);
            AppMethodBeat.o(114434);
            return 0;
        } else if (i == 1) {
            if (this.vUK != null) {
                f = e.a.a.b.b.a.f(1, this.vUK) + 0;
            } else {
                f = 0;
            }
            int o = (((f + e.a.a.b.b.a.o(2, this.vUL)) + e.a.a.b.b.a.bs(3, this.vUM)) + e.a.a.b.b.a.bs(4, this.vEr)) + e.a.a.b.b.a.bs(5, this.jBT);
            AppMethodBeat.o(114434);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114434);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ok okVar = (ok) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    okVar.vUK = aVar3.BTU.readString();
                    AppMethodBeat.o(114434);
                    return 0;
                case 2:
                    okVar.vUL = aVar3.BTU.ve();
                    AppMethodBeat.o(114434);
                    return 0;
                case 3:
                    okVar.vUM = aVar3.BTU.vd();
                    AppMethodBeat.o(114434);
                    return 0;
                case 4:
                    okVar.vEr = aVar3.BTU.vd();
                    AppMethodBeat.o(114434);
                    return 0;
                case 5:
                    okVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(114434);
                    return 0;
                default:
                    AppMethodBeat.o(114434);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114434);
            return -1;
        }
    }
}
