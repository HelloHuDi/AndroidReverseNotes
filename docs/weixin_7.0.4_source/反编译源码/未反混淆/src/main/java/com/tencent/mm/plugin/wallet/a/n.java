package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class n extends a {
    public LinkedList<o> tns = new LinkedList();

    public n() {
        AppMethodBeat.i(56656);
        AppMethodBeat.o(56656);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56657);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.tns);
            AppMethodBeat.o(56657);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.tns) + 0;
            AppMethodBeat.o(56657);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tns.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(56657);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        o oVar = new o();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = oVar.populateBuilderWithField(aVar3, oVar, a.getNextFieldNumber(aVar3))) {
                        }
                        nVar.tns.add(oVar);
                    }
                    AppMethodBeat.o(56657);
                    return 0;
                default:
                    AppMethodBeat.o(56657);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56657);
            return -1;
        }
    }
}
