package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.afe */
public final class afe extends btd {
    public int kCl;
    public String kCm;
    public LinkedList<String> ttN = new LinkedList();
    public String wmE;

    public afe() {
        AppMethodBeat.m2504i(56809);
        AppMethodBeat.m2505o(56809);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56810);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56810);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 1, this.ttN);
            c6093a.mo13480iz(3, this.kCl);
            if (this.kCm != null) {
                c6093a.mo13475e(4, this.kCm);
            }
            if (this.wmE != null) {
                c6093a.mo13475e(5, this.wmE);
            }
            AppMethodBeat.m2505o(56810);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6087a.m9552c(2, 1, this.ttN)) + C6091a.m9572bs(3, this.kCl);
            if (this.kCm != null) {
                ix += C6091a.m9575f(4, this.kCm);
            }
            if (this.wmE != null) {
                ix += C6091a.m9575f(5, this.wmE);
            }
            AppMethodBeat.m2505o(56810);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ttN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56810);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56810);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            afe afe = (afe) objArr[1];
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
                        afe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56810);
                    return 0;
                case 2:
                    afe.ttN.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56810);
                    return 0;
                case 3:
                    afe.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56810);
                    return 0;
                case 4:
                    afe.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56810);
                    return 0;
                case 5:
                    afe.wmE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56810);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56810);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56810);
            return -1;
        }
    }
}
