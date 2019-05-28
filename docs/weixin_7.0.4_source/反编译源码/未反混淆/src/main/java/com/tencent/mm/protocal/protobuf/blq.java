package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class blq extends a {
    public String Name;
    public String PriceType;
    public int Scene;
    public String ThumbUrl;
    public int jBv;
    public int jCt;
    public int wOD;
    public LinkedList<axa> wOE = new LinkedList();
    public int wOF;
    public String wOG;
    public String wOH;
    public int wOI;
    public String wOJ;
    public int wOK;
    public LinkedList<xd> wOL = new LinkedList();
    public String wrm;

    public blq() {
        AppMethodBeat.i(56933);
        AppMethodBeat.o(56933);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56934);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wOD);
            aVar.e(2, 8, this.wOE);
            aVar.iz(3, this.jBv);
            aVar.iz(4, this.wOF);
            if (this.PriceType != null) {
                aVar.e(5, this.PriceType);
            }
            if (this.wrm != null) {
                aVar.e(6, this.wrm);
            }
            if (this.wOG != null) {
                aVar.e(7, this.wOG);
            }
            if (this.wOH != null) {
                aVar.e(8, this.wOH);
            }
            aVar.iz(9, this.jCt);
            if (this.Name != null) {
                aVar.e(10, this.Name);
            }
            if (this.ThumbUrl != null) {
                aVar.e(11, this.ThumbUrl);
            }
            aVar.iz(12, this.wOI);
            aVar.iz(13, this.Scene);
            if (this.wOJ != null) {
                aVar.e(14, this.wOJ);
            }
            aVar.iz(15, this.wOK);
            aVar.e(16, 8, this.wOL);
            AppMethodBeat.o(56934);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wOD) + 0) + e.a.a.a.c(2, 8, this.wOE)) + e.a.a.b.b.a.bs(3, this.jBv)) + e.a.a.b.b.a.bs(4, this.wOF);
            if (this.PriceType != null) {
                bs += e.a.a.b.b.a.f(5, this.PriceType);
            }
            if (this.wrm != null) {
                bs += e.a.a.b.b.a.f(6, this.wrm);
            }
            if (this.wOG != null) {
                bs += e.a.a.b.b.a.f(7, this.wOG);
            }
            if (this.wOH != null) {
                bs += e.a.a.b.b.a.f(8, this.wOH);
            }
            bs += e.a.a.b.b.a.bs(9, this.jCt);
            if (this.Name != null) {
                bs += e.a.a.b.b.a.f(10, this.Name);
            }
            if (this.ThumbUrl != null) {
                bs += e.a.a.b.b.a.f(11, this.ThumbUrl);
            }
            bs = (bs + e.a.a.b.b.a.bs(12, this.wOI)) + e.a.a.b.b.a.bs(13, this.Scene);
            if (this.wOJ != null) {
                bs += e.a.a.b.b.a.f(14, this.wOJ);
            }
            bs = (bs + e.a.a.b.b.a.bs(15, this.wOK)) + e.a.a.a.c(16, 8, this.wOL);
            AppMethodBeat.o(56934);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wOE.clear();
            this.wOL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56934);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blq blq = (blq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    blq.wOD = aVar3.BTU.vd();
                    AppMethodBeat.o(56934);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axa axa = new axa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axa.populateBuilderWithField(aVar4, axa, a.getNextFieldNumber(aVar4))) {
                        }
                        blq.wOE.add(axa);
                    }
                    AppMethodBeat.o(56934);
                    return 0;
                case 3:
                    blq.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(56934);
                    return 0;
                case 4:
                    blq.wOF = aVar3.BTU.vd();
                    AppMethodBeat.o(56934);
                    return 0;
                case 5:
                    blq.PriceType = aVar3.BTU.readString();
                    AppMethodBeat.o(56934);
                    return 0;
                case 6:
                    blq.wrm = aVar3.BTU.readString();
                    AppMethodBeat.o(56934);
                    return 0;
                case 7:
                    blq.wOG = aVar3.BTU.readString();
                    AppMethodBeat.o(56934);
                    return 0;
                case 8:
                    blq.wOH = aVar3.BTU.readString();
                    AppMethodBeat.o(56934);
                    return 0;
                case 9:
                    blq.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(56934);
                    return 0;
                case 10:
                    blq.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(56934);
                    return 0;
                case 11:
                    blq.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(56934);
                    return 0;
                case 12:
                    blq.wOI = aVar3.BTU.vd();
                    AppMethodBeat.o(56934);
                    return 0;
                case 13:
                    blq.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(56934);
                    return 0;
                case 14:
                    blq.wOJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56934);
                    return 0;
                case 15:
                    blq.wOK = aVar3.BTU.vd();
                    AppMethodBeat.o(56934);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xd xdVar = new xd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xdVar.populateBuilderWithField(aVar4, xdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        blq.wOL.add(xdVar);
                    }
                    AppMethodBeat.o(56934);
                    return 0;
                default:
                    AppMethodBeat.o(56934);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56934);
            return -1;
        }
    }
}
