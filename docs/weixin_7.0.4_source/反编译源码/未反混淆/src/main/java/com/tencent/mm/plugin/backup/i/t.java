package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class t extends a {
    public String ID;
    public int jCo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18068);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18068);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.iz(2, this.jCo);
            AppMethodBeat.o(18068);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                f = e.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                f = 0;
            }
            int bs = f + e.a.a.b.b.a.bs(2, this.jCo);
            AppMethodBeat.o(18068);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ID == null) {
                bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(18068);
                throw bVar;
            }
            AppMethodBeat.o(18068);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(18068);
                    return 0;
                case 2:
                    tVar.jCo = aVar3.BTU.vd();
                    AppMethodBeat.o(18068);
                    return 0;
                default:
                    AppMethodBeat.o(18068);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18068);
            return -1;
        }
    }
}
