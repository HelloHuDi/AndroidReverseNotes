package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.akg */
public final class akg extends btd {
    public String cMD;
    public String color;
    public String kbU;
    public String kbV;
    public String kbW;
    public String kbX;
    public int kbZ;
    public String kdg;
    public int qsq;
    public String qsr;
    public String qss;
    public String qst;
    public String qsv;
    public boolean qsw;
    public String title;
    public boolean wpH;
    public boolean wpI;
    public String wpJ;
    public String wpK;
    public int wpL;
    public String wpM;
    public int wpN;
    public String wpO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28444);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28444);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13471aO(2, this.wpH);
            c6093a.mo13471aO(3, this.wpI);
            if (this.wpJ != null) {
                c6093a.mo13475e(4, this.wpJ);
            }
            if (this.wpK != null) {
                c6093a.mo13475e(5, this.wpK);
            }
            c6093a.mo13480iz(6, this.wpL);
            if (this.wpM != null) {
                c6093a.mo13475e(7, this.wpM);
            }
            c6093a.mo13480iz(8, this.wpN);
            if (this.kbU != null) {
                c6093a.mo13475e(9, this.kbU);
            }
            if (this.cMD != null) {
                c6093a.mo13475e(10, this.cMD);
            }
            if (this.title != null) {
                c6093a.mo13475e(11, this.title);
            }
            if (this.kbW != null) {
                c6093a.mo13475e(12, this.kbW);
            }
            if (this.kbX != null) {
                c6093a.mo13475e(13, this.kbX);
            }
            if (this.kdg != null) {
                c6093a.mo13475e(14, this.kdg);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(15, this.kbV);
            }
            if (this.color != null) {
                c6093a.mo13475e(16, this.color);
            }
            c6093a.mo13480iz(17, this.qsq);
            if (this.qsr != null) {
                c6093a.mo13475e(18, this.qsr);
            }
            if (this.qss != null) {
                c6093a.mo13475e(19, this.qss);
            }
            if (this.qst != null) {
                c6093a.mo13475e(20, this.qst);
            }
            c6093a.mo13480iz(21, this.kbZ);
            if (this.qsv != null) {
                c6093a.mo13475e(22, this.qsv);
            }
            if (this.wpO != null) {
                c6093a.mo13475e(23, this.wpO);
            }
            c6093a.mo13471aO(24, this.qsw);
            AppMethodBeat.m2505o(28444);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + (C6091a.m9576fv(2) + 1)) + (C6091a.m9576fv(3) + 1);
            if (this.wpJ != null) {
                ix += C6091a.m9575f(4, this.wpJ);
            }
            if (this.wpK != null) {
                ix += C6091a.m9575f(5, this.wpK);
            }
            ix += C6091a.m9572bs(6, this.wpL);
            if (this.wpM != null) {
                ix += C6091a.m9575f(7, this.wpM);
            }
            ix += C6091a.m9572bs(8, this.wpN);
            if (this.kbU != null) {
                ix += C6091a.m9575f(9, this.kbU);
            }
            if (this.cMD != null) {
                ix += C6091a.m9575f(10, this.cMD);
            }
            if (this.title != null) {
                ix += C6091a.m9575f(11, this.title);
            }
            if (this.kbW != null) {
                ix += C6091a.m9575f(12, this.kbW);
            }
            if (this.kbX != null) {
                ix += C6091a.m9575f(13, this.kbX);
            }
            if (this.kdg != null) {
                ix += C6091a.m9575f(14, this.kdg);
            }
            if (this.kbV != null) {
                ix += C6091a.m9575f(15, this.kbV);
            }
            if (this.color != null) {
                ix += C6091a.m9575f(16, this.color);
            }
            ix += C6091a.m9572bs(17, this.qsq);
            if (this.qsr != null) {
                ix += C6091a.m9575f(18, this.qsr);
            }
            if (this.qss != null) {
                ix += C6091a.m9575f(19, this.qss);
            }
            if (this.qst != null) {
                ix += C6091a.m9575f(20, this.qst);
            }
            ix += C6091a.m9572bs(21, this.kbZ);
            if (this.qsv != null) {
                ix += C6091a.m9575f(22, this.qsv);
            }
            if (this.wpO != null) {
                ix += C6091a.m9575f(23, this.wpO);
            }
            int fv = ix + (C6091a.m9576fv(24) + 1);
            AppMethodBeat.m2505o(28444);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28444);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28444);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            akg akg = (akg) objArr[1];
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
                        akg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 2:
                    akg.wpH = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 3:
                    akg.wpI = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 4:
                    akg.wpJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 5:
                    akg.wpK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 6:
                    akg.wpL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 7:
                    akg.wpM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 8:
                    akg.wpN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 9:
                    akg.kbU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 10:
                    akg.cMD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 11:
                    akg.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 12:
                    akg.kbW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 13:
                    akg.kbX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 14:
                    akg.kdg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 15:
                    akg.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 16:
                    akg.color = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 17:
                    akg.qsq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 18:
                    akg.qsr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 19:
                    akg.qss = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 20:
                    akg.qst = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 21:
                    akg.kbZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 22:
                    akg.qsv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 23:
                    akg.wpO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                case 24:
                    akg.qsw = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28444);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28444);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28444);
            return -1;
        }
    }
}
