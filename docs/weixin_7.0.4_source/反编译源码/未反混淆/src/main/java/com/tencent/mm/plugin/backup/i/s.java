package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class s extends a {
    public long jBP;
    public long jCm;
    public long jCn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18067);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.jBP);
            aVar.ai(2, this.jCm);
            aVar.ai(3, this.jCn);
            AppMethodBeat.o(18067);
            return 0;
        } else if (i == 1) {
            o = ((e.a.a.b.b.a.o(1, this.jBP) + 0) + e.a.a.b.b.a.o(2, this.jCm)) + e.a.a.b.b.a.o(3, this.jCn);
            AppMethodBeat.o(18067);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(18067);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sVar.jBP = aVar3.BTU.ve();
                    AppMethodBeat.o(18067);
                    return 0;
                case 2:
                    sVar.jCm = aVar3.BTU.ve();
                    AppMethodBeat.o(18067);
                    return 0;
                case 3:
                    sVar.jCn = aVar3.BTU.ve();
                    AppMethodBeat.o(18067);
                    return 0;
                default:
                    AppMethodBeat.o(18067);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18067);
            return -1;
        }
    }
}
