package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bzl extends a {
    public String url;
    public int wYt;
    public int wYu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80188);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            aVar.iz(2, this.wYt);
            aVar.iz(3, this.wYu);
            AppMethodBeat.o(80188);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = e.a.a.b.b.a.f(1, this.url) + 0;
            } else {
                f = 0;
            }
            int bs = (f + e.a.a.b.b.a.bs(2, this.wYt)) + e.a.a.b.b.a.bs(3, this.wYu);
            AppMethodBeat.o(80188);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80188);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzl bzl = (bzl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzl.url = aVar3.BTU.readString();
                    AppMethodBeat.o(80188);
                    return 0;
                case 2:
                    bzl.wYt = aVar3.BTU.vd();
                    AppMethodBeat.o(80188);
                    return 0;
                case 3:
                    bzl.wYu = aVar3.BTU.vd();
                    AppMethodBeat.o(80188);
                    return 0;
                default:
                    AppMethodBeat.o(80188);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80188);
            return -1;
        }
    }
}
