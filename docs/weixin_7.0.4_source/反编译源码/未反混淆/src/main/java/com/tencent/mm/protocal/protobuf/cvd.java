package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cvd extends a {
    public int Scene;
    public int jCt;
    public int vOq;
    public String vQg;
    public int wCv = 2;
    public String wCy;
    public int wDH;
    public axy wDI;
    public String wIF;
    public String wSi;
    public int wUr;
    public String wkD;
    public int xfr;
    public LinkedList<String> xgp = new LinkedList();
    public LinkedList<tn> xqa = new LinkedList();
    public int xrc;
    public String xrd;
    public int xre;
    public int xrf;

    public cvd() {
        AppMethodBeat.i(124379);
        AppMethodBeat.o(124379);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124380);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vOq);
            aVar.iz(2, this.wDH);
            aVar.iz(3, this.wUr);
            if (this.wkD != null) {
                aVar.e(4, this.wkD);
            }
            if (this.wDI != null) {
                aVar.iy(5, this.wDI.computeSize());
                this.wDI.writeFields(aVar);
            }
            aVar.iz(6, this.Scene);
            if (this.vQg != null) {
                aVar.e(7, this.vQg);
            }
            aVar.iz(8, this.xrc);
            aVar.iz(9, this.wCv);
            aVar.e(10, 8, this.xqa);
            if (this.wCy != null) {
                aVar.e(11, this.wCy);
            }
            if (this.wIF != null) {
                aVar.e(12, this.wIF);
            }
            aVar.iz(13, this.xfr);
            if (this.xrd != null) {
                aVar.e(14, this.xrd);
            }
            if (this.wSi != null) {
                aVar.e(15, this.wSi);
            }
            aVar.e(16, 1, this.xgp);
            aVar.iz(17, this.xre);
            aVar.iz(18, this.jCt);
            aVar.iz(19, this.xrf);
            AppMethodBeat.o(124380);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.vOq) + 0) + e.a.a.b.b.a.bs(2, this.wDH)) + e.a.a.b.b.a.bs(3, this.wUr);
            if (this.wkD != null) {
                bs += e.a.a.b.b.a.f(4, this.wkD);
            }
            if (this.wDI != null) {
                bs += e.a.a.a.ix(5, this.wDI.computeSize());
            }
            bs += e.a.a.b.b.a.bs(6, this.Scene);
            if (this.vQg != null) {
                bs += e.a.a.b.b.a.f(7, this.vQg);
            }
            bs = ((bs + e.a.a.b.b.a.bs(8, this.xrc)) + e.a.a.b.b.a.bs(9, this.wCv)) + e.a.a.a.c(10, 8, this.xqa);
            if (this.wCy != null) {
                bs += e.a.a.b.b.a.f(11, this.wCy);
            }
            if (this.wIF != null) {
                bs += e.a.a.b.b.a.f(12, this.wIF);
            }
            bs += e.a.a.b.b.a.bs(13, this.xfr);
            if (this.xrd != null) {
                bs += e.a.a.b.b.a.f(14, this.xrd);
            }
            if (this.wSi != null) {
                bs += e.a.a.b.b.a.f(15, this.wSi);
            }
            bs = (((bs + e.a.a.a.c(16, 1, this.xgp)) + e.a.a.b.b.a.bs(17, this.xre)) + e.a.a.b.b.a.bs(18, this.jCt)) + e.a.a.b.b.a.bs(19, this.xrf);
            AppMethodBeat.o(124380);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xqa.clear();
            this.xgp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124380);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvd cvd = (cvd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cvd.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 2:
                    cvd.wDH = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 3:
                    cvd.wUr = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 4:
                    cvd.wkD = aVar3.BTU.readString();
                    AppMethodBeat.o(124380);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axy.populateBuilderWithField(aVar4, axy, a.getNextFieldNumber(aVar4))) {
                        }
                        cvd.wDI = axy;
                    }
                    AppMethodBeat.o(124380);
                    return 0;
                case 6:
                    cvd.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 7:
                    cvd.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(124380);
                    return 0;
                case 8:
                    cvd.xrc = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 9:
                    cvd.wCv = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tn tnVar = new tn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tnVar.populateBuilderWithField(aVar4, tnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cvd.xqa.add(tnVar);
                    }
                    AppMethodBeat.o(124380);
                    return 0;
                case 11:
                    cvd.wCy = aVar3.BTU.readString();
                    AppMethodBeat.o(124380);
                    return 0;
                case 12:
                    cvd.wIF = aVar3.BTU.readString();
                    AppMethodBeat.o(124380);
                    return 0;
                case 13:
                    cvd.xfr = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 14:
                    cvd.xrd = aVar3.BTU.readString();
                    AppMethodBeat.o(124380);
                    return 0;
                case 15:
                    cvd.wSi = aVar3.BTU.readString();
                    AppMethodBeat.o(124380);
                    return 0;
                case 16:
                    cvd.xgp.add(aVar3.BTU.readString());
                    AppMethodBeat.o(124380);
                    return 0;
                case 17:
                    cvd.xre = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 18:
                    cvd.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                case 19:
                    cvd.xrf = aVar3.BTU.vd();
                    AppMethodBeat.o(124380);
                    return 0;
                default:
                    AppMethodBeat.o(124380);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124380);
            return -1;
        }
    }
}
