package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bf extends a {
    public LinkedList<cgq> vDi = new LinkedList();
    public bd vDj;

    public bf() {
        AppMethodBeat.i(73645);
        AppMethodBeat.o(73645);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73646);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.vDi);
            if (this.vDj != null) {
                aVar.iy(2, this.vDj.computeSize());
                this.vDj.writeFields(aVar);
            }
            AppMethodBeat.o(73646);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vDi) + 0;
            if (this.vDj != null) {
                c += e.a.a.a.ix(2, this.vDj.computeSize());
            }
            AppMethodBeat.o(73646);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vDi.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73646);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bf bfVar = (bf) objArr[1];
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
                        cgq cgq = new cgq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgq.populateBuilderWithField(aVar4, cgq, a.getNextFieldNumber(aVar4))) {
                        }
                        bfVar.vDi.add(cgq);
                    }
                    AppMethodBeat.o(73646);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bd bdVar = new bd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdVar.populateBuilderWithField(aVar4, bdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bfVar.vDj = bdVar;
                    }
                    AppMethodBeat.o(73646);
                    return 0;
                default:
                    AppMethodBeat.o(73646);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73646);
            return -1;
        }
    }
}
