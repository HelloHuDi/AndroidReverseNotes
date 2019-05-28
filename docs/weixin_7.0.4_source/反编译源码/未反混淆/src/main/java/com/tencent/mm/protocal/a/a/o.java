package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class o extends a {
    public LinkedList<m> vzF = new LinkedList();

    public o() {
        AppMethodBeat.i(72835);
        AppMethodBeat.o(72835);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72836);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.vzF);
            AppMethodBeat.o(72836);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vzF) + 0;
            AppMethodBeat.o(72836);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzF.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(72836);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        m mVar = new m();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar3, mVar, a.getNextFieldNumber(aVar3))) {
                        }
                        oVar.vzF.add(mVar);
                    }
                    AppMethodBeat.o(72836);
                    return 0;
                default:
                    AppMethodBeat.o(72836);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72836);
            return -1;
        }
    }
}
