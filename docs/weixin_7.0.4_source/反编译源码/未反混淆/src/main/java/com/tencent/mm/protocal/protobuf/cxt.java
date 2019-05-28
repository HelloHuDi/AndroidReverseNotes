package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cxt extends a {
    public cxp xsZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115020);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xsZ != null) {
                aVar.iy(1, this.xsZ.computeSize());
                this.xsZ.writeFields(aVar);
            }
            AppMethodBeat.o(115020);
            return 0;
        } else if (i == 1) {
            if (this.xsZ != null) {
                ix = e.a.a.a.ix(1, this.xsZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(115020);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115020);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxt cxt = (cxt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cxp cxp = new cxp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cxp.populateBuilderWithField(aVar4, cxp, a.getNextFieldNumber(aVar4))) {
                        }
                        cxt.xsZ = cxp;
                    }
                    AppMethodBeat.o(115020);
                    return 0;
                default:
                    AppMethodBeat.o(115020);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115020);
            return -1;
        }
    }
}
