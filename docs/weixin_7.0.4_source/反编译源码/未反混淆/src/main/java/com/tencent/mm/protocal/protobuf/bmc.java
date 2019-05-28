package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bmc extends a {
    public int nwP;
    public LinkedList<bml> wPh = new LinkedList();
    public int wem;
    public long wen;

    public bmc() {
        AppMethodBeat.i(28584);
        AppMethodBeat.o(28584);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28585);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wem);
            aVar.ai(2, this.wen);
            aVar.e(3, 8, this.wPh);
            aVar.iz(4, this.nwP);
            AppMethodBeat.o(28585);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wem) + 0) + e.a.a.b.b.a.o(2, this.wen)) + e.a.a.a.c(3, 8, this.wPh)) + e.a.a.b.b.a.bs(4, this.nwP);
            AppMethodBeat.o(28585);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wPh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28585);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmc bmc = (bmc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bmc.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28585);
                    return 0;
                case 2:
                    bmc.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(28585);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bml bml = new bml();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bml.populateBuilderWithField(aVar4, bml, a.getNextFieldNumber(aVar4))) {
                        }
                        bmc.wPh.add(bml);
                    }
                    AppMethodBeat.o(28585);
                    return 0;
                case 4:
                    bmc.nwP = aVar3.BTU.vd();
                    AppMethodBeat.o(28585);
                    return 0;
                default:
                    AppMethodBeat.o(28585);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28585);
            return -1;
        }
    }
}
