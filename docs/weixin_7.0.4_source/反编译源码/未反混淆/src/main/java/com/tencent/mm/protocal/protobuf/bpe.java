package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bpe extends a {
    public String mZr;
    public int mZx;
    public String nad;
    public String ncH;
    public String vDk;
    public String vDl;
    public String vDm;
    public String vDn;
    public String vDo;
    public String vDp;
    public cyf vDq;
    public String vME;
    public int wHF;
    public LinkedList<bts> wRA = new LinkedList();
    public String wRB;
    public String wRC;
    public String wRD;
    public String wRE;
    public String wRF;
    public String wRG;
    public String wRH;
    public int wRI;
    public String wRx;
    public String wRy;
    public int wRz;

    public bpe() {
        AppMethodBeat.i(80158);
        AppMethodBeat.o(80158);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80159);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZr != null) {
                aVar.e(1, this.mZr);
            }
            if (this.ncH != null) {
                aVar.e(2, this.ncH);
            }
            if (this.vDm != null) {
                aVar.e(3, this.vDm);
            }
            if (this.wRx != null) {
                aVar.e(4, this.wRx);
            }
            if (this.vDl != null) {
                aVar.e(5, this.vDl);
            }
            if (this.vDk != null) {
                aVar.e(6, this.vDk);
            }
            if (this.wRy != null) {
                aVar.e(7, this.wRy);
            }
            aVar.iz(8, this.wRz);
            aVar.e(9, 8, this.wRA);
            if (this.vDn != null) {
                aVar.e(10, this.vDn);
            }
            if (this.wRB != null) {
                aVar.e(11, this.wRB);
            }
            if (this.wRC != null) {
                aVar.e(12, this.wRC);
            }
            aVar.iz(13, this.wHF);
            if (this.vME != null) {
                aVar.e(14, this.vME);
            }
            if (this.nad != null) {
                aVar.e(15, this.nad);
            }
            if (this.vDo != null) {
                aVar.e(16, this.vDo);
            }
            if (this.wRD != null) {
                aVar.e(17, this.wRD);
            }
            if (this.wRE != null) {
                aVar.e(18, this.wRE);
            }
            if (this.vDp != null) {
                aVar.e(19, this.vDp);
            }
            if (this.wRF != null) {
                aVar.e(20, this.wRF);
            }
            if (this.wRG != null) {
                aVar.e(21, this.wRG);
            }
            if (this.vDq != null) {
                aVar.iy(22, this.vDq.computeSize());
                this.vDq.writeFields(aVar);
            }
            if (this.wRH != null) {
                aVar.e(23, this.wRH);
            }
            aVar.iz(24, this.wRI);
            aVar.iz(25, this.mZx);
            AppMethodBeat.o(80159);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = e.a.a.b.b.a.f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(2, this.ncH);
            }
            if (this.vDm != null) {
                f += e.a.a.b.b.a.f(3, this.vDm);
            }
            if (this.wRx != null) {
                f += e.a.a.b.b.a.f(4, this.wRx);
            }
            if (this.vDl != null) {
                f += e.a.a.b.b.a.f(5, this.vDl);
            }
            if (this.vDk != null) {
                f += e.a.a.b.b.a.f(6, this.vDk);
            }
            if (this.wRy != null) {
                f += e.a.a.b.b.a.f(7, this.wRy);
            }
            f = (f + e.a.a.b.b.a.bs(8, this.wRz)) + e.a.a.a.c(9, 8, this.wRA);
            if (this.vDn != null) {
                f += e.a.a.b.b.a.f(10, this.vDn);
            }
            if (this.wRB != null) {
                f += e.a.a.b.b.a.f(11, this.wRB);
            }
            if (this.wRC != null) {
                f += e.a.a.b.b.a.f(12, this.wRC);
            }
            f += e.a.a.b.b.a.bs(13, this.wHF);
            if (this.vME != null) {
                f += e.a.a.b.b.a.f(14, this.vME);
            }
            if (this.nad != null) {
                f += e.a.a.b.b.a.f(15, this.nad);
            }
            if (this.vDo != null) {
                f += e.a.a.b.b.a.f(16, this.vDo);
            }
            if (this.wRD != null) {
                f += e.a.a.b.b.a.f(17, this.wRD);
            }
            if (this.wRE != null) {
                f += e.a.a.b.b.a.f(18, this.wRE);
            }
            if (this.vDp != null) {
                f += e.a.a.b.b.a.f(19, this.vDp);
            }
            if (this.wRF != null) {
                f += e.a.a.b.b.a.f(20, this.wRF);
            }
            if (this.wRG != null) {
                f += e.a.a.b.b.a.f(21, this.wRG);
            }
            if (this.vDq != null) {
                f += e.a.a.a.ix(22, this.vDq.computeSize());
            }
            if (this.wRH != null) {
                f += e.a.a.b.b.a.f(23, this.wRH);
            }
            int bs = (f + e.a.a.b.b.a.bs(24, this.wRI)) + e.a.a.b.b.a.bs(25, this.mZx);
            AppMethodBeat.o(80159);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wRA.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80159);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpe bpe = (bpe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bpe.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 2:
                    bpe.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 3:
                    bpe.vDm = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 4:
                    bpe.wRx = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 5:
                    bpe.vDl = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 6:
                    bpe.vDk = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 7:
                    bpe.wRy = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 8:
                    bpe.wRz = aVar3.BTU.vd();
                    AppMethodBeat.o(80159);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bpe.wRA.add(bts);
                    }
                    AppMethodBeat.o(80159);
                    return 0;
                case 10:
                    bpe.vDn = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 11:
                    bpe.wRB = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 12:
                    bpe.wRC = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 13:
                    bpe.wHF = aVar3.BTU.vd();
                    AppMethodBeat.o(80159);
                    return 0;
                case 14:
                    bpe.vME = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 15:
                    bpe.nad = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 16:
                    bpe.vDo = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 17:
                    bpe.wRD = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 18:
                    bpe.wRE = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 19:
                    bpe.vDp = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 20:
                    bpe.wRF = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 21:
                    bpe.wRG = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyf cyf = new cyf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyf.populateBuilderWithField(aVar4, cyf, a.getNextFieldNumber(aVar4))) {
                        }
                        bpe.vDq = cyf;
                    }
                    AppMethodBeat.o(80159);
                    return 0;
                case 23:
                    bpe.wRH = aVar3.BTU.readString();
                    AppMethodBeat.o(80159);
                    return 0;
                case 24:
                    bpe.wRI = aVar3.BTU.vd();
                    AppMethodBeat.o(80159);
                    return 0;
                case 25:
                    bpe.mZx = aVar3.BTU.vd();
                    AppMethodBeat.o(80159);
                    return 0;
                default:
                    AppMethodBeat.o(80159);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80159);
            return -1;
        }
    }
}
