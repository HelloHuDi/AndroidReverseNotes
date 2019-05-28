package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bnr extends btd {
    public int cRh;
    public int kdT;
    public String kdU;
    public String tgu;
    public int wJb;
    public String wPv;
    public String wPx;
    public xg wQA;
    public bbh wQB;
    public String wQC;
    public int wQD;
    public String wQE;
    public int wQF;
    public boolean wQG;
    public String wQH;
    public String wQI;
    public LinkedList<bdy> wQJ = new LinkedList();
    public String wQK;
    public String wQL;
    public String wQM;
    public String wQN;
    public bdy wQO;
    public axi wQP;
    public axi wQQ;
    public String wQR;
    public String wQS;
    public acd wQT;
    public String wQp;
    public String wQr;
    public String wQs;
    public String wQt;
    public int wQu;
    public LinkedList<xg> wQv = new LinkedList();
    public int wQw;
    public LinkedList<xg> wQx = new LinkedList();
    public xg wQy;
    public LinkedList<xg> wQz = new LinkedList();
    public int wao;

    public bnr() {
        AppMethodBeat.i(56941);
        AppMethodBeat.o(56941);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56942);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56942);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            aVar.iz(4, this.wJb);
            if (this.wQr != null) {
                aVar.e(5, this.wQr);
            }
            if (this.wQs != null) {
                aVar.e(6, this.wQs);
            }
            if (this.wQt != null) {
                aVar.e(7, this.wQt);
            }
            aVar.iz(8, this.wQu);
            aVar.e(9, 8, this.wQv);
            aVar.iz(10, this.cRh);
            aVar.iz(11, this.wQw);
            aVar.e(12, 8, this.wQx);
            if (this.wPv != null) {
                aVar.e(13, this.wPv);
            }
            if (this.wQy != null) {
                aVar.iy(14, this.wQy.computeSize());
                this.wQy.writeFields(aVar);
            }
            aVar.e(15, 8, this.wQz);
            if (this.wQA != null) {
                aVar.iy(16, this.wQA.computeSize());
                this.wQA.writeFields(aVar);
            }
            if (this.wQB != null) {
                aVar.iy(17, this.wQB.computeSize());
                this.wQB.writeFields(aVar);
            }
            if (this.wQC != null) {
                aVar.e(18, this.wQC);
            }
            aVar.iz(19, this.wQD);
            if (this.wQE != null) {
                aVar.e(20, this.wQE);
            }
            if (this.wQp != null) {
                aVar.e(21, this.wQp);
            }
            aVar.iz(22, this.wQF);
            aVar.aO(23, this.wQG);
            aVar.iz(24, this.wao);
            if (this.wPx != null) {
                aVar.e(25, this.wPx);
            }
            if (this.wQH != null) {
                aVar.e(26, this.wQH);
            }
            if (this.wQI != null) {
                aVar.e(27, this.wQI);
            }
            aVar.e(28, 8, this.wQJ);
            if (this.wQK != null) {
                aVar.e(29, this.wQK);
            }
            if (this.wQL != null) {
                aVar.e(30, this.wQL);
            }
            if (this.wQM != null) {
                aVar.e(31, this.wQM);
            }
            if (this.wQN != null) {
                aVar.e(32, this.wQN);
            }
            if (this.wQO != null) {
                aVar.iy(33, this.wQO.computeSize());
                this.wQO.writeFields(aVar);
            }
            if (this.wQP != null) {
                aVar.iy(34, this.wQP.computeSize());
                this.wQP.writeFields(aVar);
            }
            if (this.wQQ != null) {
                aVar.iy(35, this.wQQ.computeSize());
                this.wQQ.writeFields(aVar);
            }
            if (this.wQR != null) {
                aVar.e(36, this.wQR);
            }
            if (this.wQS != null) {
                aVar.e(37, this.wQS);
            }
            if (this.wQT != null) {
                aVar.iy(38, this.wQT.computeSize());
                this.wQT.writeFields(aVar);
            }
            if (this.tgu != null) {
                aVar.e(100, this.tgu);
            }
            AppMethodBeat.o(56942);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            ix += e.a.a.b.b.a.bs(4, this.wJb);
            if (this.wQr != null) {
                ix += e.a.a.b.b.a.f(5, this.wQr);
            }
            if (this.wQs != null) {
                ix += e.a.a.b.b.a.f(6, this.wQs);
            }
            if (this.wQt != null) {
                ix += e.a.a.b.b.a.f(7, this.wQt);
            }
            ix = ((((ix + e.a.a.b.b.a.bs(8, this.wQu)) + e.a.a.a.c(9, 8, this.wQv)) + e.a.a.b.b.a.bs(10, this.cRh)) + e.a.a.b.b.a.bs(11, this.wQw)) + e.a.a.a.c(12, 8, this.wQx);
            if (this.wPv != null) {
                ix += e.a.a.b.b.a.f(13, this.wPv);
            }
            if (this.wQy != null) {
                ix += e.a.a.a.ix(14, this.wQy.computeSize());
            }
            ix += e.a.a.a.c(15, 8, this.wQz);
            if (this.wQA != null) {
                ix += e.a.a.a.ix(16, this.wQA.computeSize());
            }
            if (this.wQB != null) {
                ix += e.a.a.a.ix(17, this.wQB.computeSize());
            }
            if (this.wQC != null) {
                ix += e.a.a.b.b.a.f(18, this.wQC);
            }
            ix += e.a.a.b.b.a.bs(19, this.wQD);
            if (this.wQE != null) {
                ix += e.a.a.b.b.a.f(20, this.wQE);
            }
            if (this.wQp != null) {
                ix += e.a.a.b.b.a.f(21, this.wQp);
            }
            ix = ((ix + e.a.a.b.b.a.bs(22, this.wQF)) + (e.a.a.b.b.a.fv(23) + 1)) + e.a.a.b.b.a.bs(24, this.wao);
            if (this.wPx != null) {
                ix += e.a.a.b.b.a.f(25, this.wPx);
            }
            if (this.wQH != null) {
                ix += e.a.a.b.b.a.f(26, this.wQH);
            }
            if (this.wQI != null) {
                ix += e.a.a.b.b.a.f(27, this.wQI);
            }
            ix += e.a.a.a.c(28, 8, this.wQJ);
            if (this.wQK != null) {
                ix += e.a.a.b.b.a.f(29, this.wQK);
            }
            if (this.wQL != null) {
                ix += e.a.a.b.b.a.f(30, this.wQL);
            }
            if (this.wQM != null) {
                ix += e.a.a.b.b.a.f(31, this.wQM);
            }
            if (this.wQN != null) {
                ix += e.a.a.b.b.a.f(32, this.wQN);
            }
            if (this.wQO != null) {
                ix += e.a.a.a.ix(33, this.wQO.computeSize());
            }
            if (this.wQP != null) {
                ix += e.a.a.a.ix(34, this.wQP.computeSize());
            }
            if (this.wQQ != null) {
                ix += e.a.a.a.ix(35, this.wQQ.computeSize());
            }
            if (this.wQR != null) {
                ix += e.a.a.b.b.a.f(36, this.wQR);
            }
            if (this.wQS != null) {
                ix += e.a.a.b.b.a.f(37, this.wQS);
            }
            if (this.wQT != null) {
                ix += e.a.a.a.ix(38, this.wQT.computeSize());
            }
            if (this.tgu != null) {
                ix += e.a.a.b.b.a.f(100, this.tgu);
            }
            AppMethodBeat.o(56942);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wQv.clear();
            this.wQx.clear();
            this.wQz.clear();
            this.wQJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56942);
                throw bVar;
            }
            AppMethodBeat.o(56942);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnr bnr = (bnr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            xg xgVar;
            bdy bdy;
            axi axi;
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
                        bnr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 2:
                    bnr.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56942);
                    return 0;
                case 3:
                    bnr.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 4:
                    bnr.wJb = aVar3.BTU.vd();
                    AppMethodBeat.o(56942);
                    return 0;
                case 5:
                    bnr.wQr = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 6:
                    bnr.wQs = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 7:
                    bnr.wQt = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 8:
                    bnr.wQu = aVar3.BTU.vd();
                    AppMethodBeat.o(56942);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xgVar = new xg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xgVar.populateBuilderWithField(aVar4, xgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQv.add(xgVar);
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 10:
                    bnr.cRh = aVar3.BTU.vd();
                    AppMethodBeat.o(56942);
                    return 0;
                case 11:
                    bnr.wQw = aVar3.BTU.vd();
                    AppMethodBeat.o(56942);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xgVar = new xg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xgVar.populateBuilderWithField(aVar4, xgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQx.add(xgVar);
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 13:
                    bnr.wPv = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xgVar = new xg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xgVar.populateBuilderWithField(aVar4, xgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQy = xgVar;
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xgVar = new xg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xgVar.populateBuilderWithField(aVar4, xgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQz.add(xgVar);
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xgVar = new xg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xgVar.populateBuilderWithField(aVar4, xgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQA = xgVar;
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbh bbh = new bbh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbh.populateBuilderWithField(aVar4, bbh, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQB = bbh;
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 18:
                    bnr.wQC = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 19:
                    bnr.wQD = aVar3.BTU.vd();
                    AppMethodBeat.o(56942);
                    return 0;
                case 20:
                    bnr.wQE = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 21:
                    bnr.wQp = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 22:
                    bnr.wQF = aVar3.BTU.vd();
                    AppMethodBeat.o(56942);
                    return 0;
                case 23:
                    bnr.wQG = aVar3.BTU.ehX();
                    AppMethodBeat.o(56942);
                    return 0;
                case 24:
                    bnr.wao = aVar3.BTU.vd();
                    AppMethodBeat.o(56942);
                    return 0;
                case 25:
                    bnr.wPx = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 26:
                    bnr.wQH = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 27:
                    bnr.wQI = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdy = new bdy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdy.populateBuilderWithField(aVar4, bdy, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQJ.add(bdy);
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 29:
                    bnr.wQK = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 30:
                    bnr.wQL = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 31:
                    bnr.wQM = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 32:
                    bnr.wQN = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 33:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdy = new bdy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdy.populateBuilderWithField(aVar4, bdy, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQO = bdy;
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 34:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axi = new axi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axi.populateBuilderWithField(aVar4, axi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQP = axi;
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 35:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axi = new axi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axi.populateBuilderWithField(aVar4, axi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQQ = axi;
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 36:
                    bnr.wQR = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    bnr.wQS = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                case 38:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acd acd = new acd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = acd.populateBuilderWithField(aVar4, acd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnr.wQT = acd;
                    }
                    AppMethodBeat.o(56942);
                    return 0;
                case 100:
                    bnr.tgu = aVar3.BTU.readString();
                    AppMethodBeat.o(56942);
                    return 0;
                default:
                    AppMethodBeat.o(56942);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56942);
            return -1;
        }
    }
}
