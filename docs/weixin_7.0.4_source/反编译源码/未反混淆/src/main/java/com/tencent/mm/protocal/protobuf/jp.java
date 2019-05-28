package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class jp extends btd {
    public String cxb;
    public int vCl;
    public bzr vHR;
    public String vHS;
    public int vHW;
    public String vHl;
    public int vLC;
    public String vLD;
    public String vLH;
    public int vLI;
    public String vLJ;
    public ato vLK;
    public lm vLL;
    public bdu vLM;
    public String vLN;
    public int vLO;
    public btv vLP;
    public String vLQ;
    public String vLR;
    public String vLS;
    public String vLT;
    public int vLU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123507);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123507);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.cxb != null) {
                aVar.e(2, this.cxb);
            }
            if (this.vLH != null) {
                aVar.e(3, this.vLH);
            }
            aVar.iz(4, this.vLI);
            if (this.vLJ != null) {
                aVar.e(5, this.vLJ);
            }
            if (this.vHl != null) {
                aVar.e(6, this.vHl);
            }
            if (this.vLK != null) {
                aVar.iy(7, this.vLK.computeSize());
                this.vLK.writeFields(aVar);
            }
            if (this.vLL != null) {
                aVar.iy(8, this.vLL.computeSize());
                this.vLL.writeFields(aVar);
            }
            if (this.vLM != null) {
                aVar.iy(9, this.vLM.computeSize());
                this.vLM.writeFields(aVar);
            }
            if (this.vHS != null) {
                aVar.e(10, this.vHS);
            }
            aVar.iz(11, this.vCl);
            if (this.vLN != null) {
                aVar.e(12, this.vLN);
            }
            aVar.iz(13, this.vLO);
            if (this.vLP != null) {
                aVar.iy(14, this.vLP.computeSize());
                this.vLP.writeFields(aVar);
            }
            if (this.vLQ != null) {
                aVar.e(15, this.vLQ);
            }
            if (this.vLR != null) {
                aVar.e(16, this.vLR);
            }
            if (this.vHR != null) {
                aVar.iy(17, this.vHR.computeSize());
                this.vHR.writeFields(aVar);
            }
            aVar.iz(18, this.vHW);
            if (this.vLS != null) {
                aVar.e(19, this.vLS);
            }
            if (this.vLT != null) {
                aVar.e(20, this.vLT);
            }
            aVar.iz(21, this.vLC);
            if (this.vLD != null) {
                aVar.e(22, this.vLD);
            }
            aVar.iz(23, this.vLU);
            AppMethodBeat.o(123507);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.cxb != null) {
                ix += e.a.a.b.b.a.f(2, this.cxb);
            }
            if (this.vLH != null) {
                ix += e.a.a.b.b.a.f(3, this.vLH);
            }
            ix += e.a.a.b.b.a.bs(4, this.vLI);
            if (this.vLJ != null) {
                ix += e.a.a.b.b.a.f(5, this.vLJ);
            }
            if (this.vHl != null) {
                ix += e.a.a.b.b.a.f(6, this.vHl);
            }
            if (this.vLK != null) {
                ix += e.a.a.a.ix(7, this.vLK.computeSize());
            }
            if (this.vLL != null) {
                ix += e.a.a.a.ix(8, this.vLL.computeSize());
            }
            if (this.vLM != null) {
                ix += e.a.a.a.ix(9, this.vLM.computeSize());
            }
            if (this.vHS != null) {
                ix += e.a.a.b.b.a.f(10, this.vHS);
            }
            ix += e.a.a.b.b.a.bs(11, this.vCl);
            if (this.vLN != null) {
                ix += e.a.a.b.b.a.f(12, this.vLN);
            }
            ix += e.a.a.b.b.a.bs(13, this.vLO);
            if (this.vLP != null) {
                ix += e.a.a.a.ix(14, this.vLP.computeSize());
            }
            if (this.vLQ != null) {
                ix += e.a.a.b.b.a.f(15, this.vLQ);
            }
            if (this.vLR != null) {
                ix += e.a.a.b.b.a.f(16, this.vLR);
            }
            if (this.vHR != null) {
                ix += e.a.a.a.ix(17, this.vHR.computeSize());
            }
            ix += e.a.a.b.b.a.bs(18, this.vHW);
            if (this.vLS != null) {
                ix += e.a.a.b.b.a.f(19, this.vLS);
            }
            if (this.vLT != null) {
                ix += e.a.a.b.b.a.f(20, this.vLT);
            }
            ix += e.a.a.b.b.a.bs(21, this.vLC);
            if (this.vLD != null) {
                ix += e.a.a.b.b.a.f(22, this.vLD);
            }
            int bs = ix + e.a.a.b.b.a.bs(23, this.vLU);
            AppMethodBeat.o(123507);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123507);
                throw bVar;
            }
            AppMethodBeat.o(123507);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jp jpVar = (jp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
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
                        jpVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123507);
                    return 0;
                case 2:
                    jpVar.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 3:
                    jpVar.vLH = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 4:
                    jpVar.vLI = aVar3.BTU.vd();
                    AppMethodBeat.o(123507);
                    return 0;
                case 5:
                    jpVar.vLJ = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 6:
                    jpVar.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ato ato = new ato();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ato.populateBuilderWithField(aVar4, ato, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jpVar.vLK = ato;
                    }
                    AppMethodBeat.o(123507);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        lm lmVar = new lm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lmVar.populateBuilderWithField(aVar4, lmVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jpVar.vLL = lmVar;
                    }
                    AppMethodBeat.o(123507);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdu bdu = new bdu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdu.populateBuilderWithField(aVar4, bdu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jpVar.vLM = bdu;
                    }
                    AppMethodBeat.o(123507);
                    return 0;
                case 10:
                    jpVar.vHS = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 11:
                    jpVar.vCl = aVar3.BTU.vd();
                    AppMethodBeat.o(123507);
                    return 0;
                case 12:
                    jpVar.vLN = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 13:
                    jpVar.vLO = aVar3.BTU.vd();
                    AppMethodBeat.o(123507);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btv btv = new btv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btv.populateBuilderWithField(aVar4, btv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jpVar.vLP = btv;
                    }
                    AppMethodBeat.o(123507);
                    return 0;
                case 15:
                    jpVar.vLQ = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 16:
                    jpVar.vLR = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzr bzr = new bzr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzr.populateBuilderWithField(aVar4, bzr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jpVar.vHR = bzr;
                    }
                    AppMethodBeat.o(123507);
                    return 0;
                case 18:
                    jpVar.vHW = aVar3.BTU.vd();
                    AppMethodBeat.o(123507);
                    return 0;
                case 19:
                    jpVar.vLS = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 20:
                    jpVar.vLT = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 21:
                    jpVar.vLC = aVar3.BTU.vd();
                    AppMethodBeat.o(123507);
                    return 0;
                case 22:
                    jpVar.vLD = aVar3.BTU.readString();
                    AppMethodBeat.o(123507);
                    return 0;
                case 23:
                    jpVar.vLU = aVar3.BTU.vd();
                    AppMethodBeat.o(123507);
                    return 0;
                default:
                    AppMethodBeat.o(123507);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123507);
            return -1;
        }
    }
}
