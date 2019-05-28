package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.jp */
public final class C35927jp extends btd {
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
    public C7270lm vLL;
    public bdu vLM;
    public String vLN;
    public int vLO;
    public btv vLP;
    public String vLQ;
    public String vLR;
    public String vLS;
    public String vLT;
    public int vLU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(123507);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(123507);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.cxb != null) {
                c6093a.mo13475e(2, this.cxb);
            }
            if (this.vLH != null) {
                c6093a.mo13475e(3, this.vLH);
            }
            c6093a.mo13480iz(4, this.vLI);
            if (this.vLJ != null) {
                c6093a.mo13475e(5, this.vLJ);
            }
            if (this.vHl != null) {
                c6093a.mo13475e(6, this.vHl);
            }
            if (this.vLK != null) {
                c6093a.mo13479iy(7, this.vLK.computeSize());
                this.vLK.writeFields(c6093a);
            }
            if (this.vLL != null) {
                c6093a.mo13479iy(8, this.vLL.computeSize());
                this.vLL.writeFields(c6093a);
            }
            if (this.vLM != null) {
                c6093a.mo13479iy(9, this.vLM.computeSize());
                this.vLM.writeFields(c6093a);
            }
            if (this.vHS != null) {
                c6093a.mo13475e(10, this.vHS);
            }
            c6093a.mo13480iz(11, this.vCl);
            if (this.vLN != null) {
                c6093a.mo13475e(12, this.vLN);
            }
            c6093a.mo13480iz(13, this.vLO);
            if (this.vLP != null) {
                c6093a.mo13479iy(14, this.vLP.computeSize());
                this.vLP.writeFields(c6093a);
            }
            if (this.vLQ != null) {
                c6093a.mo13475e(15, this.vLQ);
            }
            if (this.vLR != null) {
                c6093a.mo13475e(16, this.vLR);
            }
            if (this.vHR != null) {
                c6093a.mo13479iy(17, this.vHR.computeSize());
                this.vHR.writeFields(c6093a);
            }
            c6093a.mo13480iz(18, this.vHW);
            if (this.vLS != null) {
                c6093a.mo13475e(19, this.vLS);
            }
            if (this.vLT != null) {
                c6093a.mo13475e(20, this.vLT);
            }
            c6093a.mo13480iz(21, this.vLC);
            if (this.vLD != null) {
                c6093a.mo13475e(22, this.vLD);
            }
            c6093a.mo13480iz(23, this.vLU);
            AppMethodBeat.m2505o(123507);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.cxb != null) {
                ix += C6091a.m9575f(2, this.cxb);
            }
            if (this.vLH != null) {
                ix += C6091a.m9575f(3, this.vLH);
            }
            ix += C6091a.m9572bs(4, this.vLI);
            if (this.vLJ != null) {
                ix += C6091a.m9575f(5, this.vLJ);
            }
            if (this.vHl != null) {
                ix += C6091a.m9575f(6, this.vHl);
            }
            if (this.vLK != null) {
                ix += C6087a.m9557ix(7, this.vLK.computeSize());
            }
            if (this.vLL != null) {
                ix += C6087a.m9557ix(8, this.vLL.computeSize());
            }
            if (this.vLM != null) {
                ix += C6087a.m9557ix(9, this.vLM.computeSize());
            }
            if (this.vHS != null) {
                ix += C6091a.m9575f(10, this.vHS);
            }
            ix += C6091a.m9572bs(11, this.vCl);
            if (this.vLN != null) {
                ix += C6091a.m9575f(12, this.vLN);
            }
            ix += C6091a.m9572bs(13, this.vLO);
            if (this.vLP != null) {
                ix += C6087a.m9557ix(14, this.vLP.computeSize());
            }
            if (this.vLQ != null) {
                ix += C6091a.m9575f(15, this.vLQ);
            }
            if (this.vLR != null) {
                ix += C6091a.m9575f(16, this.vLR);
            }
            if (this.vHR != null) {
                ix += C6087a.m9557ix(17, this.vHR.computeSize());
            }
            ix += C6091a.m9572bs(18, this.vHW);
            if (this.vLS != null) {
                ix += C6091a.m9575f(19, this.vLS);
            }
            if (this.vLT != null) {
                ix += C6091a.m9575f(20, this.vLT);
            }
            ix += C6091a.m9572bs(21, this.vLC);
            if (this.vLD != null) {
                ix += C6091a.m9575f(22, this.vLD);
            }
            int bs = ix + C6091a.m9572bs(23, this.vLU);
            AppMethodBeat.m2505o(123507);
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
                AppMethodBeat.m2505o(123507);
                throw c6092b;
            }
            AppMethodBeat.m2505o(123507);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35927jp c35927jp = (C35927jp) objArr[1];
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
                        c35927jp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 2:
                    c35927jp.cxb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 3:
                    c35927jp.vLH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 4:
                    c35927jp.vLI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 5:
                    c35927jp.vLJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 6:
                    c35927jp.vHl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ato ato = new ato();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ato.populateBuilderWithField(c6086a3, ato, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35927jp.vLK = ato;
                    }
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7270lm c7270lm = new C7270lm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7270lm.populateBuilderWithField(c6086a3, c7270lm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35927jp.vLL = c7270lm;
                    }
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdu bdu = new bdu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdu.populateBuilderWithField(c6086a3, bdu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35927jp.vLM = bdu;
                    }
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 10:
                    c35927jp.vHS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 11:
                    c35927jp.vCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 12:
                    c35927jp.vLN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 13:
                    c35927jp.vLO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btv btv = new btv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btv.populateBuilderWithField(c6086a3, btv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35927jp.vLP = btv;
                    }
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 15:
                    c35927jp.vLQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 16:
                    c35927jp.vLR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzr bzr = new bzr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzr.populateBuilderWithField(c6086a3, bzr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35927jp.vHR = bzr;
                    }
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 18:
                    c35927jp.vHW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 19:
                    c35927jp.vLS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 20:
                    c35927jp.vLT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 21:
                    c35927jp.vLC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 22:
                    c35927jp.vLD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                case 23:
                    c35927jp.vLU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123507);
                    return 0;
                default:
                    AppMethodBeat.m2505o(123507);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(123507);
            return -1;
        }
    }
}
