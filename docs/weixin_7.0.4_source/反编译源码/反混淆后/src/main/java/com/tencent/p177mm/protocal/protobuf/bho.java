package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bho */
public final class bho extends btd {
    public int kCl;
    public String kCm;
    public String kCx;
    public String kCy;
    public int wKN;
    public int wKO;
    public String wKP;
    public String wKQ;
    public int wKR;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48912);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48912);
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
            c6093a.mo13480iz(4, this.wKN);
            c6093a.mo13480iz(5, this.wKO);
            if (this.kCx != null) {
                c6093a.mo13475e(6, this.kCx);
            }
            if (this.kCy != null) {
                c6093a.mo13475e(7, this.kCy);
            }
            if (this.wKP != null) {
                c6093a.mo13475e(8, this.wKP);
            }
            if (this.wKQ != null) {
                c6093a.mo13475e(9, this.wKQ);
            }
            c6093a.mo13480iz(10, this.wKR);
            AppMethodBeat.m2505o(48912);
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
            ix = (ix + C6091a.m9572bs(4, this.wKN)) + C6091a.m9572bs(5, this.wKO);
            if (this.kCx != null) {
                ix += C6091a.m9575f(6, this.kCx);
            }
            if (this.kCy != null) {
                ix += C6091a.m9575f(7, this.kCy);
            }
            if (this.wKP != null) {
                ix += C6091a.m9575f(8, this.wKP);
            }
            if (this.wKQ != null) {
                ix += C6091a.m9575f(9, this.wKQ);
            }
            int bs = ix + C6091a.m9572bs(10, this.wKR);
            AppMethodBeat.m2505o(48912);
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
                AppMethodBeat.m2505o(48912);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48912);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bho bho = (bho) objArr[1];
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
                        bho.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 2:
                    bho.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 3:
                    bho.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 4:
                    bho.wKN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 5:
                    bho.wKO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 6:
                    bho.kCx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 7:
                    bho.kCy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 8:
                    bho.wKP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 9:
                    bho.wKQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                case 10:
                    bho.wKR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48912);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48912);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48912);
            return -1;
        }
    }
}
