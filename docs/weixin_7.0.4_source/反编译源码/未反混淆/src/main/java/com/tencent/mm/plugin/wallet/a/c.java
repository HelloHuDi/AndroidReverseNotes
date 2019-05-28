package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class c extends a {
    public String pbo;
    public LinkedList<d> tmL = new LinkedList();

    public c() {
        AppMethodBeat.i(56643);
        AppMethodBeat.o(56643);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56644);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pbo != null) {
                aVar.e(1, this.pbo);
            }
            aVar.e(2, 8, this.tmL);
            AppMethodBeat.o(56644);
            return 0;
        } else if (i == 1) {
            if (this.pbo != null) {
                f = e.a.a.b.b.a.f(1, this.pbo) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 8, this.tmL);
            AppMethodBeat.o(56644);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tmL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56644);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.pbo = aVar3.BTU.readString();
                    AppMethodBeat.o(56644);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.tmL.add(dVar);
                    }
                    AppMethodBeat.o(56644);
                    return 0;
                default:
                    AppMethodBeat.o(56644);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56644);
            return -1;
        }
    }
}
