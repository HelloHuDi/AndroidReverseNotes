package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class o extends a {
    public String kLS;
    public String kdF;
    public int type;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35541);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.kLS != null) {
                aVar.e(2, this.kLS);
            }
            if (this.kdF != null) {
                aVar.e(3, this.kdF);
            }
            AppMethodBeat.o(35541);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.kLS != null) {
                bs += e.a.a.b.b.a.f(2, this.kLS);
            }
            if (this.kdF != null) {
                bs += e.a.a.b.b.a.f(3, this.kdF);
            }
            AppMethodBeat.o(35541);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35541);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(35541);
                    return 0;
                case 2:
                    oVar.kLS = aVar3.BTU.readString();
                    AppMethodBeat.o(35541);
                    return 0;
                case 3:
                    oVar.kdF = aVar3.BTU.readString();
                    AppMethodBeat.o(35541);
                    return 0;
                default:
                    AppMethodBeat.o(35541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35541);
            return -1;
        }
    }
}
