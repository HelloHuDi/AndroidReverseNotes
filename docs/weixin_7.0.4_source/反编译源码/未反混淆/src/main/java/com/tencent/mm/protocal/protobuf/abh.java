package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class abh extends a {
    public int cOi;
    public String cvF;
    public int index;
    public int jSW;
    public String mfg;
    public String query;
    public int scene;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51406);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.scene);
            aVar.iz(2, this.jSW);
            aVar.iz(3, this.index);
            if (this.cvF != null) {
                aVar.e(4, this.cvF);
            }
            if (this.query != null) {
                aVar.e(5, this.query);
            }
            if (this.mfg != null) {
                aVar.e(6, this.mfg);
            }
            aVar.iz(7, this.cOi);
            AppMethodBeat.o(51406);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.scene) + 0) + e.a.a.b.b.a.bs(2, this.jSW)) + e.a.a.b.b.a.bs(3, this.index);
            if (this.cvF != null) {
                bs += e.a.a.b.b.a.f(4, this.cvF);
            }
            if (this.query != null) {
                bs += e.a.a.b.b.a.f(5, this.query);
            }
            if (this.mfg != null) {
                bs += e.a.a.b.b.a.f(6, this.mfg);
            }
            bs += e.a.a.b.b.a.bs(7, this.cOi);
            AppMethodBeat.o(51406);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51406);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abh abh = (abh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abh.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(51406);
                    return 0;
                case 2:
                    abh.jSW = aVar3.BTU.vd();
                    AppMethodBeat.o(51406);
                    return 0;
                case 3:
                    abh.index = aVar3.BTU.vd();
                    AppMethodBeat.o(51406);
                    return 0;
                case 4:
                    abh.cvF = aVar3.BTU.readString();
                    AppMethodBeat.o(51406);
                    return 0;
                case 5:
                    abh.query = aVar3.BTU.readString();
                    AppMethodBeat.o(51406);
                    return 0;
                case 6:
                    abh.mfg = aVar3.BTU.readString();
                    AppMethodBeat.o(51406);
                    return 0;
                case 7:
                    abh.cOi = aVar3.BTU.vd();
                    AppMethodBeat.o(51406);
                    return 0;
                default:
                    AppMethodBeat.o(51406);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51406);
            return -1;
        }
    }
}
