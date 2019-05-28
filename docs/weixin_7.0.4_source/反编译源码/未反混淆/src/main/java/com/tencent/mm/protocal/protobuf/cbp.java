package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cbp extends a {
    public int rnf;
    public int rng;
    public String vFJ;
    public String vFK;
    public String vFL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94594);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vFJ != null) {
                aVar.e(1, this.vFJ);
            }
            if (this.vFK != null) {
                aVar.e(2, this.vFK);
            }
            if (this.vFL != null) {
                aVar.e(3, this.vFL);
            }
            aVar.iz(4, this.rnf);
            aVar.iz(5, this.rng);
            AppMethodBeat.o(94594);
            return 0;
        } else if (i == 1) {
            if (this.vFJ != null) {
                f = e.a.a.b.b.a.f(1, this.vFJ) + 0;
            } else {
                f = 0;
            }
            if (this.vFK != null) {
                f += e.a.a.b.b.a.f(2, this.vFK);
            }
            if (this.vFL != null) {
                f += e.a.a.b.b.a.f(3, this.vFL);
            }
            int bs = (f + e.a.a.b.b.a.bs(4, this.rnf)) + e.a.a.b.b.a.bs(5, this.rng);
            AppMethodBeat.o(94594);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94594);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbp cbp = (cbp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbp.vFJ = aVar3.BTU.readString();
                    AppMethodBeat.o(94594);
                    return 0;
                case 2:
                    cbp.vFK = aVar3.BTU.readString();
                    AppMethodBeat.o(94594);
                    return 0;
                case 3:
                    cbp.vFL = aVar3.BTU.readString();
                    AppMethodBeat.o(94594);
                    return 0;
                case 4:
                    cbp.rnf = aVar3.BTU.vd();
                    AppMethodBeat.o(94594);
                    return 0;
                case 5:
                    cbp.rng = aVar3.BTU.vd();
                    AppMethodBeat.o(94594);
                    return 0;
                default:
                    AppMethodBeat.o(94594);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94594);
            return -1;
        }
    }
}
