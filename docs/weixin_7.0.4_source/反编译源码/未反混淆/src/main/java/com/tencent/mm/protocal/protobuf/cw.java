package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cw extends a {
    public ayj vEU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60023);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEU != null) {
                aVar.iy(1, this.vEU.computeSize());
                this.vEU.writeFields(aVar);
            }
            AppMethodBeat.o(60023);
            return 0;
        } else if (i == 1) {
            if (this.vEU != null) {
                ix = e.a.a.a.ix(1, this.vEU.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(60023);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60023);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cw cwVar = (cw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ayj ayj = new ayj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ayj.populateBuilderWithField(aVar4, ayj, a.getNextFieldNumber(aVar4))) {
                        }
                        cwVar.vEU = ayj;
                    }
                    AppMethodBeat.o(60023);
                    return 0;
                default:
                    AppMethodBeat.o(60023);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60023);
            return -1;
        }
    }
}
