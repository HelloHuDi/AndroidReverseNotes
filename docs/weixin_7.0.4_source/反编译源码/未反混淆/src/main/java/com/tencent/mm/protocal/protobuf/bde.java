package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bde extends a {
    public String cDL;
    public String url;
    public String wsY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96277);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wsY != null) {
                aVar.e(1, this.wsY);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.cDL != null) {
                aVar.e(3, this.cDL);
            }
            AppMethodBeat.o(96277);
            return 0;
        } else if (i == 1) {
            if (this.wsY != null) {
                f = e.a.a.b.b.a.f(1, this.wsY) + 0;
            } else {
                f = 0;
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.cDL != null) {
                f += e.a.a.b.b.a.f(3, this.cDL);
            }
            AppMethodBeat.o(96277);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96277);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bde bde = (bde) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bde.wsY = aVar3.BTU.readString();
                    AppMethodBeat.o(96277);
                    return 0;
                case 2:
                    bde.url = aVar3.BTU.readString();
                    AppMethodBeat.o(96277);
                    return 0;
                case 3:
                    bde.cDL = aVar3.BTU.readString();
                    AppMethodBeat.o(96277);
                    return 0;
                default:
                    AppMethodBeat.o(96277);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96277);
            return -1;
        }
    }
}
