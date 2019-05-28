package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bqi extends a {
    public int wHG;
    public LinkedList<bqh> wSD = new LinkedList();

    public bqi() {
        AppMethodBeat.i(14740);
        AppMethodBeat.o(14740);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14741);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wHG);
            aVar.e(2, 8, this.wSD);
            AppMethodBeat.o(14741);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.wHG) + 0) + e.a.a.a.c(2, 8, this.wSD);
            AppMethodBeat.o(14741);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14741);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqi bqi = (bqi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqi.wHG = aVar3.BTU.vd();
                    AppMethodBeat.o(14741);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqh bqh = new bqh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqh.populateBuilderWithField(aVar4, bqh, a.getNextFieldNumber(aVar4))) {
                        }
                        bqi.wSD.add(bqh);
                    }
                    AppMethodBeat.o(14741);
                    return 0;
                default:
                    AppMethodBeat.o(14741);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14741);
            return -1;
        }
    }
}
