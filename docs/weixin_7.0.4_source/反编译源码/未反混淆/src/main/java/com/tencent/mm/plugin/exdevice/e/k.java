package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class k extends i {
    public b jBi;
    public int jCt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(19426);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.jBi == null) {
                bVar = new e.a.a.b("Not all required fields were included: Data");
                AppMethodBeat.o(19426);
                throw bVar;
            }
            if (this.lvj != null) {
                aVar.iy(1, this.lvj.computeSize());
                this.lvj.writeFields(aVar);
            }
            if (this.jBi != null) {
                aVar.c(2, this.jBi);
            }
            aVar.iz(3, this.jCt);
            AppMethodBeat.o(19426);
            return 0;
        } else if (i == 1) {
            if (this.lvj != null) {
                ix = e.a.a.a.ix(1, this.lvj.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBi != null) {
                ix += e.a.a.b.b.a.b(2, this.jBi);
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.jCt);
            AppMethodBeat.o(19426);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.jBi == null) {
                bVar = new e.a.a.b("Not all required fields were included: Data");
                AppMethodBeat.o(19426);
                throw bVar;
            }
            AppMethodBeat.o(19426);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
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
                        kVar.lvj = dVar;
                    }
                    AppMethodBeat.o(19426);
                    return 0;
                case 2:
                    kVar.jBi = aVar3.BTU.emu();
                    AppMethodBeat.o(19426);
                    return 0;
                case 3:
                    kVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(19426);
                    return 0;
                default:
                    AppMethodBeat.o(19426);
                    return -1;
            }
        } else {
            AppMethodBeat.o(19426);
            return -1;
        }
    }
}
