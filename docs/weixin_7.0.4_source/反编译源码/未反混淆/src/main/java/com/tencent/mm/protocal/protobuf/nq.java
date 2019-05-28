package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class nq extends a {
    public String vCb;
    public String vSA;
    public String vSB;
    public String vSC;
    public LinkedList<np> vSD = new LinkedList();
    public int vSE;
    public String vSF;
    public String vSG;
    public String vSH;
    public int vSI;
    public String vSJ;
    public int vSK;
    public String vSy;
    public String vSz;

    public nq() {
        AppMethodBeat.i(89022);
        AppMethodBeat.o(89022);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89023);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCb != null) {
                aVar.e(1, this.vCb);
            }
            if (this.vSy != null) {
                aVar.e(2, this.vSy);
            }
            if (this.vSz != null) {
                aVar.e(3, this.vSz);
            }
            if (this.vSA != null) {
                aVar.e(4, this.vSA);
            }
            if (this.vSB != null) {
                aVar.e(5, this.vSB);
            }
            if (this.vSC != null) {
                aVar.e(6, this.vSC);
            }
            aVar.e(7, 8, this.vSD);
            aVar.iz(8, this.vSE);
            if (this.vSF != null) {
                aVar.e(9, this.vSF);
            }
            if (this.vSG != null) {
                aVar.e(10, this.vSG);
            }
            if (this.vSH != null) {
                aVar.e(11, this.vSH);
            }
            aVar.iz(12, this.vSI);
            if (this.vSJ != null) {
                aVar.e(13, this.vSJ);
            }
            aVar.iz(14, this.vSK);
            AppMethodBeat.o(89023);
            return 0;
        } else if (i == 1) {
            if (this.vCb != null) {
                f = e.a.a.b.b.a.f(1, this.vCb) + 0;
            } else {
                f = 0;
            }
            if (this.vSy != null) {
                f += e.a.a.b.b.a.f(2, this.vSy);
            }
            if (this.vSz != null) {
                f += e.a.a.b.b.a.f(3, this.vSz);
            }
            if (this.vSA != null) {
                f += e.a.a.b.b.a.f(4, this.vSA);
            }
            if (this.vSB != null) {
                f += e.a.a.b.b.a.f(5, this.vSB);
            }
            if (this.vSC != null) {
                f += e.a.a.b.b.a.f(6, this.vSC);
            }
            f = (f + e.a.a.a.c(7, 8, this.vSD)) + e.a.a.b.b.a.bs(8, this.vSE);
            if (this.vSF != null) {
                f += e.a.a.b.b.a.f(9, this.vSF);
            }
            if (this.vSG != null) {
                f += e.a.a.b.b.a.f(10, this.vSG);
            }
            if (this.vSH != null) {
                f += e.a.a.b.b.a.f(11, this.vSH);
            }
            f += e.a.a.b.b.a.bs(12, this.vSI);
            if (this.vSJ != null) {
                f += e.a.a.b.b.a.f(13, this.vSJ);
            }
            int bs = f + e.a.a.b.b.a.bs(14, this.vSK);
            AppMethodBeat.o(89023);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vSD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89023);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nq nqVar = (nq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nqVar.vCb = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 2:
                    nqVar.vSy = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 3:
                    nqVar.vSz = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 4:
                    nqVar.vSA = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 5:
                    nqVar.vSB = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 6:
                    nqVar.vSC = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        np npVar = new np();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = npVar.populateBuilderWithField(aVar4, npVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nqVar.vSD.add(npVar);
                    }
                    AppMethodBeat.o(89023);
                    return 0;
                case 8:
                    nqVar.vSE = aVar3.BTU.vd();
                    AppMethodBeat.o(89023);
                    return 0;
                case 9:
                    nqVar.vSF = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 10:
                    nqVar.vSG = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 11:
                    nqVar.vSH = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 12:
                    nqVar.vSI = aVar3.BTU.vd();
                    AppMethodBeat.o(89023);
                    return 0;
                case 13:
                    nqVar.vSJ = aVar3.BTU.readString();
                    AppMethodBeat.o(89023);
                    return 0;
                case 14:
                    nqVar.vSK = aVar3.BTU.vd();
                    AppMethodBeat.o(89023);
                    return 0;
                default:
                    AppMethodBeat.o(89023);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89023);
            return -1;
        }
    }
}
