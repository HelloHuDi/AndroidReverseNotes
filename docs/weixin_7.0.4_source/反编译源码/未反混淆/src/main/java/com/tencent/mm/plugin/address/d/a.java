package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public LinkedList<b> gIY = new LinkedList();

    public a() {
        AppMethodBeat.i(16784);
        AppMethodBeat.o(16784);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(16785);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.gIY);
            AppMethodBeat.o(16785);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.gIY) + 0;
            AppMethodBeat.o(16785);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.gIY.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = com.tencent.mm.bt.a.getNextFieldNumber(aVar); c > 0; c = com.tencent.mm.bt.a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(16785);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            a aVar3 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aVar3.gIY.add(bVar);
                    }
                    AppMethodBeat.o(16785);
                    return 0;
                default:
                    AppMethodBeat.o(16785);
                    return -1;
            }
        } else {
            AppMethodBeat.o(16785);
            return -1;
        }
    }
}
