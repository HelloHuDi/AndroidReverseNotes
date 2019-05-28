package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class axm extends a {
    public String Desc;
    public String nbs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62574);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nbs != null) {
                aVar.e(1, this.nbs);
            }
            if (this.Desc != null) {
                aVar.e(2, this.Desc);
            }
            AppMethodBeat.o(62574);
            return 0;
        } else if (i == 1) {
            if (this.nbs != null) {
                f = e.a.a.b.b.a.f(1, this.nbs) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(2, this.Desc);
            }
            AppMethodBeat.o(62574);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62574);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axm axm = (axm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axm.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(62574);
                    return 0;
                case 2:
                    axm.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(62574);
                    return 0;
                default:
                    AppMethodBeat.o(62574);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62574);
            return -1;
        }
    }
}
