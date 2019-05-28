package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xo */
public final class C40586xo extends btd {
    public int fJT;
    public int ptD;
    public long ptF;
    public SKBuiltinBuffer_t ptz;
    public String vFF;
    public int vOq;
    public int wdn;
    public int wdp;
    public int wdq;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116803);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116803);
                throw c6092b;
            } else if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(116803);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.ptD);
                c6093a.mo13480iz(2, this.vOq);
                c6093a.mo13480iz(3, this.wdn);
                c6093a.mo13480iz(5, this.wdp);
                if (this.vFF != null) {
                    c6093a.mo13475e(6, this.vFF);
                }
                if (this.ptz != null) {
                    c6093a.mo13479iy(7, this.ptz.computeSize());
                    this.ptz.writeFields(c6093a);
                }
                c6093a.mo13480iz(8, this.fJT);
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(9, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                c6093a.mo13480iz(10, this.wdq);
                c6093a.mo13472ai(11, this.ptF);
                AppMethodBeat.m2505o(116803);
                return 0;
            }
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.ptD) + 0) + C6091a.m9572bs(2, this.vOq)) + C6091a.m9572bs(3, this.wdn)) + C6091a.m9572bs(5, this.wdp);
            if (this.vFF != null) {
                bs += C6091a.m9575f(6, this.vFF);
            }
            if (this.ptz != null) {
                bs += C6087a.m9557ix(7, this.ptz.computeSize());
            }
            bs += C6091a.m9572bs(8, this.fJT);
            if (this.BaseResponse != null) {
                bs += C6087a.m9557ix(9, this.BaseResponse.computeSize());
            }
            bs = (bs + C6091a.m9572bs(10, this.wdq)) + C6091a.m9578o(11, this.ptF);
            AppMethodBeat.m2505o(116803);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116803);
                throw c6092b;
            } else if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(116803);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(116803);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40586xo c40586xo = (C40586xo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c40586xo.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 2:
                    c40586xo.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 3:
                    c40586xo.wdn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 5:
                    c40586xo.wdp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 6:
                    c40586xo.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40586xo.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 8:
                    c40586xo.fJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40586xo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 10:
                    c40586xo.wdq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116803);
                    return 0;
                case 11:
                    c40586xo.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(116803);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116803);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116803);
            return -1;
        }
    }
}
