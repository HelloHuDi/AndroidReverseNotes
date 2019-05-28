package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cpu extends a {
    public String gDC;
    public String userName;
    public int xnK;
    public int xnL;
    public int xnM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5258);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xnK);
            aVar.iz(2, this.xnL);
            aVar.iz(3, this.xnM);
            if (this.userName != null) {
                aVar.e(4, this.userName);
            }
            if (this.gDC != null) {
                aVar.e(5, this.gDC);
            }
            AppMethodBeat.o(5258);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.xnK) + 0) + e.a.a.b.b.a.bs(2, this.xnL)) + e.a.a.b.b.a.bs(3, this.xnM);
            if (this.userName != null) {
                bs += e.a.a.b.b.a.f(4, this.userName);
            }
            if (this.gDC != null) {
                bs += e.a.a.b.b.a.f(5, this.gDC);
            }
            AppMethodBeat.o(5258);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5258);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpu cpu = (cpu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cpu.xnK = aVar3.BTU.vd();
                    AppMethodBeat.o(5258);
                    return 0;
                case 2:
                    cpu.xnL = aVar3.BTU.vd();
                    AppMethodBeat.o(5258);
                    return 0;
                case 3:
                    cpu.xnM = aVar3.BTU.vd();
                    AppMethodBeat.o(5258);
                    return 0;
                case 4:
                    cpu.userName = aVar3.BTU.readString();
                    AppMethodBeat.o(5258);
                    return 0;
                case 5:
                    cpu.gDC = aVar3.BTU.readString();
                    AppMethodBeat.o(5258);
                    return 0;
                default:
                    AppMethodBeat.o(5258);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5258);
            return -1;
        }
    }
}
