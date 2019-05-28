package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class h extends a {
    public LinkedList<g> fMm = new LinkedList();

    public h() {
        AppMethodBeat.i(78446);
        AppMethodBeat.o(78446);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(78447);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.fMm);
            AppMethodBeat.o(78447);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.fMm) + 0;
            AppMethodBeat.o(78447);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fMm.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(78447);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar3, gVar, a.getNextFieldNumber(aVar3))) {
                        }
                        hVar.fMm.add(gVar);
                    }
                    AppMethodBeat.o(78447);
                    return 0;
                default:
                    AppMethodBeat.o(78447);
                    return -1;
            }
        } else {
            AppMethodBeat.o(78447);
            return -1;
        }
    }
}
