package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class t extends a {
    public String fKh;
    public String mZo;
    public int nam;
    public int nan;
    public int nao;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111557);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.nam);
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            aVar.iz(3, this.nan);
            if (this.mZo != null) {
                aVar.e(4, this.mZo);
            }
            aVar.iz(5, this.nao);
            AppMethodBeat.o(111557);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.nam) + 0;
            if (this.fKh != null) {
                bs += e.a.a.b.b.a.f(2, this.fKh);
            }
            bs += e.a.a.b.b.a.bs(3, this.nan);
            if (this.mZo != null) {
                bs += e.a.a.b.b.a.f(4, this.mZo);
            }
            bs += e.a.a.b.b.a.bs(5, this.nao);
            AppMethodBeat.o(111557);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111557);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.nam = aVar3.BTU.vd();
                    AppMethodBeat.o(111557);
                    return 0;
                case 2:
                    tVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(111557);
                    return 0;
                case 3:
                    tVar.nan = aVar3.BTU.vd();
                    AppMethodBeat.o(111557);
                    return 0;
                case 4:
                    tVar.mZo = aVar3.BTU.readString();
                    AppMethodBeat.o(111557);
                    return 0;
                case 5:
                    tVar.nao = aVar3.BTU.vd();
                    AppMethodBeat.o(111557);
                    return 0;
                default:
                    AppMethodBeat.o(111557);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111557);
            return -1;
        }
    }
}
