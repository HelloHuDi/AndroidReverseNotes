package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class chg extends a {
    public String kKZ;
    public String path;
    public int showType;
    public String title;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80197);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.showType);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.kKZ != null) {
                aVar.e(3, this.kKZ);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            AppMethodBeat.o(80197);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.showType) + 0;
            if (this.title != null) {
                bs += e.a.a.b.b.a.f(2, this.title);
            }
            if (this.kKZ != null) {
                bs += e.a.a.b.b.a.f(3, this.kKZ);
            }
            if (this.path != null) {
                bs += e.a.a.b.b.a.f(4, this.path);
            }
            AppMethodBeat.o(80197);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80197);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chg chg = (chg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chg.showType = aVar3.BTU.vd();
                    AppMethodBeat.o(80197);
                    return 0;
                case 2:
                    chg.title = aVar3.BTU.readString();
                    AppMethodBeat.o(80197);
                    return 0;
                case 3:
                    chg.kKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(80197);
                    return 0;
                case 4:
                    chg.path = aVar3.BTU.readString();
                    AppMethodBeat.o(80197);
                    return 0;
                default:
                    AppMethodBeat.o(80197);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80197);
            return -1;
        }
    }
}
