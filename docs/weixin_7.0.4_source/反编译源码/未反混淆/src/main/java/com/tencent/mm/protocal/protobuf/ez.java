package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ez extends a {
    public String mZr;
    public String nbm;
    public int vGY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80018);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZr != null) {
                aVar.e(1, this.mZr);
            }
            aVar.iz(2, this.vGY);
            if (this.nbm != null) {
                aVar.e(3, this.nbm);
            }
            AppMethodBeat.o(80018);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = e.a.a.b.b.a.f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vGY);
            if (this.nbm != null) {
                f += e.a.a.b.b.a.f(3, this.nbm);
            }
            AppMethodBeat.o(80018);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80018);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ez ezVar = (ez) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezVar.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(80018);
                    return 0;
                case 2:
                    ezVar.vGY = aVar3.BTU.vd();
                    AppMethodBeat.o(80018);
                    return 0;
                case 3:
                    ezVar.nbm = aVar3.BTU.readString();
                    AppMethodBeat.o(80018);
                    return 0;
                default:
                    AppMethodBeat.o(80018);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80018);
            return -1;
        }
    }
}
