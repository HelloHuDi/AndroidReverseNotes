package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bmu extends a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guS;
    public int guT;
    public int guU;
    public String guV;
    public String guW;
    public String guX;
    public String jBB;
    public String jCH;
    public String vXm;
    public String vXn;
    public ccl wBZ;
    public uy wCa;
    public int wPI;
    public String wPJ;
    public int wPK;
    public String wPL;
    public String wlF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73747);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wPI);
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            if (this.jCH != null) {
                aVar.e(3, this.jCH);
            }
            if (this.wPJ != null) {
                aVar.e(4, this.wPJ);
            }
            aVar.iz(5, this.wPK);
            if (this.wPL != null) {
                aVar.e(6, this.wPL);
            }
            aVar.iz(7, this.guN);
            if (this.guO != null) {
                aVar.e(8, this.guO);
            }
            if (this.guP != null) {
                aVar.e(9, this.guP);
            }
            if (this.guQ != null) {
                aVar.e(10, this.guQ);
            }
            aVar.iz(11, this.guR);
            if (this.guS != null) {
                aVar.e(12, this.guS);
            }
            aVar.iz(13, this.guT);
            aVar.iz(14, this.guU);
            if (this.guV != null) {
                aVar.e(15, this.guV);
            }
            if (this.wBZ != null) {
                aVar.iy(16, this.wBZ.computeSize());
                this.wBZ.writeFields(aVar);
            }
            if (this.guW != null) {
                aVar.e(17, this.guW);
            }
            if (this.guX != null) {
                aVar.e(18, this.guX);
            }
            if (this.wCa != null) {
                aVar.iy(19, this.wCa.computeSize());
                this.wCa.writeFields(aVar);
            }
            if (this.vXm != null) {
                aVar.e(20, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(21, this.vXn);
            }
            if (this.wlF != null) {
                aVar.e(22, this.wlF);
            }
            AppMethodBeat.o(73747);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wPI) + 0;
            if (this.jBB != null) {
                bs += e.a.a.b.b.a.f(2, this.jBB);
            }
            if (this.jCH != null) {
                bs += e.a.a.b.b.a.f(3, this.jCH);
            }
            if (this.wPJ != null) {
                bs += e.a.a.b.b.a.f(4, this.wPJ);
            }
            bs += e.a.a.b.b.a.bs(5, this.wPK);
            if (this.wPL != null) {
                bs += e.a.a.b.b.a.f(6, this.wPL);
            }
            bs += e.a.a.b.b.a.bs(7, this.guN);
            if (this.guO != null) {
                bs += e.a.a.b.b.a.f(8, this.guO);
            }
            if (this.guP != null) {
                bs += e.a.a.b.b.a.f(9, this.guP);
            }
            if (this.guQ != null) {
                bs += e.a.a.b.b.a.f(10, this.guQ);
            }
            bs += e.a.a.b.b.a.bs(11, this.guR);
            if (this.guS != null) {
                bs += e.a.a.b.b.a.f(12, this.guS);
            }
            bs = (bs + e.a.a.b.b.a.bs(13, this.guT)) + e.a.a.b.b.a.bs(14, this.guU);
            if (this.guV != null) {
                bs += e.a.a.b.b.a.f(15, this.guV);
            }
            if (this.wBZ != null) {
                bs += e.a.a.a.ix(16, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                bs += e.a.a.b.b.a.f(17, this.guW);
            }
            if (this.guX != null) {
                bs += e.a.a.b.b.a.f(18, this.guX);
            }
            if (this.wCa != null) {
                bs += e.a.a.a.ix(19, this.wCa.computeSize());
            }
            if (this.vXm != null) {
                bs += e.a.a.b.b.a.f(20, this.vXm);
            }
            if (this.vXn != null) {
                bs += e.a.a.b.b.a.f(21, this.vXn);
            }
            if (this.wlF != null) {
                bs += e.a.a.b.b.a.f(22, this.wlF);
            }
            AppMethodBeat.o(73747);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73747);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmu bmu = (bmu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bmu.wPI = aVar3.BTU.vd();
                    AppMethodBeat.o(73747);
                    return 0;
                case 2:
                    bmu.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 3:
                    bmu.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 4:
                    bmu.wPJ = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 5:
                    bmu.wPK = aVar3.BTU.vd();
                    AppMethodBeat.o(73747);
                    return 0;
                case 6:
                    bmu.wPL = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 7:
                    bmu.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(73747);
                    return 0;
                case 8:
                    bmu.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 9:
                    bmu.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 10:
                    bmu.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 11:
                    bmu.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(73747);
                    return 0;
                case 12:
                    bmu.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 13:
                    bmu.guT = aVar3.BTU.vd();
                    AppMethodBeat.o(73747);
                    return 0;
                case 14:
                    bmu.guU = aVar3.BTU.vd();
                    AppMethodBeat.o(73747);
                    return 0;
                case 15:
                    bmu.guV = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, a.getNextFieldNumber(aVar4))) {
                        }
                        bmu.wBZ = ccl;
                    }
                    AppMethodBeat.o(73747);
                    return 0;
                case 17:
                    bmu.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 18:
                    bmu.guX = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uy uyVar = new uy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uyVar.populateBuilderWithField(aVar4, uyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bmu.wCa = uyVar;
                    }
                    AppMethodBeat.o(73747);
                    return 0;
                case 20:
                    bmu.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 21:
                    bmu.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                case 22:
                    bmu.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(73747);
                    return 0;
                default:
                    AppMethodBeat.o(73747);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73747);
            return -1;
        }
    }
}
