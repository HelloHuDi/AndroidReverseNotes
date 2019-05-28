package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public int jBv;
    public LinkedList<b> pXB = new LinkedList();

    public a() {
        AppMethodBeat.i(72700);
        AppMethodBeat.o(72700);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72701);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jBv);
            aVar.e(2, 8, this.pXB);
            AppMethodBeat.o(72701);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.jBv) + 0) + e.a.a.a.c(2, 8, this.pXB);
            AppMethodBeat.o(72701);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pXB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); bs > 0; bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72701);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(72701);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar5, bVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.pXB.add(bVar);
                    }
                    AppMethodBeat.o(72701);
                    return 0;
                default:
                    AppMethodBeat.o(72701);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72701);
            return -1;
        }
    }
}
