package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class g extends a {
    public String jBt;
    public int jBu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18050);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBt == null) {
                bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(18050);
                throw bVar;
            }
            if (this.jBt != null) {
                aVar.e(1, this.jBt);
            }
            aVar.iz(2, this.jBu);
            AppMethodBeat.o(18050);
            return 0;
        } else if (i == 1) {
            if (this.jBt != null) {
                f = e.a.a.b.b.a.f(1, this.jBt) + 0;
            } else {
                f = 0;
            }
            int bs = f + e.a.a.b.b.a.bs(2, this.jBu);
            AppMethodBeat.o(18050);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jBt == null) {
                bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(18050);
                throw bVar;
            }
            AppMethodBeat.o(18050);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.jBt = aVar3.BTU.readString();
                    AppMethodBeat.o(18050);
                    return 0;
                case 2:
                    gVar.jBu = aVar3.BTU.vd();
                    AppMethodBeat.o(18050);
                    return 0;
                default:
                    AppMethodBeat.o(18050);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18050);
            return -1;
        }
    }
}
