package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cyj extends a {
    public int timestamp;
    public String username;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28772);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(28772);
                throw bVar;
            }
            aVar.iz(1, this.timestamp);
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            AppMethodBeat.o(28772);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.timestamp) + 0;
            if (this.username != null) {
                bs += e.a.a.b.b.a.f(2, this.username);
            }
            AppMethodBeat.o(28772);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(28772);
                throw bVar;
            }
            AppMethodBeat.o(28772);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cyj cyj = (cyj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyj.timestamp = aVar3.BTU.vd();
                    AppMethodBeat.o(28772);
                    return 0;
                case 2:
                    cyj.username = aVar3.BTU.readString();
                    AppMethodBeat.o(28772);
                    return 0;
                default:
                    AppMethodBeat.o(28772);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28772);
            return -1;
        }
    }
}
