package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.pv */
public final class C46574pv extends btd {
    public String desc;
    public int kCl;
    public String kCm;
    public String pOy;
    public String vWr;
    public int vWs;
    public LinkedList<Integer> vWt = new LinkedList();
    public int vWw;

    public C46574pv() {
        AppMethodBeat.m2504i(48808);
        AppMethodBeat.m2505o(48808);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48809);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48809);
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
            if (this.pOy != null) {
                c6093a.mo13475e(4, this.pOy);
            }
            if (this.vWr != null) {
                c6093a.mo13475e(5, this.vWr);
            }
            c6093a.mo13480iz(6, this.vWs);
            c6093a.mo13474e(7, 2, this.vWt);
            if (this.desc != null) {
                c6093a.mo13475e(8, this.desc);
            }
            c6093a.mo13480iz(9, this.vWw);
            AppMethodBeat.m2505o(48809);
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
            if (this.pOy != null) {
                ix += C6091a.m9575f(4, this.pOy);
            }
            if (this.vWr != null) {
                ix += C6091a.m9575f(5, this.vWr);
            }
            ix = (ix + C6091a.m9572bs(6, this.vWs)) + C6087a.m9552c(7, 2, this.vWt);
            if (this.desc != null) {
                ix += C6091a.m9575f(8, this.desc);
            }
            int bs = ix + C6091a.m9572bs(9, this.vWw);
            AppMethodBeat.m2505o(48809);
            return bs;
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
                AppMethodBeat.m2505o(48809);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48809);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46574pv c46574pv = (C46574pv) objArr[1];
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
                        c46574pv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48809);
                    return 0;
                case 2:
                    c46574pv.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48809);
                    return 0;
                case 3:
                    c46574pv.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48809);
                    return 0;
                case 4:
                    c46574pv.pOy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48809);
                    return 0;
                case 5:
                    c46574pv.vWr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48809);
                    return 0;
                case 6:
                    c46574pv.vWs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48809);
                    return 0;
                case 7:
                    c46574pv.vWt.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(48809);
                    return 0;
                case 8:
                    c46574pv.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48809);
                    return 0;
                case 9:
                    c46574pv.vWw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48809);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48809);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48809);
            return -1;
        }
    }
}
