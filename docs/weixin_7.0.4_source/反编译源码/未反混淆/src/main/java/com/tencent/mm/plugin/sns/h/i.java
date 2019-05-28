package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<h> qQr = new LinkedList();
    public g qQs;

    public i() {
        AppMethodBeat.i(36832);
        AppMethodBeat.o(36832);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(36833);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.qQr);
            if (this.qQs != null) {
                aVar.iy(2, this.qQs.computeSize());
                this.qQs.writeFields(aVar);
            }
            AppMethodBeat.o(36833);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.qQr) + 0;
            if (this.qQs != null) {
                c += e.a.a.a.ix(2, this.qQs.computeSize());
            }
            AppMethodBeat.o(36833);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qQr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(36833);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
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
                        h hVar = new h();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.qQr.add(hVar);
                    }
                    AppMethodBeat.o(36833);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.qQs = gVar;
                    }
                    AppMethodBeat.o(36833);
                    return 0;
                default:
                    AppMethodBeat.o(36833);
                    return -1;
            }
        } else {
            AppMethodBeat.o(36833);
            return -1;
        }
    }
}
