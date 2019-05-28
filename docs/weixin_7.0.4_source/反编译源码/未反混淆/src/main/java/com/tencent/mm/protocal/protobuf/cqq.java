package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cqq extends a {
    public String wyn;
    public long xox;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102398);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.xox);
            if (this.wyn != null) {
                aVar.e(2, this.wyn);
            }
            AppMethodBeat.o(102398);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.xox) + 0;
            if (this.wyn != null) {
                o += e.a.a.b.b.a.f(2, this.wyn);
            }
            AppMethodBeat.o(102398);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102398);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqq cqq = (cqq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqq.xox = aVar3.BTU.ve();
                    AppMethodBeat.o(102398);
                    return 0;
                case 2:
                    cqq.wyn = aVar3.BTU.readString();
                    AppMethodBeat.o(102398);
                    return 0;
                default:
                    AppMethodBeat.o(102398);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102398);
            return -1;
        }
    }
}
