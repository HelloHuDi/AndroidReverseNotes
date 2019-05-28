package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class g extends a {
    public String country;
    public String duc;
    public String dud;
    public String fBg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56630);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.country != null) {
                aVar.e(1, this.country);
            }
            if (this.duc != null) {
                aVar.e(2, this.duc);
            }
            if (this.dud != null) {
                aVar.e(3, this.dud);
            }
            if (this.fBg != null) {
                aVar.e(4, this.fBg);
            }
            AppMethodBeat.o(56630);
            return 0;
        } else if (i == 1) {
            if (this.country != null) {
                f = e.a.a.b.b.a.f(1, this.country) + 0;
            } else {
                f = 0;
            }
            if (this.duc != null) {
                f += e.a.a.b.b.a.f(2, this.duc);
            }
            if (this.dud != null) {
                f += e.a.a.b.b.a.f(3, this.dud);
            }
            if (this.fBg != null) {
                f += e.a.a.b.b.a.f(4, this.fBg);
            }
            AppMethodBeat.o(56630);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56630);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.country = aVar3.BTU.readString();
                    AppMethodBeat.o(56630);
                    return 0;
                case 2:
                    gVar.duc = aVar3.BTU.readString();
                    AppMethodBeat.o(56630);
                    return 0;
                case 3:
                    gVar.dud = aVar3.BTU.readString();
                    AppMethodBeat.o(56630);
                    return 0;
                case 4:
                    gVar.fBg = aVar3.BTU.readString();
                    AppMethodBeat.o(56630);
                    return 0;
                default:
                    AppMethodBeat.o(56630);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56630);
            return -1;
        }
    }
}
