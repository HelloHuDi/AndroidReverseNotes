package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bmw extends a {
    public int wPN;
    public String wdO;
    public int wep;
    public String wkk;
    public int wrw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73750);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wrw);
            if (this.wkk != null) {
                aVar.e(2, this.wkk);
            }
            if (this.wdO != null) {
                aVar.e(3, this.wdO);
            }
            aVar.iz(4, this.wep);
            aVar.iz(5, this.wPN);
            AppMethodBeat.o(73750);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wrw) + 0;
            if (this.wkk != null) {
                bs += e.a.a.b.b.a.f(2, this.wkk);
            }
            if (this.wdO != null) {
                bs += e.a.a.b.b.a.f(3, this.wdO);
            }
            bs = (bs + e.a.a.b.b.a.bs(4, this.wep)) + e.a.a.b.b.a.bs(5, this.wPN);
            AppMethodBeat.o(73750);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73750);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmw bmw = (bmw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmw.wrw = aVar3.BTU.vd();
                    AppMethodBeat.o(73750);
                    return 0;
                case 2:
                    bmw.wkk = aVar3.BTU.readString();
                    AppMethodBeat.o(73750);
                    return 0;
                case 3:
                    bmw.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(73750);
                    return 0;
                case 4:
                    bmw.wep = aVar3.BTU.vd();
                    AppMethodBeat.o(73750);
                    return 0;
                case 5:
                    bmw.wPN = aVar3.BTU.vd();
                    AppMethodBeat.o(73750);
                    return 0;
                default:
                    AppMethodBeat.o(73750);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73750);
            return -1;
        }
    }
}
