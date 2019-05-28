package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bzo extends btd {
    public String cxb;
    public String fhH;
    public String title;
    public String wIL;
    public fz wXh;
    public int wYA;
    public fy wYB;
    public String wYC;
    public LinkedList<ga> wYD = new LinkedList();
    public String wYE;
    public String wYF;
    public gb wYG;
    public LinkedList<gb> wYH = new LinkedList();
    public cno wYI;
    public boolean wYJ;
    public String wYK;

    public bzo() {
        AppMethodBeat.i(96292);
        AppMethodBeat.o(96292);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96293);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96293);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wXh != null) {
                aVar.iy(2, this.wXh.computeSize());
                this.wXh.writeFields(aVar);
            }
            aVar.iz(3, this.wYA);
            if (this.wYB != null) {
                aVar.iy(4, this.wYB.computeSize());
                this.wYB.writeFields(aVar);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.wIL != null) {
                aVar.e(6, this.wIL);
            }
            if (this.fhH != null) {
                aVar.e(7, this.fhH);
            }
            if (this.wYC != null) {
                aVar.e(8, this.wYC);
            }
            aVar.e(9, 8, this.wYD);
            if (this.wYE != null) {
                aVar.e(10, this.wYE);
            }
            if (this.wYF != null) {
                aVar.e(11, this.wYF);
            }
            if (this.wYG != null) {
                aVar.iy(12, this.wYG.computeSize());
                this.wYG.writeFields(aVar);
            }
            aVar.e(13, 8, this.wYH);
            if (this.cxb != null) {
                aVar.e(14, this.cxb);
            }
            if (this.wYI != null) {
                aVar.iy(15, this.wYI.computeSize());
                this.wYI.writeFields(aVar);
            }
            aVar.aO(16, this.wYJ);
            if (this.wYK != null) {
                aVar.e(17, this.wYK);
            }
            AppMethodBeat.o(96293);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wXh != null) {
                ix += e.a.a.a.ix(2, this.wXh.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.wYA);
            if (this.wYB != null) {
                ix += e.a.a.a.ix(4, this.wYB.computeSize());
            }
            if (this.title != null) {
                ix += e.a.a.b.b.a.f(5, this.title);
            }
            if (this.wIL != null) {
                ix += e.a.a.b.b.a.f(6, this.wIL);
            }
            if (this.fhH != null) {
                ix += e.a.a.b.b.a.f(7, this.fhH);
            }
            if (this.wYC != null) {
                ix += e.a.a.b.b.a.f(8, this.wYC);
            }
            ix += e.a.a.a.c(9, 8, this.wYD);
            if (this.wYE != null) {
                ix += e.a.a.b.b.a.f(10, this.wYE);
            }
            if (this.wYF != null) {
                ix += e.a.a.b.b.a.f(11, this.wYF);
            }
            if (this.wYG != null) {
                ix += e.a.a.a.ix(12, this.wYG.computeSize());
            }
            ix += e.a.a.a.c(13, 8, this.wYH);
            if (this.cxb != null) {
                ix += e.a.a.b.b.a.f(14, this.cxb);
            }
            if (this.wYI != null) {
                ix += e.a.a.a.ix(15, this.wYI.computeSize());
            }
            ix += e.a.a.b.b.a.fv(16) + 1;
            if (this.wYK != null) {
                ix += e.a.a.b.b.a.f(17, this.wYK);
            }
            AppMethodBeat.o(96293);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wYD.clear();
            this.wYH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96293);
                throw bVar;
            }
            AppMethodBeat.o(96293);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzo bzo = (bzo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            gb gbVar;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bzo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96293);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fz fzVar = new fz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fzVar.populateBuilderWithField(aVar4, fzVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bzo.wXh = fzVar;
                    }
                    AppMethodBeat.o(96293);
                    return 0;
                case 3:
                    bzo.wYA = aVar3.BTU.vd();
                    AppMethodBeat.o(96293);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fy fyVar = new fy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fyVar.populateBuilderWithField(aVar4, fyVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bzo.wYB = fyVar;
                    }
                    AppMethodBeat.o(96293);
                    return 0;
                case 5:
                    bzo.title = aVar3.BTU.readString();
                    AppMethodBeat.o(96293);
                    return 0;
                case 6:
                    bzo.wIL = aVar3.BTU.readString();
                    AppMethodBeat.o(96293);
                    return 0;
                case 7:
                    bzo.fhH = aVar3.BTU.readString();
                    AppMethodBeat.o(96293);
                    return 0;
                case 8:
                    bzo.wYC = aVar3.BTU.readString();
                    AppMethodBeat.o(96293);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ga gaVar = new ga();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gaVar.populateBuilderWithField(aVar4, gaVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bzo.wYD.add(gaVar);
                    }
                    AppMethodBeat.o(96293);
                    return 0;
                case 10:
                    bzo.wYE = aVar3.BTU.readString();
                    AppMethodBeat.o(96293);
                    return 0;
                case 11:
                    bzo.wYF = aVar3.BTU.readString();
                    AppMethodBeat.o(96293);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        gbVar = new gb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gbVar.populateBuilderWithField(aVar4, gbVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bzo.wYG = gbVar;
                    }
                    AppMethodBeat.o(96293);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        gbVar = new gb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gbVar.populateBuilderWithField(aVar4, gbVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bzo.wYH.add(gbVar);
                    }
                    AppMethodBeat.o(96293);
                    return 0;
                case 14:
                    bzo.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(96293);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cno cno = new cno();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cno.populateBuilderWithField(aVar4, cno, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bzo.wYI = cno;
                    }
                    AppMethodBeat.o(96293);
                    return 0;
                case 16:
                    bzo.wYJ = aVar3.BTU.ehX();
                    AppMethodBeat.o(96293);
                    return 0;
                case 17:
                    bzo.wYK = aVar3.BTU.readString();
                    AppMethodBeat.o(96293);
                    return 0;
                default:
                    AppMethodBeat.o(96293);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96293);
            return -1;
        }
    }
}
