package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class a extends com.tencent.mm.bt.a {
    public String ID;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18044);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18044);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            AppMethodBeat.o(18044);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                f = e.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.o(18044);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18044);
                throw bVar;
            }
            AppMethodBeat.o(18044);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(18044);
                    return 0;
                default:
                    AppMethodBeat.o(18044);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18044);
            return -1;
        }
    }
}
