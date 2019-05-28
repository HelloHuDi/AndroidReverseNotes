package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bpj extends a {
    public int count;
    public int timestamp;
    public LinkedList<bpk> wRN = new LinkedList();

    public bpj() {
        AppMethodBeat.i(28603);
        AppMethodBeat.o(28603);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28604);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.count);
            aVar.e(2, 8, this.wRN);
            aVar.iz(3, this.timestamp);
            AppMethodBeat.o(28604);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.count) + 0) + e.a.a.a.c(2, 8, this.wRN)) + e.a.a.b.b.a.bs(3, this.timestamp);
            AppMethodBeat.o(28604);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wRN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28604);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpj bpj = (bpj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bpj.count = aVar3.BTU.vd();
                    AppMethodBeat.o(28604);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpk bpk = new bpk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bpk.populateBuilderWithField(aVar4, bpk, a.getNextFieldNumber(aVar4))) {
                        }
                        bpj.wRN.add(bpk);
                    }
                    AppMethodBeat.o(28604);
                    return 0;
                case 3:
                    bpj.timestamp = aVar3.BTU.vd();
                    AppMethodBeat.o(28604);
                    return 0;
                default:
                    AppMethodBeat.o(28604);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28604);
            return -1;
        }
    }
}
