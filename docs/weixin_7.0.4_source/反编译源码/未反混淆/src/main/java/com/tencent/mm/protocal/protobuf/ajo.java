package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ajo extends a {
    public LinkedList<ajn> wpm = new LinkedList();
    public ajm wpn;

    public ajo() {
        AppMethodBeat.i(10177);
        AppMethodBeat.o(10177);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10178);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.wpm);
            if (this.wpn != null) {
                aVar.iy(2, this.wpn.computeSize());
                this.wpn.writeFields(aVar);
            }
            AppMethodBeat.o(10178);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wpm) + 0;
            if (this.wpn != null) {
                c += e.a.a.a.ix(2, this.wpn.computeSize());
            }
            AppMethodBeat.o(10178);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10178);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajo ajo = (ajo) objArr[1];
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
                        ajn ajn = new ajn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajn.populateBuilderWithField(aVar4, ajn, a.getNextFieldNumber(aVar4))) {
                        }
                        ajo.wpm.add(ajn);
                    }
                    AppMethodBeat.o(10178);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ajm ajm = new ajm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajm.populateBuilderWithField(aVar4, ajm, a.getNextFieldNumber(aVar4))) {
                        }
                        ajo.wpn = ajm;
                    }
                    AppMethodBeat.o(10178);
                    return 0;
                default:
                    AppMethodBeat.o(10178);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10178);
            return -1;
        }
    }
}
