package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cyi extends a {
    public int score;
    public String username;
    public int xtG;
    public int xtH;
    public int xtI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28771);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(28771);
                throw bVar;
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.iz(2, this.score);
            aVar.iz(3, this.xtG);
            aVar.iz(4, this.xtH);
            aVar.iz(5, this.xtI);
            AppMethodBeat.o(28771);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            int bs = (((f + e.a.a.b.b.a.bs(2, this.score)) + e.a.a.b.b.a.bs(3, this.xtG)) + e.a.a.b.b.a.bs(4, this.xtH)) + e.a.a.b.b.a.bs(5, this.xtI);
            AppMethodBeat.o(28771);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(28771);
                throw bVar;
            }
            AppMethodBeat.o(28771);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cyi cyi = (cyi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyi.username = aVar3.BTU.readString();
                    AppMethodBeat.o(28771);
                    return 0;
                case 2:
                    cyi.score = aVar3.BTU.vd();
                    AppMethodBeat.o(28771);
                    return 0;
                case 3:
                    cyi.xtG = aVar3.BTU.vd();
                    AppMethodBeat.o(28771);
                    return 0;
                case 4:
                    cyi.xtH = aVar3.BTU.vd();
                    AppMethodBeat.o(28771);
                    return 0;
                case 5:
                    cyi.xtI = aVar3.BTU.vd();
                    AppMethodBeat.o(28771);
                    return 0;
                default:
                    AppMethodBeat.o(28771);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28771);
            return -1;
        }
    }
}
