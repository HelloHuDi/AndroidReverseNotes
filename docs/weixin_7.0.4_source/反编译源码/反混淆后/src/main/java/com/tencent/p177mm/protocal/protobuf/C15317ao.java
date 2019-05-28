package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ao */
public final class C15317ao extends btd {
    public String color;
    public String content;
    public String kbU;
    public LinkedList<C7250ap> kcO = new LinkedList();
    public LinkedList<C35902aq> kcP = new LinkedList();
    public String kcQ;
    public int kcR;
    public String kcS;
    public String kcT;
    public String kcU;
    public String kcV;
    public String vBE;
    public String vBF;
    public String vBG;
    public String vBH;
    public String vBI;
    public String vBJ;
    public String vBK;
    public String vBL;
    public String vBM;
    public String vBN;
    public String vBO;
    public String vBP;
    public boolean vBQ = false;
    public int vBR;
    public int vBS;
    public int vBT;
    public String vBU;
    public String vBV;
    public int vBW;
    public String vBX;
    public String vBY;
    public String vBZ;
    public String vCa;
    public String vCb;
    public String vCc;
    public String vCd;
    public String vCe;

    public C15317ao() {
        AppMethodBeat.m2504i(88999);
        AppMethodBeat.m2505o(88999);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89000);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.vBE != null) {
                c6093a.mo13475e(2, this.vBE);
            }
            if (this.vBF != null) {
                c6093a.mo13475e(3, this.vBF);
            }
            if (this.vBG != null) {
                c6093a.mo13475e(4, this.vBG);
            }
            if (this.content != null) {
                c6093a.mo13475e(5, this.content);
            }
            if (this.vBH != null) {
                c6093a.mo13475e(6, this.vBH);
            }
            if (this.vBI != null) {
                c6093a.mo13475e(7, this.vBI);
            }
            if (this.vBJ != null) {
                c6093a.mo13475e(8, this.vBJ);
            }
            if (this.vBK != null) {
                c6093a.mo13475e(9, this.vBK);
            }
            if (this.vBL != null) {
                c6093a.mo13475e(10, this.vBL);
            }
            if (this.vBM != null) {
                c6093a.mo13475e(11, this.vBM);
            }
            if (this.vBN != null) {
                c6093a.mo13475e(12, this.vBN);
            }
            if (this.vBO != null) {
                c6093a.mo13475e(13, this.vBO);
            }
            if (this.kcU != null) {
                c6093a.mo13475e(14, this.kcU);
            }
            if (this.kcV != null) {
                c6093a.mo13475e(15, this.kcV);
            }
            if (this.vBP != null) {
                c6093a.mo13475e(16, this.vBP);
            }
            c6093a.mo13471aO(17, this.vBQ);
            c6093a.mo13480iz(18, this.vBR);
            c6093a.mo13480iz(19, this.vBS);
            c6093a.mo13480iz(20, this.vBT);
            if (this.color != null) {
                c6093a.mo13475e(21, this.color);
            }
            if (this.vBU != null) {
                c6093a.mo13475e(22, this.vBU);
            }
            if (this.vBV != null) {
                c6093a.mo13475e(23, this.vBV);
            }
            c6093a.mo13480iz(24, this.vBW);
            if (this.vBX != null) {
                c6093a.mo13475e(25, this.vBX);
            }
            if (this.vBY != null) {
                c6093a.mo13475e(26, this.vBY);
            }
            if (this.vBZ != null) {
                c6093a.mo13475e(27, this.vBZ);
            }
            if (this.vCa != null) {
                c6093a.mo13475e(28, this.vCa);
            }
            if (this.vCb != null) {
                c6093a.mo13475e(29, this.vCb);
            }
            if (this.vCc != null) {
                c6093a.mo13475e(30, this.vCc);
            }
            if (this.vCd != null) {
                c6093a.mo13475e(31, this.vCd);
            }
            if (this.kbU != null) {
                c6093a.mo13475e(32, this.kbU);
            }
            if (this.vCe != null) {
                c6093a.mo13475e(33, this.vCe);
            }
            c6093a.mo13474e(34, 8, this.kcO);
            c6093a.mo13474e(35, 8, this.kcP);
            if (this.kcQ != null) {
                c6093a.mo13475e(36, this.kcQ);
            }
            c6093a.mo13480iz(37, this.kcR);
            if (this.kcS != null) {
                c6093a.mo13475e(38, this.kcS);
            }
            if (this.kcT != null) {
                c6093a.mo13475e(39, this.kcT);
            }
            AppMethodBeat.m2505o(89000);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vBE != null) {
                ix += C6091a.m9575f(2, this.vBE);
            }
            if (this.vBF != null) {
                ix += C6091a.m9575f(3, this.vBF);
            }
            if (this.vBG != null) {
                ix += C6091a.m9575f(4, this.vBG);
            }
            if (this.content != null) {
                ix += C6091a.m9575f(5, this.content);
            }
            if (this.vBH != null) {
                ix += C6091a.m9575f(6, this.vBH);
            }
            if (this.vBI != null) {
                ix += C6091a.m9575f(7, this.vBI);
            }
            if (this.vBJ != null) {
                ix += C6091a.m9575f(8, this.vBJ);
            }
            if (this.vBK != null) {
                ix += C6091a.m9575f(9, this.vBK);
            }
            if (this.vBL != null) {
                ix += C6091a.m9575f(10, this.vBL);
            }
            if (this.vBM != null) {
                ix += C6091a.m9575f(11, this.vBM);
            }
            if (this.vBN != null) {
                ix += C6091a.m9575f(12, this.vBN);
            }
            if (this.vBO != null) {
                ix += C6091a.m9575f(13, this.vBO);
            }
            if (this.kcU != null) {
                ix += C6091a.m9575f(14, this.kcU);
            }
            if (this.kcV != null) {
                ix += C6091a.m9575f(15, this.kcV);
            }
            if (this.vBP != null) {
                ix += C6091a.m9575f(16, this.vBP);
            }
            ix = (((ix + (C6091a.m9576fv(17) + 1)) + C6091a.m9572bs(18, this.vBR)) + C6091a.m9572bs(19, this.vBS)) + C6091a.m9572bs(20, this.vBT);
            if (this.color != null) {
                ix += C6091a.m9575f(21, this.color);
            }
            if (this.vBU != null) {
                ix += C6091a.m9575f(22, this.vBU);
            }
            if (this.vBV != null) {
                ix += C6091a.m9575f(23, this.vBV);
            }
            ix += C6091a.m9572bs(24, this.vBW);
            if (this.vBX != null) {
                ix += C6091a.m9575f(25, this.vBX);
            }
            if (this.vBY != null) {
                ix += C6091a.m9575f(26, this.vBY);
            }
            if (this.vBZ != null) {
                ix += C6091a.m9575f(27, this.vBZ);
            }
            if (this.vCa != null) {
                ix += C6091a.m9575f(28, this.vCa);
            }
            if (this.vCb != null) {
                ix += C6091a.m9575f(29, this.vCb);
            }
            if (this.vCc != null) {
                ix += C6091a.m9575f(30, this.vCc);
            }
            if (this.vCd != null) {
                ix += C6091a.m9575f(31, this.vCd);
            }
            if (this.kbU != null) {
                ix += C6091a.m9575f(32, this.kbU);
            }
            if (this.vCe != null) {
                ix += C6091a.m9575f(33, this.vCe);
            }
            ix = (ix + C6087a.m9552c(34, 8, this.kcO)) + C6087a.m9552c(35, 8, this.kcP);
            if (this.kcQ != null) {
                ix += C6091a.m9575f(36, this.kcQ);
            }
            ix += C6091a.m9572bs(37, this.kcR);
            if (this.kcS != null) {
                ix += C6091a.m9575f(38, this.kcS);
            }
            if (this.kcT != null) {
                ix += C6091a.m9575f(39, this.kcT);
            }
            AppMethodBeat.m2505o(89000);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kcO.clear();
            this.kcP.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89000);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15317ao c15317ao = (C15317ao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
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
                        c15317ao.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 2:
                    c15317ao.vBE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 3:
                    c15317ao.vBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 4:
                    c15317ao.vBG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 5:
                    c15317ao.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 6:
                    c15317ao.vBH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 7:
                    c15317ao.vBI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 8:
                    c15317ao.vBJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 9:
                    c15317ao.vBK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 10:
                    c15317ao.vBL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 11:
                    c15317ao.vBM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 12:
                    c15317ao.vBN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 13:
                    c15317ao.vBO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 14:
                    c15317ao.kcU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 15:
                    c15317ao.kcV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 16:
                    c15317ao.vBP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 17:
                    c15317ao.vBQ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 18:
                    c15317ao.vBR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 19:
                    c15317ao.vBS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 20:
                    c15317ao.vBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 21:
                    c15317ao.color = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 22:
                    c15317ao.vBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 23:
                    c15317ao.vBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 24:
                    c15317ao.vBW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 25:
                    c15317ao.vBX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 26:
                    c15317ao.vBY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 27:
                    c15317ao.vBZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    c15317ao.vCa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 29:
                    c15317ao.vCb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 30:
                    c15317ao.vCc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 31:
                    c15317ao.vCd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 32:
                    c15317ao.kbU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 33:
                    c15317ao.vCe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 34:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7250ap c7250ap = new C7250ap();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7250ap.populateBuilderWithField(c6086a3, c7250ap, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15317ao.kcO.add(c7250ap);
                    }
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 35:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35902aq c35902aq = new C35902aq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35902aq.populateBuilderWithField(c6086a3, c35902aq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15317ao.kcP.add(c35902aq);
                    }
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 36:
                    c15317ao.kcQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    c15317ao.kcR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 38:
                    c15317ao.kcS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                case 39:
                    c15317ao.kcT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89000);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89000);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89000);
            return -1;
        }
    }
}
