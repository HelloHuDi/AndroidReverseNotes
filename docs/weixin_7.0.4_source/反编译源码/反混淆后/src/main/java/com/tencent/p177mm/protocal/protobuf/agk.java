package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.agk */
public final class agk extends btd {
    public String color;
    public String content;
    public String kbU;
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

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89076);
        int ix;
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
            AppMethodBeat.m2505o(89076);
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
            AppMethodBeat.m2505o(89076);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89076);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            agk agk = (agk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        agk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 2:
                    agk.vBE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 3:
                    agk.vBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 4:
                    agk.vBG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 5:
                    agk.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 6:
                    agk.vBH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 7:
                    agk.vBI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 8:
                    agk.vBJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 9:
                    agk.vBK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 10:
                    agk.vBL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 11:
                    agk.vBM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 12:
                    agk.vBN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 13:
                    agk.vBO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 14:
                    agk.kcU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 15:
                    agk.kcV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 16:
                    agk.vBP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 17:
                    agk.vBQ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 18:
                    agk.vBR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 19:
                    agk.vBS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 20:
                    agk.vBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 21:
                    agk.color = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 22:
                    agk.vBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 23:
                    agk.vBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 24:
                    agk.vBW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 25:
                    agk.vBX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 26:
                    agk.vBY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 27:
                    agk.vBZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    agk.vCa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 29:
                    agk.vCb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 30:
                    agk.vCc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 31:
                    agk.vCd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 32:
                    agk.kbU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                case 33:
                    agk.vCe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89076);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89076);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89076);
            return -1;
        }
    }
}
