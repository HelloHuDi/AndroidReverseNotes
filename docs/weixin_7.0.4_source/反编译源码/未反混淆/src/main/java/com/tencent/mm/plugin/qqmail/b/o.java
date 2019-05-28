package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class o extends a {
    public String nJq;
    public String name;
    public int puf;
    public int pug;
    public String puh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(67960);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name == null) {
                bVar = new b("Not all required fields were included: name");
                AppMethodBeat.o(67960);
                throw bVar;
            } else if (this.nJq == null) {
                bVar = new b("Not all required fields were included: addr");
                AppMethodBeat.o(67960);
                throw bVar;
            } else {
                aVar.iz(1, this.puf);
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                if (this.nJq != null) {
                    aVar.e(3, this.nJq);
                }
                aVar.iz(4, this.pug);
                if (this.puh != null) {
                    aVar.e(5, this.puh);
                }
                AppMethodBeat.o(67960);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.puf) + 0;
            if (this.name != null) {
                bs += e.a.a.b.b.a.f(2, this.name);
            }
            if (this.nJq != null) {
                bs += e.a.a.b.b.a.f(3, this.nJq);
            }
            bs += e.a.a.b.b.a.bs(4, this.pug);
            if (this.puh != null) {
                bs += e.a.a.b.b.a.f(5, this.puh);
            }
            AppMethodBeat.o(67960);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.name == null) {
                bVar = new b("Not all required fields were included: name");
                AppMethodBeat.o(67960);
                throw bVar;
            } else if (this.nJq == null) {
                bVar = new b("Not all required fields were included: addr");
                AppMethodBeat.o(67960);
                throw bVar;
            } else {
                AppMethodBeat.o(67960);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.puf = aVar3.BTU.vd();
                    AppMethodBeat.o(67960);
                    return 0;
                case 2:
                    oVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(67960);
                    return 0;
                case 3:
                    oVar.nJq = aVar3.BTU.readString();
                    AppMethodBeat.o(67960);
                    return 0;
                case 4:
                    oVar.pug = aVar3.BTU.vd();
                    AppMethodBeat.o(67960);
                    return 0;
                case 5:
                    oVar.puh = aVar3.BTU.readString();
                    AppMethodBeat.o(67960);
                    return 0;
                default:
                    AppMethodBeat.o(67960);
                    return -1;
            }
        } else {
            AppMethodBeat.o(67960);
            return -1;
        }
    }
}
