package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bbd extends a {
    public String color;
    public String jMS;
    public String url;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48886);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jMS != null) {
                aVar.e(1, this.jMS);
            }
            if (this.color != null) {
                aVar.e(2, this.color);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            AppMethodBeat.o(48886);
            return 0;
        } else if (i == 1) {
            if (this.jMS != null) {
                f = e.a.a.b.b.a.f(1, this.jMS) + 0;
            } else {
                f = 0;
            }
            if (this.color != null) {
                f += e.a.a.b.b.a.f(2, this.color);
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(4, this.url);
            }
            AppMethodBeat.o(48886);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48886);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbd bbd = (bbd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbd.jMS = aVar3.BTU.readString();
                    AppMethodBeat.o(48886);
                    return 0;
                case 2:
                    bbd.color = aVar3.BTU.readString();
                    AppMethodBeat.o(48886);
                    return 0;
                case 4:
                    bbd.url = aVar3.BTU.readString();
                    AppMethodBeat.o(48886);
                    return 0;
                default:
                    AppMethodBeat.o(48886);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48886);
            return -1;
        }
    }
}
