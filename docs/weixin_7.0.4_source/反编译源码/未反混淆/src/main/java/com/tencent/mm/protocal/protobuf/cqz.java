package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cqz extends a {
    public LinkedList<cqt> xoJ = new LinkedList();

    public cqz() {
        AppMethodBeat.i(102407);
        AppMethodBeat.o(102407);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102408);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.xoJ);
            AppMethodBeat.o(102408);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.xoJ) + 0;
            AppMethodBeat.o(102408);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xoJ.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(102408);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            cqz cqz = (cqz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqt cqt = new cqt();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cqt.populateBuilderWithField(aVar3, cqt, a.getNextFieldNumber(aVar3))) {
                        }
                        cqz.xoJ.add(cqt);
                    }
                    AppMethodBeat.o(102408);
                    return 0;
                default:
                    AppMethodBeat.o(102408);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102408);
            return -1;
        }
    }
}
