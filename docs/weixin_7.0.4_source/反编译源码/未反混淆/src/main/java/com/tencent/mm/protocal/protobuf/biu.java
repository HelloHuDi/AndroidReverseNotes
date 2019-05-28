package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class biu extends a {
    public int jBT;
    public int vKo;
    public String wMe;
    public b wMf;
    public b wMg;
    public b wMh;
    public String wMi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56882);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMe != null) {
                aVar.e(1, this.wMe);
            }
            aVar.iz(2, this.jBT);
            if (this.wMf != null) {
                aVar.c(3, this.wMf);
            }
            if (this.wMg != null) {
                aVar.c(4, this.wMg);
            }
            if (this.wMh != null) {
                aVar.c(5, this.wMh);
            }
            aVar.iz(6, this.vKo);
            if (this.wMi != null) {
                aVar.e(7, this.wMi);
            }
            AppMethodBeat.o(56882);
            return 0;
        } else if (i == 1) {
            if (this.wMe != null) {
                f = e.a.a.b.b.a.f(1, this.wMe) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.jBT);
            if (this.wMf != null) {
                f += e.a.a.b.b.a.b(3, this.wMf);
            }
            if (this.wMg != null) {
                f += e.a.a.b.b.a.b(4, this.wMg);
            }
            if (this.wMh != null) {
                f += e.a.a.b.b.a.b(5, this.wMh);
            }
            f += e.a.a.b.b.a.bs(6, this.vKo);
            if (this.wMi != null) {
                f += e.a.a.b.b.a.f(7, this.wMi);
            }
            AppMethodBeat.o(56882);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56882);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            biu biu = (biu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    biu.wMe = aVar3.BTU.readString();
                    AppMethodBeat.o(56882);
                    return 0;
                case 2:
                    biu.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(56882);
                    return 0;
                case 3:
                    biu.wMf = aVar3.BTU.emu();
                    AppMethodBeat.o(56882);
                    return 0;
                case 4:
                    biu.wMg = aVar3.BTU.emu();
                    AppMethodBeat.o(56882);
                    return 0;
                case 5:
                    biu.wMh = aVar3.BTU.emu();
                    AppMethodBeat.o(56882);
                    return 0;
                case 6:
                    biu.vKo = aVar3.BTU.vd();
                    AppMethodBeat.o(56882);
                    return 0;
                case 7:
                    biu.wMi = aVar3.BTU.readString();
                    AppMethodBeat.o(56882);
                    return 0;
                default:
                    AppMethodBeat.o(56882);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56882);
            return -1;
        }
    }
}
