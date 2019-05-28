package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.caa */
public final class caa extends btd {
    public String wDM;
    public String wYV;
    public String wYW;
    public String wYX;
    public int wZh;
    public int wZi;
    public int wZj;
    public C1332b wZk;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124364);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wYV != null) {
                c6093a.mo13475e(2, this.wYV);
            }
            c6093a.mo13480iz(3, this.wZh);
            c6093a.mo13480iz(4, this.wZi);
            if (this.wYW != null) {
                c6093a.mo13475e(5, this.wYW);
            }
            if (this.wYX != null) {
                c6093a.mo13475e(6, this.wYX);
            }
            c6093a.mo13480iz(7, this.wZj);
            if (this.wDM != null) {
                c6093a.mo13475e(8, this.wDM);
            }
            if (this.wZk != null) {
                c6093a.mo13473c(9, this.wZk);
            }
            AppMethodBeat.m2505o(124364);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wYV != null) {
                ix += C6091a.m9575f(2, this.wYV);
            }
            ix = (ix + C6091a.m9572bs(3, this.wZh)) + C6091a.m9572bs(4, this.wZi);
            if (this.wYW != null) {
                ix += C6091a.m9575f(5, this.wYW);
            }
            if (this.wYX != null) {
                ix += C6091a.m9575f(6, this.wYX);
            }
            ix += C6091a.m9572bs(7, this.wZj);
            if (this.wDM != null) {
                ix += C6091a.m9575f(8, this.wDM);
            }
            if (this.wZk != null) {
                ix += C6091a.m9571b(9, this.wZk);
            }
            AppMethodBeat.m2505o(124364);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124364);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            caa caa = (caa) objArr[1];
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
                        caa.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(124364);
                    return 0;
                case 2:
                    caa.wYV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124364);
                    return 0;
                case 3:
                    caa.wZh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124364);
                    return 0;
                case 4:
                    caa.wZi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124364);
                    return 0;
                case 5:
                    caa.wYW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124364);
                    return 0;
                case 6:
                    caa.wYX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124364);
                    return 0;
                case 7:
                    caa.wZj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124364);
                    return 0;
                case 8:
                    caa.wDM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124364);
                    return 0;
                case 9:
                    caa.wZk = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(124364);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124364);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124364);
            return -1;
        }
    }
}
