package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> qQg = new LinkedList();
    public LinkedList<e> qQh = new LinkedList();
    public LinkedList<e> qQi = new LinkedList();
    public LinkedList<e> qQj = new LinkedList();
    public LinkedList<f> qQk = new LinkedList();
    public LinkedList<f> qQl = new LinkedList();

    public d() {
        AppMethodBeat.i(36826);
        AppMethodBeat.o(36826);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(36827);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.qQg);
            aVar.e(2, 8, this.qQh);
            aVar.e(3, 8, this.qQi);
            aVar.e(4, 8, this.qQj);
            aVar.e(5, 8, this.qQk);
            aVar.e(6, 8, this.qQl);
            AppMethodBeat.o(36827);
            return 0;
        } else if (i == 1) {
            c = (((((e.a.a.a.c(1, 8, this.qQg) + 0) + e.a.a.a.c(2, 8, this.qQh)) + e.a.a.a.c(3, 8, this.qQi)) + e.a.a.a.c(4, 8, this.qQj)) + e.a.a.a.c(5, 8, this.qQk)) + e.a.a.a.c(6, 8, this.qQl);
            AppMethodBeat.o(36827);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qQg.clear();
            this.qQh.clear();
            this.qQi.clear();
            this.qQj.clear();
            this.qQk.clear();
            this.qQl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(36827);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e eVar;
            e.a.a.a.a aVar4;
            boolean z;
            f fVar;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.qQg.add(eVar);
                    }
                    AppMethodBeat.o(36827);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.qQh.add(eVar);
                    }
                    AppMethodBeat.o(36827);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.qQi.add(eVar);
                    }
                    AppMethodBeat.o(36827);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.qQj.add(eVar);
                    }
                    AppMethodBeat.o(36827);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fVar = new f();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.qQk.add(fVar);
                    }
                    AppMethodBeat.o(36827);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fVar = new f();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.qQl.add(fVar);
                    }
                    AppMethodBeat.o(36827);
                    return 0;
                default:
                    AppMethodBeat.o(36827);
                    return -1;
            }
        } else {
            AppMethodBeat.o(36827);
            return -1;
        }
    }
}
