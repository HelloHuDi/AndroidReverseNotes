package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.pr */
public final class C30214pr extends btd {
    public String desc;
    public int kCl;
    public String kCm;
    public String pPw;
    public String vWG;
    public String vWJ;
    public String vWM;
    public String vWO;
    public String vWP;
    public String vWS;
    public LinkedList<Integer> vWt = new LinkedList();
    public int vWv;

    public C30214pr() {
        AppMethodBeat.m2504i(48802);
        AppMethodBeat.m2505o(48802);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48803);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48803);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kCl);
            if (this.kCm != null) {
                c6093a.mo13475e(3, this.kCm);
            }
            if (this.vWJ != null) {
                c6093a.mo13475e(4, this.vWJ);
            }
            c6093a.mo13474e(5, 2, this.vWt);
            if (this.desc != null) {
                c6093a.mo13475e(6, this.desc);
            }
            if (this.vWS != null) {
                c6093a.mo13475e(7, this.vWS);
            }
            if (this.pPw != null) {
                c6093a.mo13475e(8, this.pPw);
            }
            if (this.vWM != null) {
                c6093a.mo13475e(9, this.vWM);
            }
            if (this.vWO != null) {
                c6093a.mo13475e(10, this.vWO);
            }
            if (this.vWP != null) {
                c6093a.mo13475e(11, this.vWP);
            }
            c6093a.mo13480iz(12, this.vWv);
            if (this.vWG != null) {
                c6093a.mo13475e(13, this.vWG);
            }
            AppMethodBeat.m2505o(48803);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kCl);
            if (this.kCm != null) {
                ix += C6091a.m9575f(3, this.kCm);
            }
            if (this.vWJ != null) {
                ix += C6091a.m9575f(4, this.vWJ);
            }
            ix += C6087a.m9552c(5, 2, this.vWt);
            if (this.desc != null) {
                ix += C6091a.m9575f(6, this.desc);
            }
            if (this.vWS != null) {
                ix += C6091a.m9575f(7, this.vWS);
            }
            if (this.pPw != null) {
                ix += C6091a.m9575f(8, this.pPw);
            }
            if (this.vWM != null) {
                ix += C6091a.m9575f(9, this.vWM);
            }
            if (this.vWO != null) {
                ix += C6091a.m9575f(10, this.vWO);
            }
            if (this.vWP != null) {
                ix += C6091a.m9575f(11, this.vWP);
            }
            ix += C6091a.m9572bs(12, this.vWv);
            if (this.vWG != null) {
                ix += C6091a.m9575f(13, this.vWG);
            }
            AppMethodBeat.m2505o(48803);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWt.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48803);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48803);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30214pr c30214pr = (C30214pr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30214pr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 2:
                    c30214pr.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 3:
                    c30214pr.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 4:
                    c30214pr.vWJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 5:
                    c30214pr.vWt.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 6:
                    c30214pr.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 7:
                    c30214pr.vWS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 8:
                    c30214pr.pPw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 9:
                    c30214pr.vWM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 10:
                    c30214pr.vWO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 11:
                    c30214pr.vWP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 12:
                    c30214pr.vWv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                case 13:
                    c30214pr.vWG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48803);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48803);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48803);
            return -1;
        }
    }
}
