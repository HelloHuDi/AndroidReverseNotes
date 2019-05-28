package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xk */
public final class C23465xk extends btd {
    public String fKh;
    public String fKk;
    public String jBB;
    public int ptw;
    public int ptx;
    public int pty;
    public SKBuiltinBuffer_t ptz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135757);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(135757);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(135757);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.fKh != null) {
                    c6093a.mo13475e(2, this.fKh);
                }
                if (this.fKk != null) {
                    c6093a.mo13475e(3, this.fKk);
                }
                if (this.jBB != null) {
                    c6093a.mo13475e(4, this.jBB);
                }
                c6093a.mo13480iz(5, this.ptw);
                c6093a.mo13480iz(6, this.ptx);
                c6093a.mo13480iz(7, this.pty);
                if (this.ptz != null) {
                    c6093a.mo13479iy(8, this.ptz.computeSize());
                    this.ptz.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(135757);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += C6091a.m9575f(2, this.fKh);
            }
            if (this.fKk != null) {
                ix += C6091a.m9575f(3, this.fKk);
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(4, this.jBB);
            }
            ix = ((ix + C6091a.m9572bs(5, this.ptw)) + C6091a.m9572bs(6, this.ptx)) + C6091a.m9572bs(7, this.pty);
            if (this.ptz != null) {
                ix += C6087a.m9557ix(8, this.ptz.computeSize());
            }
            AppMethodBeat.m2505o(135757);
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
                AppMethodBeat.m2505o(135757);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(135757);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(135757);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23465xk c23465xk = (C23465xk) objArr[1];
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
                        c23465xk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(135757);
                    return 0;
                case 2:
                    c23465xk.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135757);
                    return 0;
                case 3:
                    c23465xk.fKk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135757);
                    return 0;
                case 4:
                    c23465xk.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135757);
                    return 0;
                case 5:
                    c23465xk.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135757);
                    return 0;
                case 6:
                    c23465xk.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135757);
                    return 0;
                case 7:
                    c23465xk.pty = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135757);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23465xk.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(135757);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135757);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135757);
            return -1;
        }
    }
}
