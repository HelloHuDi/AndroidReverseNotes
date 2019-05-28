package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ee */
public final class C30180ee extends btd {
    public int enabled;
    public int kKI;
    public LinkedList<C44136kl> vFR = new LinkedList();
    public boolean vFS;
    public int vFT;

    public C30180ee() {
        AppMethodBeat.m2504i(14687);
        AppMethodBeat.m2505o(14687);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14688);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(14688);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vFR);
            c6093a.mo13471aO(3, this.vFS);
            c6093a.mo13480iz(4, this.vFT);
            c6093a.mo13480iz(5, this.enabled);
            c6093a.mo13480iz(6, this.kKI);
            AppMethodBeat.m2505o(14688);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ((((ix + C6087a.m9552c(2, 8, this.vFR)) + (C6091a.m9576fv(3) + 1)) + C6091a.m9572bs(4, this.vFT)) + C6091a.m9572bs(5, this.enabled)) + C6091a.m9572bs(6, this.kKI);
            AppMethodBeat.m2505o(14688);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vFR.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(14688);
                throw c6092b;
            }
            AppMethodBeat.m2505o(14688);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30180ee c30180ee = (C30180ee) objArr[1];
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
                        c30180ee.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(14688);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44136kl c44136kl = new C44136kl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44136kl.populateBuilderWithField(c6086a3, c44136kl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30180ee.vFR.add(c44136kl);
                    }
                    AppMethodBeat.m2505o(14688);
                    return 0;
                case 3:
                    c30180ee.vFS = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(14688);
                    return 0;
                case 4:
                    c30180ee.vFT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14688);
                    return 0;
                case 5:
                    c30180ee.enabled = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14688);
                    return 0;
                case 6:
                    c30180ee.kKI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14688);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14688);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14688);
            return -1;
        }
    }
}
