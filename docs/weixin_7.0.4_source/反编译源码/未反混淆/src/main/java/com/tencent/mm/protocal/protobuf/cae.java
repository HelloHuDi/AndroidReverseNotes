package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cae extends a {
    public bts wZq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94554);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZq != null) {
                aVar.iy(1, this.wZq.computeSize());
                this.wZq.writeFields(aVar);
            }
            AppMethodBeat.o(94554);
            return 0;
        } else if (i == 1) {
            if (this.wZq != null) {
                ix = e.a.a.a.ix(1, this.wZq.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(94554);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94554);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cae cae = (cae) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cae.wZq = bts;
                    }
                    AppMethodBeat.o(94554);
                    return 0;
                default:
                    AppMethodBeat.o(94554);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94554);
            return -1;
        }
    }
}
