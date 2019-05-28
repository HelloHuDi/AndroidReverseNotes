package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bmv extends a {
    public int jBv;
    public LinkedList<bmu> wPM = new LinkedList();
    public int wrw;

    public bmv() {
        AppMethodBeat.i(73748);
        AppMethodBeat.o(73748);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73749);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wrw);
            aVar.iz(2, this.jBv);
            aVar.e(3, 8, this.wPM);
            AppMethodBeat.o(73749);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wrw) + 0) + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.c(3, 8, this.wPM);
            AppMethodBeat.o(73749);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wPM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73749);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmv bmv = (bmv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bmv.wrw = aVar3.BTU.vd();
                    AppMethodBeat.o(73749);
                    return 0;
                case 2:
                    bmv.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(73749);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bmu bmu = new bmu();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bmu.populateBuilderWithField(aVar4, bmu, a.getNextFieldNumber(aVar4))) {
                        }
                        bmv.wPM.add(bmu);
                    }
                    AppMethodBeat.o(73749);
                    return 0;
                default:
                    AppMethodBeat.o(73749);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73749);
            return -1;
        }
    }
}
