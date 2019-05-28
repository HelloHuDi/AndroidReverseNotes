package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class axf extends a {
    public String pXM;
    public String wBn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28537);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pXM != null) {
                aVar.e(1, this.pXM);
            }
            if (this.wBn != null) {
                aVar.e(2, this.wBn);
            }
            AppMethodBeat.o(28537);
            return 0;
        } else if (i == 1) {
            if (this.pXM != null) {
                f = e.a.a.b.b.a.f(1, this.pXM) + 0;
            } else {
                f = 0;
            }
            if (this.wBn != null) {
                f += e.a.a.b.b.a.f(2, this.wBn);
            }
            AppMethodBeat.o(28537);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28537);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axf axf = (axf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axf.pXM = aVar3.BTU.readString();
                    AppMethodBeat.o(28537);
                    return 0;
                case 2:
                    axf.wBn = aVar3.BTU.readString();
                    AppMethodBeat.o(28537);
                    return 0;
                default:
                    AppMethodBeat.o(28537);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28537);
            return -1;
        }
    }
}
