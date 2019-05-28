package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cps extends a {
    public LinkedList<coj> xma = new LinkedList();
    public int xnF;
    public int xnG;

    public cps() {
        AppMethodBeat.i(5255);
        AppMethodBeat.o(5255);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5256);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xnF);
            aVar.iz(2, this.xnG);
            aVar.e(3, 8, this.xma);
            AppMethodBeat.o(5256);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.xnF) + 0) + e.a.a.b.b.a.bs(2, this.xnG)) + e.a.a.a.c(3, 8, this.xma);
            AppMethodBeat.o(5256);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xma.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5256);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cps cps = (cps) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cps.xnF = aVar3.BTU.vd();
                    AppMethodBeat.o(5256);
                    return 0;
                case 2:
                    cps.xnG = aVar3.BTU.vd();
                    AppMethodBeat.o(5256);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = coj.populateBuilderWithField(aVar4, coj, a.getNextFieldNumber(aVar4))) {
                        }
                        cps.xma.add(coj);
                    }
                    AppMethodBeat.o(5256);
                    return 0;
                default:
                    AppMethodBeat.o(5256);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5256);
            return -1;
        }
    }
}
