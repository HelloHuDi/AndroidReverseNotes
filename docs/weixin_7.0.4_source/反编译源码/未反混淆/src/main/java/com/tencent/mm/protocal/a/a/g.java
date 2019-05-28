package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class g extends a {
    public int vyT;
    public int vzj;
    public LinkedList<b> vzk = new LinkedList();
    public b vzl;

    public g() {
        AppMethodBeat.i(72823);
        AppMethodBeat.o(72823);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72824);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vyT);
            aVar.iz(2, this.vzj);
            aVar.e(3, 8, this.vzk);
            if (this.vzl != null) {
                aVar.c(4, this.vzl);
            }
            AppMethodBeat.o(72824);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.vyT) + 0) + e.a.a.b.b.a.bs(2, this.vzj)) + e.a.a.a.c(3, 8, this.vzk);
            if (this.vzl != null) {
                bs += e.a.a.b.b.a.b(4, this.vzl);
            }
            AppMethodBeat.o(72824);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72824);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gVar.vyT = aVar3.BTU.vd();
                    AppMethodBeat.o(72824);
                    return 0;
                case 2:
                    gVar.vzj = aVar3.BTU.vd();
                    AppMethodBeat.o(72824);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.vzk.add(bVar);
                    }
                    AppMethodBeat.o(72824);
                    return 0;
                case 4:
                    gVar.vzl = aVar3.BTU.emu();
                    AppMethodBeat.o(72824);
                    return 0;
                default:
                    AppMethodBeat.o(72824);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72824);
            return -1;
        }
    }
}
