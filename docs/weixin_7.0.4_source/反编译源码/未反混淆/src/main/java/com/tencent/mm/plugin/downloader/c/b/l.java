package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class l extends a {
    public long duration;
    public long interval;
    public long kLH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35538);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.duration);
            aVar.ai(2, this.interval);
            aVar.ai(3, this.kLH);
            AppMethodBeat.o(35538);
            return 0;
        } else if (i == 1) {
            o = ((e.a.a.b.b.a.o(1, this.duration) + 0) + e.a.a.b.b.a.o(2, this.interval)) + e.a.a.b.b.a.o(3, this.kLH);
            AppMethodBeat.o(35538);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35538);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.duration = aVar3.BTU.ve();
                    AppMethodBeat.o(35538);
                    return 0;
                case 2:
                    lVar.interval = aVar3.BTU.ve();
                    AppMethodBeat.o(35538);
                    return 0;
                case 3:
                    lVar.kLH = aVar3.BTU.ve();
                    AppMethodBeat.o(35538);
                    return 0;
                default:
                    AppMethodBeat.o(35538);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35538);
            return -1;
        }
    }
}
