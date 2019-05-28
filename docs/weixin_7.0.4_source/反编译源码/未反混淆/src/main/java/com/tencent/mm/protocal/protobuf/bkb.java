package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bkb extends a {
    public String ncH;
    public String pcU;
    public String pcW;
    public int pcX;
    public String pcY;
    public int pcZ;
    public String pda;
    public int pdb;
    public int pdc;
    public String pde;
    public String pdf;
    public String pdg;
    public String pdh;
    public int wMU;
    public String wNg;
    public String wNh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56917);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pcU != null) {
                aVar.e(1, this.pcU);
            }
            aVar.iz(2, this.wMU);
            if (this.pcW != null) {
                aVar.e(3, this.pcW);
            }
            aVar.iz(4, this.pcX);
            if (this.pcY != null) {
                aVar.e(5, this.pcY);
            }
            aVar.iz(6, this.pcZ);
            if (this.pda != null) {
                aVar.e(7, this.pda);
            }
            aVar.iz(8, this.pdb);
            aVar.iz(9, this.pdc);
            if (this.ncH != null) {
                aVar.e(11, this.ncH);
            }
            if (this.pde != null) {
                aVar.e(12, this.pde);
            }
            if (this.pdf != null) {
                aVar.e(13, this.pdf);
            }
            if (this.pdg != null) {
                aVar.e(14, this.pdg);
            }
            if (this.pdh != null) {
                aVar.e(15, this.pdh);
            }
            if (this.wNg != null) {
                aVar.e(18, this.wNg);
            }
            if (this.wNh != null) {
                aVar.e(19, this.wNh);
            }
            AppMethodBeat.o(56917);
            return 0;
        } else if (i == 1) {
            if (this.pcU != null) {
                f = e.a.a.b.b.a.f(1, this.pcU) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wMU);
            if (this.pcW != null) {
                f += e.a.a.b.b.a.f(3, this.pcW);
            }
            f += e.a.a.b.b.a.bs(4, this.pcX);
            if (this.pcY != null) {
                f += e.a.a.b.b.a.f(5, this.pcY);
            }
            f += e.a.a.b.b.a.bs(6, this.pcZ);
            if (this.pda != null) {
                f += e.a.a.b.b.a.f(7, this.pda);
            }
            f = (f + e.a.a.b.b.a.bs(8, this.pdb)) + e.a.a.b.b.a.bs(9, this.pdc);
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(11, this.ncH);
            }
            if (this.pde != null) {
                f += e.a.a.b.b.a.f(12, this.pde);
            }
            if (this.pdf != null) {
                f += e.a.a.b.b.a.f(13, this.pdf);
            }
            if (this.pdg != null) {
                f += e.a.a.b.b.a.f(14, this.pdg);
            }
            if (this.pdh != null) {
                f += e.a.a.b.b.a.f(15, this.pdh);
            }
            if (this.wNg != null) {
                f += e.a.a.b.b.a.f(18, this.wNg);
            }
            if (this.wNh != null) {
                f += e.a.a.b.b.a.f(19, this.wNh);
            }
            AppMethodBeat.o(56917);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56917);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkb bkb = (bkb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkb.pcU = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 2:
                    bkb.wMU = aVar3.BTU.vd();
                    AppMethodBeat.o(56917);
                    return 0;
                case 3:
                    bkb.pcW = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 4:
                    bkb.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(56917);
                    return 0;
                case 5:
                    bkb.pcY = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 6:
                    bkb.pcZ = aVar3.BTU.vd();
                    AppMethodBeat.o(56917);
                    return 0;
                case 7:
                    bkb.pda = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 8:
                    bkb.pdb = aVar3.BTU.vd();
                    AppMethodBeat.o(56917);
                    return 0;
                case 9:
                    bkb.pdc = aVar3.BTU.vd();
                    AppMethodBeat.o(56917);
                    return 0;
                case 11:
                    bkb.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 12:
                    bkb.pde = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 13:
                    bkb.pdf = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 14:
                    bkb.pdg = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 15:
                    bkb.pdh = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 18:
                    bkb.wNg = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                case 19:
                    bkb.wNh = aVar3.BTU.readString();
                    AppMethodBeat.o(56917);
                    return 0;
                default:
                    AppMethodBeat.o(56917);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56917);
            return -1;
        }
    }
}
