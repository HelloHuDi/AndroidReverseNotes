package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bs extends a {
    public brf vDY;
    public brf vDZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94501);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vDY != null) {
                aVar.iy(1, this.vDY.computeSize());
                this.vDY.writeFields(aVar);
            }
            if (this.vDZ != null) {
                aVar.iy(2, this.vDZ.computeSize());
                this.vDZ.writeFields(aVar);
            }
            AppMethodBeat.o(94501);
            return 0;
        } else if (i == 1) {
            if (this.vDY != null) {
                ix = e.a.a.a.ix(1, this.vDY.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vDZ != null) {
                ix += e.a.a.a.ix(2, this.vDZ.computeSize());
            }
            AppMethodBeat.o(94501);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94501);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bs bsVar = (bs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            brf brf;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brf = new brf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.populateBuilderWithField(aVar4, brf, a.getNextFieldNumber(aVar4))) {
                        }
                        bsVar.vDY = brf;
                    }
                    AppMethodBeat.o(94501);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brf = new brf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.populateBuilderWithField(aVar4, brf, a.getNextFieldNumber(aVar4))) {
                        }
                        bsVar.vDZ = brf;
                    }
                    AppMethodBeat.o(94501);
                    return 0;
                default:
                    AppMethodBeat.o(94501);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94501);
            return -1;
        }
    }
}
