package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ckp */
public final class ckp extends btd {
    public String wGj;
    public int wnG;
    public int wnH;
    public int wnI;
    public int wnJ;
    public String wnK;
    public int wnL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5605);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5605);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wGj != null) {
                c6093a.mo13475e(2, this.wGj);
            }
            if (this.wnK != null) {
                c6093a.mo13475e(3, this.wnK);
            }
            c6093a.mo13480iz(4, this.wnJ);
            c6093a.mo13480iz(5, this.wnG);
            c6093a.mo13480iz(6, this.wnH);
            c6093a.mo13480iz(7, this.wnI);
            c6093a.mo13480iz(8, this.wnL);
            AppMethodBeat.m2505o(5605);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wGj != null) {
                ix += C6091a.m9575f(2, this.wGj);
            }
            if (this.wnK != null) {
                ix += C6091a.m9575f(3, this.wnK);
            }
            int bs = ((((ix + C6091a.m9572bs(4, this.wnJ)) + C6091a.m9572bs(5, this.wnG)) + C6091a.m9572bs(6, this.wnH)) + C6091a.m9572bs(7, this.wnI)) + C6091a.m9572bs(8, this.wnL);
            AppMethodBeat.m2505o(5605);
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
                AppMethodBeat.m2505o(5605);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5605);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ckp ckp = (ckp) objArr[1];
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
                        ckp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(5605);
                    return 0;
                case 2:
                    ckp.wGj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5605);
                    return 0;
                case 3:
                    ckp.wnK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5605);
                    return 0;
                case 4:
                    ckp.wnJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5605);
                    return 0;
                case 5:
                    ckp.wnG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5605);
                    return 0;
                case 6:
                    ckp.wnH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5605);
                    return 0;
                case 7:
                    ckp.wnI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5605);
                    return 0;
                case 8:
                    ckp.wnL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5605);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5605);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5605);
            return -1;
        }
    }
}
