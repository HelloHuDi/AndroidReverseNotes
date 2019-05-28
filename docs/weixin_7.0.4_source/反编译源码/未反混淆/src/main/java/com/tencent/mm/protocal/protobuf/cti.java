package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cti extends a {
    public String vHl;
    public long xqp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28716);
        b bVar;
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHl == null) {
                bVar = new b("Not all required fields were included: Username");
                AppMethodBeat.o(28716);
                throw bVar;
            }
            aVar.ai(1, this.xqp);
            if (this.vHl != null) {
                aVar.e(2, this.vHl);
            }
            AppMethodBeat.o(28716);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.xqp) + 0;
            if (this.vHl != null) {
                o += e.a.a.b.b.a.f(2, this.vHl);
            }
            AppMethodBeat.o(28716);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.vHl == null) {
                bVar = new b("Not all required fields were included: Username");
                AppMethodBeat.o(28716);
                throw bVar;
            }
            AppMethodBeat.o(28716);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cti cti = (cti) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cti.xqp = aVar3.BTU.ve();
                    AppMethodBeat.o(28716);
                    return 0;
                case 2:
                    cti.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(28716);
                    return 0;
                default:
                    AppMethodBeat.o(28716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28716);
            return -1;
        }
    }
}
