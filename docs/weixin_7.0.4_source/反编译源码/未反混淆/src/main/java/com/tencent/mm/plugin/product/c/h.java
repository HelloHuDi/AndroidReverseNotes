package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class h extends a {
    public String id;
    public String name;
    public boolean phS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56631);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.aO(3, this.phS);
            AppMethodBeat.o(56631);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                f = e.a.a.b.b.a.f(1, this.id) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += e.a.a.b.b.a.f(2, this.name);
            }
            int fv = f + (e.a.a.b.b.a.fv(3) + 1);
            AppMethodBeat.o(56631);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56631);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.id = aVar3.BTU.readString();
                    AppMethodBeat.o(56631);
                    return 0;
                case 2:
                    hVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56631);
                    return 0;
                case 3:
                    hVar.phS = aVar3.BTU.ehX();
                    AppMethodBeat.o(56631);
                    return 0;
                default:
                    AppMethodBeat.o(56631);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56631);
            return -1;
        }
    }
}
