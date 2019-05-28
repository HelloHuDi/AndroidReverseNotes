package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<c> eoG = new LinkedList();

    public d() {
        AppMethodBeat.i(59618);
        AppMethodBeat.o(59618);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(59619);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.eoG);
            AppMethodBeat.o(59619);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.eoG) + 0;
            AppMethodBeat.o(59619);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.eoG.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(59619);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c cVar = new c();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar3, cVar, a.getNextFieldNumber(aVar3))) {
                        }
                        dVar.eoG.add(cVar);
                    }
                    AppMethodBeat.o(59619);
                    return 0;
                default:
                    AppMethodBeat.o(59619);
                    return -1;
            }
        } else {
            AppMethodBeat.o(59619);
            return -1;
        }
    }
}
