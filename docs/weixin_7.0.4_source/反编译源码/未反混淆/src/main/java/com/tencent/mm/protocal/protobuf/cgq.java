package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cgq extends a {
    public boolean xfx = false;
    public LinkedList<be> xfy = new LinkedList();

    public cgq() {
        AppMethodBeat.i(73659);
        AppMethodBeat.o(73659);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73660);
        int fv;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.xfx);
            aVar.e(2, 8, this.xfy);
            AppMethodBeat.o(73660);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 1) + 0) + e.a.a.a.c(2, 8, this.xfy);
            AppMethodBeat.o(73660);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73660);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgq cgq = (cgq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgq.xfx = aVar3.BTU.ehX();
                    AppMethodBeat.o(73660);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        be beVar = new be();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = beVar.populateBuilderWithField(aVar4, beVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cgq.xfy.add(beVar);
                    }
                    AppMethodBeat.o(73660);
                    return 0;
                default:
                    AppMethodBeat.o(73660);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73660);
            return -1;
        }
    }
}
