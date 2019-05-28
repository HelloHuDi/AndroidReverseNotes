package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cxi extends a {
    public String path;
    public String username;
    public int vOP;
    public String wHu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96342);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.wHu != null) {
                aVar.e(2, this.wHu);
            }
            aVar.iz(3, this.vOP);
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            AppMethodBeat.o(96342);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.wHu != null) {
                f += e.a.a.b.b.a.f(2, this.wHu);
            }
            f += e.a.a.b.b.a.bs(3, this.vOP);
            if (this.path != null) {
                f += e.a.a.b.b.a.f(4, this.path);
            }
            AppMethodBeat.o(96342);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96342);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxi cxi = (cxi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxi.username = aVar3.BTU.readString();
                    AppMethodBeat.o(96342);
                    return 0;
                case 2:
                    cxi.wHu = aVar3.BTU.readString();
                    AppMethodBeat.o(96342);
                    return 0;
                case 3:
                    cxi.vOP = aVar3.BTU.vd();
                    AppMethodBeat.o(96342);
                    return 0;
                case 4:
                    cxi.path = aVar3.BTU.readString();
                    AppMethodBeat.o(96342);
                    return 0;
                default:
                    AppMethodBeat.o(96342);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96342);
            return -1;
        }
    }
}
