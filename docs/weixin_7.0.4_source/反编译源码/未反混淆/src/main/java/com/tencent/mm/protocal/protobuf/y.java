package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class y extends a {
    public String nZa;
    public String nZb;
    public String nZc;
    public String nZd;
    public int vAF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56695);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vAF);
            if (this.nZa != null) {
                aVar.e(2, this.nZa);
            }
            if (this.nZb != null) {
                aVar.e(3, this.nZb);
            }
            if (this.nZc != null) {
                aVar.e(4, this.nZc);
            }
            if (this.nZd != null) {
                aVar.e(5, this.nZd);
            }
            AppMethodBeat.o(56695);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vAF) + 0;
            if (this.nZa != null) {
                bs += e.a.a.b.b.a.f(2, this.nZa);
            }
            if (this.nZb != null) {
                bs += e.a.a.b.b.a.f(3, this.nZb);
            }
            if (this.nZc != null) {
                bs += e.a.a.b.b.a.f(4, this.nZc);
            }
            if (this.nZd != null) {
                bs += e.a.a.b.b.a.f(5, this.nZd);
            }
            AppMethodBeat.o(56695);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56695);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.vAF = aVar3.BTU.vd();
                    AppMethodBeat.o(56695);
                    return 0;
                case 2:
                    yVar.nZa = aVar3.BTU.readString();
                    AppMethodBeat.o(56695);
                    return 0;
                case 3:
                    yVar.nZb = aVar3.BTU.readString();
                    AppMethodBeat.o(56695);
                    return 0;
                case 4:
                    yVar.nZc = aVar3.BTU.readString();
                    AppMethodBeat.o(56695);
                    return 0;
                case 5:
                    yVar.nZd = aVar3.BTU.readString();
                    AppMethodBeat.o(56695);
                    return 0;
                default:
                    AppMethodBeat.o(56695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56695);
            return -1;
        }
    }
}
