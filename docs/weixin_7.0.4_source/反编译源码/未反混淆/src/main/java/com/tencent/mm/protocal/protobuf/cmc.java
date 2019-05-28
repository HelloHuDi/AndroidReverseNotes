package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cmc extends a {
    public String qkh;
    public int qki;
    public String scope;
    public int state;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(127737);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            if (this.qkh != null) {
                aVar.e(2, this.qkh);
            }
            aVar.iz(3, this.state);
            aVar.iz(4, this.qki);
            AppMethodBeat.o(127737);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                f = e.a.a.b.b.a.f(1, this.scope) + 0;
            } else {
                f = 0;
            }
            if (this.qkh != null) {
                f += e.a.a.b.b.a.f(2, this.qkh);
            }
            int bs = (f + e.a.a.b.b.a.bs(3, this.state)) + e.a.a.b.b.a.bs(4, this.qki);
            AppMethodBeat.o(127737);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(127737);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmc cmc = (cmc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmc.scope = aVar3.BTU.readString();
                    AppMethodBeat.o(127737);
                    return 0;
                case 2:
                    cmc.qkh = aVar3.BTU.readString();
                    AppMethodBeat.o(127737);
                    return 0;
                case 3:
                    cmc.state = aVar3.BTU.vd();
                    AppMethodBeat.o(127737);
                    return 0;
                case 4:
                    cmc.qki = aVar3.BTU.vd();
                    AppMethodBeat.o(127737);
                    return 0;
                default:
                    AppMethodBeat.o(127737);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127737);
            return -1;
        }
    }
}
