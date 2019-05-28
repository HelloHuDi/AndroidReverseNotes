package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class yq extends a {
    public String color;
    public int pLQ;
    public String pLR;
    public String pLS;
    public int pLT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48840);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.pLQ);
            if (this.pLR != null) {
                aVar.e(2, this.pLR);
            }
            if (this.pLS != null) {
                aVar.e(3, this.pLS);
            }
            aVar.iz(4, this.pLT);
            if (this.color != null) {
                aVar.e(5, this.color);
            }
            AppMethodBeat.o(48840);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.pLQ) + 0;
            if (this.pLR != null) {
                bs += e.a.a.b.b.a.f(2, this.pLR);
            }
            if (this.pLS != null) {
                bs += e.a.a.b.b.a.f(3, this.pLS);
            }
            bs += e.a.a.b.b.a.bs(4, this.pLT);
            if (this.color != null) {
                bs += e.a.a.b.b.a.f(5, this.color);
            }
            AppMethodBeat.o(48840);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48840);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yq yqVar = (yq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yqVar.pLQ = aVar3.BTU.vd();
                    AppMethodBeat.o(48840);
                    return 0;
                case 2:
                    yqVar.pLR = aVar3.BTU.readString();
                    AppMethodBeat.o(48840);
                    return 0;
                case 3:
                    yqVar.pLS = aVar3.BTU.readString();
                    AppMethodBeat.o(48840);
                    return 0;
                case 4:
                    yqVar.pLT = aVar3.BTU.vd();
                    AppMethodBeat.o(48840);
                    return 0;
                case 5:
                    yqVar.color = aVar3.BTU.readString();
                    AppMethodBeat.o(48840);
                    return 0;
                default:
                    AppMethodBeat.o(48840);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48840);
            return -1;
        }
    }
}
