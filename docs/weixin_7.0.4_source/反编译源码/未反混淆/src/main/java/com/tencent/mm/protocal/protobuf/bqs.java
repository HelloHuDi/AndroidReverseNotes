package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bqs extends a {
    public String csB;
    public String path;
    public String tff;
    public int type;
    public String wTe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56957);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.csB != null) {
                aVar.e(2, this.csB);
            }
            if (this.wTe != null) {
                aVar.e(3, this.wTe);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            if (this.tff != null) {
                aVar.e(5, this.tff);
            }
            AppMethodBeat.o(56957);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.csB != null) {
                bs += e.a.a.b.b.a.f(2, this.csB);
            }
            if (this.wTe != null) {
                bs += e.a.a.b.b.a.f(3, this.wTe);
            }
            if (this.path != null) {
                bs += e.a.a.b.b.a.f(4, this.path);
            }
            if (this.tff != null) {
                bs += e.a.a.b.b.a.f(5, this.tff);
            }
            AppMethodBeat.o(56957);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56957);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqs bqs = (bqs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqs.type = aVar3.BTU.vd();
                    AppMethodBeat.o(56957);
                    return 0;
                case 2:
                    bqs.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(56957);
                    return 0;
                case 3:
                    bqs.wTe = aVar3.BTU.readString();
                    AppMethodBeat.o(56957);
                    return 0;
                case 4:
                    bqs.path = aVar3.BTU.readString();
                    AppMethodBeat.o(56957);
                    return 0;
                case 5:
                    bqs.tff = aVar3.BTU.readString();
                    AppMethodBeat.o(56957);
                    return 0;
                default:
                    AppMethodBeat.o(56957);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56957);
            return -1;
        }
    }
}
