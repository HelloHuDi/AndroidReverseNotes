package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class am extends a {
    public int xXB;
    public LinkedList<Integer> xXC = new LinkedList();
    public LinkedList<Integer> xXD = new LinkedList();
    public LinkedList<Integer> xXE = new LinkedList();
    public LinkedList<Long> xXF = new LinkedList();
    public LinkedList<Long> xXG = new LinkedList();
    public LinkedList<Long> xXH = new LinkedList();

    public am() {
        AppMethodBeat.i(60134);
        AppMethodBeat.o(60134);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60135);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xXB);
            aVar.e(2, 2, this.xXC);
            aVar.e(3, 2, this.xXD);
            aVar.e(4, 2, this.xXE);
            aVar.e(5, 3, this.xXF);
            aVar.e(6, 3, this.xXG);
            aVar.e(7, 3, this.xXH);
            AppMethodBeat.o(60135);
            return 0;
        } else if (i == 1) {
            bs = ((((((e.a.a.b.b.a.bs(1, this.xXB) + 0) + e.a.a.a.c(2, 2, this.xXC)) + e.a.a.a.c(3, 2, this.xXD)) + e.a.a.a.c(4, 2, this.xXE)) + e.a.a.a.c(5, 3, this.xXF)) + e.a.a.a.c(6, 3, this.xXG)) + e.a.a.a.c(7, 3, this.xXH);
            AppMethodBeat.o(60135);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xXC.clear();
            this.xXD.clear();
            this.xXE.clear();
            this.xXF.clear();
            this.xXG.clear();
            this.xXH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60135);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            am amVar = (am) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amVar.xXB = aVar3.BTU.vd();
                    AppMethodBeat.o(60135);
                    return 0;
                case 2:
                    amVar.xXC.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(60135);
                    return 0;
                case 3:
                    amVar.xXD.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(60135);
                    return 0;
                case 4:
                    amVar.xXE.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(60135);
                    return 0;
                case 5:
                    amVar.xXF.add(Long.valueOf(aVar3.BTU.ve()));
                    AppMethodBeat.o(60135);
                    return 0;
                case 6:
                    amVar.xXG.add(Long.valueOf(aVar3.BTU.ve()));
                    AppMethodBeat.o(60135);
                    return 0;
                case 7:
                    amVar.xXH.add(Long.valueOf(aVar3.BTU.ve()));
                    AppMethodBeat.o(60135);
                    return 0;
                default:
                    AppMethodBeat.o(60135);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60135);
            return -1;
        }
    }
}
