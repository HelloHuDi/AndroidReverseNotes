package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class asi extends a {
    public String cIY;
    public String url;
    public String wvU;
    public String wvV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48863);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wvU != null) {
                aVar.e(1, this.wvU);
            }
            if (this.wvV != null) {
                aVar.e(2, this.wvV);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.cIY != null) {
                aVar.e(4, this.cIY);
            }
            AppMethodBeat.o(48863);
            return 0;
        } else if (i == 1) {
            if (this.wvU != null) {
                f = e.a.a.b.b.a.f(1, this.wvU) + 0;
            } else {
                f = 0;
            }
            if (this.wvV != null) {
                f += e.a.a.b.b.a.f(2, this.wvV);
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(3, this.url);
            }
            if (this.cIY != null) {
                f += e.a.a.b.b.a.f(4, this.cIY);
            }
            AppMethodBeat.o(48863);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48863);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asi asi = (asi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asi.wvU = aVar3.BTU.readString();
                    AppMethodBeat.o(48863);
                    return 0;
                case 2:
                    asi.wvV = aVar3.BTU.readString();
                    AppMethodBeat.o(48863);
                    return 0;
                case 3:
                    asi.url = aVar3.BTU.readString();
                    AppMethodBeat.o(48863);
                    return 0;
                case 4:
                    asi.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(48863);
                    return 0;
                default:
                    AppMethodBeat.o(48863);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48863);
            return -1;
        }
    }
}
