package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class csl extends a {
    public LinkedList<csm> wmz = new LinkedList();

    public csl() {
        AppMethodBeat.i(57001);
        AppMethodBeat.o(57001);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57002);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.wmz);
            AppMethodBeat.o(57002);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wmz) + 0;
            AppMethodBeat.o(57002);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wmz.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(57002);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            csl csl = (csl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csm csm = new csm();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = csm.populateBuilderWithField(aVar3, csm, a.getNextFieldNumber(aVar3))) {
                        }
                        csl.wmz.add(csm);
                    }
                    AppMethodBeat.o(57002);
                    return 0;
                default:
                    AppMethodBeat.o(57002);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57002);
            return -1;
        }
    }
}
