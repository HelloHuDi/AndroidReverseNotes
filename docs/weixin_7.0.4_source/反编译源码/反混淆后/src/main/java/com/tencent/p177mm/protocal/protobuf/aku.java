package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aku */
public final class aku extends btd {
    public int kKI;
    public int kdT;
    public String kdU;
    public int wqk;
    public bik wqr;
    public int wqs;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89098);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(89098);
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
            c6093a.mo13480iz(4, this.kKI);
            c6093a.mo13480iz(5, this.wqk);
            if (this.wqr != null) {
                c6093a.mo13479iy(6, this.wqr.computeSize());
                this.wqr.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.wqs);
            AppMethodBeat.m2505o(89098);
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
            ix = (ix + C6091a.m9572bs(4, this.kKI)) + C6091a.m9572bs(5, this.wqk);
            if (this.wqr != null) {
                ix += C6087a.m9557ix(6, this.wqr.computeSize());
            }
            int bs = ix + C6091a.m9572bs(7, this.wqs);
            AppMethodBeat.m2505o(89098);
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
                AppMethodBeat.m2505o(89098);
                throw c6092b;
            }
            AppMethodBeat.m2505o(89098);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aku aku = (aku) objArr[1];
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
                        aku.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(89098);
                    return 0;
                case 2:
                    aku.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89098);
                    return 0;
                case 3:
                    aku.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89098);
                    return 0;
                case 4:
                    aku.kKI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89098);
                    return 0;
                case 5:
                    aku.wqk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89098);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bik bik = new bik();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bik.populateBuilderWithField(c6086a3, bik, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aku.wqr = bik;
                    }
                    AppMethodBeat.m2505o(89098);
                    return 0;
                case 7:
                    aku.wqs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89098);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89098);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89098);
            return -1;
        }
    }
}
