package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class p extends a {
    public String fjD;
    public int id;
    public String name;
    public String tmN;
    public String url;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56659);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.id);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.tmN != null) {
                aVar.e(4, this.tmN);
            }
            if (this.fjD != null) {
                aVar.e(5, this.fjD);
            }
            AppMethodBeat.o(56659);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.id) + 0;
            if (this.name != null) {
                bs += e.a.a.b.b.a.f(2, this.name);
            }
            if (this.url != null) {
                bs += e.a.a.b.b.a.f(3, this.url);
            }
            if (this.tmN != null) {
                bs += e.a.a.b.b.a.f(4, this.tmN);
            }
            if (this.fjD != null) {
                bs += e.a.a.b.b.a.f(5, this.fjD);
            }
            AppMethodBeat.o(56659);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56659);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.id = aVar3.BTU.vd();
                    AppMethodBeat.o(56659);
                    return 0;
                case 2:
                    pVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56659);
                    return 0;
                case 3:
                    pVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56659);
                    return 0;
                case 4:
                    pVar.tmN = aVar3.BTU.readString();
                    AppMethodBeat.o(56659);
                    return 0;
                case 5:
                    pVar.fjD = aVar3.BTU.readString();
                    AppMethodBeat.o(56659);
                    return 0;
                default:
                    AppMethodBeat.o(56659);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56659);
            return -1;
        }
    }
}
