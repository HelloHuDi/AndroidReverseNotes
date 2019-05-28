package com.tencent.mm.cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public LinkedList<d> xFx = new LinkedList();
    public LinkedList<c> xFy = new LinkedList();

    public a() {
        AppMethodBeat.i(62642);
        AppMethodBeat.o(62642);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62643);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(3, 8, this.xFx);
            aVar.e(4, 8, this.xFy);
            AppMethodBeat.o(62643);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(3, 8, this.xFx) + 0) + e.a.a.a.c(4, 8, this.xFy);
            AppMethodBeat.o(62643);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xFx.clear();
            this.xFy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); c > 0; c = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62643);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar5;
            boolean z;
            switch (intValue) {
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.populateBuilderWithField(aVar5, dVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.xFx.add(dVar);
                    }
                    AppMethodBeat.o(62643);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c cVar = new c();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.populateBuilderWithField(aVar5, cVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.xFy.add(cVar);
                    }
                    AppMethodBeat.o(62643);
                    return 0;
                default:
                    AppMethodBeat.o(62643);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62643);
            return -1;
        }
    }
}
