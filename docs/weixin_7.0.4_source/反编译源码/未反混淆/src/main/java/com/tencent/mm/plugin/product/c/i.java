package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class i extends a {
    public String name;
    public String value;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56632);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.value != null) {
                aVar.e(2, this.value);
            }
            AppMethodBeat.o(56632);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = e.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                f = 0;
            }
            if (this.value != null) {
                f += e.a.a.b.b.a.f(2, this.value);
            }
            AppMethodBeat.o(56632);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56632);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56632);
                    return 0;
                case 2:
                    iVar.value = aVar3.BTU.readString();
                    AppMethodBeat.o(56632);
                    return 0;
                default:
                    AppMethodBeat.o(56632);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56632);
            return -1;
        }
    }
}
