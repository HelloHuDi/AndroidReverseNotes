package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ate extends a {
    public int wxc;
    public LinkedList<bdf> wxd = new LinkedList();
    public int wxe;

    public ate() {
        AppMethodBeat.i(72853);
        AppMethodBeat.o(72853);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72854);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wxc);
            aVar.e(2, 8, this.wxd);
            aVar.iz(3, this.wxe);
            AppMethodBeat.o(72854);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wxc) + 0) + e.a.a.a.c(2, 8, this.wxd)) + e.a.a.b.b.a.bs(3, this.wxe);
            AppMethodBeat.o(72854);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wxd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72854);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ate ate = (ate) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ate.wxc = aVar3.BTU.vd();
                    AppMethodBeat.o(72854);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdf bdf = new bdf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bdf.populateBuilderWithField(aVar4, bdf, a.getNextFieldNumber(aVar4))) {
                        }
                        ate.wxd.add(bdf);
                    }
                    AppMethodBeat.o(72854);
                    return 0;
                case 3:
                    ate.wxe = aVar3.BTU.vd();
                    AppMethodBeat.o(72854);
                    return 0;
                default:
                    AppMethodBeat.o(72854);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72854);
            return -1;
        }
    }
}
