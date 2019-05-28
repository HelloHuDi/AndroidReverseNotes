package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class j extends a {
    public int bJt;
    public String iqz;
    public g phT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56633);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.bJt);
            if (this.phT != null) {
                aVar.iy(2, this.phT.computeSize());
                this.phT.writeFields(aVar);
            }
            if (this.iqz != null) {
                aVar.e(3, this.iqz);
            }
            AppMethodBeat.o(56633);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.bJt) + 0;
            if (this.phT != null) {
                bs += e.a.a.a.ix(2, this.phT.computeSize());
            }
            if (this.iqz != null) {
                bs += e.a.a.b.b.a.f(3, this.iqz);
            }
            AppMethodBeat.o(56633);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56633);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.bJt = aVar3.BTU.vd();
                    AppMethodBeat.o(56633);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.phT = gVar;
                    }
                    AppMethodBeat.o(56633);
                    return 0;
                case 3:
                    jVar.iqz = aVar3.BTU.readString();
                    AppMethodBeat.o(56633);
                    return 0;
                default:
                    AppMethodBeat.o(56633);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56633);
            return -1;
        }
    }
}
