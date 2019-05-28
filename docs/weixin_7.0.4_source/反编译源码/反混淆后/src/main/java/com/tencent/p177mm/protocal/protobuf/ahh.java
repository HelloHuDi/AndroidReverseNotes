package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ahh */
public final class ahh extends btd {
    public int jBs;
    public String wnM;
    public C7280qe wnN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5586);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5586);
                throw c6092b;
            } else if (this.wnN == null) {
                c6092b = new C6092b("Not all required fields were included: NewChatroomData");
                AppMethodBeat.m2505o(5586);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wnM != null) {
                    c6093a.mo13475e(2, this.wnM);
                }
                c6093a.mo13480iz(3, this.jBs);
                if (this.wnN != null) {
                    c6093a.mo13479iy(4, this.wnN.computeSize());
                    this.wnN.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(5586);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wnM != null) {
                ix += C6091a.m9575f(2, this.wnM);
            }
            ix += C6091a.m9572bs(3, this.jBs);
            if (this.wnN != null) {
                ix += C6087a.m9557ix(4, this.wnN.computeSize());
            }
            AppMethodBeat.m2505o(5586);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5586);
                throw c6092b;
            } else if (this.wnN == null) {
                c6092b = new C6092b("Not all required fields were included: NewChatroomData");
                AppMethodBeat.m2505o(5586);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5586);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ahh ahh = (ahh) objArr[1];
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
                        ahh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(5586);
                    return 0;
                case 2:
                    ahh.wnM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5586);
                    return 0;
                case 3:
                    ahh.jBs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5586);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7280qe c7280qe = new C7280qe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7280qe.populateBuilderWithField(c6086a3, c7280qe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ahh.wnN = c7280qe;
                    }
                    AppMethodBeat.m2505o(5586);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5586);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5586);
            return -1;
        }
    }
}
