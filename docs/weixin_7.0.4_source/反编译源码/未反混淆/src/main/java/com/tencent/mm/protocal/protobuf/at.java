package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class at extends a {
    public String fKh;
    public String vCs;
    public String vCt;
    public String vCu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94489);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fKh != null) {
                aVar.e(1, this.fKh);
            }
            if (this.vCs != null) {
                aVar.e(2, this.vCs);
            }
            if (this.vCt != null) {
                aVar.e(3, this.vCt);
            }
            if (this.vCu != null) {
                aVar.e(4, this.vCu);
            }
            AppMethodBeat.o(94489);
            return 0;
        } else if (i == 1) {
            if (this.fKh != null) {
                f = e.a.a.b.b.a.f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.vCs != null) {
                f += e.a.a.b.b.a.f(2, this.vCs);
            }
            if (this.vCt != null) {
                f += e.a.a.b.b.a.f(3, this.vCt);
            }
            if (this.vCu != null) {
                f += e.a.a.b.b.a.f(4, this.vCu);
            }
            AppMethodBeat.o(94489);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94489);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            at atVar = (at) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(94489);
                    return 0;
                case 2:
                    atVar.vCs = aVar3.BTU.readString();
                    AppMethodBeat.o(94489);
                    return 0;
                case 3:
                    atVar.vCt = aVar3.BTU.readString();
                    AppMethodBeat.o(94489);
                    return 0;
                case 4:
                    atVar.vCu = aVar3.BTU.readString();
                    AppMethodBeat.o(94489);
                    return 0;
                default:
                    AppMethodBeat.o(94489);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94489);
            return -1;
        }
    }
}
