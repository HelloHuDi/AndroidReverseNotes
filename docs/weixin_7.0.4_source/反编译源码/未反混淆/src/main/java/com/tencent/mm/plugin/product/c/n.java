package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class n extends a {
    public int bJt;
    public String csB;
    public String name;
    public String pia;
    public String username;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56639);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.pia != null) {
                aVar.e(3, this.pia);
            }
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            aVar.iz(5, this.bJt);
            AppMethodBeat.o(56639);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += e.a.a.b.b.a.f(2, this.name);
            }
            if (this.pia != null) {
                f += e.a.a.b.b.a.f(3, this.pia);
            }
            if (this.username != null) {
                f += e.a.a.b.b.a.f(4, this.username);
            }
            int bs = f + e.a.a.b.b.a.bs(5, this.bJt);
            AppMethodBeat.o(56639);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56639);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(56639);
                    return 0;
                case 2:
                    nVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56639);
                    return 0;
                case 3:
                    nVar.pia = aVar3.BTU.readString();
                    AppMethodBeat.o(56639);
                    return 0;
                case 4:
                    nVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(56639);
                    return 0;
                case 5:
                    nVar.bJt = aVar3.BTU.vd();
                    AppMethodBeat.o(56639);
                    return 0;
                default:
                    AppMethodBeat.o(56639);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56639);
            return -1;
        }
    }
}
