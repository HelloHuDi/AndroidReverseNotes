package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xm */
public final class C44192xm extends btd {
    public int ptD;
    public long ptF;
    public int ptw;
    public int ptx;
    public SKBuiltinBuffer_t ptz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(50999);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(50999);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(50999);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.ptD);
                c6093a.mo13480iz(3, this.ptw);
                c6093a.mo13480iz(4, this.ptx);
                if (this.ptz != null) {
                    c6093a.mo13479iy(5, this.ptz.computeSize());
                    this.ptz.writeFields(c6093a);
                }
                c6093a.mo13472ai(6, this.ptF);
                AppMethodBeat.m2505o(50999);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6091a.m9572bs(2, this.ptD)) + C6091a.m9572bs(3, this.ptw)) + C6091a.m9572bs(4, this.ptx);
            if (this.ptz != null) {
                ix += C6087a.m9557ix(5, this.ptz.computeSize());
            }
            int o = ix + C6091a.m9578o(6, this.ptF);
            AppMethodBeat.m2505o(50999);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(50999);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(50999);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(50999);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44192xm c44192xm = (C44192xm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        c44192xm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(50999);
                    return 0;
                case 2:
                    c44192xm.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(50999);
                    return 0;
                case 3:
                    c44192xm.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(50999);
                    return 0;
                case 4:
                    c44192xm.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(50999);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44192xm.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(50999);
                    return 0;
                case 6:
                    c44192xm.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(50999);
                    return 0;
                default:
                    AppMethodBeat.m2505o(50999);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(50999);
            return -1;
        }
    }
}
