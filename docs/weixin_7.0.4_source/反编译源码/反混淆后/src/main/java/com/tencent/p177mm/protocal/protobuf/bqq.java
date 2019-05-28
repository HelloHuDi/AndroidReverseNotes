package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bqq */
public final class bqq extends btd {
    public int kdT;
    public String kdU;
    public String nuL;
    public String pck;
    public int status;
    public String tgu;
    public int wOi;
    public boolean wSW;
    public boolean wSX;
    public String wSY;
    public String wSZ;
    public String wTa;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56955);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56955);
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
            c6093a.mo13471aO(4, this.wSW);
            c6093a.mo13471aO(5, this.wSX);
            c6093a.mo13480iz(6, this.status);
            if (this.wSY != null) {
                c6093a.mo13475e(7, this.wSY);
            }
            if (this.wSZ != null) {
                c6093a.mo13475e(8, this.wSZ);
            }
            c6093a.mo13480iz(9, this.wOi);
            if (this.nuL != null) {
                c6093a.mo13475e(10, this.nuL);
            }
            if (this.pck != null) {
                c6093a.mo13475e(11, this.pck);
            }
            if (this.wTa != null) {
                c6093a.mo13475e(12, this.wTa);
            }
            if (this.tgu != null) {
                c6093a.mo13475e(100, this.tgu);
            }
            AppMethodBeat.m2505o(56955);
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
            ix = ((ix + (C6091a.m9576fv(4) + 1)) + (C6091a.m9576fv(5) + 1)) + C6091a.m9572bs(6, this.status);
            if (this.wSY != null) {
                ix += C6091a.m9575f(7, this.wSY);
            }
            if (this.wSZ != null) {
                ix += C6091a.m9575f(8, this.wSZ);
            }
            ix += C6091a.m9572bs(9, this.wOi);
            if (this.nuL != null) {
                ix += C6091a.m9575f(10, this.nuL);
            }
            if (this.pck != null) {
                ix += C6091a.m9575f(11, this.pck);
            }
            if (this.wTa != null) {
                ix += C6091a.m9575f(12, this.wTa);
            }
            if (this.tgu != null) {
                ix += C6091a.m9575f(100, this.tgu);
            }
            AppMethodBeat.m2505o(56955);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56955);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56955);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bqq bqq = (bqq) objArr[1];
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
                        bqq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 2:
                    bqq.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 3:
                    bqq.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 4:
                    bqq.wSW = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 5:
                    bqq.wSX = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 6:
                    bqq.status = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 7:
                    bqq.wSY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 8:
                    bqq.wSZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 9:
                    bqq.wOi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 10:
                    bqq.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 11:
                    bqq.pck = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 12:
                    bqq.wTa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                case 100:
                    bqq.tgu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56955);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56955);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56955);
            return -1;
        }
    }
}
