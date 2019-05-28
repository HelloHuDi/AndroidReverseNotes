package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class btf extends a {
    public String mZj;
    public int nbk;
    public String wVl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124344);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wVl != null) {
                aVar.e(1, this.wVl);
            }
            aVar.iz(2, this.nbk);
            if (this.mZj != null) {
                aVar.e(3, this.mZj);
            }
            AppMethodBeat.o(124344);
            return 0;
        } else if (i == 1) {
            if (this.wVl != null) {
                f = e.a.a.b.b.a.f(1, this.wVl) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.nbk);
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(3, this.mZj);
            }
            AppMethodBeat.o(124344);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124344);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btf btf = (btf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btf.wVl = aVar3.BTU.readString();
                    AppMethodBeat.o(124344);
                    return 0;
                case 2:
                    btf.nbk = aVar3.BTU.vd();
                    AppMethodBeat.o(124344);
                    return 0;
                case 3:
                    btf.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(124344);
                    return 0;
                default:
                    AppMethodBeat.o(124344);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124344);
            return -1;
        }
    }
}
