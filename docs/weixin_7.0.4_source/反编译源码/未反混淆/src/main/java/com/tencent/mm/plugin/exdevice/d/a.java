package com.tencent.mm.plugin.exdevice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends com.tencent.mm.bt.a {
    public int luF;
    public String luG;
    public String luH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(19415);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.luF);
            if (this.luG != null) {
                aVar.e(2, this.luG);
            }
            if (this.luH != null) {
                aVar.e(3, this.luH);
            }
            AppMethodBeat.o(19415);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.luF) + 0;
            if (this.luG != null) {
                bs += e.a.a.b.b.a.f(2, this.luG);
            }
            if (this.luH != null) {
                bs += e.a.a.b.b.a.f(3, this.luH);
            }
            AppMethodBeat.o(19415);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); bs > 0; bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(19415);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.luF = aVar3.BTU.vd();
                    AppMethodBeat.o(19415);
                    return 0;
                case 2:
                    aVar4.luG = aVar3.BTU.readString();
                    AppMethodBeat.o(19415);
                    return 0;
                case 3:
                    aVar4.luH = aVar3.BTU.readString();
                    AppMethodBeat.o(19415);
                    return 0;
                default:
                    AppMethodBeat.o(19415);
                    return -1;
            }
        } else {
            AppMethodBeat.o(19415);
            return -1;
        }
    }
}
