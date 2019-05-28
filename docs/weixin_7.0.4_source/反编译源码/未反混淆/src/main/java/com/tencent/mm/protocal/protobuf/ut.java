package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ut extends a {
    public LinkedList<bgc> vEN = new LinkedList();

    public ut() {
        AppMethodBeat.i(80038);
        AppMethodBeat.o(80038);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80039);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.vEN);
            AppMethodBeat.o(80039);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vEN) + 0;
            AppMethodBeat.o(80039);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEN.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(80039);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            ut utVar = (ut) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgc bgc = new bgc();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bgc.populateBuilderWithField(aVar3, bgc, a.getNextFieldNumber(aVar3))) {
                        }
                        utVar.vEN.add(bgc);
                    }
                    AppMethodBeat.o(80039);
                    return 0;
                default:
                    AppMethodBeat.o(80039);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80039);
            return -1;
        }
    }
}
