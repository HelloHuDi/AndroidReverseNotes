package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<h> kKA = new LinkedList();

    public i() {
        AppMethodBeat.i(35517);
        AppMethodBeat.o(35517);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35518);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.kKA);
            AppMethodBeat.o(35518);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.kKA) + 0;
            AppMethodBeat.o(35518);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kKA.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(35518);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        h hVar = new h();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.populateBuilderWithField(aVar3, hVar, a.getNextFieldNumber(aVar3))) {
                        }
                        iVar.kKA.add(hVar);
                    }
                    AppMethodBeat.o(35518);
                    return 0;
                default:
                    AppMethodBeat.o(35518);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35518);
            return -1;
        }
    }
}
