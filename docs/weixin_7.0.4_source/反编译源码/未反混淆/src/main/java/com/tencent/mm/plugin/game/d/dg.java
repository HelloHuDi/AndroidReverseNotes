package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class dg extends a {
    public String mZL;
    public String mZi;
    public String mZj;
    public int ndE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111673);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZi != null) {
                aVar.e(1, this.mZi);
            }
            if (this.mZj != null) {
                aVar.e(2, this.mZj);
            }
            aVar.iz(3, this.ndE);
            if (this.mZL != null) {
                aVar.e(4, this.mZL);
            }
            AppMethodBeat.o(111673);
            return 0;
        } else if (i == 1) {
            if (this.mZi != null) {
                f = e.a.a.b.b.a.f(1, this.mZi) + 0;
            } else {
                f = 0;
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(2, this.mZj);
            }
            f += e.a.a.b.b.a.bs(3, this.ndE);
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(4, this.mZL);
            }
            AppMethodBeat.o(111673);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111673);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dg dgVar = (dg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dgVar.mZi = aVar3.BTU.readString();
                    AppMethodBeat.o(111673);
                    return 0;
                case 2:
                    dgVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111673);
                    return 0;
                case 3:
                    dgVar.ndE = aVar3.BTU.vd();
                    AppMethodBeat.o(111673);
                    return 0;
                case 4:
                    dgVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111673);
                    return 0;
                default:
                    AppMethodBeat.o(111673);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111673);
            return -1;
        }
    }
}
