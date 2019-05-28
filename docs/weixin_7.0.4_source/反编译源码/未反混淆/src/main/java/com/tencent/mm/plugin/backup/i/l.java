package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class l extends a {
    public LinkedList<k> jBC = new LinkedList();
    public int jBD;

    public l() {
        AppMethodBeat.i(18058);
        AppMethodBeat.o(18058);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18059);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.jBC);
            aVar.iz(2, this.jBD);
            AppMethodBeat.o(18059);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.jBC) + 0) + e.a.a.b.b.a.bs(2, this.jBD);
            AppMethodBeat.o(18059);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(18059);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        k kVar = new k();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = kVar.populateBuilderWithField(aVar4, kVar, a.getNextFieldNumber(aVar4))) {
                        }
                        lVar.jBC.add(kVar);
                    }
                    AppMethodBeat.o(18059);
                    return 0;
                case 2:
                    lVar.jBD = aVar3.BTU.vd();
                    AppMethodBeat.o(18059);
                    return 0;
                default:
                    AppMethodBeat.o(18059);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18059);
            return -1;
        }
    }
}
