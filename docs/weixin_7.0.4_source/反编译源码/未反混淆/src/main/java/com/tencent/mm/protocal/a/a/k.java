package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class k extends a {
    public int vzn;
    public LinkedList<l> vzo = new LinkedList();

    public k() {
        AppMethodBeat.i(72829);
        AppMethodBeat.o(72829);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72830);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vzn);
            aVar.e(2, 8, this.vzo);
            AppMethodBeat.o(72830);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vzn) + 0) + e.a.a.a.c(2, 8, this.vzo);
            AppMethodBeat.o(72830);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72830);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    kVar.vzn = aVar3.BTU.vd();
                    AppMethodBeat.o(72830);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        l lVar = new l();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.vzo.add(lVar);
                    }
                    AppMethodBeat.o(72830);
                    return 0;
                default:
                    AppMethodBeat.o(72830);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72830);
            return -1;
        }
    }
}
