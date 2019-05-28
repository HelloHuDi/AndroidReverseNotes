package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cok extends a {
    public int xlZ;
    public LinkedList<coj> xma = new LinkedList();

    public cok() {
        AppMethodBeat.i(5228);
        AppMethodBeat.o(5228);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5229);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xlZ);
            aVar.e(2, 8, this.xma);
            AppMethodBeat.o(5229);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.xlZ) + 0) + e.a.a.a.c(2, 8, this.xma);
            AppMethodBeat.o(5229);
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
            AppMethodBeat.o(5229);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cok cok = (cok) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cok.xlZ = aVar3.BTU.vd();
                    AppMethodBeat.o(5229);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = coj.populateBuilderWithField(aVar4, coj, a.getNextFieldNumber(aVar4))) {
                        }
                        cok.xma.add(coj);
                    }
                    AppMethodBeat.o(5229);
                    return 0;
                default:
                    AppMethodBeat.o(5229);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5229);
            return -1;
        }
    }
}
