package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class c extends a {
    public LinkedList<Long> qQf = new LinkedList();

    public c() {
        AppMethodBeat.i(36824);
        AppMethodBeat.o(36824);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(36825);
        int c;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 3, this.qQf);
            AppMethodBeat.o(36825);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 3, this.qQf) + 0;
            AppMethodBeat.o(36825);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.qQf.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(36825);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.qQf.add(Long.valueOf(aVar2.BTU.ve()));
                    AppMethodBeat.o(36825);
                    return 0;
                default:
                    AppMethodBeat.o(36825);
                    return -1;
            }
        } else {
            AppMethodBeat.o(36825);
            return -1;
        }
    }
}
