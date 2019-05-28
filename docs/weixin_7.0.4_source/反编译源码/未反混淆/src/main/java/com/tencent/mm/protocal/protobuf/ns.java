package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ns extends a {
    public String vSR;
    public String vSS;
    public String vST;
    public String vSU;
    public LinkedList<nr> vSV = new LinkedList();
    public int vSW;
    public String vSX;
    public ny vSY;
    public String vSZ;
    public LinkedList<nq> vTa = new LinkedList();
    public String vTb;
    public String vTc;
    public ny vTd;
    public nr vTe;
    public int vTf;
    public int vTg;
    public int vTh;
    public long vTi;

    public ns() {
        AppMethodBeat.i(89025);
        AppMethodBeat.o(89025);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89026);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSR != null) {
                aVar.e(1, this.vSR);
            }
            if (this.vSS != null) {
                aVar.e(2, this.vSS);
            }
            if (this.vST != null) {
                aVar.e(3, this.vST);
            }
            if (this.vSU != null) {
                aVar.e(4, this.vSU);
            }
            aVar.e(5, 8, this.vSV);
            aVar.iz(6, this.vSW);
            if (this.vSX != null) {
                aVar.e(7, this.vSX);
            }
            if (this.vSY != null) {
                aVar.iy(8, this.vSY.computeSize());
                this.vSY.writeFields(aVar);
            }
            if (this.vSZ != null) {
                aVar.e(9, this.vSZ);
            }
            aVar.e(10, 8, this.vTa);
            if (this.vTb != null) {
                aVar.e(11, this.vTb);
            }
            if (this.vTc != null) {
                aVar.e(12, this.vTc);
            }
            if (this.vTd != null) {
                aVar.iy(13, this.vTd.computeSize());
                this.vTd.writeFields(aVar);
            }
            if (this.vTe != null) {
                aVar.iy(14, this.vTe.computeSize());
                this.vTe.writeFields(aVar);
            }
            aVar.iz(15, this.vTf);
            aVar.iz(16, this.vTg);
            aVar.iz(17, this.vTh);
            aVar.ai(18, this.vTi);
            AppMethodBeat.o(89026);
            return 0;
        } else if (i == 1) {
            if (this.vSR != null) {
                f = e.a.a.b.b.a.f(1, this.vSR) + 0;
            } else {
                f = 0;
            }
            if (this.vSS != null) {
                f += e.a.a.b.b.a.f(2, this.vSS);
            }
            if (this.vST != null) {
                f += e.a.a.b.b.a.f(3, this.vST);
            }
            if (this.vSU != null) {
                f += e.a.a.b.b.a.f(4, this.vSU);
            }
            f = (f + e.a.a.a.c(5, 8, this.vSV)) + e.a.a.b.b.a.bs(6, this.vSW);
            if (this.vSX != null) {
                f += e.a.a.b.b.a.f(7, this.vSX);
            }
            if (this.vSY != null) {
                f += e.a.a.a.ix(8, this.vSY.computeSize());
            }
            if (this.vSZ != null) {
                f += e.a.a.b.b.a.f(9, this.vSZ);
            }
            f += e.a.a.a.c(10, 8, this.vTa);
            if (this.vTb != null) {
                f += e.a.a.b.b.a.f(11, this.vTb);
            }
            if (this.vTc != null) {
                f += e.a.a.b.b.a.f(12, this.vTc);
            }
            if (this.vTd != null) {
                f += e.a.a.a.ix(13, this.vTd.computeSize());
            }
            if (this.vTe != null) {
                f += e.a.a.a.ix(14, this.vTe.computeSize());
            }
            int bs = (((f + e.a.a.b.b.a.bs(15, this.vTf)) + e.a.a.b.b.a.bs(16, this.vTg)) + e.a.a.b.b.a.bs(17, this.vTh)) + e.a.a.b.b.a.o(18, this.vTi);
            AppMethodBeat.o(89026);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vSV.clear();
            this.vTa.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89026);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ns nsVar = (ns) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            nr nrVar;
            e.a.a.a.a aVar4;
            boolean z;
            ny nyVar;
            switch (intValue) {
                case 1:
                    nsVar.vSR = aVar3.BTU.readString();
                    AppMethodBeat.o(89026);
                    return 0;
                case 2:
                    nsVar.vSS = aVar3.BTU.readString();
                    AppMethodBeat.o(89026);
                    return 0;
                case 3:
                    nsVar.vST = aVar3.BTU.readString();
                    AppMethodBeat.o(89026);
                    return 0;
                case 4:
                    nsVar.vSU = aVar3.BTU.readString();
                    AppMethodBeat.o(89026);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nrVar = new nr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.populateBuilderWithField(aVar4, nrVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nsVar.vSV.add(nrVar);
                    }
                    AppMethodBeat.o(89026);
                    return 0;
                case 6:
                    nsVar.vSW = aVar3.BTU.vd();
                    AppMethodBeat.o(89026);
                    return 0;
                case 7:
                    nsVar.vSX = aVar3.BTU.readString();
                    AppMethodBeat.o(89026);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nyVar = new ny();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nsVar.vSY = nyVar;
                    }
                    AppMethodBeat.o(89026);
                    return 0;
                case 9:
                    nsVar.vSZ = aVar3.BTU.readString();
                    AppMethodBeat.o(89026);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nq nqVar = new nq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nqVar.populateBuilderWithField(aVar4, nqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nsVar.vTa.add(nqVar);
                    }
                    AppMethodBeat.o(89026);
                    return 0;
                case 11:
                    nsVar.vTb = aVar3.BTU.readString();
                    AppMethodBeat.o(89026);
                    return 0;
                case 12:
                    nsVar.vTc = aVar3.BTU.readString();
                    AppMethodBeat.o(89026);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nyVar = new ny();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nsVar.vTd = nyVar;
                    }
                    AppMethodBeat.o(89026);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nrVar = new nr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nrVar.populateBuilderWithField(aVar4, nrVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nsVar.vTe = nrVar;
                    }
                    AppMethodBeat.o(89026);
                    return 0;
                case 15:
                    nsVar.vTf = aVar3.BTU.vd();
                    AppMethodBeat.o(89026);
                    return 0;
                case 16:
                    nsVar.vTg = aVar3.BTU.vd();
                    AppMethodBeat.o(89026);
                    return 0;
                case 17:
                    nsVar.vTh = aVar3.BTU.vd();
                    AppMethodBeat.o(89026);
                    return 0;
                case 18:
                    nsVar.vTi = aVar3.BTU.ve();
                    AppMethodBeat.o(89026);
                    return 0;
                default:
                    AppMethodBeat.o(89026);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89026);
            return -1;
        }
    }
}
