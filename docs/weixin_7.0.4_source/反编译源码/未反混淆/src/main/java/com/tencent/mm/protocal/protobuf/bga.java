package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bga extends a {
    public String bfz;
    public String cFW;
    public String kfO;
    public String wJW;
    public String wJX;
    public int wJY;
    public String wJZ;
    public String wKa;
    public String wKb;
    public int wKc;
    public int wKd;
    public int wKe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80126);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.bfz != null) {
                aVar.e(1, this.bfz);
            }
            if (this.wJW != null) {
                aVar.e(2, this.wJW);
            }
            if (this.wJX != null) {
                aVar.e(3, this.wJX);
            }
            aVar.iz(4, this.wJY);
            if (this.cFW != null) {
                aVar.e(5, this.cFW);
            }
            if (this.wJZ != null) {
                aVar.e(6, this.wJZ);
            }
            if (this.wKa != null) {
                aVar.e(7, this.wKa);
            }
            if (this.kfO != null) {
                aVar.e(8, this.kfO);
            }
            if (this.wKb != null) {
                aVar.e(9, this.wKb);
            }
            aVar.iz(10, this.wKc);
            aVar.iz(11, this.wKd);
            aVar.iz(12, this.wKe);
            AppMethodBeat.o(80126);
            return 0;
        } else if (i == 1) {
            if (this.bfz != null) {
                f = e.a.a.b.b.a.f(1, this.bfz) + 0;
            } else {
                f = 0;
            }
            if (this.wJW != null) {
                f += e.a.a.b.b.a.f(2, this.wJW);
            }
            if (this.wJX != null) {
                f += e.a.a.b.b.a.f(3, this.wJX);
            }
            f += e.a.a.b.b.a.bs(4, this.wJY);
            if (this.cFW != null) {
                f += e.a.a.b.b.a.f(5, this.cFW);
            }
            if (this.wJZ != null) {
                f += e.a.a.b.b.a.f(6, this.wJZ);
            }
            if (this.wKa != null) {
                f += e.a.a.b.b.a.f(7, this.wKa);
            }
            if (this.kfO != null) {
                f += e.a.a.b.b.a.f(8, this.kfO);
            }
            if (this.wKb != null) {
                f += e.a.a.b.b.a.f(9, this.wKb);
            }
            int bs = ((f + e.a.a.b.b.a.bs(10, this.wKc)) + e.a.a.b.b.a.bs(11, this.wKd)) + e.a.a.b.b.a.bs(12, this.wKe);
            AppMethodBeat.o(80126);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80126);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bga bga = (bga) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bga.bfz = aVar3.BTU.readString();
                    AppMethodBeat.o(80126);
                    return 0;
                case 2:
                    bga.wJW = aVar3.BTU.readString();
                    AppMethodBeat.o(80126);
                    return 0;
                case 3:
                    bga.wJX = aVar3.BTU.readString();
                    AppMethodBeat.o(80126);
                    return 0;
                case 4:
                    bga.wJY = aVar3.BTU.vd();
                    AppMethodBeat.o(80126);
                    return 0;
                case 5:
                    bga.cFW = aVar3.BTU.readString();
                    AppMethodBeat.o(80126);
                    return 0;
                case 6:
                    bga.wJZ = aVar3.BTU.readString();
                    AppMethodBeat.o(80126);
                    return 0;
                case 7:
                    bga.wKa = aVar3.BTU.readString();
                    AppMethodBeat.o(80126);
                    return 0;
                case 8:
                    bga.kfO = aVar3.BTU.readString();
                    AppMethodBeat.o(80126);
                    return 0;
                case 9:
                    bga.wKb = aVar3.BTU.readString();
                    AppMethodBeat.o(80126);
                    return 0;
                case 10:
                    bga.wKc = aVar3.BTU.vd();
                    AppMethodBeat.o(80126);
                    return 0;
                case 11:
                    bga.wKd = aVar3.BTU.vd();
                    AppMethodBeat.o(80126);
                    return 0;
                case 12:
                    bga.wKe = aVar3.BTU.vd();
                    AppMethodBeat.o(80126);
                    return 0;
                default:
                    AppMethodBeat.o(80126);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80126);
            return -1;
        }
    }
}
