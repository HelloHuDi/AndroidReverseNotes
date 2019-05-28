package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class as extends a {
    public String content;
    public int erD;
    public String iconUrl;
    public int nZn;
    public int nZo;
    public String name;
    public String type;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56616);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.erD);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.type != null) {
                aVar.e(3, this.type);
            }
            if (this.content != null) {
                aVar.e(4, this.content);
            }
            aVar.iz(5, this.nZn);
            if (this.iconUrl != null) {
                aVar.e(6, this.iconUrl);
            }
            aVar.iz(7, this.nZo);
            AppMethodBeat.o(56616);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.erD) + 0;
            if (this.name != null) {
                bs += e.a.a.b.b.a.f(2, this.name);
            }
            if (this.type != null) {
                bs += e.a.a.b.b.a.f(3, this.type);
            }
            if (this.content != null) {
                bs += e.a.a.b.b.a.f(4, this.content);
            }
            bs += e.a.a.b.b.a.bs(5, this.nZn);
            if (this.iconUrl != null) {
                bs += e.a.a.b.b.a.f(6, this.iconUrl);
            }
            bs += e.a.a.b.b.a.bs(7, this.nZo);
            AppMethodBeat.o(56616);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56616);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            as asVar = (as) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asVar.erD = aVar3.BTU.vd();
                    AppMethodBeat.o(56616);
                    return 0;
                case 2:
                    asVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56616);
                    return 0;
                case 3:
                    asVar.type = aVar3.BTU.readString();
                    AppMethodBeat.o(56616);
                    return 0;
                case 4:
                    asVar.content = aVar3.BTU.readString();
                    AppMethodBeat.o(56616);
                    return 0;
                case 5:
                    asVar.nZn = aVar3.BTU.vd();
                    AppMethodBeat.o(56616);
                    return 0;
                case 6:
                    asVar.iconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(56616);
                    return 0;
                case 7:
                    asVar.nZo = aVar3.BTU.vd();
                    AppMethodBeat.o(56616);
                    return 0;
                default:
                    AppMethodBeat.o(56616);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56616);
            return -1;
        }
    }
}
