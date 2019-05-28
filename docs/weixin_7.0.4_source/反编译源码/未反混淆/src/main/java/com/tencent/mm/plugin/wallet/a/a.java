package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public LinkedList<c> tmA = new LinkedList();
    public n tmB;

    public a() {
        AppMethodBeat.i(56640);
        AppMethodBeat.o(56640);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56641);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.tmA);
            if (this.tmB != null) {
                aVar.iy(2, this.tmB.computeSize());
                this.tmB.writeFields(aVar);
            }
            AppMethodBeat.o(56641);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.tmA) + 0;
            if (this.tmB != null) {
                c += e.a.a.a.ix(2, this.tmB.computeSize());
            }
            AppMethodBeat.o(56641);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tmA.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); c > 0; c = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56641);
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
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c cVar = new c();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.populateBuilderWithField(aVar5, cVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.tmA.add(cVar);
                    }
                    AppMethodBeat.o(56641);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        n nVar = new n();
                        aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nVar.populateBuilderWithField(aVar5, nVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.tmB = nVar;
                    }
                    AppMethodBeat.o(56641);
                    return 0;
                default:
                    AppMethodBeat.o(56641);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56641);
            return -1;
        }
    }
}
