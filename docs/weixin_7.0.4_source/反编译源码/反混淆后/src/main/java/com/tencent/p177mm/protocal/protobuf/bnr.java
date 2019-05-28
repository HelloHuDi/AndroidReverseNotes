package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bnr */
public final class bnr extends btd {
    public int cRh;
    public int kdT;
    public String kdU;
    public String tgu;
    public int wJb;
    public String wPv;
    public String wPx;
    public C44191xg wQA;
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
    public LinkedList<C44191xg> wQv = new LinkedList();
    public int wQw;
    public LinkedList<C44191xg> wQx = new LinkedList();
    public C44191xg wQy;
    public LinkedList<C44191xg> wQz = new LinkedList();
    public int wao;

    public bnr() {
        AppMethodBeat.m2504i(56941);
        AppMethodBeat.m2505o(56941);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56942);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56942);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdT);
            if (this.kdU != null) {
                c6093a.mo13475e(3, this.kdU);
            }
            c6093a.mo13480iz(4, this.wJb);
            if (this.wQr != null) {
                c6093a.mo13475e(5, this.wQr);
            }
            if (this.wQs != null) {
                c6093a.mo13475e(6, this.wQs);
            }
            if (this.wQt != null) {
                c6093a.mo13475e(7, this.wQt);
            }
            c6093a.mo13480iz(8, this.wQu);
            c6093a.mo13474e(9, 8, this.wQv);
            c6093a.mo13480iz(10, this.cRh);
            c6093a.mo13480iz(11, this.wQw);
            c6093a.mo13474e(12, 8, this.wQx);
            if (this.wPv != null) {
                c6093a.mo13475e(13, this.wPv);
            }
            if (this.wQy != null) {
                c6093a.mo13479iy(14, this.wQy.computeSize());
                this.wQy.writeFields(c6093a);
            }
            c6093a.mo13474e(15, 8, this.wQz);
            if (this.wQA != null) {
                c6093a.mo13479iy(16, this.wQA.computeSize());
                this.wQA.writeFields(c6093a);
            }
            if (this.wQB != null) {
                c6093a.mo13479iy(17, this.wQB.computeSize());
                this.wQB.writeFields(c6093a);
            }
            if (this.wQC != null) {
                c6093a.mo13475e(18, this.wQC);
            }
            c6093a.mo13480iz(19, this.wQD);
            if (this.wQE != null) {
                c6093a.mo13475e(20, this.wQE);
            }
            if (this.wQp != null) {
                c6093a.mo13475e(21, this.wQp);
            }
            c6093a.mo13480iz(22, this.wQF);
            c6093a.mo13471aO(23, this.wQG);
            c6093a.mo13480iz(24, this.wao);
            if (this.wPx != null) {
                c6093a.mo13475e(25, this.wPx);
            }
            if (this.wQH != null) {
                c6093a.mo13475e(26, this.wQH);
            }
            if (this.wQI != null) {
                c6093a.mo13475e(27, this.wQI);
            }
            c6093a.mo13474e(28, 8, this.wQJ);
            if (this.wQK != null) {
                c6093a.mo13475e(29, this.wQK);
            }
            if (this.wQL != null) {
                c6093a.mo13475e(30, this.wQL);
            }
            if (this.wQM != null) {
                c6093a.mo13475e(31, this.wQM);
            }
            if (this.wQN != null) {
                c6093a.mo13475e(32, this.wQN);
            }
            if (this.wQO != null) {
                c6093a.mo13479iy(33, this.wQO.computeSize());
                this.wQO.writeFields(c6093a);
            }
            if (this.wQP != null) {
                c6093a.mo13479iy(34, this.wQP.computeSize());
                this.wQP.writeFields(c6093a);
            }
            if (this.wQQ != null) {
                c6093a.mo13479iy(35, this.wQQ.computeSize());
                this.wQQ.writeFields(c6093a);
            }
            if (this.wQR != null) {
                c6093a.mo13475e(36, this.wQR);
            }
            if (this.wQS != null) {
                c6093a.mo13475e(37, this.wQS);
            }
            if (this.wQT != null) {
                c6093a.mo13479iy(38, this.wQT.computeSize());
                this.wQT.writeFields(c6093a);
            }
            if (this.tgu != null) {
                c6093a.mo13475e(100, this.tgu);
            }
            AppMethodBeat.m2505o(56942);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kdT);
            if (this.kdU != null) {
                ix += C6091a.m9575f(3, this.kdU);
            }
            ix += C6091a.m9572bs(4, this.wJb);
            if (this.wQr != null) {
                ix += C6091a.m9575f(5, this.wQr);
            }
            if (this.wQs != null) {
                ix += C6091a.m9575f(6, this.wQs);
            }
            if (this.wQt != null) {
                ix += C6091a.m9575f(7, this.wQt);
            }
            ix = ((((ix + C6091a.m9572bs(8, this.wQu)) + C6087a.m9552c(9, 8, this.wQv)) + C6091a.m9572bs(10, this.cRh)) + C6091a.m9572bs(11, this.wQw)) + C6087a.m9552c(12, 8, this.wQx);
            if (this.wPv != null) {
                ix += C6091a.m9575f(13, this.wPv);
            }
            if (this.wQy != null) {
                ix += C6087a.m9557ix(14, this.wQy.computeSize());
            }
            ix += C6087a.m9552c(15, 8, this.wQz);
            if (this.wQA != null) {
                ix += C6087a.m9557ix(16, this.wQA.computeSize());
            }
            if (this.wQB != null) {
                ix += C6087a.m9557ix(17, this.wQB.computeSize());
            }
            if (this.wQC != null) {
                ix += C6091a.m9575f(18, this.wQC);
            }
            ix += C6091a.m9572bs(19, this.wQD);
            if (this.wQE != null) {
                ix += C6091a.m9575f(20, this.wQE);
            }
            if (this.wQp != null) {
                ix += C6091a.m9575f(21, this.wQp);
            }
            ix = ((ix + C6091a.m9572bs(22, this.wQF)) + (C6091a.m9576fv(23) + 1)) + C6091a.m9572bs(24, this.wao);
            if (this.wPx != null) {
                ix += C6091a.m9575f(25, this.wPx);
            }
            if (this.wQH != null) {
                ix += C6091a.m9575f(26, this.wQH);
            }
            if (this.wQI != null) {
                ix += C6091a.m9575f(27, this.wQI);
            }
            ix += C6087a.m9552c(28, 8, this.wQJ);
            if (this.wQK != null) {
                ix += C6091a.m9575f(29, this.wQK);
            }
            if (this.wQL != null) {
                ix += C6091a.m9575f(30, this.wQL);
            }
            if (this.wQM != null) {
                ix += C6091a.m9575f(31, this.wQM);
            }
            if (this.wQN != null) {
                ix += C6091a.m9575f(32, this.wQN);
            }
            if (this.wQO != null) {
                ix += C6087a.m9557ix(33, this.wQO.computeSize());
            }
            if (this.wQP != null) {
                ix += C6087a.m9557ix(34, this.wQP.computeSize());
            }
            if (this.wQQ != null) {
                ix += C6087a.m9557ix(35, this.wQQ.computeSize());
            }
            if (this.wQR != null) {
                ix += C6091a.m9575f(36, this.wQR);
            }
            if (this.wQS != null) {
                ix += C6091a.m9575f(37, this.wQS);
            }
            if (this.wQT != null) {
                ix += C6087a.m9557ix(38, this.wQT.computeSize());
            }
            if (this.tgu != null) {
                ix += C6091a.m9575f(100, this.tgu);
            }
            AppMethodBeat.m2505o(56942);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wQv.clear();
            this.wQx.clear();
            this.wQz.clear();
            this.wQJ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56942);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56942);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bnr bnr = (bnr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            C44191xg c44191xg;
            bdy bdy;
            axi axi;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 2:
                    bnr.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 3:
                    bnr.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 4:
                    bnr.wJb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 5:
                    bnr.wQr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 6:
                    bnr.wQs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 7:
                    bnr.wQt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 8:
                    bnr.wQu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44191xg = new C44191xg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44191xg.populateBuilderWithField(c6086a3, c44191xg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQv.add(c44191xg);
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 10:
                    bnr.cRh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 11:
                    bnr.wQw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44191xg = new C44191xg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44191xg.populateBuilderWithField(c6086a3, c44191xg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQx.add(c44191xg);
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 13:
                    bnr.wPv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44191xg = new C44191xg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44191xg.populateBuilderWithField(c6086a3, c44191xg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQy = c44191xg;
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44191xg = new C44191xg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44191xg.populateBuilderWithField(c6086a3, c44191xg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQz.add(c44191xg);
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44191xg = new C44191xg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44191xg.populateBuilderWithField(c6086a3, c44191xg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQA = c44191xg;
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbh bbh = new bbh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbh.populateBuilderWithField(c6086a3, bbh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQB = bbh;
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 18:
                    bnr.wQC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 19:
                    bnr.wQD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 20:
                    bnr.wQE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 21:
                    bnr.wQp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 22:
                    bnr.wQF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 23:
                    bnr.wQG = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 24:
                    bnr.wao = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 25:
                    bnr.wPx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 26:
                    bnr.wQH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 27:
                    bnr.wQI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdy = new bdy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdy.populateBuilderWithField(c6086a3, bdy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQJ.add(bdy);
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 29:
                    bnr.wQK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 30:
                    bnr.wQL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 31:
                    bnr.wQM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 32:
                    bnr.wQN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 33:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdy = new bdy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdy.populateBuilderWithField(c6086a3, bdy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQO = bdy;
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 34:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axi = new axi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axi.populateBuilderWithField(c6086a3, axi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQP = axi;
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 35:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axi = new axi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axi.populateBuilderWithField(c6086a3, axi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQQ = axi;
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 36:
                    bnr.wQR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    bnr.wQS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 38:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acd acd = new acd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = acd.populateBuilderWithField(c6086a3, acd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnr.wQT = acd;
                    }
                    AppMethodBeat.m2505o(56942);
                    return 0;
                case 100:
                    bnr.tgu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56942);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56942);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56942);
            return -1;
        }
    }
}
