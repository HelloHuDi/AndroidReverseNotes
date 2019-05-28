package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class q extends a {
    public int mLA;
    public int nXH;
    public long nXI;
    public int nXJ;
    public long nXK;
    public int nXa;
    public LinkedList<r> nXj = new LinkedList();

    public q() {
        AppMethodBeat.i(56612);
        AppMethodBeat.o(56612);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56613);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.nXH);
            aVar.ai(2, this.nXI);
            aVar.iz(3, this.nXJ);
            aVar.ai(4, this.nXK);
            aVar.iz(5, this.mLA);
            aVar.iz(6, this.nXa);
            aVar.e(7, 8, this.nXj);
            AppMethodBeat.o(56613);
            return 0;
        } else if (i == 1) {
            bs = ((((((e.a.a.b.b.a.bs(1, this.nXH) + 0) + e.a.a.b.b.a.o(2, this.nXI)) + e.a.a.b.b.a.bs(3, this.nXJ)) + e.a.a.b.b.a.o(4, this.nXK)) + e.a.a.b.b.a.bs(5, this.mLA)) + e.a.a.b.b.a.bs(6, this.nXa)) + e.a.a.a.c(7, 8, this.nXj);
            AppMethodBeat.o(56613);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nXj.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56613);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qVar.nXH = aVar3.BTU.vd();
                    AppMethodBeat.o(56613);
                    return 0;
                case 2:
                    qVar.nXI = aVar3.BTU.ve();
                    AppMethodBeat.o(56613);
                    return 0;
                case 3:
                    qVar.nXJ = aVar3.BTU.vd();
                    AppMethodBeat.o(56613);
                    return 0;
                case 4:
                    qVar.nXK = aVar3.BTU.ve();
                    AppMethodBeat.o(56613);
                    return 0;
                case 5:
                    qVar.mLA = aVar3.BTU.vd();
                    AppMethodBeat.o(56613);
                    return 0;
                case 6:
                    qVar.nXa = aVar3.BTU.vd();
                    AppMethodBeat.o(56613);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        r rVar = new r();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = rVar.populateBuilderWithField(aVar4, rVar, a.getNextFieldNumber(aVar4))) {
                        }
                        qVar.nXj.add(rVar);
                    }
                    AppMethodBeat.o(56613);
                    return 0;
                default:
                    AppMethodBeat.o(56613);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56613);
            return -1;
        }
    }
}
