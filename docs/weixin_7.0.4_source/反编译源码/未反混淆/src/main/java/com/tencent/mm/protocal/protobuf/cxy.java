package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cxy extends a {
    public String csB;
    public int iCZ;
    public int iDa;
    public int type;
    public String xts;
    public String xtt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96346);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.csB != null) {
                aVar.e(2, this.csB);
            }
            if (this.xts != null) {
                aVar.e(3, this.xts);
            }
            if (this.xtt != null) {
                aVar.e(4, this.xtt);
            }
            aVar.iz(5, this.iCZ);
            aVar.iz(6, this.iDa);
            AppMethodBeat.o(96346);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.csB != null) {
                bs += e.a.a.b.b.a.f(2, this.csB);
            }
            if (this.xts != null) {
                bs += e.a.a.b.b.a.f(3, this.xts);
            }
            if (this.xtt != null) {
                bs += e.a.a.b.b.a.f(4, this.xtt);
            }
            bs = (bs + e.a.a.b.b.a.bs(5, this.iCZ)) + e.a.a.b.b.a.bs(6, this.iDa);
            AppMethodBeat.o(96346);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96346);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxy cxy = (cxy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxy.type = aVar3.BTU.vd();
                    AppMethodBeat.o(96346);
                    return 0;
                case 2:
                    cxy.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(96346);
                    return 0;
                case 3:
                    cxy.xts = aVar3.BTU.readString();
                    AppMethodBeat.o(96346);
                    return 0;
                case 4:
                    cxy.xtt = aVar3.BTU.readString();
                    AppMethodBeat.o(96346);
                    return 0;
                case 5:
                    cxy.iCZ = aVar3.BTU.vd();
                    AppMethodBeat.o(96346);
                    return 0;
                case 6:
                    cxy.iDa = aVar3.BTU.vd();
                    AppMethodBeat.o(96346);
                    return 0;
                default:
                    AppMethodBeat.o(96346);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96346);
            return -1;
        }
    }
}
