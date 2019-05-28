package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cly */
public final class cly extends btd {
    public int fJT;
    public String ndF;
    public String ndG;
    public int pcX;
    public int ptD;
    public long ptF;
    public String vFF;
    public int vOq;
    public int wdn;
    public int wdp;
    public int wdq;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116812);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(116812);
                throw c6092b;
            }
            if (this.ndG != null) {
                c6093a.mo13475e(1, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(2, this.ndF);
            }
            c6093a.mo13480iz(3, this.vOq);
            c6093a.mo13480iz(4, this.wdn);
            c6093a.mo13480iz(5, this.pcX);
            if (this.vFF != null) {
                c6093a.mo13475e(6, this.vFF);
            }
            c6093a.mo13480iz(7, this.ptD);
            c6093a.mo13480iz(8, this.wdp);
            c6093a.mo13480iz(9, this.fJT);
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(10, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(11, this.wdq);
            c6093a.mo13472ai(12, this.ptF);
            AppMethodBeat.m2505o(116812);
            return 0;
        } else if (i == 1) {
            if (this.ndG != null) {
                f = C6091a.m9575f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.ndF != null) {
                f += C6091a.m9575f(2, this.ndF);
            }
            f = ((f + C6091a.m9572bs(3, this.vOq)) + C6091a.m9572bs(4, this.wdn)) + C6091a.m9572bs(5, this.pcX);
            if (this.vFF != null) {
                f += C6091a.m9575f(6, this.vFF);
            }
            f = ((f + C6091a.m9572bs(7, this.ptD)) + C6091a.m9572bs(8, this.wdp)) + C6091a.m9572bs(9, this.fJT);
            if (this.BaseResponse != null) {
                f += C6087a.m9557ix(10, this.BaseResponse.computeSize());
            }
            int bs = (f + C6091a.m9572bs(11, this.wdq)) + C6091a.m9578o(12, this.ptF);
            AppMethodBeat.m2505o(116812);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(116812);
                throw c6092b;
            }
            AppMethodBeat.m2505o(116812);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cly cly = (cly) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cly.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 2:
                    cly.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 3:
                    cly.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 4:
                    cly.wdn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 5:
                    cly.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 6:
                    cly.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 7:
                    cly.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 8:
                    cly.wdp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 9:
                    cly.fJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 10:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cly.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 11:
                    cly.wdq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                case 12:
                    cly.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(116812);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116812);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116812);
            return -1;
        }
    }
}
