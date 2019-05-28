package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class e extends a {
    public String fMh;
    public String lang;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(78442);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fMh != null) {
                aVar.e(1, this.fMh);
            }
            if (this.lang != null) {
                aVar.e(2, this.lang);
            }
            AppMethodBeat.o(78442);
            return 0;
        } else if (i == 1) {
            if (this.fMh != null) {
                f = e.a.a.b.b.a.f(1, this.fMh) + 0;
            } else {
                f = 0;
            }
            if (this.lang != null) {
                f += e.a.a.b.b.a.f(2, this.lang);
            }
            AppMethodBeat.o(78442);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(78442);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.fMh = aVar3.BTU.readString();
                    AppMethodBeat.o(78442);
                    return 0;
                case 2:
                    eVar.lang = aVar3.BTU.readString();
                    AppMethodBeat.o(78442);
                    return 0;
                default:
                    AppMethodBeat.o(78442);
                    return -1;
            }
        } else {
            AppMethodBeat.o(78442);
            return -1;
        }
    }
}
