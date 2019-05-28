package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cvt extends a {
    public LinkedList<cvq> xrI = new LinkedList();
    public boolean xrJ;

    public cvt() {
        AppMethodBeat.i(63700);
        AppMethodBeat.o(63700);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63701);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xrI);
            aVar.aO(2, this.xrJ);
            AppMethodBeat.o(63701);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.xrI) + 0) + (e.a.a.b.b.a.fv(2) + 1);
            AppMethodBeat.o(63701);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xrI.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(63701);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvt cvt = (cvt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvq cvq = new cvq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cvq.populateBuilderWithField(aVar4, cvq, a.getNextFieldNumber(aVar4))) {
                        }
                        cvt.xrI.add(cvq);
                    }
                    AppMethodBeat.o(63701);
                    return 0;
                case 2:
                    cvt.xrJ = aVar3.BTU.ehX();
                    AppMethodBeat.o(63701);
                    return 0;
                default:
                    AppMethodBeat.o(63701);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63701);
            return -1;
        }
    }
}
