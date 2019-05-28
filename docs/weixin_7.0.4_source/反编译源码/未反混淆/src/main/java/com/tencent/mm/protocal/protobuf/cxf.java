package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cxf extends a {
    public LinkedList<cgb> vKQ = new LinkedList();
    public int xsF;

    public cxf() {
        AppMethodBeat.i(115009);
        AppMethodBeat.o(115009);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115010);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.vKQ);
            aVar.iz(2, this.xsF);
            AppMethodBeat.o(115010);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.vKQ) + 0) + e.a.a.b.b.a.bs(2, this.xsF);
            AppMethodBeat.o(115010);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115010);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxf cxf = (cxf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgb cgb = new cgb();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cgb.populateBuilderWithField(aVar4, cgb, a.getNextFieldNumber(aVar4))) {
                        }
                        cxf.vKQ.add(cgb);
                    }
                    AppMethodBeat.o(115010);
                    return 0;
                case 2:
                    cxf.xsF = aVar3.BTU.vd();
                    AppMethodBeat.o(115010);
                    return 0;
                default:
                    AppMethodBeat.o(115010);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115010);
            return -1;
        }
    }
}
