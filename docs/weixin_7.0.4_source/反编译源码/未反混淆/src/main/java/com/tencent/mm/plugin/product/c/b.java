package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public String name;
    public LinkedList<i> phB = new LinkedList();

    public b() {
        AppMethodBeat.i(56622);
        AppMethodBeat.o(56622);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56623);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.e(2, 8, this.phB);
            AppMethodBeat.o(56623);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = e.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 8, this.phB);
            AppMethodBeat.o(56623);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56623);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56623);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        i iVar = new i();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = iVar.populateBuilderWithField(aVar4, iVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.phB.add(iVar);
                    }
                    AppMethodBeat.o(56623);
                    return 0;
                default:
                    AppMethodBeat.o(56623);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56623);
            return -1;
        }
    }
}
