package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lv */
public final class C44143lv extends btd {
    public String cBT;
    public int kdT;
    public String kdU;
    public int pPG = 0;
    public String pPH;
    public String pPI;
    public String pPJ;
    public String pPK;
    public String vFb;
    public String vFc;
    public String vFd;
    public String vPA;
    public bzp vPB;
    public String vPC;
    public String vPD;
    public int vPE;
    public int vPF;
    public int vPG;
    public chl vPH;
    public String vPI;
    public int vPJ;
    public int vPK;
    public int vPL;
    public C1332b vPM;
    public int vPN;
    public int vPO;
    public int vPP;
    public String vPo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56725);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56725);
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
            if (this.cBT != null) {
                c6093a.mo13475e(4, this.cBT);
            }
            if (this.vPA != null) {
                c6093a.mo13475e(5, this.vPA);
            }
            if (this.vPB != null) {
                c6093a.mo13479iy(6, this.vPB.computeSize());
                this.vPB.writeFields(c6093a);
            }
            if (this.vFb != null) {
                c6093a.mo13475e(7, this.vFb);
            }
            if (this.vFd != null) {
                c6093a.mo13475e(8, this.vFd);
            }
            if (this.vPC != null) {
                c6093a.mo13475e(9, this.vPC);
            }
            if (this.vPD != null) {
                c6093a.mo13475e(10, this.vPD);
            }
            c6093a.mo13480iz(11, this.vPE);
            if (this.vFc != null) {
                c6093a.mo13475e(12, this.vFc);
            }
            if (this.vPo != null) {
                c6093a.mo13475e(13, this.vPo);
            }
            c6093a.mo13480iz(14, this.vPF);
            c6093a.mo13480iz(15, this.vPG);
            if (this.vPH != null) {
                c6093a.mo13479iy(16, this.vPH.computeSize());
                this.vPH.writeFields(c6093a);
            }
            if (this.vPI != null) {
                c6093a.mo13475e(17, this.vPI);
            }
            c6093a.mo13480iz(18, this.vPJ);
            c6093a.mo13480iz(19, this.vPK);
            c6093a.mo13480iz(20, this.vPL);
            if (this.vPM != null) {
                c6093a.mo13473c(21, this.vPM);
            }
            c6093a.mo13480iz(22, this.vPN);
            c6093a.mo13480iz(23, this.pPG);
            if (this.pPH != null) {
                c6093a.mo13475e(24, this.pPH);
            }
            if (this.pPI != null) {
                c6093a.mo13475e(25, this.pPI);
            }
            c6093a.mo13480iz(26, this.vPO);
            if (this.pPJ != null) {
                c6093a.mo13475e(27, this.pPJ);
            }
            if (this.pPK != null) {
                c6093a.mo13475e(28, this.pPK);
            }
            c6093a.mo13480iz(29, this.vPP);
            AppMethodBeat.m2505o(56725);
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
            if (this.cBT != null) {
                ix += C6091a.m9575f(4, this.cBT);
            }
            if (this.vPA != null) {
                ix += C6091a.m9575f(5, this.vPA);
            }
            if (this.vPB != null) {
                ix += C6087a.m9557ix(6, this.vPB.computeSize());
            }
            if (this.vFb != null) {
                ix += C6091a.m9575f(7, this.vFb);
            }
            if (this.vFd != null) {
                ix += C6091a.m9575f(8, this.vFd);
            }
            if (this.vPC != null) {
                ix += C6091a.m9575f(9, this.vPC);
            }
            if (this.vPD != null) {
                ix += C6091a.m9575f(10, this.vPD);
            }
            ix += C6091a.m9572bs(11, this.vPE);
            if (this.vFc != null) {
                ix += C6091a.m9575f(12, this.vFc);
            }
            if (this.vPo != null) {
                ix += C6091a.m9575f(13, this.vPo);
            }
            ix = (ix + C6091a.m9572bs(14, this.vPF)) + C6091a.m9572bs(15, this.vPG);
            if (this.vPH != null) {
                ix += C6087a.m9557ix(16, this.vPH.computeSize());
            }
            if (this.vPI != null) {
                ix += C6091a.m9575f(17, this.vPI);
            }
            ix = ((ix + C6091a.m9572bs(18, this.vPJ)) + C6091a.m9572bs(19, this.vPK)) + C6091a.m9572bs(20, this.vPL);
            if (this.vPM != null) {
                ix += C6091a.m9571b(21, this.vPM);
            }
            ix = (ix + C6091a.m9572bs(22, this.vPN)) + C6091a.m9572bs(23, this.pPG);
            if (this.pPH != null) {
                ix += C6091a.m9575f(24, this.pPH);
            }
            if (this.pPI != null) {
                ix += C6091a.m9575f(25, this.pPI);
            }
            ix += C6091a.m9572bs(26, this.vPO);
            if (this.pPJ != null) {
                ix += C6091a.m9575f(27, this.pPJ);
            }
            if (this.pPK != null) {
                ix += C6091a.m9575f(28, this.pPK);
            }
            int bs = ix + C6091a.m9572bs(29, this.vPP);
            AppMethodBeat.m2505o(56725);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56725);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56725);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44143lv c44143lv = (C44143lv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        c44143lv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 2:
                    c44143lv.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 3:
                    c44143lv.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 4:
                    c44143lv.cBT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 5:
                    c44143lv.vPA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzp bzp = new bzp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzp.populateBuilderWithField(c6086a3, bzp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44143lv.vPB = bzp;
                    }
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 7:
                    c44143lv.vFb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 8:
                    c44143lv.vFd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 9:
                    c44143lv.vPC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 10:
                    c44143lv.vPD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 11:
                    c44143lv.vPE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 12:
                    c44143lv.vFc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 13:
                    c44143lv.vPo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 14:
                    c44143lv.vPF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 15:
                    c44143lv.vPG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chl chl = new chl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chl.populateBuilderWithField(c6086a3, chl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44143lv.vPH = chl;
                    }
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 17:
                    c44143lv.vPI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 18:
                    c44143lv.vPJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 19:
                    c44143lv.vPK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 20:
                    c44143lv.vPL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 21:
                    c44143lv.vPM = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 22:
                    c44143lv.vPN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 23:
                    c44143lv.pPG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 24:
                    c44143lv.pPH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 25:
                    c44143lv.pPI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 26:
                    c44143lv.vPO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 27:
                    c44143lv.pPJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    c44143lv.pPK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                case 29:
                    c44143lv.vPP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56725);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56725);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56725);
            return -1;
        }
    }
}
