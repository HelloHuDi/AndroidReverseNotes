package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class g extends a {
    public m tmC;
    public String tmE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56648);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.tmC != null) {
                aVar.iy(1, this.tmC.computeSize());
                this.tmC.writeFields(aVar);
            }
            if (this.tmE != null) {
                aVar.e(2, this.tmE);
            }
            AppMethodBeat.o(56648);
            return 0;
        } else if (i == 1) {
            if (this.tmC != null) {
                ix = e.a.a.a.ix(1, this.tmC.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.tmE != null) {
                ix += e.a.a.b.b.a.f(2, this.tmE);
            }
            AppMethodBeat.o(56648);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56648);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        m mVar = new m();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.tmC = mVar;
                    }
                    AppMethodBeat.o(56648);
                    return 0;
                case 2:
                    gVar.tmE = aVar3.BTU.readString();
                    AppMethodBeat.o(56648);
                    return 0;
                default:
                    AppMethodBeat.o(56648);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56648);
            return -1;
        }
    }
}
