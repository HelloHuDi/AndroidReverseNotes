package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bsq extends a {
    public int Scene;
    public String Url;
    public int vFW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14745);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            aVar.iz(2, this.vFW);
            aVar.iz(3, this.Scene);
            AppMethodBeat.o(14745);
            return 0;
        } else if (i == 1) {
            if (this.Url != null) {
                f = e.a.a.b.b.a.f(1, this.Url) + 0;
            } else {
                f = 0;
            }
            int bs = (f + e.a.a.b.b.a.bs(2, this.vFW)) + e.a.a.b.b.a.bs(3, this.Scene);
            AppMethodBeat.o(14745);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14745);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsq bsq = (bsq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsq.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(14745);
                    return 0;
                case 2:
                    bsq.vFW = aVar3.BTU.vd();
                    AppMethodBeat.o(14745);
                    return 0;
                case 3:
                    bsq.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(14745);
                    return 0;
                default:
                    AppMethodBeat.o(14745);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14745);
            return -1;
        }
    }
}
