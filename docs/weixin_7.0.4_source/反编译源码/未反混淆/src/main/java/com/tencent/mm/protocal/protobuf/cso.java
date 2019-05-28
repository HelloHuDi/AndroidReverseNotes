package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cso extends a {
    public LinkedList<bfk> xpQ = new LinkedList();

    public cso() {
        AppMethodBeat.i(93801);
        AppMethodBeat.o(93801);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(93802);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.xpQ);
            AppMethodBeat.o(93802);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.xpQ) + 0;
            AppMethodBeat.o(93802);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xpQ.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(93802);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            cso cso = (cso) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bfk bfk = new bfk();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bfk.populateBuilderWithField(aVar3, bfk, a.getNextFieldNumber(aVar3))) {
                        }
                        cso.xpQ.add(bfk);
                    }
                    AppMethodBeat.o(93802);
                    return 0;
                default:
                    AppMethodBeat.o(93802);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93802);
            return -1;
        }
    }
}
