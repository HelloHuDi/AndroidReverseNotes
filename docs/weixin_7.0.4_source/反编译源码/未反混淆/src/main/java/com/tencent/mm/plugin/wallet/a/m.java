package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class m extends a {
    public int jkL;
    public String pbo;
    public String tnr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56655);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.tnr != null) {
                aVar.e(1, this.tnr);
            }
            aVar.iz(2, this.jkL);
            if (this.pbo != null) {
                aVar.e(3, this.pbo);
            }
            AppMethodBeat.o(56655);
            return 0;
        } else if (i == 1) {
            if (this.tnr != null) {
                f = e.a.a.b.b.a.f(1, this.tnr) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.jkL);
            if (this.pbo != null) {
                f += e.a.a.b.b.a.f(3, this.pbo);
            }
            AppMethodBeat.o(56655);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56655);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.tnr = aVar3.BTU.readString();
                    AppMethodBeat.o(56655);
                    return 0;
                case 2:
                    mVar.jkL = aVar3.BTU.vd();
                    AppMethodBeat.o(56655);
                    return 0;
                case 3:
                    mVar.pbo = aVar3.BTU.readString();
                    AppMethodBeat.o(56655);
                    return 0;
                default:
                    AppMethodBeat.o(56655);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56655);
            return -1;
        }
    }
}
