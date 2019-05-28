package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bzr extends a {
    public int wYL;
    public LinkedList<cfi> wYM = new LinkedList();

    public bzr() {
        AppMethodBeat.i(58931);
        AppMethodBeat.o(58931);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58932);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wYL);
            aVar.e(2, 8, this.wYM);
            AppMethodBeat.o(58932);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.wYL) + 0) + e.a.a.a.c(2, 8, this.wYM);
            AppMethodBeat.o(58932);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wYM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58932);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzr bzr = (bzr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bzr.wYL = aVar3.BTU.vd();
                    AppMethodBeat.o(58932);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cfi cfi = new cfi();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cfi.populateBuilderWithField(aVar4, cfi, a.getNextFieldNumber(aVar4))) {
                        }
                        bzr.wYM.add(cfi);
                    }
                    AppMethodBeat.o(58932);
                    return 0;
                default:
                    AppMethodBeat.o(58932);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58932);
            return -1;
        }
    }
}
