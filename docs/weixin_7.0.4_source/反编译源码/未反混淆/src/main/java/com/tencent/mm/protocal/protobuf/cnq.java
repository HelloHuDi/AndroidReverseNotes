package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cnq extends a {
    public int xkW;
    public bdk xkX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124373);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xkW);
            if (this.xkX != null) {
                aVar.iy(3, this.xkX.computeSize());
                this.xkX.writeFields(aVar);
            }
            AppMethodBeat.o(124373);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xkW) + 0;
            if (this.xkX != null) {
                bs += e.a.a.a.ix(3, this.xkX.computeSize());
            }
            AppMethodBeat.o(124373);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124373);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cnq cnq = (cnq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnq.xkW = aVar3.BTU.vd();
                    AppMethodBeat.o(124373);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bdk bdk = new bdk();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bdk.populateBuilderWithField(aVar4, bdk, a.getNextFieldNumber(aVar4))) {
                        }
                        cnq.xkX = bdk;
                    }
                    AppMethodBeat.o(124373);
                    return 0;
                default:
                    AppMethodBeat.o(124373);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124373);
            return -1;
        }
    }
}
