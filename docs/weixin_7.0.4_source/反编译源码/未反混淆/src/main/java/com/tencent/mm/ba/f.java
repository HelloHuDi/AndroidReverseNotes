package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class f extends a {
    public LinkedList<d> fMi = new LinkedList();
    public double fMj;

    public f() {
        AppMethodBeat.i(78443);
        AppMethodBeat.o(78443);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(78444);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.fMi);
            aVar.f(2, this.fMj);
            AppMethodBeat.o(78444);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.fMi) + 0) + (e.a.a.b.b.a.fv(2) + 8);
            AppMethodBeat.o(78444);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fMi.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(78444);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.fMi.add(dVar);
                    }
                    AppMethodBeat.o(78444);
                    return 0;
                case 2:
                    fVar.fMj = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(78444);
                    return 0;
                default:
                    AppMethodBeat.o(78444);
                    return -1;
            }
        } else {
            AppMethodBeat.o(78444);
            return -1;
        }
    }
}
