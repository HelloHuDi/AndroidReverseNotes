package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.azl */
public final class azl extends btd {
    public String kKw;
    public String kKx;
    public String sign;
    public String ulZ;
    public int uma;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10217);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(10217);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.ulZ != null) {
                c6093a.mo13475e(2, this.ulZ);
            }
            if (this.kKw != null) {
                c6093a.mo13475e(3, this.kKw);
            }
            if (this.kKx != null) {
                c6093a.mo13475e(4, this.kKx);
            }
            if (this.sign != null) {
                c6093a.mo13475e(5, this.sign);
            }
            c6093a.mo13480iz(6, this.uma);
            AppMethodBeat.m2505o(10217);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ulZ != null) {
                ix += C6091a.m9575f(2, this.ulZ);
            }
            if (this.kKw != null) {
                ix += C6091a.m9575f(3, this.kKw);
            }
            if (this.kKx != null) {
                ix += C6091a.m9575f(4, this.kKx);
            }
            if (this.sign != null) {
                ix += C6091a.m9575f(5, this.sign);
            }
            int bs = ix + C6091a.m9572bs(6, this.uma);
            AppMethodBeat.m2505o(10217);
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
                AppMethodBeat.m2505o(10217);
                throw c6092b;
            }
            AppMethodBeat.m2505o(10217);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            azl azl = (azl) objArr[1];
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
                        azl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(10217);
                    return 0;
                case 2:
                    azl.ulZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10217);
                    return 0;
                case 3:
                    azl.kKw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10217);
                    return 0;
                case 4:
                    azl.kKx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10217);
                    return 0;
                case 5:
                    azl.sign = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10217);
                    return 0;
                case 6:
                    azl.uma = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10217);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10217);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10217);
            return -1;
        }
    }
}
