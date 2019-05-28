package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class mk extends a {
    public long vQj;
    public b vQk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60024);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.vQj);
            if (this.vQk != null) {
                aVar.c(2, this.vQk);
            }
            AppMethodBeat.o(60024);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vQj) + 0;
            if (this.vQk != null) {
                o += e.a.a.b.b.a.b(2, this.vQk);
            }
            AppMethodBeat.o(60024);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60024);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mk mkVar = (mk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mkVar.vQj = aVar3.BTU.ve();
                    AppMethodBeat.o(60024);
                    return 0;
                case 2:
                    mkVar.vQk = aVar3.BTU.emu();
                    AppMethodBeat.o(60024);
                    return 0;
                default:
                    AppMethodBeat.o(60024);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60024);
            return -1;
        }
    }
}
