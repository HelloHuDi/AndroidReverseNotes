package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bkh extends a {
    public int Timestamp;
    public axx wcn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28571);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcn != null) {
                aVar.iy(1, this.wcn.computeSize());
                this.wcn.writeFields(aVar);
            }
            aVar.iz(2, this.Timestamp);
            AppMethodBeat.o(28571);
            return 0;
        } else if (i == 1) {
            if (this.wcn != null) {
                ix = e.a.a.a.ix(1, this.wcn.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ix + e.a.a.b.b.a.bs(2, this.Timestamp);
            AppMethodBeat.o(28571);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28571);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkh bkh = (bkh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        axx axx = new axx();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axx.populateBuilderWithField(aVar4, axx, a.getNextFieldNumber(aVar4))) {
                        }
                        bkh.wcn = axx;
                    }
                    AppMethodBeat.o(28571);
                    return 0;
                case 2:
                    bkh.Timestamp = aVar3.BTU.vd();
                    AppMethodBeat.o(28571);
                    return 0;
                default:
                    AppMethodBeat.o(28571);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28571);
            return -1;
        }
    }
}
