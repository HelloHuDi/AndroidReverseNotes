package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aug extends a {
    public int cts;
    public int wyf;
    public int wyg;
    public int wyh;
    public int wyi;
    public int wyj;
    public int wyk;
    public int wyl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72857);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wyf);
            aVar.iz(2, this.cts);
            aVar.iz(3, this.wyg);
            aVar.iz(4, this.wyh);
            aVar.iz(5, this.wyi);
            aVar.iz(6, this.wyj);
            aVar.iz(7, this.wyk);
            aVar.iz(8, this.wyl);
            AppMethodBeat.o(72857);
            return 0;
        } else if (i == 1) {
            bs = (((((((e.a.a.b.b.a.bs(1, this.wyf) + 0) + e.a.a.b.b.a.bs(2, this.cts)) + e.a.a.b.b.a.bs(3, this.wyg)) + e.a.a.b.b.a.bs(4, this.wyh)) + e.a.a.b.b.a.bs(5, this.wyi)) + e.a.a.b.b.a.bs(6, this.wyj)) + e.a.a.b.b.a.bs(7, this.wyk)) + e.a.a.b.b.a.bs(8, this.wyl);
            AppMethodBeat.o(72857);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72857);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aug aug = (aug) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aug.wyf = aVar3.BTU.vd();
                    AppMethodBeat.o(72857);
                    return 0;
                case 2:
                    aug.cts = aVar3.BTU.vd();
                    AppMethodBeat.o(72857);
                    return 0;
                case 3:
                    aug.wyg = aVar3.BTU.vd();
                    AppMethodBeat.o(72857);
                    return 0;
                case 4:
                    aug.wyh = aVar3.BTU.vd();
                    AppMethodBeat.o(72857);
                    return 0;
                case 5:
                    aug.wyi = aVar3.BTU.vd();
                    AppMethodBeat.o(72857);
                    return 0;
                case 6:
                    aug.wyj = aVar3.BTU.vd();
                    AppMethodBeat.o(72857);
                    return 0;
                case 7:
                    aug.wyk = aVar3.BTU.vd();
                    AppMethodBeat.o(72857);
                    return 0;
                case 8:
                    aug.wyl = aVar3.BTU.vd();
                    AppMethodBeat.o(72857);
                    return 0;
                default:
                    AppMethodBeat.o(72857);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72857);
            return -1;
        }
    }
}
