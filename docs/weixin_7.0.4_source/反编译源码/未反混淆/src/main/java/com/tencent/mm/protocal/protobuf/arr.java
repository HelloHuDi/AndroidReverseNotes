package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class arr extends a {
    public int jBv;
    public LinkedList<arq> jBw = new LinkedList();

    public arr() {
        AppMethodBeat.i(60038);
        AppMethodBeat.o(60038);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60039);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jBv);
            aVar.e(2, 8, this.jBw);
            AppMethodBeat.o(60039);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.jBv) + 0) + e.a.a.a.c(2, 8, this.jBw);
            AppMethodBeat.o(60039);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60039);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arr arr = (arr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    arr.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(60039);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        arq arq = new arq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = arq.populateBuilderWithField(aVar4, arq, a.getNextFieldNumber(aVar4))) {
                        }
                        arr.jBw.add(arq);
                    }
                    AppMethodBeat.o(60039);
                    return 0;
                default:
                    AppMethodBeat.o(60039);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60039);
            return -1;
        }
    }
}
