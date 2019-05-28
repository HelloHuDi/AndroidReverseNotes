package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class e extends a {
    public long jxD;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18048);
        int o;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).ai(1, this.jxD);
            AppMethodBeat.o(18048);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.jxD) + 0;
            AppMethodBeat.o(18048);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar); o > 0; o = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, o)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(18048);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.jxD = aVar2.BTU.ve();
                    AppMethodBeat.o(18048);
                    return 0;
                default:
                    AppMethodBeat.o(18048);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18048);
            return -1;
        }
    }
}
