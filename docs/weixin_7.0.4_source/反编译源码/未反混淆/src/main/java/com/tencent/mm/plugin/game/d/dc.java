package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class dc extends a {
    public String Name;
    public int ncp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111670);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(111670);
                throw bVar;
            }
            aVar.iz(1, this.ncp);
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            AppMethodBeat.o(111670);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ncp) + 0;
            if (this.Name != null) {
                bs += e.a.a.b.b.a.f(2, this.Name);
            }
            AppMethodBeat.o(111670);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(111670);
                throw bVar;
            }
            AppMethodBeat.o(111670);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dc dcVar = (dc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcVar.ncp = aVar3.BTU.vd();
                    AppMethodBeat.o(111670);
                    return 0;
                case 2:
                    dcVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(111670);
                    return 0;
                default:
                    AppMethodBeat.o(111670);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111670);
            return -1;
        }
    }
}
