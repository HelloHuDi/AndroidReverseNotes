package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class chv extends a {
    public String ctj;
    public boolean eif;
    public String hlm;
    public int offset;
    public int scene;
    public LinkedList<tn> tZG = new LinkedList();
    public String xgC;
    public String xgD;
    public String xgE;
    public String xgF;
    public long xgG;
    public chw xgH;
    public bzs xgI;
    public boolean xgJ;
    public LinkedList<chw> xgK = new LinkedList();
    public int xgL;
    public int xgM;
    public String xgN;
    public int xgO;
    public boolean xgP;
    public String xgj;

    public chv() {
        AppMethodBeat.i(55708);
        AppMethodBeat.o(55708);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55709);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgC != null) {
                aVar.e(1, this.xgC);
            }
            if (this.xgD != null) {
                aVar.e(2, this.xgD);
            }
            if (this.xgE != null) {
                aVar.e(3, this.xgE);
            }
            if (this.xgF != null) {
                aVar.e(4, this.xgF);
            }
            aVar.ai(5, this.xgG);
            aVar.iz(6, this.scene);
            if (this.hlm != null) {
                aVar.e(7, this.hlm);
            }
            if (this.ctj != null) {
                aVar.e(8, this.ctj);
            }
            if (this.xgH != null) {
                aVar.iy(9, this.xgH.computeSize());
                this.xgH.writeFields(aVar);
            }
            if (this.xgI != null) {
                aVar.iy(10, this.xgI.computeSize());
                this.xgI.writeFields(aVar);
            }
            aVar.e(11, 8, this.tZG);
            if (this.xgj != null) {
                aVar.e(12, this.xgj);
            }
            aVar.iz(13, this.offset);
            aVar.aO(14, this.xgJ);
            aVar.e(15, 8, this.xgK);
            aVar.iz(16, this.xgL);
            aVar.iz(17, this.xgM);
            aVar.aO(18, this.eif);
            if (this.xgN != null) {
                aVar.e(19, this.xgN);
            }
            aVar.iz(20, this.xgO);
            aVar.aO(21, this.xgP);
            AppMethodBeat.o(55709);
            return 0;
        } else if (i == 1) {
            if (this.xgC != null) {
                f = e.a.a.b.b.a.f(1, this.xgC) + 0;
            } else {
                f = 0;
            }
            if (this.xgD != null) {
                f += e.a.a.b.b.a.f(2, this.xgD);
            }
            if (this.xgE != null) {
                f += e.a.a.b.b.a.f(3, this.xgE);
            }
            if (this.xgF != null) {
                f += e.a.a.b.b.a.f(4, this.xgF);
            }
            f = (f + e.a.a.b.b.a.o(5, this.xgG)) + e.a.a.b.b.a.bs(6, this.scene);
            if (this.hlm != null) {
                f += e.a.a.b.b.a.f(7, this.hlm);
            }
            if (this.ctj != null) {
                f += e.a.a.b.b.a.f(8, this.ctj);
            }
            if (this.xgH != null) {
                f += e.a.a.a.ix(9, this.xgH.computeSize());
            }
            if (this.xgI != null) {
                f += e.a.a.a.ix(10, this.xgI.computeSize());
            }
            f += e.a.a.a.c(11, 8, this.tZG);
            if (this.xgj != null) {
                f += e.a.a.b.b.a.f(12, this.xgj);
            }
            f = (((((f + e.a.a.b.b.a.bs(13, this.offset)) + (e.a.a.b.b.a.fv(14) + 1)) + e.a.a.a.c(15, 8, this.xgK)) + e.a.a.b.b.a.bs(16, this.xgL)) + e.a.a.b.b.a.bs(17, this.xgM)) + (e.a.a.b.b.a.fv(18) + 1);
            if (this.xgN != null) {
                f += e.a.a.b.b.a.f(19, this.xgN);
            }
            int bs = (f + e.a.a.b.b.a.bs(20, this.xgO)) + (e.a.a.b.b.a.fv(21) + 1);
            AppMethodBeat.o(55709);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tZG.clear();
            this.xgK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55709);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chv chv = (chv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            chw chw;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    chv.xgC = aVar3.BTU.readString();
                    AppMethodBeat.o(55709);
                    return 0;
                case 2:
                    chv.xgD = aVar3.BTU.readString();
                    AppMethodBeat.o(55709);
                    return 0;
                case 3:
                    chv.xgE = aVar3.BTU.readString();
                    AppMethodBeat.o(55709);
                    return 0;
                case 4:
                    chv.xgF = aVar3.BTU.readString();
                    AppMethodBeat.o(55709);
                    return 0;
                case 5:
                    chv.xgG = aVar3.BTU.ve();
                    AppMethodBeat.o(55709);
                    return 0;
                case 6:
                    chv.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(55709);
                    return 0;
                case 7:
                    chv.hlm = aVar3.BTU.readString();
                    AppMethodBeat.o(55709);
                    return 0;
                case 8:
                    chv.ctj = aVar3.BTU.readString();
                    AppMethodBeat.o(55709);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chw = new chw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chw.populateBuilderWithField(aVar4, chw, a.getNextFieldNumber(aVar4))) {
                        }
                        chv.xgH = chw;
                    }
                    AppMethodBeat.o(55709);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzs bzs = new bzs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzs.populateBuilderWithField(aVar4, bzs, a.getNextFieldNumber(aVar4))) {
                        }
                        chv.xgI = bzs;
                    }
                    AppMethodBeat.o(55709);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tn tnVar = new tn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tnVar.populateBuilderWithField(aVar4, tnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        chv.tZG.add(tnVar);
                    }
                    AppMethodBeat.o(55709);
                    return 0;
                case 12:
                    chv.xgj = aVar3.BTU.readString();
                    AppMethodBeat.o(55709);
                    return 0;
                case 13:
                    chv.offset = aVar3.BTU.vd();
                    AppMethodBeat.o(55709);
                    return 0;
                case 14:
                    chv.xgJ = aVar3.BTU.ehX();
                    AppMethodBeat.o(55709);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chw = new chw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chw.populateBuilderWithField(aVar4, chw, a.getNextFieldNumber(aVar4))) {
                        }
                        chv.xgK.add(chw);
                    }
                    AppMethodBeat.o(55709);
                    return 0;
                case 16:
                    chv.xgL = aVar3.BTU.vd();
                    AppMethodBeat.o(55709);
                    return 0;
                case 17:
                    chv.xgM = aVar3.BTU.vd();
                    AppMethodBeat.o(55709);
                    return 0;
                case 18:
                    chv.eif = aVar3.BTU.ehX();
                    AppMethodBeat.o(55709);
                    return 0;
                case 19:
                    chv.xgN = aVar3.BTU.readString();
                    AppMethodBeat.o(55709);
                    return 0;
                case 20:
                    chv.xgO = aVar3.BTU.vd();
                    AppMethodBeat.o(55709);
                    return 0;
                case 21:
                    chv.xgP = aVar3.BTU.ehX();
                    AppMethodBeat.o(55709);
                    return 0;
                default:
                    AppMethodBeat.o(55709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55709);
            return -1;
        }
    }
}
