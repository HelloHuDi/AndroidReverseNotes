package com.tencent.mm.cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class c extends a {
    public int coc;
    public int jik;
    public int jil;
    public int jim;
    public int size;
    public int xFV = -1;
    public int xFW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62664);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jik);
            aVar.iz(2, this.jil);
            aVar.iz(3, this.jim);
            aVar.iz(41, this.xFV);
            aVar.iz(5, this.xFW);
            aVar.iz(6, this.coc);
            aVar.iz(7, this.size);
            AppMethodBeat.o(62664);
            return 0;
        } else if (i == 1) {
            bs = ((((((e.a.a.b.b.a.bs(1, this.jik) + 0) + e.a.a.b.b.a.bs(2, this.jil)) + e.a.a.b.b.a.bs(3, this.jim)) + e.a.a.b.b.a.bs(41, this.xFV)) + e.a.a.b.b.a.bs(5, this.xFW)) + e.a.a.b.b.a.bs(6, this.coc)) + e.a.a.b.b.a.bs(7, this.size);
            AppMethodBeat.o(62664);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62664);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.jik = aVar3.BTU.vd();
                    AppMethodBeat.o(62664);
                    return 0;
                case 2:
                    cVar.jil = aVar3.BTU.vd();
                    AppMethodBeat.o(62664);
                    return 0;
                case 3:
                    cVar.jim = aVar3.BTU.vd();
                    AppMethodBeat.o(62664);
                    return 0;
                case 5:
                    cVar.xFW = aVar3.BTU.vd();
                    AppMethodBeat.o(62664);
                    return 0;
                case 6:
                    cVar.coc = aVar3.BTU.vd();
                    AppMethodBeat.o(62664);
                    return 0;
                case 7:
                    cVar.size = aVar3.BTU.vd();
                    AppMethodBeat.o(62664);
                    return 0;
                case 41:
                    cVar.xFV = aVar3.BTU.vd();
                    AppMethodBeat.o(62664);
                    return 0;
                default:
                    AppMethodBeat.o(62664);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62664);
            return -1;
        }
    }
}
