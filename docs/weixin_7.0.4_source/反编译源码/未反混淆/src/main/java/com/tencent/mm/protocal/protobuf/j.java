package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class j extends a {
    public long cSh;
    public String username;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56678);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.ai(2, this.cSh);
            AppMethodBeat.o(56678);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            int o = f + e.a.a.b.b.a.o(2, this.cSh);
            AppMethodBeat.o(56678);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56678);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(56678);
                    return 0;
                case 2:
                    jVar.cSh = aVar3.BTU.ve();
                    AppMethodBeat.o(56678);
                    return 0;
                default:
                    AppMethodBeat.o(56678);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56678);
            return -1;
        }
    }
}
