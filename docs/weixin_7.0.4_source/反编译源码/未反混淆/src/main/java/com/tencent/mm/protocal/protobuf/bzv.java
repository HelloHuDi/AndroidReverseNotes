package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bzv extends a {
    public String ThumbUrl;
    public String pdB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56974);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ThumbUrl != null) {
                aVar.e(1, this.ThumbUrl);
            }
            if (this.pdB != null) {
                aVar.e(2, this.pdB);
            }
            AppMethodBeat.o(56974);
            return 0;
        } else if (i == 1) {
            if (this.ThumbUrl != null) {
                f = e.a.a.b.b.a.f(1, this.ThumbUrl) + 0;
            } else {
                f = 0;
            }
            if (this.pdB != null) {
                f += e.a.a.b.b.a.f(2, this.pdB);
            }
            AppMethodBeat.o(56974);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56974);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzv bzv = (bzv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzv.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(56974);
                    return 0;
                case 2:
                    bzv.pdB = aVar3.BTU.readString();
                    AppMethodBeat.o(56974);
                    return 0;
                default:
                    AppMethodBeat.o(56974);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56974);
            return -1;
        }
    }
}
