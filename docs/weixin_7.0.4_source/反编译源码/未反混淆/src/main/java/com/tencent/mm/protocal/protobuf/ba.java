package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ba extends a {
    public LinkedList<az> vCQ = new LinkedList();
    public cgv vCR;

    public ba() {
        AppMethodBeat.i(48770);
        AppMethodBeat.o(48770);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48771);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.vCQ);
            if (this.vCR != null) {
                aVar.iy(2, this.vCR.computeSize());
                this.vCR.writeFields(aVar);
            }
            AppMethodBeat.o(48771);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vCQ) + 0;
            if (this.vCR != null) {
                c += e.a.a.a.ix(2, this.vCR.computeSize());
            }
            AppMethodBeat.o(48771);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48771);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ba baVar = (ba) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        az azVar = new az();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azVar.populateBuilderWithField(aVar4, azVar, a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.vCQ.add(azVar);
                    }
                    AppMethodBeat.o(48771);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.vCR = cgv;
                    }
                    AppMethodBeat.o(48771);
                    return 0;
                default:
                    AppMethodBeat.o(48771);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48771);
            return -1;
        }
    }
}
