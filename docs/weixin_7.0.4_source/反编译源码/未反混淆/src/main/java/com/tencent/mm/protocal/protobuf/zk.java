package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class zk extends a {
    public int weH;
    public String weI;
    public String weJ;
    public String weK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28395);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.weH);
            if (this.weI != null) {
                aVar.e(2, this.weI);
            }
            if (this.weJ != null) {
                aVar.e(3, this.weJ);
            }
            if (this.weK != null) {
                aVar.e(4, this.weK);
            }
            AppMethodBeat.o(28395);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.weH) + 0;
            if (this.weI != null) {
                bs += e.a.a.b.b.a.f(2, this.weI);
            }
            if (this.weJ != null) {
                bs += e.a.a.b.b.a.f(3, this.weJ);
            }
            if (this.weK != null) {
                bs += e.a.a.b.b.a.f(4, this.weK);
            }
            AppMethodBeat.o(28395);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28395);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zk zkVar = (zk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zkVar.weH = aVar3.BTU.vd();
                    AppMethodBeat.o(28395);
                    return 0;
                case 2:
                    zkVar.weI = aVar3.BTU.readString();
                    AppMethodBeat.o(28395);
                    return 0;
                case 3:
                    zkVar.weJ = aVar3.BTU.readString();
                    AppMethodBeat.o(28395);
                    return 0;
                case 4:
                    zkVar.weK = aVar3.BTU.readString();
                    AppMethodBeat.o(28395);
                    return 0;
                default:
                    AppMethodBeat.o(28395);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28395);
            return -1;
        }
    }
}
