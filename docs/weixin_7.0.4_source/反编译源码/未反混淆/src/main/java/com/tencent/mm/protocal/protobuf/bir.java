package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bir extends a {
    public String qkq;
    public String url;
    public long wMc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48917);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.qkq != null) {
                aVar.e(1, this.qkq);
            }
            aVar.ai(2, this.wMc);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            AppMethodBeat.o(48917);
            return 0;
        } else if (i == 1) {
            if (this.qkq != null) {
                f = e.a.a.b.b.a.f(1, this.qkq) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.o(2, this.wMc);
            if (this.url != null) {
                f += e.a.a.b.b.a.f(3, this.url);
            }
            AppMethodBeat.o(48917);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48917);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bir bir = (bir) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bir.qkq = aVar3.BTU.readString();
                    AppMethodBeat.o(48917);
                    return 0;
                case 2:
                    bir.wMc = aVar3.BTU.ve();
                    AppMethodBeat.o(48917);
                    return 0;
                case 3:
                    bir.url = aVar3.BTU.readString();
                    AppMethodBeat.o(48917);
                    return 0;
                default:
                    AppMethodBeat.o(48917);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48917);
            return -1;
        }
    }
}
