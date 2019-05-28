package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class uz extends a {
    public int gvb;
    public String gvc;
    public String gvd;
    public String gve;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124312);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.gvb);
            if (this.gvc != null) {
                aVar.e(2, this.gvc);
            }
            if (this.gvd != null) {
                aVar.e(3, this.gvd);
            }
            if (this.gve != null) {
                aVar.e(4, this.gve);
            }
            AppMethodBeat.o(124312);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.gvb) + 0;
            if (this.gvc != null) {
                bs += e.a.a.b.b.a.f(2, this.gvc);
            }
            if (this.gvd != null) {
                bs += e.a.a.b.b.a.f(3, this.gvd);
            }
            if (this.gve != null) {
                bs += e.a.a.b.b.a.f(4, this.gve);
            }
            AppMethodBeat.o(124312);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124312);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            uz uzVar = (uz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uzVar.gvb = aVar3.BTU.vd();
                    AppMethodBeat.o(124312);
                    return 0;
                case 2:
                    uzVar.gvc = aVar3.BTU.readString();
                    AppMethodBeat.o(124312);
                    return 0;
                case 3:
                    uzVar.gvd = aVar3.BTU.readString();
                    AppMethodBeat.o(124312);
                    return 0;
                case 4:
                    uzVar.gve = aVar3.BTU.readString();
                    AppMethodBeat.o(124312);
                    return 0;
                default:
                    AppMethodBeat.o(124312);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124312);
            return -1;
        }
    }
}
