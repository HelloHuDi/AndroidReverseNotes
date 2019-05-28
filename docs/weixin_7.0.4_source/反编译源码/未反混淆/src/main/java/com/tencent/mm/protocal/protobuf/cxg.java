package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cxg extends a {
    public double xsG;
    public long xsH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115011);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.f(1, this.xsG);
            aVar.ai(2, this.xsH);
            AppMethodBeat.o(115011);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 8) + 0) + e.a.a.b.b.a.o(2, this.xsH);
            AppMethodBeat.o(115011);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115011);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxg cxg = (cxg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxg.xsG = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(115011);
                    return 0;
                case 2:
                    cxg.xsH = aVar3.BTU.ve();
                    AppMethodBeat.o(115011);
                    return 0;
                default:
                    AppMethodBeat.o(115011);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115011);
            return -1;
        }
    }
}
