package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class l extends j {
    public b jBi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(19427);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lvk == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(19427);
                throw bVar;
            }
            if (this.lvk != null) {
                aVar.iy(1, this.lvk.computeSize());
                this.lvk.writeFields(aVar);
            }
            if (this.jBi != null) {
                aVar.c(2, this.jBi);
            }
            AppMethodBeat.o(19427);
            return 0;
        } else if (i == 1) {
            if (this.lvk != null) {
                ix = e.a.a.a.ix(1, this.lvk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBi != null) {
                ix += e.a.a.b.b.a.b(2, this.jBi);
            }
            AppMethodBeat.o(19427);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.lvk == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(19427);
                throw bVar;
            }
            AppMethodBeat.o(19427);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        lVar.lvk = eVar;
                    }
                    AppMethodBeat.o(19427);
                    return 0;
                case 2:
                    lVar.jBi = aVar3.BTU.emu();
                    AppMethodBeat.o(19427);
                    return 0;
                default:
                    AppMethodBeat.o(19427);
                    return -1;
            }
        } else {
            AppMethodBeat.o(19427);
            return -1;
        }
    }
}
