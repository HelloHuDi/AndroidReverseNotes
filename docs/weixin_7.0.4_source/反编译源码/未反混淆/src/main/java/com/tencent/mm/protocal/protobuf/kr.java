package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class kr extends a {
    public String vNL;
    public String vNM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14713);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNL != null) {
                aVar.e(1, this.vNL);
            }
            if (this.vNM != null) {
                aVar.e(2, this.vNM);
            }
            AppMethodBeat.o(14713);
            return 0;
        } else if (i == 1) {
            if (this.vNL != null) {
                f = e.a.a.b.b.a.f(1, this.vNL) + 0;
            } else {
                f = 0;
            }
            if (this.vNM != null) {
                f += e.a.a.b.b.a.f(2, this.vNM);
            }
            AppMethodBeat.o(14713);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14713);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kr krVar = (kr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    krVar.vNL = aVar3.BTU.readString();
                    AppMethodBeat.o(14713);
                    return 0;
                case 2:
                    krVar.vNM = aVar3.BTU.readString();
                    AppMethodBeat.o(14713);
                    return 0;
                default:
                    AppMethodBeat.o(14713);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14713);
            return -1;
        }
    }
}
