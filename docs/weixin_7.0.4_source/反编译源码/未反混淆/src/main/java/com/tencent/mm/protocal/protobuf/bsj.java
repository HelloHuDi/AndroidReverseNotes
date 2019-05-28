package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bsj extends a {
    public int Scene;
    public long vQd;
    public int vZW;
    public String wDM;
    public long wOP;
    public String wUn;
    public String wUo;
    public int wUp;
    public int wUq;
    public int wUr;
    public String wUs;
    public String wUt;
    public String wUu;
    public int wyk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124342);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Scene);
            if (this.wDM != null) {
                aVar.e(2, this.wDM);
            }
            if (this.wUn != null) {
                aVar.e(3, this.wUn);
            }
            aVar.ai(4, this.vQd);
            if (this.wUo != null) {
                aVar.e(5, this.wUo);
            }
            aVar.iz(6, this.wUp);
            aVar.iz(7, this.wUq);
            aVar.iz(8, this.wUr);
            aVar.ai(9, this.wOP);
            aVar.iz(10, this.wyk);
            if (this.wUs != null) {
                aVar.e(11, this.wUs);
            }
            aVar.iz(12, this.vZW);
            if (this.wUt != null) {
                aVar.e(13, this.wUt);
            }
            if (this.wUu != null) {
                aVar.e(14, this.wUu);
            }
            AppMethodBeat.o(124342);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Scene) + 0;
            if (this.wDM != null) {
                bs += e.a.a.b.b.a.f(2, this.wDM);
            }
            if (this.wUn != null) {
                bs += e.a.a.b.b.a.f(3, this.wUn);
            }
            bs += e.a.a.b.b.a.o(4, this.vQd);
            if (this.wUo != null) {
                bs += e.a.a.b.b.a.f(5, this.wUo);
            }
            bs = ((((bs + e.a.a.b.b.a.bs(6, this.wUp)) + e.a.a.b.b.a.bs(7, this.wUq)) + e.a.a.b.b.a.bs(8, this.wUr)) + e.a.a.b.b.a.o(9, this.wOP)) + e.a.a.b.b.a.bs(10, this.wyk);
            if (this.wUs != null) {
                bs += e.a.a.b.b.a.f(11, this.wUs);
            }
            bs += e.a.a.b.b.a.bs(12, this.vZW);
            if (this.wUt != null) {
                bs += e.a.a.b.b.a.f(13, this.wUt);
            }
            if (this.wUu != null) {
                bs += e.a.a.b.b.a.f(14, this.wUu);
            }
            AppMethodBeat.o(124342);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124342);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsj bsj = (bsj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsj.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124342);
                    return 0;
                case 2:
                    bsj.wDM = aVar3.BTU.readString();
                    AppMethodBeat.o(124342);
                    return 0;
                case 3:
                    bsj.wUn = aVar3.BTU.readString();
                    AppMethodBeat.o(124342);
                    return 0;
                case 4:
                    bsj.vQd = aVar3.BTU.ve();
                    AppMethodBeat.o(124342);
                    return 0;
                case 5:
                    bsj.wUo = aVar3.BTU.readString();
                    AppMethodBeat.o(124342);
                    return 0;
                case 6:
                    bsj.wUp = aVar3.BTU.vd();
                    AppMethodBeat.o(124342);
                    return 0;
                case 7:
                    bsj.wUq = aVar3.BTU.vd();
                    AppMethodBeat.o(124342);
                    return 0;
                case 8:
                    bsj.wUr = aVar3.BTU.vd();
                    AppMethodBeat.o(124342);
                    return 0;
                case 9:
                    bsj.wOP = aVar3.BTU.ve();
                    AppMethodBeat.o(124342);
                    return 0;
                case 10:
                    bsj.wyk = aVar3.BTU.vd();
                    AppMethodBeat.o(124342);
                    return 0;
                case 11:
                    bsj.wUs = aVar3.BTU.readString();
                    AppMethodBeat.o(124342);
                    return 0;
                case 12:
                    bsj.vZW = aVar3.BTU.vd();
                    AppMethodBeat.o(124342);
                    return 0;
                case 13:
                    bsj.wUt = aVar3.BTU.readString();
                    AppMethodBeat.o(124342);
                    return 0;
                case 14:
                    bsj.wUu = aVar3.BTU.readString();
                    AppMethodBeat.o(124342);
                    return 0;
                default:
                    AppMethodBeat.o(124342);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124342);
            return -1;
        }
    }
}
