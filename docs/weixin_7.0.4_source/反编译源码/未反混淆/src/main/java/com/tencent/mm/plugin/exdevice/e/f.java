package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class f extends i {
    public b luV;
    public b luW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(19423);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lvj != null) {
                aVar.iy(1, this.lvj.computeSize());
                this.lvj.writeFields(aVar);
            }
            if (this.luV != null) {
                aVar.c(2, this.luV);
            }
            if (this.luW != null) {
                aVar.c(3, this.luW);
            }
            AppMethodBeat.o(19423);
            return 0;
        } else if (i == 1) {
            if (this.lvj != null) {
                ix = e.a.a.a.ix(1, this.lvj.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.luV != null) {
                ix += e.a.a.b.b.a.b(2, this.luV);
            }
            if (this.luW != null) {
                ix += e.a.a.b.b.a.b(3, this.luW);
            }
            AppMethodBeat.o(19423);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(19423);
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
                        d dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.lvj = dVar;
                    }
                    AppMethodBeat.o(19423);
                    return 0;
                case 2:
                    fVar.luV = aVar3.BTU.emu();
                    AppMethodBeat.o(19423);
                    return 0;
                case 3:
                    fVar.luW = aVar3.BTU.emu();
                    AppMethodBeat.o(19423);
                    return 0;
                default:
                    AppMethodBeat.o(19423);
                    return -1;
            }
        } else {
            AppMethodBeat.o(19423);
            return -1;
        }
    }
}
