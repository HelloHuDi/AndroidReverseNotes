package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aeq */
public final class aeq extends btd {
    public int kdT;
    public String kdU;
    public int wms;
    public String wmt;
    public String wmu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56803);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdT);
            if (this.kdU != null) {
                c6093a.mo13475e(3, this.kdU);
            }
            c6093a.mo13480iz(4, this.wms);
            if (this.wmt != null) {
                c6093a.mo13475e(5, this.wmt);
            }
            if (this.wmu != null) {
                c6093a.mo13475e(6, this.wmu);
            }
            AppMethodBeat.m2505o(56803);
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
            ix += C6091a.m9572bs(4, this.wms);
            if (this.wmt != null) {
                ix += C6091a.m9575f(5, this.wmt);
            }
            if (this.wmu != null) {
                ix += C6091a.m9575f(6, this.wmu);
            }
            AppMethodBeat.m2505o(56803);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56803);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aeq aeq = (aeq) objArr[1];
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
                        aeq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56803);
                    return 0;
                case 2:
                    aeq.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56803);
                    return 0;
                case 3:
                    aeq.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56803);
                    return 0;
                case 4:
                    aeq.wms = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56803);
                    return 0;
                case 5:
                    aeq.wmt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56803);
                    return 0;
                case 6:
                    aeq.wmu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56803);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56803);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56803);
            return -1;
        }
    }
}
