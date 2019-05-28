package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class f extends a {
    public j phQ;
    public String phR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56629);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.phQ != null) {
                aVar.iy(1, this.phQ.computeSize());
                this.phQ.writeFields(aVar);
            }
            if (this.phR != null) {
                aVar.e(2, this.phR);
            }
            AppMethodBeat.o(56629);
            return 0;
        } else if (i == 1) {
            if (this.phQ != null) {
                ix = e.a.a.a.ix(1, this.phQ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.phR != null) {
                ix += e.a.a.b.b.a.f(2, this.phR);
            }
            AppMethodBeat.o(56629);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56629);
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
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        j jVar = new j();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jVar.populateBuilderWithField(aVar4, jVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.phQ = jVar;
                    }
                    AppMethodBeat.o(56629);
                    return 0;
                case 2:
                    fVar.phR = aVar3.BTU.readString();
                    AppMethodBeat.o(56629);
                    return 0;
                default:
                    AppMethodBeat.o(56629);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56629);
            return -1;
        }
    }
}
