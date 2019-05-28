package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdk */
public final class cdk extends btd {
    public int ptD;
    public long ptF;
    public int xdf;
    public LinkedList<C7279qd> xdg = new LinkedList();

    public cdk() {
        AppMethodBeat.m2504i(80193);
        AppMethodBeat.m2505o(80193);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80194);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80194);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.ptD);
            c6093a.mo13472ai(3, this.ptF);
            c6093a.mo13480iz(4, this.xdf);
            c6093a.mo13474e(5, 8, this.xdg);
            AppMethodBeat.m2505o(80194);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + C6091a.m9572bs(2, this.ptD)) + C6091a.m9578o(3, this.ptF)) + C6091a.m9572bs(4, this.xdf)) + C6087a.m9552c(5, 8, this.xdg);
            AppMethodBeat.m2505o(80194);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdg.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80194);
                throw c6092b;
            }
            AppMethodBeat.m2505o(80194);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdk cdk = (cdk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        cdk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(80194);
                    return 0;
                case 2:
                    cdk.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80194);
                    return 0;
                case 3:
                    cdk.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(80194);
                    return 0;
                case 4:
                    cdk.xdf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80194);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7279qd c7279qd = new C7279qd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7279qd.populateBuilderWithField(c6086a3, c7279qd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdk.xdg.add(c7279qd);
                    }
                    AppMethodBeat.m2505o(80194);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80194);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80194);
            return -1;
        }
    }
}
